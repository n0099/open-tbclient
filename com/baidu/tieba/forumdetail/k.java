package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1287a;
    final /* synthetic */ ItemHotThreadView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ItemHotThreadView itemHotThreadView, String str) {
        this.b = itemHotThreadView;
        this.f1287a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TiebaApplication.g().s()) {
            context2 = this.b.f1276a;
            StatService.onEvent(context2, "detail_hot_thread", "click", 1);
        }
        context = this.b.f1276a;
        NewPbActivity.a(context, this.f1287a, "", "");
    }
}
