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
import com.baidu.live.q.a;
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
    private int eee;
    private ViewTreeObserver.OnGlobalLayoutListener eeg;
    private d fsx;
    private c fsy;
    private int mLastScreenHeight;
    private int mLastScreenWidth;
    private TbPageContext mPageContext;
    private Handler mHandler = new Handler();
    private boolean agD = false;
    private boolean mUseStyleImmersiveSticky = false;
    private volatile boolean isBackground = false;
    private boolean eef = true;
    private boolean fsz = false;
    private int fsA = -1;
    private CustomMessageListener eYe = new CustomMessageListener(2913011, false) { // from class: com.baidu.tieba.ala.player.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaCloseLiveRoomResponsedMessage) && b.this.fsy != null) {
                b.this.fsy.F(false, true);
            }
        }
    };
    private CustomMessageListener fsB = new CustomMessageListener(2913086) { // from class: com.baidu.tieba.ala.player.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fsy != null) {
                b.this.fsy.jN(false);
            }
        }
    };
    private CustomMessageListener eJz = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.player.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.netType() != b.this.fsA) {
                b.this.fsA = BdNetTypeUtil.netType();
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    if (b.this.getPageContext() != null) {
                        b.this.getPageContext().showToast(b.this.getPageContext().getPageActivity().getString(a.i.ala_create_no_network));
                    }
                    if (b.this.fsy != null) {
                        b.this.fsy.onStop();
                    }
                } else if (BdNetTypeUtil.isMobileNet()) {
                    if (k.yr() && b.this.fsy != null) {
                        b.this.fsy.onStop();
                        b.this.fsy.bqD();
                    }
                } else if (BdNetTypeUtil.isWifiNet()) {
                    if (b.this.fsy != null) {
                        b.this.fsy.bqE();
                        b.this.fsy.onStart();
                        b.this.fsy.bqH();
                    }
                    b.this.getPageContext().showToast(b.this.getPageContext().getResources().getString(a.i.ala_watch_live_user_has_change_to_wifi));
                }
            }
        }
    };
    private CustomMessageListener fsC = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.player.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof AccountData) {
                b.this.bqd();
            }
        }
    };
    private CustomMessageListener eYf = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.player.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                b.this.bkG();
            }
        }
    };

    public b(TbPageContext tbPageContext, d dVar) {
        this.mPageContext = tbPageContext;
        this.fsx = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mPageContext;
    }

    public void init() {
        this.isBackground = false;
        if (MessageManager.getInstance().findTask(2913060) != null) {
            this.fsz = false;
            BdUtilHelper.showToast(getPageContext().getPageActivity(), a.i.ala_master_on_live_no_watch_other_live);
            a(false, false, -1L);
            return;
        }
        this.fsz = true;
        MessageManager.getInstance().dispatchResponsedMessage(new AlaCloseLiveRoomResponsedMessage());
        MessageManager.getInstance().registerListener(this.eYe);
        MessageManager.getInstance().registerListener(this.fsB);
        MessageManager.getInstance().registerListener(this.eJz);
        MessageManager.getInstance().registerListener(this.fsC);
        MessageManager.getInstance().registerListener(this.eYf);
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
            bkF();
            return;
        }
        Intent intent = getPageContext().getPageActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.fsy = new c(getPageContext(), this);
            this.fsy.ag(intent);
            return;
        }
        getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
        a(false, false, -1L);
    }

    private void bkF() {
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
        if (this.fsy != null) {
            this.fsy.bN(getPageContext().getPageActivity().getResources().getConfiguration().orientation);
        }
    }

    private void addGlobalLayoutListener() {
        this.eeg = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                b.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(b.this.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(b.this.getPageContext().getPageActivity());
                boolean z = b.this.eee != rect.bottom;
                b.this.eee = rect.bottom;
                if (b.this.mLastScreenHeight != screenFullSize[1]) {
                    if (b.this.fsy != null) {
                        b.this.fsy.bqv();
                    }
                    b.this.mLastScreenHeight = screenFullSize[1];
                } else if (b.this.mLastScreenWidth != screenFullSize[0]) {
                    if (b.this.fsy != null) {
                        b.this.fsy.bqv();
                    }
                    b.this.mLastScreenWidth = screenFullSize[0];
                }
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && ((!b.this.agD || z) && b.this.eef)) {
                    b.this.agD = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    b.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && b.this.agD) {
                    b.this.agD = false;
                    b.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eeg);
    }

    public void onWindowFocusChanged(boolean z) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity());
        if (this.fsy != null) {
            if (realScreenOrientation == 2) {
                this.fsy.bqw();
            } else {
                this.fsy.bqx();
            }
        }
    }

    public void onResume() {
        TbadkCoreApplication.getInst().AddResumeNum();
        this.eef = true;
        if (this.fsy != null) {
            this.fsy.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkG() {
        boolean isNetWorkAvailable = BdNetTypeUtil.isNetWorkAvailable();
        boolean yr = k.yr();
        if (isNetWorkAvailable && !BdNetTypeUtil.isWifiNet() && yr) {
            getPageContext().showToast(getPageContext().getPageActivity().getResources().getString(a.i.ala_create_not_wifi));
        }
    }

    public void onStart() {
        if ((this.fsy == null || !this.fsy.bqF()) && this.fsy != null) {
            this.fsy.onStart();
        }
    }

    public void onPause() {
        TbadkCoreApplication.getInst().DelResumeNum();
        if (this.fsz) {
            this.eef = false;
            if (this.fsy != null) {
                this.fsy.onPause();
            }
        }
    }

    public void onStop() {
        if (this.fsy != null) {
            this.fsy.onStop();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 && this.fsy != null && this.fsy.onKeyDown(i, keyEvent);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fsy != null) {
            this.fsy.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fsy != null) {
            this.fsy.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqd() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fsy != null) {
                        b.this.fsy.iM(true);
                        b.this.fsy.bqn();
                        b.this.fsy.bqe();
                    }
                }
            }, 1L);
        }
    }

    public void a(boolean z, boolean z2, long j) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer closeActivity");
        }
        s.rq();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            HKStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.fsy != null ? this.fsy.vi() : "");
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            QMStaticManager.staticEndPlayTime("", j + "", "", "", System.currentTimeMillis(), "", this.fsy != null ? this.fsy.vi() : "");
        }
        if (this.fsy != null) {
            this.fsy.bqC();
        }
        if (this.fsx != null) {
            this.fsx.b(z, !z2, j);
        } else {
            getPageContext().getPageActivity().finish();
        }
    }

    public void onDestroy() {
        if (this.fsz) {
            MessageManager.getInstance().unRegisterListener(this.fsB);
            MessageManager.getInstance().unRegisterListener(this.eYe);
            MessageManager.getInstance().unRegisterListener(this.eJz);
            MessageManager.getInstance().unRegisterListener(this.fsC);
            MessageManager.getInstance().unRegisterListener(this.eYf);
            MessageManager.getInstance().unRegisterListener(getPageContext().getUniqueId());
            getPageContext().getPageActivity().getWindow().clearFlags(128);
            getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eeg);
            this.eeg = null;
            if (this.fsy != null) {
                this.fsy.destroy();
                this.fsy = null;
            }
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mPageContext = null;
            System.gc();
        }
    }
}
