package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.util.aj {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1206a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, Context context) {
        super(context);
        this.f1206a = jVar;
    }

    @Override // com.baidu.tieba.util.aj, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        str = this.f1206a.b;
        if (str != null) {
            str3 = this.f1206a.b;
            str4 = str3.replace("@", "").replace(" ", "");
        }
        Context a2 = a();
        str2 = this.f1206a.f;
        PersonInfoActivity.a(a2, str2, str4);
    }
}
