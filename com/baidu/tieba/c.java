package com.baidu.tieba;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public final class c implements LayoutInflater.Factory {
    private e a;

    public final void a(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.a == null) {
            this.a = new e();
        }
        this.a.a(str, context, attributeSet);
        return null;
    }
}
