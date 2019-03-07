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
import com.baidu.adp.lib.g.h;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.o.n;
import com.baidu.tieba.d;
import com.baidu.tieba.u.d;
import com.baidu.tieba.view.BesAdViewContainer;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private long cHY;
    private boolean cIa;
    private BesAdViewContainer cIf;
    private com.baidu.tieba.u.d cIg;
    private View cIh;
    private com.baidu.tbadk.g.b cIi;
    private com.baidu.tbadk.t.a cIj;
    private RelativeLayout mRootView;
    private Bitmap cHV = null;
    private boolean cHW = false;
    private boolean cHX = true;
    private int cHZ = -1;
    private boolean cIb = false;
    private boolean cIc = false;
    private boolean cId = true;
    private a cIe = new a();
    private com.baidu.tbadk.t.b cIk = new com.baidu.tbadk.t.b() { // from class: com.baidu.tieba.LogoActivity.1
    };
    private long cIl = -1;
    private d.a cIm = new d.a() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            LogoActivity.this.auI();
        }

        @Override // com.baidu.tieba.u.d.a
        public void auP() {
            if (LogoActivity.this.cHZ != -2) {
                LogoActivity.this.auK();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener cIn = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.auB()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(LogoActivity.this.cIe);
                    LogoActivity.this.cIc = true;
                    if (LogoActivity.this.cId) {
                        LogoActivity.this.auL();
                    }
                }
            }
        }
    };
    private Runnable cIo = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.auz();
        }
    };
    private Runnable cIp = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.auJ()) {
                LogoActivity.this.auL();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
            LogoActivity.this.finish();
        }
    };
    private Runnable cIq = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.cIb) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.cIf);
                com.baidu.adp.lib.g.e.jH().post(LogoActivity.this.cIp);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable cIr = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.auI();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void auz() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.cIa = true;
            return;
        }
        if (MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.jI().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.auM();
            }
        });
        finish();
    }

    private void T(Intent intent) {
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
        this.cIl = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (auO()) {
            auN();
        } else if (auB()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(d.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.cIn);
                this.cHZ = -2;
                auG();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !auA()) {
            finish();
        } else {
            TiebaStatic.log(new am("c11894").T("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
            }
            T(getIntent());
            getWindow().setFlags(1024, 1024);
            setContentView(d.h.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.cHW = TbadkCoreApplication.getInst().getIsFirstUse();
            n.apr().fg(this.cHW);
            registerListener(this.cIn);
            auC();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                auD();
            }
            if (!m.hy()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean auA() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new am("c11897").bJ(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auB() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void auC() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.WH(), getPageContext().getPageActivity());
        }
        m19do(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void auD() {
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
        this.cId = false;
        if (this.cIg != null) {
            this.cIg.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cId = true;
        if (this.cHX) {
            this.cHX = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.cIc) {
            auL();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.cIa) {
            auz();
            this.cIa = false;
        }
        if (this.cIg != null) {
            this.cIg.onResume();
        }
        if (LogoActivityConfig.isFirst && this.cIl >= 0) {
            n.apr().bd(System.currentTimeMillis() - this.cIl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cIi != null) {
            this.cIi.l(null);
            this.cIi.a(null);
        }
        if (this.cIj != null) {
            this.cIj.release();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cIe);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cIo);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cIp);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cIq);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cIr);
        if (this.cIg != null) {
            this.cIg.onDestroy();
        }
        if (this.cHV != null && !this.cHV.isRecycled()) {
            this.cHV.recycle();
            this.cHV = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.kG().clearCashBitmap();
    }

    /* renamed from: do  reason: not valid java name */
    private void m19do(Context context) {
        auE();
        if (LogoActivityConfig.mFromSpacial) {
            ll(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.cHW) {
                com.baidu.adp.lib.g.e.jH().post(this.cIo);
            } else {
                ll(1);
            }
        } else if (this.cHW) {
            com.baidu.adp.lib.g.e.jH().post(this.cIo);
        } else {
            auF();
        }
    }

    private void auE() {
        if (this.cHW) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void auF() {
        if (this.cHZ != -2) {
            if (this.cIg == null) {
                this.cIg = new com.baidu.tieba.u.d(this);
            }
            if (this.cIg.cmD()) {
                this.cIh = this.cIg.o(0.8125d);
                this.mRootView.addView(this.cIh);
                this.cIg.a(this.cIm);
                this.cIg.start();
                return;
            }
            this.cIg.cmI();
        }
        auG();
    }

    private void auG() {
        this.cHY = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.t.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.cIj = (com.baidu.tbadk.t.a) runTask.getData();
            this.cIj.a(this.cIk);
            this.cIj.apL();
            n.apr().be(System.currentTimeMillis() - this.cHY);
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(this.cIr, i * 1000);
            return;
        }
        auH();
    }

    private void auH() {
        int aO = com.baidu.adp.lib.b.d.iQ().aO("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (aO == 0 || findTask == null) {
            auI();
        }
        this.cHY = System.currentTimeMillis();
        this.cIi = new com.baidu.tbadk.g.b();
        this.cIf = new BesAdViewContainer(getPageContext().getPageActivity());
        this.cIf.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.auL();
            }
        });
        this.cIf.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(getPageContext().getPageActivity()), (int) (l.aQ(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.cIf);
        this.cIi.l(this.cIf);
        this.cIi.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.a
            public void kp(String str) {
                LogoActivity.this.cIb = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.cIf);
                LogoActivity.this.auI();
            }

            @Override // com.baidu.tbadk.g.a
            public void Vt() {
                LogoActivity.this.cIb = true;
                if (LogoActivity.this.cHZ == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.jH().removeCallbacks(LogoActivity.this.cIq);
                n.apr().bf(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.g.a
            public void Vu() {
                LogoActivity.this.cIc = true;
                if (LogoActivity.this.cId) {
                    LogoActivity.this.auL();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void tm() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.cIi));
        n.apr().be(System.currentTimeMillis() - this.cHY);
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.cIq, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auI() {
        if (this.cHZ == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.jH().post(this.cIp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auJ() {
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
    public void auK() {
        if (this.cHZ >= 0) {
            lm(this.cHZ);
        } else if (this.cHZ == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auL() {
        auK();
        n.apr().bg(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auM() {
        File[] listFiles;
        File file = new File(m.acg());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                return !TextUtils.isEmpty(name) && name.contains(LogoActivity.this.getPageContext().getString(d.j.app_name)) && name.endsWith(".apk");
            }
        })) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void ll(int i) {
        this.cHZ = i;
        auF();
    }

    private void lm(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private void auN() {
        sendMessage(new CustomMessage(2002001, new SecretHintActivityConfig(getPageContext().getPageActivity())));
        finish();
    }

    private boolean auO() {
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
                        ll(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        ll(intExtra);
                        return;
                    } else {
                        ll(1);
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
            LogoActivity.this.auL();
        }
    }
}
