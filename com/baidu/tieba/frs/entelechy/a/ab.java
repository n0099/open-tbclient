package com.baidu.tieba.frs.entelechy.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.b;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ab extends com.baidu.tieba.frs.j<bu, com.baidu.card.a<bv>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String afx;
    private com.baidu.tieba.card.aa<bv> fWN;
    private int hOD;
    private com.baidu.tieba.frs.d.b hOE;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hOD = 3;
        this.hOE = new com.baidu.tieba.frs.d.b();
        this.fWN = new com.baidu.tieba.card.aa<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    if (ab.this.hFd != null) {
                        ab.this.hFd.a(view, (View) bvVar, (Object) bv.dRS);
                    }
                    if ("c13010".equals(ab.this.mFrom)) {
                        TiebaStatic.log(new ap("c13010").ah("obj_type", 2).t("fid", bvVar.getFid()).dn("tid", bvVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bvVar.aUR()) {
                        com.baidu.tieba.frs.d.c.chQ().a(ab.this.hOE, bvVar, 1);
                        ab.this.ap(bvVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.chQ().a(ab.this.hOE, bvVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(ab.this.hOE, bvVar.aTO());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.chQ().a(ab.this.hOE, bvVar, 4);
                        ab.this.ap(bvVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ab.this.ap(bvVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 4, ab.this.mPageId, ab.this.hOE, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 4, ab.this.mPageId, ab.this.hOE, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 2, ab.this.mPageId, ab.this.hOE, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 5, ab.this.mPageId, ab.this.hOE, ab.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 15, ab.this.mPageId, ab.this.hOE, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 14, ab.this.mPageId, ab.this.hOE, ab.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bvVar, 1, ab.this.mPageId, ab.this.hOE, ab.this.getTbPageTag());
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
    public com.baidu.card.a b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity(), true);
        gVar.setFrom("frs");
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ab.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aW = ax.aW(gVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bv)) {
                        ax.a(absThreadDataSupport, ab.this.mContext, ab.this.hOD, false, aW);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ax.a(absThreadDataSupport, ab.this.mContext, ab.this.hOD, false, aW);
                }
            }
        });
        if (this.hOD == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        aVar.c(gVar);
        com.baidu.card.ai a = aVar.a(false, viewGroup, this.hlu);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.fWN);
        a.setSourceForPb(this.hOD);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.ab.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bu) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar = (com.baidu.card.ak) view.getTag();
                    bv bvVar = ((bu) qVar).dLK;
                    bvVar.objType = 1;
                    if (ab.this.fWN != null) {
                        ab.this.fWN.a(akVar.getView(), bvVar);
                    }
                    ax.a((AbsThreadDataSupport) bvVar, view.getContext(), ab.this.hOD, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    akVar.sg().b(new a.C0096a(1));
                }
            }
        });
        aVar2.aL(false);
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, com.baidu.card.a<bv> aVar) {
        if (aVar == null) {
            return null;
        }
        if (buVar == null) {
            return aVar.getView();
        }
        if (aVar.sg() instanceof com.baidu.tieba.a.e) {
            aVar.sg().setPage(this.afx);
        }
        super.a(i, view, viewGroup, (ViewGroup) buVar, (bu) aVar);
        com.baidu.tieba.frs.i.a(aVar.sg().sa(), this.hEX);
        aVar.setVideoStatsData(ah(buVar.dLK));
        aVar.sg().setPosition(i);
        if (this.hEX != null && this.hEX.getForum() != null && !StringUtils.isNull(this.hEX.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hEX.getForum().getTopic_special_icon_right())) {
            buVar.dLK.de(this.hEX.getForum().getTopic_special_icon(), this.hEX.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bv>) buVar.dLK);
        aVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.sg().a(this.fWN);
        if (this.hOE != null) {
            int i2 = 0;
            if (this.hEX != null) {
                i2 = this.hEX.getTopThreadSize();
            }
            buVar.dLK.dPI = (buVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.chQ().a(this.hOE, buVar.dLK);
        com.baidu.tieba.frs.d.c.chQ().av(buVar.dLK);
        com.baidu.tieba.frs.d.c.chQ().a(buVar.dLK, cbj());
        com.baidu.tieba.frs.d.a.a(buVar.dLK, this.mPageId, this.hOE, getTbPageTag());
        buVar.dLK.aXx();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ah(bv bvVar) {
        if (bvVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bvVar.aXu() ? "3" : "2";
        if (this.hOE.icN == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.eKO = this.hOE.icM;
        oVar.ajJ = bvVar.getTid();
        oVar.mSource = bvVar.mRecomSource;
        oVar.lcH = bvVar.dTO;
        oVar.lcI = bvVar.mRecomWeight;
        oVar.lcL = bvVar.mRecomAbTag;
        if (bvVar.aWD() != null) {
            oVar.lcM = bvVar.aWD().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
        this.hOD = i;
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bv bvVar) {
        TiebaStatic.log(new ap("c12126").dn("tid", bvVar.getId()).ah("obj_locate", cbj() ? 2 : 1).t("obj_id", bvVar.aWF() == null ? -1L : bvVar.aWF().live_id).ah("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.z
    public void mJ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hOE;
    }
}
