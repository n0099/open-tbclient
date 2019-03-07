package com.baidu.tieba.b;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.v.a;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public abstract class d<T, V extends v.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }
}
