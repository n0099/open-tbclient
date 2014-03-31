package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends com.baidu.tieba.util.l {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(f fVar, Context context) {
        super(context);
        this.a = fVar;
    }

    @Override // com.baidu.tieba.util.l, android.text.style.ClickableSpan
    public final void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        str = this.a.b;
        if (str != null) {
            str3 = this.a.b;
            str4 = str3.replace("@", "").replace(" ", "");
        }
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        Context a2 = a();
        str2 = this.a.g;
        a.a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(a2, str2, str4)));
    }
}
