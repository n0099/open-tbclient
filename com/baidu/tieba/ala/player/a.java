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
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.gift.v;
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
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveRoomResponsedMessage;
/* loaded from: classes7.dex */
public class a {
    private int availableHeight;
    private c gXv;
    private b gXw;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler();
    private boolean mIsKeyboardOpen = false;
    private boolean fuK = true;
    private boolean gXx = false;
    private int gBL = -1;
    private CustomMessageListener gBN = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.player.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && a.this.gXw != null) {
                a.this.gXw.P(false, true);
            }
        }
    };
    private CustomMessageListener gXy = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.ala.player.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.gXw != null) {
                a.this.gXw.mT(false);
                a.this.gXw.bLV();
            }
        }
    };
    private CustomMessageListener gkC = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.player.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int netType = BdNetTypeUtil.netType();
            if (netType != a.this.gBL) {
                a.this.gBL = netType;
                NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                if (netWorkChangedMessage.mLastNetState != netType || !BdNetTypeUtil.isWifiNet() || netWorkChangedMessage.mlastChangedTime != 0) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        a.this.bTe();
                        if (a.this.gXw != null) {
                            a.this.gXw.Q(false, false);
                            return;
                        }
                        return;
                    }
                    if (BdNetTypeUtil.isMobileNet() && k.Pj()) {
                        a.this.bTd();
                    } else if (BdNetTypeUtil.isWifiNet()) {
                        a.this.bTf();
                    }
                    if (a.this.gXw != null) {
                        a.this.gXw.onStart();
                        a.this.gXw.bZN();
                    }
                }
            }
        }
    };
    private CustomMessageListener gXz = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.player.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                a.this.bZd();
            }
        }
    };
    private CustomMessageListener bre = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.player.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    a.this.bTe();
                    if (a.this.gXw != null) {
                        a.this.gXw.Q(false, false);
                    }
                } else if (a.this.gXw != null) {
                    if (a.this.gXw.bZx()) {
                        if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && BdNetTypeUtil.isMobileNet() && k.Pj()) {
                            TbadkCoreApplication.isShownNetChangeDialog = true;
                            a.this.bTd();
                        }
                    } else if (BdNetTypeUtil.isMobileNet() && k.Pj()) {
                        a.this.bTd();
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.gXv = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    public void init() {
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.gXx = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.i.ala_master_on_live_no_watch_other_live);
            a(false, false, -1L);
            return;
        }
        this.gXx = true;
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        MessageManager.getInstance().registerListener(this.gBN);
        MessageManager.getInstance().registerListener(this.gXy);
        MessageManager.getInstance().registerListener(this.gkC);
        MessageManager.getInstance().registerListener(this.gXz);
        MessageManager.getInstance().registerListener(this.bre);
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
            bSY();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.gXw = new b(getPageContext(), this);
            this.gXw.S(intent);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
        a(false, false, -1L);
    }

    private void bSY() {
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
        if (this.gXw != null) {
            int i = getPageContext().getPageActivity().getResources().getConfiguration().orientation;
            if (i == 0 && configuration != null) {
                i = configuration.orientation;
            }
            this.gXw.dz(i);
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
                    if (a.this.gXw != null) {
                        a.this.gXw.bZE();
                    }
                    a.this.mLastScreenHeight = screenFullSize[1];
                } else if (a.this.mLastScreenWidth != screenFullSize[0]) {
                    if (a.this.gXw != null) {
                        a.this.gXw.bZE();
                    }
                    a.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!a.this.mIsKeyboardOpen || z) && a.this.fuK)) {
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
        if (this.gXw != null) {
            if (realScreenOrientation == 2) {
                this.gXw.bZF();
            } else {
                this.gXw.bZG();
            }
        }
    }

    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.fuK = true;
        if (this.gXw != null) {
            this.gXw.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTf() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.ala_watch_live_user_has_change_to_wifi));
        }
    }

    public void bTd() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_watch_live_mobile_net_tip));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTe() {
        if (getPageContext() != null) {
            getPageContext().showToast(getPageContext().getPageActivity().getString(a.i.ala_create_no_network));
        }
    }

    public void mR(boolean z) {
        if (this.gXw != null) {
            this.gXw.mR(z);
        }
    }

    public void onStart() {
        if (this.gXw != null) {
            this.gXw.mV(false);
            this.gXw.onStart();
        }
    }

    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.gXx) {
            this.fuK = false;
            if (this.gXw != null) {
                this.gXw.onPause();
            }
        }
    }

    public void mS(boolean z) {
        if (this.gXw != null) {
            this.gXw.mV(true);
            this.gXw.Q(true, z);
        }
        AlaStatManager.getInstance().forceUpload();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.gXw != null && this.gXw.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gXw != null) {
            this.gXw.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gXw != null) {
            this.gXw.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZd() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gXw != null) {
                        a.this.gXw.lM(true);
                        a.this.gXw.bZw();
                        a.this.gXw.bZf();
                    }
                }
            }, 1L);
        }
    }

    public void a(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        v.EY();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            HKStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.gXw != null ? this.gXw.JY() : "");
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            QMStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.gXw != null ? this.gXw.JY() : "");
        }
        if (this.gXw != null) {
            this.gXw.bZM();
        }
        if (this.gXv != null) {
            this.gXv.b(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    public void onDestroy() {
        if (this.gXx) {
            MessageManager.getInstance().unRegisterListener(this.gXy);
            MessageManager.getInstance().unRegisterListener(this.gBN);
            MessageManager.getInstance().unRegisterListener(this.gkC);
            MessageManager.getInstance().unRegisterListener(this.gXz);
            MessageManager.getInstance().unRegisterListener(this.bre);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
            this.globalListener = null;
            if (this.gXw != null) {
                this.gXw.destroy();
                this.gXw = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }
}
