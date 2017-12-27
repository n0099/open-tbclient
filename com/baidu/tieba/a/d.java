package com.baidu.tieba.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.r.a;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public abstract class d<T, V extends r.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }
}
