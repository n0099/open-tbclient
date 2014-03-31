package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.b.af;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements View.OnClickListener {
    final /* synthetic */ ItemHotThreadView a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ItemHotThreadView itemHotThreadView, String str) {
        this.a = itemHotThreadView;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        context = this.a.a;
        TiebaStatic.a(context, "detail_hot_thread", "click", 1, new Object[0]);
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        context2 = this.a.a;
        a.a(new com.baidu.adp.framework.message.a(2004001, new af(context2).a(this.b, "", "")));
    }
}
