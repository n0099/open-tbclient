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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.s;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.view.AdapterLinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tbclient.ForumRuleStatus;
/* loaded from: classes22.dex */
public class FrsTopView extends LinearLayout {
    private ForumData fxa;
    private ab iUG;
    private com.baidu.tieba.frs.d.b jcS;
    private az jct;
    private FrsFoldingView jyt;
    private com.baidu.tieba.frs.ad.g jyu;
    private boolean jyv;
    private List<View> jyw;
    private List<com.baidu.tieba.frs.view.g> jyx;
    private ArrayList<Boolean> jyy;
    private BdUniqueId mBdUniqueId;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private UserData mUserData;
    private int textColor;
    private List<q> topThreadList;
    private String url;

    public FrsTopView(Context context) {
        this(context, null);
    }

    public FrsTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jyv = false;
        this.mForumName = "";
        this.mForumId = "";
        this.mFrom = "";
        this.textColor = 0;
        this.url = null;
        this.jyw = new ArrayList();
        this.jyx = new ArrayList();
        this.topThreadList = new ArrayList();
        this.jcS = new com.baidu.tieba.frs.d.b();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.jyt = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public void setDatas(List<q> list, com.baidu.tieba.tbadkCore.i iVar) {
        this.topThreadList.clear();
        this.jyx.clear();
        this.jyw.clear();
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
                cLt();
                com.baidu.tieba.frs.view.g gVar = this.jyx.get(i2);
                if (gVar != null) {
                    if (this.iUG == null) {
                        this.iUG = new a();
                    }
                    gVar.d(this.iUG);
                    gVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 4) + 2, this.topThreadList.size())));
                }
            }
        }
        if (this.jyy == null && this.jyw != null) {
            this.jyy = new ArrayList<>(Collections.nCopies(this.jyw.size(), Boolean.FALSE));
        }
        cLu();
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar) {
        int i = 6;
        if (iVar != null) {
            if (this.jyu == null) {
                this.jyu = new com.baidu.tieba.frs.ad.g(getContext());
                addView(this.jyu.getView());
            }
            this.jyu.a(this.fxa, iVar);
            if (!this.jyv) {
                this.jyv = true;
                ar arVar = new ar("common_exp");
                arVar.dY("page_type", PageStayDurationConstants.PageName.FRS);
                arVar.dY("obj_isad", "1");
                if (iVar.getType() != 1) {
                    if (iVar.getType() == 2) {
                        i = 7;
                    } else if (iVar.getType() == 3) {
                        i = 8;
                    }
                }
                arVar.al("obj_floor", 1);
                arVar.al("obj_adlocate", i);
                arVar.w("obj_id", iVar.getId());
                if (this.fxa != null) {
                    arVar.dY("fid", this.fxa.getId());
                    arVar.dY("first_dir", this.fxa.getFirst_class());
                    arVar.dY("second_dir", this.fxa.getSecond_class());
                }
                if (iVar.getType() == 1) {
                    arVar.dY("tid", iVar.getThreadId());
                    arVar.al("thread_type", iVar.getThreadType());
                }
                TiebaStatic.log(arVar);
            }
        }
    }

    private void cLt() {
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
        adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        adapterLinearLayout.setOrientation(1);
        com.baidu.tieba.frs.view.g gVar = new com.baidu.tieba.frs.view.g(getContext());
        gVar.a(this.mForumId, this.mForumName, this.mUserData);
        gVar.a(this.fxa);
        gVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            gVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            gVar.Ck(this.textColor);
        }
        adapterLinearLayout.setAdapter(gVar);
        this.jyw.add(adapterLinearLayout);
        this.jyx.add(gVar);
    }

    public void setStatListener(az azVar) {
        this.jct = azVar;
    }

    private void cLu() {
        if (!y.isEmpty(this.jyw)) {
            setVisibility(0);
            if (this.jyt != null) {
                this.jyt.setViews(this.jyw, this.jyx);
            }
        }
    }

    public void onChangeSkinType(int i) {
        for (com.baidu.tieba.frs.view.g gVar : this.jyx) {
            gVar.notifyDataSetChanged();
        }
        if (this.jyt != null) {
            this.jyt.onChangeSkinType();
        }
    }

    /* loaded from: classes22.dex */
    private final class a implements ab {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (qVar != null && (qVar instanceof by)) {
                    by byVar = (by) qVar;
                    if (byVar.bpR() == null || byVar.bpR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsTopView.this.getContext())) {
                        if (byVar.bpC() != 1 || bh.checkUpIsLogin(FrsTopView.this.getContext())) {
                            if (byVar.bpb() != null) {
                                if (bh.checkUpIsLogin(FrsTopView.this.getContext())) {
                                    String postUrl = byVar.bpb().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.getContext(), postUrl);
                                    }
                                }
                            } else if (byVar.bqc() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bh.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                    return;
                                }
                                s bqc = byVar.bqc();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), bqc.getCartoonId(), bqc.getChapterId(), 2)));
                            } else {
                                boolean z = false;
                                final String boV = byVar.boV();
                                if (boV != null && !boV.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            aa aaVar = new aa(boV);
                                            aaVar.btv().bue().mIsNeedAddCommenParam = false;
                                            aaVar.btv().bue().mIsUseCurrentBDUSS = false;
                                            aaVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = byVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (byVar.boK() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    bf.bua().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(tid) && tid.length() > 3) {
                                    byVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == by.eKU.getId()) {
                                    com.baidu.tieba.frs.f.k.a(byVar.bov());
                                } else if (bdUniqueId.getId() == by.eJv.getId()) {
                                    ar arVar = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    arVar.dY("obj_type", "2");
                                    arVar.dY("tid", byVar.getTid());
                                    TiebaStatic.log(arVar);
                                }
                                FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), byVar, i, z);
                                if (FrsTopView.this.jct != null) {
                                    FrsTopView.this.jct.ao(byVar);
                                }
                            }
                        }
                    }
                } else if (qVar != null && (qVar instanceof p)) {
                    FrsTopView.this.a(((p) qVar).dOv());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumRuleStatus forumRuleStatus) {
        int i;
        if (forumRuleStatus != null && this.mUserData != null && this.fxa != null) {
            if ((com.baidu.adp.base.a.lg().bt("ForumRulesEditActivity") || com.baidu.tbadk.k.d.bDH().bDI()) && this.mUserData.getIs_manager() == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921518, ""));
                return;
            }
            if (this.mUserData.getIs_manager() == 1 && forumRuleStatus.has_forum_rule.intValue() == 0 && forumRuleStatus.audit_status.intValue() == 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(getContext(), this.mForumId, this.mForumName, ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS, this.fxa != null ? this.fxa.getImage_url() : "", this.fxa != null ? this.fxa.getUser_level() : 0, RequestResponseCode.REQUEST_MOBILE_MODIFY_NICKNAME_DIALOG)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(getContext(), this.mForumId, "")));
            }
            ar arVar = new ar("c14027");
            arVar.dY("fid", this.mForumId);
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            if (this.mUserData.getIs_manager() == 1) {
                i = 1;
            } else if (this.mUserData.getIs_manager() == 2) {
                i = 2;
            } else if (this.fxa.isLike() == 1) {
                i = 3;
            } else {
                i = 4;
            }
            arVar.al("obj_type", i);
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
        this.fxa = forumData;
        this.mUserData = userData;
        this.mFrom = str3;
    }

    public void setFragmentUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void a(BaseFragmentActivity baseFragmentActivity, by byVar, int i, boolean z) {
        String str;
        String str2;
        PbActivityConfig createFromThreadCfg;
        if (baseFragmentActivity != null && byVar != null) {
            String valueOf = String.valueOf(byVar.getFid());
            if (byVar.eLS == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = byVar.eLS.id;
                str2 = valueOf;
            }
            if (byVar.bpm() > 0 && com.baidu.tieba.tbadkCore.util.e.dQw()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(byVar.getTid(), String.valueOf(byVar.bpm()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(byVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(byVar.bqg());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (byVar.bpY() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        this.textColor = i;
        for (com.baidu.tieba.frs.view.g gVar : this.jyx) {
            if (str != null) {
                gVar.setImageUrl(str);
                this.url = str;
            }
            gVar.Ck(i);
            gVar.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.jcS;
    }

    public List<View> getmTopViews() {
        if (this.jyw == null || this.jyw.size() == 0) {
            return null;
        }
        return this.jyw;
    }

    public void BU(int i) {
        com.baidu.tieba.frs.view.g gVar;
        if (i != -1 && this.jyx.size() > i && (gVar = this.jyx.get(0)) != null) {
            new ArrayList();
            List<q> data = gVar.getData();
            if (data != null && data.size() > i && (data.get(i) instanceof p)) {
                p pVar = (p) data.get(i);
                if (pVar != null) {
                    ForumRuleStatus.Builder builder = new ForumRuleStatus.Builder();
                    builder.has_forum_rule = pVar.dOv().has_forum_rule;
                    builder.forum_rule_id = pVar.dOv().forum_rule_id;
                    builder.title = pVar.dOv().title;
                    builder.audit_status = 1;
                    pVar.b(builder.build(true));
                }
                gVar.setData(data);
                gVar.notifyDataSetChanged();
            }
        }
    }
}
