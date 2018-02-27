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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.k.q;
import com.baidu.tieba.c;
import com.baidu.tieba.d;
import com.baidu.tieba.videosplash.d;
import com.baidu.tieba.view.b;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private View bNO;
    private long bNS;
    private boolean bNU;
    private com.baidu.tieba.view.b bNZ;
    private com.baidu.tieba.videosplash.d bOa;
    private View bOb;
    private RelativeLayout mRootView;
    private int bNN = 3100;
    private Bitmap bNP = null;
    private boolean bNQ = false;
    private boolean bNR = true;
    private int bNT = -1;
    private boolean bNV = false;
    private boolean bNW = false;
    private boolean bNX = true;
    private a bNY = new a();
    private d.a bOc = new d.a() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tieba.videosplash.d.a
        public void onError() {
            if (LogoActivity.this.bNT != -2) {
                com.baidu.adp.lib.g.e.ns().post(LogoActivity.this.bOh);
            } else {
                LogoActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.videosplash.d.a
        public void SU() {
            if (LogoActivity.this.bNT != -2) {
                LogoActivity.this.SR();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener bOd = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.SI()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra("jump_url", str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.ns().removeCallbacks(LogoActivity.this.bNY);
                    LogoActivity.this.bNW = true;
                    if (LogoActivity.this.bNX) {
                        LogoActivity.this.SS();
                    }
                }
            }
        }
    };
    private Runnable bOe = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.bNO != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.bNO.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.bNO);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                q.OA().ao(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.ns().removeCallbacks(LogoActivity.this.bNY);
            if (LogoActivity.this.bNO != null && (LogoActivity.this.bNO.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.bNO.getTag()).booleanValue()) {
                    LogoActivity.this.bNN = 6100;
                } else {
                    LogoActivity.this.bNN = 3100;
                }
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(LogoActivity.this.bNY, LogoActivity.this.bNN);
        }
    };
    private Runnable bOf = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.SG();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bOg = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.7.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (MessageManager.getInstance().findTask(2015001) != null) {
                        LogoActivity.this.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 2)));
                    } else {
                        LogoActivity.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(1)));
                    }
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bOh = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.8.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.SP()) {
                        com.baidu.adp.lib.g.e.ns().post(LogoActivity.this.bNY);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bOi = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bNV) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bNZ);
                com.baidu.adp.lib.g.e.ns().post(LogoActivity.this.bOh);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void SG() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bNU = true;
            return;
        }
        if (MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.nt().e(new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.ST();
            }
        });
        finish();
    }

    private void E(Intent intent) {
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
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (SI()) {
            setSwipeBackEnabled(false);
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(d.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bOd);
                this.bNT = -2;
                SN();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !SH()) {
            finish();
        } else {
            TiebaStatic.log(new ak("c11894").s("obj_param1", 2));
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
            }
            E(getIntent());
            getWindow().setFlags(1024, 1024);
            setContentView(d.h.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.bNQ = TbadkCoreApplication.getInst().getIsFirstUse();
            q.OA().cB(this.bNQ);
            registerListener(this.bOd);
            SJ();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                SK();
            }
            if (!k.lk()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean SH() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new ak("c11897").ab(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SI() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void SJ() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.xz(), getPageContext().getPageActivity());
        }
        bm(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void SK() {
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
        this.bNX = false;
        if (this.bOa != null) {
            this.bOa.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bNX = true;
        if (LogoActivityConfig.isFirst) {
            q.OA().am(System.currentTimeMillis());
        }
        if (this.bNR) {
            this.bNR = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bNW) {
            SS();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.bNU) {
            SG();
            this.bNU = false;
        }
        if (this.bOa != null) {
            this.bOa.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bNY);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bOe);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bOf);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bOg);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bOh);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bOi);
        if (this.bOa != null) {
            this.bOa.onDestroy();
        }
        if (this.bNP != null && !this.bNP.isRecycled()) {
            this.bNP.recycle();
            this.bNP = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.or().clearCashBitmap();
    }

    private void bm(Context context) {
        SL();
        if (LogoActivityConfig.mFromSpacial) {
            jf(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bNQ) {
                com.baidu.adp.lib.g.e.ns().post(this.bOf);
            } else {
                jf(1);
            }
        } else if (this.bNQ) {
            com.baidu.adp.lib.g.e.ns().post(this.bOf);
        } else {
            SM();
        }
    }

    private void SL() {
        if (this.bNQ) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void SM() {
        if (this.bNT != -2) {
            if (this.bOa == null) {
                this.bOa = new com.baidu.tieba.videosplash.d(this);
            }
            if (this.bOa.bEA()) {
                this.bOb = this.bOa.o(0.8125d);
                this.mRootView.addView(this.bOb);
                this.bOa.a(this.bOc);
                this.bOa.start();
                return;
            }
            this.bOa.bEF();
        }
        SN();
    }

    private void SN() {
        int an = com.baidu.adp.lib.b.d.mA().an("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (an == 0 || findTask == null) {
            if (this.bNT == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.ns().post(this.bOh);
                return;
            }
        }
        this.bNS = System.currentTimeMillis();
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b();
        this.bNZ = new com.baidu.tieba.view.b(getPageContext().getPageActivity());
        this.bNZ.setListener(new b.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.b.a
            public void a(com.baidu.tieba.view.b bVar2) {
                LogoActivity.this.SS();
            }
        });
        this.bNZ.setLayoutParams(new RelativeLayout.LayoutParams(l.ao(getPageContext().getPageActivity()), (int) (l.aq(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bNZ);
        bVar.j(this.bNZ);
        bVar.a(new com.baidu.tbadk.c.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.c.a
            public void cr(String str) {
                LogoActivity.this.bNV = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bNZ);
                LogoActivity.this.SO();
            }

            @Override // com.baidu.tbadk.c.a
            public void wo() {
                LogoActivity.this.bNV = true;
                if (LogoActivity.this.bNT == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.ns().removeCallbacks(LogoActivity.this.bOi);
                q.OA().ao(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.c.a
            public void wp() {
                LogoActivity.this.bNW = true;
                if (LogoActivity.this.bNX) {
                    LogoActivity.this.SS();
                }
            }

            @Override // com.baidu.tbadk.c.a
            public void vA() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, bVar));
        q.OA().an(System.currentTimeMillis() - this.bNS);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.bOi, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SO() {
        this.bNS = System.currentTimeMillis();
        boolean SQ = SQ();
        q.OA().an(System.currentTimeMillis() - this.bNS);
        if (SQ) {
            com.baidu.adp.lib.g.e.ns().post(this.bOe);
            if (this.bNT == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this));
            }
        } else if (this.bNT == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.ns().post(this.bOh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SP() {
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

    private boolean SQ() {
        if (com.baidu.adp.lib.b.d.mA().an("ad_baichuan_open") == 0) {
            return false;
        }
        int ao = l.ao(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016310, View.class, new com.baidu.tbadk.coreExtra.data.g(getPageContext(), (int) (l.aq(getPageContext().getPageActivity()) * 0.8125d), ao));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.bNO = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SR() {
        if (this.bNT >= 0) {
            jg(this.bNT);
        } else if (this.bNT == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SS() {
        SR();
        q.OA().ap(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ST() {
        File[] listFiles;
        File file = new File(k.BU());
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

    private void jf(int i) {
        this.bNT = i;
        SM();
    }

    private void jg(int i) {
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
                        jf(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        jf(intExtra);
                        return;
                    } else {
                        jf(1);
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
            LogoActivity.this.SS();
        }
    }
}
