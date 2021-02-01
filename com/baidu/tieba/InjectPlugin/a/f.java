package com.baidu.tieba.InjectPlugin.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class f<ViewGroup, Object> extends com.baidu.adp.widget.ListView.a {
    protected TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public TypeAdapter.ViewHolder e(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        return null;
    }
}
