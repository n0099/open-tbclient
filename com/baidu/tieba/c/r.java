package com.baidu.tieba.c;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes.dex */
public class r extends ClickableSpan {
    private Context a;

    public r(Context context) {
        this.a = null;
        this.a = context;
    }

    public Context a() {
        return this.a;
    }

    public void a(String str) {
        ag.c(this.a, str);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }
}
