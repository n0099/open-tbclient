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
    private TbPageContext<?> EA;
    public BdUniqueId aTm;
    private bx<g> bKK;
    private j csK;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bKK = new e(this);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public a a(ViewGroup viewGroup) {
        this.csK = new j(this.EA);
        this.csK.i(this.aTm);
        return new a(this.csK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        aVar.csM.a(hVar);
        if (aVar.csM.KQ() != null) {
            aVar.csM.KQ().a(this.bKK);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public j csM;

        public a(j jVar) {
            super(jVar.getView());
            this.csM = jVar;
        }
    }
}
