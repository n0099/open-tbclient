package com.baidu.tieba.a;

import android.content.Context;
import android.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.c.r {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k kVar, Context context) {
        super(context);
        this.a = kVar;
    }

    @Override // com.baidu.tieba.c.r, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        String str2;
        Pattern pattern = this.a.a;
        str = this.a.f;
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group();
                b(group.substring(group.lastIndexOf("/") + 1));
                return;
            } catch (Exception e) {
                com.baidu.tieba.c.af.b(getClass().getName(), "onClick", e.toString());
            }
        }
        str2 = this.a.f;
        a(str2);
    }
}
