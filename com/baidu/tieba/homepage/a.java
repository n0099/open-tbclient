package com.baidu.tieba.homepage;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected FollowUserButton.a jRn;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void a(FollowUserButton.a aVar) {
        this.jRn = aVar;
    }
}
