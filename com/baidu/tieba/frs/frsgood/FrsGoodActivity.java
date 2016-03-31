package com.baidu.tieba.frs.frsgood;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.a.a.a;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class FrsGoodActivity extends BaseActivity<FrsGoodActivity> implements a.InterfaceC0000a, BdListView.e, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c {
    private static boolean isNeedRefreshOnResume = false;
    private com.baidu.adp.lib.f.b<TbImageView> ahC;
    private boolean biT;
    private String biU;
    private VoiceManager bja;
    private com.baidu.adp.lib.f.b<TbImageView> bkt;
    private af bse;
    private ag bsf;
    private w bsg;
    public boolean bkb = false;
    private String bkf = null;
    private String adH = null;
    private int bkg = 0;
    private int mPn = 1;
    private boolean bkh = false;
    private boolean bki = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean bkm = false;
    private boolean bkn = false;
    protected y bsd = null;
    private final as bkp = null;
    private com.baidu.tieba.tbadkCore.o bkq = new com.baidu.tieba.tbadkCore.o();
    private as bks = null;
    private boolean Km = false;
    public long bbg = -1;
    public long aBt = 0;
    public long aBB = 0;
    public long createTime = 0;
    public long Tq = -1;
    private boolean bkx = false;
    private com.baidu.tbadk.performanceLog.e bky = null;
    private boolean bkA = true;
    private int bkH = -1;
    private int bsh = 0;
    private Handler bsi = new a(this);
    private fo bkK = new m(this);
    private CustomMessageListener ahA = new o(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener bkX = new p(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    public final com.baidu.tieba.tbadkCore.r bkP = new q(this);
    private final CustomMessageListener Rf = new r(this, CmdConfigCustom.CMD_REFRESH);
    private NoNetworkView.a bfk = new s(this);
    private final bj bkW = new t(this);
    private final s.a bkU = new u(this);
    public final View.OnClickListener bkV = new b(this);
    private final AbsListView.OnScrollListener bjb = new c(this);
    private final View.OnClickListener bkY = new d(this);
    private final View.OnClickListener bkZ = new e(this);
    private final CustomMessageListener blc = new f(this, 0);
    private com.baidu.adp.widget.ListView.v bld = new g(this);
    private com.baidu.adp.widget.ListView.w blg = new i(this);

    private void SD() {
        this.bsf.ST().setVisibility(8);
        this.bsd.SO().setVisibility(8);
        showLoadingView(this.bsd.SN(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SE() {
        this.bsf.ST().setVisibility(0);
        this.bsd.SO().setVisibility(0);
        hideLoadingView(this.bsd.SN());
    }

    private void SF() {
        this.bsf.ST().setVisibility(0);
        this.bsd.SO().setVisibility(8);
        showLoadingView(this.bsd.SN(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SG() {
        this.bsf.ST().setVisibility(0);
        this.bsd.SO().setVisibility(0);
        hideLoadingView(this.bsd.SN());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        this.bsf.ST().setVisibility(8);
        this.bsd.SO().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.bsd.SN(), getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.bsd.SN(), "", true);
        }
    }

    private void SH() {
        this.bsf.ST().setVisibility(0);
        this.bsd.SO().setVisibility(0);
        hideNetRefreshView(this.bsd.SN());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.a aVar) {
        this.bsf.ST().setVisibility(0);
        this.bsd.SO().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.bsd.Sc(), getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.bsd.Sc(), "", true);
        }
    }

    private void SI() {
        this.bsf.ST().setVisibility(0);
        this.bsd.SO().setVisibility(0);
        hideNetRefreshView(this.bsd.Sc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK(boolean z) {
        Qn();
        if (!z) {
            if (this.bkn) {
                SI();
                SF();
            } else {
                SH();
                SD();
            }
        }
        this.bse.gv(this.bsh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        as asVar;
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bkq.getThreadList();
        if (threadList != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof as) && (asVar = (as) next) != null && asVar.getAuthor() != null && asVar.getAuthor().getUserId() != null && asVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
                    a(asVar, updateAttentionMessage);
                    break;
                }
            }
            this.bsd.SM().a(threadList, this.bkq);
            this.bsd.SM().notifyDataSetChanged();
        }
    }

    private void a(as asVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2;
        if (asVar != null && asVar.getAuthor() != null && asVar.getAuthor().getUserId() != null && asVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = asVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                i2 = 1;
            } else {
                i = fansNum - 1;
                i2 = 0;
            }
            asVar.getAuthor().setFansNum(i);
            if (asVar.getAuthor().getGodUserData() != null) {
                asVar.getAuthor().getGodUserData().setFollowed(i2);
                asVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bbg = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
        } else {
            this.bbg = System.currentTimeMillis();
        }
        this.Tq = System.currentTimeMillis();
        this.aBt = this.Tq - this.bbg;
        super.onCreate(bundle);
        setContentView(t.h.frs_good_activity);
        this.bse = new af(this);
        this.bsf = new ag(this);
        this.bsf.oJ();
        this.bsd.f(this.bfk);
        if (getIntent() != null) {
            this.bse.c(getIntent().getExtras());
        } else if (bundle != null) {
            this.bse.c(bundle);
        } else {
            this.bse.c(null);
        }
        this.bja = getVoiceManager();
        this.bja.onCreate(getPageContext());
        pU();
        initData(bundle);
        addGlobalLayoutListener();
        registerListener(this.Rf);
        registerListener(this.ahA);
        registerListener(this.bkX);
        this.bsg = new w(this);
        this.bsg.registerListener();
        this.createTime = System.currentTimeMillis() - this.Tq;
        if (com.baidu.adp.lib.util.i.jf()) {
            cK(false);
        } else {
            a((d.a) null);
        }
    }

    public void QU() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.bkq.avu().getId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bja = getVoiceManager();
        this.bja.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        QI();
        if (bundle != null) {
            this.bkf = bundle.getString("name");
            this.adH = bundle.getString("from");
            this.bkg = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bkf = intent.getStringExtra("name");
                this.adH = intent.getStringExtra("from");
                this.bkg = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.adH) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adH)) {
            setSwipeBackEnabled(false);
        }
    }

    private void QI() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.blc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bsd != null) {
            this.bsd.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bky != null) {
                this.bky.onDestroy();
            }
            this.bsd.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bse.onActivityDestroy();
        this.bja = getVoiceManager();
        this.bja.onDestory(getPageContext());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bkf);
        bundle.putString("from", this.adH);
        this.bse.onSaveInstanceState(bundle);
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        as nN;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11011:
                    d(this.bkp);
                    return;
                case 11012:
                    e(this.bks);
                    return;
                case 11016:
                    this.bsd.RR();
                    return;
                case 18003:
                    this.bsd.SM().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (nN = this.bkq.nN(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            nN.bX(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            nN.parser_title();
                            cK(false);
                            return;
                        } else if (intExtra == 0) {
                            this.bkq.l(nN);
                            ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bkq.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new di());
                            }
                            this.bsd.SL();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.biT = true;
        this.bkA = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bsd.nk();
            return;
        }
        this.bja = getVoiceManager();
        this.bja.onResume(getPageContext());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bkf = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.adH = intent.getStringExtra("from");
            }
            this.bki = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bki) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    QK();
                } else {
                    QL();
                }
            }
        }
    }

    private void QK() {
        this.bsd.nk();
    }

    private void QL() {
        this.bsd.nk();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adH)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adH)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adH)) {
            finish();
        }
    }

    private void pU() {
        this.bsd.SM().l(this.bkY);
        this.bsd.SM().m(this.bkZ);
        if (this.bkg != 0) {
            this.bkg = 1;
        }
        this.bsd.a(this.bld);
        this.bsd.a(this.blg);
        this.bsd.setOnScrollListener(this.bjb);
        this.bsd.a(this.bkU);
        this.bsd.SM().a(this.bkW);
        this.bsf.a(this.bkK);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bsd.onChangeSkinType(i);
        this.bsf.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> Qr() {
        if (this.bkt == null) {
            this.bkt = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.bkt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(as asVar) {
        boolean tS = asVar == null ? true : asVar.tS();
        this.bsd.a(new j(this, asVar));
        this.bsd.a(asVar, tS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(as asVar) {
        boolean tS = asVar == null ? true : asVar.tS();
        if (this.mThreadId != null) {
            if (!tS) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(asVar, this.bkf, null, 18003, true, true, this.bkm)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(asVar, this.bkf, null, 18003, false, false, this.bkm)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(as asVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(asVar, this.bkf, null, 18003, false, false, this.bkm)));
        }
    }

    private void QO() {
        switch (this.bkg) {
            case 1:
                com.baidu.adp.lib.h.k.hy().c(new k(this));
                break;
        }
        this.bkg = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QP() {
        Qn();
        try {
            if (this.bkq != null) {
                this.bsd.Mu();
                this.bkf = this.bkq.avu().getName();
                this.forumId = this.bkq.avu().getId();
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.bkq.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.bkq.getUserData().getBimg_end_time());
                QO();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bkq.getThreadList();
                if (threadList != null) {
                    this.bsd.a(threadList, this.mPn, this.bkq, this.bkq.getPage().sq());
                    QX();
                    this.bsd.SL();
                    if (this.bkq.avC() == 1) {
                        this.bsd.SM().setFromCDN(true);
                    } else {
                        this.bsd.SM().setFromCDN(false);
                    }
                    this.bsd.gV(W(SJ().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int W(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.biT = false;
        this.bkA = false;
        this.bja = getVoiceManager();
        this.bja.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bkq != null && this.bkq.avu() != null) {
            com.baidu.tbadk.distribute.a.CR().b(getPageContext().getPageActivity(), "frs", this.bkq.avu().getId(), 0L);
        }
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bkh) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.c cVar, int i, boolean z) {
        String trim;
        if (cVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            if (cVar.rm()) {
                bg.wM().a(getPageContext(), new String[]{cVar.Sc}, true);
            } else if (cVar.rl()) {
                if (com.baidu.adp.lib.util.i.jf() && !com.baidu.adp.lib.util.i.jg()) {
                    trim = getPageContext().getString(t.j.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.Sn.Sx.trim())) {
                    trim = getPageContext().getString(t.j.confirm_download_app);
                } else {
                    trim = cVar.Sn.Sx.trim();
                }
                aVar.cC(trim);
                aVar.a(t.j.alert_yes_button, new l(this, cVar, z, i));
                aVar.b(t.j.alert_no_button, new n(this));
                aVar.b(getPageContext()).up();
            }
        }
    }

    public boolean d(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar == null) {
            return false;
        }
        if (!cVar.rk()) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), t.j.pb_app_error);
            return false;
        } else if (!com.baidu.tieba.tbadkCore.ag.p(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), t.j.write_external_storage_permission_denied_fun_disable);
            return false;
        } else {
            boolean a = com.baidu.tieba.tbadkCore.ag.a(getPageContext().getPageActivity(), cVar, i);
            if (a) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Se);
            }
            return a;
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.CR().a(getPageContext().getPageActivity(), cVar, str, "frs", this.bkq.avu().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.CR().a(cVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bkq.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof as) {
                    as asVar = (as) next;
                    if (asVar.getId() != null && asVar.getId().equals(this.biU)) {
                        b(asVar, i);
                        this.biU = null;
                        break;
                    }
                }
            }
            this.bsd.SM().a(threadList, this.bkq);
            this.bsd.SM().notifyDataSetChanged();
        }
    }

    private void b(as asVar, int i) {
        if (i == 1) {
            PraiseData praise = asVar.getPraise();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (praise == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    asVar.setPraise(praiseData);
                    return;
                }
                asVar.getPraise().getUser().add(0, metaData);
                asVar.getPraise().setNum(asVar.getPraise().getNum() + 1);
                asVar.getPraise().setIsLike(i);
            }
        } else if (asVar.getPraise() != null) {
            asVar.getPraise().setIsLike(i);
            asVar.getPraise().setNum(asVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = asVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        asVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bja == null) {
            this.bja = VoiceManager.instance();
        }
        return this.bja;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: Mg */
    public BdListView getListView() {
        if (this.bsd == null) {
            return null;
        }
        return this.bsd.Mg();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void Qn() {
        this.bja = getVoiceManager();
        this.bja.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int xH() {
        if (this.bsd == null) {
            return 0;
        }
        return this.bsd.RV();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> xI() {
        if (this.ahC == null) {
            this.ahC = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.ahC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        cn SM;
        HashMap<Integer, as> Rm;
        if (this.bkq != null && this.bsd != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (SM = this.bsd.SM()) != null && (Rm = SM.Rm()) != null && Rm.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, as> entry : Rm.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        as value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Se, downloadData.getId())) {
                            int aSi = this.bkq.aSi();
                            if (SM.aF(intValue + aSi) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) SM.aF(aSi + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    cVar.RY = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!ay.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    cVar.RY = 0;
                                } else if (status == 1) {
                                    cVar.RY = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.bsd.RP();
        }
    }

    private void QX() {
        HashMap<Integer, as> Rm;
        if (this.bsd != null && this.bsd.SM() != null && (Rm = this.bsd.SM().Rm()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, as> entry : Rm.entrySet()) {
                as value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.CX().n(arrayList);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            a(cVar, true, this.mPn);
            int i2 = cVar.RY;
            if (i2 == 0) {
                a(cVar, i, true);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.E(getPageContext().getPageActivity(), cVar.Se);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Se);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            a(cVar, true, this.mPn);
            bg.wM().a(getPageContext(), new String[]{cVar.Sc}, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.i.jf()) {
            cK(false);
        }
    }

    public af SJ() {
        return this.bse;
    }

    public void hI(String str) {
        this.bkf = str;
    }

    public void setFrom(String str) {
        this.adH = str;
    }

    public void setFlag(int i) {
        this.bkg = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        if (!com.baidu.adp.lib.util.k.jw()) {
            this.bsd.Si();
        } else if (!this.bse.SR()) {
            this.bsd.Si();
        } else {
            Re();
            if (!this.bsg.azx && !this.bse.isLoading()) {
                if (this.bsg.ak(this.bkq.aRJ())) {
                    this.bsd.a(this.bsg.SK(), this.mPn, this.bkq, 0);
                    this.bsg.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.bkq.aRJ(), this.bkf, this.mPn);
                } else if (this.bkH != 0) {
                    this.bsd.a(this.bsg.SK(), this.mPn, this.bkq, 0);
                    this.mPn++;
                    this.bse.gW(this.mPn);
                    this.bsg.bsm = false;
                    this.bsg.bsn = 0;
                }
            }
        }
    }

    public void hJ(String str) {
        Re();
    }

    public void B(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        Re();
        if (arrayList != null && arrayList.size() != 0 && (a = this.bsg.a(false, arrayList)) != null) {
            this.bkq.ao(a);
            this.bsd.a(a, this.mPn, this.bkq, 0);
        }
    }

    private void Re() {
        if (this.bkH == 0 && !this.bsg.ak(this.bkq.aRJ())) {
            if (this.bkq.getThreadList() == null || this.bkq.getThreadList().size() == 0) {
                this.bsd.Si();
                return;
            } else {
                this.bsd.Sh();
                return;
            }
        }
        this.bsd.Sg();
    }

    public void a(y yVar) {
        this.bsd = yVar;
    }

    private void a(com.baidu.tbadk.core.data.c cVar, boolean z, int i) {
        a(cVar, z ? "area_click" : "btn_click");
        b(cVar, "click");
        com.baidu.tieba.recapp.report.b.aLC().a(com.baidu.tieba.recapp.report.e.a(cVar, "click", i));
    }

    public void Rh() {
        if (!com.baidu.tbadk.core.util.ag.c(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.as.c(getPageContext());
        }
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void a(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ag.S(getApplicationContext())) {
                com.baidu.tbadk.core.util.as.c(getPageContext());
            } else {
                showToast(t.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(t.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }
}
