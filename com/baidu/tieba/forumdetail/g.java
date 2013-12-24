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
    final /* synthetic */ com.baidu.tieba.j a;
    final /* synthetic */ String b;
    final /* synthetic */ ItemFootNavView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ItemFootNavView itemFootNavView, com.baidu.tieba.j jVar, String str) {
        this.c = itemFootNavView;
        this.a = jVar;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Context context;
        if (TiebaApplication.h().t()) {
            context = this.c.a;
            StatService.onEvent(context, "detail_enter_forum", "click", 1);
        }
        z = this.c.g;
        if (z) {
            this.a.finish();
        } else {
            FrsActivity.a(this.a, this.b, SwitchKey.BAR_DETAIL_DIR);
        }
    }
}
