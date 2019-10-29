package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class q extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String GC;
    private boolean HY;
    private boolean cqZ;
    private NEGFeedBackView.a dTF;
    private ab<bh> dTc;
    private HashSet<String> fDV;
    private int fDY;
    private com.baidu.tieba.frs.d.b fDZ;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.cqZ = false;
        this.HY = true;
        this.fDY = 3;
        this.fDZ = new com.baidu.tieba.frs.d.b();
        this.dTc = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if ("c13010".equals(q.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").O("obj_type", 3).p("fid", bhVar.getFid()).bS("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpJ().a(q.this.fDZ, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, q.this.mPageId, q.this.fDZ);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, q.this.mPageId, q.this.fDZ);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.bpJ().a(q.this.fDZ, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, q.this.mPageId, q.this.fDZ);
                    } else {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar.bS("obj_type", "1");
                        anVar.bS("tid", bhVar.getTid());
                        TiebaStatic.log(anVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        an anVar2 = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar2.bS("obj_type", "3");
                        anVar2.bS("tid", bhVar.getTid());
                        TiebaStatic.log(anVar2);
                    }
                }
            }
        };
        this.dTF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.q.2
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
        dVar.aB(4280);
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
        abVar.aM(2);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.HY);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bXQ = 2;
        dVar2.bXV = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.aL(2);
        aaVar.aB(16);
        aVar.a(aaVar);
        com.baidu.card.x lU = aVar.lU();
        lU.aF(2);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(lU);
        zVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.q.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).cbq;
                    bhVar.objType = 1;
                    if (q.this.dTc != null) {
                        q.this.dTc.a(zVar2.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), q.this.fDY, false);
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
        if (bgVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        if (zVar.lV() instanceof com.baidu.tieba.a.e) {
            zVar.lV().setPage(this.GC);
        }
        super.a(i, view, viewGroup, (ViewGroup) bgVar, (bg) zVar);
        com.baidu.tieba.frs.g.a(zVar.lV().lP(), this.fuR);
        if (this.fuR != null && this.fuR.getForum() != null && !StringUtils.isNull(this.fuR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fuR.getForum().getTopic_special_icon_right())) {
            bgVar.cbq.bI(this.fuR.getForum().getTopic_special_icon(), this.fuR.getForum().getTopic_special_icon_right());
        }
        boolean z = (bgVar.cbq.aiG() == null || bgVar.cbq.aiG().getUserId() == null || !bgVar.cbq.aiG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.cbq.ajO() && bgVar.cbq.getFeedBackReasonMap() != null && !z) {
            zVar.lW().a(this.dTF);
        }
        zVar.lY();
        zVar.a(bgVar.cbq);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.dTc);
        if (this.fDZ != null) {
            bgVar.cbq.cez = (bgVar.position + 1) - (this.fuR != null ? this.fuR.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bpJ().a(this.fDZ, bgVar.cbq);
        ad(bgVar.cbq);
        bgVar.cbq.ajK();
        com.baidu.tieba.frs.d.a.a(bgVar.cbq, this.mPageId, this.fDZ);
        if (bgVar.cbq != null) {
            bgVar.cbq.ajK();
        }
        return zVar.getView();
    }

    private void ad(bh bhVar) {
        if (this.fDV == null) {
            this.fDV = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bpJ().a(bhVar, this.fDV);
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

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.HY = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmX() {
        return this.fDZ;
    }
}
