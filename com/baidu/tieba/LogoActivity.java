package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.performanceLog.z;
import com.baidu.tieba.i;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private com.baidu.tbadk.core.dialog.a Lv;
    private View mRootView;
    private ImageView aCk = null;
    private Bitmap mBitmap = null;
    private Bitmap aCl = null;
    private boolean aCm = false;
    private int aCn = -1;
    private a aCo = new a(this, null);
    private Runnable aCp = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(LogoActivity logoActivity, a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.FA();
        }
    }

    private void L(Intent intent) {
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
        L(intent);
        ap(getPageContext().getPageActivity());
        LogoActivityConfig.isFirst = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isTaskRoot() && !Fv()) {
            finish();
            return;
        }
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().onLowMemory();
        System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        }
        L(getIntent());
        getWindow().setFlags(1024, 1024);
        setContentView(i.g.logo_activity);
        this.mRootView = findViewById(i.f.layout_root);
        this.aCk = (ImageView) findViewById(i.f.logo);
        this.aCl = com.baidu.tbadk.core.util.c.f(getPageContext().getPageActivity(), i.e.logo_ad_bg);
        if (this.aCl == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            options.inSampleSize = 2;
            this.aCl = com.baidu.tbadk.core.util.c.a(getPageContext().getPageActivity(), i.e.logo_ad_bg, options);
        }
        if (this.aCl != null) {
            try {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.aCl));
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
        if (bundle != null) {
            LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
        } else {
            LogoActivityConfig.isFirst = true;
        }
        this.aCm = TbadkCoreApplication.m411getInst().getIsFirstUse();
        z.DX().bu(this.aCm);
        Fw();
        this.mHandler.sendMessage(this.mHandler.obtainMessage());
        HashMap hashMap = new HashMap();
        hashMap.put("type", IntentConfig.START);
        hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
            Fx();
        }
        if (!com.baidu.tbadk.core.util.n.fi()) {
            TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
        }
    }

    private boolean Fv() {
        return getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
    }

    private void Fw() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.rf(), getPageContext().getPageActivity());
        }
        ap(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void Fx() {
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        z.DX().J(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FC();
        com.baidu.adp.lib.g.h.hh().removeCallbacks(this.aCo);
        com.baidu.adp.lib.g.h.hh().removeCallbacks(this.aCp);
        LogoActivityConfig.isFirst = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        FC();
    }

    private Bitmap k(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                bitmap.recycle();
                return null;
            }
            return bitmap;
        }
        return bitmap;
    }

    private void ap(Context context) {
        Fy();
        if (LogoActivityConfig.mFromSpacial) {
            eN(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.aCm) {
                if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                }
                com.baidu.adp.lib.g.k.hi().c(new f(this));
                finish();
                return;
            }
            eN(1);
        } else {
            Fz();
        }
    }

    private void Fy() {
        if (this.aCm) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.m411getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("frs_first_in", true);
        }
    }

    private void Fz() {
        h hVar = new h();
        long currentTimeMillis = System.currentTimeMillis();
        this.mBitmap = hVar.aq(getPageContext().getPageActivity());
        z.DX().K(System.currentTimeMillis() - currentTimeMillis);
        if (k(this.mBitmap) == null || this.aCk == null) {
            com.baidu.adp.lib.g.h.hh().postDelayed(this.aCo, 1000L);
        } else {
            com.baidu.adp.lib.g.h.hh().postDelayed(this.aCp, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        if (this.aCn >= 0) {
            eO(this.aCn);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
            finish();
        }
        z.DX().M(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FB() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.n.tD());
        if (file.isDirectory() && (listFiles = file.listFiles(new g(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void eN(int i) {
        this.aCn = i;
        Fz();
    }

    private void eO(int i) {
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
                        eN(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        eN(intExtra);
                        return;
                    } else {
                        eN(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void FC() {
        if (this.aCk != null) {
            this.aCk.setImageDrawable(null);
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.aCl != null && !this.aCl.isRecycled()) {
            this.aCl.recycle();
            this.aCl = null;
        }
    }
}
