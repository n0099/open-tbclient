package com.baidu.tieba.ala.player;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.gift.aa;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveRoomResponsedMessage;
/* loaded from: classes4.dex */
public class a {
    private int availableHeight;
    private boolean bmo;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private c hHZ;
    private b hIa;
    private d hIb;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler();
    private boolean mIsKeyboardOpen = false;
    private boolean bFL = true;
    private boolean hIc = false;
    private int hlw = -1;
    private CustomMessageListener hlx = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.player.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && a.this.hIa != null) {
                a.this.hIa.S(false, true);
            }
        }
    };
    private CustomMessageListener hId = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.ala.player.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hIa != null) {
                a.this.hIa.oe(false);
                a.this.hIa.bWc();
            }
        }
    };
    private CustomMessageListener gUt = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.player.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType = BdNetTypeUtil.netType();
            if (netType != a.this.hlw) {
                a.this.hlw = netType;
                NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                if (netWorkChangedMessage.mLastNetState != netType || !BdNetTypeUtil.isWifiNet() || netWorkChangedMessage.mlastChangedTime != 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.cdL();
                        if (a.this.hIa != null) {
                            a.this.hIa.T(false, false);
                            return;
                        }
                        return;
                    }
                    if (BdNetTypeUtil.isMobileNet() && l.UF()) {
                        a.this.cdK();
                    } else if (BdNetTypeUtil.isWifiNet()) {
                        a.this.cdM();
                    }
                    if (a.this.hIa != null) {
                        a.this.hIa.onStart();
                        a.this.hIa.ckO();
                    }
                }
            }
        }
    };
    private CustomMessageListener hIe = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.player.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                a.this.cke();
            }
        }
    };
    private CustomMessageListener bHB = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.player.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    a.this.cdL();
                    if (a.this.hIa != null) {
                        a.this.hIa.T(false, false);
                    }
                } else if (a.this.hIa != null) {
                    if (a.this.hIa.ckx()) {
                        if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && BdNetTypeUtil.isMobileNet() && l.UF()) {
                            TbadkCoreApplication.isShownNetChangeDialog = true;
                            a.this.cdK();
                        }
                    } else if (BdNetTypeUtil.isMobileNet() && l.UF()) {
                        a.this.cdK();
                    }
                }
            }
        }
    };
    private CustomMessageTask.CustomRunnable hIf = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.player.a.6
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, Boolean.valueOf(a.this.bmo));
        }
    };

    public boolean ckc() {
        return this.bmo;
    }

    public d ckd() {
        return this.hIb;
    }

    public a(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.hHZ = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    public void init() {
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.hIc = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.h.ala_master_on_live_no_watch_other_live);
            b(false, false, -1L);
            return;
        }
        this.hIc = true;
        if (!this.bmo) {
            MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        }
        MessageManager.getInstance().registerListener(this.hlx);
        MessageManager.getInstance().registerListener(this.hId);
        MessageManager.getInstance().registerListener(this.gUt);
        MessageManager.getInstance().registerListener(this.hIe);
        MessageManager.getInstance().registerListener(this.bHB);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, this.hIf);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        getPageContext().getPageActivity().getWindow().addFlags(128);
        addGlobalLayoutListener();
        initData();
        com.baidu.live.entereffect.a.Fg().requestData(false);
    }

    private void initData() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        if (!UtilHelper.isARM()) {
            cdF();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.hIa = new b(getPageContext(), this, intent.getStringExtra("last_live_info"));
            this.hIa.b(intent, this.bmo);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
        b(false, false, -1L);
    }

    private void cdF() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(getPageContext().getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.live_not_support_msg);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.a.7
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                a.this.b(false, false, -1L);
            }
        });
        bdAlertDialog.create(getPageContext()).show();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hIa != null) {
            int i = getPageContext().getPageActivity().getResources().getConfiguration().orientation;
            if (i == 0 && configuration != null) {
                i = configuration.orientation;
            }
            this.hIa.dI(i);
        }
    }

    private void addGlobalLayoutListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.player.a.8
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(a.this.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(a.this.getPageContext().getPageActivity());
                boolean z = a.this.availableHeight != rect.bottom;
                a.this.availableHeight = rect.bottom;
                if (a.this.mLastScreenHeight != screenFullSize[1]) {
                    if (a.this.hIa != null) {
                        a.this.hIa.ckF();
                    }
                    a.this.mLastScreenHeight = screenFullSize[1];
                } else if (a.this.mLastScreenWidth != screenFullSize[0]) {
                    if (a.this.hIa != null) {
                        a.this.hIa.ckF();
                    }
                    a.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!a.this.mIsKeyboardOpen || z) && a.this.bFL)) {
                    a.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void onWindowFocusChanged(boolean z) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity());
        if (this.hIa != null) {
            if (realScreenOrientation == 2) {
                this.hIa.ckG();
            } else {
                this.hIa.ckH();
            }
        }
    }

    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.bFL = true;
        if (this.hIa != null) {
            this.hIa.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdM() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.ala_watch_live_user_has_change_to_wifi));
        }
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

    public void oa(boolean z) {
        if (this.hIa != null) {
            this.hIa.oa(z);
        }
    }

    public void onStart() {
        if (this.hIa != null) {
            this.hIa.og(false);
            this.hIa.onStart();
        }
    }

    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.hIc) {
            this.bFL = false;
            if (this.hIa != null) {
                this.hIa.onPause();
            }
        }
    }

    public void ob(boolean z) {
        if (this.hIa != null) {
            this.hIa.og(true);
            this.hIa.T(true, z);
        }
        AlaStatManager.getInstance().forceUpload();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.hIa != null && this.hIa.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hIa != null) {
            this.hIa.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hIa != null) {
            this.hIa.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cke() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hIa != null) {
                        a.this.hIa.mR(true);
                        a.this.hIa.ckw();
                        a.this.hIa.ckg();
                    }
                }
            }, 1L);
        }
    }

    public void b(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        com.baidu.live.ac.a.b.Qx().release();
        aa.Hq();
        com.baidu.live.entereffect.a.Fg().release();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            HKStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.hIa != null ? this.hIa.MD() : "");
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            QMStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.hIa != null ? this.hIa.MD() : "");
        }
        if (this.hIa != null) {
            this.hIa.ckN();
        }
        if (this.hHZ != null) {
            this.hHZ.a(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    public void onDestroy() {
        if (this.hIc) {
            MessageManager.getInstance().unRegisterListener(this.hId);
            MessageManager.getInstance().unRegisterListener(this.hlx);
            MessageManager.getInstance().unRegisterListener(this.gUt);
            MessageManager.getInstance().unRegisterListener(this.hIe);
            MessageManager.getInstance().unRegisterListener(this.bHB);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_MIX);
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
            this.globalListener = null;
            if (this.hIa != null) {
                this.hIa.destroy();
                this.hIa = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }
}
