package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.aa;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    private NEGFeedBackView.a fAU;
    public BdUniqueId fey;
    aa<com.baidu.tieba.card.data.k> hUs;
    private com.baidu.tieba.card.k jlM;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fAU = null;
        this.hUs = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (c.this.jlM.fJK != view) {
                    if (view != c.this.jlM.gAE.getCommentContainer()) {
                        if (view != c.this.jlM.hDf.getCommentContainer()) {
                            if (c.this.jlM.cio() != null && view.getId() == c.this.jlM.cio().getId()) {
                                i = 2;
                            } else if (c.this.jlM.cip() != null && view.getId() == c.this.jlM.cip().getId()) {
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
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.eji, c.this.fey, kVar.ciV(), i);
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
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> c(ViewGroup viewGroup) {
        this.jlM = new com.baidu.tieba.card.k(this.mPageContext, this.fey);
        this.jlM.wu(2);
        if (this.fey != null) {
            this.jlM.o(this.fey);
        }
        return new com.baidu.tieba.card.a.a<>(this.jlM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        kVar.wD(kVar.position + 1);
        com.baidu.tieba.card.k cjq = aVar.cjq();
        cjq.wz(i + 1);
        cjq.a(kVar);
        cjq.c(this.hUs);
        cjq.b(this.fAU);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.eji, this.fey, kVar.ciV());
        com.baidu.tieba.homepage.tabfeed.b.a(kVar, this.mTabName);
        return aVar.getView();
    }
}
