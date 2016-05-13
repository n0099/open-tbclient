package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.frs.fh;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.widget.ListView.a<ax, a> {
    private TbPageContext<?> DV;
    private com.baidu.tieba.frs.entelechy.c.a bph;

    /* JADX INFO: Access modifiers changed from: protected */
    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public a b(ViewGroup viewGroup) {
        this.bph = new com.baidu.tieba.frs.entelechy.c.a(this.DV);
        this.bph.j(this.DV.getUniqueId());
        return new a(this.bph);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ax axVar, a aVar) {
        aVar.bpi.h(axVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements fh {
        public com.baidu.tieba.frs.entelechy.c.a bpi;

        public a(com.baidu.tieba.frs.entelechy.c.a aVar) {
            super(aVar.getView());
            this.bpi = aVar;
        }

        @Override // com.baidu.tieba.frs.fh
        public void Kb() {
            this.bpi.Kb();
        }

        @Override // com.baidu.tieba.frs.fh
        public void RG() {
            this.bpi.ch(true);
        }

        @Override // com.baidu.tieba.frs.fh
        public void RH() {
            this.bpi.ch(false);
        }
    }
}
