package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PbEditor extends LinearLayout {
    private static final Pattern f = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static final Pattern i = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    protected Context a;
    protected PbEditorToolView b;
    public EditorToolComponetContainer c;
    protected com.baidu.tbadk.editortool.x d;
    protected boolean e;
    private boolean g;
    private boolean h;

    public PbEditor(Context context) {
        super(context);
        this.h = false;
        this.e = true;
        this.a = context;
        u();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.e = true;
        this.a = context;
        u();
    }

    public void setFrom(int i2) {
        if (this.c != null) {
            this.c.setFrom(i2);
        }
    }

    public final void a() {
        this.b.d();
    }

    public final void b() {
        this.b.e();
    }

    public final boolean c() {
        Editable text = this.b.getEditText().getText();
        if ((text == null || text.length() <= 0) && !this.c.i()) {
            return this.c.j();
        }
        return true;
    }

    public EditText getEditText() {
        return this.b.getEditText();
    }

    public final void a(ArrayList<String> arrayList) {
        this.b.a(arrayList);
    }

    public String getContent() {
        return this.b.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.b.getEditText().setText(str);
    }

    public final void d() {
        this.b.getEditText().requestFocus();
        this.c.c(this.b.getEditText());
    }

    public final void e() {
        this.c.b();
        this.b.j();
    }

    public final void f() {
        this.c.b();
        this.b.j();
    }

    public final void g() {
        if (this.c.a() && !this.g) {
            this.g = true;
            Context context = this.a;
            t tVar = new t(this);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setAnimationListener(new ar(tVar, this));
            startAnimation(translateAnimation);
            return;
        }
        e();
    }

    public final boolean h() {
        return this.c.a();
    }

    private void u() {
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.pb_editor_view, (ViewGroup) this, true);
        this.b = (PbEditorToolView) findViewById(com.baidu.tieba.a.h.pb_editor_tool_button);
        this.c = (EditorToolComponetContainer) findViewById(com.baidu.tieba.a.h.pb_editor_tool_group);
    }

    public final boolean i() {
        return this.c.o();
    }

    public final void a(View view) {
        this.c.a(view);
    }

    public final void b(View view) {
        this.c.b(view);
    }

    public final void j() {
        this.b.getEditText().requestFocus();
        this.c.c(this.b.getEditText());
        this.b.getEditText().setSelection(this.b.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i2) {
        this.b.getEditText().requestFocus();
        this.c.b(this.b.getEditText());
        d(i2);
    }

    private void d(int i2) {
        if (i2 == 5) {
            this.c.f();
        } else if (i2 == 23 || i2 == 22) {
            this.c.g();
        } else if (i2 == 2) {
            this.c.e();
        } else if (i2 == 38) {
            this.c.d();
        } else if (i2 == 44) {
            this.c.h();
        }
    }

    public final void b(int i2) {
        if (this.c.a()) {
            d(i2);
            return;
        }
        this.e = false;
        if (this.c.o()) {
            this.c.b(this.b.getEditText());
        }
        new Handler().postDelayed(new u(this, i2), 200L);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.x xVar) {
        if (xVar != null) {
            this.d = xVar;
            this.b.setOnActionListener(new w(this, xVar));
            this.c.setOnActionListener(new x(this, xVar));
        }
    }

    public final void c(int i2) {
        this.b.a(i2);
        this.c.a(i2);
        if (this.a instanceof com.baidu.tbadk.a) {
            ((com.baidu.tbadk.a) this.a).getLayoutMode().a(i2 == 1);
            ((com.baidu.tbadk.a) this.a).getLayoutMode().a(this.b);
            ((com.baidu.tbadk.a) this.a).getLayoutMode().a(this.c);
        } else if (this.a instanceof com.baidu.tbadk.core.e) {
            ((com.baidu.tbadk.core.e) this.a).b().a(i2 == 1);
            ((com.baidu.tbadk.core.e) this.a).b().a(this.b);
            ((com.baidu.tbadk.core.e) this.a).b().a(this.c);
        }
    }

    public final void k() {
        this.b.a();
        this.c.l();
    }

    public final void l() {
        if (this.d != null) {
            this.d.a(33, null);
        }
        setVisibility(0);
    }

    public final void m() {
        if (this.d != null) {
            this.d.a(34, null);
        }
        this.b.j();
        this.c.b();
        b(getEditText());
        setVisibility(8);
    }

    public final boolean n() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.b.setMoreFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.b.setAudioFocusable(z);
    }

    public final void o() {
        this.b.c();
    }

    public final void p() {
        this.b.b();
    }

    public final void q() {
        this.c.m();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.c.getAudioData();
    }

    public final void r() {
        this.c.k();
    }

    public final void a(Bitmap bitmap) {
        this.c.setImage(bitmap);
    }

    public final void a(boolean z) {
        this.h = z;
        this.c.a(z);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public static int a(String str) {
        int i2 = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = i.matcher(str);
            while (matcher.find()) {
                if (com.baidu.tbadk.editortool.ab.a().a(matcher.group())) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public final void s() {
        if (this.h) {
            this.b.i();
            return;
        }
        if (TextUtils.isEmpty(TbadkApplication.j().aA()) && !this.h) {
            if (!this.c.i()) {
                this.b.i();
            }
        } else {
            this.b.h();
        }
        this.c.q();
    }
}
