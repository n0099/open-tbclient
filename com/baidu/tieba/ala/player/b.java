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
import com.baidu.live.gift.s;
import com.baidu.live.r.a;
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
/* loaded from: classes2.dex */
public class b {
    private int eem;
    private ViewTreeObserver.OnGlobalLayoutListener eeo;
    private d fvG;
    private c fvH;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler();
    private boolean ahn = false;
    private boolean mUseStyleImmersiveSticky = false;
    private volatile boolean isBackground = false;
    private boolean een = true;
    private boolean fvI = false;
    private int fvJ = -1;
    private CustomMessageListener faE = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.player.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && b.this.fvH != null) {
                b.this.fvH.F(false, true);
            }
        }
    };
    private CustomMessageListener fvK = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.ala.player.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fvH != null) {
                b.this.fvH.jY(false);
                b.this.fvH.beQ();
            }
        }
    };
    private CustomMessageListener eKK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.player.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.netType() != b.this.fvJ) {
                b.this.fvJ = BdNetTypeUtil.netType();
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    if (b.this.getPageContext() != null) {
                        b.this.getPageContext().showToast(b.this.getPageContext().getPageActivity().getString(a.i.ala_create_no_network));
                    }
                    if (b.this.fvH != null) {
                        b.this.fvH.onStop();
                    }
                } else if (BdNetTypeUtil.isMobileNet()) {
                    if (k.yH() && b.this.fvH != null) {
                        b.this.fvH.onStop();
                        b.this.fvH.brF();
                    }
                } else if (BdNetTypeUtil.isWifiNet()) {
                    if (b.this.fvH != null) {
                        b.this.fvH.brG();
                        b.this.fvH.onStart();
                        b.this.fvH.brJ();
                    }
                    b.this.getPageContext().showToast(b.this.getPageContext().getResources().getString(a.i.ala_watch_live_user_has_change_to_wifi));
                }
            }
        }
    };
    private CustomMessageListener fvL = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.player.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                b.this.bre();
            }
        }
    };
    private CustomMessageListener faF = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.player.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                b.this.blC();
            }
        }
    };

    public b(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.fvG = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    public void init() {
        this.isBackground = false;
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.fvI = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.i.ala_master_on_live_no_watch_other_live);
            a(false, false, -1L);
            return;
        }
        this.fvI = true;
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        MessageManager.getInstance().registerListener(this.faE);
        MessageManager.getInstance().registerListener(this.fvK);
        MessageManager.getInstance().registerListener(this.eKK);
        MessageManager.getInstance().registerListener(this.fvL);
        MessageManager.getInstance().registerListener(this.faF);
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
            blB();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.fvH = new c(getPageContext(), this);
            this.fvH.ag(intent);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
        a(false, false, -1L);
    }

    private void blB() {
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
        if (this.fvH != null) {
            this.fvH.bN(getPageContext().getPageActivity().getResources().getConfiguration().orientation);
        }
    }

    private void addGlobalLayoutListener() {
        this.eeo = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                b.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(b.this.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(b.this.getPageContext().getPageActivity());
                boolean z = b.this.eem != rect.bottom;
                b.this.eem = rect.bottom;
                if (b.this.mLastScreenHeight != screenFullSize[1]) {
                    if (b.this.fvH != null) {
                        b.this.fvH.brx();
                    }
                    b.this.mLastScreenHeight = screenFullSize[1];
                } else if (b.this.mLastScreenWidth != screenFullSize[0]) {
                    if (b.this.fvH != null) {
                        b.this.fvH.brx();
                    }
                    b.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!b.this.ahn || z) && b.this.een)) {
                    b.this.ahn = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    b.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && b.this.ahn) {
                    b.this.ahn = false;
                    b.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eeo);
    }

    public void onWindowFocusChanged(boolean z) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity());
        if (this.fvH != null) {
            if (realScreenOrientation == 2) {
                this.fvH.bry();
            } else {
                this.fvH.brz();
            }
        }
    }

    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.een = true;
        if (this.fvH != null) {
            this.fvH.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blC() {
        boolean isNetWorkAvailable = BdNetTypeUtil.isNetWorkAvailable();
        boolean yH = k.yH();
        if (isNetWorkAvailable && !BdNetTypeUtil.isWifiNet() && yH) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_create_not_wifi));
        }
    }

    public void onStart() {
        if ((this.fvH == null || !this.fvH.brH()) && this.fvH != null) {
            this.fvH.onStart();
        }
    }

    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.fvI) {
            this.een = false;
            if (this.fvH != null) {
                this.fvH.onPause();
            }
        }
    }

    public void onStop() {
        if (this.fvH != null) {
            this.fvH.onStop();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.fvH != null && this.fvH.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fvH != null) {
            this.fvH.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fvH != null) {
            this.fvH.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bre() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fvH != null) {
                        b.this.fvH.iT(true);
                        b.this.fvH.brp();
                        b.this.fvH.brf();
                    }
                }
            }, 1L);
        }
    }

    public void a(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        s.rC();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            HKStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.fvH != null ? this.fvH.vz() : "");
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            QMStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.fvH != null ? this.fvH.vz() : "");
        }
        if (this.fvH != null) {
            this.fvH.brE();
        }
        if (this.fvG != null) {
            this.fvG.b(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    public void onDestroy() {
        if (this.fvI) {
            MessageManager.getInstance().unRegisterListener(this.fvK);
            MessageManager.getInstance().unRegisterListener(this.faE);
            MessageManager.getInstance().unRegisterListener(this.eKK);
            MessageManager.getInstance().unRegisterListener(this.fvL);
            MessageManager.getInstance().unRegisterListener(this.faF);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eeo);
            this.eeo = null;
            if (this.fvH != null) {
                this.fvH.destroy();
                this.fvH = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }
}
