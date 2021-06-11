package com.baidu.tbadk.youngster;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class PasswordView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public EditText f13432e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f13433f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f13434g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f13435h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f13436i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public FrameLayout n;
    public List<EditText> o;
    public List<ImageView> p;
    public g q;
    public Map<EditText, List<TextWatcher>> r;
    public Runnable s;
    public Runnable t;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PasswordView.this.f13436i != null) {
                l.K(PasswordView.this.getContext(), PasswordView.this.f13436i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = PasswordView.this.q;
            if (gVar != null) {
                gVar.onComplete();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PasswordView.this.q();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f13440e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f13441f;

        public d(ImageView imageView, EditText editText) {
            this.f13440e = imageView;
            this.f13441f = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                this.f13440e.setVisibility(0);
                PasswordView.this.r(this.f13441f);
                this.f13441f.requestFocus();
                PasswordView.this.f13436i = this.f13441f;
                return;
            }
            this.f13440e.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f13443e;

        public e(ImageView imageView) {
            this.f13443e = imageView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                this.f13443e.setVisibility(0);
                d.a.c.e.m.e.a().post(PasswordView.this.t);
                return;
            }
            this.f13443e.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnKeyListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditText f13445e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f13446f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImageView f13447g;

        public f(EditText editText, EditText editText2, ImageView imageView) {
            this.f13445e = editText;
            this.f13446f = editText2;
            this.f13447g = imageView;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 == 67 && keyEvent.getAction() == 0) {
                if (this.f13445e.getText().length() > 0) {
                    this.f13445e.getText().clear();
                } else {
                    this.f13446f.getText().clear();
                }
                this.f13447g.setVisibility(8);
                PasswordView.this.r(this.f13446f);
                this.f13446f.requestFocus();
                PasswordView.this.f13436i = this.f13446f;
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void onComplete();
    }

    public PasswordView(Context context) {
        this(context, null);
    }

    private Drawable getEditBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(l.g(getContext(), R.dimen.tbds3), d.a.n0.e3.c.a(SkinManager.getColor(R.color.CAM_X0105), 0.16f));
        return gradientDrawable;
    }

    private Drawable getEditDotDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0107));
        return gradientDrawable;
    }

    private void setEditBackgroundDrawable(EditText editText) {
        editText.setBackgroundDrawable(getEditBackgroundDrawable());
    }

    private void setEditDotDrawable(ImageView imageView) {
        imageView.setImageDrawable(getEditDotDrawable());
    }

    public void e() {
        for (EditText editText : this.o) {
            editText.getText().clear();
        }
        h();
        i();
    }

    public void f() {
        l.x(getContext(), this.f13432e);
    }

    public final void g() {
        RelativeLayout.inflate(getContext(), R.layout.view_password, this);
        this.f13432e = (EditText) findViewById(R.id.edit_password_a);
        this.f13433f = (EditText) findViewById(R.id.edit_password_b);
        this.f13434g = (EditText) findViewById(R.id.edit_password_c);
        this.f13435h = (EditText) findViewById(R.id.edit_password_d);
        this.o.add(this.f13432e);
        this.o.add(this.f13433f);
        this.o.add(this.f13434g);
        this.o.add(this.f13435h);
        this.j = (ImageView) findViewById(R.id.edit_dot_a);
        this.k = (ImageView) findViewById(R.id.edit_dot_b);
        this.l = (ImageView) findViewById(R.id.edit_dot_c);
        this.m = (ImageView) findViewById(R.id.edit_dot_d);
        this.p.add(this.j);
        this.p.add(this.k);
        this.p.add(this.l);
        this.p.add(this.m);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.password_click);
        this.n = frameLayout;
        frameLayout.setOnClickListener(new c());
        n();
        l();
        i();
        h();
        j();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.o) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public final void h() {
        r(this.f13432e);
        this.f13432e.requestFocus();
        this.f13436i = this.f13432e;
    }

    public final void i() {
        for (ImageView imageView : this.p) {
            imageView.setVisibility(8);
        }
    }

    public void j() {
        for (EditText editText : this.o) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.p) {
            setEditDotDrawable(imageView);
        }
    }

    public final void k() {
        for (EditText editText : this.o) {
            for (TextWatcher textWatcher : this.r.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    public final void l() {
        for (int size = this.o.size() - 1; size > 0; size--) {
            m(this.o.get(size), this.o.get(size - 1), this.p.get(size));
        }
    }

    public final void m(EditText editText, EditText editText2, ImageView imageView) {
        editText.setOnKeyListener(new f(editText, editText2, imageView));
    }

    public final void n() {
        int i2;
        int size = this.o.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            int i4 = i3 + 1;
            p(this.o.get(i3), this.o.get(i4), this.p.get(i3));
            i3 = i4;
        }
        if (i2 >= 0) {
            o(this.o.get(i2), this.p.get(i2));
        }
    }

    public final void o(EditText editText, ImageView imageView) {
        e eVar = new e(imageView);
        editText.addTextChangedListener(eVar);
        List<TextWatcher> list = this.r.get(editText);
        if (ListUtils.isEmpty(list)) {
            list = new ArrayList<>();
            this.r.put(editText, list);
        }
        list.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.a.c.e.m.e.a().removeCallbacks(this.s);
        d.a.c.e.m.e.a().removeCallbacks(this.t);
        k();
    }

    public final void p(EditText editText, EditText editText2, ImageView imageView) {
        d dVar = new d(imageView, editText2);
        editText.addTextChangedListener(dVar);
        List<TextWatcher> list = this.r.get(editText);
        if (ListUtils.isEmpty(list)) {
            list = new ArrayList<>();
            this.r.put(editText, list);
        }
        list.add(dVar);
    }

    public void q() {
        d.a.c.e.m.e.a().removeCallbacks(this.s);
        d.a.c.e.m.e.a().postDelayed(this.s, 300L);
    }

    public final void r(EditText editText) {
        if (editText == null) {
            return;
        }
        for (EditText editText2 : this.o) {
            editText2.setFocusableInTouchMode(false);
        }
        editText.setFocusableInTouchMode(true);
    }

    public void setOnPasswordInputComplete(g gVar) {
        this.q = gVar;
    }

    public PasswordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PasswordView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new HashMap();
        this.s = new a();
        this.t = new b();
        g();
    }
}
