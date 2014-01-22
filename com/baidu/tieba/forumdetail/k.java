package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ ItemHotThreadView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ItemHotThreadView itemHotThreadView, String str) {
        this.b = itemHotThreadView;
        this.a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.b.a;
        by.a(context, "detail_hot_thread", "click", 1, new Object[0]);
        context2 = this.b.a;
        NewPbActivity.a(context2, this.a, "", "");
    }
}
