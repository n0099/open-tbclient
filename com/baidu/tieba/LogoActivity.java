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
    private View bOb;
    private long bOf;
    private boolean bOh;
    private com.baidu.tieba.view.b bOm;
    private com.baidu.tieba.videosplash.d bOn;
    private View bOo;
    private RelativeLayout mRootView;
    private int bOa = 3100;
    private Bitmap bOc = null;
    private boolean bOd = false;
    private boolean bOe = true;
    private int bOg = -1;
    private boolean bOi = false;
    private boolean bOj = false;
    private boolean bOk = true;
    private a bOl = new a();
    private d.a bOp = new d.a() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tieba.videosplash.d.a
        public void onError() {
            if (LogoActivity.this.bOg != -2) {
                com.baidu.adp.lib.g.e.ns().post(LogoActivity.this.bOu);
            } else {
                LogoActivity.this.finish();
            }
        }

        @Override // com.baidu.tieba.videosplash.d.a
        public void SV() {
            if (LogoActivity.this.bOg != -2) {
                LogoActivity.this.SS();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener bOq = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.SJ()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra("jump_url", str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.ns().removeCallbacks(LogoActivity.this.bOl);
                    LogoActivity.this.bOj = true;
                    if (LogoActivity.this.bOk) {
                        LogoActivity.this.ST();
                    }
                }
            }
        }
    };
    private Runnable bOr = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.bOb != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.bOb.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.bOb);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                q.OB().ao(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.ns().removeCallbacks(LogoActivity.this.bOl);
            if (LogoActivity.this.bOb != null && (LogoActivity.this.bOb.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.bOb.getTag()).booleanValue()) {
                    LogoActivity.this.bOa = 6100;
                } else {
                    LogoActivity.this.bOa = 3100;
                }
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(LogoActivity.this.bOl, LogoActivity.this.bOa);
        }
    };
    private Runnable bOs = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.SH();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bOt = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
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
    private Runnable bOu = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.8.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.SQ()) {
                        com.baidu.adp.lib.g.e.ns().post(LogoActivity.this.bOl);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bOv = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bOi) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bOm);
                com.baidu.adp.lib.g.e.ns().post(LogoActivity.this.bOu);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void SH() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bOh = true;
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
                LogoActivity.this.SU();
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
        if (SJ()) {
            setSwipeBackEnabled(false);
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(d.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bOq);
                this.bOg = -2;
                SO();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !SI()) {
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
            this.bOd = TbadkCoreApplication.getInst().getIsFirstUse();
            q.OB().cB(this.bOd);
            registerListener(this.bOq);
            SK();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                SL();
            }
            if (!k.lk()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean SI() {
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
    public boolean SJ() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void SK() {
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

    private void SL() {
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
        this.bOk = false;
        if (this.bOn != null) {
            this.bOn.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bOk = true;
        if (LogoActivityConfig.isFirst) {
            q.OB().am(System.currentTimeMillis());
        }
        if (this.bOe) {
            this.bOe = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bOj) {
            ST();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.bOh) {
            SH();
            this.bOh = false;
        }
        if (this.bOn != null) {
            this.bOn.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bOl);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bOr);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bOs);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bOt);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bOu);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bOv);
        if (this.bOn != null) {
            this.bOn.onDestroy();
        }
        if (this.bOc != null && !this.bOc.isRecycled()) {
            this.bOc.recycle();
            this.bOc = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.or().clearCashBitmap();
    }

    private void bm(Context context) {
        SM();
        if (LogoActivityConfig.mFromSpacial) {
            jf(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bOd) {
                com.baidu.adp.lib.g.e.ns().post(this.bOs);
            } else {
                jf(1);
            }
        } else if (this.bOd) {
            com.baidu.adp.lib.g.e.ns().post(this.bOs);
        } else {
            SN();
        }
    }

    private void SM() {
        if (this.bOd) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void SN() {
        if (this.bOg != -2) {
            if (this.bOn == null) {
                this.bOn = new com.baidu.tieba.videosplash.d(this);
            }
            if (this.bOn.bEB()) {
                this.bOo = this.bOn.o(0.8125d);
                this.mRootView.addView(this.bOo);
                this.bOn.a(this.bOp);
                this.bOn.start();
                return;
            }
            this.bOn.bEG();
        }
        SO();
    }

    private void SO() {
        int an = com.baidu.adp.lib.b.d.mA().an("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (an == 0 || findTask == null) {
            if (this.bOg == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.ns().post(this.bOu);
                return;
            }
        }
        this.bOf = System.currentTimeMillis();
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b();
        this.bOm = new com.baidu.tieba.view.b(getPageContext().getPageActivity());
        this.bOm.setListener(new b.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.b.a
            public void a(com.baidu.tieba.view.b bVar2) {
                LogoActivity.this.ST();
            }
        });
        this.bOm.setLayoutParams(new RelativeLayout.LayoutParams(l.ao(getPageContext().getPageActivity()), (int) (l.aq(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bOm);
        bVar.j(this.bOm);
        bVar.a(new com.baidu.tbadk.c.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.c.a
            public void cr(String str) {
                LogoActivity.this.bOi = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bOm);
                LogoActivity.this.SP();
            }

            @Override // com.baidu.tbadk.c.a
            public void wo() {
                LogoActivity.this.bOi = true;
                if (LogoActivity.this.bOg == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.ns().removeCallbacks(LogoActivity.this.bOv);
                q.OB().ao(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.c.a
            public void wp() {
                LogoActivity.this.bOj = true;
                if (LogoActivity.this.bOk) {
                    LogoActivity.this.ST();
                }
            }

            @Override // com.baidu.tbadk.c.a
            public void vA() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, bVar));
        q.OB().an(System.currentTimeMillis() - this.bOf);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.bOv, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SP() {
        this.bOf = System.currentTimeMillis();
        boolean SR = SR();
        q.OB().an(System.currentTimeMillis() - this.bOf);
        if (SR) {
            com.baidu.adp.lib.g.e.ns().post(this.bOr);
            if (this.bOg == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this));
            }
        } else if (this.bOg == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.ns().post(this.bOu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SQ() {
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

    private boolean SR() {
        if (com.baidu.adp.lib.b.d.mA().an("ad_baichuan_open") == 0) {
            return false;
        }
        int ao = l.ao(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016310, View.class, new com.baidu.tbadk.coreExtra.data.g(getPageContext(), (int) (l.aq(getPageContext().getPageActivity()) * 0.8125d), ao));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.bOb = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SS() {
        if (this.bOg >= 0) {
            jg(this.bOg);
        } else if (this.bOg == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ST() {
        SS();
        q.OB().ap(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SU() {
        File[] listFiles;
        File file = new File(k.BV());
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
        this.bOg = i;
        SN();
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
            LogoActivity.this.ST();
        }
    }
}
