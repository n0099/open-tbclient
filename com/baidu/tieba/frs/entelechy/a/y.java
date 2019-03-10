package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.d.b;
import com.baidu.tieba.frs.d.c;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class y extends com.baidu.tieba.frs.h<bg, com.baidu.card.a<bg>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String Yz;
    private boolean ZO;
    private boolean bSM;
    private NEGFeedBackView.a dqM;
    private ab<bg> dqn;
    public boolean fgm;
    private boolean fhd;
    private int fhe;
    private b fhf;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bSM = false;
        this.fhd = false;
        this.ZO = false;
        this.fhe = 3;
        this.fhf = new b();
        this.dqn = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (y.this.eYC != null) {
                        y.this.eYC.a(view, (View) bgVar, (Object) bg.bBb);
                    }
                    if ("c13010".equals(y.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").T("obj_type", 2).k(ImageViewerConfig.FORUM_ID, bgVar.getFid()).bJ("tid", bgVar.getTid()));
                    }
                    if (view.getId() == d.g.thread_card_root) {
                        c.bim().a(y.this.fhf, bgVar, 1);
                        y.this.af(bgVar);
                    } else if (view.getId() == d.g.video_play) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, y.this.mPageId, y.this.fhf);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    } else if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        c.bim().a(y.this.fhf, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, y.this.mPageId, y.this.fhf);
                    } else if (view.getId() == d.g.header_divider) {
                        com.baidu.tieba.frs.f.h.a(y.this.fhf, bgVar.WS());
                    } else if (view.getId() == d.g.operable_video_container) {
                        c.bim().a(y.this.fhf, bgVar, 4);
                        y.this.af(bgVar);
                    } else if (view.getId() == d.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, y.this.mPageId, y.this.fhf);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        y.this.af(bgVar);
                    }
                    if (view.getId() == d.g.operable_video_container) {
                        c.bim().b(y.this.fhf, bgVar, 1);
                    } else if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        c.bim().b(y.this.fhf, bgVar, 2);
                    } else if (view.getId() == d.g.share_num_container) {
                        c.bim().b(y.this.fhf, bgVar, 5);
                    } else if (view.getId() == d.g.new_agree_view) {
                        c.bim().b(y.this.fhf, bgVar, 4);
                    } else {
                        c.bim().b(y.this.fhf, bgVar, 3);
                    }
                }
            }
        };
        this.dqM = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.y.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new am("c11973").bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
                if (arrayList != null && ajVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new am("c11974").bJ("obj_locate", sb.toString()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
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
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bu(176);
        dVar.setPageUniqueId(this.mPageId);
        aVar.c(dVar);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setFrom("frs");
        aVar.b(eVar);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.ZO);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bxh = 2;
        dVar2.bxi = 2;
        dVar2.bxm = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bA(this.fhe);
        aaVar.bu(16);
        aVar.a(aaVar);
        aVar.rv().setBackgroundResource(d.f.addresslist_item_bg);
        com.baidu.card.x rw = aVar.rw();
        com.baidu.card.a aVar2 = new com.baidu.card.a(rw);
        aVar2.setPageId(this.mPageId);
        rw.a(this.dqn);
        rw.by(this.fhe);
        setOnAdapterItemClickListener(new s() { // from class: com.baidu.tieba.frs.entelechy.a.y.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bg bgVar = (bg) mVar;
                    bgVar.objType = 1;
                    if (y.this.dqn != null) {
                        y.this.dqn.a(zVar.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), y.this.fhe, false);
                    zVar.rx().b(new a.C0037a(1));
                }
            }
        });
        aVar2.rz();
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.a<bg> aVar) {
        if (aVar == null) {
            return null;
        }
        if (bgVar == null) {
            return aVar.getView();
        }
        if (aVar.rx() instanceof com.baidu.tieba.a.e) {
            aVar.rx().setPage(this.Yz);
        }
        super.onFillViewHolder(i, view, viewGroup, bgVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.rx().rr(), this.eYw);
        aVar.setVideoStatsData(ag(bgVar));
        if (this.eYw != null && this.eYw.getForum() != null && !StringUtils.isNull(this.eYw.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.eYw.getForum().getTopic_special_icon_right())) {
            bgVar.bt(this.eYw.getForum().getTopic_special_icon(), this.eYw.getForum().getTopic_special_icon_right());
        }
        boolean z = (bgVar.YR() == null || bgVar.YR().getUserId() == null || !bgVar.YR().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.aaa() && bgVar.XA() != null && !z) {
            aVar.ry().a(this.dqM);
        }
        aVar.rA();
        aVar.a(bgVar);
        aVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rx().a(this.dqn);
        if (this.fhf != null) {
            bgVar.bDP = (i + 1) - (this.eYw != null ? this.eYw.getTopThreadSize() : 0);
        }
        c.bim().a(this.fhf, bgVar);
        c.bim().al(bgVar);
        c.bim().b(bgVar, bck());
        com.baidu.tieba.frs.d.a.a(bgVar, this.mPageId, this.fhf);
        bgVar.ZV();
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
        zVar.hYR = bgVar.bCX;
        zVar.hYS = bgVar.mRecomWeight;
        zVar.hYU = bgVar.mRecomAbTag;
        if (bgVar.Zi() != null) {
            zVar.hYV = bgVar.Zi().video_md5;
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
    public void qN(String str) {
        this.Yz = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(bg bgVar) {
        TiebaStatic.log(new am("c12126").bJ("tid", bgVar.getId()).T("obj_locate", bck() ? 2 : 1).k(VideoPlayActivityConfig.OBJ_ID, bgVar.Zk() == null ? -1L : bgVar.Zk().live_id).T("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void hS(boolean z) {
        this.fhd = z;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.ZO = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public b bfA() {
        return this.fhf;
    }
}
