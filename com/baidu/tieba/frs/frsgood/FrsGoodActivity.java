package com.baidu.tieba.frs.frsgood;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class FrsGoodActivity extends BaseActivity<FrsGoodActivity> implements BdListView.e, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c {
    private static boolean isNeedRefreshOnResume = false;
    private boolean aSH;
    private String aSI;
    private com.baidu.adp.lib.e.b<TbImageView> aUh;
    private com.baidu.adp.lib.e.b<TbImageView> aeN;
    private ae baa;
    private af bab;
    private v bac;
    private VoiceManager mVoiceManager;
    public boolean aTQ = false;
    private String aTU = null;
    private String mFrom = null;
    private int aTV = 0;
    private int mPn = 1;
    private boolean aTW = false;
    private boolean aTX = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aUa = false;
    private boolean aUb = false;
    protected x aZZ = null;
    private final com.baidu.tbadk.core.data.w aUd = null;
    private com.baidu.tieba.tbadkCore.o aUe = new com.baidu.tieba.tbadkCore.o();
    private com.baidu.tbadk.core.data.w aUg = null;
    private boolean Jk = false;
    public long aLR = -1;
    public long awn = 0;
    public long createTime = 0;
    public long aUi = -1;
    private boolean aUm = false;
    public com.baidu.tbadk.performanceLog.e aUn = null;
    private boolean aUp = true;
    private int aUv = -1;
    private int bad = 0;
    private Handler bae = new a(this);
    private ec aUy = new m(this);
    private CustomMessageListener aSN = new n(this, CmdConfigCustom.PB_ACTION_PRAISE);
    public final com.baidu.tieba.tbadkCore.r aUC = new o(this);
    private final CustomMessageListener Tt = new p(this, CmdConfigCustom.CMD_REFRESH);
    private NoNetworkView.a aPg = new q(this);
    private final bd aUG = new r(this);
    private final p.a aUE = new s(this);
    public final View.OnClickListener aUF = new t(this);
    private final AbsListView.OnScrollListener aSP = new b(this);
    private final View.OnClickListener aUH = new c(this);
    private final View.OnClickListener aUI = new d(this);
    private final CustomMessageListener aUK = new e(this, 0);
    private com.baidu.adp.widget.ListView.v aUL = new f(this);
    private com.baidu.adp.widget.ListView.w aUO = new h(this);

    private void MS() {
        this.bab.Nj().setVisibility(8);
        this.aZZ.Nd().setVisibility(8);
        showLoadingView(this.aZZ.Nc(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MT() {
        this.bab.Nj().setVisibility(0);
        this.aZZ.Nd().setVisibility(0);
        hideLoadingView(this.aZZ.Nc());
    }

    private void MU() {
        this.bab.Nj().setVisibility(0);
        this.aZZ.Nd().setVisibility(8);
        showLoadingView(this.aZZ.Nc(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MV() {
        this.bab.Nj().setVisibility(0);
        this.aZZ.Nd().setVisibility(0);
        hideLoadingView(this.aZZ.Nc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar) {
        this.bab.Nj().setVisibility(8);
        this.aZZ.Nd().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.aZZ.Nc(), getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.aZZ.Nc(), "", true);
        }
    }

    private void MW() {
        this.bab.Nj().setVisibility(0);
        this.aZZ.Nd().setVisibility(0);
        hideNetRefreshView(this.aZZ.Nc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e.a aVar) {
        this.bab.Nj().setVisibility(0);
        this.aZZ.Nd().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.aZZ.Mm(), getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.aZZ.Mm(), "", true);
        }
    }

    private void MX() {
        this.bab.Nj().setVisibility(0);
        this.aZZ.Nd().setVisibility(0);
        hideNetRefreshView(this.aZZ.Mm());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(boolean z) {
        stopVoice();
        if (!z) {
            if (this.aUb) {
                MX();
                MU();
            } else {
                MW();
                MS();
            }
        }
        this.baa.fr(this.bad);
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
            this.aLR = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aLR = System.currentTimeMillis();
        }
        if (this.aLR != -1) {
            this.aUi = this.aLR;
        } else {
            this.aUi = System.currentTimeMillis();
        }
        super.onCreate(bundle);
        setContentView(i.g.frs_good_activity);
        this.baa = new ae(this);
        this.bab = new af(this);
        this.bab.oR();
        this.aZZ.g(this.aPg);
        if (getIntent() != null) {
            this.baa.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.baa.f(bundle);
        } else {
            this.baa.f(null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        addGlobalLayoutListener();
        registerListener(this.Tt);
        registerListener(this.aSN);
        this.bac = new v(this);
        this.bac.registerListener();
        this.createTime = System.currentTimeMillis() - this.aLR;
        if (com.baidu.adp.lib.util.i.iN()) {
            ck(false);
        } else {
            a((e.a) null);
        }
    }

    public void Lo() {
        com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aUe.afg().getId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        Le();
        if (bundle != null) {
            this.aTU = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aTV = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aTU = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aTV = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
    }

    private void Le() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.aUK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.aZZ != null) {
            this.aZZ.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aUn != null) {
                this.aUn.onDestroy();
            }
            this.aZZ.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.baa.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aTU);
        bundle.putString("from", this.mFrom);
        this.baa.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.w ly;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11011:
                    b(this.aUd);
                    return;
                case 11012:
                    c(this.aUg);
                    return;
                case 11016:
                    this.aZZ.Me();
                    return;
                case 18003:
                    this.aZZ.Nb().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (ly = this.aUe.ly(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            ly.bB(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            ly.parser_title();
                            ck(false);
                            return;
                        } else if (intExtra == 0) {
                            this.aUe.g(ly);
                            ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUe.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new cd());
                            }
                            this.aZZ.Na();
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
        this.aSH = true;
        this.aUp = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aZZ.nx();
            return;
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aTU = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aTX = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aTX) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    Lg();
                } else {
                    Lh();
                }
            }
        }
    }

    private void Lg() {
        this.aZZ.nx();
    }

    private void Lh() {
        this.aZZ.nx();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            finish();
        }
    }

    private void initUI() {
        this.aZZ.Nb().h(this.aUH);
        this.aZZ.Nb().i(this.aUI);
        if (this.aTV != 0) {
            this.aTV = 1;
        }
        this.aZZ.a(this.aUL);
        this.aZZ.a(this.aUO);
        this.aZZ.setOnScrollListener(this.aSP);
        this.aZZ.a(this.aUE);
        this.aZZ.Nb().a(this.aUG);
        this.bab.a(this.aUy);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aZZ.onChangeSkinType(i);
        this.bab.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> KP() {
        if (this.aUh == null) {
            this.aUh = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aUh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.w wVar) {
        boolean sE = wVar == null ? true : wVar.sE();
        this.aZZ.c(new i(this, wVar));
        this.aZZ.a(wVar, sE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.w wVar) {
        boolean sE = wVar == null ? true : wVar.sE();
        if (this.mThreadId != null) {
            if (!sE) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aTU, null, 18003, true, true, this.aUa)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aTU, null, 18003, false, false, this.aUa)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.w wVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aTU, null, 18003, false, false, this.aUa)));
        }
    }

    private void Ll() {
        switch (this.aTV) {
            case 1:
                com.baidu.adp.lib.g.k.hi().c(new j(this));
                break;
        }
        this.aTV = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lm() {
        stopVoice();
        try {
            if (this.aUe != null) {
                this.aZZ.Mb();
                this.aTU = this.aUe.afg().getName();
                this.forumId = this.aUe.afg().getId();
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aUe.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aUe.getUserData().getBimg_end_time());
                Ll();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUe.getThreadList();
                if (threadList != null) {
                    this.aZZ.a(threadList, this.mPn, this.aUe, this.aUe.getPage().rK());
                    Lr();
                    this.aZZ.Na();
                    if (this.aUe.afm() == 1) {
                        this.aZZ.Nb().setFromCDN(true);
                    } else {
                        this.aZZ.Nb().setFromCDN(false);
                    }
                    this.aZZ.fS(X(MY().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int X(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aSH = false;
        this.aUp = false;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.aUe != null && this.aUe.afg() != null) {
            com.baidu.tbadk.distribute.a.Ai().a(getPageContext().getPageActivity(), "frs", this.aUe.afg().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aTW) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i) {
        String trim;
        if (bVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            if (bVar.rp()) {
                az.uX().b(getPageContext(), new String[]{bVar.TZ});
            } else if (bVar.ro()) {
                if (com.baidu.adp.lib.util.i.iN() && !com.baidu.adp.lib.util.i.iO()) {
                    trim = getPageContext().getString(i.h.frs_network_tips);
                } else if (TextUtils.isEmpty(bVar.Uk.Uq.trim())) {
                    trim = getPageContext().getString(i.h.confirm_download_app);
                } else {
                    trim = bVar.Uk.Uq.trim();
                }
                aVar.cu(trim);
                aVar.a(i.h.alert_yes_button, new k(this, bVar, i));
                aVar.b(i.h.alert_no_button, new l(this));
                aVar.b(getPageContext()).sR();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar != null) {
            if (!bVar.rn()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), i.h.pb_app_error);
            } else if (com.baidu.adp.lib.util.i.iN()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", bVar.Ub);
                com.baidu.tbadk.download.b.Ap().a(bVar.Ub, bVar.Ua, bVar.TX, i, com.baidu.adp.lib.g.b.g(bVar.TW, 0));
            } else {
                showToast(i.h.neterror);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Ai().a(getPageContext().getPageActivity(), bVar, str, "frs", this.aUe.afg().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Ai().a(bVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUe.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.w) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) next;
                    if (wVar.getId() != null && wVar.getId().equals(this.aSI)) {
                        b(wVar, i);
                        this.aSI = null;
                        break;
                    }
                }
            }
            this.aZZ.Nb().a(threadList, this.aUe);
            this.aZZ.Nb().notifyDataSetChanged();
        }
    }

    private void b(com.baidu.tbadk.core.data.w wVar, int i) {
        if (i == 1) {
            PraiseData praise = wVar.getPraise();
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
                    wVar.setPraise(praiseData);
                    return;
                }
                wVar.getPraise().getUser().add(0, metaData);
                wVar.getPraise().setNum(wVar.getPraise().getNum() + 1);
                wVar.getPraise().setIsLike(i);
            }
        } else if (wVar.getPraise() != null) {
            wVar.getPraise().setIsLike(i);
            wVar.getPraise().setNum(wVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = wVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        wVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.aZZ == null) {
            return null;
        }
        return this.aZZ.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vE() {
        if (this.aZZ == null) {
            return 0;
        }
        return this.aZZ.Mi();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vF() {
        if (this.aeN == null) {
            this.aeN = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aeN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bq Nb;
        HashMap<Integer, com.baidu.tbadk.core.data.w> LG;
        if (this.aUe != null && this.aZZ != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Nb = this.aZZ.Nb()) != null && (LG = Nb.LG()) != null && LG.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : LG.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.w value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && TextUtils.equals(((com.baidu.tbadk.core.data.b) value).Ub, downloadData.getId())) {
                            int aww = this.aUe.aww();
                            if (Nb.aA(intValue + aww) instanceof com.baidu.tbadk.core.data.b) {
                                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) Nb.aA(aww + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    bVar.TV = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!as.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    bVar.TV = 0;
                                } else if (status == 1) {
                                    bVar.TV = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aZZ.Mc();
        }
    }

    private void Lr() {
        HashMap<Integer, com.baidu.tbadk.core.data.w> LG;
        if (this.aZZ != null && this.aZZ.Nb() != null && (LG = this.aZZ.Nb().LG()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : LG.entrySet()) {
                com.baidu.tbadk.core.data.w value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            com.baidu.tbadk.download.b.Ap().o(arrayList);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar != null) {
            a(bVar, "area_click");
            b(bVar, "click");
            int i2 = bVar.TV;
            if (i2 == 0) {
                a(bVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), bVar.Ub);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", bVar.Ub);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            a(bVar, "btn_click");
            b(bVar, "click");
            az.uX().b(getPageContext(), new String[]{bVar.TZ});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.i.iN()) {
            ck(false);
        }
    }

    public ae MY() {
        return this.baa;
    }

    public void gP(String str) {
        this.aTU = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFlag(int i) {
        this.aTV = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.je()) {
            this.aZZ.Ms();
        } else if (!this.baa.Nh()) {
            this.aZZ.Ms();
        } else {
            Lz();
            if (!this.bac.auq && !this.baa.isLoading()) {
                if (this.bac.ac(this.aUe.awc())) {
                    this.aZZ.a(this.bac.MZ(), this.mPn, this.aUe, 0);
                    this.bac.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.aUe.awc());
                } else if (this.aUv != 0) {
                    this.aZZ.a(this.bac.MZ(), this.mPn, this.aUe, 0);
                    this.mPn++;
                    this.baa.fT(this.mPn);
                    this.bac.bai = false;
                    this.bac.baj = 0;
                }
            }
        }
    }

    public void gQ(String str) {
        Lz();
    }

    public void B(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        Lz();
        if (arrayList != null && arrayList.size() != 0 && (a = this.bac.a(false, arrayList)) != null) {
            this.aUe.af(a);
            this.aZZ.a(a, this.mPn, this.aUe, 0);
        }
    }

    private void Lz() {
        if (this.aUv == 0 && !this.bac.ac(this.aUe.awc())) {
            if (this.aUe.getThreadList() == null || this.aUe.getThreadList().size() == 0) {
                this.aZZ.Ms();
                return;
            } else {
                this.aZZ.Mr();
                return;
            }
        }
        this.aZZ.Mq();
    }

    public void a(x xVar) {
        this.aZZ = xVar;
    }
}
