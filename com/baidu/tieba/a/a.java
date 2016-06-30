package com.baidu.tieba.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.adp.widget.ListView.y.a;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public abstract class a<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected TbPageContext<?> Ea;
    public boolean aMF;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.aMF = true;
    }

    public void m(TbPageContext<?> tbPageContext) {
        this.Ea = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }
}
