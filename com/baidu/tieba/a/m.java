package com.baidu.tieba.a;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.c.r {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, Context context) {
        super(context);
        this.a = jVar;
    }

    @Override // com.baidu.tieba.c.r, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        str = this.a.b;
        if (str != null) {
            str3 = this.a.b;
            str4 = str3.replace("@", "").replace(" ", "");
        }
        Context a = a();
        str2 = this.a.e;
        PersonInfoActivity.a(a, str2, str4);
    }
}
