package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.cm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends com.baidu.tieba.util.ao {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(k kVar, Context context) {
        super(context);
        this.a = kVar;
    }

    @Override // com.baidu.tieba.util.ao, android.text.style.ClickableSpan
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
        Context a = a();
        str2 = this.a.g;
        cm.a(a, str2, str4);
    }
}
