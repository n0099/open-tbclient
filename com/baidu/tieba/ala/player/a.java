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
import com.baidu.live.gift.ac;
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
    private boolean bpM;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private c hRp;
    private b hRq;
    private d hRr;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler();
    private boolean mIsKeyboardOpen = false;
    private boolean bJi = true;
    private boolean hRs = false;
    private int huE = -1;
    private CustomMessageListener huF = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.player.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && a.this.hRq != null) {
                a.this.hRq.S(false, true);
            }
        }
    };
    private CustomMessageListener hRt = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.ala.player.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hRq != null) {
                a.this.hRq.oA(false);
                a.this.hRq.bZg();
            }
        }
    };
    private CustomMessageListener hdp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.player.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType = BdNetTypeUtil.netType();
            if (netType != a.this.huE) {
                a.this.huE = netType;
                NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                if (netWorkChangedMessage.mLastNetState != netType || !BdNetTypeUtil.isWifiNet() || netWorkChangedMessage.mlastChangedTime != 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.cgX();
                        if (a.this.hRq != null) {
                            a.this.hRq.T(false, false);
                            return;
                        }
                        return;
                    }
                    if (BdNetTypeUtil.isMobileNet() && l.Ww()) {
                        a.this.cgW();
                    } else if (BdNetTypeUtil.isWifiNet()) {
                        a.this.cgY();
                    }
                    if (a.this.hRq != null) {
                        a.this.hRq.onStart();
                        a.this.hRq.cod();
                    }
                }
            }
        }
    };
    private CustomMessageListener hRu = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.player.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                a.this.cns();
            }
        }
    };
    private CustomMessageListener byv = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.player.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    a.this.cgX();
                    if (a.this.hRq != null) {
                        a.this.hRq.T(false, false);
                    }
                } else if (a.this.hRq != null) {
                    if (a.this.hRq.cnM()) {
                        if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && BdNetTypeUtil.isMobileNet() && l.Ww()) {
                            TbadkCoreApplication.isShownNetChangeDialog = true;
                            a.this.cgW();
                        }
                    } else if (BdNetTypeUtil.isMobileNet() && l.Ww()) {
                        a.this.cgW();
                    }
                }
            }
        }
    };
    private CustomMessageTask.CustomRunnable hRv = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.player.a.6
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, Boolean.valueOf(a.this.bpM));
        }
    };

    public boolean cnq() {
        return this.bpM;
    }

    public d cnr() {
        return this.hRr;
    }

    public a(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.hRp = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    public void init() {
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.hRs = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.h.ala_master_on_live_no_watch_other_live);
            b(false, false, -1L);
            return;
        }
        this.hRs = true;
        if (!this.bpM) {
            MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        }
        MessageManager.getInstance().registerListener(this.huF);
        MessageManager.getInstance().registerListener(this.hRt);
        MessageManager.getInstance().registerListener(this.hdp);
        MessageManager.getInstance().registerListener(this.hRu);
        MessageManager.getInstance().registerListener(this.byv);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, this.hRv);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        getPageContext().getPageActivity().getWindow().addFlags(128);
        addGlobalLayoutListener();
        initData();
        com.baidu.live.entereffect.a.Gi().bA(false);
    }

    private void initData() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        if (!UtilHelper.isARM()) {
            cgR();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.hRq = new b(getPageContext(), this, intent.getStringExtra("last_live_info"));
            this.hRq.b(intent, this.bpM);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
        b(false, false, -1L);
    }

    private void cgR() {
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
        if (this.hRq != null) {
            int i = getPageContext().getPageActivity().getResources().getConfiguration().orientation;
            if (i == 0 && configuration != null) {
                i = configuration.orientation;
            }
            this.hRq.dX(i);
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
                    if (a.this.hRq != null) {
                        a.this.hRq.cnU();
                    }
                    a.this.mLastScreenHeight = screenFullSize[1];
                } else if (a.this.mLastScreenWidth != screenFullSize[0]) {
                    if (a.this.hRq != null) {
                        a.this.hRq.cnU();
                    }
                    a.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!a.this.mIsKeyboardOpen || z) && a.this.bJi)) {
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
        if (this.hRq != null) {
            if (realScreenOrientation == 2) {
                this.hRq.cnV();
            } else {
                this.hRq.cnW();
            }
        }
    }

    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.bJi = true;
        if (this.hRq != null) {
            this.hRq.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgY() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.ala_watch_live_user_has_change_to_wifi));
        }
    }

    public void cgW() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_watch_live_mobile_net_tip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgX() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getString(a.h.ala_create_no_network));
        }
    }

    public void ow(boolean z) {
        if (this.hRq != null) {
            this.hRq.ow(z);
        }
    }

    public void onStart() {
        if (this.hRq != null) {
            this.hRq.oC(false);
            this.hRq.onStart();
        }
    }

    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.hRs) {
            this.bJi = false;
            if (this.hRq != null) {
                this.hRq.onPause();
            }
        }
    }

    public void ox(boolean z) {
        if (this.hRq != null) {
            this.hRq.oC(true);
            this.hRq.T(true, z);
        }
        AlaStatManager.getInstance().forceUpload();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.hRq != null && this.hRq.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hRq != null) {
            this.hRq.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hRq != null) {
            this.hRq.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cns() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hRq != null) {
                        a.this.hRq.nn(true);
                        a.this.hRq.cnL();
                        a.this.hRq.cnu();
                    }
                }
            }, 1L);
        }
    }

    public void b(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        com.baidu.live.ag.a.b.Sm().release();
        ac.Iy();
        com.baidu.live.entereffect.a.Gi().release();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            HKStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.hRq != null ? this.hRq.Oj() : "");
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            QMStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.hRq != null ? this.hRq.Oj() : "");
        }
        if (this.hRq != null) {
            this.hRq.coc();
        }
        if (this.hRp != null) {
            this.hRp.a(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    public void onDestroy() {
        if (this.hRs) {
            MessageManager.getInstance().unRegisterListener(this.hRt);
            MessageManager.getInstance().unRegisterListener(this.huF);
            MessageManager.getInstance().unRegisterListener(this.hdp);
            MessageManager.getInstance().unRegisterListener(this.hRu);
            MessageManager.getInstance().unRegisterListener(this.byv);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_MIX);
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
            this.globalListener = null;
            if (this.hRq != null) {
                this.hRq.destroy();
                this.hRq = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }
}
