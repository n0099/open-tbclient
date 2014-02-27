package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends com.baidu.tieba.util.ao {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(k kVar, Context context) {
        super(context);
        this.a = kVar;
    }

    @Override // com.baidu.tieba.util.ao, android.text.style.ClickableSpan
    public final void onClick(View view) {
        String str;
        str = this.a.b;
        a(str);
    }
}
