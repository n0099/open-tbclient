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
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class FrsGoodActivity extends BaseActivity<FrsGoodActivity> implements BdListView.e, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c {
    private static boolean isNeedRefreshOnResume = false;
    private boolean aTe;
    private String aTf;
    private com.baidu.adp.lib.e.b<TbImageView> aUB;
    private ae aZk;
    private af aZl;
    private v aZm;
    private com.baidu.adp.lib.e.b<TbImageView> afk;
    private VoiceManager mVoiceManager;
    public boolean aUn = false;
    private String aUq = null;
    private String mFrom = null;
    private int aUr = 0;
    private int mPn = 1;
    private boolean aUs = false;
    private boolean aUt = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aUu = false;
    private boolean aUv = false;
    protected x aZj = null;
    private final com.baidu.tbadk.core.data.v aUx = null;
    private com.baidu.tieba.tbadkCore.n aUy = new com.baidu.tieba.tbadkCore.n();
    private com.baidu.tbadk.core.data.v aUA = null;
    private boolean Ji = false;
    public long aMq = -1;
    public long axq = 0;
    public long createTime = 0;
    public long aUC = -1;
    private boolean aUG = false;
    public com.baidu.tbadk.performanceLog.e aUH = null;
    private boolean aUJ = true;
    private int aUP = -1;
    private int aZn = 0;
    private Handler aZo = new a(this);
    private db aUS = new m(this);
    private CustomMessageListener aTk = new n(this, CmdConfigCustom.PB_ACTION_PRAISE);
    public final com.baidu.tieba.tbadkCore.q aUV = new o(this);
    private final CustomMessageListener TE = new p(this, CmdConfigCustom.CMD_REFRESH);
    private NoNetworkView.a aPE = new q(this);
    private final au aUZ = new r(this);
    private final x.a aUX = new s(this);
    public final View.OnClickListener aUY = new t(this);
    private final AbsListView.OnScrollListener aTm = new b(this);
    private final View.OnClickListener aVa = new c(this);
    private final View.OnClickListener aVb = new d(this);
    private final CustomMessageListener aVd = new e(this, 0);
    private com.baidu.adp.widget.ListView.v aVe = new f(this);
    private com.baidu.adp.widget.ListView.w aVh = new h(this);

    private void MG() {
        this.aZl.MW().setVisibility(8);
        this.aZj.MQ().setVisibility(8);
        showLoadingView(this.aZj.MP(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MH() {
        this.aZl.MW().setVisibility(0);
        this.aZj.MQ().setVisibility(0);
        hideLoadingView(this.aZj.MP());
    }

    private void MI() {
        this.aZl.MW().setVisibility(0);
        this.aZj.MQ().setVisibility(8);
        showLoadingView(this.aZj.MP(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MJ() {
        this.aZl.MW().setVisibility(0);
        this.aZj.MQ().setVisibility(0);
        hideLoadingView(this.aZj.MP());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        this.aZl.MW().setVisibility(8);
        this.aZj.MQ().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.aZj.MP(), getPageContext().getResources().getString(i.C0057i.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.aZj.MP(), "", true);
        }
    }

    private void MK() {
        this.aZl.MW().setVisibility(0);
        this.aZj.MQ().setVisibility(0);
        hideNetRefreshView(this.aZj.MP());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.a aVar) {
        this.aZl.MW().setVisibility(0);
        this.aZj.MQ().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.aZj.Mk(), getPageContext().getResources().getString(i.C0057i.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.aZj.Mk(), "", true);
        }
    }

    private void ML() {
        this.aZl.MW().setVisibility(0);
        this.aZj.MQ().setVisibility(0);
        hideNetRefreshView(this.aZj.Mk());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(boolean z) {
        stopVoice();
        if (!z) {
            if (this.aUv) {
                ML();
                MI();
            } else {
                MK();
                MG();
            }
        }
        this.aZk.eX(this.aZn);
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
            this.aMq = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aMq = System.currentTimeMillis();
        }
        if (this.aMq != -1) {
            this.aUC = this.aMq;
        } else {
            this.aUC = System.currentTimeMillis();
        }
        super.onCreate(bundle);
        setContentView(i.g.frs_good_activity);
        this.aZk = new ae(this);
        this.aZl = new af(this);
        this.aZl.oS();
        this.aZj.g(this.aPE);
        if (getIntent() != null) {
            this.aZk.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aZk.f(bundle);
        } else {
            this.aZk.f(null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        addGlobalLayoutListener();
        registerListener(this.TE);
        registerListener(this.aTk);
        this.aZm = new v(this);
        this.aZm.registerListener();
        this.createTime = System.currentTimeMillis() - this.aMq;
        if (com.baidu.adp.lib.util.i.iO()) {
            cg(false);
        } else {
            a((d.a) null);
        }
    }

    public void Lr() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aUy.acG().getId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        Lk();
        if (bundle != null) {
            this.aUq = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aUr = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aUq = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aUr = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
    }

    private void Lk() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.aVd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.aZj != null) {
            this.aZj.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aUH != null) {
                this.aUH.onDestroy();
            }
            this.aZj.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aZk.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aUq);
        bundle.putString("from", this.mFrom);
        this.aZk.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.v ko;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11011:
                    b(this.aUx);
                    return;
                case 11012:
                    c(this.aUA);
                    return;
                case 11016:
                    this.aZj.Mc();
                    return;
                case 18003:
                    this.aZj.MO().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (ko = this.aUy.ko(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            ko.bA(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            ko.parser_title();
                            cg(false);
                            return;
                        } else if (intExtra == 0) {
                            this.aUy.f(ko);
                            this.aZj.Md();
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
        this.aTe = true;
        this.aUJ = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aZj.ny();
            return;
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aUq = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aUt = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aUt) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    Lm();
                } else {
                    Ln();
                }
            }
        }
    }

    private void Lm() {
        this.aZj.ny();
    }

    private void Ln() {
        this.aZj.ny();
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
        this.aZj.MO().h(this.aVa);
        this.aZj.MO().i(this.aVb);
        if (this.aUr != 0) {
            this.aUr = 1;
        }
        this.aZj.a(this.aVe);
        this.aZj.a(this.aVh);
        this.aZj.setOnScrollListener(this.aTm);
        this.aZj.a(this.aUX);
        this.aZj.MO().a(this.aUZ);
        this.aZl.a(this.aUS);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aZj.onChangeSkinType(i);
        this.aZl.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> KU() {
        if (this.aUB == null) {
            this.aUB = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aUB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.v vVar) {
        boolean sD = vVar == null ? true : vVar.sD();
        this.aZj.a(new i(this, vVar));
        this.aZj.a(vVar, sD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.v vVar) {
        boolean sD = vVar == null ? true : vVar.sD();
        if (this.mThreadId != null) {
            if (!sD) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aUq, null, 18003, true, true, this.aUu)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aUq, null, 18003, false, false, this.aUu)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.v vVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aUq, null, 18003, false, false, this.aUu)));
        }
    }

    private void Lo() {
        switch (this.aUr) {
            case 1:
                com.baidu.adp.lib.g.k.hj().c(new j(this));
                break;
        }
        this.aUr = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lp() {
        stopVoice();
        try {
            if (this.aUy != null) {
                this.aZj.LZ();
                this.aUq = this.aUy.acG().getName();
                this.forumId = this.aUy.acG().getId();
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aUy.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aUy.getUserData().getBimg_end_time());
                Lo();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUy.getThreadList();
                if (threadList != null) {
                    this.aZj.a(threadList, this.mPn, this.aUy, this.aUy.getPage().rT());
                    Ls();
                    this.aZj.Md();
                    if (this.aUy.acL() == 1) {
                        this.aZj.MO().setFromCDN(true);
                    } else {
                        this.aZj.MO().setFromCDN(false);
                    }
                    this.aZj.fp(V(MM().getType(), this.mPn));
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
        this.aTe = false;
        this.aUJ = false;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.aUy != null && this.aUy.acG() != null) {
            com.baidu.tbadk.distribute.a.Ai().a(getPageContext().getPageActivity(), "frs", this.aUy.acG().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aUs) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.c cVar, int i) {
        String trim;
        if (cVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            if (cVar.rx()) {
                ax.uR().b(getPageContext(), new String[]{cVar.Uk});
            } else if (cVar.rw()) {
                if (com.baidu.adp.lib.util.i.iO() && !com.baidu.adp.lib.util.i.iP()) {
                    trim = getPageContext().getString(i.C0057i.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.Uv.UA.trim())) {
                    trim = getPageContext().getString(i.C0057i.confirm_download_app);
                } else {
                    trim = cVar.Uv.UA.trim();
                }
                aVar.cn(trim);
                aVar.a(i.C0057i.alert_yes_button, new k(this, cVar, i));
                aVar.b(i.C0057i.alert_no_button, new l(this));
                aVar.b(getPageContext()).sP();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.rv()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), i.C0057i.pb_app_error);
            } else if (com.baidu.adp.lib.util.i.iO()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Um);
                com.baidu.tbadk.download.b.Ap().a(cVar.Um, cVar.Ul, cVar.Ui, i, com.baidu.adp.lib.g.b.g(cVar.Uh, 0));
            } else {
                showToast(i.C0057i.neterror);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Ai().a(getPageContext().getPageActivity(), cVar, str, "frs", this.aUy.acG().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Ai().a(cVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUy.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.v) {
                    com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) next;
                    if (vVar.getId() != null && vVar.getId().equals(this.aTf)) {
                        a(vVar, i);
                        this.aTf = null;
                        break;
                    }
                }
            }
            this.aZj.MO().a(threadList, this.aUy);
            this.aZj.MO().notifyDataSetChanged();
        }
    }

    private void a(com.baidu.tbadk.core.data.v vVar, int i) {
        if (i == 1) {
            PraiseData praise = vVar.getPraise();
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
                    vVar.setPraise(praiseData);
                    return;
                }
                vVar.getPraise().getUser().add(0, metaData);
                vVar.getPraise().setNum(vVar.getPraise().getNum() + 1);
                vVar.getPraise().setIsLike(i);
            }
        } else if (vVar.getPraise() != null) {
            vVar.getPraise().setIsLike(i);
            vVar.getPraise().setNum(vVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = vVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        vVar.getPraise().getUser().remove(next);
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
        if (this.aZj == null) {
            return null;
        }
        return this.aZj.getListView();
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
    public int vG() {
        if (this.aZj == null) {
            return 0;
        }
        return this.aZj.Mg();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vH() {
        if (this.afk == null) {
            this.afk = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.afk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bf MO;
        HashMap<Integer, com.baidu.tbadk.core.data.v> LF;
        if (this.aUy != null && this.aZj != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (MO = this.aZj.MO()) != null && (LF = MO.LF()) != null && LF.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.v> entry : LF.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.v value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Um, downloadData.getId())) {
                            int apj = this.aUy.apj();
                            if (MO.aA(intValue + apj) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) MO.aA(apj + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    cVar.Ug = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!aq.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    cVar.Ug = 0;
                                } else if (status == 1) {
                                    cVar.Ug = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aZj.Ma();
        }
    }

    private void Ls() {
        HashMap<Integer, com.baidu.tbadk.core.data.v> LF;
        if (this.aZj != null && this.aZj.MO() != null && (LF = this.aZj.MO().LF()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.v> entry : LF.entrySet()) {
                com.baidu.tbadk.core.data.v value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.Ap().p(arrayList);
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
            int i2 = cVar.Ug;
            if (i2 == 0) {
                a(cVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.I(getPageContext().getPageActivity(), cVar.Um);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Um);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            a(cVar, "btn_click");
            b(cVar, "click");
            ax.uR().b(getPageContext(), new String[]{cVar.Uk});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.i.iO()) {
            cg(false);
        }
    }

    public ae MM() {
        return this.aZk;
    }

    public void gD(String str) {
        this.aUq = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFlag(int i) {
        this.aUr = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jf()) {
            this.aZj.Mq();
        } else if (!this.aZk.MU()) {
            this.aZj.Mq();
        } else {
            LA();
            if (!this.aZm.avu && !this.aZk.isLoading()) {
                if (this.aZm.Y(this.aUy.aoW())) {
                    this.aZj.a(this.aZm.MN(), this.mPn, this.aUy, 0);
                    this.aZm.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.aUy.aoW());
                } else if (this.aUP != 0) {
                    this.aZj.a(this.aZm.MN(), this.mPn, this.aUy, 0);
                    this.mPn++;
                    this.aZk.fw(this.mPn);
                    this.aZm.aZs = false;
                    this.aZm.aZt = 0;
                }
            }
        }
    }

    public void gE(String str) {
        LA();
    }

    public void C(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        LA();
        if (arrayList != null && arrayList.size() != 0 && (a = this.aZm.a(false, arrayList)) != null) {
            this.aUy.X(a);
            this.aZj.a(a, this.mPn, this.aUy, 0);
        }
    }

    private void LA() {
        if (this.aUP == 0 && !this.aZm.Y(this.aUy.aoW())) {
            if (this.aUy.getThreadList() == null || this.aUy.getThreadList().size() == 0) {
                this.aZj.Mq();
                return;
            } else {
                this.aZj.Mp();
                return;
            }
        }
        this.aZj.Mo();
    }

    public void a(x xVar) {
        this.aZj = xVar;
    }
}
