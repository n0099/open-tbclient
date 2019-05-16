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
    private String Wt;
    private boolean XJ;
    private boolean caI;
    private ab<bg> dAU;
    private NEGFeedBackView.a dBr;
    public boolean fwl;
    private boolean fxh;
    private boolean fxi;
    private int fxj;
    private com.baidu.tieba.frs.d.b fxk;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.caI = false;
        this.fxh = false;
        this.XJ = false;
        this.fxi = false;
        this.fxj = 3;
        this.fxk = new com.baidu.tieba.frs.d.b();
        this.dAU = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (z.this.foy != null) {
                        z.this.foy.a(view, (View) bgVar, (Object) bg.bIw);
                    }
                    if ("c13010".equals(z.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").P("obj_type", 2).l("fid", bgVar.getFid()).bT("tid", bgVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.bpz().a(z.this.fxk, bgVar, 1);
                        z.this.ae(bgVar);
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, z.this.mPageId, z.this.fxk);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpz().a(z.this.fxk, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, z.this.mPageId, z.this.fxk);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(z.this.fxk, bgVar.abw());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bpz().a(z.this.fxk, bgVar, 4);
                        z.this.ae(bgVar);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, z.this.mPageId, z.this.fxk);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        z.this.ae(bgVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bpz().b(z.this.fxk, bgVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpz().b(z.this.fxk, bgVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bpz().b(z.this.fxk, bgVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bpz().b(z.this.fxk, bgVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bpz().b(z.this.fxk, bgVar, 3);
                    }
                }
            }
        };
        this.dBr = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.z.2
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
        hVar.setFromCDN(this.XJ);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bEy = 2;
        dVar2.bEz = 2;
        dVar2.bED = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bw(this.fxj);
        aaVar.bm(16);
        if (this.fxi) {
            aaVar.bn(4);
        }
        aVar.a(aaVar);
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.x qr = aVar.qr();
        com.baidu.card.a aVar2 = new com.baidu.card.a(qr);
        aVar2.setPageId(this.mPageId);
        qr.a(this.dAU);
        qr.bq(this.fxj);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.z.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bg bgVar = (bg) mVar;
                    bgVar.objType = 1;
                    if (z.this.dAU != null) {
                        z.this.dAU.a(zVar.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), z.this.fxj, false);
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
            aVar.qs().setPage(this.Wt);
        }
        super.onFillViewHolder(i, view, viewGroup, bgVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.qs().qm(), this.fos);
        aVar.setVideoStatsData(af(bgVar));
        if (this.fos != null && this.fos.getForum() != null && !StringUtils.isNull(this.fos.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fos.getForum().getTopic_special_icon_right())) {
            bgVar.bC(this.fos.getForum().getTopic_special_icon(), this.fos.getForum().getTopic_special_icon_right());
        }
        boolean z = (bgVar.adv() == null || bgVar.adv().getUserId() == null || !bgVar.adv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.aeE() && bgVar.ace() != null && !z) {
            aVar.qt().a(this.dBr);
        }
        aVar.qv();
        aVar.a(bgVar);
        aVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.qs().a(this.dAU);
        if (this.fxk != null) {
            bgVar.bLm = (i + 1) - (this.fos != null ? this.fos.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bpz().a(this.fxk, bgVar);
        com.baidu.tieba.frs.d.c.bpz().ak(bgVar);
        com.baidu.tieba.frs.d.c.bpz().a(bgVar, bjB());
        com.baidu.tieba.frs.d.a.a(bgVar, this.mPageId, this.fxk);
        bgVar.aez();
        return aVar.getView();
    }

    private com.baidu.tieba.play.z af(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bgVar.aew() ? "3" : "2";
        if (this.fxk.fJF == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.eAB = this.fxk.fJE;
        zVar.bVL = bgVar.getTid();
        zVar.mSource = bgVar.mRecomSource;
        zVar.ire = bgVar.bKt;
        zVar.irf = bgVar.mRecomWeight;
        zVar.irh = bgVar.mRecomAbTag;
        if (bgVar.adM() != null) {
            zVar.iri = bgVar.adM().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nt(int i) {
        this.fxj = i;
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bg bgVar) {
        TiebaStatic.log(new am("c12126").bT("tid", bgVar.getId()).P("obj_locate", bjB() ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bgVar.adO() == null ? -1L : bgVar.adO().live_id).P("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void ix(boolean z) {
        this.fxh = z;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.XJ = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmQ() {
        return this.fxk;
    }

    public void kn(boolean z) {
        this.fxi = z;
    }
}
