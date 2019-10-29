package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class k extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String GC;
    private boolean HY;
    private boolean cqZ;
    private NEGFeedBackView.a dTF;
    private ab<bh> dTc;
    private int fDY;
    private com.baidu.tieba.frs.d.b fDZ;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.cqZ = false;
        this.HY = true;
        this.fDY = 3;
        this.fDZ = new com.baidu.tieba.frs.d.b();
        this.dTc = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpJ().a(k.this.fDZ, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, k.this.mPageId, k.this.fDZ);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, k.this.mPageId, k.this.fDZ);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.bpJ().a(k.this.fDZ, bhVar, 7);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, k.this.mPageId, k.this.fDZ);
                    } else {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    }
                }
            }
        };
        this.dTF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.k.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new an("c11973").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11974").bS("obj_locate", sb.toString()).bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.z<bh> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.mPageId);
        dVar.aB(4272);
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
        hVar.setFromCDN(this.HY);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bXQ = 2;
        dVar2.bXV = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(this.fDY);
        aaVar.aL(this.fDY);
        aaVar.aB(16);
        aVar.a(aaVar);
        com.baidu.card.x lU = aVar.lU();
        lU.aF(this.fDY);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(lU);
        zVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.k.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).cbq;
                    bhVar.objType = 1;
                    if (k.this.dTc != null) {
                        k.this.dTc.a(zVar2.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), k.this.fDY, false);
                    zVar2.lV().b(new a.C0044a(1));
                }
            }
        });
        zVar.lX();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.z<bh> zVar) {
        if (bgVar == null || zVar == null || zVar.lV() == null) {
            return null;
        }
        super.a(i, view, viewGroup, (ViewGroup) bgVar, (bg) zVar);
        if (zVar.lV() instanceof com.baidu.tieba.a.e) {
            zVar.lV().setPage(this.GC);
        }
        com.baidu.tieba.frs.g.a(zVar.lV().lP(), this.fuR);
        boolean z = (bgVar.cbq.aiG() == null || bgVar.cbq.aiG().getUserId() == null || !bgVar.cbq.aiG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.cbq.ajO() && bgVar.cbq.getFeedBackReasonMap() != null && !z) {
            com.baidu.card.s lW = zVar.lW();
            lW.a(this.dTF);
            lW.z(bgVar.cbq.agK());
        }
        zVar.lY();
        zVar.a(bgVar.cbq);
        zVar.c(this.dTc);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.fDZ != null) {
            bgVar.cbq.cez = (bgVar.position + 1) - (this.fuR != null ? this.fuR.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bpJ().a(this.fDZ, bgVar.cbq);
        com.baidu.tieba.frs.d.a.a(bgVar.cbq, this.mPageId, this.fDZ);
        if (bgVar != null) {
            bgVar.cbq.ajK();
        }
        return zVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mX(int i) {
        this.fDY = i;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.cqZ = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmX() {
        return this.fDZ;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.HY = z;
    }
}
