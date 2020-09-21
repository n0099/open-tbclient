package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.aa;
/* loaded from: classes21.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    public BdUniqueId eSq;
    private NEGFeedBackView.a foG;
    aa<com.baidu.tieba.card.data.k> hFx;
    private com.baidu.tieba.card.k iWO;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.foG = null;
        this.hFx = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (c.this.iWO.fxB != view) {
                    if (view != c.this.iWO.gml.getCommentContainer()) {
                        if (view != c.this.iWO.hol.getCommentContainer()) {
                            if (c.this.iWO.ceS() != null && view.getId() == c.this.iWO.ceS().getId()) {
                                i = 2;
                            } else if (c.this.iWO.ceT() != null && view.getId() == c.this.iWO.ceT().getId()) {
                                i = 2;
                            }
                        }
                    } else {
                        i = 5;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.dXg, c.this.eSq, kVar.cfz(), i);
                }
                com.baidu.tieba.homepage.tabfeed.b.a(view, kVar, c.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.mTabName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> c(ViewGroup viewGroup) {
        this.iWO = new com.baidu.tieba.card.k(this.mPageContext, this.eSq);
        this.iWO.vO(2);
        if (this.eSq != null) {
            this.iWO.o(this.eSq);
        }
        return new com.baidu.tieba.card.a.a<>(this.iWO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        kVar.vX(kVar.position + 1);
        com.baidu.tieba.card.k cfU = aVar.cfU();
        cfU.vT(i + 1);
        cfU.a(kVar);
        cfU.c(this.hFx);
        cfU.b(this.foG);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dXg, this.eSq, kVar.cfz());
        com.baidu.tieba.homepage.tabfeed.b.a(kVar, this.mTabName);
        return aVar.getView();
    }
}
