package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    public BdUniqueId ePv;
    private NEGFeedBackView.a flJ;
    aa<com.baidu.tieba.card.data.k> hyp;
    private com.baidu.tieba.card.k iOc;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.flJ = null;
        this.hyp = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (c.this.iOc.fum != view) {
                    if (view != c.this.iOc.gja.getCommentContainer()) {
                        if (view != c.this.iOc.hhd.getCommentContainer()) {
                            if (c.this.iOc.cbC() != null && view.getId() == c.this.iOc.cbC().getId()) {
                                i = 2;
                            } else if (c.this.iOc.cbD() != null && view.getId() == c.this.iOc.cbD().getId()) {
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
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.dUS, c.this.ePv, kVar.ccj(), i);
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
        this.iOc = new com.baidu.tieba.card.k(this.mPageContext, this.ePv);
        this.iOc.vp(2);
        if (this.ePv != null) {
            this.iOc.p(this.ePv);
        }
        return new com.baidu.tieba.card.a.a<>(this.iOc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        kVar.vy(kVar.position + 1);
        com.baidu.tieba.card.k ccE = aVar.ccE();
        ccE.vu(i + 1);
        ccE.a(kVar);
        ccE.c(this.hyp);
        ccE.b(this.flJ);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dUS, this.ePv, kVar.ccj());
        com.baidu.tieba.homepage.tabfeed.b.a(kVar, this.mTabName);
        return aVar.getView();
    }
}
