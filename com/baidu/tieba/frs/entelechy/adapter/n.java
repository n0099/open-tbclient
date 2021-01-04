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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class n extends com.baidu.tieba.frs.k<by, ThreadCardViewHolder<bz>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String aji;
    private NEGFeedBackView.a hnM;
    private com.baidu.tieba.card.aa<bz> hni;
    private boolean jpQ;
    private int jpp;
    private String mFrom;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jpQ = false;
        this.jpp = 3;
        this.hni = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if (n.this.jeN != null) {
                        n.this.jeN.a(view, (View) bzVar, (Object) n.this.getType());
                    }
                    if ("c13010".equals(n.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").an("obj_type", 1).w("fid", bzVar.getFid()).dX("tid", bzVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 2, n.this.mPageId, com.baidu.tieba.frs.b.d.jpq, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 5, n.this.mPageId, com.baidu.tieba.frs.b.d.jpq, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 14, n.this.mPageId, com.baidu.tieba.frs.b.d.jpq, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 12, n.this.mPageId, com.baidu.tieba.frs.b.d.jpq, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 13, n.this.mPageId, com.baidu.tieba.frs.b.d.jpq, n.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (n.this.hni.akp instanceof Boolean) {
                            if (((Boolean) n.this.hni.akp).booleanValue()) {
                                com.baidu.tieba.frs.b.a.a(bzVar, 1, n.this.mPageId, com.baidu.tieba.frs.b.d.jpq, n.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.b.a.a(bzVar, 3, n.this.mPageId, com.baidu.tieba.frs.b.d.jpq, n.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 15, n.this.mPageId, com.baidu.tieba.frs.b.d.jpq, n.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(bzVar, 1, n.this.mPageId, com.baidu.tieba.frs.b.d.jpq, n.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bzVar.bpV()) {
                        n.this.as(bzVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cMI().a(com.baidu.tieba.frs.b.d.jpq, bzVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(com.baidu.tieba.frs.b.d.jpq, bzVar.boP());
                    } else if (view instanceof TbImageView) {
                        if (n.this.hni.akp instanceof Boolean) {
                            if (((Boolean) n.this.hni.akp).booleanValue()) {
                                com.baidu.tieba.frs.b.c.cMI().a(com.baidu.tieba.frs.b.d.jpq, bzVar, 1);
                            } else {
                                com.baidu.tieba.frs.b.c.cMI().a(com.baidu.tieba.frs.b.d.jpq, bzVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.b.c.cMI().a(com.baidu.tieba.frs.b.d.jpq, bzVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bzVar.bsW() != null && bzVar.bsW().dPf() != null && bzVar.bsW().dPf().bKW() != null && bzVar.bsW().dPf().bKW().size() > 0) {
                            i = bzVar.bsW().nsb ? 9 : 8;
                        }
                        com.baidu.tieba.frs.b.c.cMI().a(com.baidu.tieba.frs.b.d.jpq, bzVar, i);
                    } else {
                        com.baidu.tieba.frs.b.c.cMI().a(com.baidu.tieba.frs.b.d.jpq, bzVar, 1);
                    }
                }
            }
        };
        this.hnM = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.n.4
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                TiebaStatic.log(new aq("c11973").dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                if (arrayList != null && atVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + ",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new aq("c11974").dX("obj_locate", sb.toString()).dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX(IntentConfig.NID, atVar.bpO()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("source", atVar.source).dX("weight", atVar.weight).dX("ab_tag", atVar.abTag).dX("extra", atVar.extra).an(IntentConfig.CARD_TYPE, atVar.cardType).an("obj_floor", atVar.eQR));
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
    public ThreadCardViewHolder<bz> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eOz = this.jpQ ? 10 : 2;
        dVar.eOF = 2;
        amVar.setAgreeStatisticData(dVar);
        amVar.setFrom(2);
        amVar.setStType("frs_page");
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(3);
        amVar.bs(48);
        aVar.b(amVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.iKI);
        a2.setSourceForPb(3);
        ThreadCardViewHolder<bz> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        threadCardViewHolder.aL(true);
        threadCardViewHolder.b(4, aVar.tx());
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.n.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar).eMv;
                    bzVar.objType = 1;
                    if (n.this.hni != null) {
                        n.this.hni.a(threadCardViewHolder2.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), n.this.jpp, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, by byVar, ThreadCardViewHolder threadCardViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) threadCardViewHolder);
        if (byVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.ty().setPage(this.aji);
        threadCardViewHolder.ty().setPosition(i);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.ty().ts(), this.jeH);
        if (byVar.eMv.getType() == bz.eTC) {
            threadCardViewHolder.ty().ts().bs(128);
        } else {
            threadCardViewHolder.ty().ts().bt(128);
        }
        if (this.jeH != null && this.jeH.getForum() != null && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon_right())) {
            byVar.eMv.dK(this.jeH.getForum().getTopic_special_icon(), this.jeH.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.a(false, Align.ALIGN_RIGHT_BOTTOM, this.hnM);
        if (threadCardViewHolder.ty().ts() instanceof am) {
            ((am) threadCardViewHolder.ty().ts()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.n.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup, view, i));
                    }
                }
            });
        }
        threadCardViewHolder.b((ThreadCardViewHolder) byVar.eMv);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.hni);
        byVar.eMv.bsE();
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fm(String str) {
        this.aji = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
        this.jpp = i;
    }

    @Override // com.baidu.tieba.card.z
    public void px(boolean z) {
        this.jpQ = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return jpq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bz bzVar) {
        TiebaStatic.log(new aq("c12126").dX("tid", bzVar.getId()).an("obj_locate", cEM() ? 2 : 1).w("obj_id", bzVar.brJ() == null ? -1L : bzVar.brJ().live_id).an("obj_type", 1));
    }
}
