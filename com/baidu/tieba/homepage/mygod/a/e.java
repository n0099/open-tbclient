package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.data.g;
import com.baidu.tieba.card.data.h;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<h, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYW;
    private cd<g> bVT;
    private com.baidu.tieba.card.d cEx;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVT = new f(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public a a(ViewGroup viewGroup) {
        this.cEx = new com.baidu.tieba.card.d(this.GM);
        this.cEx.i(this.aYW);
        return new a(this.cEx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        aVar.cEz.onBindDataToView(hVar);
        if (aVar.cEz.NT() != null) {
            aVar.cEz.NT().setOnSubCardOnClickListenner(this.bVT);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.d cEz;

        public a(com.baidu.tieba.card.d dVar) {
            super(dVar.getView());
            this.cEz = dVar;
        }
    }
}
