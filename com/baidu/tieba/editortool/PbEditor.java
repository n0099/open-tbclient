package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.VoiceData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PbEditor extends LinearLayout {
    private static final Pattern g = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static final Pattern k = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    protected Context a;
    protected PbEditorToolView b;
    public EditorToolComponetContainer c;
    protected com.baidu.tbadk.editortool.w d;
    protected boolean e;
    private int f;
    private boolean h;
    private boolean i;
    private boolean j;

    public void setHideBaobao(boolean z) {
        this.j = z;
        if (this.c != null) {
            this.c.setHideBaobao(z);
        }
    }

    public EditorToolComponetContainer getEditorToolComponetContainer() {
        return this.c;
    }

    public PbEditor(Context context) {
        super(context);
        this.f = 1000;
        this.i = false;
        this.j = false;
        this.e = true;
        this.a = context;
        i();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 1000;
        this.i = false;
        this.j = false;
        this.e = true;
        this.a = context;
        i();
    }

    public void setFrom(int i) {
        if (this.c != null) {
            this.c.setFrom(i);
        }
    }

    public void a() {
        this.b.e();
    }

    public void b() {
        this.b.f();
    }

    public boolean c() {
        Editable text = this.b.getEditText().getText();
        if ((text != null && text.toString().trim().length() > 0) || this.c.x() || this.c.y()) {
            return true;
        }
        return this.c.z();
    }

    public EditText getEditText() {
        return this.b.getEditText();
    }

    public void a(ArrayList<String> arrayList) {
        this.b.a(arrayList);
    }

    public String getContent() {
        return this.b.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.b.getEditText().setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.b.getEditText().setSelection(str.length());
        }
    }

    public void d() {
        this.b.getEditText().requestFocus();
        this.c.c(this.b.getEditText());
    }

    public void e() {
        this.c.p();
        this.b.k();
    }

    public void f() {
        this.c.p();
        this.b.k();
    }

    public void g() {
        if (this.c.o() && !this.h) {
            this.h = true;
            as.a(this, this.a, new v(this));
            return;
        }
        e();
    }

    public boolean h() {
        return this.c.o();
    }

    protected void i() {
        com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.pb_editor_view, this, true);
        this.b = (PbEditorToolView) findViewById(com.baidu.tieba.u.pb_editor_tool_button);
        this.c = (EditorToolComponetContainer) findViewById(com.baidu.tieba.u.pb_editor_tool_group);
    }

    public boolean j() {
        return this.c.E();
    }

    public void a(View view) {
        this.c.a(view);
    }

    public void b(View view) {
        this.c.b(view);
    }

    public void k() {
        this.b.getEditText().requestFocus();
        this.c.c(this.b.getEditText());
        this.b.getEditText().setSelection(this.b.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, au auVar) {
        this.b.getEditText().requestFocus();
        this.c.b(this.b.getEditText());
        a(i);
    }

    protected void a(int i) {
        if (i == 5) {
            this.c.t();
        } else if (i == 23 || i == 22) {
            this.c.u();
        } else if (i == 2) {
            this.c.s();
        } else if (i == 38) {
            this.c.r();
        } else if (i == 44) {
            this.c.v();
        } else if (i == 50 || i == 48) {
            this.c.w();
        }
    }

    public void b(int i) {
        if (this.c.o()) {
            a(i);
            this.c.b(this.b.getEditText());
            return;
        }
        this.e = false;
        if (this.c.E()) {
            this.c.b(this.b.getEditText());
        }
        new Handler().postDelayed(new w(this, i), 200L);
    }

    public boolean l() {
        Editable text = this.b.getEditText().getText();
        return (text == null ? 0 : text.length()) >= this.f;
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.d = wVar;
            this.b.setOnActionListener(new y(this, wVar));
            this.c.setOnActionListener(new z(this, wVar));
        }
    }

    public void c(int i) {
        if (this.a instanceof BaseActivity) {
            ((BaseActivity) this.a).getLayoutMode().a(i == 1);
            ((BaseActivity) this.a).getLayoutMode().a((View) this.b);
            ((BaseActivity) this.a).getLayoutMode().a((View) this.c);
        } else if (this.a instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.a).c().a(i == 1);
            ((BaseFragmentActivity) this.a).c().a((View) this.b);
            ((BaseFragmentActivity) this.a).c().a((View) this.c);
        }
        this.b.a(i);
        this.c.a(i);
    }

    public void m() {
        this.b.b();
        this.c.B();
    }

    public void n() {
        if (this.d != null) {
            this.d.a(33, null);
        }
        setVisibility(0);
    }

    public void o() {
        if (this.d != null) {
            this.d.a(34, null);
        }
        this.b.k();
        this.c.p();
        b(getEditText());
        setVisibility(8);
    }

    public boolean p() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.b.setMoreFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.b.setAudioFocusable(z);
    }

    public void q() {
        this.b.d();
    }

    public void r() {
        this.b.c();
    }

    public void s() {
        this.c.C();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.c.getAudioData();
    }

    public void t() {
        this.c.A();
    }

    public void a(Bitmap bitmap) {
        this.c.setImage(bitmap);
    }

    public void a(boolean z) {
        this.i = z;
        this.c.a(z);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public static int a(String str) {
        int i = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = k.matcher(str);
            while (matcher.find()) {
                if (com.baidu.tbadk.editortool.aa.a().a(matcher.group())) {
                    i++;
                }
            }
        }
        return i;
    }

    public void u() {
        if (this.i) {
            this.b.j();
            return;
        }
        if (TextUtils.isEmpty(TbadkApplication.m252getInst().getDefaultBubble()) && !this.i) {
            if (!this.c.x() && !this.c.y()) {
                this.b.j();
            } else {
                this.b.i();
            }
        } else {
            this.b.i();
        }
        this.c.G();
    }

    public void setMaxTextCount(int i) {
        this.f = i;
    }
}
