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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.k.n;
import com.baidu.tieba.c;
import com.baidu.tieba.d;
import com.baidu.tieba.v.d;
import com.baidu.tieba.view.BesAdViewContainer;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private View bfW;
    private long bga;
    private boolean bgc;
    private BesAdViewContainer bgh;
    private com.baidu.tieba.v.d bgi;
    private View bgj;
    private com.baidu.tbadk.d.b bgk;
    private RelativeLayout mRootView;
    private int bfV = 3100;
    private Bitmap bfX = null;
    private boolean bfY = false;
    private boolean bfZ = true;
    private int bgb = -1;
    private boolean bgd = false;
    private boolean bge = false;
    private boolean bgf = true;
    private a bgg = new a();
    private long bgl = -1;
    private d.a bgm = new d.a() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tieba.v.d.a
        public void onError() {
            if (LogoActivity.this.bgb != -2) {
                com.baidu.adp.lib.g.e.im().post(LogoActivity.this.bgq);
            } else {
                LogoActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.v.d.a
        public void OQ() {
            if (LogoActivity.this.bgb != -2) {
                LogoActivity.this.ON();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener bgn = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.OE()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra("jump_url", str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.im().removeCallbacks(LogoActivity.this.bgg);
                    LogoActivity.this.bge = true;
                    if (LogoActivity.this.bgf) {
                        LogoActivity.this.OO();
                    }
                }
            }
        }
    };
    private Runnable bgo = new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.bfW != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.bfW.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.bfW);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                n.Kx().ak(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.im().removeCallbacks(LogoActivity.this.bgg);
            if (LogoActivity.this.bfW != null && (LogoActivity.this.bfW.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.bfW.getTag()).booleanValue()) {
                    LogoActivity.this.bfV = 6100;
                } else {
                    LogoActivity.this.bfV = 3100;
                }
            }
            com.baidu.adp.lib.g.e.im().postDelayed(LogoActivity.this.bgg, LogoActivity.this.bfV);
        }
    };
    private Runnable bgp = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.5.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.OC();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bgq = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.OL()) {
                        LogoActivity.this.OO();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bgr = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bgd) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bgh);
                com.baidu.adp.lib.g.e.im().post(LogoActivity.this.bgq);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void OC() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bgc = true;
            return;
        }
        if (MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.in().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.OP();
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
        this.bgl = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (OE()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(d.i.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bgn);
                this.bgb = -2;
                OJ();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !OD()) {
            finish();
        } else {
            TiebaStatic.log(new am("c11894").r("obj_param1", 2));
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
            this.bfY = TbadkCoreApplication.getInst().getIsFirstUse();
            n.Kx().bY(this.bfY);
            registerListener(this.bgn);
            OF();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                OG();
            }
            if (!l.ge()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean OD() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new am("c11897").ah(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OE() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void OF() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.tE(), getPageContext().getPageActivity());
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

    private void OG() {
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
        this.bgf = false;
        if (this.bgi != null) {
            this.bgi.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bgf = true;
        if (this.bfZ) {
            this.bfZ = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bge) {
            OO();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.bgc) {
            OC();
            this.bgc = false;
        }
        if (this.bgi != null) {
            this.bgi.onResume();
        }
        if (LogoActivityConfig.isFirst && this.bgl >= 0) {
            n.Kx().ai(System.currentTimeMillis() - this.bgl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bgk != null) {
            this.bgk.f(null);
            this.bgk.a(null);
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bgg);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bgo);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bgp);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bgq);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bgr);
        if (this.bgi != null) {
            this.bgi.onDestroy();
        }
        if (this.bfX != null && !this.bfX.isRecycled()) {
            this.bfX.recycle();
            this.bfX = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.jl().clearCashBitmap();
    }

    private void bh(Context context) {
        OH();
        if (LogoActivityConfig.mFromSpacial) {
            gf(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bfY) {
                com.baidu.adp.lib.g.e.im().post(this.bgp);
            } else {
                gf(1);
            }
        } else if (this.bfY) {
            com.baidu.adp.lib.g.e.im().post(this.bgp);
        } else {
            OI();
        }
    }

    private void OH() {
        if (this.bfY) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void OI() {
        if (this.bgb != -2) {
            if (this.bgi == null) {
                this.bgi = new com.baidu.tieba.v.d(this);
            }
            if (this.bgi.bEV()) {
                this.bgj = this.bgi.q(0.8125d);
                this.mRootView.addView(this.bgj);
                this.bgi.a(this.bgm);
                this.bgi.start();
                return;
            }
            this.bgi.bFa();
        }
        OJ();
    }

    private void OJ() {
        int aw = com.baidu.adp.lib.b.d.hv().aw("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (aw == 0 || findTask == null) {
            if (this.bgb == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.im().post(this.bgq);
                return;
            }
        }
        this.bga = System.currentTimeMillis();
        this.bgk = new com.baidu.tbadk.d.b();
        this.bgh = new BesAdViewContainer(getPageContext().getPageActivity());
        this.bgh.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.9
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.OO();
            }
        });
        this.bgh.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ah(getPageContext().getPageActivity()), (int) (com.baidu.adp.lib.util.l.aj(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bgh);
        this.bgk.f(this.bgh);
        this.bgk.a(new com.baidu.tbadk.d.a() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // com.baidu.tbadk.d.a
            public void cJ(String str) {
                LogoActivity.this.bgd = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bgh);
                LogoActivity.this.OK();
            }

            @Override // com.baidu.tbadk.d.a
            public void ss() {
                LogoActivity.this.bgd = true;
                if (LogoActivity.this.bgb == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.im().removeCallbacks(LogoActivity.this.bgr);
                n.Kx().ak(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.d.a
            public void st() {
                LogoActivity.this.bge = true;
                if (LogoActivity.this.bgf) {
                    LogoActivity.this.OO();
                }
            }

            @Override // com.baidu.tbadk.d.a
            public void rt() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.bgk));
        n.Kx().aj(System.currentTimeMillis() - this.bga);
        com.baidu.adp.lib.g.e.im().postDelayed(this.bgr, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OK() {
        this.bga = System.currentTimeMillis();
        boolean OM = OM();
        n.Kx().aj(System.currentTimeMillis() - this.bga);
        if (OM) {
            com.baidu.adp.lib.g.e.im().post(this.bgo);
            if (this.bgb == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this));
            }
        } else if (this.bgb == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.im().post(this.bgq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OL() {
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

    private boolean OM() {
        if (com.baidu.adp.lib.b.d.hv().aw("ad_baichuan_open") == 0) {
            return false;
        }
        int ah = com.baidu.adp.lib.util.l.ah(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016310, View.class, new com.baidu.tbadk.coreExtra.data.g(getPageContext(), (int) (com.baidu.adp.lib.util.l.aj(getPageContext().getPageActivity()) * 0.8125d), ah));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.bfW = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ON() {
        if (this.bgb >= 0) {
            gg(this.bgb);
        } else if (this.bgb == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OO() {
        ON();
        n.Kx().al(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OP() {
        File[] listFiles;
        File file = new File(l.ye());
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

    private void gf(int i) {
        this.bgb = i;
        OI();
    }

    private void gg(int i) {
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
                        gf(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        gf(intExtra);
                        return;
                    } else {
                        gf(1);
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
            LogoActivity.this.OO();
        }
    }
}
