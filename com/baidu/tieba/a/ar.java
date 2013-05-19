package com.baidu.tieba.a;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends ClickableSpan {
    final /* synthetic */ aq a;
    private String b;
    private String c;
    private Context d;

    public ar(aq aqVar, Context context, String str, String str2) {
        this.a = aqVar;
        this.b = null;
        this.c = null;
        this.d = null;
        this.b = str;
        this.c = str2;
        this.d = context;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(-9989158);
        textPaint.setUnderlineText(false);
        textPaint.setFakeBoldText(false);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.b != null && this.c != null && this.d != null) {
            PersonInfoActivity.a(this.d, this.c, this.b);
        }
    }
}
