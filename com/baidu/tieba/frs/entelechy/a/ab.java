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
    private com.baidu.tieba.card.ab<bw> gMe;
    private int iLn;
    private com.baidu.tieba.frs.d.b iLo;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iLn = 3;
        this.iLo = new com.baidu.tieba.frs.d.b();
        this.gMe = new com.baidu.tieba.card.ab<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (ab.this.iAW != null) {
                        ab.this.iAW.a(view, (View) bwVar, (Object) bw.eyg);
                    }
                    if ("c13010".equals(ab.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").aj("obj_type", 2).w("fid", bwVar.getFid()).dR("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bwVar.biG()) {
                        com.baidu.tieba.frs.d.c.cCo().a(ab.this.iLo, bwVar, 1);
                        ab.this.aq(bwVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cCo().a(ab.this.iLo, bwVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.j.a(ab.this.iLo, bwVar.bhA());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.cCo().a(ab.this.iLo, bwVar, 4);
                        ab.this.aq(bwVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ab.this.aq(bwVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, ab.this.mPageId, ab.this.iLo, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, ab.this.mPageId, ab.this.iLo, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, ab.this.mPageId, ab.this.iLo, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, ab.this.mPageId, ab.this.iLo, ab.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, ab.this.mPageId, ab.this.iLo, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, ab.this.mPageId, ab.this.iLo, ab.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, ab.this.mPageId, ab.this.iLo, ab.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public com.baidu.card.a c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity(), true);
        hVar.setFrom("frs");
        hVar.setStageType("2003");
        hVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ab.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect bd = ay.bd(hVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, ab.this.mContext, ab.this.iLn, false, bd);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, ab.this.mContext, ab.this.iLn, false, bd);
                }
            }
        });
        if (this.iLn == 502) {
            hVar.setNeedFrsTabName(false);
        } else {
            hVar.setNeedFrsTabName(true);
        }
        aVar.c(hVar);
        com.baidu.card.ak a2 = aVar.a(false, viewGroup, this.igO);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a2);
        aVar2.setPageId(this.mPageId);
        a2.a(this.gMe);
        a2.setSourceForPb(this.iLn);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ab.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    bw bwVar = ((bv) qVar).erH;
                    bwVar.objType = 1;
                    if (ab.this.gMe != null) {
                        ab.this.gMe.a(amVar.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), ab.this.iLn, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
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
        com.baidu.tieba.frs.j.a(aVar.tW().tQ(), this.iAQ);
        aVar.setVideoStatsData(ai(bvVar.erH));
        aVar.tW().setPosition(i);
        if (this.iAQ != null && this.iAQ.getForum() != null && !StringUtils.isNull(this.iAQ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iAQ.getForum().getTopic_special_icon_right())) {
            bvVar.erH.dG(this.iAQ.getForum().getTopic_special_icon(), this.iAQ.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bw>) bvVar.erH);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.gMe);
        if (this.iLo != null) {
            int i2 = 0;
            if (this.iAQ != null) {
                i2 = this.iAQ.getTopThreadSize();
            }
            bvVar.erH.evR = (bvVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.cCo().a(this.iLo, bvVar.erH);
        com.baidu.tieba.frs.d.c.cCo().aw(bvVar.erH);
        com.baidu.tieba.frs.d.c.cCo().a(bvVar.erH, cvx());
        com.baidu.tieba.frs.d.a.a(bvVar.erH, this.mPageId, this.iLo, getTbPageTag());
        bvVar.erH.blm();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ai(bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bwVar.blj() ? "3" : "2";
        if (this.iLo.iZH == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.fsZ = this.iLo.iZG;
        oVar.alT = bwVar.getTid();
        oVar.mSource = bwVar.mRecomSource;
        oVar.mdS = bwVar.eAe;
        oVar.mdT = bwVar.mRecomWeight;
        oVar.mdW = bwVar.mRecomAbTag;
        if (bwVar.bks() != null) {
            oVar.mdX = bwVar.bks().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uQ(int i) {
        this.iLn = i;
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dR("tid", bwVar.getId()).aj("obj_locate", cvx() ? 2 : 1).w("obj_id", bwVar.bku() == null ? -1L : bwVar.bku().live_id).aj("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void or(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iLo;
    }
}
