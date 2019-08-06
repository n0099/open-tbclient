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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class q extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WN;
    private boolean Yd;
    private boolean cbS;
    private NEGFeedBackView.a dEV;
    private ab<bh> dEt;
    private HashSet<String> fCR;
    private int fCU;
    private com.baidu.tieba.frs.d.b fCV;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.cbS = false;
        this.Yd = true;
        this.fCU = 3;
        this.fCV = new com.baidu.tieba.frs.d.b();
        this.dEt = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if ("c13010".equals(q.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 3).l("fid", bhVar.getFid()).bT("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brS().a(q.this.fCV, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, q.this.mPageId, q.this.fCV);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, q.this.mPageId, q.this.fCV);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.brS().a(q.this.fCV, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, q.this.mPageId, q.this.fCV);
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
        this.dEV = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.q.2
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
        dVar.bm(184);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.a.q.3
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
        abVar.bx(2);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Yd);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bFA = 2;
        dVar2.bFF = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bw(2);
        aaVar.bm(16);
        aVar.a(aaVar);
        aVar.qN().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.x qO = aVar.qO();
        qO.bq(2);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(qO);
        zVar.setPageId(this.mPageId);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.q.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).threadData;
                    bhVar.objType = 1;
                    if (q.this.dEt != null) {
                        q.this.dEt.a(zVar2.getView(), bhVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), q.this.fCU, false);
                    zVar2.qP().b(new a.C0038a(1));
                }
            }
        });
        zVar.qR();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.z<bh> zVar) {
        if (bgVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        if (zVar.qP() instanceof com.baidu.tieba.a.e) {
            zVar.qP().setPage(this.WN);
        }
        super.onFillViewHolder(i, view, viewGroup, bgVar, zVar);
        com.baidu.tieba.frs.g.a(zVar.qP().qJ(), this.ftR);
        if (this.ftR != null && this.ftR.getForum() != null && !StringUtils.isNull(this.ftR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.ftR.getForum().getTopic_special_icon_right())) {
            bgVar.threadData.bC(this.ftR.getForum().getTopic_special_icon(), this.ftR.getForum().getTopic_special_icon_right());
        }
        boolean z = (bgVar.threadData.aey() == null || bgVar.threadData.aey().getUserId() == null || !bgVar.threadData.aey().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.threadData.afH() && bgVar.threadData.adh() != null && !z) {
            zVar.qQ().a(this.dEV);
        }
        zVar.qS();
        zVar.a(bgVar.threadData);
        zVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qP().a(this.dEt);
        if (this.fCV != null) {
            bgVar.threadData.bMs = (bgVar.position + 1) - (this.ftR != null ? this.ftR.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.brS().a(this.fCV, bgVar.threadData);
        ae(bgVar.threadData);
        bgVar.threadData.afC();
        com.baidu.tieba.frs.d.a.a(bgVar.threadData, this.mPageId, this.fCV);
        if (bgVar.threadData != null) {
            bgVar.threadData.afC();
        }
        return zVar.getView();
    }

    private void ae(bh bhVar) {
        if (this.fCR == null) {
            this.fCR = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.brS().a(bhVar, this.fCR);
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

    public void setInFrsAllThread(boolean z) {
        this.cbS = z;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bph() {
        return this.fCV;
    }
}
