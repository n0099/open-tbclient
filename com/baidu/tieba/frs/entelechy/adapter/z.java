package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class z extends com.baidu.tieba.frs.k<by, ThreadCardViewHolder<bz>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.b.d {
    private String aji;
    private boolean alQ;
    private com.baidu.tieba.card.aa<bz> hni;
    private int jpm;
    private String mFrom;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.alQ = true;
        this.hni = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if (z.this.jeN != null) {
                        z.this.jeN.a(view, (View) bzVar, (Object) z.this.getType());
                    }
                    if ("c13010".equals(z.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").an("obj_type", 1).w("fid", bzVar.getFid()).dX("tid", bzVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 2, z.this.mPageId, com.baidu.tieba.frs.b.d.jpq, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 5, z.this.mPageId, com.baidu.tieba.frs.b.d.jpq, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 14, z.this.mPageId, com.baidu.tieba.frs.b.d.jpq, z.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (z.this.hni.akp instanceof Boolean) {
                            if (((Boolean) z.this.hni.akp).booleanValue()) {
                                com.baidu.tieba.frs.b.a.a(bzVar, 1, z.this.mPageId, com.baidu.tieba.frs.b.d.jpq, z.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.b.a.a(bzVar, 3, z.this.mPageId, com.baidu.tieba.frs.b.d.jpq, z.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 15, z.this.mPageId, com.baidu.tieba.frs.b.d.jpq, z.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(bzVar, 1, z.this.mPageId, com.baidu.tieba.frs.b.d.jpq, z.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cMI().a(com.baidu.tieba.frs.b.d.jpq, bzVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(com.baidu.tieba.frs.b.d.jpq, bzVar.boP());
                    } else if (view instanceof TbImageView) {
                        if (z.this.hni.akp instanceof Boolean) {
                            if (((Boolean) z.this.hni.akp).booleanValue()) {
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
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<bz> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.y yVar = new com.baidu.card.y(this.mPageContext.getPageActivity());
        yVar.setFrom("frs");
        yVar.setFromCDN(this.alQ);
        if (this.jpm == 502) {
            yVar.setNeedFrsTabName(false);
        } else {
            yVar.setNeedFrsTabName(true);
        }
        aVar.c(yVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.iKI);
        a2.setSourceForPb(3);
        ThreadCardViewHolder<bz> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        threadCardViewHolder.aL(false);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.z.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar).eMv;
                    bzVar.objType = 1;
                    if (z.this.hni != null) {
                        z.this.hni.a(threadCardViewHolder2.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), 3, false);
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, ThreadCardViewHolder<bz> threadCardViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) threadCardViewHolder);
        if (byVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.ty().setPage(this.aji);
        threadCardViewHolder.ty().setPosition(i);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.ty().ts(), this.jeH);
        if (this.jeH != null && this.jeH.getForum() != null && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon_right())) {
            byVar.eMv.dK(this.jeH.getForum().getTopic_special_icon(), this.jeH.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.b((ThreadCardViewHolder<bz>) byVar.eMv);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.hni);
        byVar.eMv.bsE();
        com.baidu.card.y yVar = (com.baidu.card.y) threadCardViewHolder.ty().tr();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.aiw.amp.getLayoutParams();
        layoutParams.width = byVar.eSI;
        layoutParams.height = byVar.eSJ;
        if (yVar.aiw.amp.getVisibility() != 8) {
            yVar.aiw.amp.setLayoutParams(layoutParams);
        }
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.alQ = z;
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
        this.jpm = i;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return jpq;
    }
}
