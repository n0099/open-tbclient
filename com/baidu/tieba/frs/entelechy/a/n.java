package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class n extends com.baidu.tieba.frs.k<bv, com.baidu.card.al<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String agH;
    private boolean ajr;
    private com.baidu.tieba.card.aa<bw> giJ;
    private int icK;
    private String mFrom;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ajr = true;
        this.icK = 3;
        this.giJ = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (n.this.hSt != null) {
                        n.this.hSt.a(view, (View) bwVar, (Object) n.this.getType());
                    }
                    if ("c13010".equals(n.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 1).u("fid", bwVar.getFid()).dD("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, n.this.mPageId, com.baidu.tieba.frs.d.d.icL, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, n.this.mPageId, com.baidu.tieba.frs.d.d.icL, n.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, n.this.mPageId, com.baidu.tieba.frs.d.d.icL, n.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (n.this.giJ.ahT instanceof Boolean) {
                            if (((Boolean) n.this.giJ.ahT).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bwVar, 1, n.this.mPageId, com.baidu.tieba.frs.d.d.icL, n.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bwVar, 3, n.this.mPageId, com.baidu.tieba.frs.d.d.icL, n.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, n.this.mPageId, com.baidu.tieba.frs.d.d.icL, n.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, n.this.mPageId, com.baidu.tieba.frs.d.d.icL, n.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bwVar.bdk()) {
                        n.this.ap(bwVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.csu().a(com.baidu.tieba.frs.d.d.icL, bwVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.icL, bwVar.bcf());
                    } else if (view instanceof TbImageView) {
                        if (n.this.giJ.ahT instanceof Boolean) {
                            if (((Boolean) n.this.giJ.ahT).booleanValue()) {
                                com.baidu.tieba.frs.d.c.csu().a(com.baidu.tieba.frs.d.d.icL, bwVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.csu().a(com.baidu.tieba.frs.d.d.icL, bwVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.csu().a(com.baidu.tieba.frs.d.d.icL, bwVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bwVar.bgh() != null && bwVar.bgh().dwH() != null && bwVar.bgh().dwH().bxw() != null && bwVar.bgh().dwH().bxw().size() > 0) {
                            i = bwVar.bgh().mft ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.csu().a(com.baidu.tieba.frs.d.d.icL, bwVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.csu().a(com.baidu.tieba.frs.d.d.icL, bwVar, 1);
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
    /* renamed from: aQ */
    public com.baidu.card.al<bw> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.y yVar = new com.baidu.card.y(this.mPageContext.getPageActivity());
        yVar.setFrom("frs");
        yVar.setFromCDN(this.ajr);
        if (this.icK == 502) {
            yVar.setNeedFrsTabName(false);
        } else {
            yVar.setNeedFrsTabName(true);
        }
        aVar.c(yVar);
        com.baidu.card.aj a = aVar.a(false, viewGroup, this.hyl);
        a.setSourceForPb(3);
        com.baidu.card.al<bw> alVar = new com.baidu.card.al<>(a);
        alVar.setPageId(this.mPageId);
        alVar.aM(false);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.n.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof com.baidu.card.al)) {
                    com.baidu.card.al alVar2 = (com.baidu.card.al) view.getTag();
                    bw bwVar = ((bv) qVar).dUS;
                    bwVar.objType = 1;
                    if (n.this.giJ != null) {
                        n.this.giJ.a(alVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), n.this.icK, false);
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.card.al<bw> alVar) {
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) alVar);
        if (bvVar == null || alVar == null || alVar.getView() == null) {
            return null;
        }
        alVar.tR().setPage(this.agH);
        alVar.tR().setPosition(i);
        com.baidu.tieba.frs.j.a(alVar.tR().tL(), this.hSn);
        if (this.hSn != null && this.hSn.getForum() != null && !StringUtils.isNull(this.hSn.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hSn.getForum().getTopic_special_icon_right())) {
            bvVar.dUS.du(this.hSn.getForum().getTopic_special_icon(), this.hSn.getForum().getTopic_special_icon_right());
        }
        alVar.b((com.baidu.card.al<bw>) bvVar.dUS);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.giJ);
        bvVar.dUS.bfQ();
        return alVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.icK = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return icL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dD("tid", bwVar.getId()).ai("obj_locate", clF() ? 2 : 1).u("obj_id", bwVar.beY() == null ? -1L : bwVar.beY().live_id).ai("obj_type", 1));
    }
}
