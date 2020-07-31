package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes16.dex */
public class k extends com.baidu.adp.widget.ListView.a<bu, ak<bv>> {
    private v ajt;
    public BdUniqueId eEU;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.eEU = bdUniqueId2;
        this.mTabName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak<bv> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.q qVar = new com.baidu.card.q(this.mPageContext.getPageActivity());
        qVar.rV();
        aVar.a((com.baidu.card.h) qVar);
        ai a = aVar.a(false, viewGroup, this.ajt);
        a.setSourceForPb(2);
        ak<bv> akVar = new ak<>(a);
        akVar.setPageId(this.eEU);
        a(new z() { // from class: com.baidu.tieba.homepage.tabfeed.a.k.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar2 instanceof bu) && (view.getTag() instanceof ak)) {
                    bv bvVar = ((bu) qVar2).dLK;
                    bvVar.objType = 1;
                    ax.a((AbsThreadDataSupport) bvVar, view.getContext(), 2, false);
                    ((ak) view.getTag()).sg().b(new a.C0096a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, ak<bv> akVar) {
        if (buVar == null || akVar == null || akVar.getView() == null || buVar.dLK == null) {
            return null;
        }
        buVar.dLK.dPI = getPositionByType(i) + 1;
        akVar.sg().setPosition(i);
        akVar.b((ak<bv>) buVar.dLK);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    public void a(v vVar) {
        this.ajt = vVar;
    }
}
