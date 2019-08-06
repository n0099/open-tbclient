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
import com.baidu.tbadk.core.data.bh;
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
public class z extends com.baidu.tieba.frs.h<bh, com.baidu.card.a<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WN;
    private boolean Yd;
    private boolean cbS;
    private NEGFeedBackView.a dEV;
    private ab<bh> dEy;
    public boolean fBW;
    private boolean fCS;
    private boolean fCT;
    private int fCU;
    private com.baidu.tieba.frs.d.b fCV;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cbS = false;
        this.fCS = false;
        this.Yd = false;
        this.fCT = false;
        this.fCU = 3;
        this.fCV = new com.baidu.tieba.frs.d.b();
        this.dEy = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (z.this.ftX != null) {
                        z.this.ftX.a(view, (View) bhVar, (Object) bh.bJC);
                    }
                    if ("c13010".equals(z.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 2).l("fid", bhVar.getFid()).bT("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.brS().a(z.this.fCV, bhVar, 1);
                        z.this.af(bhVar);
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 4, z.this.mPageId, z.this.fCV);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brS().a(z.this.fCV, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, z.this.mPageId, z.this.fCV);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(z.this.fCV, bhVar.acz());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.brS().a(z.this.fCV, bhVar, 4);
                        z.this.af(bhVar);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, z.this.mPageId, z.this.fCV);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        z.this.af(bhVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.brS().b(z.this.fCV, bhVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brS().b(z.this.fCV, bhVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.brS().b(z.this.fCV, bhVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.brS().b(z.this.fCV, bhVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.brS().b(z.this.fCV, bhVar, 3);
                    }
                }
            }
        };
        this.dEV = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.z.2
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
        dVar2.bFA = 2;
        dVar2.bFB = 2;
        dVar2.bFF = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bw(this.fCU);
        aaVar.bm(16);
        if (this.fCT) {
            aaVar.bn(4);
        }
        aVar.a(aaVar);
        aVar.qN().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.x qO = aVar.qO();
        com.baidu.card.a aVar2 = new com.baidu.card.a(qO);
        aVar2.setPageId(this.mPageId);
        qO.a(this.dEy);
        qO.bq(this.fCU);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.z.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bh) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bh bhVar = (bh) mVar;
                    bhVar.objType = 1;
                    if (z.this.dEy != null) {
                        z.this.dEy.a(zVar.getView(), bhVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), z.this.fCU, false);
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
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.card.a<bh> aVar) {
        if (aVar == null) {
            return null;
        }
        if (bhVar == null) {
            return aVar.getView();
        }
        if (aVar.qP() instanceof com.baidu.tieba.a.e) {
            aVar.qP().setPage(this.WN);
        }
        super.onFillViewHolder(i, view, viewGroup, bhVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.qP().qJ(), this.ftR);
        aVar.setVideoStatsData(ag(bhVar));
        if (this.ftR != null && this.ftR.getForum() != null && !StringUtils.isNull(this.ftR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.ftR.getForum().getTopic_special_icon_right())) {
            bhVar.bC(this.ftR.getForum().getTopic_special_icon(), this.ftR.getForum().getTopic_special_icon_right());
        }
        boolean z = (bhVar.aey() == null || bhVar.aey().getUserId() == null || !bhVar.aey().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bhVar.afH() && bhVar.adh() != null && !z) {
            aVar.qQ().a(this.dEV);
        }
        aVar.qS();
        aVar.a(bhVar);
        aVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.qP().a(this.dEy);
        if (this.fCV != null) {
            bhVar.bMs = (i + 1) - (this.ftR != null ? this.ftR.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.brS().a(this.fCV, bhVar);
        com.baidu.tieba.frs.d.c.brS().al(bhVar);
        com.baidu.tieba.frs.d.c.brS().a(bhVar, blN());
        com.baidu.tieba.frs.d.a.a(bhVar, this.mPageId, this.fCV);
        bhVar.afC();
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

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(bh bhVar) {
        TiebaStatic.log(new an("c12126").bT("tid", bhVar.getId()).P("obj_locate", blN() ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bhVar.aeR() == null ? -1L : bhVar.aeR().live_id).P("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void iG(boolean z) {
        this.fCS = z;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bph() {
        return this.fCV;
    }

    public void kx(boolean z) {
        this.fCT = z;
    }
}
