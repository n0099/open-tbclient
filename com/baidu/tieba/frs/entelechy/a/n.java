package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class n extends com.baidu.tieba.frs.h<bj, com.baidu.card.ag<bk>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String aeX;
    private boolean aha;
    private com.baidu.tieba.card.aa<bk> fGi;
    private int hvK;
    private String mFrom;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aha = true;
        this.hvK = 3;
        this.fGi = new com.baidu.tieba.card.aa<bk>() { // from class: com.baidu.tieba.frs.entelechy.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                if (view != null && bkVar != null) {
                    if (n.this.hmX != null) {
                        n.this.hmX.a(view, (View) bkVar, (Object) n.this.getType());
                    }
                    if ("c13010".equals(n.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").ag("obj_type", 1).s("fid", bkVar.getFid()).dh("tid", bkVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 2, n.this.mPageId, com.baidu.tieba.frs.d.d.hvL, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 5, n.this.mPageId, com.baidu.tieba.frs.d.d.hvL, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 14, n.this.mPageId, com.baidu.tieba.frs.d.d.hvL, n.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (n.this.fGi.agg instanceof Boolean) {
                            if (((Boolean) n.this.fGi.agg).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bkVar, 1, n.this.mPageId, com.baidu.tieba.frs.d.d.hvL, n.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bkVar, 3, n.this.mPageId, com.baidu.tieba.frs.d.d.hvL, n.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 15, n.this.mPageId, com.baidu.tieba.frs.d.d.hvL, n.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bkVar, 1, n.this.mPageId, com.baidu.tieba.frs.d.d.hvL, n.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bkVar.aPk()) {
                        n.this.as(bkVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.caY().a(com.baidu.tieba.frs.d.d.hvL, bkVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.hvL, bkVar.aOj());
                    } else if (view instanceof TbImageView) {
                        if (n.this.fGi.agg instanceof Boolean) {
                            if (((Boolean) n.this.fGi.agg).booleanValue()) {
                                com.baidu.tieba.frs.d.c.caY().a(com.baidu.tieba.frs.d.d.hvL, bkVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.caY().a(com.baidu.tieba.frs.d.d.hvL, bkVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.caY().a(com.baidu.tieba.frs.d.d.hvL, bkVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bkVar.aSb() != null && bkVar.aSb().ddL() != null && bkVar.aSb().ddL().bis() != null && bkVar.aSb().ddL().bis().size() > 0) {
                            i = bkVar.aSb().lmA ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.caY().a(com.baidu.tieba.frs.d.d.hvL, bkVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.caY().a(com.baidu.tieba.frs.d.d.hvL, bkVar, 1);
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
    /* renamed from: aM */
    public com.baidu.card.ag<bk> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.w wVar = new com.baidu.card.w(this.mPageContext.getPageActivity());
        wVar.setFrom("frs");
        wVar.setFromCDN(this.aha);
        if (this.hvK == 502) {
            wVar.setNeedFrsTabName(false);
        } else {
            wVar.setNeedFrsTabName(true);
        }
        aVar.c(wVar);
        com.baidu.card.ae a = aVar.a(false, viewGroup, this.gTb);
        a.setSourceForPb(3);
        com.baidu.card.ag<bk> agVar = new com.baidu.card.ag<>(a);
        agVar.setPageId(this.mPageId);
        agVar.aI(false);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.frs.entelechy.a.n.2
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof bj) && (view.getTag() instanceof com.baidu.card.ag)) {
                    com.baidu.card.ag agVar2 = (com.baidu.card.ag) view.getTag();
                    bk bkVar = ((bj) oVar).dEA;
                    bkVar.objType = 1;
                    if (n.this.fGi != null) {
                        n.this.fGi.a(agVar2.getView(), bkVar);
                    }
                    au.a((AbsThreadDataSupport) bkVar, view.getContext(), n.this.hvK, false);
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.card.ag<bk> agVar) {
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) agVar);
        if (bjVar == null || agVar == null || agVar.getView() == null) {
            return null;
        }
        agVar.rM().setPage(this.aeX);
        agVar.rM().setPosition(i);
        com.baidu.tieba.frs.g.a(agVar.rM().rG(), this.hmR);
        if (this.hmR != null && this.hmR.getForum() != null && !StringUtils.isNull(this.hmR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hmR.getForum().getTopic_special_icon_right())) {
            bjVar.dEA.cY(this.hmR.getForum().getTopic_special_icon(), this.hmR.getForum().getTopic_special_icon_right());
        }
        agVar.b((com.baidu.card.ag<bk>) bjVar.dEA);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.fGi);
        bjVar.dEA.aRK();
        return agVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qy(int i) {
        this.hvK = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hvL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bk bkVar) {
        TiebaStatic.log(new an("c12126").dh("tid", bkVar.getId()).ag("obj_locate", bUG() ? 2 : 1).s("obj_id", bkVar.aQS() == null ? -1L : bkVar.aQS().live_id).ag("obj_type", 1));
    }
}
