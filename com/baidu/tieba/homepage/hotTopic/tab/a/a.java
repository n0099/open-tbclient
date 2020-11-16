package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.af.a;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.bx;
/* loaded from: classes21.dex */
public abstract class a<T, V extends af.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected com.baidu.tbadk.h.f aiR;
    protected v alH;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.aiR = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(v vVar) {
        this.alH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        this.mIsFromCDN = true;
        a(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mIsFromCDN = true;
        this.mPageContext = ((TbPageContextSupport) context).getPageContext();
        a(this.mPageContext, this.mPageContext == null ? null : this.mPageContext.getUniqueId());
    }

    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mPageContext = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        return view;
    }

    public void a(View view, bx bxVar, int i, long j) {
        if (this.aiR != null) {
            this.aiR.b(view, bxVar, i, j);
        }
    }

    public void f(View view, bx bxVar) {
        if (this.aiR != null) {
            this.aiR.a(view, bxVar, bxVar.position, bxVar.position);
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }
}
