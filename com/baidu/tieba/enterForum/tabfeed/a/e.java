package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
/* loaded from: classes21.dex */
public class e extends com.baidu.adp.widget.ListView.a<bv, am<bw>> {
    private aa<bw> afn;
    private boolean ajR;
    private v alj;
    public BdUniqueId eSq;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajR = true;
        this.afn = new aa<bw>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                s.cfn().kO(true);
                com.baidu.tieba.enterForum.a.a(view, bwVar, e.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.eSq = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.alj = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        z zVar = new z(this.mPageContext.getPageActivity());
        zVar.setFrom("index");
        zVar.setFromCDN(this.ajR);
        aVar.c(zVar);
        ak a = aVar.a(false, viewGroup, this.alj);
        a.setSourceForPb(2);
        am amVar = new am(a);
        amVar.setPageId(this.eSq);
        a(new ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.e.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = ((bv) qVar).dXg;
                    bwVar.objType = 1;
                    if (e.this.afn != null) {
                        e.this.afn.a(amVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 2, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, am<bw> amVar) {
        if (bvVar == null || amVar == null || amVar.getView() == null || bvVar.dXg == null) {
            return null;
        }
        bvVar.dXg.ebp = getPositionByType(i) + 1;
        amVar.tW().setPosition(i);
        amVar.b((am<bw>) bvVar.dXg);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afn);
        com.baidu.tieba.enterForum.a.a(bvVar, this.mTabName);
        return amVar.getView();
    }
}
