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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
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
    private ForumData fEm;
    private FrsFoldingView jLS;
    private com.baidu.tieba.frs.ad.g jLT;
    private boolean jLU;
    private List<View> jLV;
    private List<com.baidu.tieba.frs.view.e> jLW;
    private ArrayList<Boolean> jLX;
    private w jhT;
    private aw jpN;
    private com.baidu.tieba.frs.b.b jqq;
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
        this.jLU = false;
        this.mForumName = "";
        this.mForumId = "";
        this.mFrom = "";
        this.textColor = 0;
        this.url = null;
        this.jLV = new ArrayList();
        this.jLW = new ArrayList();
        this.topThreadList = new ArrayList();
        this.jqq = new com.baidu.tieba.frs.b.b();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.jLS = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.n> list, com.baidu.tieba.tbadkCore.i iVar) {
        this.topThreadList.clear();
        this.jLW.clear();
        this.jLV.clear();
        if (y.isEmpty(list) && iVar == null) {
            setVisibility(8);
            return;
        }
        if (iVar != null) {
            a(iVar);
        }
        if (!y.isEmpty(list)) {
            if (list.size() > 6) {
                list = list.subList(0, 6);
            }
            this.topThreadList.addAll(list);
            int i = this.topThreadList.size() <= 2 ? 1 : 2;
            for (int i2 = 0; i2 < i; i2++) {
                cLU();
                com.baidu.tieba.frs.view.e eVar = this.jLW.get(i2);
                if (eVar != null) {
                    if (this.jhT == null) {
                        this.jhT = new a();
                    }
                    eVar.d(this.jhT);
                    eVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 4) + 2, this.topThreadList.size())));
                }
            }
        }
        if (this.jLX == null && this.jLV != null) {
            this.jLX = new ArrayList<>(Collections.nCopies(this.jLV.size(), Boolean.FALSE));
        }
        cLV();
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar) {
        int i = 6;
        if (iVar != null) {
            if (this.jLT == null) {
                this.jLT = new com.baidu.tieba.frs.ad.g(getContext());
                addView(this.jLT.getView());
            }
            this.jLT.a(this.fEm, iVar);
            if (!this.jLU) {
                this.jLU = true;
                ar arVar = new ar("common_exp");
                arVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
                arVar.dR("obj_isad", "1");
                if (iVar.getType() != 1) {
                    if (iVar.getType() == 2) {
                        i = 7;
                    } else if (iVar.getType() == 3) {
                        i = 8;
                    }
                }
                arVar.ap("obj_floor", 1);
                arVar.ap("obj_adlocate", i);
                arVar.v("obj_id", iVar.getId());
                if (this.fEm != null) {
                    arVar.dR("fid", this.fEm.getId());
                    arVar.dR("first_dir", this.fEm.getFirst_class());
                    arVar.dR("second_dir", this.fEm.getSecond_class());
                }
                if (iVar.getType() == 1) {
                    arVar.dR("tid", iVar.getThreadId());
                    arVar.ap("thread_type", iVar.getThreadType());
                }
                TiebaStatic.log(arVar);
            }
        }
    }

    private void cLU() {
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
        adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        adapterLinearLayout.setOrientation(1);
        com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(getContext());
        eVar.a(this.mForumId, this.mForumName, this.mUserData);
        eVar.a(this.fEm);
        eVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            eVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            eVar.Bf(this.textColor);
        }
        adapterLinearLayout.setAdapter(eVar);
        this.jLV.add(adapterLinearLayout);
        this.jLW.add(eVar);
    }

    public void setStatListener(aw awVar) {
        this.jpN = awVar;
    }

    private void cLV() {
        if (!y.isEmpty(this.jLV)) {
            setVisibility(0);
            if (this.jLS != null) {
                this.jLS.setViews(this.jLV, this.jLW);
            }
        }
    }

    public void onChangeSkinType(int i) {
        for (com.baidu.tieba.frs.view.e eVar : this.jLW) {
            eVar.notifyDataSetChanged();
        }
        if (this.jLS != null) {
            this.jLS.onChangeSkinType();
        }
    }

    /* loaded from: classes2.dex */
    private final class a implements w {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (nVar != null && (nVar instanceof cb)) {
                    cb cbVar = (cb) nVar;
                    if (cbVar.boR() == null || cbVar.boR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsTopView.this.getContext())) {
                        if (cbVar.boC() != 1 || bh.checkUpIsLogin(FrsTopView.this.getContext())) {
                            if (cbVar.boc() != null) {
                                if (bh.checkUpIsLogin(FrsTopView.this.getContext())) {
                                    String postUrl = cbVar.boc().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.getContext(), postUrl);
                                    }
                                }
                            } else if (cbVar.bpc() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bh.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                    return;
                                }
                                t bpc = cbVar.bpc();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), bpc.getCartoonId(), bpc.getChapterId(), 2)));
                            } else {
                                boolean z = false;
                                final String bnW = cbVar.bnW();
                                if (bnW != null && !bnW.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            aa aaVar = new aa(bnW);
                                            aaVar.bsr().bta().mIsNeedAddCommenParam = false;
                                            aaVar.bsr().bta().mIsUseCurrentBDUSS = false;
                                            aaVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = cbVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (cbVar.bnL() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    bf.bsV().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(tid) && tid.length() > 3) {
                                    cbVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == cb.eSp.getId()) {
                                    com.baidu.tieba.frs.d.k.a(cbVar.bnw());
                                } else if (bdUniqueId.getId() == cb.eQP.getId()) {
                                    ar arVar = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    arVar.dR("obj_type", "2");
                                    arVar.dR("tid", cbVar.getTid());
                                    TiebaStatic.log(arVar);
                                }
                                FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), cbVar, i, z);
                                if (FrsTopView.this.jpN != null) {
                                    FrsTopView.this.jpN.ap(cbVar);
                                }
                            }
                        }
                    }
                } else if (nVar != null && (nVar instanceof p)) {
                    FrsTopView.this.a(((p) nVar).dMI());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumRuleStatus forumRuleStatus) {
        int i;
        if (forumRuleStatus != null && this.mUserData != null && this.fEm != null) {
            if ((com.baidu.adp.base.b.kB().bo("ForumRulesEditActivity") || com.baidu.tbadk.k.d.bCB().bCC()) && this.mUserData.getIs_manager() == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921518, ""));
                return;
            }
            if (this.mUserData.getIs_manager() == 1 && forumRuleStatus.has_forum_rule.intValue() == 0 && forumRuleStatus.audit_status.intValue() == 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(getContext(), this.mForumId, this.mForumName, ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS, this.fEm != null ? this.fEm.getImage_url() : "", this.fEm != null ? this.fEm.getUser_level() : 0, RequestResponseCode.REQUEST_MOBILE_MODIFY_NICKNAME_DIALOG)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(getContext(), this.mForumId, "")));
            }
            ar arVar = new ar("c14027");
            arVar.dR("fid", this.mForumId);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            if (this.mUserData.getIs_manager() == 1) {
                i = 1;
            } else if (this.mUserData.getIs_manager() == 2) {
                i = 2;
            } else if (this.fEm.isLike() == 1) {
                i = 3;
            } else {
                i = 4;
            }
            arVar.ap("obj_type", i);
            TiebaStatic.log(arVar);
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
        this.fEm = forumData;
        this.mUserData = userData;
        this.mFrom = str3;
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, cb cbVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (baseFragmentActivity != null && cbVar != null) {
            String valueOf = String.valueOf(cbVar.getFid());
            if (cbVar.eTn == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = cbVar.eTn.id;
                str2 = valueOf;
            }
            if (cbVar.bom() > 0 && com.baidu.tieba.tbadkCore.util.e.dON()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(cbVar.getTid(), String.valueOf(cbVar.bom()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(cbVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(cbVar.bph());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (cbVar.boY() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        this.textColor = i;
        for (com.baidu.tieba.frs.view.e eVar : this.jLW) {
            if (str != null) {
                eVar.setImageUrl(str);
                this.url = str;
            }
            eVar.Bf(i);
            eVar.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jqq;
    }

    public List<View> getmTopViews() {
        if (this.jLV == null || this.jLV.size() == 0) {
            return null;
        }
        return this.jLV;
    }

    public void AK(int i) {
        com.baidu.tieba.frs.view.e eVar;
        if (i != -1 && this.jLW.size() > i && (eVar = this.jLW.get(0)) != null) {
            new ArrayList();
            List<com.baidu.adp.widget.ListView.n> data = eVar.getData();
            if (data != null && data.size() > i && (data.get(i) instanceof p)) {
                p pVar = (p) data.get(i);
                if (pVar != null) {
                    ForumRuleStatus.Builder builder = new ForumRuleStatus.Builder();
                    builder.has_forum_rule = pVar.dMI().has_forum_rule;
                    builder.forum_rule_id = pVar.dMI().forum_rule_id;
                    builder.title = pVar.dMI().title;
                    builder.audit_status = 1;
                    pVar.b(builder.build(true));
                }
                eVar.setData(data);
                eVar.notifyDataSetChanged();
            }
        }
    }
}
