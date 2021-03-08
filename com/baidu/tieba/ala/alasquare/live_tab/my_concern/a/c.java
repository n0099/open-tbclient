package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernItemViewLineHolder;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, LiveTabConcernItemViewLineHolder> {
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.d gEf;
    private i gEg;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.gCU);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public LiveTabConcernItemViewLineHolder e(ViewGroup viewGroup) {
        this.gEf = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.d(this.mPageContext, viewGroup);
        if (this.gEg != null) {
            this.gEf.a(this.gEg);
        }
        return new LiveTabConcernItemViewLineHolder(this.gEf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        if (liveTabConcernItemViewLineHolder == null || liveTabConcernItemViewLineHolder.gEf == null) {
            return null;
        }
        liveTabConcernItemViewLineHolder.gEf.a(kVar);
        return liveTabConcernItemViewLineHolder.getView();
    }

    public void a(i iVar) {
        this.gEg = iVar;
        if (this.gEf != null) {
            this.gEf.a(this.gEg);
        }
    }
}
