package com.baidu.tieba.ala.person.hosttabpanel.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.hosttabpanel.d.b;
/* loaded from: classes3.dex */
public class b extends AbsDelegateAdapter<com.baidu.tieba.ala.person.hosttabpanel.b.a, b.a> {
    private com.baidu.tieba.ala.person.hosttabpanel.d.b gkP;
    private TbPageContext mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.person.hosttabpanel.b.a aVar, b.a aVar2) {
        aVar2.gkP.onBindDataToView(aVar);
        return aVar2.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: aB */
    public b.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.gkP != null) {
            this.gkP.onDestroy();
        }
        this.gkP = new com.baidu.tieba.ala.person.hosttabpanel.d.b(this.mPageContext);
        return new b.a(this.gkP);
    }

    public void onDestroy() {
        if (this.gkP != null) {
            this.gkP.onDestroy();
        }
    }
}
