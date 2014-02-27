package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements View.OnClickListener {
    final /* synthetic */ ItemFootNavView a;
    private final /* synthetic */ com.baidu.tieba.f b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ItemFootNavView itemFootNavView, com.baidu.tieba.f fVar, String str) {
        this.a = itemFootNavView;
        this.b = fVar;
        this.c = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        boolean z;
        context = this.a.a;
        cb.a(context, "detail_enter_forum", "click", 1, new Object[0]);
        z = this.a.g;
        if (z) {
            this.b.finish();
        } else {
            FrsActivity.a(this.b, this.c, SwitchKey.BAR_DETAIL_DIR);
        }
    }
}
