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
    private View brK;
    private long brO;
    private boolean brQ;
    private BesAdViewContainer brV;
    private com.baidu.tieba.u.d brW;
    private View brX;
    private com.baidu.tbadk.e.b brY;
    private RelativeLayout mRootView;
    private int brJ = 3100;
    private Bitmap brL = null;
    private boolean brM = false;
    private boolean brN = true;
    private int brP = -1;
    private boolean brR = false;
    private boolean brS = false;
    private boolean brT = true;
    private a brU = new a();
    private long brZ = -1;
    private d.a bsa = new d.a() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            if (LogoActivity.this.brP != -2) {
                com.baidu.adp.lib.g.e.jI().post(LogoActivity.this.bse);
            } else {
                LogoActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.u.d.a
        public void Te() {
            if (LogoActivity.this.brP != -2) {
                LogoActivity.this.SZ();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener bsb = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.SQ()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.jI().removeCallbacks(LogoActivity.this.brU);
                    LogoActivity.this.brS = true;
                    if (LogoActivity.this.brT) {
                        LogoActivity.this.Ta();
                    }
                }
            }
        }
    };
    private Runnable bsc = new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.brK != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.brK.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.brK);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                n.Oc().at(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.jI().removeCallbacks(LogoActivity.this.brU);
            if (LogoActivity.this.brK != null && (LogoActivity.this.brK.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.brK.getTag()).booleanValue()) {
                    LogoActivity.this.brJ = 6100;
                } else {
                    LogoActivity.this.brJ = 3100;
                }
            }
            com.baidu.adp.lib.g.e.jI().postDelayed(LogoActivity.this.brU, LogoActivity.this.brJ);
        }
    };
    private Runnable bsd = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            d.a(LogoActivity.this.getPageContext(), new d.a() { // from class: com.baidu.tieba.LogoActivity.5.1
                @Override // com.baidu.tieba.d.a
                public void onCompleted() {
                    LogoActivity.this.SO();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bse = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            d.a(LogoActivity.this.getPageContext(), new d.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.d.a
                public void onCompleted() {
                    if (!LogoActivity.this.SX()) {
                        LogoActivity.this.Ta();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bsf = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.brR) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.brV);
                com.baidu.adp.lib.g.e.jI().post(LogoActivity.this.bse);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void SO() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.brQ = true;
            return;
        }
        if (MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        com.baidu.adp.lib.g.h.jJ().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.Tb();
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
        this.brZ = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (Td()) {
            Tc();
        } else if (SQ()) {
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(e.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(e.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bsb);
                this.brP = -2;
                SV();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !SP()) {
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
            this.brM = TbadkCoreApplication.getInst().getIsFirstUse();
            n.Oc().cv(this.brM);
            registerListener(this.bsb);
            SR();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                SS();
            }
            if (!l.hB()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean SP() {
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
    public boolean SQ() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void SR() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.wB(), getPageContext().getPageActivity());
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

    private void SS() {
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
        this.brT = false;
        if (this.brW != null) {
            this.brW.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.brT = true;
        if (this.brN) {
            this.brN = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.brS) {
            Ta();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.brQ) {
            SO();
            this.brQ = false;
        }
        if (this.brW != null) {
            this.brW.onResume();
        }
        if (LogoActivityConfig.isFirst && this.brZ >= 0) {
            n.Oc().ar(System.currentTimeMillis() - this.brZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.brY != null) {
            this.brY.e(null);
            this.brY.a(null);
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.brU);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bsc);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bsd);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bse);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bsf);
        if (this.brW != null) {
            this.brW.onDestroy();
        }
        if (this.brL != null && !this.brL.isRecycled()) {
            this.brL.recycle();
            this.brL = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.kG().clearCashBitmap();
    }

    private void bW(Context context) {
        ST();
        if (LogoActivityConfig.mFromSpacial) {
            gT(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.brM) {
                com.baidu.adp.lib.g.e.jI().post(this.bsd);
            } else {
                gT(1);
            }
        } else if (this.brM) {
            com.baidu.adp.lib.g.e.jI().post(this.bsd);
        } else {
            SU();
        }
    }

    private void ST() {
        if (this.brM) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void SU() {
        if (this.brP != -2) {
            if (this.brW == null) {
                this.brW = new com.baidu.tieba.u.d(this);
            }
            if (this.brW.bKl()) {
                this.brX = this.brW.n(0.8125d);
                this.mRootView.addView(this.brX);
                this.brW.a(this.bsa);
                this.brW.start();
                return;
            }
            this.brW.bKq();
        }
        SV();
    }

    private void SV() {
        int aO = com.baidu.adp.lib.b.d.iR().aO("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (aO == 0 || findTask == null) {
            if (this.brP == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.jI().post(this.bse);
                return;
            }
        }
        this.brO = System.currentTimeMillis();
        this.brY = new com.baidu.tbadk.e.b();
        this.brV = new BesAdViewContainer(getPageContext().getPageActivity());
        this.brV.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.9
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.Ta();
            }
        });
        this.brV.setLayoutParams(new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.aO(getPageContext().getPageActivity()), (int) (com.baidu.adp.lib.util.l.aQ(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.brV);
        this.brY.e(this.brV);
        this.brY.a(new com.baidu.tbadk.e.a() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // com.baidu.tbadk.e.a
            public void dp(String str) {
                LogoActivity.this.brR = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.brV);
                LogoActivity.this.SW();
            }

            @Override // com.baidu.tbadk.e.a
            public void vs() {
                LogoActivity.this.brR = true;
                if (LogoActivity.this.brP == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.jI().removeCallbacks(LogoActivity.this.bsf);
                n.Oc().at(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.e.a
            public void vt() {
                LogoActivity.this.brS = true;
                if (LogoActivity.this.brT) {
                    LogoActivity.this.Ta();
                }
            }

            @Override // com.baidu.tbadk.e.a
            public void tZ() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.brY));
        n.Oc().as(System.currentTimeMillis() - this.brO);
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.bsf, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SW() {
        this.brO = System.currentTimeMillis();
        boolean SY = SY();
        n.Oc().as(System.currentTimeMillis() - this.brO);
        if (SY) {
            com.baidu.adp.lib.g.e.jI().post(this.bsc);
            if (this.brP == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this));
            }
        } else if (this.brP == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.jI().post(this.bse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SX() {
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

    private boolean SY() {
        if (com.baidu.adp.lib.b.d.iR().aO("ad_baichuan_open") == 0) {
            return false;
        }
        int aO = com.baidu.adp.lib.util.l.aO(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016310, View.class, new com.baidu.tbadk.coreExtra.data.h(getPageContext(), (int) (com.baidu.adp.lib.util.l.aQ(getPageContext().getPageActivity()) * 0.8125d), aO));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.brK = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SZ() {
        if (this.brP >= 0) {
            gU(this.brP);
        } else if (this.brP == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ta() {
        SZ();
        n.Oc().au(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tb() {
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

    private void gT(int i) {
        this.brP = i;
        SU();
    }

    private void gU(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private void Tc() {
        sendMessage(new CustomMessage(2002001, new SecretHintActivityConfig(getPageContext().getPageActivity())));
        finish();
    }

    private boolean Td() {
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
                        gT(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        gT(intExtra);
                        return;
                    } else {
                        gT(1);
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
            LogoActivity.this.Ta();
        }
    }
}
