package com.baidu.tieba.ala.liveroom.master;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
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
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveRoomResponsedMessage;
import com.baidu.tieba.ala.liveroom.n.d;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaMasterLiveRoomActivity extends BaseActivity<AlaMasterLiveRoomActivity> {
    private int availableHeight;
    private PermissionJudgePolicy bEF;
    private boolean byF;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private com.baidu.tieba.ala.liveroom.master.a hGk;
    private d hGl;
    private Bundle hGo;
    private b hGu;
    private com.baidu.tieba.ala.liveroom.h.b hGv;
    private String hoQ;
    private boolean mDestroyed;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private boolean mIsKeyboardOpen = false;
    private a hGm = null;
    private volatile boolean isBackground = false;
    private boolean hGn = false;
    private boolean hGp = false;
    private boolean hGq = false;
    private int hGr = -1;
    private CustomMessageListener hGs = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && AlaMasterLiveRoomActivity.this.hGk != null) {
                AlaMasterLiveRoomActivity.this.hGk.g((short) 1);
            }
        }
    };
    private CustomMessageListener bCb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomActivity.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
            }
        }
    };
    private CustomMessageListener hGt = new CustomMessageListener(2913169, true) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Boolean) {
                AlaMasterLiveRoomActivity.this.hGq = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private CustomMessageListener hpb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType;
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && (netType = BdNetTypeUtil.netType()) != AlaMasterLiveRoomActivity.this.hGr) {
                AlaMasterLiveRoomActivity.this.hGr = netType;
                NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                if (netWorkChangedMessage.mLastNetState != netType || !BdNetTypeUtil.isWifiNet() || netWorkChangedMessage.mlastChangedTime != 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        AlaMasterLiveRoomActivity.this.cgU();
                        return;
                    }
                    if (BdNetTypeUtil.isMobileNet() && m.Vq()) {
                        AlaMasterLiveRoomActivity.this.cgT();
                    } else if (BdNetTypeUtil.isWifiNet()) {
                        AlaMasterLiveRoomActivity.this.cgV();
                    }
                    if (AlaMasterLiveRoomActivity.this.hGk != null) {
                        AlaMasterLiveRoomActivity.this.hGk.chf();
                    }
                }
            }
        }
    };
    private CustomMessageListener hGw = new CustomMessageListener(2913178) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomActivity.this.hoQ = null;
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.hGk != null) {
            this.hGk.cr(UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.isBackground = false;
        setIsAddSwipeBackLayout(false);
        getWindow().setSoftInputMode(32);
        super.onCreate(bundle);
        this.byF = true;
        if (!isFinishing()) {
            this.hGo = bundle;
            if (!cgN()) {
                init();
            }
            TbConfig.liveScene = 1;
        }
    }

    private boolean cgN() {
        Activity pageActivity = getPageContext().getPageActivity();
        this.bEF = new PermissionJudgePolicy();
        this.bEF.setDialogClickListener(new PermissionJudgePolicy.PermissionDialogClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.4
            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogCaneled(String str) {
                AlaMasterLiveRoomActivity.this.hGn = true;
                AlaMasterLiveRoomActivity.this.finish();
            }

            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogComfirmed(String str) {
                AlaMasterLiveRoomActivity.this.hGn = true;
                AlaMasterLiveRoomActivity.this.finish();
            }
        });
        this.bEF.clearRequestPermissionList();
        this.bEF.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        this.bEF.appendRequestPermission(pageActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        this.bEF.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.bEF.startRequestPermission(pageActivity);
    }

    private void init() {
        this.hGn = true;
        setUseStyleImmersiveSticky(true);
        getWindow().addFlags(128);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        registerListener(this.hGs);
        initData(this.hGo);
    }

    private void initData(Bundle bundle) {
        AlaLivePersonData alaLivePersonData;
        if (!UtilHelper.isARM()) {
            cgO();
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_forum_name");
            String stringExtra2 = intent.getStringExtra("live_forum_id");
            this.hGp = intent.getBooleanExtra("stop_im_when_close", false);
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
                        this.hoQ = null;
                    } else {
                        this.hoQ = new JSONObject(optString).optString("live_back_scheme");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.hoQ = null;
                    AlaLiveSwitchData.liveActivityType = "";
                }
            }
            cgQ();
            MessageManager.getInstance().registerListener(this.hpb);
            MessageManager.getInstance().registerListener(this.hGw);
            MessageManager.getInstance().registerListener(this.bCb);
            MessageManager.getInstance().registerListener(this.hGt);
            this.hGl = new d(getPageContext());
            if (intExtra == 2) {
                if (!checkPermission()) {
                    if (alaLivePersonData != null) {
                        this.hGl.h(Long.toString(alaLivePersonData.mLiveInfo.live_id), false, false);
                    }
                    if (this.hGk != null) {
                        this.hGk.g((short) 1);
                        return;
                    } else {
                        finish();
                        return;
                    }
                }
                e(alaLivePersonData);
                return;
            } else if (!checkPermission()) {
                if (this.hGk != null) {
                    this.hGk.g((short) 1);
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
        if (this.hGk != null) {
            this.hGk.g((short) 1);
        }
    }

    private void cgO() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(getPageContext().getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.live_not_support_msg);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (AlaMasterLiveRoomActivity.this.hGk != null) {
                    AlaMasterLiveRoomActivity.this.hGk.g((short) 1);
                }
            }
        });
        bdAlertDialog.create(getPageContext()).show();
    }

    private void e(AlaLivePersonData alaLivePersonData) {
        if (alaLivePersonData == null) {
            if (this.hGk != null) {
                this.hGk.g((short) 1);
                return;
            }
            return;
        }
        this.hGl.h(alaLivePersonData);
        this.hGk = new com.baidu.tieba.ala.liveroom.master.a(this);
        this.hGk.a(this.hGl);
        this.hGk.f(alaLivePersonData);
        this.hGl.h(Long.toString(alaLivePersonData.mLiveInfo.live_id), false, true);
    }

    private void a(Bundle bundle, String str, String str2, String str3) {
        if (bundle != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913020));
        }
        this.hGk = new com.baidu.tieba.ala.liveroom.master.a(this);
        this.hGk.a(this.hGl);
        this.hGk.a(str, str2, str3, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void addGlobalLayoutListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (AlaMasterLiveRoomActivity.this.hGq) {
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
                        if (AlaMasterLiveRoomActivity.this.hGk != null) {
                            AlaMasterLiveRoomActivity.this.hGk.chc();
                        }
                        AlaMasterLiveRoomActivity.this.mLastScreenHeight = screenFullSize[1];
                    } else if (AlaMasterLiveRoomActivity.this.mLastScreenWidth != screenFullSize[0]) {
                        if (AlaMasterLiveRoomActivity.this.hGk != null) {
                            AlaMasterLiveRoomActivity.this.hGk.chc();
                        }
                        AlaMasterLiveRoomActivity.this.mLastScreenWidth = screenFullSize[0];
                    }
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void onRelease() {
        if (!this.mDestroyed) {
            this.mDestroyed = true;
            if (this.hGn) {
                getWindow().clearFlags(128);
                if (this.hGm != null) {
                    BdBaseApplication.getInst().unregisterReceiver(this.hGm);
                }
                this.hGm = null;
                if (this.hGu != null) {
                    BdBaseApplication.getInst().unregisterReceiver(this.hGu);
                    this.hGu = null;
                }
                MessageManager.getInstance().unRegisterListener(this.hpb);
                MessageManager.getInstance().unRegisterListener(this.hGw);
                MessageManager.getInstance().unRegisterListener(this.bCb);
                MessageManager.getInstance().unRegisterListener(this.hGs);
                MessageManager.getInstance().unRegisterListener(this.hGt);
                getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
                this.globalListener = null;
                this.hGs = null;
                this.bCb = null;
                this.hpb = null;
                if (this.hGl != null) {
                    this.hGl.destory();
                    this.hGl = null;
                }
                if (this.hGk != null) {
                    this.hGk.onDestroy();
                    this.hGk = null;
                }
                System.gc();
            }
            AlaLiveSwitchData.liveActivityType = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        onRelease();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hGk != null) {
            this.hGk.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hGn) {
            if (this.hGl != null) {
                this.hGl.cjs();
                this.hGl.cji();
                this.hGl.cjm();
            }
            if (this.hGk != null) {
                this.hGk.onResume();
            }
            com.baidu.live.core.layer.b.Bc().onResume();
            cgP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hGn && this.hGl != null) {
            this.hGl.cjj();
            this.hGl.cjn();
        }
        if (this.hGk != null) {
            this.hGk.onPause();
        }
        com.baidu.live.core.layer.b.Bc().onPause();
        if (isFinishing()) {
            onRelease();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hGn && this.hGk != null) {
            this.hGk.onStop();
        }
        AlaStatManager.getInstance().forceUpload();
    }

    private void cgP() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            cgU();
        } else if (this.byF) {
            this.byF = false;
            if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && BdNetTypeUtil.isMobileNet() && m.Vp()) {
                TbadkCoreApplication.isShownNetChangeDialog = true;
                cgT();
            }
        } else if (BdNetTypeUtil.isMobileNet() && m.Vq()) {
            cgT();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003f -> B:6:0x001b). Please submit an issue!!! */
    private boolean checkPermission() {
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (!com.baidu.l.a.a.checkPermissionGranted(getApplicationContext(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
            showToast(getResources().getString(a.h.ala_create_permission_camera));
            return false;
        }
        if (!com.baidu.l.a.a.checkPermissionGranted(getApplicationContext(), PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
            showToast(getResources().getString(a.h.ala_create_permission_audio));
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && com.baidu.live.core.layer.b.Bc().onBackPressed()) {
            return true;
        }
        if (this.hGk == null || !this.hGk.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.hGk != null) {
            this.hGk.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hGk != null) {
            this.hGk.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        ArrayMap<String, Boolean> transformPermissionResult;
        if (this.hGk != null) {
            this.hGk.onRequestPermissionsResult(i, strArr, iArr);
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
                        if (!this.bEF.checkPermissionForbidden(getActivity(), str)) {
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

    private void cgQ() {
        this.hGm = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BdStatsConstant.BROADCAST_ACCOUNT_CHANGED);
        BdBaseApplication.getInst().registerReceiver(this.hGm, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("profile_frame_fps_avg", 0L);
            long longExtra2 = intent.getLongExtra("profile_frame_interval_avg", 0L);
            if (AlaMasterLiveRoomActivity.this.hGv == null) {
                AlaMasterLiveRoomActivity.this.hGv = new com.baidu.tieba.ala.liveroom.h.b();
            }
            AlaMasterLiveRoomActivity.this.hGv.report(longExtra, longExtra2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && AlaMasterLiveRoomActivity.this.hGk != null) {
                AlaMasterLiveRoomActivity.this.hGk.g((short) 1);
            }
        }
    }

    public void cgR() {
        this.isBackground = false;
        finish();
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (!this.isBackground) {
            com.baidu.live.core.layer.b.Bc().onDestroy();
            if (this.hGk != null) {
                this.hGk.onFinish();
            }
            com.baidu.live.d.xc().putLong("last_live_room_id", 0L);
            com.baidu.live.d.xc().putString("last_live_room_from", "");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913072));
            if (this.hGp) {
                BdSocketLinkService.setHasAbsoluteClose(true);
                BdSocketLinkService.close("live close");
            }
            super.finish();
            if (!TextUtils.isEmpty(this.hoQ)) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hoQ);
                    this.hoQ = null;
                }
            }
        }
    }

    public String cgS() {
        return this.hoQ;
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

    public void cgT() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_watch_live_mobile_net_tip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgU() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getString(a.h.ala_create_no_network));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgV() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.ala_watch_live_user_has_change_to_wifi));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        boolean z = false;
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (strArr != null && strArr.length > 0) {
            String str2 = TbadkCoreApplication.getCurrentAccountId() + "";
            if (str2 != null && str2.equals(strArr[0])) {
                z = true;
            }
            if (z && this.hGk != null) {
                this.hGk.VC();
            }
            printWriter.print("============== rtc log is open =  " + z + " ===============");
        }
    }
}
