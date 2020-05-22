package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.e;
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
public class y extends com.baidu.tieba.frs.h<bj, com.baidu.card.ag<bk>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aeX;
    private com.baidu.tieba.card.aa<bk> fFX;
    private int hvz;
    private String mFrom;

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hvz = 3;
        this.fFX = new com.baidu.tieba.card.aa<bk>() { // from class: com.baidu.tieba.frs.entelechy.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                if (view != null && bkVar != null) {
                    if (y.this.hmM != null) {
                        y.this.hmM.a(view, (View) bkVar, (Object) y.this.getType());
                    }
                    if ("c13010".equals(y.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").ag("obj_type", 1).s("fid", bkVar.getFid()).dh("tid", bkVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 2, y.this.mPageId, com.baidu.tieba.frs.d.d.hvA, y.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (y.this.fFX.agg instanceof Boolean) {
                            if (((Boolean) y.this.fFX.agg).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bkVar, 1, y.this.mPageId, com.baidu.tieba.frs.d.d.hvA, y.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bkVar, 3, y.this.mPageId, com.baidu.tieba.frs.d.d.hvA, y.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 15, y.this.mPageId, com.baidu.tieba.frs.d.d.hvA, y.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bkVar, 1, y.this.mPageId, com.baidu.tieba.frs.d.d.hvA, y.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bkVar.aPk()) {
                        y.this.as(bkVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.caQ().a(com.baidu.tieba.frs.d.d.hvA, bkVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.hvA, bkVar.aOj());
                    } else if (view instanceof TbImageView) {
                        if (y.this.fFX.agg instanceof Boolean) {
                            if (((Boolean) y.this.fFX.agg).booleanValue()) {
                                com.baidu.tieba.frs.d.c.caQ().a(com.baidu.tieba.frs.d.d.hvA, bkVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.caQ().a(com.baidu.tieba.frs.d.d.hvA, bkVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.caQ().a(com.baidu.tieba.frs.d.d.hvA, bkVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bkVar.aSb() != null && bkVar.aSb().ddw() != null && bkVar.aSb().ddw().biq() != null && bkVar.aSb().ddw().biq().size() > 0) {
                            i = bkVar.aSb().llr ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.caQ().a(com.baidu.tieba.frs.d.d.hvA, bkVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.caQ().a(com.baidu.tieba.frs.d.d.hvA, bkVar, 1);
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
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), true);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aX(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.y.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.ae a = aVar.a(false, viewGroup, this.gSQ);
        a.setSourceForPb(3);
        com.baidu.card.ag<bk> agVar = new com.baidu.card.ag<>(a);
        agVar.setPageId(this.mPageId);
        agVar.aI(false);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.frs.entelechy.a.y.3
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof bj) && (view.getTag() instanceof com.baidu.card.ag)) {
                    com.baidu.card.ag agVar2 = (com.baidu.card.ag) view.getTag();
                    bk bkVar = ((bj) oVar).dEA;
                    bkVar.objType = 1;
                    if (y.this.fFX != null) {
                        y.this.fFX.a(agVar2.getView(), bkVar);
                    }
                    au.a((AbsThreadDataSupport) bkVar, view.getContext(), y.this.hvz, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.t) viewGroup2, view, i));
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
        com.baidu.tieba.frs.g.a(agVar.rM().rG(), this.hmG);
        if (this.hmG != null && this.hmG.getForum() != null && !StringUtils.isNull(this.hmG.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hmG.getForum().getTopic_special_icon_right())) {
            bjVar.dEA.cY(this.hmG.getForum().getTopic_special_icon(), this.hmG.getForum().getTopic_special_icon_right());
        }
        agVar.a(bjVar.aOp(), Align.ALIGN_RIGHT_TOP, null);
        if (!bjVar.dEA.isBjh()) {
            agVar.rO();
        }
        agVar.b((com.baidu.card.ag<bk>) bjVar.dEA);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.fFX);
        bjVar.dEA.aRK();
        if (hvA != null) {
            int i2 = 0;
            if (this.hmG != null) {
                i2 = this.hmG.getTopThreadSize();
            }
            bjVar.dEA.dDb = (bjVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.caQ().a(hvA, bjVar.dEA);
        bjVar.dEA.aRK();
        com.baidu.tieba.frs.d.a.a(bjVar.dEA, this.mPageId, hvA, getTbPageTag());
        if (bjVar != null) {
            bjVar.dEA.aRK();
        }
        return agVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
        this.hvz = i;
    }

    @Override // com.baidu.tieba.card.z
    public void lV(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hvA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bk bkVar) {
        TiebaStatic.log(new an("c12126").dh("tid", bkVar.getId()).ag("obj_locate", bUE() ? 2 : 1).s("obj_id", bkVar.aQS() == null ? -1L : bkVar.aQS().live_id).ag("obj_type", 1));
    }
}
