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
    private View aUE;
    private long aUI;
    private boolean aUK;
    private com.baidu.tieba.view.a aUP;
    private RelativeLayout mRootView;
    private int aUD = 3100;
    private Bitmap aUF = null;
    private boolean aUG = false;
    private boolean aUH = true;
    private int aUJ = -1;
    private boolean aUL = false;
    private boolean aUM = false;
    private boolean aUN = true;
    private a aUO = new a();
    private CustomMessageListener aUQ = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.Ki()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra("jump_url", str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(LogoActivity.this.aUO);
                    LogoActivity.this.aUM = true;
                    if (LogoActivity.this.aUN) {
                        LogoActivity.this.Kq();
                    }
                }
            }
        }
    };
    private Runnable aUR = new Runnable() { // from class: com.baidu.tieba.LogoActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.aUE != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.aUE.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.aUE);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                s.Go().ad(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.fP().removeCallbacks(LogoActivity.this.aUO);
            if (LogoActivity.this.aUE != null && (LogoActivity.this.aUE.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.aUE.getTag()).booleanValue()) {
                    LogoActivity.this.aUD = 6100;
                } else {
                    LogoActivity.this.aUD = 3100;
                }
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(LogoActivity.this.aUO, LogoActivity.this.aUD);
        }
    };
    private Runnable aUS = new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.4.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.Kg();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aUT = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
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
    private Runnable aUU = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.Ko()) {
                        com.baidu.adp.lib.g.e.fP().post(LogoActivity.this.aUO);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aUV = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.aUL) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.aUP);
                com.baidu.adp.lib.g.e.fP().post(LogoActivity.this.aUU);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Kg() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.aUK = true;
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
                LogoActivity.this.Kr();
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
        if (Ki()) {
            setSwipeBackEnabled(false);
            getWindow().setFlags(1024, 1024);
            try {
                setContentView(d.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.aUQ);
                this.aUJ = -2;
                Km();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !Kh()) {
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
            this.aUG = TbadkCoreApplication.getInst().getIsFirstUse();
            s.Go().bU(this.aUG);
            registerListener(this.aUQ);
            Kj();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                Kk();
            }
            if (!k.dG()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean Kh() {
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
    public boolean Ki() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Kj() {
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

    private void Kk() {
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
        this.aUN = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aUN = true;
        if (LogoActivityConfig.isFirst) {
            s.Go().ab(System.currentTimeMillis());
        }
        if (this.aUH) {
            this.aUH = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.aUM) {
            Kq();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
        } else if (this.aUK) {
            Kg();
            this.aUK = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUO);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUR);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUS);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUT);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUU);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUV);
        if (this.aUF != null && !this.aUF.isRecycled()) {
            this.aUF.recycle();
            this.aUF = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.gP().clearCashBitmap();
    }

    private void bc(Context context) {
        Kl();
        if (LogoActivityConfig.mFromSpacial) {
            gh(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.aUG) {
                com.baidu.adp.lib.g.e.fP().post(this.aUS);
            } else {
                gh(1);
            }
        } else if (this.aUG) {
            com.baidu.adp.lib.g.e.fP().post(this.aUS);
        } else {
            Km();
        }
    }

    private void Kl() {
        if (this.aUG) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Km() {
        int af = com.baidu.adp.lib.b.d.eV().af("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH);
        if (af == 0 || findTask == null) {
            if (this.aUJ == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.fP().post(this.aUU);
                return;
            }
        }
        this.aUI = System.currentTimeMillis();
        com.baidu.tbadk.d.b bVar = new com.baidu.tbadk.d.b();
        this.aUP = new com.baidu.tieba.view.a(getPageContext().getPageActivity());
        this.aUP.setListener(new a.InterfaceC0137a() { // from class: com.baidu.tieba.LogoActivity.9
            @Override // com.baidu.tieba.view.a.InterfaceC0137a
            public void a(com.baidu.tieba.view.a aVar) {
                LogoActivity.this.Kq();
            }
        });
        this.aUP.setLayoutParams(new RelativeLayout.LayoutParams(l.ac(getPageContext().getPageActivity()), (int) (l.ae(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.aUP);
        bVar.b(this.aUP);
        bVar.a(new com.baidu.tbadk.d.a() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // com.baidu.tbadk.d.a
            public void cd(String str) {
                LogoActivity.this.aUL = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.aUP);
                LogoActivity.this.Kn();
            }

            @Override // com.baidu.tbadk.d.a
            public void nU() {
                LogoActivity.this.aUL = true;
                if (LogoActivity.this.aUJ == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.fP().removeCallbacks(LogoActivity.this.aUV);
                s.Go().ad(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.d.a
            public void nV() {
                LogoActivity.this.aUM = true;
                if (LogoActivity.this.aUN) {
                    LogoActivity.this.Kq();
                }
            }

            @Override // com.baidu.tbadk.d.a
            public void ni() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, bVar));
        s.Go().ac(System.currentTimeMillis() - this.aUI);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.aUV, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kn() {
        this.aUI = System.currentTimeMillis();
        boolean Kp = Kp();
        s.Go().ac(System.currentTimeMillis() - this.aUI);
        if (Kp) {
            com.baidu.adp.lib.g.e.fP().post(this.aUR);
            if (this.aUJ == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, this));
            }
        } else if (this.aUJ == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.fP().post(this.aUU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ko() {
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

    private boolean Kp() {
        if (com.baidu.adp.lib.b.d.eV().af("ad_baichuan_open") == 0) {
            return false;
        }
        int ac = l.ac(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, View.class, new com.baidu.tbadk.coreExtra.data.e(getPageContext(), (int) (l.ae(getPageContext().getPageActivity()) * 0.8125d), ac));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.aUE = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kq() {
        if (this.aUJ >= 0) {
            gi(this.aUJ);
        } else if (this.aUJ == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
        s.Go().ae(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kr() {
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

    private void gh(int i) {
        this.aUJ = i;
        Km();
    }

    private void gi(int i) {
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
                        gh(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        gh(intExtra);
                        return;
                    } else {
                        gh(1);
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
            LogoActivity.this.Kq();
        }
    }
}
