package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements View.OnClickListener {
    final /* synthetic */ ItemFootNavView a;
    private final /* synthetic */ com.baidu.tbadk.a b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ItemFootNavView itemFootNavView, com.baidu.tbadk.a aVar, String str) {
        this.a = itemFootNavView;
        this.b = aVar;
        this.c = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        boolean z;
        context = this.a.a;
        TiebaStatic.a(context, "detail_enter_forum", "click", 1, new Object[0]);
        z = this.a.g;
        if (z) {
            this.b.finish();
        } else {
            this.b.sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.b).a(this.c, BarDetailForDirSwitchStatic.BAR_DETAIL_DIR)));
        }
    }
}
