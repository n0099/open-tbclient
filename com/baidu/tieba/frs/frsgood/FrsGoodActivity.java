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
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cw;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class FrsGoodActivity extends BaseActivity<FrsGoodActivity> implements BdListView.e, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c {
    private static boolean isNeedRefreshOnResume = false;
    private com.baidu.adp.lib.f.b<TbImageView> agI;
    private boolean bbV;
    private String bbW;
    private com.baidu.adp.lib.f.b<TbImageView> bdr;
    private ae bkk;
    private af bkl;
    private v bkm;
    private VoiceManager mVoiceManager;
    public boolean bda = false;
    private String bde = null;
    private String mFrom = null;
    private int bdf = 0;
    private int mPn = 1;
    private boolean bdg = false;
    private boolean bdh = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean bdk = false;
    private boolean bdl = false;
    protected x bkj = null;
    private final com.baidu.tbadk.core.data.z bdn = null;
    private com.baidu.tieba.tbadkCore.p bdo = new com.baidu.tieba.tbadkCore.p();
    private com.baidu.tbadk.core.data.z bdq = null;
    private boolean JR = false;
    public long aUp = -1;
    public long azV = 0;
    public long createTime = 0;
    public long VP = -1;
    private boolean bdv = false;
    public com.baidu.tbadk.performanceLog.e bdw = null;
    private boolean bdy = true;
    private int bdE = -1;
    private int bkn = 0;
    private Handler bko = new a(this);
    private eu bdH = new m(this);
    private CustomMessageListener agG = new n(this, CmdConfigCustom.PB_ACTION_PRAISE);
    public final com.baidu.tieba.tbadkCore.s bdL = new o(this);
    private final CustomMessageListener Uk = new p(this, CmdConfigCustom.CMD_REFRESH);
    private NoNetworkView.a aYl = new q(this);
    private final bf bdR = new r(this);
    private final r.a bdP = new s(this);
    public final View.OnClickListener bdQ = new t(this);
    private final AbsListView.OnScrollListener bcc = new b(this);
    private final View.OnClickListener bdS = new c(this);
    private final View.OnClickListener bdT = new d(this);
    private final CustomMessageListener bdV = new e(this, 0);
    private com.baidu.adp.widget.ListView.v bdW = new f(this);
    private com.baidu.adp.widget.ListView.w bdZ = new h(this);

    private void OM() {
        this.bkl.Pd().setVisibility(8);
        this.bkj.OX().setVisibility(8);
        showLoadingView(this.bkj.OW(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ON() {
        this.bkl.Pd().setVisibility(0);
        this.bkj.OX().setVisibility(0);
        hideLoadingView(this.bkj.OW());
    }

    private void OO() {
        this.bkl.Pd().setVisibility(0);
        this.bkj.OX().setVisibility(8);
        showLoadingView(this.bkj.OW(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OP() {
        this.bkl.Pd().setVisibility(0);
        this.bkj.OX().setVisibility(0);
        hideLoadingView(this.bkj.OW());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar) {
        this.bkl.Pd().setVisibility(8);
        this.bkj.OX().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.bkj.OW(), getPageContext().getResources().getString(n.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.bkj.OW(), "", true);
        }
    }

    private void OQ() {
        this.bkl.Pd().setVisibility(0);
        this.bkj.OX().setVisibility(0);
        hideNetRefreshView(this.bkj.OW());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e.a aVar) {
        this.bkl.Pd().setVisibility(0);
        this.bkj.OX().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.bkj.Og(), getPageContext().getResources().getString(n.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.bkj.Og(), "", true);
        }
    }

    private void OR() {
        this.bkl.Pd().setVisibility(0);
        this.bkj.OX().setVisibility(0);
        hideNetRefreshView(this.bkj.Og());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(boolean z) {
        stopVoice();
        if (!z) {
            if (this.bdl) {
                OR();
                OO();
            } else {
                OQ();
                OM();
            }
        }
        this.bkk.fG(this.bkn);
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
            this.aUp = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aUp = System.currentTimeMillis();
        }
        if (this.aUp != -1) {
            this.VP = this.aUp;
        } else {
            this.VP = System.currentTimeMillis();
        }
        super.onCreate(bundle);
        setContentView(n.h.frs_good_activity);
        this.bkk = new ae(this);
        this.bkl = new af(this);
        this.bkl.ov();
        this.bkj.f(this.aYl);
        if (getIntent() != null) {
            this.bkk.b(getIntent().getExtras());
        } else if (bundle != null) {
            this.bkk.b(bundle);
        } else {
            this.bkk.b(null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        addGlobalLayoutListener();
        registerListener(this.Uk);
        registerListener(this.agG);
        this.bkm = new v(this);
        this.bkm.registerListener();
        this.createTime = System.currentTimeMillis() - this.aUp;
        if (com.baidu.adp.lib.util.i.iQ()) {
            cy(false);
        } else {
            a((e.a) null);
        }
    }

    public void Ni() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.bdo.akG().getId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        MX();
        if (bundle != null) {
            this.bde = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.bdf = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bde = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.bdf = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
    }

    private void MX() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bdV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bkj != null) {
            this.bkj.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bdw != null) {
                this.bdw.onDestroy();
            }
            this.bkj.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bkk.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bde);
        bundle.putString("from", this.mFrom);
        this.bkk.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.z ml;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11011:
                    d(this.bdn);
                    return;
                case 11012:
                    e(this.bdq);
                    return;
                case 11016:
                    this.bkj.NY();
                    return;
                case 18003:
                    this.bkj.OV().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (ml = this.bdo.ml(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            ml.bD(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            ml.parser_title();
                            cy(false);
                            return;
                        } else if (intExtra == 0) {
                            this.bdo.j(ml);
                            ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bdo.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new cw());
                            }
                            this.bkj.OU();
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
        this.bbV = true;
        this.bdy = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bkj.nb();
            return;
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bde = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.bdh = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bdh) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    MZ();
                } else {
                    Na();
                }
            }
        }
    }

    private void MZ() {
        this.bkj.nb();
    }

    private void Na() {
        this.bkj.nb();
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
        this.bkj.OV().h(this.bdS);
        this.bkj.OV().i(this.bdT);
        if (this.bdf != 0) {
            this.bdf = 1;
        }
        this.bkj.a(this.bdW);
        this.bkj.a(this.bdZ);
        this.bkj.setOnScrollListener(this.bcc);
        this.bkj.a(this.bdP);
        this.bkj.OV().a(this.bdR);
        this.bkl.a(this.bdH);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bkj.onChangeSkinType(i);
        this.bkl.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> MH() {
        if (this.bdr == null) {
            this.bdr = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.bdr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.z zVar) {
        boolean sP = zVar == null ? true : zVar.sP();
        this.bkj.c(new i(this, zVar));
        this.bkj.a(zVar, sP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.z zVar) {
        boolean sP = zVar == null ? true : zVar.sP();
        if (this.mThreadId != null) {
            if (!sP) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.bde, null, 18003, true, true, this.bdk)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.bde, null, 18003, false, false, this.bdk)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.z zVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.bde, null, 18003, false, false, this.bdk)));
        }
    }

    private void Nf() {
        switch (this.bdf) {
            case 1:
                com.baidu.adp.lib.h.k.hk().c(new j(this));
                break;
        }
        this.bdf = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ng() {
        stopVoice();
        try {
            if (this.bdo != null) {
                this.bkj.NV();
                this.bde = this.bdo.akG().getName();
                this.forumId = this.bdo.akG().getId();
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.bdo.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.bdo.getUserData().getBimg_end_time());
                Nf();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bdo.getThreadList();
                if (threadList != null) {
                    this.bkj.a(threadList, this.mPn, this.bdo, this.bdo.getPage().rO());
                    Nl();
                    this.bkj.OU();
                    if (this.bdo.akM() == 1) {
                        this.bkj.OV().setFromCDN(true);
                    } else {
                        this.bkj.OV().setFromCDN(false);
                    }
                    this.bkj.gh(Z(OS().getType(), this.mPn));
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
        this.bbV = false;
        this.bdy = false;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bdo != null && this.bdo.akG() != null) {
            com.baidu.tbadk.distribute.a.AV().a(getPageContext().getPageActivity(), "frs", this.bdo.akG().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bdg) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i, boolean z) {
        String trim;
        if (bVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            if (bVar.rm()) {
                com.baidu.tbadk.core.util.bf.vn().a(getPageContext(), new String[]{bVar.UQ}, true);
            } else if (bVar.rl()) {
                if (com.baidu.adp.lib.util.i.iQ() && !com.baidu.adp.lib.util.i.iR()) {
                    trim = getPageContext().getString(n.j.frs_network_tips);
                } else if (TextUtils.isEmpty(bVar.Vb.Vh.trim())) {
                    trim = getPageContext().getString(n.j.confirm_download_app);
                } else {
                    trim = bVar.Vb.Vh.trim();
                }
                aVar.cF(trim);
                aVar.a(n.j.alert_yes_button, new k(this, bVar, z, i));
                aVar.b(n.j.alert_no_button, new l(this));
                aVar.b(getPageContext()).tf();
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar != null) {
            if (!bVar.rk()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), n.j.pb_app_error);
            } else if (ah.a(getPageContext().getPageActivity(), bVar, i)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", bVar.US);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.AV().a(getPageContext().getPageActivity(), bVar, str, "frs", this.bdo.akG().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.AV().a(bVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bdo.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.z) {
                    com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) next;
                    if (zVar.getId() != null && zVar.getId().equals(this.bbW)) {
                        b(zVar, i);
                        this.bbW = null;
                        break;
                    }
                }
            }
            this.bkj.OV().a(threadList, this.bdo);
            this.bkj.OV().notifyDataSetChanged();
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
        if (this.bkj == null) {
            return null;
        }
        return this.bkj.getListView();
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
    public int vU() {
        if (this.bkj == null) {
            return 0;
        }
        return this.bkj.Oc();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vV() {
        if (this.agI == null) {
            this.agI = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.agI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        ce OV;
        HashMap<Integer, com.baidu.tbadk.core.data.z> Nx;
        if (this.bdo != null && this.bkj != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (OV = this.bkj.OV()) != null && (Nx = OV.Nx()) != null && Nx.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.z> entry : Nx.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.z value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && TextUtils.equals(((com.baidu.tbadk.core.data.b) value).US, downloadData.getId())) {
                            int aEm = this.bdo.aEm();
                            if (OV.au(intValue + aEm) instanceof com.baidu.tbadk.core.data.b) {
                                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) OV.au(aEm + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    bVar.UL = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!ax.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    bVar.UL = 0;
                                } else if (status == 1) {
                                    bVar.UL = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.bkj.NW();
        }
    }

    private void Nl() {
        HashMap<Integer, com.baidu.tbadk.core.data.z> Nx;
        if (this.bkj != null && this.bkj.OV() != null && (Nx = this.bkj.OV().Nx()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.z> entry : Nx.entrySet()) {
                com.baidu.tbadk.core.data.z value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            com.baidu.tbadk.download.b.Bb().p(arrayList);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar != null) {
            a(bVar, true, this.mPn);
            int i2 = bVar.UL;
            if (i2 == 0) {
                a(bVar, i, true);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), bVar.US);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", bVar.US);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            a(bVar, true, this.mPn);
            com.baidu.tbadk.core.util.bf.vn().a(getPageContext(), new String[]{bVar.UQ}, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.i.iQ()) {
            cy(false);
        }
    }

    public ae OS() {
        return this.bkk;
    }

    public void hr(String str) {
        this.bde = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFlag(int i) {
        this.bdf = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jh()) {
            this.bkj.Om();
        } else if (!this.bkk.Pb()) {
            this.bkj.Om();
        } else {
            Ns();
            if (!this.bkm.axY && !this.bkk.isLoading()) {
                if (this.bkm.ai(this.bdo.aDP())) {
                    this.bkj.a(this.bkm.OT(), this.mPn, this.bdo, 0);
                    this.bkm.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.bdo.aDP(), this.bde, this.mPn);
                } else if (this.bdE != 0) {
                    this.bkj.a(this.bkm.OT(), this.mPn, this.bdo, 0);
                    this.mPn++;
                    this.bkk.gi(this.mPn);
                    this.bkm.bks = false;
                    this.bkm.bkt = 0;
                }
            }
        }
    }

    public void hs(String str) {
        Ns();
    }

    public void C(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        Ns();
        if (arrayList != null && arrayList.size() != 0 && (a = this.bkm.a(false, arrayList)) != null) {
            this.bdo.am(a);
            this.bkj.a(a, this.mPn, this.bdo, 0);
        }
    }

    private void Ns() {
        if (this.bdE == 0 && !this.bkm.ai(this.bdo.aDP())) {
            if (this.bdo.getThreadList() == null || this.bdo.getThreadList().size() == 0) {
                this.bkj.Om();
                return;
            } else {
                this.bkj.Ol();
                return;
            }
        }
        this.bkj.Ok();
    }

    public void a(x xVar) {
        this.bkj = xVar;
    }

    private void a(com.baidu.tbadk.core.data.b bVar, boolean z, int i) {
        a(bVar, z ? "area_click" : "btn_click");
        b(bVar, "click");
        com.baidu.tieba.recapp.report.b.axN().a(com.baidu.tieba.recapp.report.e.a(bVar, "click", i));
    }
}
