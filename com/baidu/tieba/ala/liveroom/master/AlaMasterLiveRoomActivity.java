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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.live.tbadk.core.util.PermissionUtil;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.tieba.ala.liveroom.m.c;
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveRoomResponsedMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaMasterLiveRoomActivity extends BaseActivity<AlaMasterLiveRoomActivity> {
    private ViewTreeObserver.OnGlobalLayoutListener dLS;
    private com.baidu.tieba.ala.liveroom.master.a eiD;
    private int eiE;
    private c eiF;
    private Bundle eiI;
    private PermissionJudgePolicy eiM;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private boolean YX = false;
    private a eiG = null;
    private volatile boolean isBackground = false;
    private boolean eiH = false;
    private boolean eiJ = false;
    private CustomMessageListener eiK = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && AlaMasterLiveRoomActivity.this.eiD != null) {
                AlaMasterLiveRoomActivity.this.eiD.d((short) 1);
            }
        }
    };
    private CustomMessageListener eiL = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomActivity.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
            }
        }
    };
    private CustomMessageListener dUL = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean isShouldShowNotWifiToastByMaster;
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaMasterLiveRoomActivity.this.showToast(AlaMasterLiveRoomActivity.this.getPageContext().getPageActivity().getString(a.i.ala_create_no_network));
            } else if (!BdNetTypeUtil.isWifiNet()) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isTieba()) {
                    IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
                    isShouldShowNotWifiToastByMaster = buildParamsExtra != null ? buildParamsExtra.isShouldShowNotWifiToastByMaster() : true;
                } else {
                    isShouldShowNotWifiToastByMaster = !ExtraParamsManager.getSaveFlowStatus();
                }
                if (TbadkCoreApplication.getInst().isTieba() ? true : isShouldShowNotWifiToastByMaster) {
                    AlaMasterLiveRoomActivity.this.showToast(AlaMasterLiveRoomActivity.this.getPageContext().getPageActivity().getString(a.i.ala_create_not_wifi));
                }
            }
            if (AlaMasterLiveRoomActivity.this.eiD != null && BdNetTypeUtil.isNetWorkAvailable()) {
                AlaMasterLiveRoomActivity.this.eiD.aTj();
            }
        }
    };

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.eiD != null) {
            this.eiD.bw(UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.isBackground = false;
        setIsAddSwipeBackLayout(false);
        getWindow().setSoftInputMode(32);
        super.onCreate(bundle);
        this.eiI = bundle;
        if (!aST()) {
            init();
        }
    }

    private boolean aST() {
        Activity pageActivity = getPageContext().getPageActivity();
        this.eiM = new PermissionJudgePolicy();
        this.eiM.setDialogClickListener(new PermissionJudgePolicy.PermissionDialogClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.3
            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogCaneled(String str) {
                AlaMasterLiveRoomActivity.this.eiH = true;
                AlaMasterLiveRoomActivity.this.finish();
            }

            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogComfirmed(String str) {
                AlaMasterLiveRoomActivity.this.eiH = true;
                AlaMasterLiveRoomActivity.this.finish();
            }
        });
        this.eiM.clearRequestPermissionList();
        this.eiM.appendRequestPermission(pageActivity, "android.permission.CAMERA");
        this.eiM.appendRequestPermission(pageActivity, "android.permission.RECORD_AUDIO");
        this.eiM.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.eiM.startRequestPermission(pageActivity);
    }

    private void init() {
        this.eiH = true;
        setUseStyleImmersiveSticky(true);
        getWindow().addFlags(128);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        registerListener(this.eiK);
        initData(this.eiI);
    }

    private void initData(Bundle bundle) {
        if (!UtilHelper.isARM()) {
            aSU();
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_forum_name");
            String stringExtra2 = intent.getStringExtra("live_forum_id");
            this.eiJ = intent.getBooleanExtra("stop_im_when_close", false);
            int intExtra = intent.getIntExtra("create_master_live_type", 1);
            String stringExtra3 = intent.getStringExtra("special_forum_type");
            String stringExtra4 = intent.getStringExtra("live_info_core");
            AlaLivePersonData alaLivePersonData = null;
            if (!TextUtils.isEmpty(stringExtra4)) {
                alaLivePersonData = new AlaLivePersonData();
                try {
                    alaLivePersonData.parseJson(new JSONObject(stringExtra4));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            aSW();
            MessageManager.getInstance().registerListener(this.dUL);
            MessageManager.getInstance().registerListener(this.eiL);
            this.eiF = new c(getPageContext());
            if (intExtra == 2) {
                if (!checkPermission()) {
                    this.eiF.h(Long.toString(alaLivePersonData.mLiveInfo.live_id), false, false);
                    if (this.eiD != null) {
                        this.eiD.d((short) 1);
                        return;
                    } else {
                        finish();
                        return;
                    }
                }
                c(alaLivePersonData);
                return;
            } else if (!checkPermission()) {
                if (this.eiD != null) {
                    this.eiD.d((short) 1);
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
        if (this.eiD != null) {
            this.eiD.d((short) 1);
        }
    }

    private void aSU() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(getPageContext().getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.live_not_support_msg);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (AlaMasterLiveRoomActivity.this.eiD != null) {
                    AlaMasterLiveRoomActivity.this.eiD.d((short) 1);
                }
            }
        });
        bdAlertDialog.create(getPageContext()).show();
    }

    private void c(AlaLivePersonData alaLivePersonData) {
        if (alaLivePersonData == null) {
            if (this.eiD != null) {
                this.eiD.d((short) 1);
                return;
            }
            return;
        }
        this.eiF.e(alaLivePersonData);
        this.eiD = new com.baidu.tieba.ala.liveroom.master.a(this);
        this.eiD.a(this.eiF);
        this.eiD.d(alaLivePersonData);
        this.eiF.h(Long.toString(alaLivePersonData.mLiveInfo.live_id), false, true);
    }

    private void a(Bundle bundle, String str, String str2, String str3) {
        if (bundle != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913020));
        }
        this.eiD = new com.baidu.tieba.ala.liveroom.master.a(this);
        this.eiD.a(this.eiF);
        this.eiD.a(str, str2, str3, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void addGlobalLayoutListener() {
        this.dLS = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaMasterLiveRoomActivity.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaMasterLiveRoomActivity.this.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(AlaMasterLiveRoomActivity.this.getPageContext().getPageActivity());
                boolean z = AlaMasterLiveRoomActivity.this.eiE != rect.bottom;
                AlaMasterLiveRoomActivity.this.eiE = rect.bottom;
                if (Math.abs(screenFullSize[1] - rect.bottom) > screenFullSize[1] / 4 && (!AlaMasterLiveRoomActivity.this.YX || z)) {
                    AlaMasterLiveRoomActivity.this.YX = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    AlaMasterLiveRoomActivity.this.onKeyboardVisibilityChanged(true);
                } else if (Math.abs(screenFullSize[1] - rect.height()) <= statusBarHeight && AlaMasterLiveRoomActivity.this.YX) {
                    AlaMasterLiveRoomActivity.this.YX = false;
                    AlaMasterLiveRoomActivity.this.onKeyboardVisibilityChanged(false);
                }
                if (AlaMasterLiveRoomActivity.this.mLastScreenHeight != screenFullSize[1]) {
                    if (AlaMasterLiveRoomActivity.this.eiD != null) {
                        AlaMasterLiveRoomActivity.this.eiD.aTg();
                    }
                    AlaMasterLiveRoomActivity.this.mLastScreenHeight = screenFullSize[1];
                } else if (AlaMasterLiveRoomActivity.this.mLastScreenWidth != screenFullSize[0]) {
                    if (AlaMasterLiveRoomActivity.this.eiD != null) {
                        AlaMasterLiveRoomActivity.this.eiD.aTg();
                    }
                    AlaMasterLiveRoomActivity.this.mLastScreenWidth = screenFullSize[0];
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.dLS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eiH) {
            getWindow().clearFlags(128);
            if (this.eiG != null) {
                BdBaseApplication.getInst().unregisterReceiver(this.eiG);
            }
            this.eiG = null;
            MessageManager.getInstance().unRegisterListener(this.dUL);
            MessageManager.getInstance().unRegisterListener(this.eiL);
            MessageManager.getInstance().unRegisterListener(this.eiK);
            getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.dLS);
            this.dLS = null;
            this.eiK = null;
            this.eiL = null;
            this.dUL = null;
            if (this.eiF != null) {
                this.eiF.destory();
                this.eiF = null;
            }
            if (this.eiD != null) {
                this.eiD.onDestroy();
                this.eiD = null;
            }
            System.gc();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eiH) {
            if (this.eiF != null) {
                this.eiF.aUZ();
                this.eiF.aUR();
            }
            if (this.eiD != null) {
                this.eiD.onResume();
            }
            aSV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.eiH && this.eiF != null) {
            this.eiF.aUS();
        }
        if (this.eiD != null) {
            this.eiD.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eiH && this.eiD != null) {
            this.eiD.onStop();
        }
    }

    private void aSV() {
        boolean isShouldShowNotWifiToastByMaster;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            showToast(getResources().getString(a.i.ala_create_no_network));
        } else if (!BdNetTypeUtil.isWifiNet()) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isTieba()) {
                IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
                isShouldShowNotWifiToastByMaster = buildParamsExtra != null ? buildParamsExtra.isShouldShowNotWifiToastByMaster() : true;
            } else {
                isShouldShowNotWifiToastByMaster = !ExtraParamsManager.getSaveFlowStatus();
            }
            if (TbadkCoreApplication.getInst().isTieba() ? true : isShouldShowNotWifiToastByMaster) {
                showToast(getResources().getString(a.i.ala_create_not_wifi));
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003f -> B:6:0x001b). Please submit an issue!!! */
    private boolean checkPermission() {
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (!com.baidu.e.a.a.L(getApplicationContext(), "android.permission.CAMERA")) {
            showToast(getResources().getString(a.i.ala_create_permission_camera));
            return false;
        }
        if (!com.baidu.e.a.a.L(getApplicationContext(), "android.permission.RECORD_AUDIO")) {
            showToast(getResources().getString(a.i.ala_create_permission_audio));
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.eiD == null || !this.eiD.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.eiD != null) {
            this.eiD.onKeyboardVisibilityChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eiD != null) {
            this.eiD.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (25040 == i) {
            ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.size() > 0) {
                if (transformPermissionResult.containsKey("android.permission.CAMERA") || transformPermissionResult.containsKey("android.permission.RECORD_AUDIO") || transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < strArr.length && iArr[i3] == 0; i3++) {
                        i2++;
                    }
                    if (i2 == strArr.length) {
                        init();
                    } else if (strArr.length > 0) {
                        for (String str : strArr) {
                            if (!this.eiM.checkPermissionForbidden(getActivity(), str)) {
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
    }

    private void aSW() {
        this.eiG = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BdStatsConstant.BROADCAST_ACCOUNT_CHANGED);
        BdBaseApplication.getInst().registerReceiver(this.eiG, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && AlaMasterLiveRoomActivity.this.eiD != null) {
                AlaMasterLiveRoomActivity.this.eiD.d((short) 1);
            }
        }
    }

    public void aSX() {
        this.isBackground = false;
        finish();
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (!this.isBackground) {
            if (this.eiD != null) {
                this.eiD.onFinish();
            }
            com.baidu.live.c.np().putLong("last_live_room_id", 0L);
            com.baidu.live.c.np().putString("last_live_room_from", "");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913072));
            if (this.eiJ) {
                BdSocketLinkService.setHasAbsoluteClose(true);
                BdSocketLinkService.close("live close");
            }
            super.finish();
        }
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
}
