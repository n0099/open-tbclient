package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f1093a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, String str) {
        this.f1093a = kVar;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TiebaApplication.g().s()) {
            context2 = this.f1093a.c;
            StatService.onEvent(context2, "detail_hot_thread", "click", 1);
        }
        context = this.f1093a.c;
        NewPbActivity.a(context, this.b, "", "");
    }
}
