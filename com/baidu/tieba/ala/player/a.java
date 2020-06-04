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
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.v;
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
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveRoomResponsedMessage;
/* loaded from: classes3.dex */
public class a {
    private int availableHeight;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private c gsI;
    private b gsJ;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler();
    private boolean mIsKeyboardOpen = false;
    private boolean eVu = true;
    private boolean gsK = false;
    private int fWZ = -1;
    private CustomMessageListener fXb = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.player.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && a.this.gsJ != null) {
                a.this.gsJ.K(false, true);
            }
        }
    };
    private CustomMessageListener gsL = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.ala.player.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.gsJ != null) {
                a.this.gsJ.lC(false);
                a.this.gsJ.bwr();
            }
        }
    };
    private CustomMessageListener fIc = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.player.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType = BdNetTypeUtil.netType();
            if (netType != a.this.fWZ) {
                a.this.fWZ = netType;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    a.this.bCO();
                    if (a.this.gsJ != null) {
                        a.this.gsJ.lD(false);
                        return;
                    }
                    return;
                }
                if (BdNetTypeUtil.isMobileNet() && k.HX()) {
                    a.this.bCN();
                } else if (BdNetTypeUtil.isWifiNet()) {
                    a.this.bCP();
                }
                if (a.this.gsJ != null) {
                    a.this.gsJ.onStart();
                    a.this.gsJ.bJq();
                }
            }
        }
    };
    private CustomMessageListener gsM = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.player.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                a.this.bIP();
            }
        }
    };
    private CustomMessageListener bfX = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.player.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    a.this.bCO();
                    if (a.this.gsJ != null) {
                        a.this.gsJ.lD(false);
                    }
                } else if (a.this.gsJ != null) {
                    if (a.this.gsJ.bJb()) {
                        if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && BdNetTypeUtil.isMobileNet() && k.HX()) {
                            TbadkCoreApplication.isShownNetChangeDialog = true;
                            a.this.bCN();
                        }
                    } else if (BdNetTypeUtil.isMobileNet() && k.HX()) {
                        a.this.bCN();
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.gsI = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    public void init() {
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.gsK = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.i.ala_master_on_live_no_watch_other_live);
            a(false, false, -1L);
            return;
        }
        this.gsK = true;
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        MessageManager.getInstance().registerListener(this.fXb);
        MessageManager.getInstance().registerListener(this.gsL);
        MessageManager.getInstance().registerListener(this.fIc);
        MessageManager.getInstance().registerListener(this.gsM);
        MessageManager.getInstance().registerListener(this.bfX);
        UtilHelper.useNavigationBarStyleImmersiveSticky(getPageContext().getPageActivity());
        getPageContext().getPageActivity().getWindow().addFlags(128);
        addGlobalLayoutListener();
        initData();
    }

    private void initData() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        this.mLastScreenHeight = screenDimensions[1];
        this.mLastScreenWidth = screenDimensions[0];
        if (!UtilHelper.isARM()) {
            bCI();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.gsJ = new b(getPageContext(), this);
            this.gsJ.P(intent);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
        a(false, false, -1L);
    }

    private void bCI() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(getPageContext().getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.live_not_support_msg);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.a.6
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                a.this.a(false, false, -1L);
            }
        });
        bdAlertDialog.create(getPageContext()).show();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.gsJ != null) {
            this.gsJ.cu(getPageContext().getPageActivity().getResources().getConfiguration().orientation);
        }
    }

    private void addGlobalLayoutListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.player.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(a.this.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(a.this.getPageContext().getPageActivity());
                boolean z = a.this.availableHeight != rect.bottom;
                a.this.availableHeight = rect.bottom;
                if (a.this.mLastScreenHeight != screenFullSize[1]) {
                    if (a.this.gsJ != null) {
                        a.this.gsJ.bJj();
                    }
                    a.this.mLastScreenHeight = screenFullSize[1];
                } else if (a.this.mLastScreenWidth != screenFullSize[0]) {
                    if (a.this.gsJ != null) {
                        a.this.gsJ.bJj();
                    }
                    a.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!a.this.mIsKeyboardOpen || z) && a.this.eVu)) {
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
        if (this.gsJ != null) {
            if (realScreenOrientation == 2) {
                this.gsJ.bJk();
            } else {
                this.gsJ.bJl();
            }
        }
    }

    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.eVu = true;
        if (this.gsJ != null) {
            this.gsJ.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCP() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.ala_watch_live_user_has_change_to_wifi));
        }
    }

    public void bCN() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_watch_live_mobile_net_tip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCO() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getString(a.i.ala_create_no_network));
        }
    }

    public void onStart() {
        if (this.gsJ != null) {
            this.gsJ.onStart();
        }
    }

    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.gsK) {
            this.eVu = false;
            if (this.gsJ != null) {
                this.gsJ.onPause();
            }
        }
    }

    public void onStop() {
        if (this.gsJ != null) {
            this.gsJ.lD(true);
        }
        AlaStatManager.getInstance().forceUpload();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.gsJ != null && this.gsJ.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gsJ != null) {
            this.gsJ.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gsJ != null) {
            this.gsJ.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIP() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gsJ != null) {
                        a.this.gsJ.kw(true);
                        a.this.gsJ.bJa();
                        a.this.gsJ.bIQ();
                    }
                }
            }, 1L);
        }
    }

    public void a(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        v.yt();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            HKStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.gsJ != null ? this.gsJ.DN() : "");
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            QMStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.gsJ != null ? this.gsJ.DN() : "");
        }
        if (this.gsJ != null) {
            this.gsJ.bJp();
        }
        if (this.gsI != null) {
            this.gsI.b(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    public void onDestroy() {
        if (this.gsK) {
            MessageManager.getInstance().unRegisterListener(this.gsL);
            MessageManager.getInstance().unRegisterListener(this.fXb);
            MessageManager.getInstance().unRegisterListener(this.fIc);
            MessageManager.getInstance().unRegisterListener(this.gsM);
            MessageManager.getInstance().unRegisterListener(this.bfX);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
            this.globalListener = null;
            if (this.gsJ != null) {
                this.gsJ.destroy();
                this.gsJ = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }
}
