package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.util.s {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1016a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, Context context) {
        super(context);
        this.f1016a = iVar;
    }

    @Override // com.baidu.tieba.util.s, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        str = this.f1016a.b;
        a(str);
    }
}
