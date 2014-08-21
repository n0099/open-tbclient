package com.baidu.tieba.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class aq extends i {
    protected Context a;
    protected EditorToolButton b;
    protected EditorToolButton c;
    protected EditorToolButton d;
    protected EditorToolButton e;
    protected EditorToolButton f;
    protected EditorToolButton g;
    protected TextView h;
    protected TextView i;
    protected TextView j;
    protected TextView k;

    public aq(Context context) {
        super(context);
        this.a = context;
        d();
    }

    public aq(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        d();
    }

    public aq(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        d();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.e.getTip() != null) {
            TextView tip = this.e.getTip();
            int right = this.e.getRight() - com.baidu.adp.lib.util.j.a(this.a, 14.0f);
            int top = this.e.getTop() - com.baidu.adp.lib.util.j.a(this.a, 2.0f);
            tip.layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.d.getTip() != null) {
            TextView tip2 = this.d.getTip();
            int right2 = this.d.getRight() - com.baidu.adp.lib.util.j.a(this.a, 14.0f);
            int top2 = this.d.getTop() - com.baidu.adp.lib.util.j.a(this.a, 2.0f);
            tip2.layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
        if (this.f.getTip() != null) {
            TextView tip3 = this.f.getTip();
            int right3 = this.f.getRight() - com.baidu.adp.lib.util.j.a(this.a, 14.0f);
            int top3 = this.f.getTop() - com.baidu.adp.lib.util.j.a(this.a, 2.0f);
            tip3.layout(right3, top3, tip3.getMeasuredWidth() + right3, tip3.getMeasuredHeight() + top3);
        }
        if (this.g.getTip() != null) {
            TextView tip4 = this.g.getTip();
            int right4 = this.g.getRight() - com.baidu.adp.lib.util.j.a(this.a, 14.0f);
            int top4 = this.g.getTop() - com.baidu.adp.lib.util.j.a(this.a, 2.0f);
            tip4.layout(right4, top4, tip4.getMeasuredWidth() + right4, tip4.getMeasuredHeight() + top4);
        }
    }

    protected void d() {
        e();
        this.b = (EditorToolButton) findViewById(com.baidu.tieba.u.select_face);
        this.c = (EditorToolButton) findViewById(com.baidu.tieba.u.select_at);
        this.d = (EditorToolButton) findViewById(com.baidu.tieba.u.select_image_albumn);
        this.e = (EditorToolButton) findViewById(com.baidu.tieba.u.select_audio);
        this.f = (EditorToolButton) findViewById(com.baidu.tieba.u.select_privilege);
        this.g = (EditorToolButton) findViewById(com.baidu.tieba.u.select_baobao);
    }

    protected void e() {
        com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.editor_tool_button_container, this, true);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            View.OnClickListener a = a(wVar);
            this.b.setOnClickListener(a);
            this.c.setOnClickListener(a);
            this.e.setOnClickListener(a);
            this.d.setOnClickListener(a);
            this.f.setOnClickListener(a);
            this.g.setOnClickListener(a);
        }
    }

    public void f() {
        c();
        this.b.h();
    }

    public void g() {
        c();
        this.e.h();
    }

    public void h() {
        c();
        this.d.h();
    }

    public void i() {
        c();
        this.f.h();
    }

    public void j() {
        this.d.i();
    }

    public void k() {
        this.g.i();
    }

    public void l() {
        c();
        this.g.h();
    }

    public void setFaceFocusable(boolean z) {
        this.b.setFocusable(z);
    }

    public void setAtFocusable(boolean z) {
        this.c.setFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.e.setFocusable(z);
    }

    public void setImageAlbumnFocusable(boolean z) {
        this.d.setFocusable(z);
    }

    public void setPrivilegeFocusable(boolean z) {
        this.f.setFocusable(z);
    }

    public void setBaobaoFocusable(boolean z) {
        this.g.setFocusable(z);
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

    public void setAudioEnabled(boolean z) {
        this.e.setEnabled(z);
    }

    public void setBaobaoEnabled(boolean z) {
        this.g.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.e.setHardDisabled(z);
    }

    public void setPrivilegeEnable(boolean z) {
        this.f.setEnabled(z);
    }

    public void setBaobaoEnable(boolean z) {
        this.g.setEnabled(z);
    }

    public void a(String str) {
        if (this.h == null) {
            this.h = a(this.d, true);
        }
        this.d.a(str);
    }

    public void m() {
        if (this.g != null) {
            this.g.setVisibility(8);
        }
    }

    public void n() {
        if (this.h != null) {
            this.d.f();
        }
    }

    public void o() {
        if (this.i == null) {
            this.i = a(this.e, false);
        }
        this.e.e();
    }

    public void p() {
        this.e.f();
    }

    public void q() {
        if (this.j == null) {
            this.j = a(this.f, false);
        }
        this.f.e();
    }

    public void r() {
        this.f.f();
    }

    public void b(String str) {
        if (this.k == null) {
            this.k = a(this.g, true);
        }
        this.g.a(str);
    }

    public void s() {
        this.g.f();
    }

    public void a(boolean z) {
        if (z) {
            this.e.a();
        } else {
            this.e.b();
        }
    }

    public void b(boolean z) {
        if (z) {
            this.f.a();
        } else {
            this.f.b();
        }
    }

    public void a(int i) {
        boolean z = i == 1;
        if (this.i != null) {
            this.i.setBackgroundResource(z ? com.baidu.tieba.t.icon_news_head_prompt_one_1 : com.baidu.tieba.t.icon_news_head_prompt_one);
        }
        if (this.h != null) {
            this.h.setBackgroundResource(z ? com.baidu.tieba.t.icon_news_head_prompt_one_1 : com.baidu.tieba.t.icon_news_head_prompt_one);
        }
        if (this.j != null) {
            this.j.setBackgroundResource(z ? com.baidu.tieba.t.icon_news_list_prompt_1 : com.baidu.tieba.t.icon_news_list_prompt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.w wVar) {
        if (editorToolButton == this.b) {
            wVar.a(1, null);
        } else if (editorToolButton == this.c) {
            wVar.a(0, null);
        } else if (editorToolButton == this.e) {
            wVar.a(4, null);
        } else if (editorToolButton == this.d) {
            wVar.a(23, null);
        } else if (editorToolButton == this.f) {
            wVar.a(43, null);
        } else if (editorToolButton == this.g) {
            wVar.a(48, null);
        }
        if (editorToolButton.g()) {
            if (editorToolButton.isFocused()) {
                c();
                if (editorToolButton == this.b) {
                    wVar.a(3, null);
                } else if (editorToolButton == this.c) {
                    wVar.a(16, null);
                } else if (editorToolButton == this.d) {
                    wVar.a(9, null);
                } else if (editorToolButton == this.e) {
                    wVar.a(6, null);
                } else if (editorToolButton == this.f) {
                    wVar.a(45, null);
                } else if (editorToolButton == this.g) {
                    wVar.a(49, null);
                }
            } else if (editorToolButton == this.b) {
                wVar.a(2, null);
            } else if (editorToolButton == this.c) {
                wVar.a(17, null);
            } else if (editorToolButton == this.d) {
                wVar.a(8, null);
            } else if (editorToolButton == this.e) {
                wVar.a(5, null);
            } else if (editorToolButton == this.f) {
                wVar.a(44, null);
            } else if (editorToolButton == this.g) {
                wVar.a(50, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.w wVar) {
        return new ar(this, wVar);
    }

    public void t() {
        if (TextUtils.isEmpty(TbadkApplication.m252getInst().getDefaultBubble())) {
            r();
        } else {
            q();
        }
    }
}
