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
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
/* loaded from: classes16.dex */
public class i extends com.baidu.adp.widget.ListView.a<bu, ak<bv>> {
    private aa<bv> adN;
    private v ajt;
    public BdUniqueId eEU;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adN = new aa<bv>() { // from class: com.baidu.tieba.homepage.tabfeed.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                s.bRL().km(true);
                com.baidu.tieba.homepage.tabfeed.b.a(view, bvVar, i.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.eEU = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.ajt = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        ai a = aVar.a(false, viewGroup, this.ajt);
        a.setSourceForPb(2);
        ak akVar = new ak(a);
        akVar.setPageId(this.eEU);
        a(new z() { // from class: com.baidu.tieba.homepage.tabfeed.a.i.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bu) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    bv bvVar = ((bu) qVar).dLK;
                    bvVar.objType = 1;
                    if (i.this.adN != null) {
                        i.this.adN.a(akVar2.getView(), bvVar);
                    }
                    ax.a((AbsThreadDataSupport) bvVar, view.getContext(), 2, false);
                    akVar2.sg().b(new a.C0096a(1));
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
        akVar.sg().a(this.adN);
        com.baidu.tieba.homepage.tabfeed.b.a(buVar, this.mTabName);
        return akVar.getView();
    }
}
