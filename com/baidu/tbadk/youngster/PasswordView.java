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
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class PasswordView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public EditText f14069e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f14070f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f14071g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f14072h;
    public EditText i;
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
            if (PasswordView.this.i != null) {
                l.J(PasswordView.this.getContext(), PasswordView.this.i);
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
        public final /* synthetic */ ImageView f14076e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f14077f;

        public d(ImageView imageView, EditText editText) {
            this.f14076e = imageView;
            this.f14077f = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                this.f14076e.setVisibility(0);
                PasswordView.this.r(this.f14077f);
                this.f14077f.requestFocus();
                PasswordView.this.i = this.f14077f;
                return;
            }
            this.f14076e.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f14079e;

        public e(ImageView imageView) {
            this.f14079e = imageView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                this.f14079e.setVisibility(0);
                d.b.c.e.m.e.a().post(PasswordView.this.t);
                return;
            }
            this.f14079e.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnKeyListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditText f14081e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f14082f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImageView f14083g;

        public f(EditText editText, EditText editText2, ImageView imageView) {
            this.f14081e = editText;
            this.f14082f = editText2;
            this.f14083g = imageView;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 67 && keyEvent.getAction() == 0) {
                if (this.f14081e.getText().length() > 0) {
                    this.f14081e.getText().clear();
                } else {
                    this.f14082f.getText().clear();
                }
                this.f14083g.setVisibility(8);
                PasswordView.this.r(this.f14082f);
                this.f14082f.requestFocus();
                PasswordView.this.i = this.f14082f;
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
        gradientDrawable.setStroke(l.g(getContext(), R.dimen.tbds3), d.b.i0.d3.c.a(SkinManager.getColor(R.color.CAM_X0105), 0.16f));
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
        l.w(getContext(), this.f14069e);
    }

    public final void g() {
        RelativeLayout.inflate(getContext(), R.layout.view_password, this);
        this.f14069e = (EditText) findViewById(R.id.edit_password_a);
        this.f14070f = (EditText) findViewById(R.id.edit_password_b);
        this.f14071g = (EditText) findViewById(R.id.edit_password_c);
        this.f14072h = (EditText) findViewById(R.id.edit_password_d);
        this.o.add(this.f14069e);
        this.o.add(this.f14070f);
        this.o.add(this.f14071g);
        this.o.add(this.f14072h);
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
        r(this.f14069e);
        this.f14069e.requestFocus();
        this.i = this.f14069e;
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
        int i;
        int size = this.o.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            int i3 = i2 + 1;
            p(this.o.get(i2), this.o.get(i3), this.p.get(i2));
            i2 = i3;
        }
        if (i >= 0) {
            o(this.o.get(i), this.p.get(i));
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
        d.b.c.e.m.e.a().removeCallbacks(this.s);
        d.b.c.e.m.e.a().removeCallbacks(this.t);
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
        d.b.c.e.m.e.a().removeCallbacks(this.s);
        d.b.c.e.m.e.a().postDelayed(this.s, 300L);
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

    public PasswordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new HashMap();
        this.s = new a();
        this.t = new b();
        g();
    }
}
