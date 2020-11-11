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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ab extends com.baidu.tieba.frs.k<bv, com.baidu.card.a<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahu;
    private com.baidu.tieba.card.ab<bw> gSD;
    private int iRk;
    private com.baidu.tieba.frs.d.b iRl;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iRk = 3;
        this.iRl = new com.baidu.tieba.frs.d.b();
        this.gSD = new com.baidu.tieba.card.ab<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (ab.this.iGT != null) {
                        ab.this.iGT.a(view, (View) bwVar, (Object) bw.eDW);
                    }
                    if ("c13010".equals(ab.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").al("obj_type", 2).w("fid", bwVar.getFid()).dR("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bwVar.blg()) {
                        com.baidu.tieba.frs.d.c.cEP().a(ab.this.iRl, bwVar, 1);
                        ab.this.aq(bwVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cEP().a(ab.this.iRl, bwVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.j.a(ab.this.iRl, bwVar.bka());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.cEP().a(ab.this.iRl, bwVar, 4);
                        ab.this.aq(bwVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ab.this.aq(bwVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, ab.this.mPageId, ab.this.iRl, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, ab.this.mPageId, ab.this.iRl, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, ab.this.mPageId, ab.this.iRl, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, ab.this.mPageId, ab.this.iRl, ab.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, ab.this.mPageId, ab.this.iRl, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, ab.this.mPageId, ab.this.iRl, ab.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, ab.this.mPageId, ab.this.iRl, ab.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public com.baidu.card.a c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity(), true);
        hVar.setFrom("frs");
        hVar.setStageType("2003");
        hVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ab.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect bh = ay.bh(hVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, ab.this.mContext, ab.this.iRk, false, bh);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, ab.this.mContext, ab.this.iRk, false, bh);
                }
            }
        });
        if (this.iRk == 502) {
            hVar.setNeedFrsTabName(false);
        } else {
            hVar.setNeedFrsTabName(true);
        }
        aVar.c(hVar);
        com.baidu.card.ak a2 = aVar.a(false, viewGroup, this.imM);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a2);
        aVar2.setPageId(this.mPageId);
        a2.a(this.gSD);
        a2.setSourceForPb(this.iRk);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ab.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    bw bwVar = ((bv) qVar).exA;
                    bwVar.objType = 1;
                    if (ab.this.gSD != null) {
                        ab.this.gSD.a(amVar.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), ab.this.iRk, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar.tW().b(new a.C0097a(1));
                }
            }
        });
        aVar2.aM(false);
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.card.a<bw> aVar) {
        if (aVar == null) {
            return null;
        }
        if (bvVar == null) {
            return aVar.getView();
        }
        if (aVar.tW() instanceof com.baidu.tieba.a.e) {
            aVar.tW().setPage(this.ahu);
        }
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) aVar);
        com.baidu.tieba.frs.j.a(aVar.tW().tQ(), this.iGN);
        aVar.setVideoStatsData(ai(bvVar.exA));
        aVar.tW().setPosition(i);
        if (this.iGN != null && this.iGN.getForum() != null && !StringUtils.isNull(this.iGN.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iGN.getForum().getTopic_special_icon_right())) {
            bvVar.exA.dG(this.iGN.getForum().getTopic_special_icon(), this.iGN.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bw>) bvVar.exA);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.gSD);
        if (this.iRl != null) {
            int i2 = 0;
            if (this.iGN != null) {
                i2 = this.iGN.getTopThreadSize();
            }
            bvVar.exA.eBK = (bvVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.cEP().a(this.iRl, bvVar.exA);
        com.baidu.tieba.frs.d.c.cEP().aw(bvVar.exA);
        com.baidu.tieba.frs.d.c.cEP().a(bvVar.exA, cxY());
        com.baidu.tieba.frs.d.a.a(bvVar.exA, this.mPageId, this.iRl, getTbPageTag());
        bvVar.exA.bnM();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ai(bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bwVar.bnJ() ? "3" : "2";
        if (this.iRl.jfE == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.fyR = this.iRl.jfD;
        oVar.alT = bwVar.getTid();
        oVar.mSource = bwVar.mRecomSource;
        oVar.mjR = bwVar.eFT;
        oVar.mjS = bwVar.mRecomWeight;
        oVar.mjV = bwVar.mRecomAbTag;
        if (bwVar.bmS() != null) {
            oVar.mjW = bwVar.bmS().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void vd(int i) {
        this.iRk = i;
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dR("tid", bwVar.getId()).al("obj_locate", cxY() ? 2 : 1).w("obj_id", bwVar.bmU() == null ? -1L : bwVar.bmU().live_id).al("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void oA(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRl;
    }
}
