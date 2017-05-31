package com.baidu.tieba.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.adp.widget.ListView.z.a;
/* loaded from: classes.dex */
public abstract class a<T, V extends z.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    public boolean aVe;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.aVe = true;
    }
}
