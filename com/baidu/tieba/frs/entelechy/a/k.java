package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class k extends com.baidu.tieba.frs.h<bf, com.baidu.card.z<bg>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String Ws;
    private boolean XI;
    private boolean caJ;
    private ab<bg> dAQ;
    private NEGFeedBackView.a dBs;
    private int fxk;
    private com.baidu.tieba.frs.d.b fxl;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.caJ = false;
        this.XI = true;
        this.fxk = 3;
        this.fxl = new com.baidu.tieba.frs.d.b();
        this.dAQ = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpE().a(k.this.fxl, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, k.this.mPageId, k.this.fxl);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, k.this.mPageId, k.this.fxl);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.bpE().a(k.this.fxl, bgVar, 7);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, k.this.mPageId, k.this.fxl);
                    } else {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        this.dBs = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.k.2
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
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public com.baidu.card.z<bg> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.mPageId);
        dVar.bm(176);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.a.k.3
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
        aVar.b(new com.baidu.card.l(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.XI);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bEz = 2;
        dVar2.bEE = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(this.fxk);
        aaVar.bw(this.fxk);
        aaVar.bm(16);
        aVar.a(aaVar);
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.x qr = aVar.qr();
        qr.bq(this.fxk);
        com.baidu.card.z<bg> zVar = new com.baidu.card.z<>(qr);
        zVar.setPageId(this.mPageId);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.k.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (k.this.dAQ != null) {
                        k.this.dAQ.a(zVar2.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), k.this.fxk, false);
                    zVar2.qs().b(new a.C0038a(1));
                }
            }
        });
        zVar.qu();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bf bfVar, com.baidu.card.z<bg> zVar) {
        if (bfVar == null || zVar == null || zVar.qs() == null) {
            return null;
        }
        super.onFillViewHolder(i, view, viewGroup, bfVar, zVar);
        if (zVar.qs() instanceof com.baidu.tieba.a.e) {
            zVar.qs().setPage(this.Ws);
        }
        com.baidu.tieba.frs.g.a(zVar.qs().qm(), this.fot);
        boolean z = (bfVar.threadData.adv() == null || bfVar.threadData.adv().getUserId() == null || !bfVar.threadData.adv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bfVar.threadData.aeE() && bfVar.threadData.ace() != null && !z) {
            com.baidu.card.s qt = zVar.qt();
            qt.a(this.dBs);
            qt.C(bfVar.threadData.abx());
        }
        zVar.qv();
        zVar.a(bfVar.threadData);
        zVar.c(this.dAQ);
        zVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.fxl != null) {
            bfVar.threadData.bLn = (bfVar.position + 1) - (this.fot != null ? this.fot.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bpE().a(this.fxl, bfVar.threadData);
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, this.fxl);
        if (bfVar != null) {
            bfVar.threadData.aez();
        }
        return zVar.getView();
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

    public void setInFrsAllThread(boolean z) {
        this.caJ = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmT() {
        return this.fxl;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.XI = z;
    }
}
