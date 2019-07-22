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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class s extends com.baidu.tieba.frs.h<bf, com.baidu.card.a<bg>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WN;
    private boolean cbL;
    private ab<bg> dEr;
    private boolean fCe;
    private int fCg;
    private com.baidu.tieba.frs.d.b fCh;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cbL = false;
        this.fCe = false;
        this.fCg = 3;
        this.fCh = new com.baidu.tieba.frs.d.b();
        this.dEr = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (s.this.fty != null) {
                        s.this.fty.a(view, (View) bgVar, (Object) bg.bJx);
                    }
                    if ("c13010".equals(s.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 2).l("fid", bgVar.getFid()).bT("tid", bgVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bgVar.afr()) {
                        com.baidu.tieba.frs.d.c.brF().a(s.this.fCh, bgVar, 1);
                        s.this.ae(bgVar);
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, s.this.mPageId, s.this.fCh);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brF().a(s.this.fCh, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, s.this.mPageId, s.this.fCh);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(s.this.fCh, bgVar.acy());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.brF().a(s.this.fCh, bgVar, 4);
                        s.this.ae(bgVar);
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, s.this.mPageId, s.this.fCh);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, s.this.mPageId, s.this.fCh);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        s.this.ae(bgVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.brF().b(s.this.fCh, bgVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brF().b(s.this.fCh, bgVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.brF().b(s.this.fCh, bgVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.brF().b(s.this.fCh, bgVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.brF().b(s.this.fCh, bgVar, 3);
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
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eYZ);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.dEr);
        a.bq(this.fCg);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.s.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (s.this.dEr != null) {
                        s.this.dEr.a(zVar.getView(), bgVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), s.this.fCg, false);
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
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bf bfVar, com.baidu.card.a<bg> aVar) {
        if (aVar == null) {
            return null;
        }
        if (bfVar == null) {
            return aVar.getView();
        }
        if (aVar.qP() instanceof com.baidu.tieba.a.e) {
            aVar.qP().setPage(this.WN);
        }
        super.onFillViewHolder(i, view, viewGroup, bfVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.qP().qJ(), this.fts);
        aVar.setVideoStatsData(af(bfVar.threadData));
        aVar.qP().setPosition(i);
        if (this.fts != null && this.fts.getForum() != null && !StringUtils.isNull(this.fts.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fts.getForum().getTopic_special_icon_right())) {
            bfVar.threadData.bC(this.fts.getForum().getTopic_special_icon(), this.fts.getForum().getTopic_special_icon_right());
        }
        aVar.a(bfVar.threadData);
        aVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.qP().a(this.dEr);
        if (this.fCh != null) {
            int i2 = 0;
            if (this.fts != null) {
                i2 = this.fts.getTopThreadSize();
            }
            bfVar.threadData.bMn = (bfVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.brF().a(this.fCh, bfVar.threadData);
        com.baidu.tieba.frs.d.c.brF().ak(bfVar.threadData);
        com.baidu.tieba.frs.d.c.brF().a(bfVar.threadData, blG());
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, this.fCh);
        bfVar.threadData.afB();
        return aVar.getView();
    }

    private com.baidu.tieba.play.z af(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bgVar.afy() ? "3" : "2";
        if (this.fCh.fOG == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.eFy = this.fCh.fOF;
        zVar.bWO = bgVar.getTid();
        zVar.mSource = bgVar.mRecomSource;
        zVar.ixy = bgVar.bLu;
        zVar.ixz = bgVar.mRecomWeight;
        zVar.ixB = bgVar.mRecomAbTag;
        if (bgVar.aeO() != null) {
            zVar.ixC = bgVar.aeO().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nC(int i) {
        this.fCg = i;
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bg bgVar) {
        TiebaStatic.log(new an("c12126").bT("tid", bgVar.getId()).P("obj_locate", blG() ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bgVar.aeQ() == null ? -1L : bgVar.aeQ().live_id).P("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.cbL = z;
    }

    @Override // com.baidu.tieba.card.aa
    public void iG(boolean z) {
        this.fCe = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b boU() {
        return this.fCh;
    }
}
