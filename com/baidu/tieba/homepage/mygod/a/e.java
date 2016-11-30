package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.data.g;
import com.baidu.tieba.card.data.h;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<h, a> {
    private TbPageContext<?> GO;
    private bz<g> bZe;
    public BdUniqueId bcf;
    private com.baidu.tieba.card.d cJK;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bZe = new f(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public a a(ViewGroup viewGroup) {
        this.cJK = new com.baidu.tieba.card.d(this.GO);
        this.cJK.i(this.bcf);
        return new a(this.cJK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        aVar.cJM.onBindDataToView(hVar);
        if (aVar.cJM.OW() != null) {
            aVar.cJM.OW().setOnSubCardOnClickListenner(this.bZe);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.d cJM;

        public a(com.baidu.tieba.card.d dVar) {
            super(dVar.getView());
            this.cJM = dVar;
        }
    }
}
