package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.util.l {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f fVar, Context context) {
        super(context);
        this.a = fVar;
    }

    @Override // com.baidu.tieba.util.l, android.text.style.ClickableSpan
    public void onClick(View view) {
        Pattern pattern;
        String str;
        Pattern pattern2;
        String str2;
        String str3;
        pattern = f.j;
        str = this.a.g;
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group();
                b(group.substring(group.lastIndexOf("/") + 1));
                return;
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "onClick", e.toString());
            }
        }
        pattern2 = f.k;
        str2 = this.a.g;
        Matcher matcher2 = pattern2.matcher(str2);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                b(group2.substring(group2.lastIndexOf("=") + 1));
                return;
            } catch (Exception e2) {
                BdLog.e(getClass().getName(), "onClick", e2.toString());
            }
        }
        str3 = this.a.g;
        a(str3);
    }
}
