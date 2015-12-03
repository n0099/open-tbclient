package com.baidu.tieba.homepage.listview;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.x.a;
/* loaded from: classes.dex */
public abstract class a<T, V extends x.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    public boolean aRB;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.aRB = true;
    }
}
