package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.zeus.bouncycastle.DERTags;
/* loaded from: classes.dex */
public class f extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private Context f808a;
    private int b;
    private String c;
    private String d;

    public f(Context context, int i, String str) {
        this.f808a = null;
        this.b = 0;
        this.c = null;
        this.f808a = context;
        this.c = str;
        this.b = i;
    }

    public void a(String str) {
        this.d = str;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        h hVar = null;
        if (this.f808a instanceof h) {
            hVar = (h) this.f808a;
        }
        if (hVar != null) {
            switch (this.b) {
                case 2:
                    hVar.b(this.f808a, this.c);
                    return;
                case 16:
                    hVar.a(this.f808a, this.c);
                    return;
                case 32:
                    hVar.c(this.f808a, this.c);
                    return;
                case 64:
                    hVar.d(this.f808a, this.c);
                    return;
                case DERTags.TAGGED /* 128 */:
                    hVar.e(this.f808a, this.c);
                    return;
                case 256:
                    hVar.a(this.f808a, this.c, this.d);
                    return;
                default:
                    return;
            }
        }
    }
}
