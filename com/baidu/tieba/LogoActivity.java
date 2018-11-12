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
import com.baidu.tbadk.core.atomData.SecretHintActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.i;
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
    private long bsA;
    private boolean bsC;
    private BesAdViewContainer bsH;
    private com.baidu.tieba.u.d bsI;
    private View bsJ;
    private com.baidu.tbadk.e.b bsK;
    private View bsw;
    private RelativeLayout mRootView;
    private int bsv = 3100;
    private Bitmap bsx = null;
    private boolean bsy = false;
    private boolean bsz = true;
    private int bsB = -1;
    private boolean bsD = false;
    private boolean bsE = false;
    private boolean bsF = true;
    private a bsG = new a();
    private long bsL = -1;
    private d.a bsM = new d.a() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            if (LogoActivity.this.bsB != -2) {
                com.baidu.adp.lib.g.e.jG().post(LogoActivity.this.bsQ);
            } else {
                LogoActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.u.d.a
        public void Tn() {
            if (LogoActivity.this.bsB != -2) {
                LogoActivity.this.Ti();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener bsN = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.SZ()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bsG);
                    LogoActivity.this.bsE = true;
                    if (LogoActivity.this.bsF) {
                        LogoActivity.this.Tj();
                    }
                }
            }
        }
    };
    private Runnable bsO = new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.bsw != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.bsw.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.bsw);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                n.Ol().av(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bsG);
            if (LogoActivity.this.bsw != null && (LogoActivity.this.bsw.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.bsw.getTag()).booleanValue()) {
                    LogoActivity.this.bsv = 6100;
                } else {
                    LogoActivity.this.bsv = 3100;
                }
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(LogoActivity.this.bsG, LogoActivity.this.bsv);
        }
    };
    private Runnable bsP = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            d.a(LogoActivity.this.getPageContext(), new d.a() { // from class: com.baidu.tieba.LogoActivity.5.1
                @Override // com.baidu.tieba.d.a
                public void onCompleted() {
                    LogoActivity.this.SX();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bsQ = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            d.a(LogoActivity.this.getPageContext(), new d.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.d.a
                public void onCompleted() {
                    if (!LogoActivity.this.Tg()) {
                        LogoActivity.this.Tj();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bsR = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bsD) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bsH);
                com.baidu.adp.lib.g.e.jG().post(LogoActivity.this.bsQ);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void SX() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bsC = true;
            return;
        }
        if (MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.Tk();
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
        this.bsL = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (Tm()) {
            Tl();
        } else if (SZ()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(e.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(e.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bsN);
                this.bsB = -2;
                Te();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !SY()) {
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
            this.bsy = TbadkCoreApplication.getInst().getIsFirstUse();
            n.Ol().cM(this.bsy);
            registerListener(this.bsN);
            Ta();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                Tb();
            }
            if (!l.hA()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean SY() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new am("c11897").ax(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SZ() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Ta() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.wJ(), getPageContext().getPageActivity());
        }
        bT(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void Tb() {
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
        this.bsF = false;
        if (this.bsI != null) {
            this.bsI.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bsF = true;
        if (this.bsz) {
            this.bsz = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bsE) {
            Tj();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.bsC) {
            SX();
            this.bsC = false;
        }
        if (this.bsI != null) {
            this.bsI.onResume();
        }
        if (LogoActivityConfig.isFirst && this.bsL >= 0) {
            n.Ol().at(System.currentTimeMillis() - this.bsL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bsK != null) {
            this.bsK.e(null);
            this.bsK.a(null);
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bsG);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bsO);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bsP);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bsQ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bsR);
        if (this.bsI != null) {
            this.bsI.onDestroy();
        }
        if (this.bsx != null && !this.bsx.isRecycled()) {
            this.bsx.recycle();
            this.bsx = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.kE().clearCashBitmap();
    }

    private void bT(Context context) {
        Tc();
        if (LogoActivityConfig.mFromSpacial) {
            hg(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bsy) {
                com.baidu.adp.lib.g.e.jG().post(this.bsP);
            } else {
                hg(1);
            }
        } else if (this.bsy) {
            com.baidu.adp.lib.g.e.jG().post(this.bsP);
        } else {
            Td();
        }
    }

    private void Tc() {
        if (this.bsy) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Td() {
        if (this.bsB != -2) {
            if (this.bsI == null) {
                this.bsI = new com.baidu.tieba.u.d(this);
            }
            if (this.bsI.bJK()) {
                this.bsJ = this.bsI.n(0.8125d);
                this.mRootView.addView(this.bsJ);
                this.bsI.a(this.bsM);
                this.bsI.start();
                return;
            }
            this.bsI.bJP();
        }
        Te();
    }

    private void Te() {
        int aO = com.baidu.adp.lib.b.d.iQ().aO("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (aO == 0 || findTask == null) {
            if (this.bsB == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.jG().post(this.bsQ);
                return;
            }
        }
        this.bsA = System.currentTimeMillis();
        this.bsK = new com.baidu.tbadk.e.b();
        this.bsH = new BesAdViewContainer(getPageContext().getPageActivity());
        this.bsH.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.9
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.Tj();
            }
        });
        this.bsH.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.aO(getPageContext().getPageActivity()), (int) (com.baidu.adp.lib.util.l.aQ(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bsH);
        this.bsK.e(this.bsH);
        this.bsK.a(new com.baidu.tbadk.e.a() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // com.baidu.tbadk.e.a
            public void dp(String str) {
                LogoActivity.this.bsD = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bsH);
                LogoActivity.this.Tf();
            }

            @Override // com.baidu.tbadk.e.a
            public void vC() {
                LogoActivity.this.bsD = true;
                if (LogoActivity.this.bsB == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bsR);
                n.Ol().av(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.e.a
            public void vD() {
                LogoActivity.this.bsE = true;
                if (LogoActivity.this.bsF) {
                    LogoActivity.this.Tj();
                }
            }

            @Override // com.baidu.tbadk.e.a
            public void uj() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.bsK));
        n.Ol().au(System.currentTimeMillis() - this.bsA);
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bsR, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        this.bsA = System.currentTimeMillis();
        boolean Th = Th();
        n.Ol().au(System.currentTimeMillis() - this.bsA);
        if (Th) {
            com.baidu.adp.lib.g.e.jG().post(this.bsO);
            if (this.bsB == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this));
            }
        } else if (this.bsB == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.jG().post(this.bsQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Tg() {
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

    private boolean Th() {
        if (com.baidu.adp.lib.b.d.iQ().aO("ad_baichuan_open") == 0) {
            return false;
        }
        int aO = com.baidu.adp.lib.util.l.aO(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016310, View.class, new i(getPageContext(), (int) (com.baidu.adp.lib.util.l.aQ(getPageContext().getPageActivity()) * 0.8125d), aO));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.bsw = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ti() {
        if (this.bsB >= 0) {
            hh(this.bsB);
        } else if (this.bsB == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tj() {
        Ti();
        n.Ol().aw(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tk() {
        File[] listFiles;
        File file = new File(l.getCacheDir());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.2
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

    private void hg(int i) {
        this.bsB = i;
        Td();
    }

    private void hh(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private void Tl() {
        sendMessage(new CustomMessage(2002001, new SecretHintActivityConfig(getPageContext().getPageActivity())));
        finish();
    }

    private boolean Tm() {
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
                        hg(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        hg(intExtra);
                        return;
                    } else {
                        hg(1);
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
            LogoActivity.this.Tj();
        }
    }
}
