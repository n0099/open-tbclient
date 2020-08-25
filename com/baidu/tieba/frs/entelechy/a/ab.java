package com.baidu.tieba.frs.entelechy.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aj;
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
/* loaded from: classes16.dex */
public class ab extends com.baidu.tieba.frs.k<bv, com.baidu.card.a<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String agH;
    private com.baidu.tieba.card.aa<bw> giM;
    private int icK;
    private com.baidu.tieba.frs.d.b icL;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.icK = 3;
        this.icL = new com.baidu.tieba.frs.d.b();
        this.giM = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (ab.this.hSt != null) {
                        ab.this.hSt.a(view, (View) bwVar, (Object) bw.ebo);
                    }
                    if ("c13010".equals(ab.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 2).u("fid", bwVar.getFid()).dD("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bwVar.bdk()) {
                        com.baidu.tieba.frs.d.c.csu().a(ab.this.icL, bwVar, 1);
                        ab.this.ap(bwVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.csu().a(ab.this.icL, bwVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(ab.this.icL, bwVar.bcf());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.csu().a(ab.this.icL, bwVar, 4);
                        ab.this.ap(bwVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ab.this.ap(bwVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, ab.this.mPageId, ab.this.icL, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, ab.this.mPageId, ab.this.icL, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, ab.this.mPageId, ab.this.icL, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, ab.this.mPageId, ab.this.icL, ab.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, ab.this.mPageId, ab.this.icL, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, ab.this.mPageId, ab.this.icL, ab.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, ab.this.mPageId, ab.this.icL, ab.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity(), true);
        gVar.setFrom("frs");
        gVar.setStageType("2003");
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ab.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aY = ay.aY(gVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, ab.this.mContext, ab.this.icK, false, aY);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, ab.this.mContext, ab.this.icK, false, aY);
                }
            }
        });
        if (this.icK == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        aVar.c(gVar);
        com.baidu.card.aj a = aVar.a(false, viewGroup, this.hyl);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.giM);
        a.setSourceForPb(this.icK);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ab.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof com.baidu.card.al)) {
                    com.baidu.card.al alVar = (com.baidu.card.al) view.getTag();
                    bw bwVar = ((bv) qVar).dUS;
                    bwVar.objType = 1;
                    if (ab.this.giM != null) {
                        ab.this.giM.a(alVar.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), ab.this.icK, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    alVar.tR().b(new a.C0095a(1));
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
        if (aVar.tR() instanceof com.baidu.tieba.a.e) {
            aVar.tR().setPage(this.agH);
        }
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) aVar);
        com.baidu.tieba.frs.j.a(aVar.tR().tL(), this.hSn);
        aVar.setVideoStatsData(ah(bvVar.dUS));
        aVar.tR().setPosition(i);
        if (this.hSn != null && this.hSn.getForum() != null && !StringUtils.isNull(this.hSn.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hSn.getForum().getTopic_special_icon_right())) {
            bvVar.dUS.du(this.hSn.getForum().getTopic_special_icon(), this.hSn.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bw>) bvVar.dUS);
        aVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tR().a(this.giM);
        if (this.icL != null) {
            int i2 = 0;
            if (this.hSn != null) {
                i2 = this.hSn.getTopThreadSize();
            }
            bvVar.dUS.dZb = (bvVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.csu().a(this.icL, bvVar.dUS);
        com.baidu.tieba.frs.d.c.csu().av(bvVar.dUS);
        com.baidu.tieba.frs.d.c.csu().a(bvVar.dUS, clF());
        com.baidu.tieba.frs.d.a.a(bvVar.dUS, this.mPageId, this.icL, getTbPageTag());
        bvVar.dUS.bfQ();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ah(bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bwVar.bfN() ? "3" : "2";
        if (this.icL.iqW == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.eVt = this.icL.iqV;
        oVar.akY = bwVar.getTid();
        oVar.mSource = bwVar.mRecomSource;
        oVar.ltc = bwVar.edk;
        oVar.ltd = bwVar.mRecomWeight;
        oVar.ltg = bwVar.mRecomAbTag;
        if (bwVar.beW() != null) {
            oVar.lth = bwVar.beW().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.icK = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dD("tid", bwVar.getId()).ai("obj_locate", clF() ? 2 : 1).u("obj_id", bwVar.beY() == null ? -1L : bwVar.beY().live_id).ai("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.z
    public void nm(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.icL;
    }
}
