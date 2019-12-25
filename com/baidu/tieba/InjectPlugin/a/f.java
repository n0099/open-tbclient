package com.baidu.tieba.InjectPlugin.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class f<ViewGroup, Object> extends com.baidu.adp.widget.ListView.a {
    protected TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected v.a b(ViewGroup viewGroup) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(int i, View view, ViewGroup viewGroup, Object obj, v.a aVar) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        return null;
    }
}
