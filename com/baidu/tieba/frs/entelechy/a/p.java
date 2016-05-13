package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.frs.fh;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.a<ax, a> {
    private TbPageContext<?> DV;
    private com.baidu.tieba.frs.entelechy.c.o bpc;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.DV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: J */
    public a b(ViewGroup viewGroup) {
        this.bpc = new com.baidu.tieba.frs.entelechy.c.o(this.DV);
        this.bpc.j(this.DV.getUniqueId());
        return new a(this.bpc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ax axVar, a aVar) {
        aVar.bpd.h(axVar);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends y.a implements fh {
        public com.baidu.tieba.frs.entelechy.c.o bpd;

        public a(com.baidu.tieba.frs.entelechy.c.o oVar) {
            super(oVar.getView());
            this.bpd = oVar;
        }

        @Override // com.baidu.tieba.frs.fh
        public void Kb() {
            this.bpd.Kb();
        }

        @Override // com.baidu.tieba.frs.fh
        public void RG() {
            this.bpd.ch(true);
        }

        @Override // com.baidu.tieba.frs.fh
        public void RH() {
            this.bpd.ch(false);
        }
    }
}
