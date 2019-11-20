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
    private ViewTreeObserver.OnGlobalLayoutListener dLb;
    private d eAW;
    private c eAX;
    private int ehN;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private BdAlertDialog mNetChangedDialog;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler();
    private boolean YF = false;
    private boolean mUseStyleImmersiveSticky = false;
    private volatile boolean isBackground = false;
    private boolean dLa = true;
    private boolean eAY = false;
    private CustomMessageListener ehT = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.player.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && b.this.eAX != null) {
                b.this.eAX.F(false, true);
            }
        }
    };
    private CustomMessageListener eAZ = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.ala.player.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eAX != null) {
                b.this.eAX.iw(false);
            }
        }
    };
    private CustomMessageListener dTU = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.player.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = true;
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                if (b.this.getPageContext() != null) {
                    b.this.getPageContext().showToast(b.this.getPageContext().getPageActivity().getString(a.i.ala_create_no_network));
                }
                if (b.this.eAX != null) {
                    b.this.eAX.onStop();
                }
            } else if (BdNetTypeUtil.isMobileNet()) {
                if (b.this.eAX != null) {
                    b.this.eAX.onStop();
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
                                if (b.this.eAX != null) {
                                    b.this.eAX.onStart();
                                }
                                b.this.mNetChangedDialog.dismiss();
                            }
                        });
                        b.this.mNetChangedDialog.setNegativeButton(b.this.getPageContext().getResources().getString(a.i.ala_watch_live_user_4G_quit), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.3.2
                            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                            public void onClick(BdAlertDialog bdAlertDialog) {
                                if (b.this.eAX != null) {
                                    b.this.eAX.iw(false);
                                }
                                b.this.mNetChangedDialog.dismiss();
                            }
                        });
                        b.this.mNetChangedDialog = b.this.mNetChangedDialog.create(b.this.mPageContext);
                    }
                    if (b.this.mNetChangedDialog != null && !b.this.mNetChangedDialog.isShowing()) {
                        b.this.mNetChangedDialog.show();
                    }
                } else if (b.this.eAX != null) {
                    b.this.eAX.onStart();
                }
            } else if (BdNetTypeUtil.isWifiNet()) {
                if (b.this.mNetChangedDialog != null) {
                    b.this.mNetChangedDialog.hide();
                }
                if (b.this.eAX != null) {
                    b.this.eAX.onStart();
                }
                b.this.getPageContext().showToast(b.this.getPageContext().getResources().getString(a.i.ala_watch_live_user_has_change_to_wifi));
            }
        }
    };
    private CustomMessageListener eBa = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.player.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                b.this.aYh();
            }
        }
    };
    private CustomMessageListener ehU = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.player.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                b.this.aST();
            }
        }
    };

    public b(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.eAW = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    public void init() {
        this.isBackground = false;
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.eAY = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.i.ala_master_on_live_no_watch_other_live);
            a(false, false, -1L);
            return;
        }
        this.eAY = true;
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        MessageManager.getInstance().registerListener(this.ehT);
        MessageManager.getInstance().registerListener(this.eAZ);
        MessageManager.getInstance().registerListener(this.dTU);
        MessageManager.getInstance().registerListener(this.eBa);
        MessageManager.getInstance().registerListener(this.ehU);
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
            aSS();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.eAX = new c(getPageContext(), this);
            this.eAX.an(intent);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
        a(false, false, -1L);
    }

    private void aSS() {
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
        if (this.eAX != null) {
            this.eAX.bw(getPageContext().getPageActivity().getResources().getConfiguration().orientation);
        }
    }

    private void addGlobalLayoutListener() {
        this.dLb = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                b.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(b.this.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(b.this.getPageContext().getPageActivity());
                boolean z = b.this.ehN != rect.bottom;
                b.this.ehN = rect.bottom;
                if (b.this.mLastScreenHeight != screenFullSize[1]) {
                    if (b.this.eAX != null) {
                        b.this.eAX.aYz();
                    }
                    b.this.mLastScreenHeight = screenFullSize[1];
                } else if (b.this.mLastScreenWidth != screenFullSize[0]) {
                    if (b.this.eAX != null) {
                        b.this.eAX.aYz();
                    }
                    b.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!b.this.YF || z) && b.this.dLa)) {
                    b.this.YF = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    b.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && b.this.YF) {
                    b.this.YF = false;
                    b.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.dLb);
    }

    public void onWindowFocusChanged(boolean z) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity());
        if (this.eAX != null) {
            if (realScreenOrientation == 2) {
                this.eAX.aYA();
            } else {
                this.eAX.aYB();
            }
        }
    }

    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.dLa = true;
        if (this.eAX != null) {
            this.eAX.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aST() {
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
        if ((this.mNetChangedDialog == null || !this.mNetChangedDialog.isShowing()) && this.eAX != null) {
            this.eAX.onStart();
        }
    }

    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.eAY) {
            this.dLa = false;
            if (this.eAX != null) {
                this.eAX.onPause();
            }
        }
    }

    public void onStop() {
        if (this.eAX != null) {
            this.eAX.onStop();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.eAX != null && this.eAX.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eAX != null) {
            this.eAX.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eAX != null) {
            this.eAX.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYh() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.eAX != null) {
                        b.this.eAX.hy(true);
                        b.this.eAX.aYr();
                        b.this.eAX.aYi();
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
            HKStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.eAX != null ? this.eAX.tn() : "");
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            QMStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.eAX != null ? this.eAX.tn() : "");
        }
        this.eAX.aYG();
        if (this.eAW != null) {
            this.eAW.b(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    public void onDestroy() {
        if (this.eAY) {
            MessageManager.getInstance().unRegisterListener(this.eAZ);
            MessageManager.getInstance().unRegisterListener(this.ehT);
            MessageManager.getInstance().unRegisterListener(this.dTU);
            MessageManager.getInstance().unRegisterListener(this.eBa);
            MessageManager.getInstance().unRegisterListener(this.ehU);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.dLb);
            this.dLb = null;
            if (this.eAX != null) {
                this.eAX.destroy();
                this.eAX = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }
}
