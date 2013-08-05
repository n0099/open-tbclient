package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.util.s {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1017a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, Context context) {
        super(context);
        this.f1017a = iVar;
    }

    @Override // com.baidu.tieba.util.s, android.text.style.ClickableSpan
    public void onClick(View view) {
        Pattern pattern;
        String str;
        Pattern pattern2;
        String str2;
        String str3;
        pattern = i.h;
        str = this.f1017a.f;
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group();
                b(group.substring(group.lastIndexOf("/") + 1));
                return;
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "onClick", e.toString());
            }
        }
        pattern2 = i.i;
        str2 = this.f1017a.f;
        Matcher matcher2 = pattern2.matcher(str2);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                b(group2.substring(group2.lastIndexOf("=") + 1));
                return;
            } catch (Exception e2) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "onClick", e2.toString());
            }
        }
        str3 = this.f1017a.f;
        a(str3);
    }
}
