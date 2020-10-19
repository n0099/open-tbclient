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
public class ab extends com.baidu.tieba.frs.k<bv, com.baidu.card.a<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aht;
    private com.baidu.tieba.card.aa<bw> gAq;
    private int iyR;
    private com.baidu.tieba.frs.d.b iyS;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iyR = 3;
        this.iyS = new com.baidu.tieba.frs.d.b();
        this.gAq = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (ab.this.ioA != null) {
                        ab.this.ioA.a(view, (View) bwVar, (Object) bw.epH);
                    }
                    if ("c13010".equals(ab.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").aj("obj_type", 2).u("fid", bwVar.getFid()).dK("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bwVar.bgN()) {
                        com.baidu.tieba.frs.d.c.czh().a(ab.this.iyS, bwVar, 1);
                        ab.this.aq(bwVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.czh().a(ab.this.iyS, bwVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.j.a(ab.this.iyS, bwVar.bfH());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.czh().a(ab.this.iyS, bwVar, 4);
                        ab.this.aq(bwVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ab.this.aq(bwVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, ab.this.mPageId, ab.this.iyS, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, ab.this.mPageId, ab.this.iyS, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, ab.this.mPageId, ab.this.iyS, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, ab.this.mPageId, ab.this.iyS, ab.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, ab.this.mPageId, ab.this.iyS, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, ab.this.mPageId, ab.this.iyS, ab.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, ab.this.mPageId, ab.this.iyS, ab.this.getTbPageTag());
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
                    Rect bc = ay.bc(hVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, ab.this.mContext, ab.this.iyR, false, bc);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, ab.this.mContext, ab.this.iyR, false, bc);
                }
            }
        });
        if (this.iyR == 502) {
            hVar.setNeedFrsTabName(false);
        } else {
            hVar.setNeedFrsTabName(true);
        }
        aVar.c(hVar);
        com.baidu.card.ak a2 = aVar.a(false, viewGroup, this.hUo);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a2);
        aVar2.setPageId(this.mPageId);
        a2.a(this.gAq);
        a2.setSourceForPb(this.iyR);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ab.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    bw bwVar = ((bv) qVar).eji;
                    bwVar.objType = 1;
                    if (ab.this.gAq != null) {
                        ab.this.gAq.a(amVar.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), ab.this.iyR, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
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
            aVar.tW().setPage(this.aht);
        }
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) aVar);
        com.baidu.tieba.frs.j.a(aVar.tW().tQ(), this.iou);
        aVar.setVideoStatsData(ai(bvVar.eji));
        aVar.tW().setPosition(i);
        if (this.iou != null && this.iou.getForum() != null && !StringUtils.isNull(this.iou.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iou.getForum().getTopic_special_icon_right())) {
            bvVar.eji.dz(this.iou.getForum().getTopic_special_icon(), this.iou.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bw>) bvVar.eji);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.gAq);
        if (this.iyS != null) {
            int i2 = 0;
            if (this.iou != null) {
                i2 = this.iou.getTopThreadSize();
            }
            bvVar.eji.ens = (bvVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.czh().a(this.iyS, bvVar.eji);
        com.baidu.tieba.frs.d.c.czh().aw(bvVar.eji);
        com.baidu.tieba.frs.d.c.czh().a(bvVar.eji, csq());
        com.baidu.tieba.frs.d.a.a(bvVar.eji, this.mPageId, this.iyS, getTbPageTag());
        bvVar.eji.bjt();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ai(bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bwVar.bjq() ? "3" : "2";
        if (this.iyS.iNl == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.fkA = this.iyS.iNk;
        oVar.alS = bwVar.getTid();
        oVar.mSource = bwVar.mRecomSource;
        oVar.lRu = bwVar.erE;
        oVar.lRv = bwVar.mRecomWeight;
        oVar.lRy = bwVar.mRecomAbTag;
        if (bwVar.biz() != null) {
            oVar.lRz = bwVar.biz().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void ux(int i) {
        this.iyR = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dK("tid", bwVar.getId()).aj("obj_locate", csq() ? 2 : 1).u("obj_id", bwVar.biB() == null ? -1L : bwVar.biB().live_id).aj("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.z
    public void nZ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iyS;
    }
}
