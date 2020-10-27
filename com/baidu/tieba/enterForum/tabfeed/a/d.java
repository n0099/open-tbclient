package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.widget.ListView.a<bv, am<bw>> {
    private ab<bw> afF;
    private boolean akk;
    private v alD;
    public BdUniqueId fmX;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akk = true;
        this.afF = new ab<bw>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                t.clQ().lE(true);
                com.baidu.tieba.enterForum.a.a(view, bwVar, d.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.fmX = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.alD = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        y yVar = new y(this.mPageContext.getPageActivity());
        yVar.setFrom("index");
        yVar.setFromCDN(this.akk);
        aVar.c(yVar);
        ak a2 = aVar.a(false, viewGroup, this.alD);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fmX);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.d.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = ((bv) qVar).erH;
                    bwVar.objType = 1;
                    if (d.this.afF != null) {
                        d.this.afF.a(amVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 2, false);
                    amVar2.tW().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, am<bw> amVar) {
        if (bvVar == null || amVar == null || amVar.getView() == null || bvVar.erH == null) {
            return null;
        }
        bvVar.erH.evR = getPositionByType(i) + 1;
        amVar.tW().setPosition(i);
        amVar.b((am<bw>) bvVar.erH);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afF);
        com.baidu.tieba.enterForum.a.a(bvVar, this.mTabName);
        y yVar = (y) amVar.tW().tP();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.agI.akI.getLayoutParams();
        layoutParams.width = bvVar.exG;
        layoutParams.height = bvVar.exH;
        if (yVar.agI.akI.getVisibility() != 8) {
            yVar.agI.akI.setLayoutParams(layoutParams);
        }
        return amVar.getView();
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }
}
