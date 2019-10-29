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
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.q;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveRoomResponsedMessage;
/* loaded from: classes6.dex */
public class b {
    private ViewTreeObserver.OnGlobalLayoutListener dLS;
    private d eBN;
    private c eBO;
    private int eiE;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private BdAlertDialog mNetChangedDialog;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler();
    private boolean YX = false;
    private boolean mUseStyleImmersiveSticky = false;
    private volatile boolean isBackground = false;
    private boolean dLR = true;
    private boolean eBP = false;
    private CustomMessageListener eiK = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.player.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && b.this.eBO != null) {
                b.this.eBO.F(false, true);
            }
        }
    };
    private CustomMessageListener eBQ = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.ala.player.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eBO != null) {
                b.this.eBO.iw(false);
            }
        }
    };
    private CustomMessageListener dUL = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.player.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = true;
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                if (b.this.getPageContext() != null) {
                    b.this.getPageContext().showToast(b.this.getPageContext().getPageActivity().getString(a.i.ala_create_no_network));
                }
                if (b.this.eBO != null) {
                    b.this.eBO.onStop();
                }
            } else if (BdNetTypeUtil.isMobileNet()) {
                if (b.this.eBO != null) {
                    b.this.eBO.onStop();
                }
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isTieba()) {
                    IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
                    if (buildParamsExtra != null) {
                        z = buildParamsExtra.isShouldShowNotWifiToastByAudience();
                    }
                } else if (ExtraParamsManager.getSaveFlowStatus()) {
                    z = false;
                }
                if (z) {
                    if (b.this.mNetChangedDialog == null) {
                        b.this.mNetChangedDialog = new BdAlertDialog(b.this.getPageContext().getPageActivity());
                        b.this.mNetChangedDialog.setCanceledOnTouchOutside(false);
                        b.this.mNetChangedDialog.setMessage(b.this.getPageContext().getResources().getString(a.i.ala_watch_live_user_4G_tip));
                        b.this.mNetChangedDialog.setPositiveButton(b.this.getPageContext().getResources().getString(a.i.ala_watch_live_user_4G_continue), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.3.1
                            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                            public void onClick(BdAlertDialog bdAlertDialog) {
                                if (b.this.eBO != null) {
                                    b.this.eBO.onStart();
                                }
                                b.this.mNetChangedDialog.dismiss();
                            }
                        });
                        b.this.mNetChangedDialog.setNegativeButton(b.this.getPageContext().getResources().getString(a.i.ala_watch_live_user_4G_quit), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.3.2
                            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                            public void onClick(BdAlertDialog bdAlertDialog) {
                                if (b.this.eBO != null) {
                                    b.this.eBO.iw(false);
                                }
                                b.this.mNetChangedDialog.dismiss();
                            }
                        });
                        b.this.mNetChangedDialog = b.this.mNetChangedDialog.create(b.this.mPageContext);
                    }
                    if (b.this.mNetChangedDialog != null && !b.this.mNetChangedDialog.isShowing()) {
                        b.this.mNetChangedDialog.show();
                    }
                } else if (b.this.eBO != null) {
                    b.this.eBO.onStart();
                }
            } else if (BdNetTypeUtil.isWifiNet()) {
                if (b.this.mNetChangedDialog != null) {
                    b.this.mNetChangedDialog.hide();
                }
                if (b.this.eBO != null) {
                    b.this.eBO.onStart();
                }
                b.this.getPageContext().showToast(b.this.getPageContext().getResources().getString(a.i.ala_watch_live_user_has_change_to_wifi));
            }
        }
    };
    private CustomMessageListener eBR = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.player.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                b.this.aYj();
            }
        }
    };
    private CustomMessageListener eiL = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.player.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                b.this.aSV();
            }
        }
    };

    public b(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.eBN = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    public void init() {
        this.isBackground = false;
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.eBP = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.i.ala_master_on_live_no_watch_other_live);
            a(false, false, -1L);
            return;
        }
        this.eBP = true;
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        MessageManager.getInstance().registerListener(this.eiK);
        MessageManager.getInstance().registerListener(this.eBQ);
        MessageManager.getInstance().registerListener(this.dUL);
        MessageManager.getInstance().registerListener(this.eBR);
        MessageManager.getInstance().registerListener(this.eiL);
        this.mUseStyleImmersiveSticky = UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        getPageContext().getPageActivity().getWindow().addFlags(128);
        addGlobalLayoutListener();
        initData();
    }

    private void initData() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        if (!UtilHelper.isARM()) {
            aSU();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.eBO = new c(getPageContext(), this);
            this.eBO.an(intent);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
        a(false, false, -1L);
    }

    private void aSU() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(getPageContext().getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.live_not_support_msg);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.a(false, false, -1L);
            }
        });
        bdAlertDialog.create(getPageContext()).show();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.eBO != null) {
            this.eBO.bw(getPageContext().getPageActivity().getResources().getConfiguration().orientation);
        }
    }

    private void addGlobalLayoutListener() {
        this.dLS = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                b.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(b.this.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(b.this.getPageContext().getPageActivity());
                boolean z = b.this.eiE != rect.bottom;
                b.this.eiE = rect.bottom;
                if (b.this.mLastScreenHeight != screenFullSize[1]) {
                    if (b.this.eBO != null) {
                        b.this.eBO.aYB();
                    }
                    b.this.mLastScreenHeight = screenFullSize[1];
                } else if (b.this.mLastScreenWidth != screenFullSize[0]) {
                    if (b.this.eBO != null) {
                        b.this.eBO.aYB();
                    }
                    b.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!b.this.YX || z) && b.this.dLR)) {
                    b.this.YX = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    b.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && b.this.YX) {
                    b.this.YX = false;
                    b.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.dLS);
    }

    public void onWindowFocusChanged(boolean z) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity());
        if (this.eBO != null) {
            if (realScreenOrientation == 2) {
                this.eBO.aYC();
            } else {
                this.eBO.aYD();
            }
        }
    }

    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.dLR = true;
        if (this.eBO != null) {
            this.eBO.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSV() {
        boolean z = true;
        boolean isNetWorkAvailable = BdNetTypeUtil.isNetWorkAvailable();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isTieba()) {
            IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
            if (buildParamsExtra != null) {
                z = buildParamsExtra.isShouldShowNotWifiToastByAudience();
            }
        } else if (ExtraParamsManager.getSaveFlowStatus()) {
            z = false;
        }
        if (isNetWorkAvailable && !BdNetTypeUtil.isWifiNet() && z) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_create_not_wifi));
        }
    }

    public void onStart() {
        if ((this.mNetChangedDialog == null || !this.mNetChangedDialog.isShowing()) && this.eBO != null) {
            this.eBO.onStart();
        }
    }

    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.eBP) {
            this.dLR = false;
            if (this.eBO != null) {
                this.eBO.onPause();
            }
        }
    }

    public void onStop() {
        if (this.eBO != null) {
            this.eBO.onStop();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.eBO != null && this.eBO.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eBO != null) {
            this.eBO.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eBO != null) {
            this.eBO.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYj() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.eBO != null) {
                        b.this.eBO.hy(true);
                        b.this.eBO.aYt();
                        b.this.eBO.aYk();
                    }
                }
            }, 1L);
        }
    }

    public void a(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        q.pO();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            HKStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.eBO != null ? this.eBO.tm() : "");
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            QMStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.eBO != null ? this.eBO.tm() : "");
        }
        this.eBO.aYI();
        if (this.eBN != null) {
            this.eBN.b(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    public void onDestroy() {
        if (this.eBP) {
            MessageManager.getInstance().unRegisterListener(this.eBQ);
            MessageManager.getInstance().unRegisterListener(this.eiK);
            MessageManager.getInstance().unRegisterListener(this.dUL);
            MessageManager.getInstance().unRegisterListener(this.eBR);
            MessageManager.getInstance().unRegisterListener(this.eiL);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.dLS);
            this.dLS = null;
            if (this.eBO != null) {
                this.eBO.destroy();
                this.eBO = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }
}
