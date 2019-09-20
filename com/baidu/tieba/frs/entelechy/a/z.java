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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class z extends com.baidu.tieba.frs.h<bh, com.baidu.card.a<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WM;
    private boolean Yd;
    private boolean ccM;
    private NEGFeedBackView.a dGG;
    private ab<bh> dGj;
    public boolean fDJ;
    private boolean fEF;
    private boolean fEG;
    private int fEH;
    private com.baidu.tieba.frs.d.b fEI;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ccM = false;
        this.fEF = false;
        this.Yd = false;
        this.fEG = false;
        this.fEH = 3;
        this.fEI = new com.baidu.tieba.frs.d.b();
        this.dGj = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (z.this.fvK != null) {
                        z.this.fvK.a(view, (View) bhVar, (Object) bh.bKa);
                    }
                    if ("c13010".equals(z.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 2).n("fid", bhVar.getFid()).bT("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.bsF().a(z.this.fEI, bhVar, 1);
                        z.this.ag(bhVar);
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 4, z.this.mPageId, z.this.fEI);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bsF().a(z.this.fEI, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, z.this.mPageId, z.this.fEI);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(z.this.fEI, bhVar.acD());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bsF().a(z.this.fEI, bhVar, 4);
                        z.this.ag(bhVar);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, z.this.mPageId, z.this.fEI);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        z.this.ag(bhVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bsF().b(z.this.fEI, bhVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bsF().b(z.this.fEI, bhVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bsF().b(z.this.fEI, bhVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bsF().b(z.this.fEI, bhVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bsF().b(z.this.fEI, bhVar, 3);
                    }
                }
            }
        };
        this.dGG = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.z.2
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
        dVar.bm(4272);
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
        dVar2.bFY = 2;
        dVar2.bFZ = 2;
        dVar2.bGd = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bw(this.fEH);
        aaVar.bm(16);
        if (this.fEG) {
            aaVar.bn(4);
        }
        aVar.a(aaVar);
        com.baidu.card.x qP = aVar.qP();
        com.baidu.card.a aVar2 = new com.baidu.card.a(qP);
        aVar2.setPageId(this.mPageId);
        qP.a(this.dGj);
        qP.bq(this.fEH);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.z.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bh) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bh bhVar = (bh) mVar;
                    bhVar.objType = 1;
                    if (z.this.dGj != null) {
                        z.this.dGj.a(zVar.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), z.this.fEH, false);
                    zVar.qQ().b(new a.C0038a(1));
                }
            }
        });
        aVar2.qS();
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
        if (aVar.qQ() instanceof com.baidu.tieba.a.e) {
            aVar.qQ().setPage(this.WM);
        }
        super.onFillViewHolder(i, view, viewGroup, bhVar, aVar);
        com.baidu.tieba.frs.g.a(aVar.qQ().qK(), this.fvE);
        aVar.setVideoStatsData(ah(bhVar));
        if (this.fvE != null && this.fvE.getForum() != null && !StringUtils.isNull(this.fvE.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fvE.getForum().getTopic_special_icon_right())) {
            bhVar.bC(this.fvE.getForum().getTopic_special_icon(), this.fvE.getForum().getTopic_special_icon_right());
        }
        boolean z = (bhVar.aeC() == null || bhVar.aeC().getUserId() == null || !bhVar.aeC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bhVar.afL() && bhVar.adl() != null && !z) {
            aVar.qR().a(this.dGG);
        }
        aVar.qT();
        aVar.a(bhVar);
        aVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.qQ().a(this.dGj);
        if (this.fEI != null) {
            bhVar.bMQ = (i + 1) - (this.fvE != null ? this.fvE.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bsF().a(this.fEI, bhVar);
        com.baidu.tieba.frs.d.c.bsF().am(bhVar);
        com.baidu.tieba.frs.d.c.bsF().a(bhVar, bmy());
        com.baidu.tieba.frs.d.a.a(bhVar, this.mPageId, this.fEI);
        bhVar.afG();
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

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(bh bhVar) {
        TiebaStatic.log(new an("c12126").bT("tid", bhVar.getId()).P("obj_locate", bmy() ? 2 : 1).n(VideoPlayActivityConfig.OBJ_ID, bhVar.aeV() == null ? -1L : bhVar.aeV().live_id).P("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void iJ(boolean z) {
        this.fEF = z;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bpS() {
        return this.fEI;
    }

    public void kA(boolean z) {
        this.fEG = z;
    }
}
