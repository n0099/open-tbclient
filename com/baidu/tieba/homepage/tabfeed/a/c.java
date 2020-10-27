package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> {
    private NEGFeedBackView.a fJp;
    public BdUniqueId fmX;
    ab<com.baidu.tieba.card.data.k> igS;
    private com.baidu.tieba.card.l jym;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fJp = null;
        this.igS = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                int i = 0;
                if (c.this.jym.fSf != view) {
                    if (view != c.this.jym.gMs.getCommentContainer()) {
                        if (view != c.this.jym.hPB.getCommentContainer()) {
                            if (c.this.jym.clv() != null && view.getId() == c.this.jym.clv().getId()) {
                                i = 2;
                            } else if (c.this.jym.clw() != null && view.getId() == c.this.jym.clw().getId()) {
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
                    com.baidu.tieba.homepage.personalize.c.a.a(kVar.erH, c.this.fmX, kVar.cmc(), i);
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> c(ViewGroup viewGroup) {
        this.jym = new com.baidu.tieba.card.l(this.mPageContext, this.fmX);
        this.jym.wN(2);
        if (this.fmX != null) {
            this.jym.o(this.fmX);
        }
        return new com.baidu.tieba.card.a.a<>(this.jym);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        kVar.wW(kVar.position + 1);
        com.baidu.tieba.card.l cmx = aVar.cmx();
        cmx.wS(i + 1);
        cmx.a(kVar);
        cmx.c(this.igS);
        cmx.b(this.fJp);
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.erH, this.fmX, kVar.cmc());
        com.baidu.tieba.homepage.tabfeed.b.a(kVar, this.mTabName);
        return aVar.getView();
    }
}
