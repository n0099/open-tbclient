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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes9.dex */
public class k extends com.baidu.adp.widget.ListView.a<bt, ak<bu>> {
    private v ajy;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.eyE = bdUniqueId2;
        this.mTabName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak<bu> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.q qVar = new com.baidu.card.q(this.mPageContext.getPageActivity());
        qVar.rU();
        aVar.a((com.baidu.card.h) qVar);
        ai a = aVar.a(false, viewGroup, this.ajy);
        a.setSourceForPb(2);
        ak<bu> akVar = new ak<>(a);
        akVar.setPageId(this.eyE);
        a(new z() { // from class: com.baidu.tieba.homepage.tabfeed.a.k.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar2 instanceof bt) && (view.getTag() instanceof ak)) {
                    bu buVar = ((bt) qVar2).dLi;
                    buVar.objType = 1;
                    aw.a((AbsThreadDataSupport) buVar, view.getContext(), 2, false);
                    ((ak) view.getTag()).se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, ak<bu> akVar) {
        if (btVar == null || akVar == null || akVar.getView() == null || btVar.dLi == null) {
            return null;
        }
        btVar.dLi.dJw = getPositionByType(i) + 1;
        akVar.se().setPosition(i);
        akVar.b((ak<bu>) btVar.dLi);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    public void a(v vVar) {
        this.ajy = vVar;
    }
}
