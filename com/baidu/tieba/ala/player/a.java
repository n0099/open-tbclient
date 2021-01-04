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
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveRoomResponsedMessage;
/* loaded from: classes11.dex */
public class a {
    private int availableHeight;
    private boolean bgw;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private c idP;
    private b idQ;
    private d idR;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler();
    private boolean mIsKeyboardOpen = false;
    private boolean bNW = true;
    private boolean idS = false;
    private int hGA = -1;
    private CustomMessageListener hGB = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.player.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && a.this.idQ != null) {
                a.this.idQ.U(false, true);
            }
        }
    };
    private CustomMessageListener idT = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.ala.player.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.idQ != null) {
                a.this.idQ.oZ(false);
                a.this.idQ.cbN();
            }
        }
    };
    private CustomMessageListener hpc = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.player.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType = BdNetTypeUtil.netType();
            if (netType != a.this.hGA) {
                a.this.hGA = netType;
                NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                if (netWorkChangedMessage.mLastNetState != netType || !BdNetTypeUtil.isWifiNet() || netWorkChangedMessage.mlastChangedTime != 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.cjL();
                        if (a.this.idQ != null) {
                            a.this.idQ.V(false, false);
                            return;
                        }
                        return;
                    }
                    if (BdNetTypeUtil.isMobileNet() && m.XA()) {
                        a.this.cjK();
                    } else if (BdNetTypeUtil.isWifiNet()) {
                        a.this.cjM();
                    }
                    if (a.this.idQ != null) {
                        a.this.idQ.onStart();
                        a.this.idQ.cqV();
                    }
                }
            }
        }
    };
    private CustomMessageListener idU = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.player.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                a.this.cqk();
            }
        }
    };
    private CustomMessageListener bDh = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.player.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    a.this.cjL();
                    if (a.this.idQ != null) {
                        a.this.idQ.V(false, false);
                    }
                } else if (a.this.idQ != null) {
                    if (a.this.idQ.cqE()) {
                        if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && BdNetTypeUtil.isMobileNet() && m.XA()) {
                            TbadkCoreApplication.isShownNetChangeDialog = true;
                            a.this.cjK();
                        }
                    } else if (BdNetTypeUtil.isMobileNet() && m.XA()) {
                        a.this.cjK();
                    }
                }
            }
        }
    };
    private CustomMessageTask.CustomRunnable idV = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.player.a.6
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, Boolean.valueOf(a.this.bgw));
        }
    };

    public boolean cqi() {
        return this.bgw;
    }

    public d cqj() {
        return this.idR;
    }

    public a(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.idP = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    public void init() {
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.idS = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.h.ala_master_on_live_no_watch_other_live);
            b(false, false, -1L);
            return;
        }
        this.idS = true;
        if (!this.bgw) {
            MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        }
        MessageManager.getInstance().registerListener(this.hGB);
        MessageManager.getInstance().registerListener(this.idT);
        MessageManager.getInstance().registerListener(this.hpc);
        MessageManager.getInstance().registerListener(this.idU);
        MessageManager.getInstance().registerListener(this.bDh);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, this.idV);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        getPageContext().getPageActivity().getWindow().addFlags(128);
        addGlobalLayoutListener();
        initData();
        com.baidu.live.entereffect.a.FB().bx(false);
    }

    private void initData() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        if (!UtilHelper.isARM()) {
            cjF();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.idQ = new b(getPageContext(), this, intent.getStringExtra("last_live_info"));
            this.idQ.c(intent, this.bgw);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
        b(false, false, -1L);
    }

    private void cjF() {
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
        if (this.idQ != null) {
            int i = getPageContext().getPageActivity().getResources().getConfiguration().orientation;
            if (i == 0 && configuration != null) {
                i = configuration.orientation;
            }
            this.idQ.dU(i);
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
                    if (a.this.idQ != null) {
                        a.this.idQ.cqM();
                    }
                    a.this.mLastScreenHeight = screenFullSize[1];
                } else if (a.this.mLastScreenWidth != screenFullSize[0]) {
                    if (a.this.idQ != null) {
                        a.this.idQ.cqM();
                    }
                    a.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!a.this.mIsKeyboardOpen || z) && a.this.bNW)) {
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
        if (this.idQ != null) {
            if (realScreenOrientation == 2) {
                this.idQ.cqN();
            } else {
                this.idQ.cqO();
            }
        }
    }

    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.bNW = true;
        if (this.idQ != null) {
            this.idQ.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjM() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.ala_watch_live_user_has_change_to_wifi));
        }
    }

    public void cjK() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.h.ala_watch_live_mobile_net_tip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjL() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getString(a.h.ala_create_no_network));
        }
    }

    public void oV(boolean z) {
        if (this.idQ != null) {
            this.idQ.oV(z);
        }
    }

    public void onStart() {
        if (this.idQ != null) {
            this.idQ.pb(false);
            this.idQ.onStart();
        }
    }

    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.idS) {
            this.bNW = false;
            if (this.idQ != null) {
                this.idQ.onPause();
            }
        }
    }

    public void oW(boolean z) {
        if (this.idQ != null) {
            this.idQ.pb(true);
            this.idQ.V(true, z);
        }
        AlaStatManager.getInstance().forceUpload();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.idQ != null && this.idQ.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.idQ != null) {
            this.idQ.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.idQ != null) {
            this.idQ.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqk() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.idQ != null) {
                        a.this.idQ.nN(true);
                        a.this.idQ.cqD();
                        a.this.idQ.cqm();
                    }
                }
            }, 1L);
        }
    }

    public void b(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        com.baidu.live.ah.a.b.Tq().release();
        ac.HZ();
        com.baidu.live.entereffect.a.FB().release();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            HKStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.idQ != null ? this.idQ.NL() : "");
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            QMStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.idQ != null ? this.idQ.NL() : "");
        }
        if (this.idQ != null) {
            this.idQ.cqU();
        }
        if (this.idP != null) {
            this.idP.a(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    public void onDestroy() {
        if (this.idS) {
            MessageManager.getInstance().unRegisterListener(this.idT);
            MessageManager.getInstance().unRegisterListener(this.hGB);
            MessageManager.getInstance().unRegisterListener(this.hpc);
            MessageManager.getInstance().unRegisterListener(this.idU);
            MessageManager.getInstance().unRegisterListener(this.bDh);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_IS_MIX);
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
            this.globalListener = null;
            if (this.idQ != null) {
                this.idQ.destroy();
                this.idQ = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }
}
