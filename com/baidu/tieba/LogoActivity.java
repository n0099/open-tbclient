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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.atomData.SecretHintActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
    private long bvX;
    private boolean bvZ;
    private BesAdViewContainer bwe;
    private com.baidu.tieba.u.d bwf;
    private View bwg;
    private com.baidu.tbadk.e.b bwh;
    private com.baidu.tbadk.q.a bwi;
    private RelativeLayout mRootView;
    private Bitmap bvU = null;
    private boolean bvV = false;
    private boolean bvW = true;
    private int bvY = -1;
    private boolean bwa = false;
    private boolean bwb = false;
    private boolean bwc = true;
    private a bwd = new a();
    private com.baidu.tbadk.q.b bwj = new com.baidu.tbadk.q.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.q.b
        public void PG() {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bwq);
            LogoActivity.this.Ul();
        }

        @Override // com.baidu.tbadk.q.b
        public void w(String str, boolean z) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bwq);
            if (LogoActivity.this.bwi.getView() == null) {
                LogoActivity.this.Up();
                return;
            }
            int aO = l.aO(LogoActivity.this.getPageContext().getPageActivity());
            int aQ = l.aQ(LogoActivity.this.getPageContext().getPageActivity());
            if (!z) {
                aQ = (int) (l.aQ(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.bwi.getView().setLayoutParams(new RelativeLayout.LayoutParams(aO, aQ));
            LogoActivity.this.mRootView.addView(LogoActivity.this.bwi.getView());
            if (LogoActivity.this.bvY == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
            }
            n.Pp().aC(System.currentTimeMillis());
            TiebaStatic.log(new am("c13331").aA(VideoPlayActivityConfig.OBJ_ID, str));
        }

        @Override // com.baidu.tbadk.q.b
        public void wH() {
            LogoActivity.this.bwb = true;
            if (LogoActivity.this.bwc) {
                LogoActivity.this.Up();
            }
        }

        @Override // com.baidu.tbadk.q.b
        public void iw(String str) {
            TiebaStatic.log(new am("c13332").aA(VideoPlayActivityConfig.OBJ_ID, str));
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.Up();
        }
    };
    private long bwk = -1;
    private d.a bwl = new d.a() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            LogoActivity.this.Um();
        }

        @Override // com.baidu.tieba.u.d.a
        public void Ut() {
            if (LogoActivity.this.bvY != -2) {
                LogoActivity.this.Uo();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener bwm = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.Uf()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bwd);
                    LogoActivity.this.bwb = true;
                    if (LogoActivity.this.bwc) {
                        LogoActivity.this.Up();
                    }
                }
            }
        }
    };
    private Runnable bwn = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            d.a(LogoActivity.this.getPageContext(), new d.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.d.a
                public void onCompleted() {
                    LogoActivity.this.Ud();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bwo = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            d.a(LogoActivity.this.getPageContext(), new d.a() { // from class: com.baidu.tieba.LogoActivity.7.1
                @Override // com.baidu.tieba.d.a
                public void onCompleted() {
                    if (!LogoActivity.this.Un()) {
                        LogoActivity.this.Up();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bwp = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bwa) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bwe);
                com.baidu.adp.lib.g.e.jG().post(LogoActivity.this.bwo);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable bwq = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.Um();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Ud() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bvZ = true;
            return;
        }
        if (MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.Uq();
            }
        });
        finish();
    }

    private void D(Intent intent) {
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
        this.bwk = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (Us()) {
            Ur();
        } else if (Uf()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(e.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(e.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bwm);
                this.bvY = -2;
                Uk();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !Ue()) {
            finish();
        } else {
            TiebaStatic.log(new am("c11894").x("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
            }
            D(getIntent());
            getWindow().setFlags(1024, 1024);
            setContentView(e.h.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(e.g.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.bvV = TbadkCoreApplication.getInst().getIsFirstUse();
            n.Pp().cN(this.bvV);
            registerListener(this.bwm);
            Ug();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                Uh();
            }
            if (!com.baidu.tbadk.core.util.l.hA()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean Ue() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new am("c11897").aA(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Uf() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Ug() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.xN(), getPageContext().getPageActivity());
        }
        bW(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void Uh() {
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
        this.bwc = false;
        if (this.bwf != null) {
            this.bwf.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bwc = true;
        if (this.bvW) {
            this.bvW = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bwb) {
            Up();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.bvZ) {
            Ud();
            this.bvZ = false;
        }
        if (this.bwf != null) {
            this.bwf.onResume();
        }
        if (LogoActivityConfig.isFirst && this.bwk >= 0) {
            n.Pp().aA(System.currentTimeMillis() - this.bwk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bwh != null) {
            this.bwh.e(null);
            this.bwh.a(null);
        }
        if (this.bwi != null) {
            this.bwi.release();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bwd);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bwn);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bwo);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bwp);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bwq);
        if (this.bwf != null) {
            this.bwf.onDestroy();
        }
        if (this.bvU != null && !this.bvU.isRecycled()) {
            this.bvU.recycle();
            this.bvU = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.kE().clearCashBitmap();
    }

    private void bW(Context context) {
        Ui();
        if (LogoActivityConfig.mFromSpacial) {
            hu(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bvV) {
                com.baidu.adp.lib.g.e.jG().post(this.bwn);
            } else {
                hu(1);
            }
        } else if (this.bvV) {
            com.baidu.adp.lib.g.e.jG().post(this.bwn);
        } else {
            Uj();
        }
    }

    private void Ui() {
        if (this.bvV) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Uj() {
        if (this.bvY != -2) {
            if (this.bwf == null) {
                this.bwf = new com.baidu.tieba.u.d(this);
            }
            if (this.bwf.bLO()) {
                this.bwg = this.bwf.n(0.8125d);
                this.mRootView.addView(this.bwg);
                this.bwf.a(this.bwl);
                this.bwf.start();
                return;
            }
            this.bwf.bLT();
        }
        Uk();
    }

    private void Uk() {
        this.bvX = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921382, com.baidu.tbadk.q.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.bwi = (com.baidu.tbadk.q.a) runTask.getData();
            this.bwi.a(this.bwj);
            this.bwi.PF();
            n.Pp().aB(System.currentTimeMillis() - this.bvX);
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(this.bwq, i * 1000);
            return;
        }
        Ul();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ul() {
        int aO = com.baidu.adp.lib.b.d.iQ().aO("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (aO == 0 || findTask == null) {
            Um();
        }
        this.bvX = System.currentTimeMillis();
        this.bwh = new com.baidu.tbadk.e.b();
        this.bwe = new BesAdViewContainer(getPageContext().getPageActivity());
        this.bwe.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.Up();
            }
        });
        this.bwe.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(getPageContext().getPageActivity()), (int) (l.aQ(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bwe);
        this.bwh.e(this.bwe);
        this.bwh.a(new com.baidu.tbadk.e.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.e.a
            public void dE(String str) {
                LogoActivity.this.bwa = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bwe);
                LogoActivity.this.Um();
            }

            @Override // com.baidu.tbadk.e.a
            public void wG() {
                LogoActivity.this.bwa = true;
                if (LogoActivity.this.bvY == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bwp);
                n.Pp().aC(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.e.a
            public void wH() {
                LogoActivity.this.bwb = true;
                if (LogoActivity.this.bwc) {
                    LogoActivity.this.Up();
                }
            }

            @Override // com.baidu.tbadk.e.a
            public void ui() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.bwh));
        n.Pp().aB(System.currentTimeMillis() - this.bvX);
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bwp, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Um() {
        if (this.bvY == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.jG().post(this.bwo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Un() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void Uo() {
        if (this.bvY >= 0) {
            hv(this.bvY);
        } else if (this.bvY == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Up() {
        Uo();
        n.Pp().aD(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uq() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.l.getCacheDir());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.3
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

    private void hu(int i) {
        this.bvY = i;
        Uj();
    }

    private void hv(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private void Ur() {
        sendMessage(new CustomMessage(2002001, new SecretHintActivityConfig(getPageContext().getPageActivity())));
        finish();
    }

    private boolean Us() {
        return !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    if (intent == null) {
                        hu(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        hu(intExtra);
                        return;
                    } else {
                        hu(1);
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
            LogoActivity.this.Up();
        }
    }
}
