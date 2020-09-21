package com.baidu.tieba.ala.liveroom.master;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.c;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaMasterLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.live.tbadk.core.util.PermissionUtil;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveRoomResponsedMessage;
import com.baidu.tieba.ala.liveroom.q.d;
import com.baidu.webkit.sdk.PermissionRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaMasterLiveRoomActivity extends BaseActivity<AlaMasterLiveRoomActivity> {
    private int availableHeight;
    private boolean bkL;
    private com.baidu.tieba.ala.liveroom.master.a gFi;
    private d gFj;
    private Bundle gFm;
    private b gFs;
    private com.baidu.tieba.ala.liveroom.i.b gFt;
    private PermissionJudgePolicy gFu;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private String gnC;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private boolean mIsKeyboardOpen = false;
    private a gFk = null;
    private volatile boolean isBackground = false;
    private boolean gFl = false;
    private boolean gFn = false;
    private boolean gFo = false;
    private int gFp = -1;
    private CustomMessageListener gFq = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && AlaMasterLiveRoomActivity.this.gFi != null) {
                AlaMasterLiveRoomActivity.this.gFi.f((short) 1);
            }
        }
    };
    private CustomMessageListener buw = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomActivity.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
            }
        }
    };
    private CustomMessageListener gFr = new CustomMessageListener(2913169, true) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                AlaMasterLiveRoomActivity.this.gFo = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private CustomMessageListener gnN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType;
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && (netType = BdNetTypeUtil.netType()) != AlaMasterLiveRoomActivity.this.gFp) {
                AlaMasterLiveRoomActivity.this.gFp = netType;
                NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                if (netWorkChangedMessage.mLastNetState != netType || !BdNetTypeUtil.isWifiNet() || netWorkChangedMessage.mlastChangedTime != 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaMasterLiveRoomActivity.this.bUQ();
                        return;
                    }
                    if (BdNetTypeUtil.isMobileNet() && l.PN()) {
                        AlaMasterLiveRoomActivity.this.bUP();
                    } else if (BdNetTypeUtil.isWifiNet()) {
                        AlaMasterLiveRoomActivity.this.bUR();
                    }
                    if (AlaMasterLiveRoomActivity.this.gFi != null) {
                        AlaMasterLiveRoomActivity.this.gFi.bVd();
                    }
                }
            }
        }
    };
    private CustomMessageListener gFv = new CustomMessageListener(2913178) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomActivity.this.gnC = null;
        }
    };

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gFi != null) {
            this.gFi.dD(UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.isBackground = false;
        setIsAddSwipeBackLayout(false);
        getWindow().setSoftInputMode(32);
        super.onCreate(bundle);
        this.bkL = true;
        if (!isFinishing()) {
            this.gFm = bundle;
            if (!bUJ()) {
                init();
            }
        }
    }

    private boolean bUJ() {
        Activity pageActivity = getPageContext().getPageActivity();
        this.gFu = new PermissionJudgePolicy();
        this.gFu.setDialogClickListener(new PermissionJudgePolicy.PermissionDialogClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.4
            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogCaneled(String str) {
                AlaMasterLiveRoomActivity.this.gFl = true;
                AlaMasterLiveRoomActivity.this.finish();
            }

            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogComfirmed(String str) {
                AlaMasterLiveRoomActivity.this.gFl = true;
                AlaMasterLiveRoomActivity.this.finish();
            }
        });
        this.gFu.clearRequestPermissionList();
        this.gFu.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        this.gFu.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        this.gFu.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.gFu.startRequestPermission(pageActivity);
    }

    private void init() {
        this.gFl = true;
        setUseStyleImmersiveSticky(true);
        getWindow().addFlags(128);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        registerListener(this.gFq);
        initData(this.gFm);
    }

    private void initData(Bundle bundle) {
        AlaLivePersonData alaLivePersonData;
        if (!UtilHelper.isARM()) {
            bUK();
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_forum_name");
            String stringExtra2 = intent.getStringExtra("live_forum_id");
            this.gFn = intent.getBooleanExtra("stop_im_when_close", false);
            int intExtra = intent.getIntExtra("create_master_live_type", 1);
            String stringExtra3 = intent.getStringExtra("special_forum_type");
            String stringExtra4 = intent.getStringExtra("live_info_core");
            if (TextUtils.isEmpty(stringExtra4)) {
                alaLivePersonData = null;
            } else {
                alaLivePersonData = new AlaLivePersonData();
                try {
                    alaLivePersonData.parseJson(new JSONObject(stringExtra4));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            String stringExtra5 = intent.getStringExtra(AlaMasterLiveRoomActivityConfig.LIVE_START_PARAMS);
            if (!TextUtils.isEmpty(stringExtra5)) {
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra5);
                    AlaLiveSwitchData.liveActivityType = jSONObject.getString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                    String optString = jSONObject.optString("extra");
                    if (TextUtils.isEmpty(optString)) {
                        this.gnC = null;
                    } else {
                        this.gnC = new JSONObject(optString).optString("live_back_scheme");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.gnC = null;
                    AlaLiveSwitchData.liveActivityType = "";
                }
            }
            bUM();
            MessageManager.getInstance().registerListener(this.gnN);
            MessageManager.getInstance().registerListener(this.gFv);
            MessageManager.getInstance().registerListener(this.buw);
            MessageManager.getInstance().registerListener(this.gFr);
            this.gFj = new d(getPageContext());
            if (intExtra == 2) {
                if (!checkPermission()) {
                    if (alaLivePersonData != null) {
                        this.gFj.h(Long.toString(alaLivePersonData.mLiveInfo.live_id), false, false);
                    }
                    if (this.gFi != null) {
                        this.gFi.f((short) 1);
                        return;
                    } else {
                        finish();
                        return;
                    }
                }
                e(alaLivePersonData);
                return;
            } else if (!checkPermission()) {
                if (this.gFi != null) {
                    this.gFi.f((short) 1);
                    return;
                } else {
                    finish();
                    return;
                }
            } else {
                a(bundle, stringExtra, stringExtra2, stringExtra3);
                return;
            }
        }
        showToast(getResources().getString(a.i.ala_entry_live_failed));
        if (this.gFi != null) {
            this.gFi.f((short) 1);
        }
    }

    private void bUK() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(getPageContext().getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.live_not_support_msg);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (AlaMasterLiveRoomActivity.this.gFi != null) {
                    AlaMasterLiveRoomActivity.this.gFi.f((short) 1);
                }
            }
        });
        bdAlertDialog.create(getPageContext()).show();
    }

    private void e(AlaLivePersonData alaLivePersonData) {
        if (alaLivePersonData == null) {
            if (this.gFi != null) {
                this.gFi.f((short) 1);
                return;
            }
            return;
        }
        this.gFj.h(alaLivePersonData);
        this.gFi = new com.baidu.tieba.ala.liveroom.master.a(this);
        this.gFi.a(this.gFj);
        this.gFi.f(alaLivePersonData);
        this.gFj.h(Long.toString(alaLivePersonData.mLiveInfo.live_id), false, true);
    }

    private void a(Bundle bundle, String str, String str2, String str3) {
        if (bundle != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913020));
        }
        this.gFi = new com.baidu.tieba.ala.liveroom.master.a(this);
        this.gFi.a(this.gFj);
        this.gFi.a(str, str2, str3, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void addGlobalLayoutListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (AlaMasterLiveRoomActivity.this.gFo) {
                    Rect rect = new Rect();
                    AlaMasterLiveRoomActivity.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaMasterLiveRoomActivity.this.getPageContext().getPageActivity());
                    int[] screenFullSize = ViewCommonUtil.getScreenFullSize(AlaMasterLiveRoomActivity.this.getPageContext().getPageActivity());
                    boolean z = AlaMasterLiveRoomActivity.this.availableHeight != rect.bottom;
                    AlaMasterLiveRoomActivity.this.availableHeight = rect.bottom;
                    if (Math.abs(screenFullSize[1] - rect.bottom) > screenFullSize[1] / 4 && (!AlaMasterLiveRoomActivity.this.mIsKeyboardOpen || z)) {
                        AlaMasterLiveRoomActivity.this.mIsKeyboardOpen = true;
                        TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                        AlaMasterLiveRoomActivity.this.onKeyboardVisibilityChanged(true);
                    } else if (Math.abs(screenFullSize[1] - rect.height()) <= statusBarHeight && AlaMasterLiveRoomActivity.this.mIsKeyboardOpen) {
                        AlaMasterLiveRoomActivity.this.mIsKeyboardOpen = false;
                        AlaMasterLiveRoomActivity.this.onKeyboardVisibilityChanged(false);
                    }
                    if (AlaMasterLiveRoomActivity.this.mLastScreenHeight != screenFullSize[1]) {
                        if (AlaMasterLiveRoomActivity.this.gFi != null) {
                            AlaMasterLiveRoomActivity.this.gFi.bVa();
                        }
                        AlaMasterLiveRoomActivity.this.mLastScreenHeight = screenFullSize[1];
                    } else if (AlaMasterLiveRoomActivity.this.mLastScreenWidth != screenFullSize[0]) {
                        if (AlaMasterLiveRoomActivity.this.gFi != null) {
                            AlaMasterLiveRoomActivity.this.gFi.bVa();
                        }
                        AlaMasterLiveRoomActivity.this.mLastScreenWidth = screenFullSize[0];
                    }
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gFl) {
            getWindow().clearFlags(128);
            if (this.gFk != null) {
                BdBaseApplication.getInst().unregisterReceiver(this.gFk);
            }
            this.gFk = null;
            if (this.gFs != null) {
                BdBaseApplication.getInst().unregisterReceiver(this.gFs);
                this.gFs = null;
            }
            MessageManager.getInstance().unRegisterListener(this.gnN);
            MessageManager.getInstance().unRegisterListener(this.gFv);
            MessageManager.getInstance().unRegisterListener(this.buw);
            MessageManager.getInstance().unRegisterListener(this.gFq);
            MessageManager.getInstance().unRegisterListener(this.gFr);
            getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
            this.globalListener = null;
            this.gFq = null;
            this.buw = null;
            this.gnN = null;
            if (this.gFj != null) {
                this.gFj.destory();
                this.gFj = null;
            }
            if (this.gFi != null) {
                this.gFi.onDestroy();
                this.gFi = null;
            }
            System.gc();
        }
        AlaLiveSwitchData.liveActivityType = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gFi != null) {
            this.gFi.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gFl) {
            if (this.gFj != null) {
                this.gFj.bXj();
                this.gFj.bWZ();
                this.gFj.bXd();
            }
            if (this.gFi != null) {
                this.gFi.onResume();
            }
            com.baidu.live.core.layer.b.CA().onResume();
            bUL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gFl && this.gFj != null) {
            this.gFj.bXa();
            this.gFj.bXe();
        }
        if (this.gFi != null) {
            this.gFi.onPause();
        }
        com.baidu.live.core.layer.b.CA().onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gFl && this.gFi != null) {
            this.gFi.onStop();
        }
        AlaStatManager.getInstance().forceUpload();
    }

    private void bUL() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            bUQ();
        } else if (this.bkL) {
            this.bkL = false;
            if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && BdNetTypeUtil.isMobileNet() && l.PM()) {
                TbadkCoreApplication.isShownNetChangeDialog = true;
                bUP();
            }
        } else if (BdNetTypeUtil.isMobileNet() && l.PN()) {
            bUP();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003f -> B:6:0x001b). Please submit an issue!!! */
    private boolean checkPermission() {
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (!com.baidu.m.a.a.checkPermissionGranted(getApplicationContext(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
            showToast(getResources().getString(a.i.ala_create_permission_camera));
            return false;
        }
        if (!com.baidu.m.a.a.checkPermissionGranted(getApplicationContext(), PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
            showToast(getResources().getString(a.i.ala_create_permission_audio));
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && com.baidu.live.core.layer.b.CA().onBackPressed()) {
            return true;
        }
        if (this.gFi == null || !this.gFi.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.gFi != null) {
            this.gFi.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gFi != null) {
            this.gFi.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        ArrayMap<String, Boolean> transformPermissionResult;
        if (this.gFi != null) {
            this.gFi.onRequestPermissionsResult(i, strArr, iArr);
        }
        if (25040 == i && (transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr)) != null && transformPermissionResult.size() > 0) {
            if (transformPermissionResult.containsKey(PermissionRequest.RESOURCE_VIDEO_CAPTURE) || transformPermissionResult.containsKey(PermissionRequest.RESOURCE_AUDIO_CAPTURE) || transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE")) {
                int i2 = 0;
                for (int i3 = 0; i3 < strArr.length && iArr[i3] == 0; i3++) {
                    i2++;
                }
                if (i2 == strArr.length) {
                    init();
                } else if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!this.gFu.checkPermissionForbidden(getActivity(), str)) {
                            return;
                        }
                    }
                    finish();
                }
            } else if (transformPermissionResult.containsKey("android.permission.ACCESS_FINE_LOCATION") || transformPermissionResult.containsKey("android.permission.ACCESS_COARSE_LOCATION")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_PREPARE_LOCATION_INFO));
            }
        }
    }

    private void bUM() {
        this.gFk = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BdStatsConstant.BROADCAST_ACCOUNT_CHANGED);
        BdBaseApplication.getInst().registerReceiver(this.gFk, intentFilter);
    }

    /* loaded from: classes4.dex */
    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("profile_frame_fps_avg", 0L);
            long longExtra2 = intent.getLongExtra("profile_frame_interval_avg", 0L);
            if (AlaMasterLiveRoomActivity.this.gFt == null) {
                AlaMasterLiveRoomActivity.this.gFt = new com.baidu.tieba.ala.liveroom.i.b();
            }
            AlaMasterLiveRoomActivity.this.gFt.report(longExtra, longExtra2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && AlaMasterLiveRoomActivity.this.gFi != null) {
                AlaMasterLiveRoomActivity.this.gFi.f((short) 1);
            }
        }
    }

    public void bUN() {
        this.isBackground = false;
        finish();
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (!this.isBackground) {
            com.baidu.live.core.layer.b.CA().onDestroy();
            if (this.gFi != null) {
                this.gFi.onFinish();
            }
            c.AR().putLong("last_live_room_id", 0L);
            c.AR().putString("last_live_room_from", "");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913072));
            if (this.gFn) {
                BdSocketLinkService.setHasAbsoluteClose(true);
                BdSocketLinkService.close("live close");
            }
            super.finish();
            if (!TextUtils.isEmpty(this.gnC)) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gnC);
                    this.gnC = null;
                }
            }
        }
    }

    public String bUO() {
        return this.gnC;
    }

    public boolean isBackground() {
        return this.isBackground;
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    public void bUP() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_watch_live_mobile_net_tip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUQ() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getString(a.i.ala_create_no_network));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUR() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.ala_watch_live_user_has_change_to_wifi));
        }
    }
}
