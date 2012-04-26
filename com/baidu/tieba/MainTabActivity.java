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
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.home.HomeActivity;
import com.baidu.tieba.home.LikeActivity;
import com.baidu.tieba.home.MarkActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.service.ClearTempService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class MainTabActivity extends TabActivity implements CompoundButton.OnCheckedChangeListener {
    public static final String GOTO_CLOSE = "close";
    public static final String GOTO_CLOSE_LOGIN = "close_login";
    public static final String GOTO_HOME = "goto_home";
    public static final String GOTO_MORE = "goto_more";
    public static final String GOTO_PERSON = "goto_person";
    public static final String GOTO_SORT = "goto_sort";
    private static final String HOME_TAB = "home_tab";
    public static final String KEY_CLOSE_DIALOG = "close_dialog";
    public static final String KEY_REFRESH = "refresh_all";
    private static final String MORE_TAB = "more_tab";
    private static final String PERSON_INFO_TAB = "person_info_tab";
    private static final String SORT_TAB = "sort_tab";
    private Intent mHomeIntent;
    private TabHost mHost;
    private Intent mMoreIntent;
    private Intent mPersonIntent;
    private Intent mSortIntent;
    private long mMsgReplyme = 0;
    private long mMsgAtme = 0;
    private long mMsgFans = 0;
    private TextView mMessageTipsMention = null;
    private TextView mMessageTipsPerson = null;
    private Handler mHandler = null;
    private ProgressDialog mWaitingDialog = null;
    private AlertDialog mGetImportParaDialog = null;
    private ReLoginAsyncTask mTask = null;
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
            intent.putExtra(gotoView, true);
        }
        context.startActivity(intent);
    }

    public static void startActivityRefresh(Context context, String gotoView, boolean new_task) {
        Intent intent = new Intent(context, MainTabActivity.class);
        intent.setFlags(603979776);
        intent.putExtra(KEY_REFRESH, true);
        if (gotoView != null) {
            intent.putExtra(gotoView, true);
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
        TiebaLog.i(getClass().toString(), "onCreate", "debug");
        setContentView(R.layout.maintabs_activity);
        this.mHost = getTabHost();
        this.mHomeIntent = new Intent(this, HomeActivity.class);
        this.mSortIntent = new Intent(this, MentionActivity.class);
        this.mPersonIntent = new Intent(this, PersonInfoActivity.class);
        this.mPersonIntent.putExtra(PersonInfoActivity.TAG_SELF, true);
        this.mPersonIntent.putExtra(PersonInfoActivity.TAG_TAB_PAGE, true);
        this.mPersonIntent.putExtra("un", TiebaApplication.getCurrentAccount());
        this.mMoreIntent = new Intent(this, MoreActivity.class);
        this.mMessageTipsMention = (TextView) findViewById(R.id.message_mention);
        this.mMessageTipsPerson = (TextView) findViewById(R.id.message_person);
        initRadios();
        setupIntent();
        startSyncService();
        regReceiver();
        startService(new Intent("com.baidu.tieba.service.Message"));
        startClearTempService();
    }

    public void getUid() {
        if (TiebaApplication.isBaiduAccountManager()) {
            String user_id = TiebaApplication.getCurrentAccount();
            if (user_id == null || user_id.length() <= 0) {
                BaiduReLogin();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BaiduReLogin() {
        if (this.mTask == null) {
            this.mTask = new ReLoginAsyncTask(this, null);
            this.mTask.execute(new String[0]);
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
        unregReceiver();
        if (TiebaApplication.app != null) {
            TiebaApplication.app.cancelNotification();
        }
        stopService(new Intent("com.baidu.tieba.service.Message"));
        TiebaApplication.app.resetMsg();
        TiebaApplication.app.getSdramImage().clearPicAndPhoto();
        if (this.mTask != null) {
            this.mTask.cancel();
            this.mTask = null;
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.dismiss();
            this.mWaitingDialog = null;
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
            this.mMessageTipsMention.setText(String.valueOf(mention));
            this.mMessageTipsMention.setVisibility(0);
        } else {
            this.mMessageTipsMention.setVisibility(8);
        }
        if (this.mMsgFans > 0) {
            this.mMessageTipsPerson.setText(String.valueOf(this.mMsgFans));
            this.mMessageTipsPerson.setVisibility(0);
            return;
        }
        this.mMessageTipsPerson.setVisibility(8);
    }

    private void initRadios() {
        ((RadioButton) findViewById(R.id.radio_home)).setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_sort)).setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_person_info)).setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_more)).setOnCheckedChangeListener(this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            getUid();
            switch (buttonView.getId()) {
                case R.id.radio_home /* 2131361931 */:
                    this.mHost.setCurrentTabByTag(HOME_TAB);
                    return;
                case R.id.radio_sort /* 2131361932 */:
                    this.mHost.setCurrentTabByTag(SORT_TAB);
                    return;
                case R.id.radio_person_info /* 2131361933 */:
                    this.mHost.setCurrentTabByTag(PERSON_INFO_TAB);
                    return;
                case R.id.radio_more /* 2131361934 */:
                    this.mHost.setCurrentTabByTag(MORE_TAB);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        dealBaiduAccount();
    }

    private void dealBaiduAccount() {
        if (TiebaApplication.isBaiduAccountManager()) {
            TiebaLog.d(getClass().getName(), "onResume", "bduss = " + TiebaApplication.getCurrentBduss());
            TiebaLog.d(getClass().getName(), "onResume", "uid = " + TiebaApplication.getCurrentAccount());
            if (TiebaApplication.getCurrentBduss() == null) {
                BaiduAccountProxy.getAccountData(this);
            } else if (TiebaApplication.getCurrentAccount() == null) {
                getUid();
            }
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        TiebaLog.i(getClass().getName(), "onNewIntent", "");
        super.onNewIntent(intent);
        boolean goto_home = intent.getBooleanExtra(GOTO_HOME, false);
        if (goto_home) {
            LocalActivityManager manager = getLocalActivityManager();
            HomeActivity home = (HomeActivity) manager.getActivity(HOME_TAB);
            if (home != null) {
                Activity activity = home.getCurrentActivity();
                if (activity instanceof LikeActivity) {
                    ((LikeActivity) activity).closeSearch();
                }
            }
            this.mHost.setCurrentTabByTag(HOME_TAB);
            ((RadioButton) findViewById(R.id.radio_home)).setChecked(true);
        }
        boolean goto_sort = intent.getBooleanExtra(GOTO_SORT, false);
        if (goto_sort) {
            this.mHost.setCurrentTabByTag(SORT_TAB);
            ((RadioButton) findViewById(R.id.radio_sort)).setChecked(true);
        }
        boolean goto_person = intent.getBooleanExtra(GOTO_PERSON, false);
        if (goto_person) {
            this.mHost.setCurrentTabByTag(PERSON_INFO_TAB);
            ((RadioButton) findViewById(R.id.radio_person_info)).setChecked(true);
        }
        boolean goto_more = intent.getBooleanExtra(GOTO_MORE, false);
        if (goto_more) {
            this.mHost.setCurrentTabByTag(MORE_TAB);
            ((RadioButton) findViewById(R.id.radio_more)).setChecked(true);
        }
        boolean goto_close = intent.getBooleanExtra(GOTO_CLOSE, false);
        if (goto_close) {
            finish();
        }
        boolean goto_close_login = intent.getBooleanExtra(GOTO_CLOSE_LOGIN, false);
        if (goto_close_login) {
            if (TiebaApplication.getCurrentAccountObj() != null) {
                LoginActivity.startActivityWithAccount(this, TiebaApplication.getCurrentAccountObj().getAccount());
            } else {
                LoginActivity.startActivity(this);
            }
            finish();
        }
        boolean isCloseDialog = intent.getBooleanExtra(KEY_CLOSE_DIALOG, false);
        if (isCloseDialog) {
            closeAllDialog();
        }
        boolean isRefresh = intent.getBooleanExtra(KEY_REFRESH, false);
        if (isRefresh) {
            this.mPersonIntent.putExtra("un", TiebaApplication.getCurrentAccount());
            this.mHost.setCurrentTab(0);
            this.mHost.clearAllTabs();
            LocalActivityManager manager2 = getLocalActivityManager();
            manager2.removeAllActivities();
            setupIntent();
        }
    }

    private void closeAllDialog() {
        HomeActivity home;
        LocalActivityManager manager = getLocalActivityManager();
        String currentTab = manager.getCurrentId();
        if (!currentTab.equals(HOME_TAB) && (home = (HomeActivity) manager.getActivity(HOME_TAB)) != null) {
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
        setupIntent();
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

    private void setupIntent() {
        ((RadioButton) findViewById(R.id.radio_home)).setChecked(true);
        TabHost localTabHost = this.mHost;
        localTabHost.addTab(buildTabSpec(HOME_TAB, this.mHomeIntent));
        localTabHost.addTab(buildTabSpec(SORT_TAB, this.mSortIntent));
        localTabHost.addTab(buildTabSpec(PERSON_INFO_TAB, this.mPersonIntent));
        localTabHost.addTab(buildTabSpec(MORE_TAB, this.mMoreIntent));
        localTabHost.setCurrentTabByTag(HOME_TAB);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ReLoginAsyncTask extends AsyncTask<String, Integer, AccountData> {
        private volatile NetWork mNetwork;

        private ReLoginAsyncTask() {
            this.mNetwork = null;
        }

        /* synthetic */ ReLoginAsyncTask(MainTabActivity mainTabActivity, ReLoginAsyncTask reLoginAsyncTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public AccountData doInBackground(String... arg0) {
            this.mNetwork = new NetWork();
            AccountData account = TiebaApplication.getCurrentAccountObj();
            if (account != null) {
                return BaiduAccountProxy.getAccountDataByToken(this.mNetwork, account.getAccount(), account.getBDUSS());
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(AccountData result) {
            super.onPostExecute((ReLoginAsyncTask) result);
            MainTabActivity.this.mTask = null;
            if (MainTabActivity.this.mWaitingDialog != null) {
                MainTabActivity.this.mWaitingDialog.dismiss();
                MainTabActivity.this.mWaitingDialog = null;
            }
            if (result != null) {
                AccountData data = TiebaApplication.getCurrentAccountObj();
                if (data == null) {
                    TiebaApplication.setCurrentAccount(data);
                } else {
                    data.setID(result.getID());
                    data.setTbs(result.getTbs());
                }
                DatabaseService.saveAccountData(TiebaApplication.getCurrentAccountObj());
                Handler handler = TiebaApplication.app.handler;
                if (TiebaApplication.app.getMsgFrequency() != 0) {
                    handler.sendMessage(handler.obtainMessage(2));
                } else {
                    handler.sendMessage(handler.obtainMessage(3));
                }
                MainTabActivity.this.refreshAllUI();
                return;
            }
            String error = null;
            if (this.mNetwork != null) {
                error = this.mNetwork.getErrorString();
            }
            if (error == null) {
                error = MainTabActivity.this.getString(R.string.data_load_error);
            }
            if (MainTabActivity.this.mGetImportParaDialog != null) {
                MainTabActivity.this.mGetImportParaDialog.setMessage(error);
            } else {
                MainTabActivity.this.mGetImportParaDialog = new AlertDialog.Builder(MainTabActivity.this).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(error).setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.MainTabActivity.ReLoginAsyncTask.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        MainTabActivity.this.BaiduReLogin();
                    }
                }).setNegativeButton(R.string.quit, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.MainTabActivity.ReLoginAsyncTask.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        MainTabActivity.this.finish();
                    }
                }).create();
            }
            MainTabActivity.this.mGetImportParaDialog.show();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            if (MainTabActivity.this.mGetImportParaDialog != null && MainTabActivity.this.mGetImportParaDialog.isShowing()) {
                MainTabActivity.this.mGetImportParaDialog.dismiss();
            }
            MainTabActivity.this.mWaitingDialog = ProgressDialog.show(MainTabActivity.this, null, MainTabActivity.this.getString(R.string.data_loading), true, false);
            super.onPreExecute();
        }

        public boolean cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            MainTabActivity.this.mTask = null;
            if (MainTabActivity.this.mWaitingDialog != null) {
                MainTabActivity.this.mWaitingDialog.dismiss();
                MainTabActivity.this.mWaitingDialog = null;
            }
            return super.cancel(true);
        }
    }
}
