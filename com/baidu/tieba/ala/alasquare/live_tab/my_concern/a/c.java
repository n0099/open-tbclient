package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernItemViewLineHolder;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, LiveTabConcernItemViewLineHolder> {
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.d gzy;
    private i gzz;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), k.gyn);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public LiveTabConcernItemViewLineHolder e(ViewGroup viewGroup) {
        this.gzy = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.d(this.mPageContext, viewGroup);
        if (this.gzz != null) {
            this.gzy.a(this.gzz);
        }
        return new LiveTabConcernItemViewLineHolder(this.gzy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        if (liveTabConcernItemViewLineHolder == null || liveTabConcernItemViewLineHolder.gzy == null) {
            return null;
        }
        liveTabConcernItemViewLineHolder.gzy.a(kVar);
        return liveTabConcernItemViewLineHolder.getView();
    }

    public void a(i iVar) {
        this.gzz = iVar;
        if (this.gzy != null) {
            this.gzy.a(this.gzz);
        }
    }
}
