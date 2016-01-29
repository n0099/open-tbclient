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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bh;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.dd;
import com.baidu.tieba.frs.fe;
import com.baidu.tieba.t;
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
    private com.baidu.adp.lib.f.b<TbImageView> ahx;
    private boolean beg;
    private String beh;
    private VoiceManager ben;
    private com.baidu.adp.lib.f.b<TbImageView> bfI;
    private af bnh;
    private ag bni;
    private w bnj;
    public boolean bfr = false;
    private String bfv = null;
    private String aer = null;
    private int bfw = 0;
    private int mPn = 1;
    private boolean bfx = false;
    private boolean bfy = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean bfB = false;
    private boolean bfC = false;
    protected y bng = null;
    private final com.baidu.tbadk.core.data.ah bfE = null;
    private com.baidu.tieba.tbadkCore.o bfF = new com.baidu.tieba.tbadkCore.o();
    private com.baidu.tbadk.core.data.ah bfH = null;
    private boolean Kg = false;
    public long aWx = -1;
    public long aAK = 0;
    public long createTime = 0;
    public long VB = -1;
    private boolean bfM = false;
    public com.baidu.tbadk.performanceLog.e bfN = null;
    private boolean bfP = true;
    private int bfW = -1;
    private int bnk = 0;
    private Handler bnl = new a(this);
    private fe bfZ = new m(this);
    private CustomMessageListener ahv = new o(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener bgl = new p(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    public final com.baidu.tieba.tbadkCore.r bgd = new q(this);
    private final CustomMessageListener TI = new r(this, CmdConfigCustom.CMD_REFRESH);
    private NoNetworkView.a baA = new s(this);
    private final bh bgk = new t(this);
    private final r.a bgi = new u(this);
    public final View.OnClickListener bgj = new b(this);
    private final AbsListView.OnScrollListener beo = new c(this);
    private final View.OnClickListener bgm = new d(this);
    private final View.OnClickListener bgn = new e(this);
    private final CustomMessageListener bgq = new f(this, 0);
    private com.baidu.adp.widget.ListView.v bgr = new g(this);
    private com.baidu.adp.widget.ListView.w bgv = new i(this);

    private void QP() {
        this.bni.Rg().setVisibility(8);
        this.bng.Ra().setVisibility(8);
        showLoadingView(this.bng.QZ(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QQ() {
        this.bni.Rg().setVisibility(0);
        this.bng.Ra().setVisibility(0);
        hideLoadingView(this.bng.QZ());
    }

    private void QR() {
        this.bni.Rg().setVisibility(0);
        this.bng.Ra().setVisibility(8);
        showLoadingView(this.bng.QZ(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QS() {
        this.bni.Rg().setVisibility(0);
        this.bng.Ra().setVisibility(0);
        hideLoadingView(this.bng.QZ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        this.bni.Rg().setVisibility(8);
        this.bng.Ra().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.bng.QZ(), getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.bng.QZ(), "", true);
        }
    }

    private void QT() {
        this.bni.Rg().setVisibility(0);
        this.bng.Ra().setVisibility(0);
        hideNetRefreshView(this.bng.QZ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d.a aVar) {
        this.bni.Rg().setVisibility(0);
        this.bng.Ra().setVisibility(8);
        if (aVar != null) {
            showNetRefreshView(this.bng.Qj(), getPageContext().getResources().getString(t.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
        } else {
            showNetRefreshView(this.bng.Qj(), "", true);
        }
    }

    private void QU() {
        this.bni.Rg().setVisibility(0);
        this.bng.Ra().setVisibility(0);
        hideNetRefreshView(this.bng.Qj());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(boolean z) {
        Oy();
        if (!z) {
            if (this.bfC) {
                QU();
                QR();
            } else {
                QT();
                QP();
            }
        }
        this.bnh.gf(this.bnk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tbadk.core.data.ah ahVar;
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bfF.getThreadList();
        if (threadList != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.ah) && (ahVar = (com.baidu.tbadk.core.data.ah) next) != null && ahVar.getAuthor() != null && ahVar.getAuthor().getUserId() != null && ahVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
                    a(ahVar, updateAttentionMessage);
                    break;
                }
            }
            this.bng.QY().a(threadList, this.bfF);
            this.bng.QY().notifyDataSetChanged();
        }
    }

    private void a(com.baidu.tbadk.core.data.ah ahVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2;
        if (ahVar != null && ahVar.getAuthor() != null && ahVar.getAuthor().getUserId() != null && ahVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = ahVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                i2 = 1;
            } else {
                i = fansNum - 1;
                i2 = 0;
            }
            ahVar.getAuthor().setFansNum(i);
            if (ahVar.getAuthor().getGodUserData() != null) {
                ahVar.getAuthor().getGodUserData().setFollowed(i2);
                ahVar.getAuthor().getGodUserData().setIsFromNetWork(false);
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
            this.aWx = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aWx = System.currentTimeMillis();
        }
        if (this.aWx != -1) {
            this.VB = this.aWx;
        } else {
            this.VB = System.currentTimeMillis();
        }
        super.onCreate(bundle);
        setContentView(t.h.frs_good_activity);
        this.bnh = new af(this);
        this.bni = new ag(this);
        this.bni.oQ();
        this.bng.f(this.baA);
        if (getIntent() != null) {
            this.bnh.c(getIntent().getExtras());
        } else if (bundle != null) {
            this.bnh.c(bundle);
        } else {
            this.bnh.c(null);
        }
        this.ben = getVoiceManager();
        this.ben.onCreate(getPageContext());
        qD();
        initData(bundle);
        addGlobalLayoutListener();
        registerListener(this.TI);
        registerListener(this.ahv);
        registerListener(this.bgl);
        this.bnj = new w(this);
        this.bnj.registerListener();
        this.createTime = System.currentTimeMillis() - this.aWx;
        if (com.baidu.adp.lib.util.i.iZ()) {
            cy(false);
        } else {
            a((d.a) null);
        }
    }

    public void Pf() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.bfF.aoE().getId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.ben = getVoiceManager();
        this.ben.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        OT();
        if (bundle != null) {
            this.bfv = bundle.getString("name");
            this.aer = bundle.getString("from");
            this.bfw = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bfv = intent.getStringExtra("name");
                this.aer = intent.getStringExtra("from");
                this.bfw = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.aer) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aer)) {
            setSwipeBackEnabled(false);
        }
    }

    private void OT() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bgq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bng != null) {
            this.bng.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bfN != null) {
                this.bfN.onDestroy();
            }
            this.bng.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bnh.onActivityDestroy();
        this.ben = getVoiceManager();
        this.ben.onDestory(getPageContext());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bfv);
        bundle.putString("from", this.aer);
        this.bnh.onSaveInstanceState(bundle);
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.ah mC;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11011:
                    d(this.bfE);
                    return;
                case 11012:
                    e(this.bfH);
                    return;
                case 11016:
                    this.bng.PY();
                    return;
                case 18003:
                    this.bng.QY().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (mC = this.bfF.mC(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            mC.bV(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            mC.parser_title();
                            cy(false);
                            return;
                        } else if (intExtra == 0) {
                            this.bfF.k(mC);
                            ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bfF.getThreadList();
                            if (threadList != null && threadList.size() <= 0) {
                                threadList.add(new dd());
                            }
                            this.bng.QX();
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
        this.beg = true;
        this.bfP = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bng.ns();
            return;
        }
        this.ben = getVoiceManager();
        this.ben.onResume(getPageContext());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bfv = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.aer = intent.getStringExtra("from");
            }
            this.bfy = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bfy) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    OV();
                } else {
                    OW();
                }
            }
        }
    }

    private void OV() {
        this.bng.ns();
    }

    private void OW() {
        this.bng.ns();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aer)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.c.b.d(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aer)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.c.b.d(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aer)) {
            finish();
        }
    }

    private void qD() {
        this.bng.QY().l(this.bgm);
        this.bng.QY().m(this.bgn);
        if (this.bfw != 0) {
            this.bfw = 1;
        }
        this.bng.a(this.bgr);
        this.bng.a(this.bgv);
        this.bng.setOnScrollListener(this.beo);
        this.bng.a(this.bgi);
        this.bng.QY().a(this.bgk);
        this.bni.a(this.bfZ);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bng.onChangeSkinType(i);
        this.bni.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> OC() {
        if (this.bfI == null) {
            this.bfI = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 12);
        }
        return this.bfI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.ah ahVar) {
        boolean tM = ahVar == null ? true : ahVar.tM();
        this.bng.a(new j(this, ahVar));
        this.bng.a(ahVar, tM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.ah ahVar) {
        boolean tM = ahVar == null ? true : ahVar.tM();
        if (this.mThreadId != null) {
            if (!tM) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(ahVar, this.bfv, null, 18003, true, true, this.bfB)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(ahVar, this.bfv, null, 18003, false, false, this.bfB)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.ah ahVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(ahVar, this.bfv, null, 18003, false, false, this.bfB)));
        }
    }

    private void OZ() {
        switch (this.bfw) {
            case 1:
                com.baidu.adp.lib.h.k.hs().c(new k(this));
                break;
        }
        this.bfw = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pa() {
        Oy();
        try {
            if (this.bfF != null) {
                this.bng.KZ();
                this.bfv = this.bfF.aoE().getName();
                this.forumId = this.bfF.aoE().getId();
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.bfF.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.bfF.getUserData().getBimg_end_time());
                OZ();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bfF.getThreadList();
                if (threadList != null) {
                    this.bng.a(threadList, this.mPn, this.bfF, this.bfF.getPage().sv());
                    Pi();
                    this.bng.QX();
                    if (this.bfF.aoK() == 1) {
                        this.bng.QY().setFromCDN(true);
                    } else {
                        this.bng.QY().setFromCDN(false);
                    }
                    this.bng.gE(Z(QV().getType(), this.mPn));
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
        this.beg = false;
        this.bfP = false;
        this.ben = getVoiceManager();
        this.ben.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bfF != null && this.bfF.aoE() != null) {
            com.baidu.tbadk.distribute.a.Cl().b(getPageContext().getPageActivity(), "frs", this.bfF.aoE().getId(), 0L);
        }
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bfx) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.c cVar, int i, boolean z) {
        String trim;
        if (cVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            if (cVar.rO()) {
                be.wt().a(getPageContext(), new String[]{cVar.Uw}, true);
            } else if (cVar.rN()) {
                if (com.baidu.adp.lib.util.i.iZ() && !com.baidu.adp.lib.util.i.ja()) {
                    trim = getPageContext().getString(t.j.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.UI.UT.trim())) {
                    trim = getPageContext().getString(t.j.confirm_download_app);
                } else {
                    trim = cVar.UI.UT.trim();
                }
                aVar.cE(trim);
                aVar.a(t.j.alert_yes_button, new l(this, cVar, z, i));
                aVar.b(t.j.alert_no_button, new n(this));
                aVar.b(getPageContext()).uj();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.rM()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), t.j.pb_app_error);
            } else if (com.baidu.tieba.tbadkCore.ag.a(getPageContext().getPageActivity(), cVar, i)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Uy);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Cl().a(getPageContext().getPageActivity(), cVar, str, "frs", this.bfF.aoE().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Cl().a(cVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bfF.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.ah) {
                    com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) next;
                    if (ahVar.getId() != null && ahVar.getId().equals(this.beh)) {
                        b(ahVar, i);
                        this.beh = null;
                        break;
                    }
                }
            }
            this.bng.QY().a(threadList, this.bfF);
            this.bng.QY().notifyDataSetChanged();
        }
    }

    private void b(com.baidu.tbadk.core.data.ah ahVar, int i) {
        if (i == 1) {
            PraiseData praise = ahVar.getPraise();
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
                    ahVar.setPraise(praiseData);
                    return;
                }
                ahVar.getPraise().getUser().add(0, metaData);
                ahVar.getPraise().setNum(ahVar.getPraise().getNum() + 1);
                ahVar.getPraise().setIsLike(i);
            }
        } else if (ahVar.getPraise() != null) {
            ahVar.getPraise().setIsLike(i);
            ahVar.getPraise().setNum(ahVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = ahVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        ahVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ben == null) {
            this.ben = VoiceManager.instance();
        }
        return this.ben;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: KM */
    public BdListView getListView() {
        if (this.bng == null) {
            return null;
        }
        return this.bng.KM();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void Oy() {
        this.ben = getVoiceManager();
        this.ben.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int xi() {
        if (this.bng == null) {
            return 0;
        }
        return this.bng.Qc();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> xj() {
        if (this.ahx == null) {
            this.ahx = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.ahx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        cl QY;
        HashMap<Integer, com.baidu.tbadk.core.data.ah> Px;
        if (this.bfF != null && this.bng != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (QY = this.bng.QY()) != null && (Px = QY.Px()) != null && Px.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.ah> entry : Px.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.ah value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Uy, downloadData.getId())) {
                            int aLq = this.bfF.aLq();
                            if (QY.aG(intValue + aLq) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) QY.aG(aLq + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    cVar.Us = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!aw.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    cVar.Us = 0;
                                } else if (status == 1) {
                                    cVar.Us = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.bng.PW();
        }
    }

    private void Pi() {
        HashMap<Integer, com.baidu.tbadk.core.data.ah> Px;
        if (this.bng != null && this.bng.QY() != null && (Px = this.bng.QY().Px()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.ah> entry : Px.entrySet()) {
                com.baidu.tbadk.core.data.ah value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.Cr().q(arrayList);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            a(cVar, true, this.mPn);
            int i2 = cVar.Us;
            if (i2 == 0) {
                a(cVar, i, true);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.N(getPageContext().getPageActivity(), cVar.Uy);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Uy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            a(cVar, true, this.mPn);
            be.wt().a(getPageContext(), new String[]{cVar.Uw}, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.i.iZ()) {
            cy(false);
        }
    }

    public af QV() {
        return this.bnh;
    }

    public void hs(String str) {
        this.bfv = str;
    }

    public void setFrom(String str) {
        this.aer = str;
    }

    public void setFlag(int i) {
        this.bfw = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        if (!com.baidu.adp.lib.util.k.jq()) {
            this.bng.Qp();
        } else if (!this.bnh.Re()) {
            this.bng.Qp();
        } else {
            Pp();
            if (!this.bnj.ayQ && !this.bnh.isLoading()) {
                if (this.bnj.ag(this.bfF.aKU())) {
                    this.bng.a(this.bnj.QW(), this.mPn, this.bfF, 0);
                    this.bnj.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.bfF.aKU(), this.bfv, this.mPn);
                } else if (this.bfW != 0) {
                    this.bng.a(this.bnj.QW(), this.mPn, this.bfF, 0);
                    this.mPn++;
                    this.bnh.gF(this.mPn);
                    this.bnj.bnp = false;
                    this.bnj.bnq = 0;
                }
            }
        }
    }

    public void ht(String str) {
        Pp();
    }

    public void E(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        Pp();
        if (arrayList != null && arrayList.size() != 0 && (a = this.bnj.a(false, arrayList)) != null) {
            this.bfF.an(a);
            this.bng.a(a, this.mPn, this.bfF, 0);
        }
    }

    private void Pp() {
        if (this.bfW == 0 && !this.bnj.ag(this.bfF.aKU())) {
            if (this.bfF.getThreadList() == null || this.bfF.getThreadList().size() == 0) {
                this.bng.Qp();
                return;
            } else {
                this.bng.Qo();
                return;
            }
        }
        this.bng.Qn();
    }

    public void a(y yVar) {
        this.bng = yVar;
    }

    private void a(com.baidu.tbadk.core.data.c cVar, boolean z, int i) {
        a(cVar, z ? "area_click" : "btn_click");
        b(cVar, "click");
        com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.a(cVar, "click", i));
    }
}
