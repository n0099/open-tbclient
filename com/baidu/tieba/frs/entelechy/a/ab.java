package com.baidu.tieba.frs.entelechy.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.b;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class ab extends com.baidu.tieba.frs.k<bw, com.baidu.card.a<bx>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahw;
    private com.baidu.tieba.card.ab<bx> gSk;
    private int iRX;
    private com.baidu.tieba.frs.d.b iRY;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iRX = 3;
        this.iRY = new com.baidu.tieba.frs.d.b();
        this.gSk = new com.baidu.tieba.card.ab<bx>() { // from class: com.baidu.tieba.frs.entelechy.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bx bxVar) {
                if (view != null && bxVar != null) {
                    if (ab.this.iHH != null) {
                        ab.this.iHH.a(view, (View) bxVar, (Object) bx.eCo);
                    }
                    if ("c13010".equals(ab.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ak("obj_type", 2).w("fid", bxVar.getFid()).dR("tid", bxVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bxVar.bki()) {
                        com.baidu.tieba.frs.d.c.cEu().a(ab.this.iRY, bxVar, 1);
                        ab.this.as(bxVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ak("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cEu().a(ab.this.iRY, bxVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.j.a(ab.this.iRY, bxVar.bje());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.cEu().a(ab.this.iRY, bxVar, 4);
                        ab.this.as(bxVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ab.this.as(bxVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 4, ab.this.mPageId, ab.this.iRY, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 4, ab.this.mPageId, ab.this.iRY, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 2, ab.this.mPageId, ab.this.iRY, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 5, ab.this.mPageId, ab.this.iRY, ab.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 15, ab.this.mPageId, ab.this.iRY, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 14, ab.this.mPageId, ab.this.iRY, ab.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bxVar, 1, ab.this.mPageId, ab.this.iRY, ab.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity(), true);
        hVar.setFrom("frs");
        hVar.setStageType("2003");
        hVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ab.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bk = az.bk(hVar.getVideoContainer());
                    if (!(aVar2 instanceof bx)) {
                        az.a(aVar2, ab.this.mContext, ab.this.iRX, false, bk);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, ab.this.mContext, ab.this.iRX, false, bk);
                }
            }
        });
        if (this.iRX == 502) {
            hVar.setNeedFrsTabName(false);
        } else {
            hVar.setNeedFrsTabName(true);
        }
        aVar.c(hVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.inB);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a2);
        aVar2.setPageId(this.mPageId);
        a2.a(this.gSk);
        a2.setSourceForPb(this.iRX);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ab.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    bx bxVar = ((bw) qVar).evQ;
                    bxVar.objType = 1;
                    if (ab.this.gSk != null) {
                        ab.this.gSk.a(amVar.getView(), bxVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), ab.this.iRX, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar.tW().b(new a.C0096a(1));
                }
            }
        });
        aVar2.aO(false);
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, com.baidu.card.a<bx> aVar) {
        if (aVar == null) {
            return null;
        }
        if (bwVar == null) {
            return aVar.getView();
        }
        if (aVar.tW() instanceof com.baidu.tieba.a.e) {
            aVar.tW().setPage(this.ahw);
        }
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) aVar);
        com.baidu.tieba.frs.j.a(aVar.tW().tQ(), this.iHB);
        aVar.setVideoStatsData(ak(bwVar.evQ));
        aVar.tW().setPosition(i);
        if (this.iHB != null && this.iHB.getForum() != null && !StringUtils.isNull(this.iHB.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iHB.getForum().getTopic_special_icon_right())) {
            bwVar.evQ.dE(this.iHB.getForum().getTopic_special_icon(), this.iHB.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bx>) bwVar.evQ);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.gSk);
        if (this.iRY != null) {
            int i2 = 0;
            if (this.iHB != null) {
                i2 = this.iHB.getTopThreadSize();
            }
            bwVar.evQ.eAb = (bwVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.cEu().a(this.iRY, bwVar.evQ);
        com.baidu.tieba.frs.d.c.cEu().ay(bwVar.evQ);
        com.baidu.tieba.frs.d.c.cEu().a(bwVar.evQ, cxB());
        com.baidu.tieba.frs.d.a.a(bwVar.evQ, this.mPageId, this.iRY, getTbPageTag());
        bwVar.evQ.bmQ();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ak(bx bxVar) {
        if (bxVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bxVar.bmN() ? "3" : "2";
        if (this.iRY.jgp == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.fyg = this.iRY.jgo;
        oVar.alZ = bxVar.getTid();
        oVar.mSource = bxVar.mRecomSource;
        oVar.mkk = bxVar.eEl;
        oVar.mkl = bxVar.mRecomWeight;
        oVar.mko = bxVar.mRecomAbTag;
        if (bxVar.blU() != null) {
            oVar.mkp = bxVar.blU().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
        this.iRX = i;
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bx bxVar) {
        TiebaStatic.log(new ar("c12126").dR("tid", bxVar.getId()).ak("obj_locate", cxB() ? 2 : 1).w("obj_id", bxVar.blW() == null ? -1L : bxVar.blW().live_id).ak("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void oD(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRY;
    }
}
