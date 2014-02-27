package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ab extends a {
    protected Context a;
    protected EditorToolButton b;
    protected EditorToolButton c;
    protected EditorToolButton d;
    protected EditorToolButton e;
    protected EditorToolButton f;
    protected TextView g;
    protected TextView h;

    public ab(Context context) {
        super(context);
        this.a = context;
        j();
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        j();
    }

    public ab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        j();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f.getTip() != null) {
            TextView tip = this.f.getTip();
            int right = this.f.getRight() - BdUtilHelper.a(this.a, 14.0f);
            int top = this.f.getTop() - BdUtilHelper.a(this.a, 2.0f);
            tip.layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.d.getTip() != null) {
            TextView tip2 = this.d.getTip();
            int right2 = this.d.getRight() - BdUtilHelper.a(this.a, 14.0f);
            int top2 = this.d.getTop() - BdUtilHelper.a(this.a, 2.0f);
            tip2.layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
    }

    private void j() {
        d();
        this.b = (EditorToolButton) findViewById(R.id.select_face);
        this.c = (EditorToolButton) findViewById(R.id.select_at);
        this.d = (EditorToolButton) findViewById(R.id.select_image_albumn);
        this.e = (EditorToolButton) findViewById(R.id.select_image);
        this.f = (EditorToolButton) findViewById(R.id.select_audio);
    }

    protected void d() {
        LayoutInflater.from(this.a).inflate(R.layout.editor_tool_button_container, (ViewGroup) this, true);
    }

    public void setOnActionListener(aa aaVar) {
        if (aaVar != null) {
            ac acVar = new ac(this, aaVar);
            this.b.setOnClickListener(acVar);
            this.c.setOnClickListener(acVar);
            this.e.setOnClickListener(acVar);
            this.f.setOnClickListener(acVar);
            this.d.setOnClickListener(acVar);
        }
    }

    public final void e() {
        c();
        this.d.h();
    }

    public final void f() {
        this.d.i();
    }

    public void setFaceFocusable(boolean z) {
        this.b.setFocusable(z);
    }

    public void setAtFocusable(boolean z) {
        this.c.setFocusable(z);
    }

    public void setImageCameraFocusable(boolean z) {
        this.e.setFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.f.setFocusable(z);
    }

    public void setImageAlbumnFocusable(boolean z) {
        this.d.setFocusable(z);
    }

    public void setFaceEnabled(boolean z) {
        this.b.setEnabled(z);
    }

    public void setAtEnabled(boolean z) {
        this.c.setEnabled(z);
    }

    public void setImageAlbumnEnabled(boolean z) {
        this.d.setEnabled(z);
    }

    public void setImageCameraEnabled(boolean z) {
        this.e.setEnabled(z);
    }

    public void setAudioEnabled(boolean z) {
        this.f.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.f.setHardDisabled(z);
    }

    public final void a(String str) {
        if (this.g == null) {
            this.g = a(this.d, true);
        }
        this.d.a(str);
    }

    public final void g() {
        if (this.g != null) {
            this.d.f();
        }
    }

    public final void h() {
        if (this.h == null) {
            this.h = a(this.f, false);
        }
        this.f.e();
    }

    public final void i() {
        this.f.f();
    }

    public final void a(boolean z) {
        if (z) {
            this.f.a();
        } else {
            this.f.b();
        }
    }

    public final void a(int i) {
        int i2 = R.drawable.icon_news_head_prompt_one_1;
        boolean z = i == 1;
        if (this.h != null) {
            this.h.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
        }
        if (this.g != null) {
            TextView textView = this.g;
            if (!z) {
                i2 = R.drawable.icon_news_head_prompt_one;
            }
            textView.setBackgroundResource(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(EditorToolButton editorToolButton, aa aaVar) {
        if (editorToolButton == this.b) {
            aaVar.a(1, null);
        } else if (editorToolButton == this.c) {
            aaVar.a(0, null);
        } else if (editorToolButton == this.e) {
            aaVar.a(22, null);
        } else if (editorToolButton == this.f) {
            aaVar.a(4, null);
        } else if (editorToolButton == this.d) {
            aaVar.a(23, null);
        }
        if (editorToolButton.g()) {
            if (editorToolButton.isFocused()) {
                c();
                if (editorToolButton == this.b) {
                    aaVar.a(3, null);
                    return;
                } else if (editorToolButton == this.c) {
                    aaVar.a(16, null);
                    return;
                } else if (editorToolButton == this.d) {
                    aaVar.a(9, null);
                    return;
                } else if (editorToolButton == this.f) {
                    aaVar.a(6, null);
                    return;
                } else {
                    return;
                }
            }
            if (editorToolButton != this.e) {
                c();
                editorToolButton.h();
            }
            if (editorToolButton == this.b) {
                aaVar.a(2, null);
            } else if (editorToolButton == this.c) {
                aaVar.a(17, null);
            } else if (editorToolButton == this.d) {
                aaVar.a(8, null);
            } else if (editorToolButton == this.f) {
                aaVar.a(5, null);
            }
        }
    }
}
