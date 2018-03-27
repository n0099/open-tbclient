package com.baidu.tieba.frs.gamesubpb;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.model.d;
import com.baidu.tieba.frs.gamesubpb.view.c;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<d, c.a> {
    private TbPageContext dPF;
    private InterfaceC0156a dPG;

    /* renamed from: com.baidu.tieba.frs.gamesubpb.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0156a {
        void a(d dVar);

        void b(d dVar);

        void c(d dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dPF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public c.a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.gamesubpb.view.c cVar = new com.baidu.tieba.frs.gamesubpb.view.c(this.dPF);
        cVar.setClickListener(this.dPG);
        return new c.a(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, d dVar, c.a aVar) {
        if (dVar != null) {
            aVar.f(dVar);
        }
        return aVar.getView();
    }

    public void setClickListener(InterfaceC0156a interfaceC0156a) {
        this.dPG = interfaceC0156a;
    }
}
