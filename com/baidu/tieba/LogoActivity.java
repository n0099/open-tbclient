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
import com.baidu.tieba.v.d;
import com.baidu.tieba.view.BesAdViewContainer;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private long bwa;
    private boolean bwc;
    private BesAdViewContainer bwh;
    private com.baidu.tieba.v.d bwi;
    private View bwj;
    private com.baidu.tbadk.e.b bwk;
    private com.baidu.tbadk.q.a bwl;
    private RelativeLayout mRootView;
    private Bitmap bvX = null;
    private boolean bvY = false;
    private boolean bvZ = true;
    private int bwb = -1;
    private boolean bwd = false;
    private boolean bwe = false;
    private boolean bwf = true;
    private a bwg = new a();
    private com.baidu.tbadk.q.b bwm = new com.baidu.tbadk.q.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.q.b
        public void PI() {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bwt);
            LogoActivity.this.Un();
        }

        @Override // com.baidu.tbadk.q.b
        public void w(String str, boolean z) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bwt);
            if (LogoActivity.this.bwl.getView() == null) {
                LogoActivity.this.Ur();
                return;
            }
            int aO = l.aO(LogoActivity.this.getPageContext().getPageActivity());
            int aQ = l.aQ(LogoActivity.this.getPageContext().getPageActivity());
            if (!z) {
                aQ = (int) (l.aQ(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.bwl.getView().setLayoutParams(new RelativeLayout.LayoutParams(aO, aQ));
            LogoActivity.this.mRootView.addView(LogoActivity.this.bwl.getView());
            if (LogoActivity.this.bwb == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
            }
            n.Pr().aD(System.currentTimeMillis());
            TiebaStatic.log(new am("c13331").aA(VideoPlayActivityConfig.OBJ_ID, str));
        }

        @Override // com.baidu.tbadk.q.b
        public void wH() {
            LogoActivity.this.bwe = true;
            if (LogoActivity.this.bwf) {
                LogoActivity.this.Ur();
            }
        }

        @Override // com.baidu.tbadk.q.b
        public void ix(String str) {
            TiebaStatic.log(new am("c13332").aA(VideoPlayActivityConfig.OBJ_ID, str));
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.Ur();
        }
    };
    private long bwn = -1;
    private d.a bwo = new d.a() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // com.baidu.tieba.v.d.a
        public void onError() {
            LogoActivity.this.Uo();
        }

        @Override // com.baidu.tieba.v.d.a
        public void Uv() {
            if (LogoActivity.this.bwb != -2) {
                LogoActivity.this.Uq();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener bwp = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.Uh()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bwg);
                    LogoActivity.this.bwe = true;
                    if (LogoActivity.this.bwf) {
                        LogoActivity.this.Ur();
                    }
                }
            }
        }
    };
    private Runnable bwq = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            d.a(LogoActivity.this.getPageContext(), new d.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.d.a
                public void onCompleted() {
                    LogoActivity.this.Uf();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bwr = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            d.a(LogoActivity.this.getPageContext(), new d.a() { // from class: com.baidu.tieba.LogoActivity.7.1
                @Override // com.baidu.tieba.d.a
                public void onCompleted() {
                    if (!LogoActivity.this.Up()) {
                        LogoActivity.this.Ur();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bws = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bwd) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bwh);
                com.baidu.adp.lib.g.e.jG().post(LogoActivity.this.bwr);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable bwt = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.Uo();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Uf() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bwc = true;
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
                LogoActivity.this.Us();
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
        this.bwn = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (Uu()) {
            Ut();
        } else if (Uh()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(e.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(e.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bwp);
                this.bwb = -2;
                Um();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !Ug()) {
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
            this.bvY = TbadkCoreApplication.getInst().getIsFirstUse();
            n.Pr().cN(this.bvY);
            registerListener(this.bwp);
            Ui();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                Uj();
            }
            if (!com.baidu.tbadk.core.util.l.hA()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean Ug() {
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
    public boolean Uh() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Ui() {
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

    private void Uj() {
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
        this.bwf = false;
        if (this.bwi != null) {
            this.bwi.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bwf = true;
        if (this.bvZ) {
            this.bvZ = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bwe) {
            Ur();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.bwc) {
            Uf();
            this.bwc = false;
        }
        if (this.bwi != null) {
            this.bwi.onResume();
        }
        if (LogoActivityConfig.isFirst && this.bwn >= 0) {
            n.Pr().aB(System.currentTimeMillis() - this.bwn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bwk != null) {
            this.bwk.e(null);
            this.bwk.a(null);
        }
        if (this.bwl != null) {
            this.bwl.release();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bwg);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bwq);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bwr);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bws);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bwt);
        if (this.bwi != null) {
            this.bwi.onDestroy();
        }
        if (this.bvX != null && !this.bvX.isRecycled()) {
            this.bvX.recycle();
            this.bvX = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.kE().clearCashBitmap();
    }

    private void bW(Context context) {
        Uk();
        if (LogoActivityConfig.mFromSpacial) {
            hv(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bvY) {
                com.baidu.adp.lib.g.e.jG().post(this.bwq);
            } else {
                hv(1);
            }
        } else if (this.bvY) {
            com.baidu.adp.lib.g.e.jG().post(this.bwq);
        } else {
            Ul();
        }
    }

    private void Uk() {
        if (this.bvY) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Ul() {
        if (this.bwb != -2) {
            if (this.bwi == null) {
                this.bwi = new com.baidu.tieba.v.d(this);
            }
            if (this.bwi.bME()) {
                this.bwj = this.bwi.n(0.8125d);
                this.mRootView.addView(this.bwj);
                this.bwi.a(this.bwo);
                this.bwi.start();
                return;
            }
            this.bwi.bMJ();
        }
        Um();
    }

    private void Um() {
        this.bwa = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921382, com.baidu.tbadk.q.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.bwl = (com.baidu.tbadk.q.a) runTask.getData();
            this.bwl.a(this.bwm);
            this.bwl.PH();
            n.Pr().aC(System.currentTimeMillis() - this.bwa);
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(this.bwt, i * 1000);
            return;
        }
        Un();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Un() {
        int aO = com.baidu.adp.lib.b.d.iQ().aO("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (aO == 0 || findTask == null) {
            Uo();
        }
        this.bwa = System.currentTimeMillis();
        this.bwk = new com.baidu.tbadk.e.b();
        this.bwh = new BesAdViewContainer(getPageContext().getPageActivity());
        this.bwh.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.Ur();
            }
        });
        this.bwh.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(getPageContext().getPageActivity()), (int) (l.aQ(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bwh);
        this.bwk.e(this.bwh);
        this.bwk.a(new com.baidu.tbadk.e.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.e.a
            public void dE(String str) {
                LogoActivity.this.bwd = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bwh);
                LogoActivity.this.Uo();
            }

            @Override // com.baidu.tbadk.e.a
            public void wG() {
                LogoActivity.this.bwd = true;
                if (LogoActivity.this.bwb == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bws);
                n.Pr().aD(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.e.a
            public void wH() {
                LogoActivity.this.bwe = true;
                if (LogoActivity.this.bwf) {
                    LogoActivity.this.Ur();
                }
            }

            @Override // com.baidu.tbadk.e.a
            public void ui() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.bwk));
        n.Pr().aC(System.currentTimeMillis() - this.bwa);
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bws, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uo() {
        if (this.bwb == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.jG().post(this.bwr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Up() {
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
    public void Uq() {
        if (this.bwb >= 0) {
            hw(this.bwb);
        } else if (this.bwb == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ur() {
        Uq();
        n.Pr().aE(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Us() {
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

    private void hv(int i) {
        this.bwb = i;
        Ul();
    }

    private void hw(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private void Ut() {
        sendMessage(new CustomMessage(2002001, new SecretHintActivityConfig(getPageContext().getPageActivity())));
        finish();
    }

    private boolean Uu() {
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
                        hv(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        hv(intExtra);
                        return;
                    } else {
                        hv(1);
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
            LogoActivity.this.Ur();
        }
    }
}
