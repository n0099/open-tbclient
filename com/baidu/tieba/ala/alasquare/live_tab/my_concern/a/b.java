package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.special_forum.data.e, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.c> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.special_forum.data.e.eiW);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.c b(ViewGroup viewGroup) {
        return new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.c(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.b(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.special_forum.data.e eVar, com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.c cVar) {
        if (cVar == null || cVar.ejt == null) {
            return null;
        }
        cVar.ejt.a(eVar);
        return cVar.getView();
    }
}
