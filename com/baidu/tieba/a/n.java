package com.baidu.tieba.a;

import android.content.Context;
import android.view.View;
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.d.r {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(k kVar, Context context) {
        super(context);
        this.a = kVar;
    }

    @Override // com.baidu.tieba.d.r, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        str = this.a.b;
        if (str != null) {
            str3 = this.a.b;
            str4 = str3.replace("@", "").replace(HanziToPinyin.Token.SEPARATOR, "");
        }
        Context a = a();
        str2 = this.a.f;
        PersonInfoActivity.a(a, str2, str4);
    }
}
