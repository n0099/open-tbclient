package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class j extends a {
    protected Context a;
    protected EditorToolButton b;
    protected EditorToolButton c;
    protected EditorToolButton d;
    protected EditorToolButton e;
    protected TextView f;
    protected TextView g;

    public j(Context context) {
        super(context);
        this.a = context;
        d();
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        d();
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        d();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.e.getTip() != null) {
            TextView tip = this.e.getTip();
            int right = this.e.getRight() - com.baidu.adp.lib.h.g.a(this.a, 14.0f);
            int top = this.e.getTop() - com.baidu.adp.lib.h.g.a(this.a, 2.0f);
            this.e.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
    }

    protected void d() {
        e();
        this.b = (EditorToolButton) findViewById(R.id.select_face);
        this.c = (EditorToolButton) findViewById(R.id.select_at);
        this.d = (EditorToolButton) findViewById(R.id.select_image);
        this.e = (EditorToolButton) findViewById(R.id.select_audio);
    }

    protected void e() {
        LayoutInflater.from(this.a).inflate(R.layout.editor_tool_button_container, (ViewGroup) this, true);
    }

    public void setOnActionListener(h hVar) {
        if (hVar != null) {
            View.OnClickListener a = a(hVar);
            this.b.setOnClickListener(a);
            this.c.setOnClickListener(a);
            this.d.setOnClickListener(a);
            this.e.setOnClickListener(a);
        }
    }

    public void f() {
        this.b.h();
    }

    public void g() {
        this.d.h();
    }

    public void h() {
        this.e.h();
    }

    public void setFaceFocusable(boolean z) {
        this.b.setFocusable(z);
    }

    public void setAtFocusable(boolean z) {
        this.c.setFocusable(z);
    }

    public void setImageFocusable(boolean z) {
        this.d.setFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.e.setFocusable(z);
    }

    public void setFaceEnabled(boolean z) {
        this.b.setEnabled(z);
    }

    public void setAtEnabled(boolean z) {
        this.c.setEnabled(z);
    }

    public void setImageEnabled(boolean z) {
        this.d.setEnabled(z);
    }

    public void setAudioEnabled(boolean z) {
        this.e.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.e.setHardDisabled(z);
    }

    public void i() {
        if (this.f != null) {
            this.d.f();
        }
    }

    public void j() {
        if (this.g == null) {
            this.g = a(this.e, false);
        }
        this.e.e();
    }

    public void k() {
        this.e.f();
    }

    public void a(boolean z) {
        if (z) {
            this.b.a();
        } else {
            this.b.b();
        }
    }

    public void b(boolean z) {
        if (z) {
            this.c.a();
        } else {
            this.c.b();
        }
    }

    public void c(boolean z) {
        if (z) {
            this.d.a();
        } else {
            this.d.b();
        }
    }

    public void d(boolean z) {
        if (z) {
            this.e.a();
        } else {
            this.e.b();
        }
    }

    public void a(int i) {
        boolean z = i == 1;
        if (this.g != null) {
            TextView textView = this.g;
            if (z) {
            }
            textView.setBackgroundResource(R.drawable.icon_news_content_prompt_1);
        }
        if (this.f != null) {
            this.f.setBackgroundResource(z ? R.drawable.icon_new_tip_1 : R.drawable.icon_new_tip);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, h hVar) {
        if (editorToolButton == this.b) {
            hVar.a(1, null);
        } else if (editorToolButton == this.c) {
            hVar.a(0, null);
        } else if (editorToolButton == this.d) {
            hVar.a(7, null);
        } else if (editorToolButton == this.e) {
            hVar.a(4, null);
        }
        if (editorToolButton.g()) {
            if (editorToolButton.isFocused()) {
                c();
                if (editorToolButton == this.b) {
                    hVar.a(3, null);
                    return;
                } else if (editorToolButton == this.c) {
                    hVar.a(16, null);
                    return;
                } else if (editorToolButton == this.d) {
                    hVar.a(9, null);
                    return;
                } else if (editorToolButton == this.e) {
                    hVar.a(6, null);
                    return;
                } else {
                    return;
                }
            }
            c();
            editorToolButton.h();
            if (editorToolButton == this.b) {
                hVar.a(2, null);
            } else if (editorToolButton == this.c) {
                hVar.a(17, null);
            } else if (editorToolButton == this.d) {
                hVar.a(8, null);
            } else if (editorToolButton == this.e) {
                hVar.a(5, null);
            }
        }
    }

    protected View.OnClickListener a(h hVar) {
        return new k(this, hVar);
    }
}
