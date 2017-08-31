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
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private View aTQ;
    private boolean aTV;
    private RelativeLayout mRootView;
    private int aTP = 3100;
    private Bitmap aTR = null;
    private boolean aTS = false;
    private boolean aTT = true;
    private int aTU = -1;
    private CustomMessageListener aTW = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.JW()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra("jump_url", str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.fQ().removeCallbacks(LogoActivity.this.aTX);
                    LogoActivity.this.Kd();
                }
            }
        }
    };
    private a aTX = new a();
    private Runnable aTY = new Runnable() { // from class: com.baidu.tieba.LogoActivity.2
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.aTQ != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.aTQ.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.aTQ);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                s.GD().ac(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(LogoActivity.this.aTX);
            if (LogoActivity.this.aTQ != null && (LogoActivity.this.aTQ.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.aTQ.getTag()).booleanValue()) {
                    LogoActivity.this.aTP = 6100;
                } else {
                    LogoActivity.this.aTP = 3100;
                }
            }
            com.baidu.adp.lib.g.e.fQ().postDelayed(LogoActivity.this.aTX, LogoActivity.this.aTP);
        }
    };
    private Runnable aTZ = new Runnable() { // from class: com.baidu.tieba.LogoActivity.3
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.3.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.JU();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aUa = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
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
    private Runnable aUb = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.Kb()) {
                        com.baidu.adp.lib.g.e.fQ().post(LogoActivity.this.aTX);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable aUc = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.Ke();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.Kd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JU() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.aTV = true;
            return;
        }
        if (!this.aTS) {
            TbadkCoreApplication.getInst().setUsed();
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        h.fR().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.Kf();
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

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        E(intent);
        bc(getPageContext().getPageActivity());
        LogoActivityConfig.isFirst = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (JW()) {
            setSwipeBackEnabled(false);
            getWindow().setFlags(1024, 1024);
            try {
                setContentView(d.j.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.h.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.aTW);
                this.aTU = -2;
                Ka();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !JV()) {
            finish();
        } else {
            TiebaStatic.log(new ak("c11894").r("obj_param1", 2));
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
            }
            E(getIntent());
            getWindow().setFlags(1024, 1024);
            setContentView(d.j.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(d.h.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.aTS = TbadkCoreApplication.getInst().getIsFirstUse();
            s.GD().cb(this.aTS);
            registerListener(this.aTW);
            JX();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                JY();
            }
            if (!k.dH()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean JV() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new ak("c11897").ad(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JW() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void JX() {
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

    private void JY() {
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
            s.GD().aa(System.currentTimeMillis());
        }
        if (this.aTT) {
            this.aTT = false;
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
        } else if (this.aTV) {
            JU();
            this.aTV = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.aTX);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.aTY);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.aTZ);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.aUa);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.aUb);
        if (this.aTR != null && !this.aTR.isRecycled()) {
            this.aTR.recycle();
            this.aTR = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.gQ().clearCashBitmap();
    }

    private void bc(Context context) {
        JZ();
        if (LogoActivityConfig.mFromSpacial) {
            fL(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.aTS) {
                com.baidu.adp.lib.g.e.fQ().post(this.aTZ);
            } else {
                fL(1);
            }
        } else if (this.aTS) {
            com.baidu.adp.lib.g.e.fQ().post(this.aTZ);
        } else {
            Ka();
        }
    }

    private void JZ() {
        if (this.aTS) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Ka() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH) == null) {
            Log.e("LogoActivity", "Advert sdk is not available now");
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean Kc = Kc();
        s.GD().ab(System.currentTimeMillis() - currentTimeMillis);
        if (Kc) {
            com.baidu.adp.lib.g.e.fQ().post(this.aTY);
            if (this.aTU == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, this));
            }
        } else if (this.aTU == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.fQ().post(this.aUb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Kb() {
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

    private boolean Kc() {
        if (com.baidu.adp.lib.b.d.eW().af("ad_baichuan_open") == 0) {
            return false;
        }
        int ad = com.baidu.adp.lib.util.k.ad(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, View.class, new com.baidu.tbadk.coreExtra.data.e(getPageContext(), (int) (com.baidu.adp.lib.util.k.ae(getPageContext().getPageActivity()) * 0.8125d), ad));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.aTQ = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd() {
        if (this.aTU >= 0) {
            fM(this.aTU);
        } else if (this.aTU == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
        s.GD().ad(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ke() {
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
                if (LogoActivity.this.aTU >= 0) {
                    LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(LogoActivity.this.aTU)));
                } else {
                    LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(2)));
                }
                LogoActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kf() {
        File[] listFiles;
        File file = new File(k.uG());
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

    private void fL(int i) {
        this.aTU = i;
        Ka();
    }

    private void fM(int i) {
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
                        fL(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        fL(intExtra);
                        return;
                    } else {
                        fL(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
