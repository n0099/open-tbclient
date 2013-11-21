package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.bg;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.util.aj {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1205a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(j jVar, Context context) {
        super(context);
        this.f1205a = jVar;
    }

    @Override // com.baidu.tieba.util.aj, android.text.style.ClickableSpan
    public void onClick(View view) {
        Pattern pattern;
        String str;
        Pattern pattern2;
        String str2;
        String str3;
        pattern = j.i;
        str = this.f1205a.f;
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group();
                b(group.substring(group.lastIndexOf("/") + 1));
                return;
            } catch (Exception e) {
                bg.b(getClass().getName(), "onClick", e.toString());
            }
        }
        pattern2 = j.j;
        str2 = this.f1205a.f;
        Matcher matcher2 = pattern2.matcher(str2);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                b(group2.substring(group2.lastIndexOf("=") + 1));
                return;
            } catch (Exception e2) {
                bg.b(getClass().getName(), "onClick", e2.toString());
            }
        }
        str3 = this.f1205a.f;
        a(str3);
    }
}
