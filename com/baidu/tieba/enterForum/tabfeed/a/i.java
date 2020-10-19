package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ag;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.aa;
/* loaded from: classes22.dex */
public class i extends com.baidu.adp.widget.ListView.a<bv, am<bw>> {
    private v alC;
    public BdUniqueId fey;
    private aa<com.baidu.tieba.card.data.l> hXa;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hXa = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                super.a(view, (View) lVar);
                if (lVar != null && lVar.bfG() != null) {
                    am amVar = (am) view.getTag();
                    if (i.this.Vx != null) {
                        ay.a((AbsThreadDataSupport) lVar.bfG(), view.getContext(), 0, false);
                        amVar.tW().b(new a.C0097a(1));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fey = bdUniqueId2;
        this.mTabName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public am<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.i) new ag(this.mPageContext.getPageActivity()));
        ak a2 = aVar.a(false, viewGroup, this.alC);
        a2.setSourceForPb(2);
        am<bw> amVar = new am<>(a2);
        amVar.setPageId(this.fey);
        a(new ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.i.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    if (i.this.hXa != null) {
                        i.this.hXa.a(amVar2.getView(), lVar);
                    }
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, am<bw> amVar) {
        if (bvVar == null || amVar == null || amVar.getView() == null || bvVar.eji == null) {
            return null;
        }
        bvVar.eji.ens = getPositionByType(i) + 1;
        amVar.tW().setPosition(i);
        amVar.b((am<bw>) bvVar.eji);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    public void a(v vVar) {
        this.alC = vVar;
    }
}
