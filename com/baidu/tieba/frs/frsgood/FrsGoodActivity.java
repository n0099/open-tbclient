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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.frs.dh;
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
    private boolean aTs;
    private String aTt;
    private com.baidu.adp.lib.e.b<TbImageView> aUQ;
    private ae aZD;
    private af aZE;
    private v aZF;
    private com.baidu.adp.lib.e.b<TbImageView> afu;
    private VoiceManager mVoiceManager;
    public boolean aUB = false;
    private String aUF = null;
    private String mFrom = null;
    private int aUG = 0;
    private int mPn = 1;
    private boolean aUH = false;
    private boolean aUI = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aUJ = false;
    private boolean aUK = false;
    protected x aZC = null;
    private final com.baidu.tbadk.core.data.x aUM = null;
    private com.baidu.tieba.tbadkCore.o aUN = new com.baidu.tieba.tbadkCore.o();
    private com.baidu.tbadk.core.data.x aUP = null;
    private boolean Ji = false;
    public long aMD = -1;
    public long ayY = 0;
    public long createTime = 0;
    public long aUR = -1;
    private boolean aUV = false;
    public com.baidu.tbadk.performanceLog.e aUW = null;
    private boolean aUY = true;
    private int aVe = -1;
    private int aZG = 0;
    private Handler aZH = new a(this);
    private dh aVg = new m(this);
    private CustomMessageListener aTy = new n(this, CmdConfigCustom.PB_ACTION_PRAISE);
    public final com.baidu.tieba.tbadkCore.r aVj = new o(this);
    private final CustomMessageListener TF = new p(this, CmdConfigCustom.CMD_REFRESH);
    private NoNetworkView.a aPS = new q(this);
    private final av aVn = new r(this);
    private final x.a aVl = new s(this);
    public final View.OnClickListener aVm = new t(this);
    private final AbsListView.OnScrollListener aTA = new b(this);
    private final View.OnClickListener aVo = new c(this);
    private final View.OnClickListener aVp = new d(this);
    private final CustomMessageListener aVr = new e(this, 0);
    private com.baidu.adp.widget.ListView.v aVs = new f(this);
    private com.baidu.adp.widget.ListView.w aVv = new h(this);

    private void MG() {
        this.aZE.MW().setVisibility(8);
        this.aZC.MQ().setVisibility(8);
        showLoadingView(this.aZC.MP(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MH() {
        this.aZE.MW().setVisibility(0);
        this.aZC.MQ().setVisibility(0);
        hideLoadingView(this.aZC.MP());
    }

    private void MI() {
        this.aZE.MW().setVisibility(0);
        this.aZC.MQ().setVisibility(8);
        showLoadingView(this.aZC.MP(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MJ() {
        this.aZE.MW().setVisibility(0);
        this.aZC.MQ().setVisibility(0);
        hideLoadingView(this.aZC.MP());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar) {
        this.aZE.MW().setVisibility(8);
        this.aZC.MQ().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.aZC.MP(), getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.aZC.MP(), "", true);
        }
    }

    private void MK() {
        this.aZE.MW().setVisibility(0);
        this.aZC.MQ().setVisibility(0);
        hideNetRefreshView(this.aZC.MP());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e.a aVar) {
        this.aZE.MW().setVisibility(0);
        this.aZC.MQ().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.aZC.Mb(), getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.aZC.Mb(), "", true);
        }
    }

    private void ML() {
        this.aZE.MW().setVisibility(0);
        this.aZC.MQ().setVisibility(0);
        hideNetRefreshView(this.aZC.Mb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(boolean z) {
        stopVoice();
        if (!z) {
            if (this.aUK) {
                ML();
                MI();
            } else {
                MK();
                MG();
            }
        }
        this.aZD.fe(this.aZG);
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
            this.aMD = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aMD = System.currentTimeMillis();
        }
        if (this.aMD != -1) {
            this.aUR = this.aMD;
        } else {
            this.aUR = System.currentTimeMillis();
        }
        super.onCreate(bundle);
        setContentView(i.g.frs_good_activity);
        this.aZD = new ae(this);
        this.aZE = new af(this);
        this.aZE.oP();
        this.aZC.g(this.aPS);
        if (getIntent() != null) {
            this.aZD.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aZD.f(bundle);
        } else {
            this.aZD.f(null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        addGlobalLayoutListener();
        registerListener(this.TF);
        registerListener(this.aTy);
        this.aZF = new v(this);
        this.aZF.registerListener();
        this.createTime = System.currentTimeMillis() - this.aMD;
        if (com.baidu.adp.lib.util.i.iL()) {
            cl(false);
        } else {
            a((e.a) null);
        }
    }

    public void Lg() {
        com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aUN.acP().getId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        KY();
        if (bundle != null) {
            this.aUF = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aUG = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aUF = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aUG = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
    }

    private void KY() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.aVr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.aZC != null) {
            this.aZC.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aUW != null) {
                this.aUW.onDestroy();
            }
            this.aZC.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aZD.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aUF);
        bundle.putString("from", this.mFrom);
        this.aZD.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.x kT;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11011:
                    c(this.aUM);
                    return;
                case 11012:
                    d(this.aUP);
                    return;
                case 11016:
                    this.aZC.LT();
                    return;
                case 18003:
                    this.aZC.MO().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (kT = this.aUN.kT(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            kT.bB(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            kT.parser_title();
                            cl(false);
                            return;
                        } else if (intExtra == 0) {
                            this.aUN.g(kT);
                            ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUN.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new bt());
                            }
                            this.aZC.LU();
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
        this.aTs = true;
        this.aUY = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aZC.nv();
            return;
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aUF = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aUI = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aUI) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    La();
                } else {
                    Lb();
                }
            }
        }
    }

    private void La() {
        this.aZC.nv();
    }

    private void Lb() {
        this.aZC.nv();
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
        this.aZC.MO().h(this.aVo);
        this.aZC.MO().i(this.aVp);
        if (this.aUG != 0) {
            this.aUG = 1;
        }
        this.aZC.a(this.aVs);
        this.aZC.a(this.aVv);
        this.aZC.setOnScrollListener(this.aTA);
        this.aZC.a(this.aVl);
        this.aZC.MO().a(this.aVn);
        this.aZE.a(this.aVg);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aZC.onChangeSkinType(i);
        this.aZE.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> KI() {
        if (this.aUQ == null) {
            this.aUQ = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aUQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.x xVar) {
        boolean sH = xVar == null ? true : xVar.sH();
        this.aZC.b(new i(this, xVar));
        this.aZC.a(xVar, sH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.x xVar) {
        boolean sH = xVar == null ? true : xVar.sH();
        if (this.mThreadId != null) {
            if (!sH) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aUF, null, 18003, true, true, this.aUJ)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aUF, null, 18003, false, false, this.aUJ)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.x xVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aUF, null, 18003, false, false, this.aUJ)));
        }
    }

    private void Ld() {
        switch (this.aUG) {
            case 1:
                com.baidu.adp.lib.g.k.hg().c(new j(this));
                break;
        }
        this.aUG = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Le() {
        stopVoice();
        try {
            if (this.aUN != null) {
                this.aZC.LQ();
                this.aUF = this.aUN.acP().getName();
                this.forumId = this.aUN.acP().getId();
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aUN.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aUN.getUserData().getBimg_end_time());
                Ld();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUN.getThreadList();
                if (threadList != null) {
                    this.aZC.a(threadList, this.mPn, this.aUN, this.aUN.getPage().rQ());
                    Lj();
                    this.aZC.LU();
                    if (this.aUN.acV() == 1) {
                        this.aZC.MO().setFromCDN(true);
                    } else {
                        this.aZC.MO().setFromCDN(false);
                    }
                    this.aZC.fu(V(MM().getType(), this.mPn));
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
        this.aTs = false;
        this.aUY = false;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.aUN != null && this.aUN.acP() != null) {
            com.baidu.tbadk.distribute.a.Av().a(getPageContext().getPageActivity(), "frs", this.aUN.acP().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aUH) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.c cVar, int i) {
        String trim;
        if (cVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            if (cVar.rw()) {
                ax.uX().b(getPageContext(), new String[]{cVar.Ul});
            } else if (cVar.rv()) {
                if (com.baidu.adp.lib.util.i.iL() && !com.baidu.adp.lib.util.i.iM()) {
                    trim = getPageContext().getString(i.h.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.Uw.UB.trim())) {
                    trim = getPageContext().getString(i.h.confirm_download_app);
                } else {
                    trim = cVar.Uw.UB.trim();
                }
                aVar.ct(trim);
                aVar.a(i.h.alert_yes_button, new k(this, cVar, i));
                aVar.b(i.h.alert_no_button, new l(this));
                aVar.b(getPageContext()).sU();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.ru()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), i.h.pb_app_error);
            } else if (com.baidu.adp.lib.util.i.iL()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Un);
                com.baidu.tbadk.download.b.AC().a(cVar.Un, cVar.Um, cVar.Uj, i, com.baidu.adp.lib.g.b.g(cVar.Ui, 0));
            } else {
                showToast(i.h.neterror);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Av().a(getPageContext().getPageActivity(), cVar, str, "frs", this.aUN.acP().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Av().a(cVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fk(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUN.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.x) {
                    com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) next;
                    if (xVar.getId() != null && xVar.getId().equals(this.aTt)) {
                        a(xVar, i);
                        this.aTt = null;
                        break;
                    }
                }
            }
            this.aZC.MO().a(threadList, this.aUN);
            this.aZC.MO().notifyDataSetChanged();
        }
    }

    private void a(com.baidu.tbadk.core.data.x xVar, int i) {
        if (i == 1) {
            PraiseData praise = xVar.getPraise();
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
                    xVar.setPraise(praiseData);
                    return;
                }
                xVar.getPraise().getUser().add(0, metaData);
                xVar.getPraise().setNum(xVar.getPraise().getNum() + 1);
                xVar.getPraise().setIsLike(i);
            }
        } else if (xVar.getPraise() != null) {
            xVar.getPraise().setIsLike(i);
            xVar.getPraise().setNum(xVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = xVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        xVar.getPraise().getUser().remove(next);
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
        if (this.aZC == null) {
            return null;
        }
        return this.aZC.getListView();
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
    public int vL() {
        if (this.aZC == null) {
            return 0;
        }
        return this.aZC.LX();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vM() {
        if (this.afu == null) {
            this.afu = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.afu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bg MO;
        HashMap<Integer, com.baidu.tbadk.core.data.x> Lw;
        if (this.aUN != null && this.aZC != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (MO = this.aZC.MO()) != null && (Lw = MO.Lw()) != null && Lw.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.x> entry : Lw.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.x value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Un, downloadData.getId())) {
                            int atu = this.aUN.atu();
                            if (MO.aA(intValue + atu) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) MO.aA(atu + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    cVar.Uh = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!aq.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    cVar.Uh = 0;
                                } else if (status == 1) {
                                    cVar.Uh = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aZC.LR();
        }
    }

    private void Lj() {
        HashMap<Integer, com.baidu.tbadk.core.data.x> Lw;
        if (this.aZC != null && this.aZC.MO() != null && (Lw = this.aZC.MO().Lw()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.x> entry : Lw.entrySet()) {
                com.baidu.tbadk.core.data.x value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.AC().o(arrayList);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            a(cVar, "area_click");
            b(cVar, "click");
            int i2 = cVar.Uh;
            if (i2 == 0) {
                a(cVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.I(getPageContext().getPageActivity(), cVar.Un);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Un);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            a(cVar, "btn_click");
            b(cVar, "click");
            ax.uX().b(getPageContext(), new String[]{cVar.Ul});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.i.iL()) {
            cl(false);
        }
    }

    public ae MM() {
        return this.aZD;
    }

    public void gK(String str) {
        this.aUF = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFlag(int i) {
        this.aUG = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jc()) {
            this.aZC.Mh();
        } else if (!this.aZD.MU()) {
            this.aZC.Mh();
        } else {
            Lr();
            if (!this.aZF.axc && !this.aZD.isLoading()) {
                if (this.aZF.Y(this.aUN.atd())) {
                    this.aZC.a(this.aZF.MN(), this.mPn, this.aUN, 0);
                    this.aZF.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.aUN.atd());
                } else if (this.aVe != 0) {
                    this.aZC.a(this.aZF.MN(), this.mPn, this.aUN, 0);
                    this.mPn++;
                    this.aZD.fF(this.mPn);
                    this.aZF.aZL = false;
                    this.aZF.aZM = 0;
                }
            }
        }
    }

    public void gL(String str) {
        Lr();
    }

    public void B(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        Lr();
        if (arrayList != null && arrayList.size() != 0 && (a = this.aZF.a(false, arrayList)) != null) {
            this.aUN.ad(a);
            this.aZC.a(a, this.mPn, this.aUN, 0);
        }
    }

    private void Lr() {
        if (this.aVe == 0 && !this.aZF.Y(this.aUN.atd())) {
            if (this.aUN.getThreadList() == null || this.aUN.getThreadList().size() == 0) {
                this.aZC.Mh();
                return;
            } else {
                this.aZC.Mg();
                return;
            }
        }
        this.aZC.Mf();
    }

    public void a(x xVar) {
        this.aZC = xVar;
    }
}
