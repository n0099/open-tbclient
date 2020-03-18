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
import com.baidu.live.gift.t;
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
    private int eiT;
    private ViewTreeObserver.OnGlobalLayoutListener eiV;
    private c fyV;
    private b fyW;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler();
    private boolean ajG = false;
    private boolean mUseStyleImmersiveSticky = false;
    private volatile boolean isBackground = false;
    private boolean eiU = true;
    private boolean fyX = false;
    private int fyY = -1;
    private CustomMessageListener feD = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.player.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && a.this.fyW != null) {
                a.this.fyW.H(false, true);
            }
        }
    };
    private CustomMessageListener fyZ = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.ala.player.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.fyW != null) {
                a.this.fyW.kc(false);
                a.this.fyW.bhi();
            }
        }
    };
    private CustomMessageListener ePv = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.player.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.netType() != a.this.fyY) {
                a.this.fyY = BdNetTypeUtil.netType();
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    if (a.this.getPageContext() != null) {
                        a.this.getPageContext().showToast(a.this.getPageContext().getPageActivity().getString(a.i.ala_create_no_network));
                    }
                    if (a.this.fyW != null) {
                        a.this.fyW.kd(false);
                    }
                } else if (BdNetTypeUtil.isMobileNet()) {
                    if (k.Bh()) {
                        if (!TbadkCoreApplication.getInst().isMobileBaidu() || (TbadkCoreApplication.getInst().isMobileBaidu() && !TbadkCoreApplication.isShownNetChangeDialog.booleanValue())) {
                            if (a.this.fyW != null) {
                                a.this.fyW.kd(false);
                                a.this.fyW.btn();
                            } else if (a.this.fyW != null) {
                                a.this.fyW.bto();
                                a.this.fyW.onStart();
                                a.this.fyW.btr();
                            }
                        }
                    }
                } else if (BdNetTypeUtil.isWifiNet()) {
                    if (a.this.fyW != null) {
                        a.this.fyW.bto();
                        a.this.fyW.onStart();
                        a.this.fyW.btr();
                    }
                    if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                        a.this.getPageContext().showToast(a.this.getPageContext().getResources().getString(a.i.ala_watch_live_user_has_change_to_wifi));
                    }
                }
            }
        }
    };
    private CustomMessageListener fza = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.player.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                a.this.bsN();
            }
        }
    };
    private CustomMessageListener feE = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.player.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
                a.this.bns();
            }
        }
    };

    public a(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.fyV = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    public void init() {
        this.isBackground = false;
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.fyX = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.i.ala_master_on_live_no_watch_other_live);
            a(false, false, -1L);
            return;
        }
        this.fyX = true;
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        MessageManager.getInstance().registerListener(this.feD);
        MessageManager.getInstance().registerListener(this.fyZ);
        MessageManager.getInstance().registerListener(this.ePv);
        MessageManager.getInstance().registerListener(this.fza);
        MessageManager.getInstance().registerListener(this.feE);
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
            bnr();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.fyW = new b(getPageContext(), this);
            this.fyW.ag(intent);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
        a(false, false, -1L);
    }

    private void bnr() {
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
        if (this.fyW != null) {
            this.fyW.bW(getPageContext().getPageActivity().getResources().getConfiguration().orientation);
        }
    }

    private void addGlobalLayoutListener() {
        this.eiV = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.player.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(a.this.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(a.this.getPageContext().getPageActivity());
                boolean z = a.this.eiT != rect.bottom;
                a.this.eiT = rect.bottom;
                if (a.this.mLastScreenHeight != screenFullSize[1]) {
                    if (a.this.fyW != null) {
                        a.this.fyW.btg();
                    }
                    a.this.mLastScreenHeight = screenFullSize[1];
                } else if (a.this.mLastScreenWidth != screenFullSize[0]) {
                    if (a.this.fyW != null) {
                        a.this.fyW.btg();
                    }
                    a.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!a.this.ajG || z) && a.this.eiU)) {
                    a.this.ajG = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && a.this.ajG) {
                    a.this.ajG = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eiV);
    }

    public void onWindowFocusChanged(boolean z) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity());
        if (this.fyW != null) {
            if (realScreenOrientation == 2) {
                this.fyW.bth();
            } else {
                this.fyW.bti();
            }
        }
    }

    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.eiU = true;
        if (this.fyW != null) {
            this.fyW.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bns() {
        boolean isNetWorkAvailable = BdNetTypeUtil.isNetWorkAvailable();
        boolean Bh = k.Bh();
        if (isNetWorkAvailable && !BdNetTypeUtil.isWifiNet() && Bh) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_create_not_wifi));
        }
    }

    public void onStart() {
        if ((this.fyW == null || !this.fyW.btp()) && this.fyW != null) {
            this.fyW.onStart();
        }
    }

    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.fyX) {
            this.eiU = false;
            if (this.fyW != null) {
                this.fyW.onPause();
            }
        }
    }

    public void onStop() {
        if (this.fyW != null) {
            this.fyW.kd(true);
        }
        AlaStatManager.getInstance().forceUpload();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.fyW != null && this.fyW.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fyW != null) {
            this.fyW.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fyW != null) {
            this.fyW.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsN() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fyW != null) {
                        a.this.fyW.jb(true);
                        a.this.fyW.bsY();
                        a.this.fyW.bsO();
                    }
                }
            }, 1L);
        }
    }

    public void a(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        t.sM();
        com.baidu.live.entereffect.a.qW().release();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            HKStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.fyW != null ? this.fyW.xC() : "");
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            QMStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.fyW != null ? this.fyW.xC() : "");
        }
        if (this.fyW != null) {
            this.fyW.btm();
        }
        if (this.fyV != null) {
            this.fyV.b(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    public void onDestroy() {
        if (this.fyX) {
            MessageManager.getInstance().unRegisterListener(this.fyZ);
            MessageManager.getInstance().unRegisterListener(this.feD);
            MessageManager.getInstance().unRegisterListener(this.ePv);
            MessageManager.getInstance().unRegisterListener(this.fza);
            MessageManager.getInstance().unRegisterListener(this.feE);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eiV);
            this.eiV = null;
            if (this.fyW != null) {
                this.fyW.destroy();
                this.fyW = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }
}
