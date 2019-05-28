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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class q extends com.baidu.tieba.frs.h<bf, com.baidu.card.z<bg>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String Wt;
    private boolean XJ;
    private boolean caI;
    private ab<bg> dAQ;
    private NEGFeedBackView.a dBs;
    private HashSet<String> fxh;
    private int fxk;
    private com.baidu.tieba.frs.d.b fxl;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.caI = false;
        this.XJ = true;
        this.fxk = 3;
        this.fxl = new com.baidu.tieba.frs.d.b();
        this.dAQ = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if ("c13010".equals(q.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").P("obj_type", 3).l("fid", bgVar.getFid()).bT("tid", bgVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpC().a(q.this.fxl, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, q.this.mPageId, q.this.fxl);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, q.this.mPageId, q.this.fxl);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.bpC().a(q.this.fxl, bgVar, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, q.this.mPageId, q.this.fxl);
                    } else {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        am amVar = new am("c12940");
                        amVar.bT("obj_type", "1");
                        amVar.bT("tid", bgVar.getTid());
                        TiebaStatic.log(amVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        am amVar2 = new am("c12940");
                        amVar2.bT("obj_type", "3");
                        amVar2.bT("tid", bgVar.getTid());
                        TiebaStatic.log(amVar2);
                    }
                }
            }
        };
        this.dBs = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.q.2
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
        hVar.setFromCDN(this.XJ);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bEy = 2;
        dVar2.bED = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bw(2);
        aaVar.bm(16);
        aVar.a(aaVar);
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.x qr = aVar.qr();
        qr.bq(2);
        com.baidu.card.z<bg> zVar = new com.baidu.card.z<>(qr);
        zVar.setPageId(this.mPageId);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.q.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (q.this.dAQ != null) {
                        q.this.dAQ.a(zVar2.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), 2, false);
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
        if (bfVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        if (zVar.qs() instanceof com.baidu.tieba.a.e) {
            zVar.qs().setPage(this.Wt);
        }
        super.onFillViewHolder(i, view, viewGroup, bfVar, zVar);
        com.baidu.tieba.frs.g.a(zVar.qs().qm(), this.fot);
        if (this.fot != null && this.fot.getForum() != null && !StringUtils.isNull(this.fot.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fot.getForum().getTopic_special_icon_right())) {
            bfVar.threadData.bC(this.fot.getForum().getTopic_special_icon(), this.fot.getForum().getTopic_special_icon_right());
        }
        boolean z = (bfVar.threadData.adv() == null || bfVar.threadData.adv().getUserId() == null || !bfVar.threadData.adv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bfVar.threadData.aeE() && bfVar.threadData.ace() != null && !z) {
            zVar.qt().a(this.dBs);
        }
        zVar.qv();
        zVar.a(bfVar.threadData);
        zVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qs().a(this.dAQ);
        if (this.fxl != null) {
            bfVar.threadData.bLm = (bfVar.position + 1) - (this.fot != null ? this.fot.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bpC().a(this.fxl, bfVar.threadData);
        ad(bfVar.threadData);
        bfVar.threadData.aez();
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, this.fxl);
        if (bfVar.threadData != null) {
            bfVar.threadData.aez();
        }
        return zVar.getView();
    }

    private void ad(bg bgVar) {
        if (this.fxh == null) {
            this.fxh = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bpC().a(bgVar, this.fxh);
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
    public void rV(String str) {
        this.Wt = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.caI = z;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.XJ = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmT() {
        return this.fxl;
    }
}
