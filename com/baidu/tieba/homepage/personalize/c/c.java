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
    private final TbPageContext<?> Ea;
    private bx<e> bJf;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJf = new d(this);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public a a(ViewGroup viewGroup) {
        com.baidu.tieba.homepage.personalize.c.a aVar = new com.baidu.tieba.homepage.personalize.c.a(this.Ea);
        aVar.a(this.bJf);
        return new a(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, e eVar, a aVar) {
        bw.Lg().a(new ay("c11272"));
        aVar.csX.a(eVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.homepage.personalize.c.a csX;

        public a(com.baidu.tieba.homepage.personalize.c.a aVar) {
            super(aVar.getView());
            this.csX = aVar;
        }
    }
}
