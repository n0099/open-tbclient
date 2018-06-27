package com.baidu.tieba.frs.gamesubpb;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.model.d;
import com.baidu.tieba.frs.gamesubpb.view.b;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<d, b.a> {
    private TbPageContext dxu;
    private InterfaceC0157a dxv;

    /* renamed from: com.baidu.tieba.frs.gamesubpb.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0157a {
        void a(d dVar);

        void b(d dVar);

        void c(d dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dxu = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aE */
    public b.a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.gamesubpb.view.b bVar = new com.baidu.tieba.frs.gamesubpb.view.b(this.dxu);
        bVar.setClickListener(this.dxv);
        return new b.a(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, d dVar, b.a aVar) {
        if (dVar != null) {
            aVar.f(dVar);
        }
        return aVar.getView();
    }

    public void setClickListener(InterfaceC0157a interfaceC0157a) {
        this.dxv = interfaceC0157a;
    }
}
