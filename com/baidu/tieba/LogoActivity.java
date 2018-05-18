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
    private View aXP;
    private long aXT;
    private boolean aXV;
    private BesAdViewContainer aYa;
    private com.baidu.tieba.s.d aYb;
    private View aYc;
    private RelativeLayout mRootView;
    private int aXO = 3100;
    private Bitmap aXQ = null;
    private boolean aXR = false;
    private boolean aXS = true;
    private int aXU = -1;
    private boolean aXW = false;
    private boolean aXX = false;
    private boolean aXY = true;
    private a aXZ = new a();
    private d.a aYd = new d.a() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tieba.s.d.a
        public void onError() {
            if (LogoActivity.this.aXU != -2) {
                com.baidu.adp.lib.g.e.fw().post(LogoActivity.this.aYh);
            } else {
                LogoActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.s.d.a
        public void Lr() {
            if (LogoActivity.this.aXU != -2) {
                LogoActivity.this.Lo();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener aYe = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.Lf()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra("jump_url", str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.fw().removeCallbacks(LogoActivity.this.aXZ);
                    LogoActivity.this.aXX = true;
                    if (LogoActivity.this.aXY) {
                        LogoActivity.this.Lp();
                    }
                }
            }
        }
    };
    private Runnable aYf = new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.aXP != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.aXP.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.aXP);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                q.Hd().ag(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(LogoActivity.this.aXZ);
            if (LogoActivity.this.aXP != null && (LogoActivity.this.aXP.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.aXP.getTag()).booleanValue()) {
                    LogoActivity.this.aXO = 6100;
                } else {
                    LogoActivity.this.aXO = 3100;
                }
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(LogoActivity.this.aXZ, LogoActivity.this.aXO);
        }
    };
    private Runnable aYg = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.5.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.Ld();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aYh = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.Lm()) {
                        LogoActivity.this.Lp();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aYi = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.aXW) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.aYa);
                com.baidu.adp.lib.g.e.fw().post(LogoActivity.this.aYh);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Ld() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.aXV = true;
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
                LogoActivity.this.Lq();
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
        if (Lf()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(d.i.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.aYe);
                this.aXU = -2;
                Lk();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !Le()) {
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
            this.aXR = TbadkCoreApplication.getInst().getIsFirstUse();
            q.Hd().bT(this.aXR);
            registerListener(this.aYe);
            Lg();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                Lh();
            }
            if (!k.m15do()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean Le() {
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
    public boolean Lf() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Lg() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.qi(), getPageContext().getPageActivity());
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

    private void Lh() {
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
        this.aXY = false;
        if (this.aYb != null) {
            this.aYb.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aXY = true;
        if (this.aXS) {
            this.aXS = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.aXX) {
            Lp();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.aXV) {
            Ld();
            this.aXV = false;
        }
        if (this.aYb != null) {
            this.aYb.onResume();
        }
        if (LogoActivityConfig.isFirst) {
            q.Hd().ae(System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.aXZ);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.aYf);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.aYg);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.aYh);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.aYi);
        if (this.aYb != null) {
            this.aYb.onDestroy();
        }
        if (this.aXQ != null && !this.aXQ.isRecycled()) {
            this.aXQ.recycle();
            this.aXQ = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.gw().clearCashBitmap();
    }

    private void aX(Context context) {
        Li();
        if (LogoActivityConfig.mFromSpacial) {
            ge(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.aXR) {
                com.baidu.adp.lib.g.e.fw().post(this.aYg);
            } else {
                ge(1);
            }
        } else if (this.aXR) {
            com.baidu.adp.lib.g.e.fw().post(this.aYg);
        } else {
            Lj();
        }
    }

    private void Li() {
        if (this.aXR) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Lj() {
        if (this.aXU != -2) {
            if (this.aYb == null) {
                this.aYb = new com.baidu.tieba.s.d(this);
            }
            if (this.aYb.bzQ()) {
                this.aYc = this.aYb.p(0.8125d);
                this.mRootView.addView(this.aYc);
                this.aYb.a(this.aYd);
                this.aYb.start();
                return;
            }
            this.aYb.bzV();
        }
        Lk();
    }

    private void Lk() {
        int ak = com.baidu.adp.lib.b.d.eE().ak("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (ak == 0 || findTask == null) {
            if (this.aXU == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.fw().post(this.aYh);
                return;
            }
        }
        this.aXT = System.currentTimeMillis();
        com.baidu.tbadk.d.b bVar = new com.baidu.tbadk.d.b();
        this.aYa = new BesAdViewContainer(getPageContext().getPageActivity());
        this.aYa.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.9
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.Lp();
            }
        });
        this.aYa.setLayoutParams(new RelativeLayout.LayoutParams(l.af(getPageContext().getPageActivity()), (int) (l.ah(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.aYa);
        bVar.f(this.aYa);
        bVar.a(new com.baidu.tbadk.d.a() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // com.baidu.tbadk.d.a
            public void ci(String str) {
                LogoActivity.this.aXW = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.aYa);
                LogoActivity.this.Ll();
            }

            @Override // com.baidu.tbadk.d.a
            public void oX() {
                LogoActivity.this.aXW = true;
                if (LogoActivity.this.aXU == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.fw().removeCallbacks(LogoActivity.this.aYi);
                q.Hd().ag(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.d.a
            public void oY() {
                LogoActivity.this.aXX = true;
                if (LogoActivity.this.aXY) {
                    LogoActivity.this.Lp();
                }
            }

            @Override // com.baidu.tbadk.d.a
            public void og() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, bVar));
        q.Hd().af(System.currentTimeMillis() - this.aXT);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.aYi, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ll() {
        this.aXT = System.currentTimeMillis();
        boolean Ln = Ln();
        q.Hd().af(System.currentTimeMillis() - this.aXT);
        if (Ln) {
            com.baidu.adp.lib.g.e.fw().post(this.aYf);
            if (this.aXU == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this));
            }
        } else if (this.aXU == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.fw().post(this.aYh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Lm() {
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

    private boolean Ln() {
        if (com.baidu.adp.lib.b.d.eE().ak("ad_baichuan_open") == 0) {
            return false;
        }
        int af = l.af(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016310, View.class, new com.baidu.tbadk.coreExtra.data.g(getPageContext(), (int) (l.ah(getPageContext().getPageActivity()) * 0.8125d), af));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.aXP = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lo() {
        if (this.aXU >= 0) {
            gf(this.aXU);
        } else if (this.aXU == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lp() {
        Lo();
        q.Hd().ah(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lq() {
        File[] listFiles;
        File file = new File(k.uE());
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

    private void ge(int i) {
        this.aXU = i;
        Lj();
    }

    private void gf(int i) {
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
                        ge(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        ge(intExtra);
                        return;
                    } else {
                        ge(1);
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
            LogoActivity.this.Lp();
        }
    }
}
