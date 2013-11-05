package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.switchs.SwitchKey;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1220a;
    final /* synthetic */ com.baidu.tieba.j b;
    final /* synthetic */ String c;
    final /* synthetic */ ItemFootNavView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ItemFootNavView itemFootNavView, boolean z, com.baidu.tieba.j jVar, String str) {
        this.d = itemFootNavView;
        this.f1220a = z;
        this.b = jVar;
        this.c = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (TiebaApplication.g().s()) {
            context = this.d.f1211a;
            StatService.onEvent(context, "detail_enter_forum", "click", 1);
        }
        if (this.f1220a) {
            this.b.finish();
        } else {
            FrsActivity.a(this.b, this.c, SwitchKey.BAR_DETAIL_DIR);
        }
    }
}
