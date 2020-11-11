package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> {
    private NEGFeedBackView.a fPf;
    public BdUniqueId fsQ;
    ab<com.baidu.tieba.card.data.k> imQ;
    private com.baidu.tieba.card.l jEj;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fPf = null;
        this.imQ = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (c.this.jEj.fXV != view) {
                    if (view != c.this.jEj.gSR.getCommentContainer()) {
                        if (view != c.this.jEj.hVy.getCommentContainer()) {
                            if (c.this.jEj.cnW() != null && view.getId() == c.this.jEj.cnW().getId()) {
                                i = 2;
                            } else if (c.this.jEj.cnX() != null && view.getId() == c.this.jEj.cnX().getId()) {
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
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.exA, c.this.fsQ, kVar.coD(), i);
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
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> c(ViewGroup viewGroup) {
        this.jEj = new com.baidu.tieba.card.l(this.mPageContext, this.fsQ);
        this.jEj.xa(2);
        if (this.fsQ != null) {
            this.jEj.o(this.fsQ);
        }
        return new com.baidu.tieba.card.a.a<>(this.jEj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        kVar.xj(kVar.position + 1);
        com.baidu.tieba.card.l coY = aVar.coY();
        coY.xf(i + 1);
        coY.a(kVar);
        coY.c(this.imQ);
        coY.b(this.fPf);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.exA, this.fsQ, kVar.coD());
        com.baidu.tieba.homepage.tabfeed.b.a(kVar, this.mTabName);
        return aVar.getView();
    }
}
