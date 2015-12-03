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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.et;
import com.baidu.tieba.n;
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
    private boolean aXV;
    private String aXW;
    private com.baidu.adp.lib.f.b<TbImageView> aZv;
    private com.baidu.adp.lib.f.b<TbImageView> afK;
    private ae bgt;
    private af bgu;
    private v bgv;
    private VoiceManager mVoiceManager;
    public boolean aZe = false;
    private String aZi = null;
    private String mFrom = null;
    private int aZj = 0;
    private int mPn = 1;
    private boolean aZk = false;
    private boolean aZl = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aZo = false;
    private boolean aZp = false;
    protected x bgr = null;
    private final com.baidu.tbadk.core.data.z aZr = null;
    private com.baidu.tieba.tbadkCore.p aZs = new com.baidu.tieba.tbadkCore.p();
    private com.baidu.tbadk.core.data.z aZu = null;
    private boolean JB = false;
    public long aQy = -1;
    public long ays = 0;
    public long createTime = 0;
    public long Vp = -1;
    private boolean aZz = false;
    public com.baidu.tbadk.performanceLog.e aZA = null;
    private boolean aZC = true;
    private int aZI = -1;
    private int bgw = 0;
    private Handler bgx = new a(this);
    private et aZL = new m(this);
    private CustomMessageListener aYb = new n(this, CmdConfigCustom.PB_ACTION_PRAISE);
    public final com.baidu.tieba.tbadkCore.s aZP = new o(this);
    private final CustomMessageListener TI = new p(this, CmdConfigCustom.CMD_REFRESH);
    private NoNetworkView.a aUj = new q(this);
    private final bc aZU = new r(this);
    private final q.a aZS = new s(this);
    public final View.OnClickListener aZT = new t(this);
    private final AbsListView.OnScrollListener aYd = new b(this);
    private final View.OnClickListener aZV = new c(this);
    private final View.OnClickListener aZW = new d(this);
    private final CustomMessageListener aZY = new e(this, 0);
    private com.baidu.adp.widget.ListView.v aZZ = new f(this);
    private com.baidu.adp.widget.ListView.w bac = new h(this);

    private void Ou() {
        this.bgu.OL().setVisibility(8);
        this.bgr.OF().setVisibility(8);
        showLoadingView(this.bgr.OE(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ov() {
        this.bgu.OL().setVisibility(0);
        this.bgr.OF().setVisibility(0);
        hideLoadingView(this.bgr.OE());
    }

    private void Ow() {
        this.bgu.OL().setVisibility(0);
        this.bgr.OF().setVisibility(8);
        showLoadingView(this.bgr.OE(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ox() {
        this.bgu.OL().setVisibility(0);
        this.bgr.OF().setVisibility(0);
        hideLoadingView(this.bgr.OE());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar) {
        this.bgu.OL().setVisibility(8);
        this.bgr.OF().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.bgr.OE(), getPageContext().getResources().getString(n.i.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.bgr.OE(), "", true);
        }
    }

    private void Oy() {
        this.bgu.OL().setVisibility(0);
        this.bgr.OF().setVisibility(0);
        hideNetRefreshView(this.bgr.OE());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e.a aVar) {
        this.bgu.OL().setVisibility(0);
        this.bgr.OF().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.bgr.NN(), getPageContext().getResources().getString(n.i.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.bgr.NN(), "", true);
        }
    }

    private void Oz() {
        this.bgu.OL().setVisibility(0);
        this.bgr.OF().setVisibility(0);
        hideNetRefreshView(this.bgr.NN());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(boolean z) {
        stopVoice();
        if (!z) {
            if (this.aZp) {
                Oz();
                Ow();
            } else {
                Oy();
                Ou();
            }
        }
        this.bgt.fL(this.bgw);
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
            this.aQy = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aQy = System.currentTimeMillis();
        }
        if (this.aQy != -1) {
            this.Vp = this.aQy;
        } else {
            this.Vp = System.currentTimeMillis();
        }
        super.onCreate(bundle);
        setContentView(n.g.frs_good_activity);
        this.bgt = new ae(this);
        this.bgu = new af(this);
        this.bgu.oX();
        this.bgr.f(this.aUj);
        if (getIntent() != null) {
            this.bgt.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.bgt.f(bundle);
        } else {
            this.bgt.f(null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        addGlobalLayoutListener();
        registerListener(this.TI);
        registerListener(this.aYb);
        this.bgv = new v(this);
        this.bgv.registerListener();
        this.createTime = System.currentTimeMillis() - this.aQy;
        if (com.baidu.adp.lib.util.i.iP()) {
            cx(false);
        } else {
            a((e.a) null);
        }
    }

    public void MO() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aZs.ajy().getId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        ME();
        if (bundle != null) {
            this.aZi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aZj = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aZi = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aZj = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
    }

    private void ME() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.aZY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bgr != null) {
            this.bgr.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aZA != null) {
                this.aZA.onDestroy();
            }
            this.bgr.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bgt.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aZi);
        bundle.putString("from", this.mFrom);
        this.bgt.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.z mo;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11011:
                    b(this.aZr);
                    return;
                case 11012:
                    c(this.aZu);
                    return;
                case 11016:
                    this.bgr.NF();
                    return;
                case 18003:
                    this.bgr.OD().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (mo = this.aZs.mo(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            mo.bK(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            mo.parser_title();
                            cx(false);
                            return;
                        } else if (intExtra == 0) {
                            this.aZs.g(mo);
                            ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aZs.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new ct());
                            }
                            this.bgr.OC();
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
        this.aXV = true;
        this.aZC = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bgr.nD();
            return;
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aZi = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aZl = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aZl) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    MG();
                } else {
                    MH();
                }
            }
        }
    }

    private void MG() {
        this.bgr.nD();
    }

    private void MH() {
        this.bgr.nD();
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
        this.bgr.OD().h(this.aZV);
        this.bgr.OD().i(this.aZW);
        if (this.aZj != 0) {
            this.aZj = 1;
        }
        this.bgr.a(this.aZZ);
        this.bgr.a(this.bac);
        this.bgr.setOnScrollListener(this.aYd);
        this.bgr.a(this.aZS);
        this.bgr.OD().a(this.aZU);
        this.bgu.a(this.aZL);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bgr.onChangeSkinType(i);
        this.bgu.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> Mo() {
        if (this.aZv == null) {
            this.aZv = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aZv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.z zVar) {
        boolean tf = zVar == null ? true : zVar.tf();
        this.bgr.c(new i(this, zVar));
        this.bgr.a(zVar, tf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.z zVar) {
        boolean tf = zVar == null ? true : zVar.tf();
        if (this.mThreadId != null) {
            if (!tf) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.aZi, null, 18003, true, true, this.aZo)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.aZi, null, 18003, false, false, this.aZo)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.z zVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.aZi, null, 18003, false, false, this.aZo)));
        }
    }

    private void ML() {
        switch (this.aZj) {
            case 1:
                com.baidu.adp.lib.h.k.hk().c(new j(this));
                break;
        }
        this.aZj = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MM() {
        stopVoice();
        try {
            if (this.aZs != null) {
                this.bgr.NC();
                this.aZi = this.aZs.ajy().getName();
                this.forumId = this.aZs.ajy().getId();
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aZs.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aZs.getUserData().getBimg_end_time());
                ML();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aZs.getThreadList();
                if (threadList != null) {
                    this.bgr.a(threadList, this.mPn, this.aZs, this.aZs.getPage().sf());
                    MR();
                    this.bgr.OC();
                    if (this.aZs.ajE() == 1) {
                        this.bgr.OD().setFromCDN(true);
                    } else {
                        this.bgr.OD().setFromCDN(false);
                    }
                    this.bgr.go(Z(OA().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int Z(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aXV = false;
        this.aZC = false;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.aZs != null && this.aZs.ajy() != null) {
            com.baidu.tbadk.distribute.a.Bf().a(getPageContext().getPageActivity(), "frs", this.aZs.ajy().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aZk) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i) {
        String trim;
        if (bVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            if (bVar.rD()) {
                bf.vD().b(getPageContext(), new String[]{bVar.Up});
            } else if (bVar.rC()) {
                if (com.baidu.adp.lib.util.i.iP() && !com.baidu.adp.lib.util.i.iQ()) {
                    trim = getPageContext().getString(n.i.frs_network_tips);
                } else if (TextUtils.isEmpty(bVar.UA.UG.trim())) {
                    trim = getPageContext().getString(n.i.confirm_download_app);
                } else {
                    trim = bVar.UA.UG.trim();
                }
                aVar.cC(trim);
                aVar.a(n.i.alert_yes_button, new k(this, bVar, i));
                aVar.b(n.i.alert_no_button, new l(this));
                aVar.b(getPageContext()).tv();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar != null) {
            if (!bVar.rB()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), n.i.pb_app_error);
            } else if (com.baidu.adp.lib.util.i.iP()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", bVar.Ur);
                com.baidu.tbadk.download.b.Bm().a(bVar.Ur, bVar.Uq, bVar.Un, i, com.baidu.adp.lib.h.b.g(bVar.Um, 0));
            } else {
                showToast(n.i.neterror);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Bf().a(getPageContext().getPageActivity(), bVar, str, "frs", this.aZs.ajy().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Bf().a(bVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fU(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aZs.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.z) {
                    com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) next;
                    if (zVar.getId() != null && zVar.getId().equals(this.aXW)) {
                        b(zVar, i);
                        this.aXW = null;
                        break;
                    }
                }
            }
            this.bgr.OD().a(threadList, this.aZs);
            this.bgr.OD().notifyDataSetChanged();
        }
    }

    private void b(com.baidu.tbadk.core.data.z zVar, int i) {
        if (i == 1) {
            PraiseData praise = zVar.getPraise();
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
                    zVar.setPraise(praiseData);
                    return;
                }
                zVar.getPraise().getUser().add(0, metaData);
                zVar.getPraise().setNum(zVar.getPraise().getNum() + 1);
                zVar.getPraise().setIsLike(i);
            }
        } else if (zVar.getPraise() != null) {
            zVar.getPraise().setIsLike(i);
            zVar.getPraise().setNum(zVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = zVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        zVar.getPraise().getUser().remove(next);
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
        if (this.bgr == null) {
            return null;
        }
        return this.bgr.getListView();
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
    public int wk() {
        if (this.bgr == null) {
            return 0;
        }
        return this.bgr.NJ();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wl() {
        if (this.afK == null) {
            this.afK = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.afK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        cb OD;
        HashMap<Integer, com.baidu.tbadk.core.data.z> Ne;
        if (this.aZs != null && this.bgr != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (OD = this.bgr.OD()) != null && (Ne = OD.Ne()) != null && Ne.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.z> entry : Ne.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.z value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && TextUtils.equals(((com.baidu.tbadk.core.data.b) value).Ur, downloadData.getId())) {
                            int aCe = this.aZs.aCe();
                            if (OD.aB(intValue + aCe) instanceof com.baidu.tbadk.core.data.b) {
                                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) OD.aB(aCe + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    bVar.Ul = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!ax.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    bVar.Ul = 0;
                                } else if (status == 1) {
                                    bVar.Ul = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.bgr.ND();
        }
    }

    private void MR() {
        HashMap<Integer, com.baidu.tbadk.core.data.z> Ne;
        if (this.bgr != null && this.bgr.OD() != null && (Ne = this.bgr.OD().Ne()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.z> entry : Ne.entrySet()) {
                com.baidu.tbadk.core.data.z value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            com.baidu.tbadk.download.b.Bm().p(arrayList);
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
            int i2 = bVar.Ul;
            if (i2 == 0) {
                a(bVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), bVar.Ur);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", bVar.Ur);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            a(bVar, "btn_click");
            b(bVar, "click");
            bf.vD().b(getPageContext(), new String[]{bVar.Up});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.i.iP()) {
            cx(false);
        }
    }

    public ae OA() {
        return this.bgt;
    }

    public void hg(String str) {
        this.aZi = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFlag(int i) {
        this.aZj = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jg()) {
            this.bgr.NT();
        } else if (!this.bgt.OJ()) {
            this.bgr.NT();
        } else {
            MY();
            if (!this.bgv.awu && !this.bgt.isLoading()) {
                if (this.bgv.ai(this.aZs.aBH())) {
                    this.bgr.a(this.bgv.OB(), this.mPn, this.aZs, 0);
                    this.bgv.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.aZs.aBH(), this.aZi, this.mPn);
                } else if (this.aZI != 0) {
                    this.bgr.a(this.bgv.OB(), this.mPn, this.aZs, 0);
                    this.mPn++;
                    this.bgt.gp(this.mPn);
                    this.bgv.bgB = false;
                    this.bgv.bgC = 0;
                }
            }
        }
    }

    public void hh(String str) {
        MY();
    }

    public void E(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        MY();
        if (arrayList != null && arrayList.size() != 0 && (a = this.bgv.a(false, arrayList)) != null) {
            this.aZs.am(a);
            this.bgr.a(a, this.mPn, this.aZs, 0);
        }
    }

    private void MY() {
        if (this.aZI == 0 && !this.bgv.ai(this.aZs.aBH())) {
            if (this.aZs.getThreadList() == null || this.aZs.getThreadList().size() == 0) {
                this.bgr.NT();
                return;
            } else {
                this.bgr.NS();
                return;
            }
        }
        this.bgr.NR();
    }

    public void a(x xVar) {
        this.bgr = xVar;
    }
}
