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
    private ForumData fGG;
    private FrsFoldingView jKU;
    private com.baidu.tieba.frs.ad.g jKV;
    private boolean jKW;
    private List<View> jKX;
    private List<com.baidu.tieba.frs.view.e> jKY;
    private ArrayList<Boolean> jKZ;
    private w jgU;
    private aw joN;
    private com.baidu.tieba.frs.b.b jpq;
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
        this.jKW = false;
        this.mForumName = "";
        this.mForumId = "";
        this.mFrom = "";
        this.textColor = 0;
        this.url = null;
        this.jKX = new ArrayList();
        this.jKY = new ArrayList();
        this.topThreadList = new ArrayList();
        this.jpq = new com.baidu.tieba.frs.b.b();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.jKU = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.n> list, com.baidu.tieba.tbadkCore.i iVar) {
        this.topThreadList.clear();
        this.jKY.clear();
        this.jKX.clear();
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
                cOy();
                com.baidu.tieba.frs.view.e eVar = this.jKY.get(i2);
                if (eVar != null) {
                    if (this.jgU == null) {
                        this.jgU = new a();
                    }
                    eVar.d(this.jgU);
                    eVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 4) + 2, this.topThreadList.size())));
                }
            }
        }
        if (this.jKZ == null && this.jKX != null) {
            this.jKZ = new ArrayList<>(Collections.nCopies(this.jKX.size(), Boolean.FALSE));
        }
        cOz();
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar) {
        int i = 6;
        if (iVar != null) {
            if (this.jKV == null) {
                this.jKV = new com.baidu.tieba.frs.ad.g(getContext());
                addView(this.jKV.getView());
            }
            this.jKV.a(this.fGG, iVar);
            if (!this.jKW) {
                this.jKW = true;
                aq aqVar = new aq("common_exp");
                aqVar.dX("page_type", PageStayDurationConstants.PageName.FRS);
                aqVar.dX("obj_isad", "1");
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
                if (this.fGG != null) {
                    aqVar.dX("fid", this.fGG.getId());
                    aqVar.dX("first_dir", this.fGG.getFirst_class());
                    aqVar.dX("second_dir", this.fGG.getSecond_class());
                }
                if (iVar.getType() == 1) {
                    aqVar.dX("tid", iVar.getThreadId());
                    aqVar.an("thread_type", iVar.getThreadType());
                }
                TiebaStatic.log(aqVar);
            }
        }
    }

    private void cOy() {
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
        adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        adapterLinearLayout.setOrientation(1);
        com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(getContext());
        eVar.a(this.mForumId, this.mForumName, this.mUserData);
        eVar.a(this.fGG);
        eVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            eVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            eVar.Cw(this.textColor);
        }
        adapterLinearLayout.setAdapter(eVar);
        this.jKX.add(adapterLinearLayout);
        this.jKY.add(eVar);
    }

    public void setStatListener(aw awVar) {
        this.joN = awVar;
    }

    private void cOz() {
        if (!x.isEmpty(this.jKX)) {
            setVisibility(0);
            if (this.jKU != null) {
                this.jKU.setViews(this.jKX, this.jKY);
            }
        }
    }

    public void onChangeSkinType(int i) {
        for (com.baidu.tieba.frs.view.e eVar : this.jKY) {
            eVar.notifyDataSetChanged();
        }
        if (this.jKU != null) {
            this.jKU.onChangeSkinType();
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
                    if (bzVar.bst() == null || bzVar.bst().getGroup_id() == 0 || bg.checkUpIsLogin(FrsTopView.this.getContext())) {
                        if (bzVar.bse() != 1 || bg.checkUpIsLogin(FrsTopView.this.getContext())) {
                            if (bzVar.brD() != null) {
                                if (bg.checkUpIsLogin(FrsTopView.this.getContext())) {
                                    String postUrl = bzVar.brD().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.getContext(), postUrl);
                                    }
                                }
                            } else if (bzVar.bsE() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bg.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                    return;
                                }
                                s bsE = bzVar.bsE();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), bsE.getCartoonId(), bsE.getChapterId(), 2)));
                            } else {
                                boolean z = false;
                                final String brx = bzVar.brx();
                                if (brx != null && !brx.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            z zVar = new z(brx);
                                            zVar.bvR().bwA().mIsNeedAddCommenParam = false;
                                            zVar.bvR().bwA().mIsUseCurrentBDUSS = false;
                                            zVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bzVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bzVar.brm() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    be.bwv().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(tid) && tid.length() > 3) {
                                    bzVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bz.eUO.getId()) {
                                    com.baidu.tieba.frs.d.k.a(bzVar.bqX());
                                } else if (bdUniqueId.getId() == bz.eTo.getId()) {
                                    aq aqVar = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    aqVar.dX("obj_type", "2");
                                    aqVar.dX("tid", bzVar.getTid());
                                    TiebaStatic.log(aqVar);
                                }
                                FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), bzVar, i, z);
                                if (FrsTopView.this.joN != null) {
                                    FrsTopView.this.joN.ao(bzVar);
                                }
                            }
                        }
                    }
                } else if (nVar != null && (nVar instanceof p)) {
                    FrsTopView.this.a(((p) nVar).dOp());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumRuleStatus forumRuleStatus) {
        int i;
        if (forumRuleStatus != null && this.mUserData != null && this.fGG != null) {
            if ((com.baidu.adp.base.b.kC().bo("ForumRulesEditActivity") || com.baidu.tbadk.k.d.bGc().bGd()) && this.mUserData.getIs_manager() == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921518, ""));
                return;
            }
            if (this.mUserData.getIs_manager() == 1 && forumRuleStatus.has_forum_rule.intValue() == 0 && forumRuleStatus.audit_status.intValue() == 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(getContext(), this.mForumId, this.mForumName, ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS, this.fGG != null ? this.fGG.getImage_url() : "", this.fGG != null ? this.fGG.getUser_level() : 0, RequestResponseCode.REQUEST_MOBILE_MODIFY_NICKNAME_DIALOG)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(getContext(), this.mForumId, "")));
            }
            aq aqVar = new aq("c14027");
            aqVar.dX("fid", this.mForumId);
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            if (this.mUserData.getIs_manager() == 1) {
                i = 1;
            } else if (this.mUserData.getIs_manager() == 2) {
                i = 2;
            } else if (this.fGG.isLike() == 1) {
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
        this.fGG = forumData;
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
            if (bzVar.eVM == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = bzVar.eVM.id;
                str2 = valueOf;
            }
            if (bzVar.brN() > 0 && com.baidu.tieba.tbadkCore.util.e.dQu()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(bzVar.getTid(), String.valueOf(bzVar.brN()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(bzVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(bzVar.bsJ());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (bzVar.bsA() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        this.textColor = i;
        for (com.baidu.tieba.frs.view.e eVar : this.jKY) {
            if (str != null) {
                eVar.setImageUrl(str);
                this.url = str;
            }
            eVar.Cw(i);
            eVar.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jpq;
    }

    public List<View> getmTopViews() {
        if (this.jKX == null || this.jKX.size() == 0) {
            return null;
        }
        return this.jKX;
    }

    public void Cg(int i) {
        com.baidu.tieba.frs.view.e eVar;
        if (i != -1 && this.jKY.size() > i && (eVar = this.jKY.get(0)) != null) {
            new ArrayList();
            List<com.baidu.adp.widget.ListView.n> data = eVar.getData();
            if (data != null && data.size() > i && (data.get(i) instanceof p)) {
                p pVar = (p) data.get(i);
                if (pVar != null) {
                    ForumRuleStatus.Builder builder = new ForumRuleStatus.Builder();
                    builder.has_forum_rule = pVar.dOp().has_forum_rule;
                    builder.forum_rule_id = pVar.dOp().forum_rule_id;
                    builder.title = pVar.dOp().title;
                    builder.audit_status = 1;
                    pVar.b(builder.build(true));
                }
                eVar.setData(data);
                eVar.notifyDataSetChanged();
            }
        }
    }
}
