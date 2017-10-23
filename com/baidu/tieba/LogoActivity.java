package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.k.s;
import com.baidu.tieba.c;
import com.baidu.tieba.d;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private boolean aUE;
    private View aUz;
    private RelativeLayout mRootView;
    private int aUy = 3100;
    private Bitmap aUA = null;
    private boolean aUB = false;
    private boolean aUC = true;
    private int aUD = -1;
    private CustomMessageListener aUF = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.JZ()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra("jump_url", str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.fP().removeCallbacks(LogoActivity.this.aUG);
                    LogoActivity.this.Kg();
                }
            }
        }
    };
    private a aUG = new a();
    private Runnable aUH = new Runnable() { // from class: com.baidu.tieba.LogoActivity.2
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.aUz != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.aUz.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.aUz);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                s.Gc().ad(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.fP().removeCallbacks(LogoActivity.this.aUG);
            if (LogoActivity.this.aUz != null && (LogoActivity.this.aUz.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.aUz.getTag()).booleanValue()) {
                    LogoActivity.this.aUy = 6100;
                } else {
                    LogoActivity.this.aUy = 3100;
                }
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(LogoActivity.this.aUG, LogoActivity.this.aUy);
        }
    };
    private Runnable aUI = new Runnable() { // from class: com.baidu.tieba.LogoActivity.3
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.3.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.JX();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aUJ = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
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
    private Runnable aUK = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.Ke()) {
                        com.baidu.adp.lib.g.e.fP().post(LogoActivity.this.aUG);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aUL = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.Kh();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.Kg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JX() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.aUE = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.fQ().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.Ki();
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

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        D(intent);
        bc(getPageContext().getPageActivity());
        LogoActivityConfig.isFirst = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (JZ()) {
            setSwipeBackEnabled(false);
            getWindow().setFlags(1024, 1024);
            try {
                setContentView(d.j.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.h.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.aUF);
                this.aUD = -2;
                Kd();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !JY()) {
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
            setContentView(d.j.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(d.h.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.aUB = TbadkCoreApplication.getInst().getIsFirstUse();
            s.Gc().bZ(this.aUB);
            registerListener(this.aUF);
            Ka();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                Kb();
            }
            if (!k.dG()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean JY() {
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
    public boolean JZ() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Ka() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.oY(), getPageContext().getPageActivity());
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

    private void Kb() {
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
    public void onResume() {
        super.onResume();
        if (LogoActivityConfig.isFirst) {
            s.Gc().ab(System.currentTimeMillis());
        }
        if (this.aUC) {
            this.aUC = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
        } else if (this.aUE) {
            JX();
            this.aUE = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUG);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUH);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUI);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUJ);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aUK);
        if (this.aUA != null && !this.aUA.isRecycled()) {
            this.aUA.recycle();
            this.aUA = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.gP().clearCashBitmap();
    }

    private void bc(Context context) {
        Kc();
        if (LogoActivityConfig.mFromSpacial) {
            fY(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.aUB) {
                com.baidu.adp.lib.g.e.fP().post(this.aUI);
            } else {
                fY(1);
            }
        } else if (this.aUB) {
            com.baidu.adp.lib.g.e.fP().post(this.aUI);
        } else {
            Kd();
        }
    }

    private void Kc() {
        if (this.aUB) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Kd() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH) == null) {
            Log.e("LogoActivity", "Advert sdk is not available now");
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean Kf = Kf();
        s.Gc().ac(System.currentTimeMillis() - currentTimeMillis);
        if (Kf) {
            com.baidu.adp.lib.g.e.fP().post(this.aUH);
            if (this.aUD == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, this));
            }
        } else if (this.aUD == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.fP().post(this.aUK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ke() {
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

    private boolean Kf() {
        if (com.baidu.adp.lib.b.d.eV().af("ad_baichuan_open") == 0) {
            return false;
        }
        int ad = l.ad(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, View.class, new com.baidu.tbadk.coreExtra.data.e(getPageContext(), (int) (l.af(getPageContext().getPageActivity()) * 0.8125d), ad));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.aUz = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kg() {
        if (this.aUD >= 0) {
            fZ(this.aUD);
        } else if (this.aUD == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
        s.Gc().ae(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh() {
        com.baidu.tieba.tbadkCore.a.a(this, this.mRootView, d.a.anim_alpha_1_to_0_duration_1500_accelerate, new Animation.AnimationListener() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (LogoActivity.this.mRootView != null) {
                    LogoActivity.this.mRootView.setVisibility(8);
                }
                if (LogoActivity.this.aUD >= 0) {
                    LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(LogoActivity.this.aUD)));
                } else {
                    LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(2)));
                }
                LogoActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ki() {
        File[] listFiles;
        File file = new File(k.uc());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.9
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                return !TextUtils.isEmpty(name) && name.contains(LogoActivity.this.getPageContext().getString(d.l.app_name)) && name.endsWith(".apk");
            }
        })) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void fY(int i) {
        this.aUD = i;
        Kd();
    }

    private void fZ(int i) {
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
                        fY(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        fY(intExtra);
                        return;
                    } else {
                        fY(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
