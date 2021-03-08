package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes2.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected com.baidu.tbadk.h.f akI;
    protected s anC;
    protected boolean mIsFromCDN;
    protected TbPageContext<?> mPageContext;

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.akI = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void a(s sVar) {
        this.anC = sVar;
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

    public void a(View view, cb cbVar, int i, long j) {
        if (this.akI != null) {
            this.akI.b(view, cbVar, i, j);
        }
    }

    public void f(View view, cb cbVar) {
        if (this.akI != null) {
            this.akI.a(view, cbVar, cbVar.position, cbVar.position);
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }
}
