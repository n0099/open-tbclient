package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.app.ProgressDialog;
import android.app.TabActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.baidu.tieba.account.AccountShareHelper;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.home.HomeActivity;
import com.baidu.tieba.home.LikeActivity;
import com.baidu.tieba.home.MarkActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.recommend.RecommendActivity;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.TiebaActiveService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import java.util.Date;
/* loaded from: classes.dex */
public class MainTabActivity extends TabActivity implements CompoundButton.OnCheckedChangeListener {
    public static final String CURRENT_TAB = "home_tab";
    public static final String GOTO_CLOSE = "close";
    public static final String GOTO_HOME = "goto_home";
    public static final String GOTO_MORE = "goto_more";
    public static final String GOTO_PERSON = "goto_person";
    public static final String GOTO_RECOMMEND = "goto_recommend";
    public static final String GOTO_SORT = "goto_sort";
    public static final String GOTO_TYPE = "goto_type";
    public static final String HOME_TAB = "home_tab";
    public static final String KEY_CLOSE_DIALOG = "close_dialog";
    public static final String KEY_REFRESH = "refresh_all";
    public static final String MORE_TAB = "more_tab";
    public static final String PB_ID = "pb_id";
    public static final String PERSON_INFO_TAB = "person_info_tab";
    public static final String RECOMMEND_TAB = "recommend_tab";
    public static final String SORT_TAB = "sort_tab";
    private Intent mHomeIntent;
    private TabHost mHost;
    private Intent mMoreIntent;
    private Intent mPersonIntent;
    private Intent mReCommendIntent;
    private Intent mSortIntent;
    private String mTabType = null;
    private long mMsgReplyme = 0;
    private long mMsgAtme = 0;
    private long mMsgFans = 0;
    private TextView mMessageTipsMention = null;
    private TextView mMessageTipsPerson = null;
    private CompoundButton mOldButton = null;
    private CompoundButton mCurrentButton = null;
    private Handler mHandler = null;
    private ProgressDialog mWaitingDialog = null;
    private RadioButton mHomeButton = null;
    private RadioButton mRecommendButton = null;
    private RadioButton mSortButton = null;
    private RadioButton mPersonButton = null;
    private RadioButton mMoreButton = null;
    private AlertDialog mWifiAffirmDialog = null;
    private AlertDialog mNotWifiAffirmDialog = null;
    private UpdateReceiver receiver = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class UpdateReceiver extends BroadcastReceiver {
        private UpdateReceiver() {
        }

        /* synthetic */ UpdateReceiver(MainTabActivity mainTabActivity, UpdateReceiver updateReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MainTabActivity.this.mMsgReplyme = intent.getLongExtra(Config.BROADCAST_RELAY_ME_NUM, 0L);
            MainTabActivity.this.mMsgAtme = intent.getLongExtra(Config.BROADCAST_AT_ME_NUM, 0L);
            MainTabActivity.this.mMsgFans = intent.getLongExtra(Config.BROADCAST_FANS_NUM, 0L);
            MainTabActivity.this.refreshMsg();
        }
    }

    public static void startActivity(Context context, String gotoView) {
        Intent intent = new Intent(context, MainTabActivity.class);
        intent.setFlags(603979776);
        if (gotoView != null) {
            intent.putExtra(GOTO_TYPE, gotoView);
        }
        intent.putExtra(KEY_CLOSE_DIALOG, true);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, String gotoView, String pbId) {
        Intent intent = new Intent(context, MainTabActivity.class);
        intent.setFlags(603979776);
        if (gotoView != null) {
            intent.putExtra(GOTO_TYPE, gotoView);
        }
        intent.putExtra(PB_ID, pbId);
        intent.putExtra(KEY_CLOSE_DIALOG, true);
        context.startActivity(intent);
    }

    public static void startActivityRefresh(Context context, String gotoView, boolean new_task) {
        Intent intent = new Intent(context, MainTabActivity.class);
        intent.setFlags(603979776);
        intent.putExtra(KEY_REFRESH, true);
        if (gotoView != null) {
            intent.putExtra(GOTO_TYPE, gotoView);
        }
        if (new_task) {
            intent.addFlags(268435456);
        }
        intent.putExtra(KEY_CLOSE_DIALOG, true);
        context.startActivity(intent);
    }

    public static void startActivityOnUserChanged(Context context, String gotoView) {
        TiebaApplication.app.onUserChanged();
        startActivityRefresh(context, gotoView, false);
    }

