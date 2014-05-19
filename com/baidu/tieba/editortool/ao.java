package com.baidu.tieba.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class ao extends g {
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

    public ao(Context context) {
        super(context);
        this.a = context;
        d();
    }

    public ao(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        d();
    }

    public ao(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        d();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f.getTip() != null) {
            TextView tip = this.f.getTip();
            int right = this.f.getRight() - com.baidu.adp.lib.util.h.a(this.a, 14.0f);
            int top = this.f.getTop() - com.baidu.adp.lib.util.h.a(this.a, 2.0f);
            tip.layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.d.getTip() != null) {
            TextView tip2 = this.d.getTip();
            int right2 = this.d.getRight() - com.baidu.adp.lib.util.h.a(this.a, 14.0f);
            int top2 = this.d.getTop() - com.baidu.adp.lib.util.h.a(this.a, 2.0f);
            tip2.layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
        if (this.g.getTip() != null) {
            TextView tip3 = this.g.getTip();
            int right3 = this.g.getRight() - com.baidu.adp.lib.util.h.a(this.a, 14.0f);
            int top3 = this.g.getTop() - com.baidu.adp.lib.util.h.a(this.a, 2.0f);
            tip3.layout(right3, top3, tip3.getMeasuredWidth() + right3, tip3.getMeasuredHeight() + top3);
        }
    }

    protected void d() {
        e();
        this.b = (EditorToolButton) findViewById(com.baidu.tieba.r.select_face);
        this.c = (EditorToolButton) findViewById(com.baidu.tieba.r.select_at);
        this.d = (EditorToolButton) findViewById(com.baidu.tieba.r.select_image_albumn);
        this.e = (EditorToolButton) findViewById(com.baidu.tieba.r.select_image);
        this.f = (EditorToolButton) findViewById(com.baidu.tieba.r.select_audio);
        this.g = (EditorToolButton) findViewById(com.baidu.tieba.r.select_privilege);
    }

    protected void e() {
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.editor_tool_button_container, (ViewGroup) this, true);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.x xVar) {
        if (xVar != null) {
            View.OnClickListener a = a(xVar);
            this.b.setOnClickListener(a);
            this.c.setOnClickListener(a);
            this.e.setOnClickListener(a);
            this.f.setOnClickListener(a);
            this.d.setOnClickListener(a);
            this.g.setOnClickListener(a);
        }
    }

    public void f() {
        c();
        this.d.h();
    }

    public void g() {
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

    public void setPrivilegeFocusable(boolean z) {
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

    public void setImageCameraEnabled(boolean z) {
        this.e.setEnabled(z);
    }

    public void setAudioEnabled(boolean z) {
        this.f.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.f.setHardDisabled(z);
    }

    public void setPrivilegeEnable(boolean z) {
        this.g.setEnabled(z);
    }

    public void a(String str) {
        if (this.h == null) {
            this.h = a(this.d, true);
        }
        this.d.a(str);
    }

    public void h() {
        if (this.h != null) {
            this.d.f();
        }
    }

    public void i() {
        if (this.i == null) {
            this.i = a(this.f, false);
        }
        this.f.e();
    }

    public void j() {
        this.f.f();
    }

    public void k() {
        if (this.j == null) {
            this.j = a(this.g, false);
        }
        this.g.e();
    }

    public void l() {
        this.g.f();
    }

    public void a(boolean z) {
        if (z) {
            this.f.a();
        } else {
            this.f.b();
        }
    }

    public void b(boolean z) {
        if (z) {
            this.g.a();
        } else {
            this.g.b();
        }
    }

    public void a(int i) {
        boolean z = i == 1;
        if (this.i != null) {
            this.i.setBackgroundResource(z ? com.baidu.tieba.q.icon_news_head_prompt_one_1 : com.baidu.tieba.q.icon_news_head_prompt_one);
        }
        if (this.h != null) {
            this.h.setBackgroundResource(z ? com.baidu.tieba.q.icon_news_head_prompt_one_1 : com.baidu.tieba.q.icon_news_head_prompt_one);
        }
        if (this.j != null) {
            this.j.setBackgroundResource(z ? com.baidu.tieba.q.icon_news_list_prompt_1 : com.baidu.tieba.q.icon_news_list_prompt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.x xVar) {
        if (editorToolButton == this.b) {
            xVar.a(1, null);
        } else if (editorToolButton == this.c) {
            xVar.a(0, null);
        } else if (editorToolButton == this.e) {
            xVar.a(22, null);
        } else if (editorToolButton == this.f) {
            xVar.a(4, null);
        } else if (editorToolButton == this.d) {
            xVar.a(23, null);
        } else if (editorToolButton == this.g) {
            BdLog.d("Privilege click");
            xVar.a(43, null);
        }
        if (editorToolButton.g()) {
            if (editorToolButton.isFocused()) {
                c();
                if (editorToolButton == this.b) {
                    xVar.a(3, null);
                    return;
                } else if (editorToolButton == this.c) {
                    xVar.a(16, null);
                    return;
                } else if (editorToolButton == this.d) {
                    xVar.a(9, null);
                    return;
                } else if (editorToolButton == this.f) {
                    xVar.a(6, null);
                    return;
                } else if (editorToolButton == this.g) {
                    BdLog.d("Privilege blur");
                    xVar.a(45, null);
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
                xVar.a(2, null);
            } else if (editorToolButton == this.c) {
                xVar.a(17, null);
            } else if (editorToolButton == this.d) {
                xVar.a(8, null);
            } else if (editorToolButton == this.f) {
                xVar.a(5, null);
            } else if (editorToolButton == this.g) {
                BdLog.d("Privilege focus");
                xVar.a(44, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.x xVar) {
        return new ap(this, xVar);
    }

    public void m() {
        if (TextUtils.isEmpty(TbadkApplication.m252getInst().getDefaultBubble())) {
            l();
        } else {
            k();
        }
    }
}
