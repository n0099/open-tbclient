package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class z extends com.baidu.tieba.frs.h<bg, com.baidu.card.a<bg>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WN;
    private boolean Yd;
    private boolean cbL;
    private NEGFeedBackView.a dEO;
    private ab<bg> dEr;
    public boolean fBi;
    private boolean fCe;
    private boolean fCf;
    private int fCg;
    private com.baidu.tieba.frs.d.b fCh;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cbL = false;
        this.fCe = false;
        this.Yd = false;
        this.fCf = false;
        this.fCg = 3;
        this.fCh = new com.baidu.tieba.frs.d.b();
        this.dEr = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (z.this.fty != null) {
                        z.this.fty.a(view, (View) bgVar, (Object) bg.bJx);
                    }
                    if ("c13010".equals(z.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 2).l("fid", bgVar.getFid()).bT("tid", bgVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.brF().a(z.this.fCh, bgVar, 1);
                        z.this.ae(bgVar);
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, z.this.mPageId, z.this.fCh);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brF().a(z.this.fCh, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, z.this.mPageId, z.this.fCh);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(z.this.fCh, bgVar.acy());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.brF().a(z.this.fCh, bgVar, 4);
                        z.this.ae(bgVar);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, z.this.mPageId, z.this.fCh);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        z.this.ae(bgVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.brF().b(z.this.fCh, bgVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brF().b(z.this.fCh, bgVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.brF().b(z.this.fCh, bgVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.brF().b(z.this.fCh, bgVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.brF().b(z.this.fCh, bgVar, 3);
                    }
                }
            }
        };
        this.dEO = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.z.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new an("c11973").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11974").bT("obj_locate", sb.toString()).bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bm(176);
        dVar.setPageUniqueId(this.mPageId);
        aVar.c(dVar);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setFrom("frs");
        aVar.b(eVar);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Yd);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bFz = 2;
        dVar2.bFA = 2;
        dVar2.bFE = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bw(this.fCg);
        aaVar.bm(16);
        if (this.fCf) {
            aaVar.bn(4);
        }
        aVar.a(aaVar);
        aVar.qN().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.x qO = aVar.qO();
        com.baidu.card.a aVar2 = new com.baidu.card.a(qO);
        aVar2.setPageId(this.mPageId);
        qO.a(this.dEr);
        qO.bq(this.fCg);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.z.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bg bgVar = (bg) mVar;
                    bgVar.objType = 1;
                    if (z.this.dEr != null) {
                        z.this.dEr.a(zVar.getView(), bgVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), z.this.fCg, false);
                    zVar.qP().b(new a.C0038a(1));
                }
            }
        });
        aVar2.qR();
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
        if (aVar.qP() instanceof com.baidu.tieba.a.e) {
            aVar.qP().setPage(this.WN);
        }
        super.onFillViewHolder(i, view, viewGroup, bgVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.qP().qJ(), this.fts);
        aVar.setVideoStatsData(af(bgVar));
        if (this.fts != null && this.fts.getForum() != null && !StringUtils.isNull(this.fts.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fts.getForum().getTopic_special_icon_right())) {
            bgVar.bC(this.fts.getForum().getTopic_special_icon(), this.fts.getForum().getTopic_special_icon_right());
        }
        boolean z = (bgVar.aex() == null || bgVar.aex().getUserId() == null || !bgVar.aex().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.afG() && bgVar.adg() != null && !z) {
            aVar.qQ().a(this.dEO);
        }
        aVar.qS();
        aVar.a(bgVar);
        aVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.qP().a(this.dEr);
        if (this.fCh != null) {
            bgVar.bMn = (i + 1) - (this.fts != null ? this.fts.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.brF().a(this.fCh, bgVar);
        com.baidu.tieba.frs.d.c.brF().ak(bgVar);
        com.baidu.tieba.frs.d.c.brF().a(bgVar, blG());
        com.baidu.tieba.frs.d.a.a(bgVar, this.mPageId, this.fCh);
        bgVar.afB();
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

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bg bgVar) {
        TiebaStatic.log(new an("c12126").bT("tid", bgVar.getId()).P("obj_locate", blG() ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bgVar.aeQ() == null ? -1L : bgVar.aeQ().live_id).P("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void iG(boolean z) {
        this.fCe = z;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b boU() {
        return this.fCh;
    }

    public void kx(boolean z) {
        this.fCf = z;
    }
}
