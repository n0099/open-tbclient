package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.util.ao {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k kVar, Context context) {
        super(context);
        this.a = kVar;
    }

    @Override // com.baidu.tieba.util.ao, android.text.style.ClickableSpan
    public void onClick(View view) {
        Pattern pattern;
        String str;
        Pattern pattern2;
        String str2;
        String str3;
        pattern = k.j;
        str = this.a.g;
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group();
                b(group.substring(group.lastIndexOf("/") + 1));
                return;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onClick", e.toString());
            }
        }
        pattern2 = k.k;
        str2 = this.a.g;
        Matcher matcher2 = pattern2.matcher(str2);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                b(group2.substring(group2.lastIndexOf("=") + 1));
                return;
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onClick", e2.toString());
            }
        }
        str3 = this.a.g;
        a(str3);
    }
}
