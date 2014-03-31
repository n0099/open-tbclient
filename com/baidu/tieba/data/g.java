package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends com.baidu.tieba.util.l {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, Context context) {
        super(context);
        this.a = fVar;
    }

    @Override // com.baidu.tieba.util.l, android.text.style.ClickableSpan
    public final void onClick(View view) {
        String str;
        str = this.a.b;
        a(str);
    }
}
