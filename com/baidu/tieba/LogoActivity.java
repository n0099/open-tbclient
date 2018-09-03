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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.l.n;
import com.baidu.tieba.e;
import com.baidu.tieba.f;
import com.baidu.tieba.u.d;
import com.baidu.tieba.view.BesAdViewContainer;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private View bhW;
    private long bia;
    private boolean bic;
    private BesAdViewContainer bij;
    private com.baidu.tieba.u.d bik;
    private View bil;
    private com.baidu.tbadk.e.b bim;
    private RelativeLayout mRootView;
    private int bhV = 3100;
    private Bitmap bhX = null;
    private boolean bhY = false;
    private boolean bhZ = true;
    private int bib = -1;
    private boolean bie = false;
    private boolean bif = false;
    private boolean bih = true;
    private a bii = new a();
    private long bin = -1;
    private d.a bio = new d.a() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            if (LogoActivity.this.bib != -2) {
                com.baidu.adp.lib.g.e.in().post(LogoActivity.this.bis);
            } else {
                LogoActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.u.d.a
        public void Pv() {
            if (LogoActivity.this.bib != -2) {
                LogoActivity.this.Ps();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener bip = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.Pj()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.in().removeCallbacks(LogoActivity.this.bii);
                    LogoActivity.this.bif = true;
                    if (LogoActivity.this.bih) {
                        LogoActivity.this.Pt();
                    }
                }
            }
        }
    };
    private Runnable biq = new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.bhW != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.bhW.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.bhW);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                n.KO().an(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.in().removeCallbacks(LogoActivity.this.bii);
            if (LogoActivity.this.bhW != null && (LogoActivity.this.bhW.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.bhW.getTag()).booleanValue()) {
                    LogoActivity.this.bhV = 6100;
                } else {
                    LogoActivity.this.bhV = 3100;
                }
            }
            com.baidu.adp.lib.g.e.in().postDelayed(LogoActivity.this.bii, LogoActivity.this.bhV);
        }
    };
    private Runnable bir = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            e.a(LogoActivity.this.getPageContext(), new e.a() { // from class: com.baidu.tieba.LogoActivity.5.1
                @Override // com.baidu.tieba.e.a
                public void onCompleted() {
                    LogoActivity.this.Ph();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bis = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            e.a(LogoActivity.this.getPageContext(), new e.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.e.a
                public void onCompleted() {
                    if (!LogoActivity.this.Pq()) {
                        LogoActivity.this.Pt();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bit = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bie) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bij);
                com.baidu.adp.lib.g.e.in().post(LogoActivity.this.bis);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bic = true;
            return;
        }
        if (MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.Pu();
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
        this.bin = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (Pj()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(f.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(f.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bip);
                this.bib = -2;
                Po();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !Pi()) {
            finish();
        } else {
            TiebaStatic.log(new an("c11894").r("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
            }
            C(getIntent());
            getWindow().setFlags(1024, 1024);
            setContentView(f.h.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(f.g.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.bhY = TbadkCoreApplication.getInst().getIsFirstUse();
            n.KO().ca(this.bhY);
            registerListener(this.bip);
            Pk();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                Pl();
            }
            if (!l.gd()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean Pi() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new an("c11897").ae(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Pj() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Pk() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.tp(), getPageContext().getPageActivity());
        }
        bh(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void Pl() {
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
        this.bih = false;
        if (this.bik != null) {
            this.bik.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bih = true;
        if (this.bhZ) {
            this.bhZ = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bif) {
            Pt();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.bic) {
            Ph();
            this.bic = false;
        }
        if (this.bik != null) {
            this.bik.onResume();
        }
        if (LogoActivityConfig.isFirst && this.bin >= 0) {
            n.KO().al(System.currentTimeMillis() - this.bin);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bim != null) {
            this.bim.e(null);
            this.bim.a(null);
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bii);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.biq);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bir);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bis);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bit);
        if (this.bik != null) {
            this.bik.onDestroy();
        }
        if (this.bhX != null && !this.bhX.isRecycled()) {
            this.bhX.recycle();
            this.bhX = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.jm().clearCashBitmap();
    }

    private void bh(Context context) {
        Pm();
        if (LogoActivityConfig.mFromSpacial) {
            gk(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bhY) {
                com.baidu.adp.lib.g.e.in().post(this.bir);
            } else {
                gk(1);
            }
        } else if (this.bhY) {
            com.baidu.adp.lib.g.e.in().post(this.bir);
        } else {
            Pn();
        }
    }

    private void Pm() {
        if (this.bhY) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Pn() {
        if (this.bib != -2) {
            if (this.bik == null) {
                this.bik = new com.baidu.tieba.u.d(this);
            }
            if (this.bik.bEi()) {
                this.bil = this.bik.n(0.8125d);
                this.mRootView.addView(this.bil);
                this.bik.a(this.bio);
                this.bik.start();
                return;
            }
            this.bik.bEn();
        }
        Po();
    }

    private void Po() {
        int ax = com.baidu.adp.lib.b.d.hv().ax("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (ax == 0 || findTask == null) {
            if (this.bib == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.in().post(this.bis);
                return;
            }
        }
        this.bia = System.currentTimeMillis();
        this.bim = new com.baidu.tbadk.e.b();
        this.bij = new BesAdViewContainer(getPageContext().getPageActivity());
        this.bij.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.9
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.Pt();
            }
        });
        this.bij.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ah(getPageContext().getPageActivity()), (int) (com.baidu.adp.lib.util.l.aj(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bij);
        this.bim.e(this.bij);
        this.bim.a(new com.baidu.tbadk.e.a() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // com.baidu.tbadk.e.a
            public void cI(String str) {
                LogoActivity.this.bie = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bij);
                LogoActivity.this.Pp();
            }

            @Override // com.baidu.tbadk.e.a
            public void sc() {
                LogoActivity.this.bie = true;
                if (LogoActivity.this.bib == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.in().removeCallbacks(LogoActivity.this.bit);
                n.KO().an(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.e.a
            public void sd() {
                LogoActivity.this.bif = true;
                if (LogoActivity.this.bih) {
                    LogoActivity.this.Pt();
                }
            }

            @Override // com.baidu.tbadk.e.a
            public void ra() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.bim));
        n.KO().am(System.currentTimeMillis() - this.bia);
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.in().postDelayed(this.bit, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pp() {
        this.bia = System.currentTimeMillis();
        boolean Pr = Pr();
        n.KO().am(System.currentTimeMillis() - this.bia);
        if (Pr) {
            com.baidu.adp.lib.g.e.in().post(this.biq);
            if (this.bib == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this));
            }
        } else if (this.bib == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.in().post(this.bis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Pq() {
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

    private boolean Pr() {
        if (com.baidu.adp.lib.b.d.hv().ax("ad_baichuan_open") == 0) {
            return false;
        }
        int ah = com.baidu.adp.lib.util.l.ah(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016310, View.class, new com.baidu.tbadk.coreExtra.data.g(getPageContext(), (int) (com.baidu.adp.lib.util.l.aj(getPageContext().getPageActivity()) * 0.8125d), ah));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.bhW = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ps() {
        if (this.bib >= 0) {
            gl(this.bib);
        } else if (this.bib == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pt() {
        Ps();
        n.KO().ao(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pu() {
        File[] listFiles;
        File file = new File(l.yj());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                return !TextUtils.isEmpty(name) && name.contains(LogoActivity.this.getPageContext().getString(f.j.app_name)) && name.endsWith(".apk");
            }
        })) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void gk(int i) {
        this.bib = i;
        Pn();
    }

    private void gl(int i) {
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
                        gk(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        gk(intExtra);
                        return;
                    } else {
                        gk(1);
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
            LogoActivity.this.Pt();
        }
    }
}
