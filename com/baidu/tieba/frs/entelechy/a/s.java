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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class s extends com.baidu.tieba.frs.h<bg, com.baidu.card.a<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WN;
    private boolean cbS;
    private ab<bh> dEy;
    private boolean fCS;
    private int fCU;
    private com.baidu.tieba.frs.d.b fCV;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cbS = false;
        this.fCS = false;
        this.fCU = 3;
        this.fCV = new com.baidu.tieba.frs.d.b();
        this.dEy = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (s.this.ftX != null) {
                        s.this.ftX.a(view, (View) bhVar, (Object) bh.bJC);
                    }
                    if ("c13010".equals(s.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 2).l("fid", bhVar.getFid()).bT("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bhVar.afs()) {
                        com.baidu.tieba.frs.d.c.brS().a(s.this.fCV, bhVar, 1);
                        s.this.af(bhVar);
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 4, s.this.mPageId, s.this.fCV);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brS().a(s.this.fCV, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, s.this.mPageId, s.this.fCV);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(s.this.fCV, bhVar.acz());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.brS().a(s.this.fCV, bhVar, 4);
                        s.this.af(bhVar);
                        com.baidu.tieba.frs.d.a.a(bhVar, 4, s.this.mPageId, s.this.fCV);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, s.this.mPageId, s.this.fCV);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        s.this.af(bhVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.brS().b(s.this.fCV, bhVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brS().b(s.this.fCV, bhVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.brS().b(s.this.fCV, bhVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.brS().b(s.this.fCV, bhVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.brS().b(s.this.fCV, bhVar, 3);
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
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eZn);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.dEy);
        a.bq(this.fCU);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.s.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).threadData;
                    bhVar.objType = 1;
                    if (s.this.dEy != null) {
                        s.this.dEy.a(zVar.getView(), bhVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), s.this.fCU, false);
                    zVar.qP().b(new a.C0038a(1));
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
        if (aVar.qP() instanceof com.baidu.tieba.a.e) {
            aVar.qP().setPage(this.WN);
        }
        super.onFillViewHolder(i, view, viewGroup, bgVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.qP().qJ(), this.ftR);
        aVar.setVideoStatsData(ag(bgVar.threadData));
        aVar.qP().setPosition(i);
        if (this.ftR != null && this.ftR.getForum() != null && !StringUtils.isNull(this.ftR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.ftR.getForum().getTopic_special_icon_right())) {
            bgVar.threadData.bC(this.ftR.getForum().getTopic_special_icon(), this.ftR.getForum().getTopic_special_icon_right());
        }
        aVar.a(bgVar.threadData);
        aVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.qP().a(this.dEy);
        if (this.fCV != null) {
            int i2 = 0;
            if (this.ftR != null) {
                i2 = this.ftR.getTopThreadSize();
            }
            bgVar.threadData.bMs = (bgVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.brS().a(this.fCV, bgVar.threadData);
        com.baidu.tieba.frs.d.c.brS().al(bgVar.threadData);
        com.baidu.tieba.frs.d.c.brS().a(bgVar.threadData, blN());
        com.baidu.tieba.frs.d.a.a(bgVar.threadData, this.mPageId, this.fCV);
        bgVar.threadData.afC();
        return aVar.getView();
    }

    private com.baidu.tieba.play.z ag(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bhVar.afz() ? "3" : "2";
        if (this.fCV.fPu == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.eFF = this.fCV.fPt;
        zVar.bWU = bhVar.getTid();
        zVar.mSource = bhVar.mRecomSource;
        zVar.iyB = bhVar.bLz;
        zVar.iyC = bhVar.mRecomWeight;
        zVar.iyE = bhVar.mRecomAbTag;
        if (bhVar.aeP() != null) {
            zVar.iyF = bhVar.aeP().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nD(int i) {
        this.fCU = i;
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(bh bhVar) {
        TiebaStatic.log(new an("c12126").bT("tid", bhVar.getId()).P("obj_locate", blN() ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bhVar.aeR() == null ? -1L : bhVar.aeR().live_id).P("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.cbS = z;
    }

    @Override // com.baidu.tieba.card.aa
    public void iG(boolean z) {
        this.fCS = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bph() {
        return this.fCV;
    }
}
