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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
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
    private long cHV;
    private boolean cHX;
    private BesAdViewContainer cIc;
    private com.baidu.tieba.u.d cId;
    private View cIe;
    private com.baidu.tbadk.g.b cIf;
    private com.baidu.tbadk.t.a cIg;
    private RelativeLayout mRootView;
    private Bitmap cHS = null;
    private boolean cHT = false;
    private boolean cHU = true;
    private int cHW = -1;
    private boolean cHY = false;
    private boolean cHZ = false;
    private boolean cIa = true;
    private a cIb = new a();
    private com.baidu.tbadk.t.b cIh = new com.baidu.tbadk.t.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.t.b
        public void apL() {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(LogoActivity.this.cIo);
            LogoActivity.this.auH();
        }

        @Override // com.baidu.tbadk.t.b
        public void Q(String str, boolean z) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(LogoActivity.this.cIo);
            if (LogoActivity.this.cIg.getView() == null) {
                LogoActivity.this.auL();
                return;
            }
            int aO = l.aO(LogoActivity.this.getPageContext().getPageActivity());
            int aQ = l.aQ(LogoActivity.this.getPageContext().getPageActivity());
            if (!z) {
                aQ = (int) (l.aQ(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.cIg.getView().setLayoutParams(new RelativeLayout.LayoutParams(aO, aQ));
            LogoActivity.this.mRootView.addView(LogoActivity.this.cIg.getView());
            if (LogoActivity.this.cHW == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
            }
            n.apq().bf(System.currentTimeMillis());
            TiebaStatic.log(new am("c13331").bJ(VideoPlayActivityConfig.OBJ_ID, str));
        }

        @Override // com.baidu.tbadk.t.b
        public void Vu() {
            LogoActivity.this.cHZ = true;
            if (LogoActivity.this.cIa) {
                LogoActivity.this.auL();
            }
        }

        @Override // com.baidu.tbadk.t.b
        public void pz(String str) {
            TiebaStatic.log(new am("c13332").bJ(VideoPlayActivityConfig.OBJ_ID, str));
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.auL();
        }
    };
    private long cIi = -1;
    private d.a cIj = new d.a() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            LogoActivity.this.auI();
        }

        @Override // com.baidu.tieba.u.d.a
        public void auP() {
            if (LogoActivity.this.cHW != -2) {
                LogoActivity.this.auK();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener cIk = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.5
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
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(LogoActivity.this.cIb);
                    LogoActivity.this.cHZ = true;
                    if (LogoActivity.this.cIa) {
                        LogoActivity.this.auL();
                    }
                }
            }
        }
    };
    private Runnable cIl = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.auz();
        }
    };
    private Runnable cIm = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
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
    private Runnable cIn = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.cHY) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.cIc);
                com.baidu.adp.lib.g.e.jH().post(LogoActivity.this.cIm);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable cIo = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.auI();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void auz() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.cHX = true;
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
        this.cIi = System.currentTimeMillis();
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
                registerListener(this.cIk);
                this.cHW = -2;
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
            this.cHT = TbadkCoreApplication.getInst().getIsFirstUse();
            n.apq().fg(this.cHT);
            registerListener(this.cIk);
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
        dn(getPageContext().getPageActivity());
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
        this.cIa = false;
        if (this.cId != null) {
            this.cId.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cIa = true;
        if (this.cHU) {
            this.cHU = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.cHZ) {
            auL();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.cHX) {
            auz();
            this.cHX = false;
        }
        if (this.cId != null) {
            this.cId.onResume();
        }
        if (LogoActivityConfig.isFirst && this.cIi >= 0) {
            n.apq().bd(System.currentTimeMillis() - this.cIi);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cIf != null) {
            this.cIf.l(null);
            this.cIf.a(null);
        }
        if (this.cIg != null) {
            this.cIg.release();
        }
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cIb);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cIl);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cIm);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cIn);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.cIo);
        if (this.cId != null) {
            this.cId.onDestroy();
        }
        if (this.cHS != null && !this.cHS.isRecycled()) {
            this.cHS.recycle();
            this.cHS = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.kG().clearCashBitmap();
    }

    private void dn(Context context) {
        auE();
        if (LogoActivityConfig.mFromSpacial) {
            ll(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.cHT) {
                com.baidu.adp.lib.g.e.jH().post(this.cIl);
            } else {
                ll(1);
            }
        } else if (this.cHT) {
            com.baidu.adp.lib.g.e.jH().post(this.cIl);
        } else {
            auF();
        }
    }

    private void auE() {
        if (this.cHT) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void auF() {
        if (this.cHW != -2) {
            if (this.cId == null) {
                this.cId = new com.baidu.tieba.u.d(this);
            }
            if (this.cId.cmQ()) {
                this.cIe = this.cId.o(0.8125d);
                this.mRootView.addView(this.cIe);
                this.cId.a(this.cIj);
                this.cId.start();
                return;
            }
            this.cId.cmV();
        }
        auG();
    }

    private void auG() {
        this.cHV = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.t.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.cIg = (com.baidu.tbadk.t.a) runTask.getData();
            this.cIg.a(this.cIh);
            this.cIg.apK();
            n.apq().be(System.currentTimeMillis() - this.cHV);
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(this.cIo, i * 1000);
            return;
        }
        auH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auH() {
        int aO = com.baidu.adp.lib.b.d.iQ().aO("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (aO == 0 || findTask == null) {
            auI();
        }
        this.cHV = System.currentTimeMillis();
        this.cIf = new com.baidu.tbadk.g.b();
        this.cIc = new BesAdViewContainer(getPageContext().getPageActivity());
        this.cIc.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.auL();
            }
        });
        this.cIc.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(getPageContext().getPageActivity()), (int) (l.aQ(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.cIc);
        this.cIf.l(this.cIc);
        this.cIf.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.a
            public void kp(String str) {
                LogoActivity.this.cHY = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.cIc);
                LogoActivity.this.auI();
            }

            @Override // com.baidu.tbadk.g.a
            public void Vt() {
                LogoActivity.this.cHY = true;
                if (LogoActivity.this.cHW == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.jH().removeCallbacks(LogoActivity.this.cIn);
                n.apq().bf(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.g.a
            public void Vu() {
                LogoActivity.this.cHZ = true;
                if (LogoActivity.this.cIa) {
                    LogoActivity.this.auL();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void tm() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.cIf));
        n.apq().be(System.currentTimeMillis() - this.cHV);
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.cIn, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auI() {
        if (this.cHW == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.jH().post(this.cIm);
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
        if (this.cHW >= 0) {
            lm(this.cHW);
        } else if (this.cHW == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auL() {
        auK();
        n.apq().bg(System.currentTimeMillis());
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
        this.cHW = i;
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
