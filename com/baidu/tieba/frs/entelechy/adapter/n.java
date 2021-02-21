package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class n extends com.baidu.tieba.frs.k<ca, ThreadCardViewHolder<cb>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String aif;
    private NEGFeedBackView.a hnH;
    private com.baidu.tieba.card.ab<cb> hnd;
    private int jqD;
    private boolean jre;
    private String mFrom;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jre = false;
        this.jqD = 3;
        this.hnd = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if (n.this.jga != null) {
                        n.this.jga.a(view, (View) cbVar, (Object) n.this.getType());
                    }
                    if ("c13010".equals(n.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ap("obj_type", 1).v("fid", cbVar.getFid()).dR("tid", cbVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 2, n.this.mPageId, com.baidu.tieba.frs.b.d.jqE, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 5, n.this.mPageId, com.baidu.tieba.frs.b.d.jqE, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 14, n.this.mPageId, com.baidu.tieba.frs.b.d.jqE, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 12, n.this.mPageId, com.baidu.tieba.frs.b.d.jqE, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 13, n.this.mPageId, com.baidu.tieba.frs.b.d.jqE, n.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (n.this.hnd.ajn instanceof Boolean) {
                            if (((Boolean) n.this.hnd.ajn).booleanValue()) {
                                com.baidu.tieba.frs.b.a.a(cbVar, 1, n.this.mPageId, com.baidu.tieba.frs.b.d.jqE, n.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.b.a.a(cbVar, 3, n.this.mPageId, com.baidu.tieba.frs.b.d.jqE, n.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 15, n.this.mPageId, com.baidu.tieba.frs.b.d.jqE, n.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(cbVar, 1, n.this.mPageId, com.baidu.tieba.frs.b.d.jqE, n.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && cbVar.bmv()) {
                        n.this.as(cbVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(com.baidu.tieba.frs.b.d.jqE, cbVar.blo());
                    } else if (view instanceof TbImageView) {
                        if (n.this.hnd.ajn instanceof Boolean) {
                            if (((Boolean) n.this.hnd.ajn).booleanValue()) {
                                com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, 1);
                            } else {
                                com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (cbVar.bpv() != null && cbVar.bpv().dNH() != null && cbVar.bpv().dNH().bHz() != null && cbVar.bpv().dNH().bHz().size() > 0) {
                            i = cbVar.bpv().nxE ? 9 : 8;
                        }
                        com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, i);
                    } else {
                        com.baidu.tieba.frs.b.c.cKl().a(com.baidu.tieba.frs.b.d.jqE, cbVar, 1);
                    }
                }
            }
        };
        this.hnH = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.n.4
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(av avVar) {
                TiebaStatic.log(new ar("c11973").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
                if (arrayList != null && avVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + ",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ar("c11974").dR("obj_locate", sb.toString()).dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmo()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", avVar.source).dR("weight", avVar.weight).dR("ab_tag", avVar.abTag).dR("extra", avVar.extra).ap(IntentConfig.CARD_TYPE, avVar.cardType).ap("obj_floor", avVar.eOs));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<cb> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = this.jre ? 10 : 2;
        eVar.eMg = 2;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(2);
        amVar.setStType("frs_page");
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(3);
        amVar.bq(48);
        aVar.b(amVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.iLY);
        a2.setSourceForPb(3);
        ThreadCardViewHolder<cb> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        threadCardViewHolder.aL(true);
        threadCardViewHolder.b(4, aVar.ti());
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.n.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = ((ca) nVar).eJQ;
                    cbVar.objType = 1;
                    if (n.this.hnd != null) {
                        n.this.hnd.a(threadCardViewHolder2.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), n.this.jqD, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, ca caVar, ThreadCardViewHolder threadCardViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) caVar, (ca) threadCardViewHolder);
        if (caVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.tj().setPage(this.aif);
        threadCardViewHolder.tj().setPosition(i);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tj().td(), this.jfU);
        if (caVar.eJQ.getType() == cb.eRd) {
            threadCardViewHolder.tj().td().bq(128);
        } else {
            threadCardViewHolder.tj().td().br(128);
        }
        if (this.jfU != null && this.jfU.getForum() != null && !StringUtils.isNull(this.jfU.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jfU.getForum().getTopic_special_icon_right())) {
            caVar.eJQ.dD(this.jfU.getForum().getTopic_special_icon(), this.jfU.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.a(false, Align.ALIGN_RIGHT_BOTTOM, this.hnH);
        if (threadCardViewHolder.tj().td() instanceof am) {
            ((am) threadCardViewHolder.tj().td()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.n.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup, view, i));
                    }
                }
            });
        }
        threadCardViewHolder.b((ThreadCardViewHolder) caVar.eJQ);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.hnd);
        caVar.eJQ.bpd();
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
        this.jqD = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void pD(boolean z) {
        this.jre = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return jqE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(cb cbVar) {
        TiebaStatic.log(new ar("c12126").dR("tid", cbVar.getId()).ap("obj_locate", cCn() ? 2 : 1).v("obj_id", cbVar.boj() == null ? -1L : cbVar.boj().live_id).ap("obj_type", 1));
    }
}
