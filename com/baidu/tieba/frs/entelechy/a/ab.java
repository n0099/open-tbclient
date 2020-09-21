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
/* loaded from: classes21.dex */
public class ab extends com.baidu.tieba.frs.k<bv, com.baidu.card.a<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahc;
    private com.baidu.tieba.card.aa<bw> glX;
    private int ijU;
    private com.baidu.tieba.frs.d.b ijV;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ijU = 3;
        this.ijV = new com.baidu.tieba.frs.d.b();
        this.glX = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (ab.this.hZz != null) {
                        ab.this.hZz.a(view, (View) bwVar, (Object) bw.edC);
                    }
                    if ("c13010".equals(ab.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 2).u("fid", bwVar.getFid()).dF("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bwVar.bee()) {
                        com.baidu.tieba.frs.d.c.cvK().a(ab.this.ijV, bwVar, 1);
                        ab.this.aq(bwVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cvK().a(ab.this.ijV, bwVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.j.a(ab.this.ijV, bwVar.bcZ());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.cvK().a(ab.this.ijV, bwVar, 4);
                        ab.this.aq(bwVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ab.this.aq(bwVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, ab.this.mPageId, ab.this.ijV, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, ab.this.mPageId, ab.this.ijV, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, ab.this.mPageId, ab.this.ijV, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, ab.this.mPageId, ab.this.ijV, ab.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, ab.this.mPageId, ab.this.ijV, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, ab.this.mPageId, ab.this.ijV, ab.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, ab.this.mPageId, ab.this.ijV, ab.this.getTbPageTag());
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
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect ba = ay.ba(hVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, ab.this.mContext, ab.this.ijU, false, ba);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, ab.this.mContext, ab.this.ijU, false, ba);
                }
            }
        });
        if (this.ijU == 502) {
            hVar.setNeedFrsTabName(false);
        } else {
            hVar.setNeedFrsTabName(true);
        }
        aVar.c(hVar);
        com.baidu.card.ak a = aVar.a(false, viewGroup, this.hFt);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.glX);
        a.setSourceForPb(this.ijU);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ab.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    bw bwVar = ((bv) qVar).dXg;
                    bwVar.objType = 1;
                    if (ab.this.glX != null) {
                        ab.this.glX.a(amVar.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), ab.this.ijU, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar.tW().b(new a.C0096a(1));
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
            aVar.tW().setPage(this.ahc);
        }
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) aVar);
        com.baidu.tieba.frs.j.a(aVar.tW().tQ(), this.hZt);
        aVar.setVideoStatsData(ai(bvVar.dXg));
        aVar.tW().setPosition(i);
        if (this.hZt != null && this.hZt.getForum() != null && !StringUtils.isNull(this.hZt.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hZt.getForum().getTopic_special_icon_right())) {
            bvVar.dXg.du(this.hZt.getForum().getTopic_special_icon(), this.hZt.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bw>) bvVar.dXg);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.glX);
        if (this.ijV != null) {
            int i2 = 0;
            if (this.hZt != null) {
                i2 = this.hZt.getTopThreadSize();
            }
            bvVar.dXg.ebp = (bvVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.cvK().a(this.ijV, bvVar.dXg);
        com.baidu.tieba.frs.d.c.cvK().aw(bvVar.dXg);
        com.baidu.tieba.frs.d.c.cvK().a(bvVar.dXg, coS());
        com.baidu.tieba.frs.d.a.a(bvVar.dXg, this.mPageId, this.ijV, getTbPageTag());
        bvVar.dXg.bgK();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ai(bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bwVar.bgH() ? "3" : "2";
        if (this.ijV.iys == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.eYo = this.ijV.iyr;
        oVar.alA = bwVar.getTid();
        oVar.mSource = bwVar.mRecomSource;
        oVar.lCf = bwVar.efy;
        oVar.lCg = bwVar.mRecomWeight;
        oVar.lCj = bwVar.mRecomAbTag;
        if (bwVar.bfQ() != null) {
            oVar.lCk = bwVar.bfQ().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
        this.ijU = i;
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dF("tid", bwVar.getId()).ai("obj_locate", coS() ? 2 : 1).u("obj_id", bwVar.bfS() == null ? -1L : bwVar.bfS().live_id).ai("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.z
    public void nu(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.ijV;
    }
}
