package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.d;
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
public class ac extends com.baidu.tieba.frs.k<by, ThreadCardViewHolder<bz>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String aji;
    private com.baidu.tieba.card.aa<bz> hni;
    private int jpp;
    private String mFrom;

    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jpp = 3;
        this.hni = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if (ac.this.jeN != null) {
                        ac.this.jeN.a(view, (View) bzVar, (Object) ac.this.getType());
                    }
                    if ("c13010".equals(ac.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").an("obj_type", 1).w("fid", bzVar.getFid()).dX("tid", bzVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 2, ac.this.mPageId, com.baidu.tieba.frs.b.d.jpq, ac.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (ac.this.hni.akp instanceof Boolean) {
                            if (((Boolean) ac.this.hni.akp).booleanValue()) {
                                com.baidu.tieba.frs.b.a.a(bzVar, 1, ac.this.mPageId, com.baidu.tieba.frs.b.d.jpq, ac.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.b.a.a(bzVar, 3, ac.this.mPageId, com.baidu.tieba.frs.b.d.jpq, ac.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 15, ac.this.mPageId, com.baidu.tieba.frs.b.d.jpq, ac.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(bzVar, 1, ac.this.mPageId, com.baidu.tieba.frs.b.d.jpq, ac.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bzVar.bpW()) {
                        ac.this.as(bzVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cMJ().a(com.baidu.tieba.frs.b.d.jpq, bzVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(com.baidu.tieba.frs.b.d.jpq, bzVar.boQ());
                    } else if (view instanceof TbImageView) {
                        if (ac.this.hni.akp instanceof Boolean) {
                            if (((Boolean) ac.this.hni.akp).booleanValue()) {
                                com.baidu.tieba.frs.b.c.cMJ().a(com.baidu.tieba.frs.b.d.jpq, bzVar, 1);
                            } else {
                                com.baidu.tieba.frs.b.c.cMJ().a(com.baidu.tieba.frs.b.d.jpq, bzVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.b.c.cMJ().a(com.baidu.tieba.frs.b.d.jpq, bzVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bzVar.bsX() != null && bzVar.bsX().dPg() != null && bzVar.bsX().dPg().bKX() != null && bzVar.bsX().dPg().bKX().size() > 0) {
                            i = bzVar.bsX().nsa ? 9 : 8;
                        }
                        com.baidu.tieba.frs.b.c.cMJ().a(com.baidu.tieba.frs.b.d.jpq, bzVar, i);
                    } else {
                        com.baidu.tieba.frs.b.c.cMJ().a(com.baidu.tieba.frs.b.d.jpq, bzVar, 1);
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
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), true);
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bs(4280);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.ac.2
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.a(dVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.TOP, viewGroup, this.iKI);
        a2.setSourceForPb(3);
        ThreadCardViewHolder<bz> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        threadCardViewHolder.aL(false);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.ac.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar).eMv;
                    bzVar.objType = 1;
                    if (ac.this.hni != null) {
                        ac.this.hni.a(threadCardViewHolder2.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), ac.this.jpp, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
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
        threadCardViewHolder.a(true, Align.ALIGN_RIGHT_TOP, null);
        if (!byVar.eMv.isBjh()) {
            threadCardViewHolder.tA();
        }
        threadCardViewHolder.b((ThreadCardViewHolder<bz>) byVar.eMv);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.hni);
        byVar.eMv.bsF();
        if (jpq != null) {
            int i2 = 0;
            if (this.jeH != null) {
                i2 = this.jeH.getTopThreadSize();
            }
            byVar.eMv.eQR = (byVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.b.c.cMJ().a(jpq, byVar.eMv);
        byVar.eMv.bsF();
        com.baidu.tieba.frs.b.a.a(byVar.eMv, this.mPageId, jpq, getTbPageTag());
        if (byVar != null) {
            byVar.eMv.bsF();
        }
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fl(String str) {
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
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return jpq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bz bzVar) {
        TiebaStatic.log(new aq("c12126").dX("tid", bzVar.getId()).an("obj_locate", cEN() ? 2 : 1).w("obj_id", bzVar.brK() == null ? -1L : bzVar.brK().live_id).an("obj_type", 1));
    }
}
