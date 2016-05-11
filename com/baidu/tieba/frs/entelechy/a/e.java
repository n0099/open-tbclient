package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tieba.card.by;
import com.baidu.tieba.frs.entelechy.c.af;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<ag, a> {
    private TbPageContext<?> DV;
    private af boL;
    private by boM;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boM = new f(this);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public a b(ViewGroup viewGroup) {
        this.boL = new af(this.DV);
        this.boL.i(this.DV.getUniqueId());
        return new a(this.boL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ag agVar, a aVar) {
        if (aVar == null || aVar.boO == null) {
            return null;
        }
        aVar.boO.a(agVar);
        aVar.boO.a(this.boM);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public af boO;

        public a(af afVar) {
            super(afVar.getView());
            this.boO = afVar;
        }
    }
}
