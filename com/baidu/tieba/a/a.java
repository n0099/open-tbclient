package com.baidu.tieba.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.adp.widget.ListView.y.a;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public abstract class a<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected TbPageContext<?> EA;
    public boolean aNz;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.aNz = true;
    }

    public void m(TbPageContext<?> tbPageContext) {
        this.EA = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }
}
