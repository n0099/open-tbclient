package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class x extends com.baidu.tieba.frs.k<bw, am<bx>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahw;
    private boolean akn;
    private com.baidu.tieba.card.ab<bx> gSh;
    private int iRU;
    private String mFrom;

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.akn = true;
        this.gSh = new com.baidu.tieba.card.ab<bx>() { // from class: com.baidu.tieba.frs.entelechy.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bx bxVar) {
                if (view != null && bxVar != null) {
                    if (x.this.iHH != null) {
                        x.this.iHH.a(view, (View) bxVar, (Object) x.this.getType());
                    }
                    if ("c13010".equals(x.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ak("obj_type", 1).w("fid", bxVar.getFid()).dR("tid", bxVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 2, x.this.mPageId, com.baidu.tieba.frs.d.d.iRY, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 5, x.this.mPageId, com.baidu.tieba.frs.d.d.iRY, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 14, x.this.mPageId, com.baidu.tieba.frs.d.d.iRY, x.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (x.this.gSh.aiO instanceof Boolean) {
                            if (((Boolean) x.this.gSh.aiO).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bxVar, 1, x.this.mPageId, com.baidu.tieba.frs.d.d.iRY, x.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bxVar, 3, x.this.mPageId, com.baidu.tieba.frs.d.d.iRY, x.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 15, x.this.mPageId, com.baidu.tieba.frs.d.d.iRY, x.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bxVar, 1, x.this.mPageId, com.baidu.tieba.frs.d.d.iRY, x.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(com.baidu.tieba.frs.d.d.iRY, bxVar.bje());
                    } else if (view instanceof TbImageView) {
                        if (x.this.gSh.aiO instanceof Boolean) {
                            if (((Boolean) x.this.gSh.aiO).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ak("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bxVar.bnh() != null && bxVar.bnh().dJS() != null && bxVar.bnh().dJS().bFb() != null && bxVar.bnh().dJS().bFb().size() > 0) {
                            i = bxVar.bnh().mYp ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, 1);
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
    /* renamed from: aR */
    public am<bx> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.y yVar = new com.baidu.card.y(this.mPageContext.getPageActivity());
        yVar.setFrom("frs");
        yVar.setFromCDN(this.akn);
        if (this.iRU == 502) {
            yVar.setNeedFrsTabName(false);
        } else {
            yVar.setNeedFrsTabName(true);
        }
        aVar.c(yVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.inB);
        a2.setSourceForPb(3);
        am<bx> amVar = new am<>(a2);
        amVar.setPageId(this.mPageId);
        amVar.aO(false);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.x.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bx bxVar = ((bw) qVar).evQ;
                    bxVar.objType = 1;
                    if (x.this.gSh != null) {
                        x.this.gSh.a(amVar2.getView(), bxVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), 3, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, am<bx> amVar) {
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) amVar);
        if (bwVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tW().setPage(this.ahw);
        amVar.tW().setPosition(i);
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.iHB);
        if (this.iHB != null && this.iHB.getForum() != null && !StringUtils.isNull(this.iHB.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iHB.getForum().getTopic_special_icon_right())) {
            bwVar.evQ.dE(this.iHB.getForum().getTopic_special_icon(), this.iHB.getForum().getTopic_special_icon_right());
        }
        amVar.b((am<bx>) bwVar.evQ);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gSh);
        bwVar.evQ.bmQ();
        com.baidu.card.y yVar = (com.baidu.card.y) amVar.tW().tP();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.agK.akM.getLayoutParams();
        layoutParams.width = bwVar.eBO;
        layoutParams.height = bwVar.eBP;
        if (yVar.agK.akM.getVisibility() != 8) {
            yVar.agK.akM.setLayoutParams(layoutParams);
        }
        return amVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
        this.iRU = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return iRY;
    }
}
