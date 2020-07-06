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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ab extends com.baidu.tieba.frs.j<bt, com.baidu.card.a<bu>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String afG;
    private com.baidu.tieba.card.aa<bu> fRu;
    private int hID;
    private com.baidu.tieba.frs.d.b hIE;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hID = 3;
        this.hIE = new com.baidu.tieba.frs.d.b();
        this.fRu = new com.baidu.tieba.card.aa<bu>() { // from class: com.baidu.tieba.frs.entelechy.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bu buVar) {
                if (view != null && buVar != null) {
                    if (ab.this.hzo != null) {
                        ab.this.hzo.a(view, (View) buVar, (Object) bu.dLH);
                    }
                    if ("c13010".equals(ab.this.mFrom)) {
                        TiebaStatic.log(new ao("c13010").ag("obj_type", 2).s("fid", buVar.getFid()).dk("tid", buVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && buVar.aQV()) {
                        com.baidu.tieba.frs.d.c.cer().a(ab.this.hIE, buVar, 1);
                        ab.this.as(buVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ao(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cer().a(ab.this.hIE, buVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(ab.this.hIE, buVar.aPT());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.cer().a(ab.this.hIE, buVar, 4);
                        ab.this.as(buVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ab.this.as(buVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(buVar, 4, ab.this.mPageId, ab.this.hIE, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(buVar, 4, ab.this.mPageId, ab.this.hIE, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(buVar, 2, ab.this.mPageId, ab.this.hIE, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(buVar, 5, ab.this.mPageId, ab.this.hIE, ab.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(buVar, 15, ab.this.mPageId, ab.this.hIE, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(buVar, 14, ab.this.mPageId, ab.this.hIE, ab.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(buVar, 1, ab.this.mPageId, ab.this.hIE, ab.this.getTbPageTag());
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
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity(), true);
        gVar.setFrom("frs");
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ab.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aQ = aw.aQ(gVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bu)) {
                        aw.a(absThreadDataSupport, ab.this.mContext, ab.this.hID, false, aQ);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    aw.a(absThreadDataSupport, ab.this.mContext, ab.this.hID, false, aQ);
                }
            }
        });
        if (this.hID == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        aVar.c(gVar);
        com.baidu.card.ai a = aVar.a(false, viewGroup, this.hfK);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.fRu);
        a.setSourceForPb(this.hID);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.ab.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bt) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar = (com.baidu.card.ak) view.getTag();
                    bu buVar = ((bt) qVar).dLi;
                    buVar.objType = 1;
                    if (ab.this.fRu != null) {
                        ab.this.fRu.a(akVar.getView(), buVar);
                    }
                    aw.a((AbsThreadDataSupport) buVar, view.getContext(), ab.this.hID, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    akVar.se().b(new a.C0098a(1));
                }
            }
        });
        aVar2.aJ(false);
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, com.baidu.card.a<bu> aVar) {
        if (aVar == null) {
            return null;
        }
        if (btVar == null) {
            return aVar.getView();
        }
        if (aVar.se() instanceof com.baidu.tieba.a.e) {
            aVar.se().setPage(this.afG);
        }
        super.a(i, view, viewGroup, (ViewGroup) btVar, (bt) aVar);
        com.baidu.tieba.frs.i.a(aVar.se().rY(), this.hzi);
        aVar.setVideoStatsData(ak(btVar.dLi));
        aVar.se().setPosition(i);
        if (this.hzi != null && this.hzi.getForum() != null && !StringUtils.isNull(this.hzi.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hzi.getForum().getTopic_special_icon_right())) {
            btVar.dLi.db(this.hzi.getForum().getTopic_special_icon(), this.hzi.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bu>) btVar.dLi);
        aVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.se().a(this.fRu);
        if (this.hIE != null) {
            int i2 = 0;
            if (this.hzi != null) {
                i2 = this.hzi.getTopThreadSize();
            }
            btVar.dLi.dJw = (btVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.cer().a(this.hIE, btVar.dLi);
        com.baidu.tieba.frs.d.c.cer().ay(btVar.dLi);
        com.baidu.tieba.frs.d.c.cer().a(btVar.dLi, bXN());
        com.baidu.tieba.frs.d.a.a(btVar.dLi, this.mPageId, this.hIE, getTbPageTag());
        btVar.dLi.aTB();
        return aVar.getView();
    }

    private com.baidu.tieba.play.y ak(bu buVar) {
        if (buVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = buVar.aTy() ? "3" : "2";
        if (this.hIE.hWP == 501) {
            yVar.mLocate = "frs_tab";
        }
        yVar.eEs = this.hIE.hWO;
        yVar.ajO = buVar.getTid();
        yVar.mSource = buVar.mRecomSource;
        yVar.kVo = buVar.dND;
        yVar.kVp = buVar.mRecomWeight;
        yVar.kVs = buVar.mRecomAbTag;
        if (buVar.aSH() != null) {
            yVar.kVt = buVar.aSH().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
        this.hID = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bu buVar) {
        TiebaStatic.log(new ao("c12126").dk("tid", buVar.getId()).ag("obj_locate", bXN() ? 2 : 1).s("obj_id", buVar.aSJ() == null ? -1L : buVar.aSJ().live_id).ag("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.z
    public void me(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hIE;
    }
}
