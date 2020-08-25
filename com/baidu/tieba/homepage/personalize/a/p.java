package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes16.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, al<com.baidu.tieba.card.data.l>> {
    private com.baidu.adp.widget.ListView.v akI;
    public BdUniqueId ePv;
    private TbPageContext<?> mPageContext;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.h) new com.baidu.card.z(this.mPageContext.getPageActivity()));
        aj a = aVar.a(false, viewGroup, this.akI);
        a.setSourceForPb(2);
        al<com.baidu.tieba.card.data.l> alVar = new al<>(a);
        alVar.setPageId(this.ePv);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.p.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof al)) {
                    ay.a((AbsThreadDataSupport) ((com.baidu.tieba.card.data.l) qVar), view.getContext(), 2, false);
                    ((al) view.getTag()).tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, al<com.baidu.tieba.card.data.l> alVar) {
        if (lVar == null || alVar == null || alVar.getView() == null || lVar.dUS == null) {
            return null;
        }
        lVar.vy(lVar.position + 1);
        alVar.tR().setPosition(i);
        alVar.b((al<com.baidu.tieba.card.data.l>) lVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return alVar.getView();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.akI = vVar;
    }
}
