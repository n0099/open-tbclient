package com.baidu.tieba.a;

import android.content.Context;
import android.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.d.r {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k kVar, Context context) {
        super(context);
        this.a = kVar;
    }

    @Override // com.baidu.tieba.d.r, android.text.style.ClickableSpan
    public void onClick(View view) {
        Pattern pattern;
        String str;
        Pattern pattern2;
        String str2;
        String str3;
        pattern = k.h;
        str = this.a.f;
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group();
                b(group.substring(group.lastIndexOf("/") + 1));
                return;
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "onClick", e.toString());
            }
        }
        pattern2 = k.i;
        str2 = this.a.f;
        Matcher matcher2 = pattern2.matcher(str2);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                b(group2.substring(group2.lastIndexOf("=") + 1));
                return;
            } catch (Exception e2) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "onClick", e2.toString());
            }
        }
        str3 = this.a.f;
        a(str3);
    }
}
