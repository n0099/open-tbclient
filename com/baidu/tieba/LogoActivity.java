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
    private View bLH;
    private long bLL;
    private boolean bLN;
    private com.baidu.tieba.view.b bLS;
    private RelativeLayout mRootView;
    private int bLG = 3100;
    private Bitmap bLI = null;
    private boolean bLJ = false;
    private boolean bLK = true;
    private int bLM = -1;
    private boolean bLO = false;
    private boolean bLP = false;
    private boolean bLQ = true;
    private a bLR = new a();
    private CustomMessageListener bLT = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.Sp()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("class", 30);
                            intent.putExtra("jump_url", str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.nr().removeCallbacks(LogoActivity.this.bLR);
                    LogoActivity.this.bLP = true;
                    if (LogoActivity.this.bLQ) {
                        LogoActivity.this.Sx();
                    }
                }
            }
        }
    };
    private Runnable bLU = new Runnable() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.bLH != null && LogoActivity.this.mRootView != null) {
                if (LogoActivity.this.bLH.getParent() == null) {
                    LogoActivity.this.mRootView.addView(LogoActivity.this.bLH);
                }
                LogoActivity.this.mRootView.setFocusable(true);
                s.Og().ao(System.currentTimeMillis());
            }
            com.baidu.adp.lib.g.e.nr().removeCallbacks(LogoActivity.this.bLR);
            if (LogoActivity.this.bLH != null && (LogoActivity.this.bLH.getTag() instanceof Boolean)) {
                if (((Boolean) LogoActivity.this.bLH.getTag()).booleanValue()) {
                    LogoActivity.this.bLG = 6100;
                } else {
                    LogoActivity.this.bLG = 3100;
                }
            }
            com.baidu.adp.lib.g.e.nr().postDelayed(LogoActivity.this.bLR, LogoActivity.this.bLG);
        }
    };
    private Runnable bLV = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.6.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    LogoActivity.this.Sn();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bLW = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
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
    private Runnable bLX = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            c.a(LogoActivity.this.getPageContext(), new c.a() { // from class: com.baidu.tieba.LogoActivity.8.1
                @Override // com.baidu.tieba.c.a
                public void onCompleted() {
                    if (!LogoActivity.this.Sv()) {
                        com.baidu.adp.lib.g.e.nr().post(LogoActivity.this.bLR);
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, LogoActivity.this.getPageContext()));
                    LogoActivity.this.finish();
                }
            }, LogoActivity.this.mRootView);
        }
    };
    private Runnable bLY = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.bLO) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bLS);
                com.baidu.adp.lib.g.e.nr().post(LogoActivity.this.bLX);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Sn() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.bLN = true;
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
                LogoActivity.this.Sy();
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
        if (Sp()) {
            setSwipeBackEnabled(false);
            getWindow().setFlags(1024, 1024);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
            try {
                setContentView(d.h.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(d.g.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.bLT);
                this.bLM = -2;
                St();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !So()) {
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
            this.bLJ = TbadkCoreApplication.getInst().getIsFirstUse();
            s.Og().cy(this.bLJ);
            registerListener(this.bLT);
            Sq();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                Sr();
            }
            if (!k.lk()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean So() {
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
    public boolean Sp() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Sq() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.wM(), getPageContext().getPageActivity());
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

    private void Sr() {
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
        this.bLQ = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bLQ = true;
        if (LogoActivityConfig.isFirst) {
            s.Og().am(System.currentTimeMillis());
        }
        if (this.bLK) {
            this.bLK = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.bLP) {
            Sx();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
        } else if (this.bLN) {
            Sn();
            this.bLN = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bLR);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bLU);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bLV);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bLW);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bLX);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bLY);
        if (this.bLI != null && !this.bLI.isRecycled()) {
            this.bLI.recycle();
            this.bLI = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.oq().clearCashBitmap();
    }

    private void bq(Context context) {
        Ss();
        if (LogoActivityConfig.mFromSpacial) {
            jn(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.bLJ) {
                com.baidu.adp.lib.g.e.nr().post(this.bLV);
            } else {
                jn(1);
            }
        } else if (this.bLJ) {
            com.baidu.adp.lib.g.e.nr().post(this.bLV);
        } else {
            St();
        }
    }

    private void Ss() {
        if (this.bLJ) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void St() {
        int an = com.baidu.adp.lib.b.d.mz().an("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH);
        if (an == 0 || findTask == null) {
            if (this.bLM == -2) {
                finish();
                return;
            } else {
                com.baidu.adp.lib.g.e.nr().post(this.bLX);
                return;
            }
        }
        this.bLL = System.currentTimeMillis();
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b();
        this.bLS = new com.baidu.tieba.view.b(getPageContext().getPageActivity());
        this.bLS.setListener(new b.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.b.a
            public void a(com.baidu.tieba.view.b bVar2) {
                LogoActivity.this.Sx();
            }
        });
        this.bLS.setLayoutParams(new RelativeLayout.LayoutParams(l.ao(getPageContext().getPageActivity()), (int) (l.aq(getPageContext().getPageActivity()) * 0.8125d)));
        this.mRootView.addView(this.bLS);
        bVar.j(this.bLS);
        bVar.a(new com.baidu.tbadk.c.a() { // from class: com.baidu.tieba.LogoActivity.12
            @Override // com.baidu.tbadk.c.a
            public void ck(String str) {
                LogoActivity.this.bLO = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.bLS);
                LogoActivity.this.Su();
            }

            @Override // com.baidu.tbadk.c.a
            public void vC() {
                LogoActivity.this.bLO = true;
                if (LogoActivity.this.bLM == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.nr().removeCallbacks(LogoActivity.this.bLY);
                s.Og().ao(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.c.a
            public void vD() {
                LogoActivity.this.bLP = true;
                if (LogoActivity.this.bLQ) {
                    LogoActivity.this.Sx();
                }
            }

            @Override // com.baidu.tbadk.c.a
            public void uN() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, bVar));
        s.Og().an(System.currentTimeMillis() - this.bLL);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.bLY, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Su() {
        this.bLL = System.currentTimeMillis();
        boolean Sw = Sw();
        s.Og().an(System.currentTimeMillis() - this.bLL);
        if (Sw) {
            com.baidu.adp.lib.g.e.nr().post(this.bLU);
            if (this.bLM == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, this));
            }
        } else if (this.bLM == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.nr().post(this.bLX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sv() {
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

    private boolean Sw() {
        if (com.baidu.adp.lib.b.d.mz().an("ad_baichuan_open") == 0) {
            return false;
        }
        int ao = l.ao(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, View.class, new com.baidu.tbadk.coreExtra.data.g(getPageContext(), (int) (l.aq(getPageContext().getPageActivity()) * 0.8125d), ao));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.bLH = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sx() {
        if (this.bLM >= 0) {
            jo(this.bLM);
        } else if (this.bLM == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
        s.Og().ap(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sy() {
        File[] listFiles;
        File file = new File(k.BJ());
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

    private void jn(int i) {
        this.bLM = i;
        St();
    }

    private void jo(int i) {
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
                        jn(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        jn(intExtra);
                        return;
                    } else {
                        jn(1);
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
                aVar.fc(d.j.request_permission_default_title);
                aVar.fd(d.j.request_permission_default_text);
                aVar.a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.LogoActivity.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent = new Intent();
                        intent.addFlags(268435456);
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", LogoActivity.this.getPackageName(), null));
                        LogoActivity.this.startActivity(intent);
                        LogoActivity.this.finish();
                    }
                }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.LogoActivity.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        LogoActivity.this.finish();
                    }
                }).b(getPageContext());
                aVar.AI();
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
            LogoActivity.this.Sx();
        }
    }
}
