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
    private String air;
    private com.baidu.tieba.card.aa<bz> hiC;
    private int jkI;
    private String mFrom;

    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jkI = 3;
        this.hiC = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if (ac.this.jag != null) {
                        ac.this.jag.a(view, (View) bzVar, (Object) ac.this.getType());
                    }
                    if ("c13010".equals(ac.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").an("obj_type", 1).w("fid", bzVar.getFid()).dW("tid", bzVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 2, ac.this.mPageId, com.baidu.tieba.frs.b.d.jkJ, ac.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (ac.this.hiC.ajy instanceof Boolean) {
                            if (((Boolean) ac.this.hiC.ajy).booleanValue()) {
                                com.baidu.tieba.frs.b.a.a(bzVar, 1, ac.this.mPageId, com.baidu.tieba.frs.b.d.jkJ, ac.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.b.a.a(bzVar, 3, ac.this.mPageId, com.baidu.tieba.frs.b.d.jkJ, ac.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 15, ac.this.mPageId, com.baidu.tieba.frs.b.d.jkJ, ac.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(bzVar, 1, ac.this.mPageId, com.baidu.tieba.frs.b.d.jkJ, ac.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bzVar.bmc()) {
                        ac.this.as(bzVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cIR().a(com.baidu.tieba.frs.b.d.jkJ, bzVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(com.baidu.tieba.frs.b.d.jkJ, bzVar.bkW());
                    } else if (view instanceof TbImageView) {
                        if (ac.this.hiC.ajy instanceof Boolean) {
                            if (((Boolean) ac.this.hiC.ajy).booleanValue()) {
                                com.baidu.tieba.frs.b.c.cIR().a(com.baidu.tieba.frs.b.d.jkJ, bzVar, 1);
                            } else {
                                com.baidu.tieba.frs.b.c.cIR().a(com.baidu.tieba.frs.b.d.jkJ, bzVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.b.c.cIR().a(com.baidu.tieba.frs.b.d.jkJ, bzVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bzVar.bpd() != null && bzVar.bpd().dLo() != null && bzVar.bpd().dLo().bHf() != null && bzVar.bpd().dLo().bHf().size() > 0) {
                            i = bzVar.bpd().nnu ? 9 : 8;
                        }
                        com.baidu.tieba.frs.b.c.cIR().a(com.baidu.tieba.frs.b.d.jkJ, bzVar, i);
                    } else {
                        com.baidu.tieba.frs.b.c.cIR().a(com.baidu.tieba.frs.b.d.jkJ, bzVar, 1);
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
        dVar.bq(4280);
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
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.TOP, viewGroup, this.iGb);
        a2.setSourceForPb(3);
        ThreadCardViewHolder<bz> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        threadCardViewHolder.aL(false);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.ac.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar).eHK;
                    bzVar.objType = 1;
                    if (ac.this.hiC != null) {
                        ac.this.hiC.a(threadCardViewHolder2.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), ac.this.jkI, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.tm().b(new a.C0089a(1));
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
        threadCardViewHolder.tm().setPage(this.air);
        threadCardViewHolder.tm().setPosition(i);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tm().tg(), this.jaa);
        if (this.jaa != null && this.jaa.getForum() != null && !StringUtils.isNull(this.jaa.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jaa.getForum().getTopic_special_icon_right())) {
            byVar.eHK.dJ(this.jaa.getForum().getTopic_special_icon(), this.jaa.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.a(true, Align.ALIGN_RIGHT_TOP, null);
        if (!byVar.eHK.isBjh()) {
            threadCardViewHolder.tp();
        }
        threadCardViewHolder.b((ThreadCardViewHolder<bz>) byVar.eHK);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tm().a(this.hiC);
        byVar.eHK.boL();
        if (jkJ != null) {
            int i2 = 0;
            if (this.jaa != null) {
                i2 = this.jaa.getTopThreadSize();
            }
            byVar.eHK.eMg = (byVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.b.c.cIR().a(jkJ, byVar.eHK);
        byVar.eHK.boL();
        com.baidu.tieba.frs.b.a.a(byVar.eHK, this.mPageId, jkJ, getTbPageTag());
        if (byVar != null) {
            byVar.eHK.boL();
        }
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
        this.jkI = i;
    }

    @Override // com.baidu.tieba.card.z
    public void pt(boolean z) {
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return jkJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bz bzVar) {
        TiebaStatic.log(new aq("c12126").dW("tid", bzVar.getId()).an("obj_locate", cAV() ? 2 : 1).w("obj_id", bzVar.bnQ() == null ? -1L : bzVar.bnQ().live_id).an("obj_type", 1));
    }
}
