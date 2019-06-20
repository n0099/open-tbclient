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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class z extends com.baidu.tieba.frs.h<bg, com.baidu.card.a<bg>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String Ws;
    private boolean XI;
    private boolean caJ;
    private ab<bg> dAV;
    private NEGFeedBackView.a dBs;
    public boolean fwm;
    private boolean fxi;
    private boolean fxj;
    private int fxk;
    private com.baidu.tieba.frs.d.b fxl;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.caJ = false;
        this.fxi = false;
        this.XI = false;
        this.fxj = false;
        this.fxk = 3;
        this.fxl = new com.baidu.tieba.frs.d.b();
        this.dAV = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (z.this.foz != null) {
                        z.this.foz.a(view, (View) bgVar, (Object) bg.bIx);
                    }
                    if ("c13010".equals(z.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").P("obj_type", 2).l("fid", bgVar.getFid()).bT("tid", bgVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.bpE().a(z.this.fxl, bgVar, 1);
                        z.this.ae(bgVar);
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, z.this.mPageId, z.this.fxl);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpE().a(z.this.fxl, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, z.this.mPageId, z.this.fxl);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(z.this.fxl, bgVar.abw());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bpE().a(z.this.fxl, bgVar, 4);
                        z.this.ae(bgVar);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, z.this.mPageId, z.this.fxl);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        z.this.ae(bgVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bpE().b(z.this.fxl, bgVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpE().b(z.this.fxl, bgVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bpE().b(z.this.fxl, bgVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bpE().b(z.this.fxl, bgVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bpE().b(z.this.fxl, bgVar, 3);
                    }
                }
            }
        };
        this.dBs = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.z.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new am("c11973").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11974").bT("obj_locate", sb.toString()).bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
        dVar.bm(176);
        dVar.setPageUniqueId(this.mPageId);
        aVar.c(dVar);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setFrom("frs");
        aVar.b(eVar);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.XI);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bEz = 2;
        dVar2.bEA = 2;
        dVar2.bEE = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bw(this.fxk);
        aaVar.bm(16);
        if (this.fxj) {
            aaVar.bn(4);
        }
        aVar.a(aaVar);
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.x qr = aVar.qr();
        com.baidu.card.a aVar2 = new com.baidu.card.a(qr);
        aVar2.setPageId(this.mPageId);
        qr.a(this.dAV);
        qr.bq(this.fxk);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.z.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bg bgVar = (bg) mVar;
                    bgVar.objType = 1;
                    if (z.this.dAV != null) {
                        z.this.dAV.a(zVar.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), z.this.fxk, false);
                    zVar.qs().b(new a.C0038a(1));
                }
            }
        });
        aVar2.qu();
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
        if (aVar.qs() instanceof com.baidu.tieba.a.e) {
            aVar.qs().setPage(this.Ws);
        }
        super.onFillViewHolder(i, view, viewGroup, bgVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.qs().qm(), this.fot);
        aVar.setVideoStatsData(af(bgVar));
        if (this.fot != null && this.fot.getForum() != null && !StringUtils.isNull(this.fot.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fot.getForum().getTopic_special_icon_right())) {
            bgVar.bC(this.fot.getForum().getTopic_special_icon(), this.fot.getForum().getTopic_special_icon_right());
        }
        boolean z = (bgVar.adv() == null || bgVar.adv().getUserId() == null || !bgVar.adv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.aeE() && bgVar.ace() != null && !z) {
            aVar.qt().a(this.dBs);
        }
        aVar.qv();
        aVar.a(bgVar);
        aVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.qs().a(this.dAV);
        if (this.fxl != null) {
            bgVar.bLn = (i + 1) - (this.fot != null ? this.fot.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bpE().a(this.fxl, bgVar);
        com.baidu.tieba.frs.d.c.bpE().ak(bgVar);
        com.baidu.tieba.frs.d.c.bpE().a(bgVar, bjE());
        com.baidu.tieba.frs.d.a.a(bgVar, this.mPageId, this.fxl);
        bgVar.aez();
        return aVar.getView();
    }

    private com.baidu.tieba.play.z af(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bgVar.aew() ? "3" : "2";
        if (this.fxl.fJI == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.eAC = this.fxl.fJH;
        zVar.bVM = bgVar.getTid();
        zVar.mSource = bgVar.mRecomSource;
        zVar.iri = bgVar.bKu;
        zVar.irj = bgVar.mRecomWeight;
        zVar.irl = bgVar.mRecomAbTag;
        if (bgVar.adM() != null) {
            zVar.irm = bgVar.adM().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nt(int i) {
        this.fxk = i;
    }

    @Override // com.baidu.tieba.a.f
    public void rU(String str) {
        this.Ws = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bg bgVar) {
        TiebaStatic.log(new am("c12126").bT("tid", bgVar.getId()).P("obj_locate", bjE() ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bgVar.adO() == null ? -1L : bgVar.adO().live_id).P("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void ix(boolean z) {
        this.fxi = z;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.XI = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmT() {
        return this.fxl;
    }

    public void kn(boolean z) {
        this.fxj = z;
    }
}
