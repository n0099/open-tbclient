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
import com.baidu.tieba.frs.ea;
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
    private String aSA;
    private boolean aSz;
    private com.baidu.adp.lib.e.b<TbImageView> aTZ;
    private ae aZH;
    private af aZI;
    private v aZJ;
    private com.baidu.adp.lib.e.b<TbImageView> aeI;
    private VoiceManager mVoiceManager;
    public boolean aTI = false;
    private String aTM = null;
    private String mFrom = null;
    private int aTN = 0;
    private int mPn = 1;
    private boolean aTO = false;
    private boolean aTP = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aTS = false;
    private boolean aTT = false;
    protected x aZG = null;
    private final com.baidu.tbadk.core.data.w aTV = null;
    private com.baidu.tieba.tbadkCore.o aTW = new com.baidu.tieba.tbadkCore.o();
    private com.baidu.tbadk.core.data.w aTY = null;
    private boolean Jj = false;
    public long aLJ = -1;
    public long axy = 0;
    public long createTime = 0;
    public long aUa = -1;
    private boolean aUe = false;
    public com.baidu.tbadk.performanceLog.e aUf = null;
    private boolean aUh = true;
    private int aUn = -1;
    private int aZK = 0;
    private Handler aZL = new a(this);
    private ea aUq = new m(this);
    private CustomMessageListener aSF = new n(this, CmdConfigCustom.PB_ACTION_PRAISE);
    public final com.baidu.tieba.tbadkCore.r aUu = new o(this);
    private final CustomMessageListener Ts = new p(this, CmdConfigCustom.CMD_REFRESH);
    private NoNetworkView.a aOY = new q(this);
    private final bd aUy = new r(this);
    private final p.a aUw = new s(this);
    public final View.OnClickListener aUx = new t(this);
    private final AbsListView.OnScrollListener aSH = new b(this);
    private final View.OnClickListener aUz = new c(this);
    private final View.OnClickListener aUA = new d(this);
    private final CustomMessageListener aUC = new e(this, 0);
    private com.baidu.adp.widget.ListView.v aUD = new f(this);
    private com.baidu.adp.widget.ListView.w aUG = new h(this);

    private void MF() {
        this.aZI.MV().setVisibility(8);
        this.aZG.MP().setVisibility(8);
        showLoadingView(this.aZG.MO(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MG() {
        this.aZI.MV().setVisibility(0);
        this.aZG.MP().setVisibility(0);
        hideLoadingView(this.aZG.MO());
    }

    private void MH() {
        this.aZI.MV().setVisibility(0);
        this.aZG.MP().setVisibility(8);
        showLoadingView(this.aZG.MO(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MI() {
        this.aZI.MV().setVisibility(0);
        this.aZG.MP().setVisibility(0);
        hideLoadingView(this.aZG.MO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar) {
        this.aZI.MV().setVisibility(8);
        this.aZG.MP().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.aZG.MO(), getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.aZG.MO(), "", true);
        }
    }

    private void MJ() {
        this.aZI.MV().setVisibility(0);
        this.aZG.MP().setVisibility(0);
        hideNetRefreshView(this.aZG.MO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e.a aVar) {
        this.aZI.MV().setVisibility(0);
        this.aZG.MP().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.aZG.Ma(), getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.aZG.Ma(), "", true);
        }
    }

    private void MK() {
        this.aZI.MV().setVisibility(0);
        this.aZG.MP().setVisibility(0);
        hideNetRefreshView(this.aZG.Ma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(boolean z) {
        stopVoice();
        if (!z) {
            if (this.aTT) {
                MK();
                MH();
            } else {
                MJ();
                MF();
            }
        }
        this.aZH.fj(this.aZK);
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
            this.aLJ = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aLJ = System.currentTimeMillis();
        }
        if (this.aLJ != -1) {
            this.aUa = this.aLJ;
        } else {
            this.aUa = System.currentTimeMillis();
        }
        super.onCreate(bundle);
        setContentView(i.g.frs_good_activity);
        this.aZH = new ae(this);
        this.aZI = new af(this);
        this.aZI.oQ();
        this.aZG.g(this.aOY);
        if (getIntent() != null) {
            this.aZH.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aZH.f(bundle);
        } else {
            this.aZH.f(null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        addGlobalLayoutListener();
        registerListener(this.Ts);
        registerListener(this.aSF);
        this.aZJ = new v(this);
        this.aZJ.registerListener();
        this.createTime = System.currentTimeMillis() - this.aLJ;
        if (com.baidu.adp.lib.util.i.iM()) {
            ci(false);
        } else {
            a((e.a) null);
        }
    }

    public void Lc() {
        com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aTW.aeN().getId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        KS();
        if (bundle != null) {
            this.aTM = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aTN = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aTM = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aTN = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
    }

    private void KS() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.aUC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.aZG != null) {
            this.aZG.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aUf != null) {
                this.aUf.onDestroy();
            }
            this.aZG.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aZH.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aTM);
        bundle.putString("from", this.mFrom);
        this.aZH.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.w lu;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11011:
                    b(this.aTV);
                    return;
                case 11012:
                    c(this.aTY);
                    return;
                case 11016:
                    this.aZG.LS();
                    return;
                case 18003:
                    this.aZG.MN().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (lu = this.aTW.lu(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            lu.bB(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            lu.parser_title();
                            ci(false);
                            return;
                        } else if (intExtra == 0) {
                            this.aTW.g(lu);
                            ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aTW.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new cd());
                            }
                            this.aZG.LT();
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
        this.aSz = true;
        this.aUh = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aZG.nw();
            return;
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aTM = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aTP = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aTP) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    KU();
                } else {
                    KV();
                }
            }
        }
    }

    private void KU() {
        this.aZG.nw();
    }

    private void KV() {
        this.aZG.nw();
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
        this.aZG.MN().h(this.aUz);
        this.aZG.MN().i(this.aUA);
        if (this.aTN != 0) {
            this.aTN = 1;
        }
        this.aZG.a(this.aUD);
        this.aZG.a(this.aUG);
        this.aZG.setOnScrollListener(this.aSH);
        this.aZG.a(this.aUw);
        this.aZG.MN().a(this.aUy);
        this.aZI.a(this.aUq);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aZG.onChangeSkinType(i);
        this.aZI.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> KD() {
        if (this.aTZ == null) {
            this.aTZ = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aTZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.w wVar) {
        boolean sE = wVar == null ? true : wVar.sE();
        this.aZG.c(new i(this, wVar));
        this.aZG.a(wVar, sE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.w wVar) {
        boolean sE = wVar == null ? true : wVar.sE();
        if (this.mThreadId != null) {
            if (!sE) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aTM, null, 18003, true, true, this.aTS)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aTM, null, 18003, false, false, this.aTS)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.w wVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aTM, null, 18003, false, false, this.aTS)));
        }
    }

    private void KZ() {
        switch (this.aTN) {
            case 1:
                com.baidu.adp.lib.g.k.hh().c(new j(this));
                break;
        }
        this.aTN = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void La() {
        stopVoice();
        try {
            if (this.aTW != null) {
                this.aZG.LP();
                this.aTM = this.aTW.aeN().getName();
                this.forumId = this.aTW.aeN().getId();
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aTW.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aTW.getUserData().getBimg_end_time());
                KZ();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aTW.getThreadList();
                if (threadList != null) {
                    this.aZG.a(threadList, this.mPn, this.aTW, this.aTW.getPage().rL());
                    Lf();
                    this.aZG.LT();
                    if (this.aTW.aeT() == 1) {
                        this.aZG.MN().setFromCDN(true);
                    } else {
                        this.aZG.MN().setFromCDN(false);
                    }
                    this.aZG.fz(V(ML().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int V(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aSz = false;
        this.aUh = false;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.aTW != null && this.aTW.aeN() != null) {
            com.baidu.tbadk.distribute.a.Ag().a(getPageContext().getPageActivity(), "frs", this.aTW.aeN().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aTO) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i) {
        String trim;
        if (bVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            if (bVar.rr()) {
                az.uW().b(getPageContext(), new String[]{bVar.TY});
            } else if (bVar.rq()) {
                if (com.baidu.adp.lib.util.i.iM() && !com.baidu.adp.lib.util.i.iN()) {
                    trim = getPageContext().getString(i.h.frs_network_tips);
                } else if (TextUtils.isEmpty(bVar.Uj.Up.trim())) {
                    trim = getPageContext().getString(i.h.confirm_download_app);
                } else {
                    trim = bVar.Uj.Up.trim();
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
            if (!bVar.rp()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), i.h.pb_app_error);
            } else if (com.baidu.adp.lib.util.i.iM()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", bVar.Ua);
                com.baidu.tbadk.download.b.An().a(bVar.Ua, bVar.TZ, bVar.TW, i, com.baidu.adp.lib.g.b.g(bVar.TV, 0));
            } else {
                showToast(i.h.neterror);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Ag().a(getPageContext().getPageActivity(), bVar, str, "frs", this.aTW.aeN().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Ag().a(bVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aTW.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.w) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) next;
                    if (wVar.getId() != null && wVar.getId().equals(this.aSA)) {
                        b(wVar, i);
                        this.aSA = null;
                        break;
                    }
                }
            }
            this.aZG.MN().a(threadList, this.aTW);
            this.aZG.MN().notifyDataSetChanged();
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
        if (this.aZG == null) {
            return null;
        }
        return this.aZG.getListView();
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
    public int vD() {
        if (this.aZG == null) {
            return 0;
        }
        return this.aZG.LW();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vE() {
        if (this.aeI == null) {
            this.aeI = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aeI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bq MN;
        HashMap<Integer, com.baidu.tbadk.core.data.w> Lu;
        if (this.aTW != null && this.aZG != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (MN = this.aZG.MN()) != null && (Lu = MN.Lu()) != null && Lu.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : Lu.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.w value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && TextUtils.equals(((com.baidu.tbadk.core.data.b) value).Ua, downloadData.getId())) {
                            int avS = this.aTW.avS();
                            if (MN.aA(intValue + avS) instanceof com.baidu.tbadk.core.data.b) {
                                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) MN.aA(avS + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    bVar.TU = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!as.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    bVar.TU = 0;
                                } else if (status == 1) {
                                    bVar.TU = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aZG.LQ();
        }
    }

    private void Lf() {
        HashMap<Integer, com.baidu.tbadk.core.data.w> Lu;
        if (this.aZG != null && this.aZG.MN() != null && (Lu = this.aZG.MN().Lu()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : Lu.entrySet()) {
                com.baidu.tbadk.core.data.w value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            com.baidu.tbadk.download.b.An().o(arrayList);
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
            int i2 = bVar.TU;
            if (i2 == 0) {
                a(bVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), bVar.Ua);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", bVar.Ua);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            a(bVar, "btn_click");
            b(bVar, "click");
            az.uW().b(getPageContext(), new String[]{bVar.TY});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.i.iM()) {
            ci(false);
        }
    }

    public ae ML() {
        return this.aZH;
    }

    public void gN(String str) {
        this.aTM = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFlag(int i) {
        this.aTN = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jd()) {
            this.aZG.Mg();
        } else if (!this.aZH.MT()) {
            this.aZG.Mg();
        } else {
            Ln();
            if (!this.aZJ.avC && !this.aZH.isLoading()) {
                if (this.aZJ.Z(this.aTW.avz())) {
                    this.aZG.a(this.aZJ.MM(), this.mPn, this.aTW, 0);
                    this.aZJ.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.aTW.avz());
                } else if (this.aUn != 0) {
                    this.aZG.a(this.aZJ.MM(), this.mPn, this.aTW, 0);
                    this.mPn++;
                    this.aZH.fK(this.mPn);
                    this.aZJ.aZP = false;
                    this.aZJ.aZQ = 0;
                }
            }
        }
    }

    public void gO(String str) {
        Ln();
    }

    public void B(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        Ln();
        if (arrayList != null && arrayList.size() != 0 && (a = this.aZJ.a(false, arrayList)) != null) {
            this.aTW.af(a);
            this.aZG.a(a, this.mPn, this.aTW, 0);
        }
    }

    private void Ln() {
        if (this.aUn == 0 && !this.aZJ.Z(this.aTW.avz())) {
            if (this.aTW.getThreadList() == null || this.aTW.getThreadList().size() == 0) {
                this.aZG.Mg();
                return;
            } else {
                this.aZG.Mf();
                return;
            }
        }
        this.aZG.Me();
    }

    public void a(x xVar) {
        this.aZG = xVar;
    }
}
