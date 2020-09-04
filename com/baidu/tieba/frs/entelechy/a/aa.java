package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.e;
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
public class aa extends com.baidu.tieba.frs.k<bv, com.baidu.card.al<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String agJ;
    private com.baidu.tieba.card.aa<bw> giN;
    private int icQ;
    private String mFrom;

    public aa(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.icQ = 3;
        this.giN = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (aa.this.hSz != null) {
                        aa.this.hSz.a(view, (View) bwVar, (Object) aa.this.getType());
                    }
                    if ("c13010".equals(aa.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 1).u("fid", bwVar.getFid()).dD("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, aa.this.mPageId, com.baidu.tieba.frs.d.d.icR, aa.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (aa.this.giN.ahV instanceof Boolean) {
                            if (((Boolean) aa.this.giN.ahV).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bwVar, 1, aa.this.mPageId, com.baidu.tieba.frs.d.d.icR, aa.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bwVar, 3, aa.this.mPageId, com.baidu.tieba.frs.d.d.icR, aa.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, aa.this.mPageId, com.baidu.tieba.frs.d.d.icR, aa.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, aa.this.mPageId, com.baidu.tieba.frs.d.d.icR, aa.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bwVar.bdk()) {
                        aa.this.ap(bwVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.csv().a(com.baidu.tieba.frs.d.d.icR, bwVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.icR, bwVar.bcf());
                    } else if (view instanceof TbImageView) {
                        if (aa.this.giN.ahV instanceof Boolean) {
                            if (((Boolean) aa.this.giN.ahV).booleanValue()) {
                                com.baidu.tieba.frs.d.c.csv().a(com.baidu.tieba.frs.d.d.icR, bwVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.csv().a(com.baidu.tieba.frs.d.d.icR, bwVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.csv().a(com.baidu.tieba.frs.d.d.icR, bwVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bwVar.bgh() != null && bwVar.bgh().dwM() != null && bwVar.bgh().dwM().bxx() != null && bwVar.bgh().dwM().bxx().size() > 0) {
                            i = bwVar.bgh().mfI ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.csv().a(com.baidu.tieba.frs.d.d.icR, bwVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.csv().a(com.baidu.tieba.frs.d.d.icR, bwVar, 1);
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
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), true);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bk(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.aa.2
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
        com.baidu.card.aj a = aVar.a(false, viewGroup, this.hyr);
        a.setSourceForPb(3);
        com.baidu.card.al<bw> alVar = new com.baidu.card.al<>(a);
        alVar.setPageId(this.mPageId);
        alVar.aM(false);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.aa.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof com.baidu.card.al)) {
                    com.baidu.card.al alVar2 = (com.baidu.card.al) view.getTag();
                    bw bwVar = ((bv) qVar).dUW;
                    bwVar.objType = 1;
                    if (aa.this.giN != null) {
                        aa.this.giN.a(alVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), aa.this.icQ, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
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
        alVar.tR().setPage(this.agJ);
        alVar.tR().setPosition(i);
        com.baidu.tieba.frs.j.a(alVar.tR().tL(), this.hSt);
        if (this.hSt != null && this.hSt.getForum() != null && !StringUtils.isNull(this.hSt.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hSt.getForum().getTopic_special_icon_right())) {
            bvVar.dUW.du(this.hSt.getForum().getTopic_special_icon(), this.hSt.getForum().getTopic_special_icon_right());
        }
        alVar.a(true, Align.ALIGN_RIGHT_TOP, null);
        if (!bvVar.dUW.isBjh()) {
            alVar.tT();
        }
        alVar.b((com.baidu.card.al<bw>) bvVar.dUW);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.giN);
        bvVar.dUW.bfQ();
        if (icR != null) {
            int i2 = 0;
            if (this.hSt != null) {
                i2 = this.hSt.getTopThreadSize();
            }
            bvVar.dUW.dZf = (bvVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.csv().a(icR, bvVar.dUW);
        bvVar.dUW.bfQ();
        com.baidu.tieba.frs.d.a.a(bvVar.dUW, this.mPageId, icR, getTbPageTag());
        if (bvVar != null) {
            bvVar.dUW.bfQ();
        }
        return alVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Dk(String str) {
        this.agJ = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.icQ = i;
    }

    @Override // com.baidu.tieba.card.z
    public void no(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return icR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dD("tid", bwVar.getId()).ai("obj_locate", clG() ? 2 : 1).u("obj_id", bwVar.beY() == null ? -1L : bwVar.beY().live_id).ai("obj_type", 1));
    }
}
