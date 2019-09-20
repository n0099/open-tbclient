package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class s extends com.baidu.tieba.frs.h<bg, com.baidu.card.a<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WM;
    private boolean ccM;
    private ab<bh> dGj;
    private boolean fEF;
    private int fEH;
    private com.baidu.tieba.frs.d.b fEI;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ccM = false;
        this.fEF = false;
        this.fEH = 3;
        this.fEI = new com.baidu.tieba.frs.d.b();
        this.dGj = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (s.this.fvK != null) {
                        s.this.fvK.a(view, (View) bhVar, (Object) bh.bKa);
                    }
                    if ("c13010".equals(s.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 2).n("fid", bhVar.getFid()).bT("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bhVar.afw()) {
                        com.baidu.tieba.frs.d.c.bsF().a(s.this.fEI, bhVar, 1);
                        s.this.ag(bhVar);
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 4, s.this.mPageId, s.this.fEI);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bsF().a(s.this.fEI, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, s.this.mPageId, s.this.fEI);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(s.this.fEI, bhVar.acD());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bsF().a(s.this.fEI, bhVar, 4);
                        s.this.ag(bhVar);
                        com.baidu.tieba.frs.d.a.a(bhVar, 4, s.this.mPageId, s.this.fEI);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, s.this.mPageId, s.this.fEI);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        s.this.ag(bhVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bsF().b(s.this.fEI, bhVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bsF().b(s.this.fEI, bhVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bsF().b(s.this.fEI, bhVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bsF().b(s.this.fEI, bhVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bsF().b(s.this.fEI, bhVar, 3);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public com.baidu.card.a onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity(), true);
        eVar.setFrom("frs");
        aVar.b(eVar);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.faT);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.dGj);
        a.bq(this.fEH);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.s.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).threadData;
                    bhVar.objType = 1;
                    if (s.this.dGj != null) {
                        s.this.dGj.a(zVar.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), s.this.fEH, false);
                    zVar.qQ().b(new a.C0038a(1));
                }
            }
        });
        aVar2.aD(false);
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.a<bh> aVar) {
        if (aVar == null) {
            return null;
        }
        if (bgVar == null) {
            return aVar.getView();
        }
        if (aVar.qQ() instanceof com.baidu.tieba.a.e) {
            aVar.qQ().setPage(this.WM);
        }
        super.onFillViewHolder(i, view, viewGroup, bgVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.qQ().qK(), this.fvE);
        aVar.setVideoStatsData(ah(bgVar.threadData));
        aVar.qQ().setPosition(i);
        if (this.fvE != null && this.fvE.getForum() != null && !StringUtils.isNull(this.fvE.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fvE.getForum().getTopic_special_icon_right())) {
            bgVar.threadData.bC(this.fvE.getForum().getTopic_special_icon(), this.fvE.getForum().getTopic_special_icon_right());
        }
        aVar.a(bgVar.threadData);
        aVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.qQ().a(this.dGj);
        if (this.fEI != null) {
            int i2 = 0;
            if (this.fvE != null) {
                i2 = this.fvE.getTopThreadSize();
            }
            bgVar.threadData.bMQ = (bgVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bsF().a(this.fEI, bgVar.threadData);
        com.baidu.tieba.frs.d.c.bsF().am(bgVar.threadData);
        com.baidu.tieba.frs.d.c.bsF().a(bgVar.threadData, bmy());
        com.baidu.tieba.frs.d.a.a(bgVar.threadData, this.mPageId, this.fEI);
        bgVar.threadData.afG();
        return aVar.getView();
    }

    private com.baidu.tieba.play.z ah(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bhVar.afD() ? "3" : "2";
        if (this.fEI.fRl == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.eHo = this.fEI.fRk;
        zVar.bXN = bhVar.getTid();
        zVar.mSource = bhVar.mRecomSource;
        zVar.iAD = bhVar.bLX;
        zVar.iAE = bhVar.mRecomWeight;
        zVar.iAG = bhVar.mRecomAbTag;
        if (bhVar.aeT() != null) {
            zVar.iAH = bhVar.aeT().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nH(int i) {
        this.fEH = i;
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
        this.WM = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(bh bhVar) {
        TiebaStatic.log(new an("c12126").bT("tid", bhVar.getId()).P("obj_locate", bmy() ? 2 : 1).n(VideoPlayActivityConfig.OBJ_ID, bhVar.aeV() == null ? -1L : bhVar.aeV().live_id).P("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.ccM = z;
    }

    @Override // com.baidu.tieba.card.aa
    public void iJ(boolean z) {
        this.fEF = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bpS() {
        return this.fEI;
    }
}
