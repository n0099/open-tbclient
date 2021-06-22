package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.a.n0.r.u.c;
import d.a.n0.w.a;
import d.a.n0.w.h;
import d.a.n0.w.m;
/* loaded from: classes3.dex */
public class DLauncher extends RelativeLayout implements h {

    /* renamed from: e  reason: collision with root package name */
    public int f12879e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12880f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12881g;

    /* renamed from: h  reason: collision with root package name */
    public int f12882h;

    /* renamed from: i  reason: collision with root package name */
    public String f12883i;
    public m j;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.f12882h = 0;
        if (mVar == null) {
            return;
        }
        this.j = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f12880f = new EMTextView(context);
        setName(mVar.f54632b);
        setIcon();
        setToolId(mVar.f54633c);
        this.f12880f.setGravity(17);
        c d2 = c.d(this.f12880f);
        d2.w(R.dimen.T_X09);
        d2.s(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.ds12);
        addView(this.f12880f, layoutParams);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f12883i = str;
        if (this.f12881g == null) {
            TextView textView = new TextView(getContext());
            this.f12881g = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f12881g, R.color.common_color_10225, 1, this.f12882h);
        this.f12881g.setGravity(17);
        if (!str.equals(" ")) {
            this.f12881g.setTextSize(1, 10.0f);
            this.f12881g.setText(str);
            SkinManager.setBackgroundResource(this.f12881g, R.drawable.icon_news_head_prompt_one, this.f12882h);
            return;
        }
        this.f12881g.setWidth(0);
        this.f12881g.setHeight(0);
        this.f12881g.setText("");
        SkinManager.setBackgroundResource(this.f12881g, R.drawable.icon_news_down_bar_one, this.f12882h);
    }

    @Override // d.a.n0.w.h
    public void b() {
        setVisibility(0);
    }

    public void c(String str) {
        a(str);
        this.f12881g.setVisibility(0);
    }

    @Override // d.a.n0.w.h
    public void e() {
    }

    public void f() {
        this.f12883i = null;
        TextView textView = this.f12881g;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public String getText() {
        return this.f12883i;
    }

    @Override // d.a.n0.w.h
    public int getToolId() {
        return this.f12879e;
    }

    @Override // d.a.n0.w.h
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.n0.w.b
    public void onAction(a aVar) {
        if (aVar == null || aVar.f54625a != 2) {
            return;
        }
        Object obj = aVar.f54627c;
        if (obj == null) {
            f();
        } else if (obj instanceof String) {
            c((String) obj);
        }
    }

    @Override // d.a.n0.w.h
    public void onChangeSkinType(int i2) {
        this.f12882h = i2;
        if (isEnabled()) {
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i2);
        }
        c.d(this.f12880f).s(R.color.CAM_X0106);
        if (this.j == null) {
            return;
        }
        setIcon();
        TextView textView = this.f12881g;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i2);
            if (!TextUtils.isEmpty(this.f12881g.getText())) {
                SkinManager.setBackgroundResource(this.f12881g, R.drawable.icon_news_head_prompt_one, i2);
            } else {
                SkinManager.setBackgroundResource(this.f12881g, R.drawable.icon_news_down_bar_one, i2);
            }
            this.f12881g.setPadding(0, 0, 0, 0);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f12881g != null) {
            if (getVisibility() == 0) {
                int right = this.f12880f.getRight() - (this.f12881g.getMeasuredWidth() / 2);
                int top = this.f12880f.getTop() - (this.f12881g.getMeasuredHeight() / 2);
                this.f12881g.layout(right, top, this.f12881g.getMeasuredWidth() + right, this.f12881g.getMeasuredHeight() + top);
                return;
            }
            this.f12881g.layout(0, 0, 0, 0);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.f12880f.setAlpha(1.0f);
            this.f12880f.setEnabled(z);
            setPressed(true);
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
        } else {
            this.f12880f.setAlpha(0.33f);
            this.f12880f.setEnabled(false);
            setPressed(false);
            setBackground(null);
        }
        requestLayout();
    }

    public void setIcon() {
        Drawable drawable;
        m mVar = this.j;
        int i2 = mVar.f54636f;
        if (i2 <= 0) {
            i2 = mVar.f54634d;
        }
        if (TextUtils.isEmpty(this.f12880f.getText())) {
            if (this.j.f54637g) {
                this.f12880f.setBackgroundDrawable(SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.j.f54635e, this.f12882h));
                return;
            } else {
                SkinManager.setBackgroundResource(this.f12880f, i2, this.f12882h);
                return;
            }
        }
        if (this.j.f54637g) {
            drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.j.f54635e, this.f12882h);
        } else {
            drawable = SkinManager.getDrawable(this.f12882h, i2);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.f12880f.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.f12880f.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // d.a.n0.w.h
    public void setName(String str) {
        this.f12880f.setText(str);
    }

    public void setToolId(int i2) {
        this.f12879e = i2;
    }
}
