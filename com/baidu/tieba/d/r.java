package com.baidu.tieba.d;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
public class r extends ClickableSpan {
    private Context a;

    public r(Context context) {
        this.a = null;
        this.a = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    public Context a() {
        return this.a;
    }

    public void a(String str) {
        ag.c(this.a, str);
    }

    public void b(String str) {
        NewPbActivity.a(this.a, str, null, null);
    }
}
