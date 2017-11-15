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
import com.baidu.sapi2.SapiAccountManager;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.l.s;
import com.baidu.tieba.c;
import com.baidu.tieba.d;
import com.baidu.tieba.view.a;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private View aUM;
    private long aUQ;
    private boolean aUS;
    private com.baidu.tieba.view.a aUX;
    private RelativeLayout mRootView;
    private int aUL = 3100;
    private Bitmap aUN = null;
    private boolean aUO = false;
    private boolean aUP = true;
    private int aUR = -1;
    private boolean aUT = false;
    private boolean aUU = false;
    private boolean aUV = true;
    private a aUW = new a();
    private CustomMessageListener aUY = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.Kt()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra("jump_url", str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(LogoActivity.this.aUW);
                    LogoActivity.this.aUU = true;
                    if (LogoActivity.this.aUV) {
                        LogoActivity.this.KB();
                    }
                }
            }
        }
    };
    private Runnable aUZ = new Runnable() { // from class: com.baidu.tieba.LogoActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.aUM != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.aUM.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.aUM);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                s.Gz().ad(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.fP().removeCallbacks(LogoActivity.this.aUW);
            if (LogoActivity.this.aUM != null && (LogoActivity.this.aUM.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.aUM.getTag()).booleanValue()) {
                    LogoActivity.this.aUL = 6100;
                } else {
                    LogoActivity.this.aUL = 3100;
                }
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(LogoActivity.this.aUW, LogoActivity.this.aUL);
        }
    };
    private Runnable aVa = new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.4.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.Kr();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aVb = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.5.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                        LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 2)));
                    } else {
                        LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(1)));
                    }
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aVc = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.Kz()) {
                        com.baidu.adp.lib.g.e.fP().post(LogoActivity.this.aUW);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aVd = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.aUT) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.aUX);
                com.baidu.adp.lib.g.e.fP().post(LogoActivity.this.aVc);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Kr() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.aUS = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.fQ().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.KC();
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
        super.onCreate(bundle);
        if (Kt()) {
            setSwipeBackEnabled(false);
            getWindow().setFlags(1024, 1024);
            try {
                setContentView(d.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.aUY);
                this.aUR = -2;
                Kx();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !Ks()) {
            finish();
        } else {
            TiebaStatic.log(new ak("c11894").r("obj_param1", 2));
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
            }
            D(getIntent());
            getWindow().setFlags(1024, 1024);
            setContentView(d.h.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.aUO = TbadkCoreApplication.getInst().getIsFirstUse();
            s.Gz().bV(this.aUO);
            registerListener(this.aUY);
            Ku();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                Kv();
            }
            if (!k.dG()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean Ks() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new ak("c11897").ac(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Kt() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Ku() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.pe(), getPageContext().getPageActivity());
        }
        bc(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void Kv() {
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
        this.aUV = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aUV = true;
        if (LogoActivityConfig.isFirst) {
            s.Gz().ab(System.currentTimeMillis());
        }
        if (this.aUP) {
            this.aUP = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.aUU) {
            KB();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
        } else if (this.aUS) {
            Kr();
            this.aUS = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUW);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUZ);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aVa);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aVb);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aVc);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aVd);
        if (this.aUN != null && !this.aUN.isRecycled()) {
            this.aUN.recycle();
            this.aUN = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.gP().clearCashBitmap();
    }

    private void bc(Context context) {
        Kw();
        if (LogoActivityConfig.mFromSpacial) {
            gg(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.aUO) {
                com.baidu.adp.lib.g.e.fP().post(this.aVa);
            } else {
                gg(1);
            }
        } else if (this.aUO) {
            com.baidu.adp.lib.g.e.fP().post(this.aVa);
        } else {
            Kx();
        }
    }

    private void Kw() {
        if (this.aUO) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Kx() {
        int af = com.baidu.adp.lib.b.d.eV().af("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH);
        if (af == 0 || findTask == null) {
            if (this.aUR == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.fP().post(this.aVc);
                return;
            }
        }
        this.aUQ = System.currentTimeMillis();
        com.baidu.tbadk.d.b bVar = new com.baidu.tbadk.d.b();
        this.aUX = new com.baidu.tieba.view.a(getPageContext().getPageActivity());
        this.aUX.setListener(new a.InterfaceC0140a() { // from class: com.baidu.tieba.LogoActivity.9
            @Override // com.baidu.tieba.view.a.InterfaceC0140a
            public void a(com.baidu.tieba.view.a aVar) {
                LogoActivity.this.KB();
            }
        });
        this.aUX.setLayoutParams(new RelativeLayout.LayoutParams(l.ac(getPageContext().getPageActivity()), (int) (l.ae(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.aUX);
        bVar.b(this.aUX);
        bVar.a(new com.baidu.tbadk.d.a() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // com.baidu.tbadk.d.a
            public void cd(String str) {
                LogoActivity.this.aUT = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.aUX);
                LogoActivity.this.Ky();
            }

            @Override // com.baidu.tbadk.d.a
            public void nU() {
                LogoActivity.this.aUT = true;
                if (LogoActivity.this.aUR == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.fP().removeCallbacks(LogoActivity.this.aVd);
                s.Gz().ad(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.d.a
            public void nV() {
                LogoActivity.this.aUU = true;
                if (LogoActivity.this.aUV) {
                    LogoActivity.this.KB();
                }
            }

            @Override // com.baidu.tbadk.d.a
            public void ni() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, bVar));
        s.Gz().ac(System.currentTimeMillis() - this.aUQ);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.aVd, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ky() {
        this.aUQ = System.currentTimeMillis();
        boolean KA = KA();
        s.Gz().ac(System.currentTimeMillis() - this.aUQ);
        if (KA) {
            com.baidu.adp.lib.g.e.fP().post(this.aUZ);
            if (this.aUR == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, this));
            }
        } else if (this.aUR == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.fP().post(this.aVc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Kz() {
        try {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN, Boolean.class, 0);
            if (runTask == null || runTask.getData() == null) {
                return false;
            }
            return ((Boolean) runTask.getData()).booleanValue();
        } catch (Exception e) {
            BdLog.e(e);
            return false;
        }
    }

    private boolean KA() {
        if (com.baidu.adp.lib.b.d.eV().af("ad_baichuan_open") == 0) {
            return false;
        }
        int ac = l.ac(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, View.class, new com.baidu.tbadk.coreExtra.data.f(getPageContext(), (int) (l.ae(getPageContext().getPageActivity()) * 0.8125d), ac));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.aUM = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KB() {
        if (this.aUR >= 0) {
            gh(this.aUR);
        } else if (this.aUR == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
        s.Gz().ae(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KC() {
        File[] listFiles;
        File file = new File(k.uj());
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

    private void gg(int i) {
        this.aUR = i;
        Kx();
    }

    private void gh(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
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
            LogoActivity.this.KB();
        }
    }
}
