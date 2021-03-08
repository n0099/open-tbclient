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
    private ForumData fFL;
    private FrsFoldingView jNP;
    private com.baidu.tieba.frs.ad.g jNQ;
    private boolean jNR;
    private List<View> jNS;
    private List<com.baidu.tieba.frs.view.e> jNT;
    private ArrayList<Boolean> jNU;
    private w jjR;
    private aw jrK;
    private com.baidu.tieba.frs.b.b jsn;
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
        this.jNR = false;
        this.mForumName = "";
        this.mForumId = "";
        this.mFrom = "";
        this.textColor = 0;
        this.url = null;
        this.jNS = new ArrayList();
        this.jNT = new ArrayList();
        this.topThreadList = new ArrayList();
        this.jsn = new com.baidu.tieba.frs.b.b();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_top_view_layout, (ViewGroup) this, true);
        this.jNP = (FrsFoldingView) findViewById(R.id.frs_folding_layout);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.n> list, com.baidu.tieba.tbadkCore.i iVar) {
        this.topThreadList.clear();
        this.jNT.clear();
        this.jNS.clear();
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
                cMh();
                com.baidu.tieba.frs.view.e eVar = this.jNT.get(i2);
                if (eVar != null) {
                    if (this.jjR == null) {
                        this.jjR = new a();
                    }
                    eVar.d(this.jjR);
                    eVar.setData(this.topThreadList.subList(i2 * 2, Math.min((i2 * 4) + 2, this.topThreadList.size())));
                }
            }
        }
        if (this.jNU == null && this.jNS != null) {
            this.jNU = new ArrayList<>(Collections.nCopies(this.jNS.size(), Boolean.FALSE));
        }
        cMi();
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar) {
        int i = 6;
        if (iVar != null) {
            if (this.jNQ == null) {
                this.jNQ = new com.baidu.tieba.frs.ad.g(getContext());
                addView(this.jNQ.getView());
            }
            this.jNQ.a(this.fFL, iVar);
            if (!this.jNR) {
                this.jNR = true;
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
                arVar.aq("obj_floor", 1);
                arVar.aq("obj_adlocate", i);
                arVar.v("obj_id", iVar.getId());
                if (this.fFL != null) {
                    arVar.dR("fid", this.fFL.getId());
                    arVar.dR("first_dir", this.fFL.getFirst_class());
                    arVar.dR("second_dir", this.fFL.getSecond_class());
                }
                if (iVar.getType() == 1) {
                    arVar.dR("tid", iVar.getThreadId());
                    arVar.aq("thread_type", iVar.getThreadType());
                }
                TiebaStatic.log(arVar);
            }
        }
    }

    private void cMh() {
        AdapterLinearLayout adapterLinearLayout = new AdapterLinearLayout(getContext());
        adapterLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        adapterLinearLayout.setOrientation(1);
        com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(getContext());
        eVar.a(this.mForumId, this.mForumName, this.mUserData);
        eVar.a(this.fFL);
        eVar.setBdUniqueId(this.mBdUniqueId);
        if (this.url != null) {
            eVar.setImageUrl(this.url);
        }
        if (this.textColor != 0) {
            eVar.Bg(this.textColor);
        }
        adapterLinearLayout.setAdapter(eVar);
        this.jNS.add(adapterLinearLayout);
        this.jNT.add(eVar);
    }

    public void setStatListener(aw awVar) {
        this.jrK = awVar;
    }

    private void cMi() {
        if (!y.isEmpty(this.jNS)) {
            setVisibility(0);
            if (this.jNP != null) {
                this.jNP.setViews(this.jNS, this.jNT);
            }
        }
    }

    public void onChangeSkinType(int i) {
        for (com.baidu.tieba.frs.view.e eVar : this.jNT) {
            eVar.notifyDataSetChanged();
        }
        if (this.jNP != null) {
            this.jNP.onChangeSkinType();
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
                    if (cbVar.boT() == null || cbVar.boT().getGroup_id() == 0 || bh.checkUpIsLogin(FrsTopView.this.getContext())) {
                        if (cbVar.boE() != 1 || bh.checkUpIsLogin(FrsTopView.this.getContext())) {
                            if (cbVar.boe() != null) {
                                if (bh.checkUpIsLogin(FrsTopView.this.getContext())) {
                                    String postUrl = cbVar.boe().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsTopView.this.getContext(), postUrl);
                                    }
                                }
                            } else if (cbVar.bpe() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bh.skipToLoginActivity(FrsTopView.this.getTbPageContext().getPageActivity());
                                    return;
                                }
                                t bpe = cbVar.bpe();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsTopView.this.getTbPageContext().getPageActivity(), bpe.getCartoonId(), bpe.getChapterId(), 2)));
                            } else {
                                boolean z = false;
                                final String bnY = cbVar.bnY();
                                if (bnY != null && !bnY.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.vc.FrsTopView.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            aa aaVar = new aa(bnY);
                                            aaVar.bsu().btd().mIsNeedAddCommenParam = false;
                                            aaVar.bsu().btd().mIsUseCurrentBDUSS = false;
                                            aaVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = cbVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (cbVar.bnN() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    bf.bsY().b(FrsTopView.this.getTbPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && !TextUtils.isEmpty(tid) && tid.length() > 3) {
                                    cbVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == cb.eTQ.getId()) {
                                    com.baidu.tieba.frs.d.k.a(cbVar.bny());
                                } else if (bdUniqueId.getId() == cb.eSq.getId()) {
                                    ar arVar = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    arVar.dR("obj_type", "2");
                                    arVar.dR("tid", cbVar.getTid());
                                    TiebaStatic.log(arVar);
                                }
                                FrsTopView.this.a(FrsTopView.this.getFragmentActivity(), cbVar, i, z);
                                if (FrsTopView.this.jrK != null) {
                                    FrsTopView.this.jrK.ap(cbVar);
                                }
                            }
                        }
                    }
                } else if (nVar != null && (nVar instanceof p)) {
                    FrsTopView.this.a(((p) nVar).dMY());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumRuleStatus forumRuleStatus) {
        int i;
        if (forumRuleStatus != null && this.mUserData != null && this.fFL != null) {
            if ((com.baidu.adp.base.b.kB().bs("ForumRulesEditActivity") || com.baidu.tbadk.k.d.bCE().bCF()) && this.mUserData.getIs_manager() == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921518, ""));
                return;
            }
            if (this.mUserData.getIs_manager() == 1 && forumRuleStatus.has_forum_rule.intValue() == 0 && forumRuleStatus.audit_status.intValue() == 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(getContext(), this.mForumId, this.mForumName, ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS, this.fFL != null ? this.fFL.getImage_url() : "", this.fFL != null ? this.fFL.getUser_level() : 0, RequestResponseCode.REQUEST_MOBILE_MODIFY_NICKNAME_DIALOG)));
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
            } else if (this.fFL.isLike() == 1) {
                i = 3;
            } else {
                i = 4;
            }
            arVar.aq("obj_type", i);
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
        this.fFL = forumData;
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
            if (cbVar.eUO == null) {
                str = valueOf;
                str2 = null;
            } else {
                str = cbVar.eUO.id;
                str2 = valueOf;
            }
            if (cbVar.boo() > 0 && com.baidu.tieba.tbadkCore.util.e.dPe()) {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createHistoryCfg(cbVar.getTid(), String.valueOf(cbVar.boo()), false, true, "frs_page");
            } else {
                createFromThreadCfg = new PbActivityConfig(baseFragmentActivity).createFromThreadCfg(cbVar, this.mForumName, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, z);
            }
            if (i == 4) {
                createFromThreadCfg.setVideo_source(ConstantData.VideoLocationType.FRS_5FLOOR);
            } else {
                createFromThreadCfg.setVideo_source("frs");
            }
            createFromThreadCfg.setFromSmartFrs(cbVar.bpj());
            createFromThreadCfg.setSmartFrsPosition(i);
            createFromThreadCfg.setForumId(str);
            createFromThreadCfg.setFromForumId(str2);
            createFromThreadCfg.setStartFrom(3);
            createFromThreadCfg.setFrom("from_frs");
            if (cbVar.bpa() && createFromThreadCfg.getIntent() != null) {
                createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            baseFragmentActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void setUrlAndColor(String str, int i) {
        this.textColor = i;
        for (com.baidu.tieba.frs.view.e eVar : this.jNT) {
            if (str != null) {
                eVar.setImageUrl(str);
                this.url = str;
            }
            eVar.Bg(i);
            eVar.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jsn;
    }

    public List<View> getmTopViews() {
        if (this.jNS == null || this.jNS.size() == 0) {
            return null;
        }
        return this.jNS;
    }

    public void AL(int i) {
        com.baidu.tieba.frs.view.e eVar;
        if (i != -1 && this.jNT.size() > i && (eVar = this.jNT.get(0)) != null) {
            new ArrayList();
            List<com.baidu.adp.widget.ListView.n> data = eVar.getData();
            if (data != null && data.size() > i && (data.get(i) instanceof p)) {
                p pVar = (p) data.get(i);
                if (pVar != null) {
                    ForumRuleStatus.Builder builder = new ForumRuleStatus.Builder();
                    builder.has_forum_rule = pVar.dMY().has_forum_rule;
                    builder.forum_rule_id = pVar.dMY().forum_rule_id;
                    builder.title = pVar.dMY().title;
                    builder.audit_status = 1;
                    pVar.b(builder.build(true));
                }
                eVar.setData(data);
                eVar.notifyDataSetChanged();
            }
        }
    }
}
