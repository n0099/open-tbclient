package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.h;
import com.baidu.tieba.card.by;
import com.baidu.tieba.card.o;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    private TbPageContext<?> DV;
    private o bKm;
    private by boZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.aRJ);
        this.boZ = new e(this);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public a b(ViewGroup viewGroup) {
        this.bKm = new o(this.DV);
        this.bKm.i(this.DV.getUniqueId());
        this.bKm.a(this.boZ);
        return new a(this.bKm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.bKo == null) {
            return null;
        }
        aVar.bKo.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public o bKo;

        public a(o oVar) {
            super(oVar.getView());
            this.bKo = oVar;
        }
    }
}
