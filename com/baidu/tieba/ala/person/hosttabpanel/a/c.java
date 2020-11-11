package com.baidu.tieba.ala.person.hosttabpanel.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.hosttabpanel.d.c;
/* loaded from: classes4.dex */
public class c extends AbsDelegateAdapter<com.baidu.tieba.ala.person.hosttabpanel.b.b, c.a> {
    private com.baidu.tieba.ala.person.hosttabpanel.d.c hAs;
    private TbPageContext mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.person.hosttabpanel.b.b bVar, c.a aVar) {
        aVar.hAs.onBindDataToView(bVar);
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: aL */
    public c.a onCreateViewHolder(ViewGroup viewGroup) {
        this.hAs = new com.baidu.tieba.ala.person.hosttabpanel.d.c(this.mPageContext);
        return new c.a(this.hAs);
    }

    public void onDestroy() {
        if (this.hAs != null) {
            this.hAs.onDestroy();
        }
    }
}
