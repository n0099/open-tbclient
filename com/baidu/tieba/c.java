package com.baidu.tieba;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class c implements LayoutInflater.Factory {

    /* renamed from: a  reason: collision with root package name */
    private e f1120a;

    public void a(e eVar) {
        this.f1120a = eVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.f1120a == null) {
            this.f1120a = new e();
        }
        this.f1120a.a(str, context, attributeSet);
        return null;
    }
}