    public static void startActivityOnUserChanged(Context context, String gotoView, boolean new_task) {
        TiebaApplication.app.onUserChanged();
        startActivityRefresh(context, gotoView, new_task);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dealPbMessagePush(savedInstanceState);
        TiebaLog.i(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        this.mHost = getTabHost();
        this.mHomeIntent = new Intent(this, HomeActivity.class);
        this.mReCommendIntent = new Intent(this, RecommendActivity.class);
        this.mSortIntent = new Intent(this, MentionActivity.class);
        this.mPersonIntent = new Intent(this, PersonInfoActivity.class);
        this.mPersonIntent.putExtra(PersonInfoActivity.TAG_SELF, true);
        this.mPersonIntent.putExtra(PersonInfoActivity.TAG_TAB_PAGE, true);
        this.mPersonIntent.putExtra("un", TiebaApplication.getCurrentAccount());
        this.mMoreIntent = new Intent(this, MoreActivity.class);
        this.mMessageTipsMention = (TextView) findViewById(R.id.message_mention);
        this.mMessageTipsPerson = (TextView) findViewById(R.id.message_person);
        initRadios();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (savedInstanceState != null) {
            String type = savedInstanceState.getString(GOTO_TYPE);
            intent.putExtra(GOTO_TYPE, type);
        }
        setupIntent(intent);
        startSyncService();
        if (TiebaApplication.getFrom() != null && TiebaApplication.getFrom().equals("aishide")) {
            startActiveService();
        }
        regReceiver();
        startClearTempService();
        TiebaApplication.app.startMsgReceive();
        if (savedInstanceState == null) {
            checkNetwork();
        }
    }

    private void dealPbMessagePush(Bundle savedInstanceState) {
        String pb_id;
        if (savedInstanceState != null) {
            pb_id = savedInstanceState.getString(PB_ID);
        } else {
            pb_id = getIntent().getStringExtra(PB_ID);
        }
        if (pb_id != null && pb_id.length() > 0) {
            PbActivity.startAcitivityBackSpecial(this, pb_id);
        }
    }

    private void startClearTempService() {
        Intent service = new Intent(this, ClearTempService.class);
        startService(service);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onDestroy() {
        TiebaLog.i(getClass().getName(), "onDestroy", "");
        stopSyncService();
        stopActiveServide();
        unregReceiver();
        if (TiebaApplication.app != null) {
            TiebaApplication.app.cancelNotification();
        }
        TiebaApplication.app.stopMsgReceive();
        TiebaApplication.app.resetMsg();
        TiebaApplication.app.getSdramImage().clearPicAndPhoto();
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.dismiss();
            this.mWaitingDialog = null;
        }
        if (this.mWifiAffirmDialog != null) {
            this.mWifiAffirmDialog.dismiss();
            this.mWifiAffirmDialog = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
        super.onDestroy();
        System.gc();
    }

    private void startSyncService() {
        Intent service = new Intent(this, TiebaSyncService.class);
        startService(service);
    }

    private void stopSyncService() {
        Intent service = new Intent(this, TiebaSyncService.class);
        stopService(service);
    }

    private void startActiveService() {
        Intent service = new Intent(this, TiebaActiveService.class);
        startService(service);
    }

    private void stopActiveServide() {
        Intent service = new Intent(this, TiebaActiveService.class);
        stopService(service);
    }

    private void regReceiver() {
        this.receiver = new UpdateReceiver(this, null);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Config.BROADCAST_NOTIFY);
        registerReceiver(this.receiver, filter);
    }

    private void unregReceiver() {
        if (this.receiver != null) {
            unregisterReceiver(this.receiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshMsg() {
        long mention = this.mMsgReplyme + this.mMsgAtme;
        if (mention > 0) {
            int left = this.mPersonButton.getLeft();
            int left2 = (this.mSortButton.getLeft() + left) / 2;
            FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) this.mMessageTipsMention.getLayoutParams();
            param.leftMargin = left2;
            this.mMessageTipsMention.setLayoutParams(param);
            this.mMessageTipsMention.setText(String.valueOf(mention));
            this.mMessageTipsMention.setVisibility(0);
        } else {
            this.mMessageTipsMention.setVisibility(8);
        }
        if (this.mMsgFans > 0) {
            int left3 = this.mMoreButton.getLeft();
            int left4 = (this.mPersonButton.getLeft() + left3) / 2;
            FrameLayout.LayoutParams param2 = (FrameLayout.LayoutParams) this.mMessageTipsPerson.getLayoutParams();
            param2.leftMargin = left4;
            this.mMessageTipsPerson.setLayoutParams(param2);
            this.mMessageTipsPerson.setText(String.valueOf(this.mMsgFans));
            this.mMessageTipsPerson.setVisibility(0);
            return;
        }
        this.mMessageTipsPerson.setVisibility(8);
    }

    private void initRadios() {
        this.mHomeButton = (RadioButton) findViewById(R.id.radio_home);
        this.mRecommendButton = (RadioButton) findViewById(R.id.radio_recommend);
        this.mSortButton = (RadioButton) findViewById(R.id.radio_sort);
        this.mPersonButton = (RadioButton) findViewById(R.id.radio_person_info);
        this.mMoreButton = (RadioButton) findViewById(R.id.radio_more);
        this.mHomeButton.setOnCheckedChangeListener(this);
        this.mRecommendButton.setOnCheckedChangeListener(this);
        this.mSortButton.setOnCheckedChangeListener(this);
        this.mPersonButton.setOnCheckedChangeListener(this);
        this.mMoreButton.setOnCheckedChangeListener(this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            this.mOldButton = null;
            buttonView.setTextColor(getResources().getColor(R.color.main_button_hightlight_color));
            String id = TiebaApplication.getCurrentAccount();
            CompoundButton tmp = this.mCurrentButton;
            this.mCurrentButton = buttonView;
            buttonView.setTextColor(-13588993);
            if (id == null || id.length() <= 0) {
                switch (buttonView.getId()) {
                    case R.id.radio_home /* 2131230930 */:
                        this.mOldButton = tmp;
                        LoginActivity.startActivity(this, GOTO_HOME, getString(R.string.login_home_tab), (int) RequestResponseCode.REQUEST_LOGIN_USE);
                        return;
                    case R.id.radio_sort /* 2131230932 */:
                        this.mOldButton = tmp;
                        LoginActivity.startActivity(this, GOTO_SORT, getString(R.string.login_msg_tab), (int) RequestResponseCode.REQUEST_LOGIN_USE);
                        return;
                    case R.id.radio_person_info /* 2131230933 */:
                        this.mOldButton = tmp;
                        LoginActivity.startActivity(this, GOTO_PERSON, getString(R.string.login_person_tab), (int) RequestResponseCode.REQUEST_LOGIN_USE);
                        return;
                }
            }
            switch (buttonView.getId()) {
                case R.id.radio_home /* 2131230930 */:
                    this.mHost.setCurrentTabByTag("home_tab");
                    return;
                case R.id.radio_recommend /* 2131230931 */:
                    this.mHost.setCurrentTabByTag(RECOMMEND_TAB);
                    return;
                case R.id.radio_sort /* 2131230932 */:
                    this.mHost.setCurrentTabByTag(SORT_TAB);
                    return;
                case R.id.radio_person_info /* 2131230933 */:
                    this.mPersonIntent.putExtra("un", TiebaApplication.getCurrentAccount());
                    this.mHost.setCurrentTabByTag(PERSON_INFO_TAB);
                    return;
                case R.id.radio_more /* 2131230934 */:
                    this.mHost.setCurrentTabByTag(MORE_TAB);
                    return;
                default:
                    return;
            }
        }
        buttonView.setTextColor(getResources().getColor(R.color.main_button_color));
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        TiebaApplication.app.AddResumeNum();
        String id = TiebaApplication.getCurrentAccount();
        if (TiebaApplication.isBaiduAccountManager()) {
            if (id == null || id.length() <= 0) {
                if (this.mCurrentButton != null && (this.mCurrentButton == this.mRecommendButton || this.mCurrentButton == this.mMoreButton)) {
                    this.mCurrentButton.setChecked(true);
                    return;
                } else {
                    this.mRecommendButton.setChecked(true);
                    return;
                }
            }
            return;
        }
        if ((id == null || id.length() <= 0) && this.mOldButton != null) {
            if (this.mOldButton == this.mRecommendButton || this.mOldButton == this.mMoreButton) {
                this.mOldButton.setChecked(true);
            } else {
                this.mRecommendButton.setChecked(true);
            }
        }
        AccountShareHelper.getInstance().relogin(this);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onPause() {
        super.onPause();
        TiebaApplication.app.DelResumeNum();
    }

    @Override // android.app.TabActivity, android.app.ActivityGroup, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(GOTO_TYPE, this.mTabType);
        outState.putString(PB_ID, "");
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        TiebaLog.i(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        boolean isCloseDialog = intent.getBooleanExtra(KEY_CLOSE_DIALOG, false);
        if (isCloseDialog) {
            closeAllDialog();
        }
        boolean isRefresh = intent.getBooleanExtra(KEY_REFRESH, false);
        if (isRefresh) {
            this.mPersonIntent.putExtra("un", TiebaApplication.getCurrentAccount());
            this.mHost.setCurrentTab(0);
            this.mHost.clearAllTabs();
            LocalActivityManager manager = getLocalActivityManager();
            manager.removeAllActivities();
            setupIntent(intent);
        }
        String type = intent.getStringExtra(GOTO_TYPE);
        this.mTabType = type;
        if (GOTO_RECOMMEND.equals(type)) {
            this.mRecommendButton.setChecked(true);
        } else if (GOTO_SORT.equals(type)) {
            this.mSortButton.setChecked(true);
        } else if (GOTO_PERSON.equals(type)) {
            this.mPersonButton.setChecked(true);
        } else if (GOTO_MORE.equals(type)) {
            this.mMoreButton.setChecked(true);
        } else if (GOTO_HOME.equals(type)) {
            this.mHomeButton.setChecked(true);
        } else if ("close".equals(type)) {
            finish();
        }
    }

    private void closeAllDialog() {
        HomeActivity home;
        LocalActivityManager manager = getLocalActivityManager();
        String currentTab = manager.getCurrentId();
        if (!currentTab.equals("home_tab") && (home = (HomeActivity) manager.getActivity("home_tab")) != null) {
            Activity activity = home.getCurrentActivity();
            if (activity instanceof LikeActivity) {
                ((LikeActivity) activity).closeDialog();
            }
            if (activity instanceof MarkActivity) {
                ((MarkActivity) activity).closeDialog();
            }
        }
        MentionActivity mention = (MentionActivity) manager.getActivity(SORT_TAB);
        if (mention != null) {
            mention.closeMenuDialog();
        }
        MoreActivity more = (MoreActivity) manager.getActivity(MORE_TAB);
        if (more != null) {
            more.closeMenuDialog();
        }
    }

    public void refreshAllUI() {
        closeAllDialog();
        this.mPersonIntent.putExtra("un", TiebaApplication.getCurrentAccount());
        this.mHost.setCurrentTab(0);
        this.mHost.clearAllTabs();
        LocalActivityManager manager = getLocalActivityManager();
        manager.removeAllActivities();
        Intent intent = new Intent();
        setupIntent(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == 0 && event.getKeyCode() == 4) {
            TiebaLog.d(getClass().getName(), "dispatchKeyEvent", "KEYCODE_BACK");
            UtilHelper.quitDialog(this);
            return false;
        }
        return super.dispatchKeyEvent(event);
    }

    private void setupIntent(Intent intent) {
        int index;
        TabHost localTabHost = this.mHost;
        String type = intent.getStringExtra(GOTO_TYPE);
        String id = TiebaApplication.getCurrentAccount();
        if ((id == null || id.length() <= 0) && !GOTO_RECOMMEND.equals(type) && !GOTO_MORE.equals(type)) {
            type = GOTO_RECOMMEND;
        }
        if (GOTO_RECOMMEND.equals(type)) {
            index = 1;
            localTabHost.addTab(buildTabSpec(RECOMMEND_TAB, this.mReCommendIntent));
            this.mCurrentButton = this.mRecommendButton;
        } else if (GOTO_SORT.equals(type)) {
            index = 2;
            localTabHost.addTab(buildTabSpec(SORT_TAB, this.mSortIntent));
            this.mCurrentButton = this.mSortButton;
        } else if (GOTO_PERSON.equals(type)) {
            index = 3;
            localTabHost.addTab(buildTabSpec(PERSON_INFO_TAB, this.mPersonIntent));
            this.mCurrentButton = this.mPersonButton;
        } else if (GOTO_MORE.equals(type)) {
            index = 4;
            localTabHost.addTab(buildTabSpec(MORE_TAB, this.mMoreIntent));
            this.mCurrentButton = this.mMoreButton;
        } else {
            index = 0;
            localTabHost.addTab(buildTabSpec("home_tab", this.mHomeIntent));
            this.mCurrentButton = this.mHomeButton;
        }
        if (index != 0) {
            localTabHost.addTab(buildTabSpec("home_tab", this.mHomeIntent));
        }
        if (index != 1) {
            localTabHost.addTab(buildTabSpec(RECOMMEND_TAB, this.mReCommendIntent));
        }
        if (index != 2) {
            localTabHost.addTab(buildTabSpec(SORT_TAB, this.mSortIntent));
        }
        if (index != 3) {
            localTabHost.addTab(buildTabSpec(PERSON_INFO_TAB, this.mPersonIntent));
        }
        if (index != 4) {
            localTabHost.addTab(buildTabSpec(MORE_TAB, this.mMoreIntent));
        }
        this.mCurrentButton.setChecked(true);
        TabWidget tabs = localTabHost.getTabWidget();
        if (tabs != null) {
            int num = tabs.getChildCount();
            for (int i = 0; i < num; i++) {
                tabs.getChildAt(i).setFocusable(false);
            }
        }
    }

    private TabHost.TabSpec buildTabSpec(String tag, Intent content) {
        TabHost.TabSpec tab = this.mHost.newTabSpec(tag);
        tab.setContent(content).setIndicator("", getResources().getDrawable(R.drawable.icon));
        return tab;
    }

    private void checkNetwork() {
        NetWorkCore.NetworkState state;
        Date date = new Date();
        if (date.getTime() - TiebaApplication.app.getCheckNetworkNotify() > Config.CHECK_NETWORK_NOTIFY_TIME && (state = NetWorkCore.getNetworkState(this)) != NetWorkCore.NetworkState.UNAVAIL) {
            if (state == NetWorkCore.NetworkState.WIFI) {
                if ((TiebaApplication.app.isShowImages() && TiebaApplication.app.getViewImageQuality() != 1) || TiebaApplication.app.getUploadImageQuality() != 1) {
                    if (this.mWifiAffirmDialog == null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle(R.string.network_title);
                        builder.setMessage(R.string.network_wifi);
                        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.MainTabActivity.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface arg0, int which) {
                                if (which != -2) {
                                    MainTabActivity.this.mWifiAffirmDialog.dismiss();
                                    TiebaApplication.app.setCheckNetworkNotify();
                                    return;
                                }
                                if (TiebaApplication.app.isShowImages()) {
                                    TiebaApplication.app.setViewImageQuality(1);
                                }
                                TiebaApplication.app.setUploadImageQuality(1);
                            }
                        };
                        builder.setPositiveButton(getString(R.string.cancel), listener);
                        builder.setNegativeButton(getString(R.string.network_accept), listener);
                        this.mWifiAffirmDialog = builder.create();
                    }
                    this.mWifiAffirmDialog.setCancelable(false);
                    this.mWifiAffirmDialog.setCanceledOnTouchOutside(false);
                    this.mWifiAffirmDialog.show();
                }
            } else if ((TiebaApplication.app.isShowImages() && TiebaApplication.app.getViewImageQuality() != 2) || TiebaApplication.app.getUploadImageQuality() == 1) {
                if (this.mNotWifiAffirmDialog == null) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                    builder2.setTitle(R.string.network_title);
                    builder2.setMessage(R.string.network_not_wifi);
                    DialogInterface.OnClickListener listener2 = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.MainTabActivity.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int which) {
                            if (which != -2) {
                                MainTabActivity.this.mNotWifiAffirmDialog.dismiss();
                                TiebaApplication.app.setCheckNetworkNotify();
                                return;
                            }
                            if (TiebaApplication.app.isShowImages()) {
                                TiebaApplication.app.setViewImageQuality(2);
                            }
                            if (TiebaApplication.app.getUploadImageQuality() == 1) {
                                TiebaApplication.app.setUploadImageQuality(2);
                            }
                        }
                    };
                    builder2.setPositiveButton(getString(R.string.cancel), listener2);
                    builder2.setNegativeButton(getString(R.string.network_accept), listener2);
                    this.mNotWifiAffirmDialog = builder2.create();
                }
                this.mNotWifiAffirmDialog.setCancelable(false);
                this.mNotWifiAffirmDialog.setCanceledOnTouchOutside(false);
                this.mNotWifiAffirmDialog.show();
            }
        }
    }
}
