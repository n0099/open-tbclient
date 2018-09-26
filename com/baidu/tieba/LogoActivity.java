package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.NASLib;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.l.n;
import com.baidu.tieba.d;
import com.baidu.tieba.e;
import com.baidu.tieba.u.d;
import com.baidu.tieba.view.BesAdViewContainer;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private View bnI;
    private long bnM;
    private boolean bnO;
    private BesAdViewContainer bnT;
    private com.baidu.tieba.u.d bnU;
    private View bnV;
    private com.baidu.tbadk.e.b bnW;
    private RelativeLayout mRootView;
    private int bnH = 3100;
    private Bitmap bnJ = null;
    private boolean bnK = false;
    private boolean bnL = true;
    private int bnN = -1;
    private boolean bnP = false;
    private boolean bnQ = false;
    private boolean bnR = true;
    private a bnS = new a();
    private long bnX = -1;
    private d.a bnY = new d.a() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            if (LogoActivity.this.bnN != -2) {
                com.baidu.adp.lib.g.e.jt().post(LogoActivity.this.boc);
            } else {
                LogoActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.u.d.a
        public void Ri() {
            if (LogoActivity.this.bnN != -2) {
                LogoActivity.this.Rf();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener bnZ = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.QW()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.jt().removeCallbacks(LogoActivity.this.bnS);
                    LogoActivity.this.bnQ = true;
                    if (LogoActivity.this.bnR) {
                        LogoActivity.this.Rg();
                    }
                }
            }
        }
    };
    private Runnable boa = new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.bnI != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.bnI.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.bnI);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                n.Me().ar(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.jt().removeCallbacks(LogoActivity.this.bnS);
            if (LogoActivity.this.bnI != null && (LogoActivity.this.bnI.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.bnI.getTag()).booleanValue()) {
                    LogoActivity.this.bnH = 6100;
                } else {
                    LogoActivity.this.bnH = 3100;
                }
            }
            com.baidu.adp.lib.g.e.jt().postDelayed(LogoActivity.this.bnS, LogoActivity.this.bnH);
        }
    };
    private Runnable bob = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            d.a(LogoActivity.this.getPageContext(), new d.a() { // from class: com.baidu.tieba.LogoActivity.5.1
                @Override // com.baidu.tieba.d.a
                public void onCompleted() {
                    LogoActivity.this.QU();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable boc = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            d.a(LogoActivity.this.getPageContext(), new d.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.d.a
                public void onCompleted() {
                    if (!LogoActivity.this.Rd()) {
                        LogoActivity.this.Rg();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bod = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bnP) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bnT);
                com.baidu.adp.lib.g.e.jt().post(LogoActivity.this.boc);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void QU() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bnO = true;
            return;
        }
        if (MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        com.baidu.adp.lib.g.h.ju().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.Rh();
            }
        });
        finish();
    }

    private void C(Intent intent) {
        if (intent != null) {
            if (intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) {
                LogoActivityConfig.mFromSpacial = true;
                Intent intent2 = new Intent();
                intent2.putExtra("class", 2);
                intent2.putExtra(ImageViewerConfig.FORUM_NAME, intent.getStringExtra(ImageViewerConfig.FORUM_NAME));
                intent2.putExtra(FrsActivityConfig.FROM_SHORT_CUT, true);
                intent2.putExtra("back_special", true);
                intent2.putExtra("from", "short_cut");
                intent.putExtra(LogoActivityConfig.EXTRAINTENT, intent2);
            }
            TbadkCoreApplication.setIntent((Intent) intent.getParcelableExtra(LogoActivityConfig.EXTRAINTENT));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.bnX = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (QW()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(e.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(e.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bnZ);
                this.bnN = -2;
                Rb();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !QV()) {
            finish();
        } else {
            TiebaStatic.log(new am("c11894").w("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
            }
            C(getIntent());
            getWindow().setFlags(1024, 1024);
            setContentView(e.h.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(e.g.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.bnK = TbadkCoreApplication.getInst().getIsFirstUse();
            n.Me().cm(this.bnK);
            registerListener(this.bnZ);
            QX();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                QY();
            }
            if (!l.hk()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean QV() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new am("c11897").al(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QW() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void QX() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.us(), getPageContext().getPageActivity());
        }
        bO(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void QY() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000996, new com.baidu.adp.a.a.c(getPageContext().getPageActivity())));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_first", LogoActivityConfig.isFirst);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && LogoActivityConfig.isFirst) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bnR = false;
        if (this.bnU != null) {
            this.bnU.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bnR = true;
        if (this.bnL) {
            this.bnL = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bnQ) {
            Rg();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.bnO) {
            QU();
            this.bnO = false;
        }
        if (this.bnU != null) {
            this.bnU.onResume();
        }
        if (LogoActivityConfig.isFirst && this.bnX >= 0) {
            n.Me().ap(System.currentTimeMillis() - this.bnX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bnW != null) {
            this.bnW.e(null);
            this.bnW.a(null);
        }
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bnS);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.boa);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bob);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.boc);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bod);
        if (this.bnU != null) {
            this.bnU.onDestroy();
        }
        if (this.bnJ != null && !this.bnJ.isRecycled()) {
            this.bnJ.recycle();
            this.bnJ = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.ks().clearCashBitmap();
    }

    private void bO(Context context) {
        QZ();
        if (LogoActivityConfig.mFromSpacial) {
            gL(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bnK) {
                com.baidu.adp.lib.g.e.jt().post(this.bob);
            } else {
                gL(1);
            }
        } else if (this.bnK) {
            com.baidu.adp.lib.g.e.jt().post(this.bob);
        } else {
            Ra();
        }
    }

    private void QZ() {
        if (this.bnK) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Ra() {
        if (this.bnN != -2) {
            if (this.bnU == null) {
                this.bnU = new com.baidu.tieba.u.d(this);
            }
            if (this.bnU.bGZ()) {
                this.bnV = this.bnU.n(0.8125d);
                this.mRootView.addView(this.bnV);
                this.bnU.a(this.bnY);
                this.bnU.start();
                return;
            }
            this.bnU.bHe();
        }
        Rb();
    }

    private void Rb() {
        int aO = com.baidu.adp.lib.b.d.iB().aO("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (aO == 0 || findTask == null) {
            if (this.bnN == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.jt().post(this.boc);
                return;
            }
        }
        this.bnM = System.currentTimeMillis();
        this.bnW = new com.baidu.tbadk.e.b();
        this.bnT = new BesAdViewContainer(getPageContext().getPageActivity());
        this.bnT.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.9
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.Rg();
            }
        });
        this.bnT.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.aO(getPageContext().getPageActivity()), (int) (com.baidu.adp.lib.util.l.aQ(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bnT);
        this.bnW.e(this.bnT);
        this.bnW.a(new com.baidu.tbadk.e.a() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // com.baidu.tbadk.e.a
            public void cZ(String str) {
                LogoActivity.this.bnP = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bnT);
                LogoActivity.this.Rc();
            }

            @Override // com.baidu.tbadk.e.a
            public void ti() {
                LogoActivity.this.bnP = true;
                if (LogoActivity.this.bnN == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.jt().removeCallbacks(LogoActivity.this.bod);
                n.Me().ar(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.e.a
            public void tj() {
                LogoActivity.this.bnQ = true;
                if (LogoActivity.this.bnR) {
                    LogoActivity.this.Rg();
                }
            }

            @Override // com.baidu.tbadk.e.a
            public void sf() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.bnW));
        n.Me().aq(System.currentTimeMillis() - this.bnM);
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.bod, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rc() {
        this.bnM = System.currentTimeMillis();
        boolean Re = Re();
        n.Me().aq(System.currentTimeMillis() - this.bnM);
        if (Re) {
            com.baidu.adp.lib.g.e.jt().post(this.boa);
            if (this.bnN == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this));
            }
        } else if (this.bnN == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.jt().post(this.boc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Rd() {
        try {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016481, Boolean.class, 0);
            if (runTask == null || runTask.getData() == null) {
                return false;
            }
            return ((Boolean) runTask.getData()).booleanValue();
        } catch (Throwable th) {
            BdLog.e(th);
            return false;
        }
    }

    private boolean Re() {
        if (com.baidu.adp.lib.b.d.iB().aO("ad_baichuan_open") == 0) {
            return false;
        }
        int aO = com.baidu.adp.lib.util.l.aO(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016310, View.class, new com.baidu.tbadk.coreExtra.data.h(getPageContext(), (int) (com.baidu.adp.lib.util.l.aQ(getPageContext().getPageActivity()) * 0.8125d), aO));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.bnI = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rf() {
        if (this.bnN >= 0) {
            gM(this.bnN);
        } else if (this.bnN == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rg() {
        Rf();
        n.Me().as(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh() {
        File[] listFiles;
        File file = new File(l.zq());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                return !TextUtils.isEmpty(name) && name.contains(LogoActivity.this.getPageContext().getString(e.j.app_name)) && name.endsWith(".apk");
            }
        })) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void gL(int i) {
        this.bnN = i;
        Ra();
    }

    private void gM(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    if (intent == null) {
                        gL(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        gL(intExtra);
                        return;
                    } else {
                        gL(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.Rg();
        }
    }
}
