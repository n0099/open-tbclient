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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ay;
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
    private boolean aSo;
    private String aSp;
    private com.baidu.adp.lib.e.b<TbImageView> aTO;
    private ae aZw;
    private af aZx;
    private v aZy;
    private com.baidu.adp.lib.e.b<TbImageView> aeH;
    private VoiceManager mVoiceManager;
    public boolean aTx = false;
    private String aTB = null;
    private String mFrom = null;
    private int aTC = 0;
    private int mPn = 1;
    private boolean aTD = false;
    private boolean aTE = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aTH = false;
    private boolean aTI = false;
    protected x aZv = null;
    private final com.baidu.tbadk.core.data.v aTK = null;
    private com.baidu.tieba.tbadkCore.o aTL = new com.baidu.tieba.tbadkCore.o();
    private com.baidu.tbadk.core.data.v aTN = null;
    private boolean Ji = false;
    public long aLy = -1;
    public long axx = 0;
    public long createTime = 0;
    public long aTP = -1;
    private boolean aTT = false;
    public com.baidu.tbadk.performanceLog.e aTU = null;
    private boolean aTW = true;
    private int aUc = -1;
    private int aZz = 0;
    private Handler aZA = new a(this);
    private ea aUf = new m(this);
    private CustomMessageListener aSu = new n(this, CmdConfigCustom.PB_ACTION_PRAISE);
    public final com.baidu.tieba.tbadkCore.r aUj = new o(this);
    private final CustomMessageListener Tr = new p(this, CmdConfigCustom.CMD_REFRESH);
    private NoNetworkView.a aON = new q(this);
    private final bd aUn = new r(this);
    private final p.a aUl = new s(this);
    public final View.OnClickListener aUm = new t(this);
    private final AbsListView.OnScrollListener aSw = new b(this);
    private final View.OnClickListener aUo = new c(this);
    private final View.OnClickListener aUp = new d(this);
    private final CustomMessageListener aUr = new e(this, 0);
    private com.baidu.adp.widget.ListView.v aUs = new f(this);
    private com.baidu.adp.widget.ListView.w aUv = new h(this);

    private void MF() {
        this.aZx.MV().setVisibility(8);
        this.aZv.MP().setVisibility(8);
        showLoadingView(this.aZv.MO(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MG() {
        this.aZx.MV().setVisibility(0);
        this.aZv.MP().setVisibility(0);
        hideLoadingView(this.aZv.MO());
    }

    private void MH() {
        this.aZx.MV().setVisibility(0);
        this.aZv.MP().setVisibility(8);
        showLoadingView(this.aZv.MO(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MI() {
        this.aZx.MV().setVisibility(0);
        this.aZv.MP().setVisibility(0);
        hideLoadingView(this.aZv.MO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar) {
        this.aZx.MV().setVisibility(8);
        this.aZv.MP().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.aZv.MO(), getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.aZv.MO(), "", true);
        }
    }

    private void MJ() {
        this.aZx.MV().setVisibility(0);
        this.aZv.MP().setVisibility(0);
        hideNetRefreshView(this.aZv.MO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e.a aVar) {
        this.aZx.MV().setVisibility(0);
        this.aZv.MP().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.aZv.Ma(), getPageContext().getResources().getString(i.h.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.aZv.Ma(), "", true);
        }
    }

    private void MK() {
        this.aZx.MV().setVisibility(0);
        this.aZv.MP().setVisibility(0);
        hideNetRefreshView(this.aZv.Ma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(boolean z) {
        stopVoice();
        if (!z) {
            if (this.aTI) {
                MK();
                MH();
            } else {
                MJ();
                MF();
            }
        }
        this.aZw.fj(this.aZz);
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
            this.aLy = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aLy = System.currentTimeMillis();
        }
        if (this.aLy != -1) {
            this.aTP = this.aLy;
        } else {
            this.aTP = System.currentTimeMillis();
        }
        super.onCreate(bundle);
        setContentView(i.g.frs_good_activity);
        this.aZw = new ae(this);
        this.aZx = new af(this);
        this.aZx.oQ();
        this.aZv.g(this.aON);
        if (getIntent() != null) {
            this.aZw.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aZw.f(bundle);
        } else {
            this.aZw.f(null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        addGlobalLayoutListener();
        registerListener(this.Tr);
        registerListener(this.aSu);
        this.aZy = new v(this);
        this.aZy.registerListener();
        this.createTime = System.currentTimeMillis() - this.aLy;
        if (com.baidu.adp.lib.util.i.iM()) {
            ci(false);
        } else {
            a((e.a) null);
        }
    }

    public void Lc() {
        com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aTL.aeN().getId(), true, true, true);
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
            this.aTB = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aTC = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aTB = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aTC = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
    }

    private void KS() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.aUr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.aZv != null) {
            this.aZv.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aTU != null) {
                this.aTU.onDestroy();
            }
            this.aZv.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aZw.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aTB);
        bundle.putString("from", this.mFrom);
        this.aZw.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.v lr;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11011:
                    b(this.aTK);
                    return;
                case 11012:
                    c(this.aTN);
                    return;
                case 11016:
                    this.aZv.LS();
                    return;
                case 18003:
                    this.aZv.MN().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (lr = this.aTL.lr(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            lr.bB(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            lr.parser_title();
                            ci(false);
                            return;
                        } else if (intExtra == 0) {
                            this.aTL.g(lr);
                            ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aTL.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new cd());
                            }
                            this.aZv.LT();
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
        this.aSo = true;
        this.aTW = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aZv.nw();
            return;
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onResume(getPageContext());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aTB = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aTE = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aTE) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    KU();
                } else {
                    KV();
                }
            }
        }
    }

    private void KU() {
        this.aZv.nw();
    }

    private void KV() {
        this.aZv.nw();
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
        this.aZv.MN().h(this.aUo);
        this.aZv.MN().i(this.aUp);
        if (this.aTC != 0) {
            this.aTC = 1;
        }
        this.aZv.a(this.aUs);
        this.aZv.a(this.aUv);
        this.aZv.setOnScrollListener(this.aSw);
        this.aZv.a(this.aUl);
        this.aZv.MN().a(this.aUn);
        this.aZx.a(this.aUf);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aZv.onChangeSkinType(i);
        this.aZx.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> KD() {
        if (this.aTO == null) {
            this.aTO = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aTO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.v vVar) {
        boolean sE = vVar == null ? true : vVar.sE();
        this.aZv.c(new i(this, vVar));
        this.aZv.a(vVar, sE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.v vVar) {
        boolean sE = vVar == null ? true : vVar.sE();
        if (this.mThreadId != null) {
            if (!sE) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aTB, null, 18003, true, true, this.aTH)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aTB, null, 18003, false, false, this.aTH)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.v vVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aTB, null, 18003, false, false, this.aTH)));
        }
    }

    private void KZ() {
        switch (this.aTC) {
            case 1:
                com.baidu.adp.lib.g.k.hh().c(new j(this));
                break;
        }
        this.aTC = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void La() {
        stopVoice();
        try {
            if (this.aTL != null) {
                this.aZv.LP();
                this.aTB = this.aTL.aeN().getName();
                this.forumId = this.aTL.aeN().getId();
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aTL.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aTL.getUserData().getBimg_end_time());
                KZ();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aTL.getThreadList();
                if (threadList != null) {
                    this.aZv.a(threadList, this.mPn, this.aTL, this.aTL.getPage().rL());
                    Lf();
                    this.aZv.LT();
                    if (this.aTL.aeT() == 1) {
                        this.aZv.MN().setFromCDN(true);
                    } else {
                        this.aZv.MN().setFromCDN(false);
                    }
                    this.aZv.fz(V(ML().getType(), this.mPn));
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
        this.aSo = false;
        this.aTW = false;
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.aTL != null && this.aTL.aeN() != null) {
            com.baidu.tbadk.distribute.a.Ag().a(getPageContext().getPageActivity(), "frs", this.aTL.aeN().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aTD) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i) {
        String trim;
        if (bVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            if (bVar.rr()) {
                ay.uV().b(getPageContext(), new String[]{bVar.TX});
            } else if (bVar.rq()) {
                if (com.baidu.adp.lib.util.i.iM() && !com.baidu.adp.lib.util.i.iN()) {
                    trim = getPageContext().getString(i.h.frs_network_tips);
                } else if (TextUtils.isEmpty(bVar.Ui.Uo.trim())) {
                    trim = getPageContext().getString(i.h.confirm_download_app);
                } else {
                    trim = bVar.Ui.Uo.trim();
                }
                aVar.ct(trim);
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
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", bVar.TZ);
                com.baidu.tbadk.download.b.An().a(bVar.TZ, bVar.TY, bVar.TV, i, com.baidu.adp.lib.g.b.g(bVar.TU, 0));
            } else {
                showToast(i.h.neterror);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Ag().a(getPageContext().getPageActivity(), bVar, str, "frs", this.aTL.aeN().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Ag().a(bVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aTL.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.v) {
                    com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) next;
                    if (vVar.getId() != null && vVar.getId().equals(this.aSp)) {
                        b(vVar, i);
                        this.aSp = null;
                        break;
                    }
                }
            }
            this.aZv.MN().a(threadList, this.aTL);
            this.aZv.MN().notifyDataSetChanged();
        }
    }

    private void b(com.baidu.tbadk.core.data.v vVar, int i) {
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
        if (this.aZv == null) {
            return null;
        }
        return this.aZv.getListView();
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
        if (this.aZv == null) {
            return 0;
        }
        return this.aZv.LW();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vE() {
        if (this.aeH == null) {
            this.aeH = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aeH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bq MN;
        HashMap<Integer, com.baidu.tbadk.core.data.v> Lu;
        if (this.aTL != null && this.aZv != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (MN = this.aZv.MN()) != null && (Lu = MN.Lu()) != null && Lu.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.v> entry : Lu.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.v value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && TextUtils.equals(((com.baidu.tbadk.core.data.b) value).TZ, downloadData.getId())) {
                            int avK = this.aTL.avK();
                            if (MN.aA(intValue + avK) instanceof com.baidu.tbadk.core.data.b) {
                                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) MN.aA(avK + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    bVar.TT = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!ar.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    bVar.TT = 0;
                                } else if (status == 1) {
                                    bVar.TT = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aZv.LQ();
        }
    }

    private void Lf() {
        HashMap<Integer, com.baidu.tbadk.core.data.v> Lu;
        if (this.aZv != null && this.aZv.MN() != null && (Lu = this.aZv.MN().Lu()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.v> entry : Lu.entrySet()) {
                com.baidu.tbadk.core.data.v value = entry.getValue();
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
            int i2 = bVar.TT;
            if (i2 == 0) {
                a(bVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), bVar.TZ);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", bVar.TZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            a(bVar, "btn_click");
            b(bVar, "click");
            ay.uV().b(getPageContext(), new String[]{bVar.TX});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.i.iM()) {
            ci(false);
        }
    }

    public ae ML() {
        return this.aZw;
    }

    public void gN(String str) {
        this.aTB = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setFlag(int i) {
        this.aTC = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jd()) {
            this.aZv.Mg();
        } else if (!this.aZw.MT()) {
            this.aZv.Mg();
        } else {
            Ln();
            if (!this.aZy.avB && !this.aZw.isLoading()) {
                if (this.aZy.Z(this.aTL.avt())) {
                    this.aZv.a(this.aZy.MM(), this.mPn, this.aTL, 0);
                    this.aZy.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.aTL.avt());
                } else if (this.aUc != 0) {
                    this.aZv.a(this.aZy.MM(), this.mPn, this.aTL, 0);
                    this.mPn++;
                    this.aZw.fK(this.mPn);
                    this.aZy.aZE = false;
                    this.aZy.aZF = 0;
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
        if (arrayList != null && arrayList.size() != 0 && (a = this.aZy.a(false, arrayList)) != null) {
            this.aTL.af(a);
            this.aZv.a(a, this.mPn, this.aTL, 0);
        }
    }

    private void Ln() {
        if (this.aUc == 0 && !this.aZy.Z(this.aTL.avt())) {
            if (this.aTL.getThreadList() == null || this.aTL.getThreadList().size() == 0) {
                this.aZv.Mg();
                return;
            } else {
                this.aZv.Mf();
                return;
            }
        }
        this.aZv.Me();
    }

    public void a(x xVar) {
        this.aZv = xVar;
    }
}
