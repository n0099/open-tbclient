package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.zeus.bouncycastle.DERTags;
/* loaded from: classes.dex */
public class f extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private Context f606a;
    private int b;
    private String c;

    public f(Context context, int i, String str) {
        this.f606a = null;
        this.b = 0;
        this.c = null;
        this.f606a = context;
        this.c = str;
        this.b = i;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        h hVar = null;
        if (this.f606a instanceof h) {
            hVar = (h) this.f606a;
        }
        if (hVar != null) {
            switch (this.b) {
                case 2:
                    hVar.b(this.f606a, this.c);
                    return;
                case 16:
                    hVar.a(this.f606a, this.c);
                    return;
                case 32:
                    hVar.c(this.f606a, this.c);
                    return;
                case DERTags.APPLICATION /* 64 */:
                    hVar.d(this.f606a, this.c);
                    return;
                case DERTags.TAGGED /* 128 */:
                    hVar.e(this.f606a, this.c);
                    return;
                default:
                    return;
            }
        }
    }
}
