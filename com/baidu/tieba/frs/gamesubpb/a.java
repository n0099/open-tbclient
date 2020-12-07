package com.baidu.tieba.frs.gamesubpb;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.model.d;
import com.baidu.tieba.frs.gamesubpb.view.b;
/* loaded from: classes22.dex */
public class a extends com.baidu.adp.widget.ListView.a<d, b.a> {
    private TbPageContext jnn;
    private InterfaceC0747a jno;

    /* renamed from: com.baidu.tieba.frs.gamesubpb.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0747a {
        void a(d dVar);

        void b(d dVar);

        void c(d dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.jnn = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: by */
    public b.a c(ViewGroup viewGroup) {
        com.baidu.tieba.frs.gamesubpb.view.b bVar = new com.baidu.tieba.frs.gamesubpb.view.b(this.jnn);
        bVar.setClickListener(this.jno);
        return new b.a(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, d dVar, b.a aVar) {
        if (dVar != null) {
            aVar.f(dVar);
        }
        return aVar.getView();
    }

    public void setClickListener(InterfaceC0747a interfaceC0747a) {
        this.jno = interfaceC0747a;
    }
}
