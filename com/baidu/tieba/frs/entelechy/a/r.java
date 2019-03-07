package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.s;
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
import com.baidu.tieba.frs.d.b;
import com.baidu.tieba.frs.d.c;
/* loaded from: classes4.dex */
public class r extends com.baidu.tieba.frs.h<bf, com.baidu.card.a<bg>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String Yz;
    private boolean bSM;
    private ab<bg> dqn;
    private boolean fhd;
    private int fhe;
    private b fhf;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bSM = false;
        this.fhd = false;
        this.fhe = 3;
        this.fhf = new b();
        this.dqn = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (r.this.eYC != null) {
                        r.this.eYC.a(view, (View) bgVar, (Object) bg.bBb);
                    }
                    if ("c13010".equals(r.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").T("obj_type", 2).k(ImageViewerConfig.FORUM_ID, bgVar.getFid()).bJ("tid", bgVar.getTid()));
                    }
                    if (view.getId() == d.g.thread_card_root && bgVar.ZL()) {
                        c.bil().a(r.this.fhf, bgVar, 1);
                        r.this.af(bgVar);
                    } else if (view.getId() == d.g.video_play) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, r.this.mPageId, r.this.fhf);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    } else if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        c.bil().a(r.this.fhf, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, r.this.mPageId, r.this.fhf);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(r.this.fhf, bgVar.WS());
                    } else if (view.getId() == d.g.operable_video_container) {
                        c.bil().a(r.this.fhf, bgVar, 4);
                        r.this.af(bgVar);
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, r.this.mPageId, r.this.fhf);
                    } else if (view.getId() == d.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, r.this.mPageId, r.this.fhf);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        r.this.af(bgVar);
                    }
                    if (view.getId() == d.g.operable_video_container) {
                        c.bil().b(r.this.fhf, bgVar, 1);
                    } else if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        c.bil().b(r.this.fhf, bgVar, 2);
                    } else if (view.getId() == d.g.share_num_container) {
                        c.bil().b(r.this.fhf, bgVar, 5);
                    } else if (view.getId() == d.g.new_agree_view) {
                        c.bil().b(r.this.fhf, bgVar, 4);
                    } else {
                        c.bil().b(r.this.fhf, bgVar, 3);
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
        aVar.rv().setBackgroundResource(d.C0236d.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eEv);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.dqn);
        a.by(this.fhe);
        setOnAdapterItemClickListener(new s() { // from class: com.baidu.tieba.frs.entelechy.a.r.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (r.this.dqn != null) {
                        r.this.dqn.a(zVar.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), r.this.fhe, false);
                    zVar.rx().b(new a.C0037a(1));
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
            aVar.rx().setPage(this.Yz);
        }
        super.onFillViewHolder(i, view, viewGroup, bfVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.rx().rr(), this.eYw);
        aVar.setVideoStatsData(ag(bfVar.threadData));
        aVar.rx().setPosition(i);
        if (this.eYw != null && this.eYw.getForum() != null && !StringUtils.isNull(this.eYw.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.eYw.getForum().getTopic_special_icon_right())) {
            bfVar.threadData.bt(this.eYw.getForum().getTopic_special_icon(), this.eYw.getForum().getTopic_special_icon_right());
        }
        aVar.a(bfVar.threadData);
        aVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rx().a(this.dqn);
        if (this.fhf != null) {
            int i2 = 0;
            if (this.eYw != null) {
                i2 = this.eYw.getTopThreadSize();
            }
            bfVar.threadData.bDP = (bfVar.position + 1) - i2;
        }
        c.bil().a(this.fhf, bfVar.threadData);
        c.bil().al(bfVar.threadData);
        c.bil().b(bfVar.threadData, bcj());
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, this.fhf);
        bfVar.threadData.ZV();
        return aVar.getView();
    }

    private com.baidu.tieba.play.z ag(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bgVar.ZS() ? "3" : "2";
        if (this.fhf.fte == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.ele = this.fhf.ftd;
        zVar.ctx = bgVar.getTid();
        zVar.mSource = bgVar.mRecomSource;
        zVar.hYQ = bgVar.bCX;
        zVar.hYR = bgVar.mRecomWeight;
        zVar.hYT = bgVar.mRecomAbTag;
        if (bgVar.Zi() != null) {
            zVar.hYU = bgVar.Zi().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mD(int i) {
        this.fhe = i;
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.Yz = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(bg bgVar) {
        TiebaStatic.log(new am("c12126").bJ("tid", bgVar.getId()).T("obj_locate", bcj() ? 2 : 1).k(VideoPlayActivityConfig.OBJ_ID, bgVar.Zk() == null ? -1L : bgVar.Zk().live_id).T("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.bSM = z;
    }

    @Override // com.baidu.tieba.card.aa
    public void hS(boolean z) {
        this.fhd = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public b bfz() {
        return this.fhf;
    }
}
