package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<e, a> {
    private final TbPageContext<?> EA;
    private bx<e> bKK;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bKK = new d(this);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public a a(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.personalize.c.a aVar = new com.baidu.tieba.homepage.personalize.c.a(this.EA);
        aVar.a(this.bKK);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, e eVar, a aVar) {
        bw.Lf().b(new ay("c11272"));
        aVar.cvI.a(eVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.homepage.personalize.c.a cvI;

        public a(com.baidu.tieba.homepage.personalize.c.a aVar) {
            super(aVar.getView());
            this.cvI = aVar;
        }
    }
}
