package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.w;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.s;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.view.AdapterLinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tbclient.ForumRuleStatus;
/* loaded from: classes2.dex */
public class FrsTopView extends LinearLayout {
    private ForumData fBZ;
    private FrsFoldingView jGo;
    private com.baidu.tieba.frs.ad.g jGp;
    private boolean jGq;
    private List<View> jGr;
    private List<com.baidu.tieba.frs.view.e> jGs;
    private ArrayList<Boolean> jGt;
    private w jcn;
    private com.baidu.tieba.frs.b.b jkJ;
    private aw jkg;
    private BdUniqueId mBdUniqueId;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private UserData mUserData;
    private int textColor;
    private List<com.baidu.adp.widget.ListView.n> topThreadList;
    private String url;

    public FrsTopView(Context context) {
        this(context, null);
    }

    public FrsTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jGq = false;
        this.mForumName = "";
        this.mForumId = "";
        this.mFrom = "";
        this.textColor = 0;
        this.url = null;
        this.jGr = new ArrayList();
        this.jGs = new ArrayList();
        this.topThreadList = new ArrayList();
        this.jkJ = new com.baidu.tieba.frs.b.b();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.jGo = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.n> list, com.baidu.tieba.tbadkCore.i iVar) {
        this.topThreadList.clear();
        this.jGs.clear();
        this.jGr.clear();
        if (x.isEmpty(list) && iVar == null) {
            setVisibility(8);
            return;
        }
        if (iVar != null) {
            a(iVar);
        }
        if (!x.isEmpty(list)) {
            if (list.size() > 6) {
                list = list.subList(0, 6);
            }
            this.topThreadList.addAll(list);
            int i = this.topThreadList.size() <= 2 ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                cKG();
                com.baidu.tieba.frs.view.e eVar = this.jGs.get(i2);
                if (eVar != null) {
                    if (this.jcn == null) {
                        this.jcn = new a();
                    }
                    eVar.d(this.jcn);
                    eVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 4) + 2, this.topThreadList.size())));
                }
            }
        }
        if (this.jGt == null && this.jGr != null) {
            this.jGt = new ArrayList<>(Collections.nCopies(this.jGr.size(), Boolean.FALSE));
        }
        cKH();
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar) {
        int i = 6;
        if (iVar != null) {
            if (this.jGp == null) {
                this.jGp = new com.baidu.tieba.frs.ad.g(getContext());
                addView(this.jGp.getView());
            }
            this.jGp.a(this.fBZ, iVar);
            if (!this.jGq) {
                this.jGq = true;
                aq aqVar = new aq("common_exp");
                aqVar.dW("page_type", PageStayDurationConstants.PageName.FRS);
                aqVar.dW("obj_isad", "1");
                if (iVar.getType() != 1) {
                    if (iVar.getType() == 2) {
                        i = 7;
                    } else if (iVar.getType() == 3) {
                        i = 8;
                    }
                }
                aqVar.an("obj_floor", 1);
                aqVar.an("obj_adlocate", i);
                aqVar.w("obj_id", iVar.getId());
                if (this.fBZ != null) {
                    aqVar.dW("fid", this.fBZ.getId());
                    aqVar.dW("first_dir", this.fBZ.getFirst_class());
                    aqVar.dW("second_dir", this.fBZ.getSecond_class());
                }
                if (iVar.getType() == 1) {
                    aqVar.dW("tid", iVar.getThreadId());
                    aqVar.an("thread_type", iVar.getThreadType());
                }
                TiebaStatic.log(aqVar);
            }
        }
    }

    private void cKG() {
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
        adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        adapterLinearLayout.setOrientation(1);
        com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(getContext());
        eVar.a(this.mForumId, this.mForumName, this.mUserData);
        eVar.a(this.fBZ);
        eVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            eVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            eVar.AQ(this.textColor);
        }
        adapterLinearLayout.setAdapter(eVar);
        this.jGr.add(adapterLinearLayout);
        this.jGs.add(eVar);
    }

    public void setStatListener(aw awVar) {
        this.jkg = awVar;
    }

    private void cKH() {
        if (!x.isEmpty(this.jGr)) {
            setVisibility(0);
            if (this.jGo != null) {
                this.jGo.setViews(this.jGr, this.jGs);
            }
        }
    }

    public void onChangeSkinType(int i) {
        for (com.baidu.tieba.frs.view.e eVar : this.jGs) {
            eVar.notifyDataSetChanged();
        }
        if (this.jGo != null) {
            this.jGo.onChangeSkinType();
        }
    }

    /* loaded from: classes2.dex */
    private final class a implements w {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (nVar != null && (nVar instanceof bz)) {
                    bz bzVar = (bz) nVar;
                    if (bzVar.boz() == null || bzVar.boz().getGroup_id() == 0 || bg.checkUpIsLogin(FrsTopView.this.getContext())) {
                        if (bzVar.bok() != 1 || bg.checkUpIsLogin(FrsTopView.this.getContext())) {
                            if (bzVar.bnJ() != null) {
                                if (bg.checkUpIsLogin(FrsTopView.this.getContext())) {
                                    String postUrl = bzVar.bnJ().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.getContext(), postUrl);
                                    }
                                }
                            } else if (bzVar.boK() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bg.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                    return;
                                }
                                s boK = bzVar.boK();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), boK.getCartoonId(), boK.getChapterId(), 2)));
                            } else {
                                boolean z = false;
                                final String bnD = bzVar.bnD();
                                if (bnD != null && !bnD.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            z zVar = new z(bnD);
                                            zVar.brX().bsG().mIsNeedAddCommenParam = false;
                                            zVar.brX().bsG().mIsUseCurrentBDUSS = false;
                                            zVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bzVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bzVar.bns() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    be.bsB().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(tid) && tid.length() > 3) {
                                    bzVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bz.eQd.getId()) {
                                    com.baidu.tieba.frs.d.k.a(bzVar.bnd());
                                } else if (bdUniqueId.getId() == bz.eOD.getId()) {
                                    aq aqVar = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    aqVar.dW("obj_type", "2");
                                    aqVar.dW("tid", bzVar.getTid());
                                    TiebaStatic.log(aqVar);
                                }
                                FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bzVar, i, z);
                                if (FrsTopView.this.jkg != null) {
                                    FrsTopView.this.jkg.ao(bzVar);
                                }
                            }
                        }
                    }
                } else if (nVar != null && (nVar instanceof p)) {
                    FrsTopView.this.a(((p) nVar).dKx());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumRuleStatus forumRuleStatus) {
        int i;
        if (forumRuleStatus != null && this.mUserData != null && this.fBZ != null) {
            if ((com.baidu.adp.base.b.kC().bo("ForumRulesEditActivity") || com.baidu.tbadk.k.d.bCj().bCk()) && this.mUserData.getIs_manager() == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921518, ""));
                return;
            }
            if (this.mUserData.getIs_manager() == 1 && forumRuleStatus.has_forum_rule.intValue() == 0 && forumRuleStatus.audit_status.intValue() == 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(getContext(), this.mForumId, this.mForumName, ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS, this.fBZ != null ? this.fBZ.getImage_url() : "", this.fBZ != null ? this.fBZ.getUser_level() : 0, RequestResponseCode.REQUEST_MOBILE_MODIFY_NICKNAME_DIALOG)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(getContext(), this.mForumId, "")));
            }
            aq aqVar = new aq("c14027");
            aqVar.dW("fid", this.mForumId);
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            if (this.mUserData.getIs_manager() == 1) {
                i = 1;
            } else if (this.mUserData.getIs_manager() == 2) {
                i = 2;
            } else if (this.fBZ.isLike() == 1) {
                i = 3;
            } else {
                i = 4;
            }
            aqVar.an("obj_type", i);
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getTbPageContext() {
        if (getContext() instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) getContext()).getPageContext();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseFragmentActivity getFragmentActivity() {
        if (getContext() instanceof BaseFragmentActivity) {
            return (BaseFragmentActivity) getContext();
        }
        return null;
    }

    public void setForum(String str, String str2, ForumData forumData, UserData userData, String str3) {
        this.mForumId = str;
        this.mForumName = str2;
        this.fBZ = forumData;
        this.mUserData = userData;
        this.mFrom = str3;
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, bz bzVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (baseFragmentActivity != null && bzVar != null) {
            String valueOf = String.valueOf(bzVar.getFid());
            if (bzVar.eRb == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bzVar.eRb.id;
                str2 = valueOf;
            }
            if (bzVar.bnT() > 0 && com.baidu.tieba.tbadkCore.util.e.dMC()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bzVar.getTid(), String.valueOf(bzVar.bnT()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bzVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bzVar.boP());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bzVar.boG() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        this.textColor = i;
        for (com.baidu.tieba.frs.view.e eVar : this.jGs) {
            if (str != null) {
                eVar.setImageUrl(str);
                this.url = str;
            }
            eVar.AQ(i);
            eVar.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jkJ;
    }

    public List<View> getmTopViews() {
        if (this.jGr == null || this.jGr.size() == 0) {
            return null;
        }
        return this.jGr;
    }

    public void AA(int i) {
        com.baidu.tieba.frs.view.e eVar;
        if (i != -1 && this.jGs.size() > i && (eVar = this.jGs.get(0)) != null) {
            new ArrayList();
            List<com.baidu.adp.widget.ListView.n> data = eVar.getData();
            if (data != null && data.size() > i && (data.get(i) instanceof p)) {
                p pVar = (p) data.get(i);
                if (pVar != null) {
                    ForumRuleStatus.Builder builder = new ForumRuleStatus.Builder();
                    builder.has_forum_rule = pVar.dKx().has_forum_rule;
                    builder.forum_rule_id = pVar.dKx().forum_rule_id;
                    builder.title = pVar.dKx().title;
                    builder.audit_status = 1;
                    pVar.b(builder.build(true));
                }
                eVar.setData(data);
                eVar.notifyDataSetChanged();
            }
        }
    }
}
