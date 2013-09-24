package com.baidu.tieba;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class c implements LayoutInflater.Factory {

    /* renamed from: a  reason: collision with root package name */
    private e f950a;

    public void a(e eVar) {
        this.f950a = eVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.f950a == null) {
            this.f950a = new e();
        }
        this.f950a.a(str, context, attributeSet);
        return null;
    }
}
