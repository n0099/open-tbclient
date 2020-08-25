package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes16.dex */
public class k extends com.baidu.adp.widget.ListView.a<bv, al<bw>> {
    private v akI;
    public BdUniqueId ePv;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.ePv = bdUniqueId2;
        this.mTabName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<bw> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        r rVar = new r(this.mPageContext.getPageActivity());
        rVar.tG();
        aVar.a((com.baidu.card.h) rVar);
        aj a = aVar.a(false, viewGroup, this.akI);
        a.setSourceForPb(2);
        al<bw> alVar = new al<>(a);
        alVar.setPageId(this.ePv);
        a(new ab() { // from class: com.baidu.tieba.homepage.tabfeed.a.k.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof al)) {
                    bw bwVar = ((bv) qVar).dUS;
                    bwVar.objType = 1;
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 2, false);
                    ((al) view.getTag()).tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, al<bw> alVar) {
        if (bvVar == null || alVar == null || alVar.getView() == null || bvVar.dUS == null) {
            return null;
        }
        bvVar.dUS.dZb = getPositionByType(i) + 1;
        alVar.tR().setPosition(i);
        alVar.b((al<bw>) bvVar.dUS);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return alVar.getView();
    }

    public void a(v vVar) {
        this.akI = vVar;
    }
}
