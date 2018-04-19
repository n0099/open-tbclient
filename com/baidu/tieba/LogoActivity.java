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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.appsearchlib.NASLib;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.k.q;
import com.baidu.tieba.c;
import com.baidu.tieba.d;
import com.baidu.tieba.s.d;
import com.baidu.tieba.view.BesAdViewContainer;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private View aXO;
    private long aXS;
    private boolean aXU;
    private BesAdViewContainer aXZ;
    private com.baidu.tieba.s.d aYa;
    private View aYb;
    private RelativeLayout mRootView;
    private int aXN = 3100;
    private Bitmap aXP = null;
    private boolean aXQ = false;
    private boolean aXR = true;
    private int aXT = -1;
    private boolean aXV = false;
    private boolean aXW = false;
    private boolean aXX = true;
    private a aXY = new a();
    private d.a aYc = new d.a() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tieba.s.d.a
        public void onError() {
            if (LogoActivity.this.aXT != -2) {
                com.baidu.adp.lib.g.e.fw().post(LogoActivity.this.aYg);
            } else {
                LogoActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.s.d.a
        public void Lt() {
            if (LogoActivity.this.aXT != -2) {
                LogoActivity.this.Lq();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener aYd = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.Lh()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra("jump_url", str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.fw().removeCallbacks(LogoActivity.this.aXY);
                    LogoActivity.this.aXW = true;
                    if (LogoActivity.this.aXX) {
                        LogoActivity.this.Lr();
                    }
                }
            }
        }
    };
    private Runnable aYe = new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.aXO != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.aXO.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.aXO);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                q.Hf().ag(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(LogoActivity.this.aXY);
            if (LogoActivity.this.aXO != null && (LogoActivity.this.aXO.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.aXO.getTag()).booleanValue()) {
                    LogoActivity.this.aXN = 6100;
                } else {
                    LogoActivity.this.aXN = 3100;
                }
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(LogoActivity.this.aXY, LogoActivity.this.aXN);
        }
    };
    private Runnable aYf = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.5.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.Lf();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aYg = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.Lo()) {
                        LogoActivity.this.Lr();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aYh = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.aXV) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.aXZ);
                com.baidu.adp.lib.g.e.fw().post(LogoActivity.this.aYg);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Lf() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.aXU = true;
            return;
        }
        if (MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.fx().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.Ls();
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
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (Lh()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(d.i.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.aYd);
                this.aXT = -2;
                Lm();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !Lg()) {
            finish();
        } else {
            TiebaStatic.log(new al("c11894").r("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
            }
            C(getIntent());
            getWindow().setFlags(1024, 1024);
            setContentView(d.i.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.aXQ = TbadkCoreApplication.getInst().getIsFirstUse();
            q.Hf().bT(this.aXQ);
            registerListener(this.aYd);
            Li();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                Lj();
            }
            if (!k.m15do()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean Lg() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new al("c11897").ac(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Lh() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Li() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.qj(), getPageContext().getPageActivity());
        }
        aX(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void Lj() {
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
        this.aXX = false;
        if (this.aYa != null) {
            this.aYa.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aXX = true;
        if (this.aXR) {
            this.aXR = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.aXW) {
            Lr();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.aXU) {
            Lf();
            this.aXU = false;
        }
        if (this.aYa != null) {
            this.aYa.onResume();
        }
        if (LogoActivityConfig.isFirst) {
            q.Hf().ae(System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.aXY);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.aYe);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.aYf);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.aYg);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.aYh);
        if (this.aYa != null) {
            this.aYa.onDestroy();
        }
        if (this.aXP != null && !this.aXP.isRecycled()) {
            this.aXP.recycle();
            this.aXP = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.gw().clearCashBitmap();
    }

    private void aX(Context context) {
        Lk();
        if (LogoActivityConfig.mFromSpacial) {
            gd(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.aXQ) {
                com.baidu.adp.lib.g.e.fw().post(this.aYf);
            } else {
                gd(1);
            }
        } else if (this.aXQ) {
            com.baidu.adp.lib.g.e.fw().post(this.aYf);
        } else {
            Ll();
        }
    }

    private void Lk() {
        if (this.aXQ) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Ll() {
        if (this.aXT != -2) {
            if (this.aYa == null) {
                this.aYa = new com.baidu.tieba.s.d(this);
            }
            if (this.aYa.bzS()) {
                this.aYb = this.aYa.p(0.8125d);
                this.mRootView.addView(this.aYb);
                this.aYa.a(this.aYc);
                this.aYa.start();
                return;
            }
            this.aYa.bzX();
        }
        Lm();
    }

    private void Lm() {
        int ak = com.baidu.adp.lib.b.d.eE().ak("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (ak == 0 || findTask == null) {
            if (this.aXT == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.fw().post(this.aYg);
                return;
            }
        }
        this.aXS = System.currentTimeMillis();
        com.baidu.tbadk.d.b bVar = new com.baidu.tbadk.d.b();
        this.aXZ = new BesAdViewContainer(getPageContext().getPageActivity());
        this.aXZ.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.9
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.Lr();
            }
        });
        this.aXZ.setLayoutParams(new RelativeLayout.LayoutParams(l.af(getPageContext().getPageActivity()), (int) (l.ah(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.aXZ);
        bVar.f(this.aXZ);
        bVar.a(new com.baidu.tbadk.d.a() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // com.baidu.tbadk.d.a
            public void ci(String str) {
                LogoActivity.this.aXV = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.aXZ);
                LogoActivity.this.Ln();
            }

            @Override // com.baidu.tbadk.d.a
            public void oY() {
                LogoActivity.this.aXV = true;
                if (LogoActivity.this.aXT == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.fw().removeCallbacks(LogoActivity.this.aYh);
                q.Hf().ag(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.d.a
            public void oZ() {
                LogoActivity.this.aXW = true;
                if (LogoActivity.this.aXX) {
                    LogoActivity.this.Lr();
                }
            }

            @Override // com.baidu.tbadk.d.a
            public void oh() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, bVar));
        q.Hf().af(System.currentTimeMillis() - this.aXS);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.aYh, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ln() {
        this.aXS = System.currentTimeMillis();
        boolean Lp = Lp();
        q.Hf().af(System.currentTimeMillis() - this.aXS);
        if (Lp) {
            com.baidu.adp.lib.g.e.fw().post(this.aYe);
            if (this.aXT == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this));
            }
        } else if (this.aXT == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.fw().post(this.aYg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Lo() {
        try {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016481, Boolean.class, 0);
            if (runTask == null || runTask.getData() == null) {
                return false;
            }
            return ((Boolean) runTask.getData()).booleanValue();
        } catch (Exception e) {
            BdLog.e(e);
            return false;
        }
    }

    private boolean Lp() {
        if (com.baidu.adp.lib.b.d.eE().ak("ad_baichuan_open") == 0) {
            return false;
        }
        int af = l.af(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016310, View.class, new com.baidu.tbadk.coreExtra.data.g(getPageContext(), (int) (l.ah(getPageContext().getPageActivity()) * 0.8125d), af));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.aXO = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lq() {
        if (this.aXT >= 0) {
            ge(this.aXT);
        } else if (this.aXT == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lr() {
        Lq();
        q.Hf().ah(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ls() {
        File[] listFiles;
        File file = new File(k.uF());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                return !TextUtils.isEmpty(name) && name.contains(LogoActivity.this.getPageContext().getString(d.k.app_name)) && name.endsWith(".apk");
            }
        })) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void gd(int i) {
        this.aXT = i;
        Ll();
    }

    private void ge(int i) {
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
                        gd(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        gd(intExtra);
                        return;
                    } else {
                        gd(1);
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
            LogoActivity.this.Lr();
        }
    }
}
