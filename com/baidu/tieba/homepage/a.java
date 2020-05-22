package com.baidu.tieba.homepage;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.aa.a;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes8.dex */
public abstract class a<T, V extends aa.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected FollowUserButton.a hWm;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void a(FollowUserButton.a aVar) {
        this.hWm = aVar;
    }
}
