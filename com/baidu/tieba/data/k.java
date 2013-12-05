package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.util.ag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1251a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, Context context) {
        super(context);
        this.f1251a = jVar;
    }

    @Override // com.baidu.tieba.util.ag, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        str = this.f1251a.b;
        a(str);
    }
}
