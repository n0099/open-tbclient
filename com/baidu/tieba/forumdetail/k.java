package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
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
        if (TiebaApplication.h().t()) {
            context2 = this.b.a;
            StatService.onEvent(context2, "detail_hot_thread", "click", 1);
        }
        context = this.b.a;
        NewPbActivity.a(context, this.a, "", "");
    }
}
