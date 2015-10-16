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
    private com.baidu.tbadk.core.dialog.a Lu;
    private View mRootView;
    private ImageView aDq = null;
    private Bitmap mBitmap = null;
    private Bitmap aDr = null;
    private boolean aDs = false;
    private int aDt = -1;
    private a aDu = new a(this, null);
    private Runnable aDv = new b(this);

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
            LogoActivity.this.FH();
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
        if (!isTaskRoot() && !FC()) {
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
        this.aDq = (ImageView) findViewById(i.f.logo);
        this.aDr = com.baidu.tbadk.core.util.c.f(getPageContext().getPageActivity(), i.e.logo_ad_bg);
        if (this.aDr == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            options.inSampleSize = 2;
            this.aDr = com.baidu.tbadk.core.util.c.a(getPageContext().getPageActivity(), i.e.logo_ad_bg, options);
        }
        if (this.aDr != null) {
            try {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.aDr));
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
        if (bundle != null) {
            LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
        } else {
            LogoActivityConfig.isFirst = true;
        }
        this.aDs = TbadkCoreApplication.m411getInst().getIsFirstUse();
        z.Eh().br(this.aDs);
        FD();
        this.mHandler.sendMessage(this.mHandler.obtainMessage());
        HashMap hashMap = new HashMap();
        hashMap.put("type", IntentConfig.START);
        hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
            FE();
        }
        if (!com.baidu.tbadk.core.util.n.fi()) {
            TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
        }
    }

    private boolean FC() {
        return getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
    }

    private void FD() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.rh(), getPageContext().getPageActivity());
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

    private void FE() {
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
        z.Eh().L(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FJ();
        com.baidu.adp.lib.g.h.hg().removeCallbacks(this.aDu);
        com.baidu.adp.lib.g.h.hg().removeCallbacks(this.aDv);
        LogoActivityConfig.isFirst = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        FJ();
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
        FF();
        if (LogoActivityConfig.mFromSpacial) {
            eN(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.aDs) {
                if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                }
                com.baidu.adp.lib.g.k.hh().c(new f(this));
                finish();
                return;
            }
            eN(1);
        } else {
            FG();
        }
    }

    private void FF() {
        if (this.aDs) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.m411getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("frs_first_in", true);
        }
    }

    private void FG() {
        h hVar = new h();
        long currentTimeMillis = System.currentTimeMillis();
        this.mBitmap = hVar.aq(getPageContext().getPageActivity());
        z.Eh().M(System.currentTimeMillis() - currentTimeMillis);
        if (k(this.mBitmap) == null || this.aDq == null) {
            com.baidu.adp.lib.g.h.hg().postDelayed(this.aDu, 1000L);
        } else {
            com.baidu.adp.lib.g.h.hg().postDelayed(this.aDv, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FH() {
        if (this.aDt >= 0) {
            eO(this.aDt);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
            finish();
        }
        z.Eh().O(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FI() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.n.tD());
        if (file.isDirectory() && (listFiles = file.listFiles(new g(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void eN(int i) {
        this.aDt = i;
        FG();
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

    private void FJ() {
        if (this.aDq != null) {
            this.aDq.setImageDrawable(null);
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.aDr != null && !this.aDr.isRecycled()) {
            this.aDr.recycle();
            this.aDr = null;
        }
    }
}
