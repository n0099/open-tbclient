package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.g;
import com.baidu.tieba.card.a.h;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.j;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    private TbPageContext<?> Ea;
    public BdUniqueId aSq;
    private bx<g> bJf;
    private j cqf;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJf = new e(this);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public a a(ViewGroup viewGroup) {
        this.cqf = new j(this.Ea);
        this.cqf.i(this.aSq);
        return new a(this.cqf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        aVar.cqh.a(hVar);
        if (aVar.cqh.KR() != null) {
            aVar.cqh.KR().a(this.bJf);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public j cqh;

        public a(j jVar) {
            super(jVar.getView());
            this.cqh = jVar;
        }
    }
}
