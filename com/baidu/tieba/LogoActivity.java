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
    private View bhk;
    private long bho;
    private boolean bhq;
    private BesAdViewContainer bhv;
    private com.baidu.tieba.v.d bhw;
    private View bhx;
    private com.baidu.tbadk.d.b bhy;
    private RelativeLayout mRootView;
    private int bhj = 3100;
    private Bitmap bhl = null;
    private boolean bhm = false;
    private boolean bhn = true;
    private int bhp = -1;
    private boolean bhr = false;
    private boolean bhs = false;
    private boolean bht = true;
    private a bhu = new a();
    private long bhz = -1;
    private d.a bhA = new d.a() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tieba.v.d.a
        public void onError() {
            if (LogoActivity.this.bhp != -2) {
                com.baidu.adp.lib.g.e.im().post(LogoActivity.this.bhE);
            } else {
                LogoActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.v.d.a
        public void Pj() {
            if (LogoActivity.this.bhp != -2) {
                LogoActivity.this.Pg();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener bhB = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.OX()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.im().removeCallbacks(LogoActivity.this.bhu);
                    LogoActivity.this.bhs = true;
                    if (LogoActivity.this.bht) {
                        LogoActivity.this.Ph();
                    }
                }
            }
        }
    };
    private Runnable bhC = new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.bhk != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.bhk.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.bhk);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                n.KP().al(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.im().removeCallbacks(LogoActivity.this.bhu);
            if (LogoActivity.this.bhk != null && (LogoActivity.this.bhk.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.bhk.getTag()).booleanValue()) {
                    LogoActivity.this.bhj = 6100;
                } else {
                    LogoActivity.this.bhj = 3100;
                }
            }
            com.baidu.adp.lib.g.e.im().postDelayed(LogoActivity.this.bhu, LogoActivity.this.bhj);
        }
    };
    private Runnable bhD = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.5.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.OV();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bhE = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.Pe()) {
                        LogoActivity.this.Ph();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bhF = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bhr) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bhv);
                com.baidu.adp.lib.g.e.im().post(LogoActivity.this.bhE);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void OV() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bhq = true;
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
                LogoActivity.this.Pi();
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
        this.bhz = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (OX()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(d.i.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bhB);
                this.bhp = -2;
                Pc();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !OW()) {
            finish();
        } else {
            TiebaStatic.log(new an("c11894").r("obj_param1", 2));
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
            this.bhm = TbadkCoreApplication.getInst().getIsFirstUse();
            n.KP().cb(this.bhm);
            registerListener(this.bhB);
            OY();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                OZ();
            }
            if (!l.ge()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean OW() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new an("c11897").ah(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OX() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void OY() {
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

    private void OZ() {
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
        this.bht = false;
        if (this.bhw != null) {
            this.bhw.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bht = true;
        if (this.bhn) {
            this.bhn = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bhs) {
            Ph();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.bhq) {
            OV();
            this.bhq = false;
        }
        if (this.bhw != null) {
            this.bhw.onResume();
        }
        if (LogoActivityConfig.isFirst && this.bhz >= 0) {
            n.KP().aj(System.currentTimeMillis() - this.bhz);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bhy != null) {
            this.bhy.f(null);
            this.bhy.a(null);
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bhu);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bhC);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bhD);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bhE);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.bhF);
        if (this.bhw != null) {
            this.bhw.onDestroy();
        }
        if (this.bhl != null && !this.bhl.isRecycled()) {
            this.bhl.recycle();
            this.bhl = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.jl().clearCashBitmap();
    }

    private void bh(Context context) {
        Pa();
        if (LogoActivityConfig.mFromSpacial) {
            gg(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bhm) {
                com.baidu.adp.lib.g.e.im().post(this.bhD);
            } else {
                gg(1);
            }
        } else if (this.bhm) {
            com.baidu.adp.lib.g.e.im().post(this.bhD);
        } else {
            Pb();
        }
    }

    private void Pa() {
        if (this.bhm) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Pb() {
        if (this.bhp != -2) {
            if (this.bhw == null) {
                this.bhw = new com.baidu.tieba.v.d(this);
            }
            if (this.bhw.bFv()) {
                this.bhx = this.bhw.p(0.8125d);
                this.mRootView.addView(this.bhx);
                this.bhw.a(this.bhA);
                this.bhw.start();
                return;
            }
            this.bhw.bFA();
        }
        Pc();
    }

    private void Pc() {
        int aw = com.baidu.adp.lib.b.d.hv().aw("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (aw == 0 || findTask == null) {
            if (this.bhp == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.im().post(this.bhE);
                return;
            }
        }
        this.bho = System.currentTimeMillis();
        this.bhy = new com.baidu.tbadk.d.b();
        this.bhv = new BesAdViewContainer(getPageContext().getPageActivity());
        this.bhv.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.9
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.Ph();
            }
        });
        this.bhv.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.ah(getPageContext().getPageActivity()), (int) (com.baidu.adp.lib.util.l.aj(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bhv);
        this.bhy.f(this.bhv);
        this.bhy.a(new com.baidu.tbadk.d.a() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // com.baidu.tbadk.d.a
            public void cL(String str) {
                LogoActivity.this.bhr = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bhv);
                LogoActivity.this.Pd();
            }

            @Override // com.baidu.tbadk.d.a
            public void ss() {
                LogoActivity.this.bhr = true;
                if (LogoActivity.this.bhp == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.im().removeCallbacks(LogoActivity.this.bhF);
                n.KP().al(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.d.a
            public void st() {
                LogoActivity.this.bhs = true;
                if (LogoActivity.this.bht) {
                    LogoActivity.this.Ph();
                }
            }

            @Override // com.baidu.tbadk.d.a
            public void rt() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.bhy));
        n.KP().ak(System.currentTimeMillis() - this.bho);
        com.baidu.adp.lib.g.e.im().postDelayed(this.bhF, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pd() {
        this.bho = System.currentTimeMillis();
        boolean Pf = Pf();
        n.KP().ak(System.currentTimeMillis() - this.bho);
        if (Pf) {
            com.baidu.adp.lib.g.e.im().post(this.bhC);
            if (this.bhp == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this));
            }
        } else if (this.bhp == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.im().post(this.bhE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Pe() {
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

    private boolean Pf() {
        if (com.baidu.adp.lib.b.d.hv().aw("ad_baichuan_open") == 0) {
            return false;
        }
        int ah = com.baidu.adp.lib.util.l.ah(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016310, View.class, new com.baidu.tbadk.coreExtra.data.g(getPageContext(), (int) (com.baidu.adp.lib.util.l.aj(getPageContext().getPageActivity()) * 0.8125d), ah));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.bhk = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pg() {
        if (this.bhp >= 0) {
            gh(this.bhp);
        } else if (this.bhp == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph() {
        Pg();
        n.KP().am(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pi() {
        File[] listFiles;
        File file = new File(l.ys());
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

    private void gg(int i) {
        this.bhp = i;
        Pb();
    }

    private void gh(int i) {
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
                        gg(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        gg(intExtra);
                        return;
                    } else {
                        gg(1);
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
            LogoActivity.this.Ph();
        }
    }
}
