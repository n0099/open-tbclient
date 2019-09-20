package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class v extends com.baidu.tieba.frs.h<bh, com.baidu.card.z<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WM;
    private boolean Yd;
    private boolean ccM;
    private NEGFeedBackView.a dGG;
    private ab<bh> dGe;
    private HashSet<String> fEE;
    private int fEH;
    private com.baidu.tieba.frs.d.b fEI;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ccM = false;
        this.Yd = true;
        this.fEH = 3;
        this.fEI = new com.baidu.tieba.frs.d.b();
        this.dGe = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if ("c13010".equals(v.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 3).n("fid", bhVar.getFid()).bT("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bsF().a(v.this.fEI, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, v.this.mPageId, v.this.fEI);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, v.this.mPageId, v.this.fEI);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.bsF().a(v.this.fEI, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, v.this.mPageId, v.this.fEI);
                    } else {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        an anVar = new an("c12940");
                        anVar.bT("obj_type", "1");
                        anVar.bT("tid", bhVar.getTid());
                        TiebaStatic.log(anVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        an anVar2 = new an("c12940");
                        anVar2.bT("obj_type", "3");
                        anVar2.bT("tid", bhVar.getTid());
                        TiebaStatic.log(anVar2);
                    }
                }
            }
        };
        this.dGG = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.v.2
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
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.card.z<bh> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bm(4280);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.a.v.3
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.c(dVar);
        com.baidu.card.ab abVar = new com.baidu.card.ab(this.mPageContext.getPageActivity());
        aVar.b(abVar);
        abVar.bx(3);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Yd);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bFY = 2;
        dVar2.bGd = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(2);
        aaVar.bw(3);
        aaVar.bm(16);
        aVar.a(aaVar);
        com.baidu.card.x qP = aVar.qP();
        qP.bq(3);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(qP);
        zVar.setPageId(this.mPageId);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.v.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bh) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bh bhVar = (bh) mVar;
                    bhVar.objType = 1;
                    if (v.this.dGe != null) {
                        v.this.dGe.a(zVar2.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), 3, false);
                    zVar2.qQ().b(new a.C0038a(1));
                }
            }
        });
        zVar.qS();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.card.z<bh> zVar) {
        if (bhVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        if (zVar.qQ() instanceof com.baidu.tieba.a.e) {
            zVar.qQ().setPage(this.WM);
        }
        super.onFillViewHolder(i, view, viewGroup, bhVar, zVar);
        com.baidu.tieba.frs.g.a(zVar.qQ().qK(), this.fvE);
        if (this.fvE != null && this.fvE.getForum() != null && !StringUtils.isNull(this.fvE.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fvE.getForum().getTopic_special_icon_right())) {
            bhVar.bC(this.fvE.getForum().getTopic_special_icon(), this.fvE.getForum().getTopic_special_icon_right());
        }
        boolean z = (bhVar.aeC() == null || bhVar.aeC().getUserId() == null || !bhVar.aeC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bhVar.afL() && bhVar.adl() != null && !z) {
            zVar.qR().a(this.dGG);
        }
        zVar.qT();
        zVar.a(bhVar);
        zVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qQ().a(this.dGe);
        if (this.fEI != null) {
            bhVar.bMQ = (i + 1) - (this.fvE != null ? this.fvE.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bsF().a(this.fEI, bhVar);
        af(bhVar);
        bhVar.afG();
        com.baidu.tieba.frs.d.a.a(bhVar, this.mPageId, this.fEI);
        if (bhVar != null) {
            bhVar.afG();
        }
        return zVar.getView();
    }

    private void af(bh bhVar) {
        if (this.fEE == null) {
            this.fEE = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bsF().a(bhVar, this.fEE);
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

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bpS() {
        return this.fEI;
    }
}
