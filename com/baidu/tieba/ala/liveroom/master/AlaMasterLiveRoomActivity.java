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
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
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
    private boolean brE;
    private PermissionJudgePolicy bxz;
    private String gUi;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private com.baidu.tieba.ala.liveroom.i.b hlA;
    private com.baidu.tieba.ala.liveroom.master.a hlp;
    private d hlq;
    private Bundle hlt;
    private b hlz;
    private boolean mDestroyed;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private boolean mIsKeyboardOpen = false;
    private a hlr = null;
    private volatile boolean isBackground = false;
    private boolean hls = false;
    private boolean hlu = false;
    private boolean hlv = false;
    private int hlw = -1;
    private CustomMessageListener hlx = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && AlaMasterLiveRoomActivity.this.hlp != null) {
                AlaMasterLiveRoomActivity.this.hlp.g((short) 1);
            }
        }
    };
    private CustomMessageListener bHB = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomActivity.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
            }
        }
    };
    private CustomMessageListener hly = new CustomMessageListener(2913169, true) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                AlaMasterLiveRoomActivity.this.hlv = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private CustomMessageListener gUt = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType;
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && (netType = BdNetTypeUtil.netType()) != AlaMasterLiveRoomActivity.this.hlw) {
                AlaMasterLiveRoomActivity.this.hlw = netType;
                NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                if (netWorkChangedMessage.mLastNetState != netType || !BdNetTypeUtil.isWifiNet() || netWorkChangedMessage.mlastChangedTime != 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaMasterLiveRoomActivity.this.cdL();
                        return;
                    }
                    if (BdNetTypeUtil.isMobileNet() && l.UG()) {
                        AlaMasterLiveRoomActivity.this.cdK();
                    } else if (BdNetTypeUtil.isWifiNet()) {
                        AlaMasterLiveRoomActivity.this.cdM();
                    }
                    if (AlaMasterLiveRoomActivity.this.hlp != null) {
                        AlaMasterLiveRoomActivity.this.hlp.cdW();
                    }
                }
            }
        }
    };
    private CustomMessageListener hlB = new CustomMessageListener(2913178) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomActivity.this.gUi = null;
        }
    };

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.hlp != null) {
            this.hlp.dI(UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.isBackground = false;
        setIsAddSwipeBackLayout(false);
        getWindow().setSoftInputMode(32);
        super.onCreate(bundle);
        this.brE = true;
        if (!isFinishing()) {
            this.hlt = bundle;
            if (!cdE()) {
                init();
            }
            TbConfig.liveScene = 1;
        }
    }

    private boolean cdE() {
        Activity pageActivity = getPageContext().getPageActivity();
        this.bxz = new PermissionJudgePolicy();
        this.bxz.setDialogClickListener(new PermissionJudgePolicy.PermissionDialogClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.4
            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogCaneled(String str) {
                AlaMasterLiveRoomActivity.this.hls = true;
                AlaMasterLiveRoomActivity.this.finish();
            }

            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogComfirmed(String str) {
                AlaMasterLiveRoomActivity.this.hls = true;
                AlaMasterLiveRoomActivity.this.finish();
            }
        });
        this.bxz.clearRequestPermissionList();
        this.bxz.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        this.bxz.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        this.bxz.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.bxz.startRequestPermission(pageActivity);
    }

    private void init() {
        this.hls = true;
        setUseStyleImmersiveSticky(true);
        getWindow().addFlags(128);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        registerListener(this.hlx);
        initData(this.hlt);
    }

    private void initData(Bundle bundle) {
        AlaLivePersonData alaLivePersonData;
        if (!UtilHelper.isARM()) {
            cdF();
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_forum_name");
            String stringExtra2 = intent.getStringExtra("live_forum_id");
            this.hlu = intent.getBooleanExtra("stop_im_when_close", false);
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
                        this.gUi = null;
                    } else {
                        this.gUi = new JSONObject(optString).optString("live_back_scheme");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.gUi = null;
                    AlaLiveSwitchData.liveActivityType = "";
                }
            }
            cdH();
            MessageManager.getInstance().registerListener(this.gUt);
            MessageManager.getInstance().registerListener(this.hlB);
            MessageManager.getInstance().registerListener(this.bHB);
            MessageManager.getInstance().registerListener(this.hly);
            this.hlq = new d(getPageContext());
            if (intExtra == 2) {
                if (!checkPermission()) {
                    if (alaLivePersonData != null) {
                        this.hlq.h(Long.toString(alaLivePersonData.mLiveInfo.live_id), false, false);
                    }
                    if (this.hlp != null) {
                        this.hlp.g((short) 1);
                        return;
                    } else {
                        finish();
                        return;
                    }
                }
                e(alaLivePersonData);
                return;
            } else if (!checkPermission()) {
                if (this.hlp != null) {
                    this.hlp.g((short) 1);
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
        showToast(getResources().getString(a.h.ala_entry_live_failed));
        if (this.hlp != null) {
            this.hlp.g((short) 1);
        }
    }

    private void cdF() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(getPageContext().getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.live_not_support_msg);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (AlaMasterLiveRoomActivity.this.hlp != null) {
                    AlaMasterLiveRoomActivity.this.hlp.g((short) 1);
                }
            }
        });
        bdAlertDialog.create(getPageContext()).show();
    }

    private void e(AlaLivePersonData alaLivePersonData) {
        if (alaLivePersonData == null) {
            if (this.hlp != null) {
                this.hlp.g((short) 1);
                return;
            }
            return;
        }
        this.hlq.h(alaLivePersonData);
        this.hlp = new com.baidu.tieba.ala.liveroom.master.a(this);
        this.hlp.a(this.hlq);
        this.hlp.f(alaLivePersonData);
        this.hlq.h(Long.toString(alaLivePersonData.mLiveInfo.live_id), false, true);
    }

    private void a(Bundle bundle, String str, String str2, String str3) {
        if (bundle != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913020));
        }
        this.hlp = new com.baidu.tieba.ala.liveroom.master.a(this);
        this.hlp.a(this.hlq);
        this.hlp.a(str, str2, str3, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void addGlobalLayoutListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (AlaMasterLiveRoomActivity.this.hlv) {
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
                        if (AlaMasterLiveRoomActivity.this.hlp != null) {
                            AlaMasterLiveRoomActivity.this.hlp.cdT();
                        }
                        AlaMasterLiveRoomActivity.this.mLastScreenHeight = screenFullSize[1];
                    } else if (AlaMasterLiveRoomActivity.this.mLastScreenWidth != screenFullSize[0]) {
                        if (AlaMasterLiveRoomActivity.this.hlp != null) {
                            AlaMasterLiveRoomActivity.this.hlp.cdT();
                        }
                        AlaMasterLiveRoomActivity.this.mLastScreenWidth = screenFullSize[0];
                    }
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void onRelease() {
        if (!this.mDestroyed) {
            this.mDestroyed = true;
            if (this.hls) {
                getWindow().clearFlags(128);
                if (this.hlr != null) {
                    BdBaseApplication.getInst().unregisterReceiver(this.hlr);
                }
                this.hlr = null;
                if (this.hlz != null) {
                    BdBaseApplication.getInst().unregisterReceiver(this.hlz);
                    this.hlz = null;
                }
                MessageManager.getInstance().unRegisterListener(this.gUt);
                MessageManager.getInstance().unRegisterListener(this.hlB);
                MessageManager.getInstance().unRegisterListener(this.bHB);
                MessageManager.getInstance().unRegisterListener(this.hlx);
                MessageManager.getInstance().unRegisterListener(this.hly);
                getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
                this.globalListener = null;
                this.hlx = null;
                this.bHB = null;
                this.gUt = null;
                if (this.hlq != null) {
                    this.hlq.destory();
                    this.hlq = null;
                }
                if (this.hlp != null) {
                    this.hlp.onDestroy();
                    this.hlp = null;
                }
                System.gc();
            }
            AlaLiveSwitchData.liveActivityType = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        onRelease();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hlp != null) {
            this.hlp.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hls) {
            if (this.hlq != null) {
                this.hlq.cgj();
                this.hlq.cfZ();
                this.hlq.cgd();
            }
            if (this.hlp != null) {
                this.hlp.onResume();
            }
            com.baidu.live.core.layer.b.DX().onResume();
            cdG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hls && this.hlq != null) {
            this.hlq.cga();
            this.hlq.cge();
        }
        if (this.hlp != null) {
            this.hlp.onPause();
        }
        com.baidu.live.core.layer.b.DX().onPause();
        if (isFinishing()) {
            onRelease();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hls && this.hlp != null) {
            this.hlp.onStop();
        }
        AlaStatManager.getInstance().forceUpload();
    }

    private void cdG() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            cdL();
        } else if (this.brE) {
            this.brE = false;
            if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && BdNetTypeUtil.isMobileNet() && l.UF()) {
                TbadkCoreApplication.isShownNetChangeDialog = true;
                cdK();
            }
        } else if (BdNetTypeUtil.isMobileNet() && l.UG()) {
            cdK();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003f -> B:6:0x001b). Please submit an issue!!! */
    private boolean checkPermission() {
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (!com.baidu.m.a.a.checkPermissionGranted(getApplicationContext(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
            showToast(getResources().getString(a.h.ala_create_permission_camera));
            return false;
        }
        if (!com.baidu.m.a.a.checkPermissionGranted(getApplicationContext(), PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
            showToast(getResources().getString(a.h.ala_create_permission_audio));
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && com.baidu.live.core.layer.b.DX().onBackPressed()) {
            return true;
        }
        if (this.hlp == null || !this.hlp.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hlp != null) {
            this.hlp.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hlp != null) {
            this.hlp.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        ArrayMap<String, Boolean> transformPermissionResult;
        if (this.hlp != null) {
            this.hlp.onRequestPermissionsResult(i, strArr, iArr);
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
                        if (!this.bxz.checkPermissionForbidden(getActivity(), str)) {
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

    private void cdH() {
        this.hlr = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BdStatsConstant.BROADCAST_ACCOUNT_CHANGED);
        BdBaseApplication.getInst().registerReceiver(this.hlr, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("profile_frame_fps_avg", 0L);
            long longExtra2 = intent.getLongExtra("profile_frame_interval_avg", 0L);
            if (AlaMasterLiveRoomActivity.this.hlA == null) {
                AlaMasterLiveRoomActivity.this.hlA = new com.baidu.tieba.ala.liveroom.i.b();
            }
            AlaMasterLiveRoomActivity.this.hlA.report(longExtra, longExtra2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && AlaMasterLiveRoomActivity.this.hlp != null) {
                AlaMasterLiveRoomActivity.this.hlp.g((short) 1);
            }
        }
    }

    public void cdI() {
        this.isBackground = false;
        finish();
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (!this.isBackground) {
            com.baidu.live.core.layer.b.DX().onDestroy();
            if (this.hlp != null) {
                this.hlp.onFinish();
            }
            com.baidu.live.d.AZ().putLong("last_live_room_id", 0L);
            com.baidu.live.d.AZ().putString("last_live_room_from", "");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913072));
            if (this.hlu) {
                BdSocketLinkService.setHasAbsoluteClose(true);
                BdSocketLinkService.close("live close");
            }
            super.finish();
            if (!TextUtils.isEmpty(this.gUi)) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gUi);
                    this.gUi = null;
                }
            }
        }
    }

    public String cdJ() {
        return this.gUi;
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

    public void cdK() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_watch_live_mobile_net_tip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdL() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getString(a.h.ala_create_no_network));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdM() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.ala_watch_live_user_has_change_to_wifi));
        }
    }
}
