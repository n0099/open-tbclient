package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.k> adN;
    private String afx;
    private boolean aib;
    private com.baidu.adp.widget.ListView.v ajt;
    public BdUniqueId eEU;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aib = true;
        this.adN = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.aTN() != null && !StringUtils.isNull(kVar.aTN().getTid())) {
                    g.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajt = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
        } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        x xVar = new x(this.mPageContext.getPageActivity());
        xVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        xVar.setFromCDN(this.aib);
        aVar.c(xVar);
        ai a = aVar.a(false, viewGroup, this.ajt);
        a.setSourceForPb(1);
        ak akVar = new ak(a);
        akVar.setPageId(this.eEU);
        a(new z() { // from class: com.baidu.tieba.homepage.concern.a.g.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (g.this.adN != null) {
                        g.this.adN.a(akVar2.getView(), kVar);
                    }
                    ax.a((AbsThreadDataSupport) kVar, view.getContext(), 1, false);
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ak<com.baidu.tieba.card.data.k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLK == null) {
            return null;
        }
        kVar.tj(kVar.position + 1);
        com.baidu.tieba.card.s.bRL().e(kVar.EF("c12351"));
        akVar.sg().setPosition(i);
        if (akVar.sg() instanceof com.baidu.tieba.a.e) {
            akVar.sg().setPage(this.afx);
        }
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.adN);
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }
}
