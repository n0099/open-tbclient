package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.util.p {
    final /* synthetic */ i a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(i iVar, Context context, String str) {
        super(context);
        this.a = iVar;
        this.b = str;
    }

    @Override // com.baidu.tieba.util.p, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        Context a = a();
        str = this.a.f;
        PersonInfoActivity.a(a, str, this.b);
    }
}
