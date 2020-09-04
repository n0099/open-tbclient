package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    public BdUniqueId ePz;
    private NEGFeedBackView.a flN;
    aa<com.baidu.tieba.card.data.k> hyv;
    private com.baidu.tieba.card.k iOi;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.flN = null;
        this.hyv = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (c.this.iOi.fuq != view) {
                    if (view != c.this.iOi.gje.getCommentContainer()) {
                        if (view != c.this.iOi.hhh.getCommentContainer()) {
                            if (c.this.iOi.cbD() != null && view.getId() == c.this.iOi.cbD().getId()) {
                                i = 2;
                            } else if (c.this.iOi.cbE() != null && view.getId() == c.this.iOi.cbE().getId()) {
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
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.dUW, c.this.ePz, kVar.cck(), i);
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
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> b(ViewGroup viewGroup) {
        this.iOi = new com.baidu.tieba.card.k(this.mPageContext, this.ePz);
        this.iOi.vp(2);
        if (this.ePz != null) {
            this.iOi.p(this.ePz);
        }
        return new com.baidu.tieba.card.a.a<>(this.iOi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        kVar.vy(kVar.position + 1);
        com.baidu.tieba.card.k ccF = aVar.ccF();
        ccF.vu(i + 1);
        ccF.a(kVar);
        ccF.c(this.hyv);
        ccF.b(this.flN);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dUW, this.ePz, kVar.cck());
        com.baidu.tieba.homepage.tabfeed.b.a(kVar, this.mTabName);
        return aVar.getView();
    }
}
