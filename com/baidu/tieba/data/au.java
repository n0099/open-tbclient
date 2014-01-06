package com.baidu.tieba.data;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.person.PersonInfoActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends ClickableSpan {
    final /* synthetic */ as a;
    private String b;
    private String c;
    private Context d;

    public au(as asVar, Context context, String str, String str2) {
        this.a = asVar;
        this.b = null;
        this.c = null;
        this.d = null;
        this.b = str;
        this.c = str2;
        this.d = context;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.d != null) {
            if (TiebaApplication.g().an() == 1) {
                textPaint.setColor(this.d.getResources().getColor(R.color.common_link_text_1));
            } else {
                textPaint.setColor(this.d.getResources().getColor(R.color.common_link_text));
            }
        }
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
