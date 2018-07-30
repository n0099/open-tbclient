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
import com.baidu.tieba.c;
import com.baidu.tieba.d;
import com.baidu.tieba.u.d;
import com.baidu.tieba.view.BesAdViewContainer;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private View bhQ;
    private long bhU;
    private boolean bhW;
    private BesAdViewContainer bib;
    private com.baidu.tieba.u.d bic;
    private View bie;
    private com.baidu.tbadk.e.b bif;
    private RelativeLayout mRootView;
    private int bhP = 3100;
    private Bitmap bhR = null;
    private boolean bhS = false;
    private boolean bhT = true;
    private int bhV = -1;
    private boolean bhX = false;
    private boolean bhY = false;
    private boolean bhZ = true;
    private a bia = new a();
    private long bih = -1;
    private d.a bii = new d.a() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            if (LogoActivity.this.bhV != -2) {
                com.baidu.adp.lib.g.e.in().post(LogoActivity.this.bim);
            } else {
                LogoActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.u.d.a
        public void Pp() {
            if (LogoActivity.this.bhV != -2) {
                LogoActivity.this.Pm();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener bij = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.Pd()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.in().removeCallbacks(LogoActivity.this.bia);
                    LogoActivity.this.bhY = true;
                    if (LogoActivity.this.bhZ) {
                        LogoActivity.this.Pn();
                    }
                }
            }
        }
    };
    private Runnable bik = new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.bhQ != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.bhQ.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.bhQ);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                n.KK().an(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.in().removeCallbacks(LogoActivity.this.bia);
            if (LogoActivity.this.bhQ != null && (LogoActivity.this.bhQ.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.bhQ.getTag()).booleanValue()) {
                    LogoActivity.this.bhP = 6100;
                } else {
                    LogoActivity.this.bhP = 3100;
                }
            }
            com.baidu.adp.lib.g.e.in().postDelayed(LogoActivity.this.bia, LogoActivity.this.bhP);
        }
    };
    private Runnable bil = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.5.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.Pb();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bim = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.Pk()) {
                        LogoActivity.this.Pn();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bin = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bhX) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bib);
                com.baidu.adp.lib.g.e.in().post(LogoActivity.this.bim);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Pb() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bhW = true;
            return;
        }
        if (MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.io().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.Po();
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
        this.bih = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (Pd()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(d.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bij);
                this.bhV = -2;
                Pi();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !Pc()) {
            finish();
        } else {
            TiebaStatic.log(new an("c11894").r("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
            }
            C(getIntent());
            getWindow().setFlags(1024, 1024);
            setContentView(d.h.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.bhS = TbadkCoreApplication.getInst().getIsFirstUse();
            n.KK().bZ(this.bhS);
            registerListener(this.bij);
            Pe();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                Pf();
            }
            if (!l.gd()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean Pc() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new an("c11897").af(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Pd() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Pe() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.tq(), getPageContext().getPageActivity());
        }
        bi(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void Pf() {
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
        this.bhZ = false;
        if (this.bic != null) {
            this.bic.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bhZ = true;
        if (this.bhT) {
            this.bhT = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bhY) {
            Pn();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.bhW) {
            Pb();
            this.bhW = false;
        }
        if (this.bic != null) {
            this.bic.onResume();
        }
        if (LogoActivityConfig.isFirst && this.bih >= 0) {
            n.KK().al(System.currentTimeMillis() - this.bih);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bif != null) {
            this.bif.e(null);
            this.bif.a(null);
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bia);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bik);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bil);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bim);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.bin);
        if (this.bic != null) {
            this.bic.onDestroy();
        }
        if (this.bhR != null && !this.bhR.isRecycled()) {
            this.bhR.recycle();
            this.bhR = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.jm().clearCashBitmap();
    }

    private void bi(Context context) {
        Pg();
        if (LogoActivityConfig.mFromSpacial) {
            gl(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bhS) {
                com.baidu.adp.lib.g.e.in().post(this.bil);
            } else {
                gl(1);
            }
        } else if (this.bhS) {
            com.baidu.adp.lib.g.e.in().post(this.bil);
        } else {
            Ph();
        }
    }

    private void Pg() {
        if (this.bhS) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Ph() {
        if (this.bhV != -2) {
            if (this.bic == null) {
                this.bic = new com.baidu.tieba.u.d(this);
            }
            if (this.bic.bEg()) {
                this.bie = this.bic.o(0.8125d);
                this.mRootView.addView(this.bie);
                this.bic.a(this.bii);
                this.bic.start();
                return;
            }
            this.bic.bEl();
        }
        Pi();
    }

    private void Pi() {
        int ax = com.baidu.adp.lib.b.d.hv().ax("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (ax == 0 || findTask == null) {
            if (this.bhV == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.in().post(this.bim);
                return;
            }
        }
        this.bhU = System.currentTimeMillis();
        this.bif = new com.baidu.tbadk.e.b();
        this.bib = new BesAdViewContainer(getPageContext().getPageActivity());
        this.bib.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.9
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.Pn();
            }
        });
        this.bib.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ah(getPageContext().getPageActivity()), (int) (com.baidu.adp.lib.util.l.aj(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bib);
        this.bif.e(this.bib);
        this.bif.a(new com.baidu.tbadk.e.a() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // com.baidu.tbadk.e.a
            public void cI(String str) {
                LogoActivity.this.bhX = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bib);
                LogoActivity.this.Pj();
            }

            @Override // com.baidu.tbadk.e.a
            public void se() {
                LogoActivity.this.bhX = true;
                if (LogoActivity.this.bhV == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.in().removeCallbacks(LogoActivity.this.bin);
                n.KK().an(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.e.a
            public void sf() {
                LogoActivity.this.bhY = true;
                if (LogoActivity.this.bhZ) {
                    LogoActivity.this.Pn();
                }
            }

            @Override // com.baidu.tbadk.e.a
            public void rd() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.bif));
        n.KK().am(System.currentTimeMillis() - this.bhU);
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.in().postDelayed(this.bin, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pj() {
        this.bhU = System.currentTimeMillis();
        boolean Pl = Pl();
        n.KK().am(System.currentTimeMillis() - this.bhU);
        if (Pl) {
            com.baidu.adp.lib.g.e.in().post(this.bik);
            if (this.bhV == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this));
            }
        } else if (this.bhV == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.in().post(this.bim);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Pk() {
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

    private boolean Pl() {
        if (com.baidu.adp.lib.b.d.hv().ax("ad_baichuan_open") == 0) {
            return false;
        }
        int ah = com.baidu.adp.lib.util.l.ah(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016310, View.class, new com.baidu.tbadk.coreExtra.data.g(getPageContext(), (int) (com.baidu.adp.lib.util.l.aj(getPageContext().getPageActivity()) * 0.8125d), ah));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.bhQ = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pm() {
        if (this.bhV >= 0) {
            gm(this.bhV);
        } else if (this.bhV == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pn() {
        Pm();
        n.KK().ao(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po() {
        File[] listFiles;
        File file = new File(l.yk());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.2
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

    private void gl(int i) {
        this.bhV = i;
        Ph();
    }

    private void gm(int i) {
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
                        gl(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        gl(intExtra);
                        return;
                    } else {
                        gl(1);
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
            LogoActivity.this.Pn();
        }
    }
}
