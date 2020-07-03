package com.baidu.tieba.homepage;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.ad.a;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes8.dex */
public abstract class a<T, V extends ad.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected FollowUserButton.a ilu;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void a(FollowUserButton.a aVar) {
        this.ilu = aVar;
    }
}
