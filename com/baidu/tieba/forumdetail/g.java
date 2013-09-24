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
    final /* synthetic */ ItemFootNavView f1088a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ com.baidu.tieba.j c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ItemFootNavView itemFootNavView, boolean z, com.baidu.tieba.j jVar, String str) {
        this.f1088a = itemFootNavView;
        this.b = z;
        this.c = jVar;
        this.d = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (TiebaApplication.g().s()) {
            context = this.f1088a.f1080a;
            StatService.onEvent(context, "detail_enter_forum", "click", 1);
        }
        if (this.b) {
            this.c.finish();
        } else {
            FrsActivity.a(this.c, this.d, SwitchKey.BAR_DETAIL_DIR);
        }
    }
}
