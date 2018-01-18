package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
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
import com.baidu.b.a.a;
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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.k.s;
import com.baidu.tieba.c;
import com.baidu.tieba.d;
import com.baidu.tieba.view.b;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> implements a.InterfaceC0036a {
    private View bLP;
    private long bLT;
    private boolean bLV;
    private com.baidu.tieba.view.b bMa;
    private RelativeLayout mRootView;
    private int bLO = 3100;
    private Bitmap bLQ = null;
    private boolean bLR = false;
    private boolean bLS = true;
    private int bLU = -1;
    private boolean bLW = false;
    private boolean bLX = false;
    private boolean bLY = true;
    private a bLZ = new a();
    private CustomMessageListener bMb = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.Sd()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra("jump_url", str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.nr().removeCallbacks(LogoActivity.this.bLZ);
                    LogoActivity.this.bLX = true;
                    if (LogoActivity.this.bLY) {
                        LogoActivity.this.Sl();
                    }
                }
            }
        }
    };
    private Runnable bMc = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.bLP != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.bLP.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.bLP);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                s.NU().ao(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.nr().removeCallbacks(LogoActivity.this.bLZ);
            if (LogoActivity.this.bLP != null && (LogoActivity.this.bLP.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.bLP.getTag()).booleanValue()) {
                    LogoActivity.this.bLO = 6100;
                } else {
                    LogoActivity.this.bLO = 3100;
                }
            }
            com.baidu.adp.lib.g.e.nr().postDelayed(LogoActivity.this.bLZ, LogoActivity.this.bLO);
        }
    };
    private Runnable bMd = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.Sb();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bMe = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.7.1
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
    private Runnable bMf = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.8.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.Sj()) {
                        com.baidu.adp.lib.g.e.nr().post(LogoActivity.this.bLZ);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bMg = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bLW) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bMa);
                com.baidu.adp.lib.g.e.nr().post(LogoActivity.this.bMf);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Sb() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bLV = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.ns().e(new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.Sm();
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
        if (ab.aY(this)) {
            init(bundle);
        } else {
            ab.e(this, 1);
        }
    }

    private void init(Bundle bundle) {
        if (Sd()) {
            setSwipeBackEnabled(false);
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
            try {
                setContentView(d.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bMb);
                this.bLU = -2;
                Sh();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !Sc()) {
            finish();
        } else {
            TiebaStatic.log(new ak("c11894").s("obj_param1", 2));
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
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
            this.bLR = TbadkCoreApplication.getInst().getIsFirstUse();
            s.NU().cw(this.bLR);
            registerListener(this.bMb);
            Se();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                Sf();
            }
            if (!k.lk()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean Sc() {
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
    public boolean Sd() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Se() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.wL(), getPageContext().getPageActivity());
        }
        bq(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void Sf() {
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
        this.bLY = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bLY = true;
        if (LogoActivityConfig.isFirst) {
            s.NU().am(System.currentTimeMillis());
        }
        if (this.bLS) {
            this.bLS = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bLX) {
            Sl();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
        } else if (this.bLV) {
            Sb();
            this.bLV = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bLZ);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bMc);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bMd);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bMe);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bMf);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bMg);
        if (this.bLQ != null && !this.bLQ.isRecycled()) {
            this.bLQ.recycle();
            this.bLQ = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.oq().clearCashBitmap();
    }

    private void bq(Context context) {
        Sg();
        if (LogoActivityConfig.mFromSpacial) {
            jj(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bLR) {
                com.baidu.adp.lib.g.e.nr().post(this.bMd);
            } else {
                jj(1);
            }
        } else if (this.bLR) {
            com.baidu.adp.lib.g.e.nr().post(this.bMd);
        } else {
            Sh();
        }
    }

    private void Sg() {
        if (this.bLR) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Sh() {
        int an = com.baidu.adp.lib.b.d.mz().an("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH);
        if (an == 0 || findTask == null) {
            if (this.bLU == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.nr().post(this.bMf);
                return;
            }
        }
        this.bLT = System.currentTimeMillis();
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b();
        this.bMa = new com.baidu.tieba.view.b(getPageContext().getPageActivity());
        this.bMa.setListener(new b.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.b.a
            public void a(com.baidu.tieba.view.b bVar2) {
                LogoActivity.this.Sl();
            }
        });
        this.bMa.setLayoutParams(new RelativeLayout.LayoutParams(l.ao(getPageContext().getPageActivity()), (int) (l.aq(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bMa);
        bVar.j(this.bMa);
        bVar.a(new com.baidu.tbadk.c.a() { // from class: com.baidu.tieba.LogoActivity.12
            @Override // com.baidu.tbadk.c.a
            public void ck(String str) {
                LogoActivity.this.bLW = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bMa);
                LogoActivity.this.Si();
            }

            @Override // com.baidu.tbadk.c.a
            public void vB() {
                LogoActivity.this.bLW = true;
                if (LogoActivity.this.bLU == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.nr().removeCallbacks(LogoActivity.this.bMg);
                s.NU().ao(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.c.a
            public void vC() {
                LogoActivity.this.bLX = true;
                if (LogoActivity.this.bLY) {
                    LogoActivity.this.Sl();
                }
            }

            @Override // com.baidu.tbadk.c.a
            public void uN() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, bVar));
        s.NU().an(System.currentTimeMillis() - this.bLT);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.bMg, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Si() {
        this.bLT = System.currentTimeMillis();
        boolean Sk = Sk();
        s.NU().an(System.currentTimeMillis() - this.bLT);
        if (Sk) {
            com.baidu.adp.lib.g.e.nr().post(this.bMc);
            if (this.bLU == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, this));
            }
        } else if (this.bLU == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.nr().post(this.bMf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sj() {
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

    private boolean Sk() {
        if (com.baidu.adp.lib.b.d.mz().an("ad_baichuan_open") == 0) {
            return false;
        }
        int ao = l.ao(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, View.class, new com.baidu.tbadk.coreExtra.data.g(getPageContext(), (int) (l.aq(getPageContext().getPageActivity()) * 0.8125d), ao));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.bLP = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sl() {
        if (this.bLU >= 0) {
            jk(this.bLU);
        } else if (this.bLU == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
        s.NU().ap(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sm() {
        File[] listFiles;
        File file = new File(k.BB());
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

    private void jj(int i) {
        this.bLU = i;
        Sh();
    }

    private void jk(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
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
                        jj(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        jj(intExtra);
                        return;
                    } else {
                        jj(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0036a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
                aVar.aW(false);
                aVar.fa(d.j.request_permission_default_title);
                aVar.fb(d.j.request_permission_default_text);
                aVar.a(d.j.request_permission_request_text, new a.b() { // from class: com.baidu.tieba.LogoActivity.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        ab.e(LogoActivity.this, 1);
                    }
                }).b(d.j.request_permission_cancel_text, new a.b() { // from class: com.baidu.tieba.LogoActivity.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        LogoActivity.this.finish();
                    }
                }).b(getPageContext());
                aVar.AA();
                return;
            }
            init(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.Sl();
        }
    }
}
