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
    private long bwP;
    private boolean bwR;
    private BesAdViewContainer bwW;
    private com.baidu.tieba.v.d bwX;
    private View bwY;
    private com.baidu.tbadk.e.b bwZ;
    private com.baidu.tbadk.q.a bxa;
    private RelativeLayout mRootView;
    private Bitmap bwM = null;
    private boolean bwN = false;
    private boolean bwO = true;
    private int bwQ = -1;
    private boolean bwS = false;
    private boolean bwT = false;
    private boolean bwU = true;
    private a bwV = new a();
    private com.baidu.tbadk.q.b bxb = new com.baidu.tbadk.q.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.q.b
        public void Qa() {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bxi);
            LogoActivity.this.UJ();
        }

        @Override // com.baidu.tbadk.q.b
        public void w(String str, boolean z) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bxi);
            if (LogoActivity.this.bxa.getView() == null) {
                LogoActivity.this.UN();
                return;
            }
            int aO = l.aO(LogoActivity.this.getPageContext().getPageActivity());
            int aQ = l.aQ(LogoActivity.this.getPageContext().getPageActivity());
            if (!z) {
                aQ = (int) (l.aQ(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.bxa.getView().setLayoutParams(new RelativeLayout.LayoutParams(aO, aQ));
            LogoActivity.this.mRootView.addView(LogoActivity.this.bxa.getView());
            if (LogoActivity.this.bwQ == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
            }
            n.PJ().aD(System.currentTimeMillis());
            TiebaStatic.log(new am("c13331").aB(VideoPlayActivityConfig.OBJ_ID, str));
        }

        @Override // com.baidu.tbadk.q.b
        public void wO() {
            LogoActivity.this.bwT = true;
            if (LogoActivity.this.bwU) {
                LogoActivity.this.UN();
            }
        }

        @Override // com.baidu.tbadk.q.b
        public void iL(String str) {
            TiebaStatic.log(new am("c13332").aB(VideoPlayActivityConfig.OBJ_ID, str));
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.UN();
        }
    };
    private long bxc = -1;
    private d.a bxd = new d.a() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // com.baidu.tieba.v.d.a
        public void onError() {
            LogoActivity.this.UK();
        }

        @Override // com.baidu.tieba.v.d.a
        public void UR() {
            if (LogoActivity.this.bwQ != -2) {
                LogoActivity.this.UM();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener bxe = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.UD()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bwV);
                    LogoActivity.this.bwT = true;
                    if (LogoActivity.this.bwU) {
                        LogoActivity.this.UN();
                    }
                }
            }
        }
    };
    private Runnable bxf = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            d.a(LogoActivity.this.getPageContext(), new d.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.d.a
                public void onCompleted() {
                    LogoActivity.this.UB();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bxg = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            d.a(LogoActivity.this.getPageContext(), new d.a() { // from class: com.baidu.tieba.LogoActivity.7.1
                @Override // com.baidu.tieba.d.a
                public void onCompleted() {
                    if (!LogoActivity.this.UL()) {
                        LogoActivity.this.UN();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bxh = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bwS) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bwW);
                com.baidu.adp.lib.g.e.jG().post(LogoActivity.this.bxg);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable bxi = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.UK();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void UB() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bwR = true;
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
                LogoActivity.this.UO();
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
        this.bxc = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (UQ()) {
            UP();
        } else if (UD()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(e.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(e.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bxe);
                this.bwQ = -2;
                UI();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !UC()) {
            finish();
        } else {
            TiebaStatic.log(new am("c11894").y("obj_param1", 2));
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
            this.bwN = TbadkCoreApplication.getInst().getIsFirstUse();
            n.PJ().cQ(this.bwN);
            registerListener(this.bxe);
            UE();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                UF();
            }
            if (!com.baidu.tbadk.core.util.l.hA()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean UC() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new am("c11897").aB(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean UD() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void UE() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.ya(), getPageContext().getPageActivity());
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

    private void UF() {
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
        this.bwU = false;
        if (this.bwX != null) {
            this.bwX.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bwU = true;
        if (this.bwO) {
            this.bwO = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bwT) {
            UN();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.bwR) {
            UB();
            this.bwR = false;
        }
        if (this.bwX != null) {
            this.bwX.onResume();
        }
        if (LogoActivityConfig.isFirst && this.bxc >= 0) {
            n.PJ().aB(System.currentTimeMillis() - this.bxc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bwZ != null) {
            this.bwZ.e(null);
            this.bwZ.a(null);
        }
        if (this.bxa != null) {
            this.bxa.release();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bwV);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bxf);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bxg);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bxh);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bxi);
        if (this.bwX != null) {
            this.bwX.onDestroy();
        }
        if (this.bwM != null && !this.bwM.isRecycled()) {
            this.bwM.recycle();
            this.bwM = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.kE().clearCashBitmap();
    }

    private void bW(Context context) {
        UG();
        if (LogoActivityConfig.mFromSpacial) {
            hv(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bwN) {
                com.baidu.adp.lib.g.e.jG().post(this.bxf);
            } else {
                hv(1);
            }
        } else if (this.bwN) {
            com.baidu.adp.lib.g.e.jG().post(this.bxf);
        } else {
            UH();
        }
    }

    private void UG() {
        if (this.bwN) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void UH() {
        if (this.bwQ != -2) {
            if (this.bwX == null) {
                this.bwX = new com.baidu.tieba.v.d(this);
            }
            if (this.bwX.bNm()) {
                this.bwY = this.bwX.n(0.8125d);
                this.mRootView.addView(this.bwY);
                this.bwX.a(this.bxd);
                this.bwX.start();
                return;
            }
            this.bwX.bNr();
        }
        UI();
    }

    private void UI() {
        this.bwP = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921382, com.baidu.tbadk.q.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.bxa = (com.baidu.tbadk.q.a) runTask.getData();
            this.bxa.a(this.bxb);
            this.bxa.PZ();
            n.PJ().aC(System.currentTimeMillis() - this.bwP);
            int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(this.bxi, i * 1000);
            return;
        }
        UJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UJ() {
        int aO = com.baidu.adp.lib.b.d.iQ().aO("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (aO == 0 || findTask == null) {
            UK();
        }
        this.bwP = System.currentTimeMillis();
        this.bwZ = new com.baidu.tbadk.e.b();
        this.bwW = new BesAdViewContainer(getPageContext().getPageActivity());
        this.bwW.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.UN();
            }
        });
        this.bwW.setLayoutParams(new RelativeLayout.LayoutParams(l.aO(getPageContext().getPageActivity()), (int) (l.aQ(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bwW);
        this.bwZ.e(this.bwW);
        this.bwZ.a(new com.baidu.tbadk.e.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.e.a
            public void dG(String str) {
                LogoActivity.this.bwS = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bwW);
                LogoActivity.this.UK();
            }

            @Override // com.baidu.tbadk.e.a
            public void wN() {
                LogoActivity.this.bwS = true;
                if (LogoActivity.this.bwQ == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.jG().removeCallbacks(LogoActivity.this.bxh);
                n.PJ().aD(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.e.a
            public void wO() {
                LogoActivity.this.bwT = true;
                if (LogoActivity.this.bwU) {
                    LogoActivity.this.UN();
                }
            }

            @Override // com.baidu.tbadk.e.a
            public void um() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.bwZ));
        n.PJ().aC(System.currentTimeMillis() - this.bwP);
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bxh, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UK() {
        if (this.bwQ == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.jG().post(this.bxg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean UL() {
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
    public void UM() {
        if (this.bwQ >= 0) {
            hw(this.bwQ);
        } else if (this.bwQ == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UN() {
        UM();
        n.PJ().aE(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UO() {
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
        this.bwQ = i;
        UH();
    }

    private void hw(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private void UP() {
        sendMessage(new CustomMessage(2002001, new SecretHintActivityConfig(getPageContext().getPageActivity())));
        finish();
    }

    private boolean UQ() {
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
            LogoActivity.this.UN();
        }
    }
}
