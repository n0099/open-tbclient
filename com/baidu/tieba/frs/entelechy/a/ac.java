package com.baidu.tieba.frs.entelechy.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.b;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class ac extends com.baidu.tieba.frs.k<bx, com.baidu.card.a<by>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aiw;
    private com.baidu.tieba.card.ab<by> hbz;
    private int jcT;
    private com.baidu.tieba.frs.d.b jcU;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jcT = 3;
        this.jcU = new com.baidu.tieba.frs.d.b();
        this.hbz = new com.baidu.tieba.card.ab<by>() { // from class: com.baidu.tieba.frs.entelechy.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                if (view != null && byVar != null) {
                    if (ac.this.iSB != null) {
                        ac.this.iSB.a(view, (View) byVar, (Object) by.eJq);
                    }
                    if ("c13010".equals(ac.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").al("obj_type", 2).w("fid", byVar.getFid()).dY("tid", byVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && byVar.bnv()) {
                        com.baidu.tieba.frs.d.c.cJI().a(ac.this.jcU, byVar, 1);
                        ac.this.as(byVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cJI().a(ac.this.jcU, byVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.k.a(ac.this.jcU, byVar.bmo());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.cJI().a(ac.this.jcU, byVar, 4);
                        ac.this.as(byVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ac.this.as(byVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 4, ac.this.mPageId, ac.this.jcU, ac.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(byVar, 4, ac.this.mPageId, ac.this.jcU, ac.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(byVar, 2, ac.this.mPageId, ac.this.jcU, ac.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 5, ac.this.mPageId, ac.this.jcU, ac.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(byVar, 15, ac.this.mPageId, ac.this.jcU, ac.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 14, ac.this.mPageId, ac.this.jcU, ac.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(byVar, 1, ac.this.mPageId, ac.this.jcU, ac.this.getTbPageTag());
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
        hVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ac.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bn = az.bn(hVar.getVideoContainer());
                    if (!(aVar2 instanceof by)) {
                        az.a(aVar2, ac.this.mContext, ac.this.jcT, false, bn);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, ac.this.mContext, ac.this.jcT, false, bn);
                }
            }
        });
        if (this.jcT == 502) {
            hVar.setNeedFrsTabName(false);
        } else {
            hVar.setNeedFrsTabName(true);
        }
        aVar.c(hVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.iyv);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a2);
        aVar2.setPageId(this.mPageId);
        a2.a(this.hbz);
        a2.setSourceForPb(this.jcT);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ac.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bx) && (view.getTag() instanceof com.baidu.card.am)) {
                    com.baidu.card.am amVar = (com.baidu.card.am) view.getTag();
                    by byVar = ((bx) qVar).eCR;
                    byVar.objType = 1;
                    if (ac.this.hbz != null) {
                        ac.this.hbz.a(amVar.getView(), byVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), ac.this.jcT, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar.tZ().b(new a.C0097a(1));
                }
            }
        });
        aVar2.aO(false);
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, com.baidu.card.a<by> aVar) {
        if (aVar == null) {
            return null;
        }
        if (bxVar == null) {
            return aVar.getView();
        }
        if (aVar.tZ() instanceof com.baidu.tieba.a.e) {
            aVar.tZ().setPage(this.aiw);
        }
        super.a(i, view, viewGroup, (ViewGroup) bxVar, (bx) aVar);
        com.baidu.tieba.frs.j.a(aVar.tZ().tT(), this.iSv);
        aVar.setVideoStatsData(ak(bxVar.eCR));
        aVar.tZ().setPosition(i);
        if (this.iSv != null && this.iSv.getForum() != null && !StringUtils.isNull(this.iSv.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iSv.getForum().getTopic_special_icon_right())) {
            bxVar.eCR.dL(this.iSv.getForum().getTopic_special_icon(), this.iSv.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<by>) bxVar.eCR);
        aVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tZ().a(this.hbz);
        if (this.jcU != null) {
            int i2 = 0;
            if (this.iSv != null) {
                i2 = this.iSv.getTopThreadSize();
            }
            bxVar.eCR.eHa = (bxVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.cJI().a(this.jcU, bxVar.eCR);
        com.baidu.tieba.frs.d.c.cJI().ay(bxVar.eCR);
        com.baidu.tieba.frs.d.c.cJI().a(bxVar.eCR, cBS());
        com.baidu.tieba.frs.d.a.a(bxVar.eCR, this.mPageId, this.jcU, getTbPageTag());
        bxVar.eCR.bqd();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ak(by byVar) {
        if (byVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = byVar.bqa() ? "3" : "2";
        if (this.jcU.jtU == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.fFV = this.jcU.jtT;
        oVar.amY = byVar.getTid();
        oVar.mSource = byVar.mRecomSource;
        oVar.myq = byVar.eLn;
        oVar.myr = byVar.mRecomWeight;
        oVar.myu = byVar.mRecomAbTag;
        if (byVar.bph() != null) {
            oVar.myv = byVar.bph().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
        this.jcT = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(by byVar) {
        TiebaStatic.log(new ar("c12126").dY("tid", byVar.getId()).al("obj_locate", cBS() ? 2 : 1).w("obj_id", byVar.bpj() == null ? -1L : byVar.bpj().live_id).al("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void oZ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.jcU;
    }
}
