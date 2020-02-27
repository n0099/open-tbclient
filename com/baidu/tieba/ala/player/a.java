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
    private int eip;
    private ViewTreeObserver.OnGlobalLayoutListener eir;
    private c fyb;
    private b fyc;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler();
    private boolean ajw = false;
    private boolean mUseStyleImmersiveSticky = false;
    private volatile boolean isBackground = false;
    private boolean eiq = true;
    private boolean fyd = false;
    private int fye = -1;
    private CustomMessageListener fdQ = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.player.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && a.this.fyc != null) {
                a.this.fyc.H(false, true);
            }
        }
    };
    private CustomMessageListener fyf = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.ala.player.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.fyc != null) {
                a.this.fyc.jZ(false);
                a.this.fyc.bha();
            }
        }
    };
    private CustomMessageListener eOJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.player.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.netType() != a.this.fye) {
                a.this.fye = BdNetTypeUtil.netType();
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    if (a.this.getPageContext() != null) {
                        a.this.getPageContext().showToast(a.this.getPageContext().getPageActivity().getString(a.i.ala_create_no_network));
                    }
                    if (a.this.fyc != null) {
                        a.this.fyc.onStop();
                    }
                } else if (BdNetTypeUtil.isMobileNet()) {
                    if (k.AY()) {
                        if (!TbadkCoreApplication.getInst().isMobileBaidu() || (TbadkCoreApplication.getInst().isMobileBaidu() && !TbadkCoreApplication.isShownNetChangeDialog.booleanValue())) {
                            if (a.this.fyc != null) {
                                a.this.fyc.onStop();
                                a.this.fyc.btf();
                            } else if (a.this.fyc != null) {
                                a.this.fyc.btg();
                                a.this.fyc.onStart();
                                a.this.fyc.btj();
                            }
                        }
                    }
                } else if (BdNetTypeUtil.isWifiNet()) {
                    if (a.this.fyc != null) {
                        a.this.fyc.btg();
                        a.this.fyc.onStart();
                        a.this.fyc.btj();
                    }
                    if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                        a.this.getPageContext().showToast(a.this.getPageContext().getResources().getString(a.i.ala_watch_live_user_has_change_to_wifi));
                    }
                }
            }
        }
    };
    private CustomMessageListener fyg = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.player.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                a.this.bsE();
            }
        }
    };
    private CustomMessageListener fdR = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.player.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
                a.this.bnk();
            }
        }
    };

    public a(TbPageContext tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.fyb = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    public void init() {
        this.isBackground = false;
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.fyd = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.i.ala_master_on_live_no_watch_other_live);
            a(false, false, -1L);
            return;
        }
        this.fyd = true;
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        MessageManager.getInstance().registerListener(this.fdQ);
        MessageManager.getInstance().registerListener(this.fyf);
        MessageManager.getInstance().registerListener(this.eOJ);
        MessageManager.getInstance().registerListener(this.fyg);
        MessageManager.getInstance().registerListener(this.fdR);
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
            bnj();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.fyc = new b(getPageContext(), this);
            this.fyc.ag(intent);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
        a(false, false, -1L);
    }

    private void bnj() {
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
        if (this.fyc != null) {
            this.fyc.bW(getPageContext().getPageActivity().getResources().getConfiguration().orientation);
        }
    }

    private void addGlobalLayoutListener() {
        this.eir = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.player.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(a.this.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(a.this.getPageContext().getPageActivity());
                boolean z = a.this.eip != rect.bottom;
                a.this.eip = rect.bottom;
                if (a.this.mLastScreenHeight != screenFullSize[1]) {
                    if (a.this.fyc != null) {
                        a.this.fyc.bsX();
                    }
                    a.this.mLastScreenHeight = screenFullSize[1];
                } else if (a.this.mLastScreenWidth != screenFullSize[0]) {
                    if (a.this.fyc != null) {
                        a.this.fyc.bsX();
                    }
                    a.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!a.this.ajw || z) && a.this.eiq)) {
                    a.this.ajw = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && a.this.ajw) {
                    a.this.ajw = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eir);
    }

    public void onWindowFocusChanged(boolean z) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity());
        if (this.fyc != null) {
            if (realScreenOrientation == 2) {
                this.fyc.bsY();
            } else {
                this.fyc.bsZ();
            }
        }
    }

    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.eiq = true;
        if (this.fyc != null) {
            this.fyc.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnk() {
        boolean isNetWorkAvailable = BdNetTypeUtil.isNetWorkAvailable();
        boolean AY = k.AY();
        if (isNetWorkAvailable && !BdNetTypeUtil.isWifiNet() && AY) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_create_not_wifi));
        }
    }

    public void onStart() {
        if ((this.fyc == null || !this.fyc.bth()) && this.fyc != null) {
            this.fyc.onStart();
        }
    }

    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.fyd) {
            this.eiq = false;
            if (this.fyc != null) {
                this.fyc.onPause();
            }
        }
    }

    public void onStop() {
        if (this.fyc != null) {
            this.fyc.onStop();
        }
        AlaStatManager.getInstance().forceUpload();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.fyc != null && this.fyc.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fyc != null) {
            this.fyc.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fyc != null) {
            this.fyc.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsE() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.a.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.fyc != null) {
                        a.this.fyc.iZ(true);
                        a.this.fyc.bsP();
                        a.this.fyc.bsF();
                    }
                }
            }, 1L);
        }
    }

    public void a(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        t.sH();
        com.baidu.live.entereffect.a.qR().release();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            HKStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.fyc != null ? this.fyc.xx() : "");
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            QMStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.fyc != null ? this.fyc.xx() : "");
        }
        if (this.fyc != null) {
            this.fyc.bte();
        }
        if (this.fyb != null) {
            this.fyb.b(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    public void onDestroy() {
        if (this.fyd) {
            MessageManager.getInstance().unRegisterListener(this.fyf);
            MessageManager.getInstance().unRegisterListener(this.fdQ);
            MessageManager.getInstance().unRegisterListener(this.eOJ);
            MessageManager.getInstance().unRegisterListener(this.fyg);
            MessageManager.getInstance().unRegisterListener(this.fdR);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eir);
            this.eir = null;
            if (this.fyc != null) {
                this.fyc.destroy();
                this.fyc = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }
}
