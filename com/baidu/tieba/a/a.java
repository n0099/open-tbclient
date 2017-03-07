package com.baidu.tieba.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.adp.widget.ListView.y.a;
/* loaded from: classes.dex */
public abstract class a<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    public boolean aWP;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.aWP = true;
    }
}
