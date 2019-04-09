package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class r extends com.baidu.tieba.frs.h<bf, com.baidu.card.a<bg>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String YB;
    private boolean bSQ;
    private ab<bg> dqp;
    private boolean fgO;
    private int fgP;
    private com.baidu.tieba.frs.d.b fgQ;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bSQ = false;
        this.fgO = false;
        this.fgP = 3;
        this.fgQ = new com.baidu.tieba.frs.d.b();
        this.dqp = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (r.this.eYo != null) {
                        r.this.eYo.a(view, (View) bgVar, (Object) bg.bBh);
                    }
                    if ("c13010".equals(r.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").T("obj_type", 2).k(ImageViewerConfig.FORUM_ID, bgVar.getFid()).bJ("tid", bgVar.getTid()));
                    }
                    if (view.getId() == d.g.thread_card_root && bgVar.ZI()) {
                        com.baidu.tieba.frs.d.c.bij().a(r.this.fgQ, bgVar, 1);
                        r.this.ae(bgVar);
                    } else if (view.getId() == d.g.video_play) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, r.this.mPageId, r.this.fgQ);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    } else if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        com.baidu.tieba.frs.d.c.bij().a(r.this.fgQ, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, r.this.mPageId, r.this.fgQ);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(r.this.fgQ, bgVar.WP());
                    } else if (view.getId() == d.g.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bij().a(r.this.fgQ, bgVar, 4);
                        r.this.ae(bgVar);
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, r.this.mPageId, r.this.fgQ);
                    } else if (view.getId() == d.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, r.this.mPageId, r.this.fgQ);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        r.this.ae(bgVar);
                    }
                    if (view.getId() == d.g.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bij().b(r.this.fgQ, bgVar, 1);
                    } else if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        com.baidu.tieba.frs.d.c.bij().b(r.this.fgQ, bgVar, 2);
                    } else if (view.getId() == d.g.share_num_container) {
                        com.baidu.tieba.frs.d.c.bij().b(r.this.fgQ, bgVar, 5);
                    } else if (view.getId() == d.g.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bij().b(r.this.fgQ, bgVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bij().b(r.this.fgQ, bgVar, 3);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.card.a onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity(), true);
        eVar.setFrom("frs");
        aVar.b(eVar);
        aVar.rv().setBackgroundResource(d.C0277d.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eEd);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.dqp);
        a.bx(this.fgP);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.r.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (r.this.dqp != null) {
                        r.this.dqp.a(zVar.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), r.this.fgP, false);
                    zVar.rx().b(new a.C0039a(1));
                }
            }
        });
        aVar2.aI(false);
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
        if (aVar.rx() instanceof com.baidu.tieba.a.e) {
            aVar.rx().setPage(this.YB);
        }
        super.onFillViewHolder(i, view, viewGroup, bfVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.rx().rr(), this.eYi);
        aVar.setVideoStatsData(af(bfVar.threadData));
        aVar.rx().setPosition(i);
        if (this.eYi != null && this.eYi.getForum() != null && !StringUtils.isNull(this.eYi.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.eYi.getForum().getTopic_special_icon_right())) {
            bfVar.threadData.bt(this.eYi.getForum().getTopic_special_icon(), this.eYi.getForum().getTopic_special_icon_right());
        }
        aVar.a(bfVar.threadData);
        aVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rx().a(this.dqp);
        if (this.fgQ != null) {
            int i2 = 0;
            if (this.eYi != null) {
                i2 = this.eYi.getTopThreadSize();
            }
            bfVar.threadData.bDV = (bfVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bij().a(this.fgQ, bfVar.threadData);
        com.baidu.tieba.frs.d.c.bij().ak(bfVar.threadData);
        com.baidu.tieba.frs.d.c.bij().a(bfVar.threadData, bch());
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, this.fgQ);
        bfVar.threadData.ZS();
        return aVar.getView();
    }

    private com.baidu.tieba.play.z af(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bgVar.ZP() ? "3" : "2";
        if (this.fgQ.fsP == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.ekN = this.fgQ.fsO;
        zVar.ctx = bgVar.getTid();
        zVar.mSource = bgVar.mRecomSource;
        zVar.hYy = bgVar.bDd;
        zVar.hYz = bgVar.mRecomWeight;
        zVar.hYB = bgVar.mRecomAbTag;
        if (bgVar.Zf() != null) {
            zVar.hYC = bgVar.Zf().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mC(int i) {
        this.fgP = i;
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YB = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bg bgVar) {
        TiebaStatic.log(new am("c12126").bJ("tid", bgVar.getId()).T("obj_locate", bch() ? 2 : 1).k(VideoPlayActivityConfig.OBJ_ID, bgVar.Zh() == null ? -1L : bgVar.Zh().live_id).T("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.bSQ = z;
    }

    @Override // com.baidu.tieba.card.aa
    public void hS(boolean z) {
        this.fgO = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bfx() {
        return this.fgQ;
    }
}
