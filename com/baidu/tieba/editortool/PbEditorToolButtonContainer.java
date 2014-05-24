package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/* loaded from: classes.dex */
public class PbEditorToolButtonContainer extends g {
    protected Context a;
    protected EditorToolButton b;
    protected EditorToolButton c;
    protected TextView d;
    protected TextView e;

    public PbEditorToolButtonContainer(Context context) {
        super(context);
        this.a = context;
        e();
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        e();
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        e();
    }

    protected void d() {
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.pb_editor_tool_button_container, (ViewGroup) this, true);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.b.getTip() != null) {
            TextView tip = this.b.getTip();
            int right = this.b.getRight() - com.baidu.adp.lib.util.k.a(this.a, 18.0f);
            int top = this.b.getTop() - com.baidu.adp.lib.util.k.a(this.a, 2.0f);
            this.b.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.c.getTip() != null) {
            TextView tip2 = this.c.getTip();
            int right2 = this.c.getRight() - com.baidu.adp.lib.util.k.a(this.a, 18.0f);
            int top2 = this.c.getTop() - com.baidu.adp.lib.util.k.a(this.a, 2.0f);
            this.c.getTip().layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
    }

    protected void e() {
        d();
        this.c = (EditorToolButton) findViewById(com.baidu.tieba.v.tool_more);
        this.b = (EditorToolButton) findViewById(com.baidu.tieba.v.tool_audio);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.x xVar) {
        if (xVar != null) {
            View.OnClickListener a = a(xVar);
            this.c.setOnClickListener(a);
            this.b.setOnClickListener(a);
        }
    }

    public void setMoreFocusable(boolean z) {
        this.c.setFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.b.setFocusable(z);
    }

    public void setMoreEnabled(boolean z) {
        this.c.setEnabled(z);
    }

    public void setAudioEnabled(boolean z) {
        this.b.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.b.setHardDisabled(z);
    }

    public void f() {
        if (this.d == null) {
            this.d = a(this.b, false);
        }
        this.b.e();
    }

    public void g() {
        this.b.f();
    }

    public void h() {
        if (this.e == null) {
            this.e = a(this.c, false);
        }
        this.c.e();
    }

    public void i() {
        this.c.f();
    }

    public void a(boolean z) {
        if (z) {
            this.b.a();
        } else {
            this.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.x xVar) {
        if (editorToolButton == this.c) {
            xVar.a(37, null);
        } else if (editorToolButton == this.b) {
            xVar.a(4, null);
        }
        if (editorToolButton.g() && !editorToolButton.isFocused()) {
            c();
            editorToolButton.h();
            if (editorToolButton == this.c) {
                xVar.a(38, null);
            } else if (editorToolButton == this.b) {
                xVar.a(5, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.x xVar) {
        return new y(this, xVar);
    }
}
