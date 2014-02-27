package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements View.OnClickListener {
    final /* synthetic */ ItemHotThreadView a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ItemHotThreadView itemHotThreadView, String str) {
        this.a = itemHotThreadView;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        context = this.a.a;
        cb.a(context, "detail_hot_thread", "click", 1, new Object[0]);
        context2 = this.a.a;
        NewPbActivity.a(context2, this.b, "", "");
    }
}
