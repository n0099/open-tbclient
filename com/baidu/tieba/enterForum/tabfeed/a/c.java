package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<bv, am<bw>> {
    private ab<bw> afF;
    private boolean akk;
    private v alD;
    public BdUniqueId fsQ;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akk = true;
        this.afF = new ab<bw>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                t.cor().lN(true);
                com.baidu.tieba.enterForum.a.a(view, bwVar, c.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.fsQ = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.alD = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.v vVar = new com.baidu.card.v(this.mPageContext.getPageActivity());
        vVar.setFrom("index");
        vVar.setFromCDN(this.akk);
        aVar.c(vVar);
        ak a2 = aVar.a(false, viewGroup, this.alD);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fsQ);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.c.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = ((bv) qVar).exA;
                    bwVar.objType = 1;
                    if (c.this.afF != null) {
                        c.this.afF.a(amVar2.getView(), bwVar);
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
        if (bvVar == null || amVar == null || amVar.getView() == null || bvVar.exA == null) {
            return null;
        }
        bvVar.exA.eBK = getPositionByType(i) + 1;
        amVar.tW().setPosition(i);
        amVar.b((am<bw>) bvVar.exA);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afF);
        com.baidu.tieba.enterForum.a.a(bvVar, this.mTabName);
        return amVar.getView();
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }
}
