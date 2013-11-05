package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1225a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, String str) {
        this.b = lVar;
        this.f1225a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TiebaApplication.g().s()) {
            context2 = this.b.c;
            StatService.onEvent(context2, "detail_hot_thread", "click", 1);
        }
        context = this.b.c;
        NewPbActivity.a(context, this.f1225a, "", "");
    }
}
