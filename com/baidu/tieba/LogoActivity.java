package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.appsearchlib.NASLib;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.AdSdkSwitch;
import com.baidu.tieba.view.BesAdViewContainer;
import com.baidu.tieba.w.d;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private boolean gfa;
    private com.baidu.tbadk.core.dialog.a gfd;
    private com.baidu.tbadk.core.dialog.a gfe;
    private com.baidu.tbadk.core.dialog.a gff;
    private com.baidu.tieba.w.d gfi;
    private View gfj;
    private com.baidu.tbadk.g.e gfk;
    private BesAdViewContainer gfl;
    private com.baidu.tbadk.g.d gfn;
    private com.baidu.tbadk.s.a gfo;
    private RelativeLayout mRootView;
    private Bitmap geU = null;
    private boolean geV = false;
    private boolean geW = true;
    private long geX = -1;
    private long geY = -1;
    private int geZ = -1;
    private boolean gfb = false;
    private boolean gfc = true;
    private int gfg = 2;
    private a gfh = new a();
    private boolean gfm = false;
    private com.baidu.tbadk.s.b gfp = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void agG() {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(LogoActivity.this.gfw);
            LogoActivity.this.bNr();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(LogoActivity.this.gfw);
            if (LogoActivity.this.gfo.getView() == null) {
                LogoActivity.this.bNw();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.gfo.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.gfo.getView());
            if (LogoActivity.this.geZ == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            com.baidu.tbadk.n.l.bHL().er(System.currentTimeMillis());
            TiebaStatic.log(new aq("c13331").dX("obj_id", str).an("obj_type", z2 ? 2 : 1));
            aq aqVar = new aq("common_exp");
            aqVar.dX("page_type", "a030").an("obj_isad", 1).dX("obj_id", str).an("obj_floor", 1).an("obj_source", 2).an("obj_adlocate", 16);
            if (z) {
                aqVar.an("obj_type", z2 ? 4 : 3);
            } else {
                aqVar.an("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dNY().a(LogoActivity.this.getUniqueId(), str, aqVar);
            com.baidu.tieba.s.c.dNY().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void onAdDismiss() {
            LogoActivity.this.gfb = true;
            if (LogoActivity.this.gfc) {
                LogoActivity.this.bNw();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void az(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.gfo.getView() != null) {
                z2 = LogoActivity.this.gfo.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new aq("c13332").dX("obj_id", str).an("obj_type", z2 ? 2 : 1));
            aq aqVar = new aq("common_click");
            aqVar.dX("page_type", "a030").an("obj_isad", 1).dX("obj_id", str).an("obj_floor", 1).an("obj_source", 2).an("obj_adlocate", 16);
            if (z) {
                aqVar.an("obj_type", z2 ? 4 : 3);
            } else {
                aqVar.an("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dNY().b(LogoActivity.this.getUniqueId(), aqVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bNw();
        }
    };
    private long gfq = -1;
    private d.a gfr = new d.a() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bNu();
        }

        @Override // com.baidu.tieba.w.d.a
        public void agI() {
            if (LogoActivity.this.geZ != -2) {
                LogoActivity.this.bNv();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener gfs = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bNl()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(LogoActivity.this.gfh);
                    LogoActivity.this.gfb = true;
                    if (LogoActivity.this.gfc) {
                        LogoActivity.this.bNw();
                    }
                }
            }
        }
    };
    private Runnable gft = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bNj();
        }
    };
    private Runnable gfu = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bNw();
        }
    };
    private Runnable gfv = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.gfm && LogoActivity.this.gfl != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.gfl);
                com.baidu.adp.lib.f.e.mB().post(LogoActivity.this.gfu);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable gfw = new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bNu();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    View.OnClickListener fko = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes || id == R.id.final_private_yes) {
                if (LogoActivity.this.gfd != null && LogoActivity.this.gfd.isShowing()) {
                    LogoActivity.this.gfd.dismiss();
                }
                if (LogoActivity.this.gff != null && LogoActivity.this.gff.isShowing()) {
                    LogoActivity.this.gff.dismiss();
                }
                ad.jN(true);
                com.baidu.tbadk.core.sharedPref.b.bvr().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bNC() || ad.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bNj();
                    aq aqVar = new aq("c13295");
                    aqVar.dX("obj_locate", "1");
                    TiebaStatic.log(aqVar);
                    return;
                }
                LogoActivity.this.bND();
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.gfd.isShowing()) {
                    LogoActivity.this.gfd.dismiss();
                }
                aq aqVar2 = new aq("c13295");
                aqVar2.dX("obj_locate", "2");
                TiebaStatic.log(aqVar2);
                if (LogoActivity.this.gfe == null) {
                    LogoActivity.this.bNA();
                }
                LogoActivity.this.gfe.btY();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.gfe.isShowing()) {
                    LogoActivity.this.gfe.dismiss();
                }
                if (LogoActivity.this.gfg > 0) {
                    if (LogoActivity.this.gfd == null) {
                        LogoActivity.this.bNz();
                    }
                    LogoActivity.this.gfd.btY();
                    LogoActivity.y(LogoActivity.this);
                    return;
                }
                if (LogoActivity.this.gff == null) {
                    LogoActivity.this.bNB();
                }
                LogoActivity.this.gff.btY();
            } else if (id == R.id.final_private_no) {
                if (LogoActivity.this.gff.isShowing()) {
                    LogoActivity.this.gff.dismiss();
                }
                LogoActivity.this.finish();
            }
        }
    };
    private ClickableSpan gfx = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(LogoActivity.this.getResources().getColor(17170445));
            }
            com.baidu.tbadk.browser.a.startExternWebActivity(LogoActivity.this.getActivity(), "http://tieba.baidu.com/tb/cms/client/wise_secretright.html");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.CAM_X0304));
        }
    };

    static /* synthetic */ int y(LogoActivity logoActivity) {
        int i = logoActivity.gfg;
        logoActivity.gfg = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNj() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.gfa = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        com.baidu.adp.lib.f.h.mC().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.15
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.bNy();
                LogoActivity.bNx();
            }
        });
        finish();
    }

    private void M(Intent intent) {
        if (intent != null) {
            if (intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) {
                LogoActivityConfig.mFromSpacial = true;
                Intent intent2 = new Intent();
                intent2.putExtra(DealIntentService.KEY_CLASS, 2);
                intent2.putExtra("fname", intent.getStringExtra("fname"));
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
        this.gfq = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dNY().z(getUniqueId());
        init(bundle);
    }

    private boolean bNk() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new aq("c11897").dX("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNl() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bNm() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.boz(), getPageContext().getPageActivity());
            }
        }
        fF(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z = false;
        super.onConfigurationChanged(configuration);
        if (this.gfo != null && this.gfo.getView() != null && this.gfo.getView().getParent() != null) {
            if (this.gfo.getView() != null) {
                if (this.gfo.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gfo.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.gfo.getView().setLayoutParams(layoutParams);
        }
        if (this.gfk != null && this.gfk.eJM != null) {
            this.gfk.eJM.bnP();
        }
    }

    private void bNn() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageConfig.DEBUGTOOL_START, new com.baidu.adp.a.a.c(getPageContext().getPageActivity())));
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
        this.gfc = false;
        if (this.gfi != null) {
            this.gfi.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gfc = true;
        if (this.geW) {
            this.geW = false;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bvr().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.bvr().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (ad.bvZ()) {
            NASLib.onAppStart(getActivity());
        }
        if (this.gfb) {
            bNw();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.gfa) {
            bNj();
            this.gfa = false;
        }
        if (this.gfi != null) {
            this.gfi.onResume();
        }
        if (LogoActivityConfig.isFirst && this.gfq >= 0) {
            com.baidu.tbadk.n.l.bHL().eo(System.currentTimeMillis() - this.gfq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gfk != null) {
            this.gfk.setParentView(null);
            this.gfk.a(null);
        }
        if (this.gfn != null) {
            this.gfn.setParentView(null);
            this.gfn.a(null);
        }
        if (this.gfo != null) {
            this.gfo.release();
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gfh);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gft);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gfu);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gfv);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gfw);
        if (this.gfi != null) {
            this.gfi.onDestroy();
        }
        if (this.geU != null && !this.geU.isRecycled()) {
            this.geU.recycle();
            this.geU = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dNY().A(getUniqueId());
        com.baidu.adp.lib.util.d.nI().clearCashBitmap();
    }

    private void fF(Context context) {
        bNo();
        if (LogoActivityConfig.mFromSpacial) {
            ur(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.geV) {
                com.baidu.adp.lib.f.e.mB().post(this.gft);
            } else {
                ur(2);
            }
        } else if (this.geV) {
            com.baidu.adp.lib.f.e.mB().post(this.gft);
        } else {
            bNp();
        }
    }

    private void bNo() {
        if (this.geV) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bNp() {
        if (this.geZ != -2) {
            if (this.gfi == null) {
                this.gfi = new com.baidu.tieba.w.d(this);
            }
            if (this.gfi.dXo()) {
                this.gfj = this.gfi.J(0.8125d);
                this.mRootView.addView(this.gfj);
                this.gfi.a(this.gfr);
                this.gfi.start();
                return;
            }
            this.gfi.dXs();
        }
        bNq();
    }

    private void bNq() {
        this.geX = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.s.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.gfo = (com.baidu.tbadk.s.a) runTask.getData();
            this.gfo.a(this.gfp);
            this.gfo.bIq();
            com.baidu.tbadk.n.l.bHL().ep(System.currentTimeMillis() - this.geX);
            int i = com.baidu.tbadk.core.sharedPref.b.bvr().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(this.gfw, i * 1000);
            return;
        }
        bNr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNr() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bNu();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            bNu();
            return;
        }
        boolean Ai = com.baidu.tbadk.a.b.Ai("ad_xuzhang_splash_sdk");
        if (findTask2 != null && Ai) {
            bNs();
        } else if (findTask != null) {
            bNt();
        } else {
            bNu();
        }
    }

    private void bNs() {
        this.geX = System.currentTimeMillis();
        this.geY = System.currentTimeMillis();
        this.gfn = new com.baidu.tbadk.g.d();
        this.gfl = new BesAdViewContainer(getPageContext().getPageActivity());
        this.gfl.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bNw();
            }
        });
        this.gfl.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.gfl);
        this.gfn.setParentView(this.gfl);
        this.gfn.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tbadk.g.c
            public void Ao(String str) {
                LogoActivity.this.gfm = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.gfl);
                LogoActivity.this.bNu();
                com.baidu.tbadk.n.l.bHL().eq(System.currentTimeMillis() - LogoActivity.this.geY);
            }

            @Override // com.baidu.tbadk.g.c
            public void bnQ() {
                LogoActivity.this.gfm = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.geZ == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mB().removeCallbacks(LogoActivity.this.gfv);
                com.baidu.tbadk.n.l.bHL().er(System.currentTimeMillis());
                com.baidu.tbadk.n.l.bHL().eq(System.currentTimeMillis() - LogoActivity.this.geY);
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdDismiss() {
                LogoActivity.this.gfb = true;
                if (LogoActivity.this.gfc) {
                    LogoActivity.this.bNw();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.gfn));
        com.baidu.tbadk.n.l.bHL().ep(System.currentTimeMillis() - this.geX);
        int i = com.baidu.tbadk.core.sharedPref.b.bvr().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.gfv, (i > 0 ? i : 1) * 1000);
    }

    private void bNt() {
        this.geX = System.currentTimeMillis();
        this.geY = System.currentTimeMillis();
        this.gfk = new com.baidu.tbadk.g.e();
        this.gfl = new BesAdViewContainer(getPageContext().getPageActivity());
        this.gfl.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bNw();
            }
        });
        this.gfl.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.gfl);
        this.gfk.setParentView(this.gfl);
        this.gfk.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.5
            @Override // com.baidu.tbadk.g.a
            public void Ao(String str) {
                LogoActivity.this.gfm = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.gfl);
                LogoActivity.this.bNu();
                com.baidu.tbadk.n.l.bHL().eq(System.currentTimeMillis() - LogoActivity.this.geY);
            }

            @Override // com.baidu.tbadk.g.a
            public void v(boolean z, boolean z2) {
                LogoActivity.this.gfm = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).an("obj_type", z2 ? 2 : 1));
                aq aqVar = new aq("common_exp");
                aqVar.dX("page_type", "a030").an("obj_isad", 1).an("obj_floor", 1).an("obj_source", 1).an("obj_adlocate", 16);
                if (z) {
                    aqVar.an("obj_type", z2 ? 4 : 3);
                } else {
                    aqVar.an("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dNY().a(LogoActivity.this.getUniqueId(), "bes_ad_id", aqVar);
                com.baidu.tieba.s.c.dNY().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.geZ == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mB().removeCallbacks(LogoActivity.this.gfv);
                com.baidu.tbadk.n.l.bHL().er(System.currentTimeMillis());
                com.baidu.tbadk.n.l.bHL().eq(System.currentTimeMillis() - LogoActivity.this.geY);
            }

            @Override // com.baidu.tbadk.g.a
            public void onAdDismiss() {
                LogoActivity.this.gfb = true;
                if (LogoActivity.this.gfc) {
                    LogoActivity.this.bNw();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void w(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).an("obj_type", z2 ? 2 : 1));
                aq aqVar = new aq("common_click");
                aqVar.dX("page_type", "a030").an("obj_isad", 1).an("obj_floor", 1).an("obj_source", 1).an("obj_adlocate", 16);
                if (z) {
                    aqVar.an("obj_type", z2 ? 4 : 3);
                } else {
                    aqVar.an("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dNY().b(LogoActivity.this.getUniqueId(), aqVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.gfk));
        com.baidu.tbadk.n.l.bHL().ep(System.currentTimeMillis() - this.geX);
        int i = com.baidu.tbadk.core.sharedPref.b.bvr().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.gfv, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNu() {
        if (this.geZ == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.mB().post(this.gfu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNv() {
        if (this.geZ >= 0) {
            us(this.geZ);
        } else if (this.geZ == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNw() {
        bNv();
        com.baidu.tbadk.n.l.bHL().es(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bNx() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            n.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNy() {
        File[] listFiles;
        File file = new File(n.getCacheDir());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.6
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                return !TextUtils.isEmpty(name) && name.contains(LogoActivity.this.getPageContext().getString(R.string.app_name)) && name.endsWith(".apk");
            }
        })) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void ur(int i) {
        this.geZ = i;
        bNp();
    }

    private void us(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNz() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.gfx, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0302)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.gfd = new com.baidu.tbadk.core.dialog.a(this);
        this.gfd.br(inflate);
        this.gfd.pd(3);
        this.gfd.jI(false);
        this.gfd.setAutoNight(false);
        this.gfd.jH(false);
        ao.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        ao.a((View) textView3, R.color.CAM_X0105, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.fko);
        textView3.setOnClickListener(this.fko);
        this.gfd.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNA() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        ao.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.fko);
        this.gfe = new com.baidu.tbadk.core.dialog.a(this);
        this.gfe.br(inflate);
        this.gfe.pd(3);
        this.gfe.jI(false);
        this.gfe.setAutoNight(false);
        this.gfe.jH(false);
        this.gfe.b(getPageContext());
    }

    private void init(Bundle bundle) {
        if (!ad.bvZ()) {
            bNz();
            this.gfd.btY();
            this.gfg--;
            TiebaStatic.log(new aq("c13294"));
        } else if (!bNC() && !ad.checkLocationForGoogle(getActivity())) {
            bND();
        } else {
            if (ad.checkLocationForGoogle(getActivity())) {
                com.baidu.adp.lib.c.a.lI().getAddress(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (bNl()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.gfs);
                    this.geZ = -2;
                    bNq();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !bNk()) {
                finish();
            } else {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.HOST_START).an("obj_param1", 2).an(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getStartType()).an(TiebaInitialize.Params.OBJ_PARAM3, TbadkCoreApplication.getInst().getCanShowSplash()));
                TbadkCoreApplication.getInst().onLowMemory();
                if (!TbadkCoreApplication.isLogin()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
                }
                M(getIntent());
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                if (bundle != null) {
                    LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
                } else {
                    LogoActivityConfig.isFirst = true;
                }
                this.geV = TbadkCoreApplication.getInst().getIsFirstUse();
                com.baidu.tbadk.n.l.bHL().lp(this.geV);
                registerListener(this.gfs);
                bNm();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", "start");
                hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                    bNn();
                }
                if (!n.checkSD()) {
                    TiebaStatic.file("no SD", "LogoActivity.onCreate");
                }
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNB() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.final_private_dialog, (ViewGroup) null);
        inflate.findViewById(R.id.final_private_button_layout).setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R.id.final_scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.final_private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.final_private_no);
        ao.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        ao.a((View) textView3, R.color.CAM_X0105, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.fko);
        textView3.setOnClickListener(this.fko);
        this.gff = new com.baidu.tbadk.core.dialog.a(this);
        this.gff.br(inflate);
        this.gff.pd(3);
        this.gff.jI(false);
        this.gff.setAutoNight(false);
        this.gff.jH(false);
        this.gff.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        ur(2);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        ur(intExtra);
                        return;
                    } else {
                        ur(2);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 22001) {
            com.baidu.adp.lib.c.a.lI().getAddress(false);
            bNj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNC() {
        return at.equals(TbConfig.getVersion(), com.baidu.tbadk.core.sharedPref.b.bvr().getString("key_location_request_dialog_last_show_version", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bND() {
        com.baidu.tbadk.core.sharedPref.b.bvr().putString("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        ad.a(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onClose() {
                LogoActivity.this.bNj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bNw();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a064";
    }
}
