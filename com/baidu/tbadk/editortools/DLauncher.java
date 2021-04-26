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
import d.a.i0.r.u.c;
import d.a.i0.w.a;
import d.a.i0.w.h;
import d.a.i0.w.m;
/* loaded from: classes3.dex */
public class DLauncher extends RelativeLayout implements h {

    /* renamed from: e  reason: collision with root package name */
    public int f13488e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13489f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13490g;

    /* renamed from: h  reason: collision with root package name */
    public int f13491h;

    /* renamed from: i  reason: collision with root package name */
    public String f13492i;
    public m j;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.f13491h = 0;
        if (mVar == null) {
            return;
        }
        this.j = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f13489f = new EMTextView(context);
        setName(mVar.f49956b);
        setIcon();
        setToolId(mVar.f49957c);
        this.f13489f.setGravity(17);
        c d2 = c.d(this.f13489f);
        d2.u(R.dimen.T_X09);
        d2.q(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.ds12);
        addView(this.f13489f, layoutParams);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f13492i = str;
        if (this.f13490g == null) {
            TextView textView = new TextView(getContext());
            this.f13490g = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f13490g, R.color.common_color_10225, 1, this.f13491h);
        this.f13490g.setGravity(17);
        if (!str.equals(" ")) {
            this.f13490g.setTextSize(1, 10.0f);
            this.f13490g.setText(str);
            SkinManager.setBackgroundResource(this.f13490g, R.drawable.icon_news_head_prompt_one, this.f13491h);
            return;
        }
        this.f13490g.setWidth(0);
        this.f13490g.setHeight(0);
        this.f13490g.setText("");
        SkinManager.setBackgroundResource(this.f13490g, R.drawable.icon_news_down_bar_one, this.f13491h);
    }

    @Override // d.a.i0.w.h
    public void b() {
        setVisibility(0);
    }

    public void c(String str) {
        a(str);
        this.f13490g.setVisibility(0);
    }

    @Override // d.a.i0.w.h
    public void e() {
    }

    public void f() {
        this.f13492i = null;
        TextView textView = this.f13490g;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public String getText() {
        return this.f13492i;
    }

    @Override // d.a.i0.w.h
    public int getToolId() {
        return this.f13488e;
    }

    @Override // d.a.i0.w.h
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.i0.w.b
    public void onAction(a aVar) {
        if (aVar == null || aVar.f49949a != 2) {
            return;
        }
        Object obj = aVar.f49951c;
        if (obj == null) {
            f();
        } else if (obj instanceof String) {
            c((String) obj);
        }
    }

    @Override // d.a.i0.w.h
    public void onChangeSkinType(int i2) {
        this.f13491h = i2;
        if (isEnabled()) {
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i2);
        }
        c.d(this.f13489f).q(R.color.CAM_X0106);
        if (this.j == null) {
            return;
        }
        setIcon();
        TextView textView = this.f13490g;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i2);
            if (!TextUtils.isEmpty(this.f13490g.getText())) {
                SkinManager.setBackgroundResource(this.f13490g, R.drawable.icon_news_head_prompt_one, i2);
            } else {
                SkinManager.setBackgroundResource(this.f13490g, R.drawable.icon_news_down_bar_one, i2);
            }
            this.f13490g.setPadding(0, 0, 0, 0);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f13490g != null) {
            if (getVisibility() == 0) {
                int right = this.f13489f.getRight() - (this.f13490g.getMeasuredWidth() / 2);
                int top = this.f13489f.getTop() - (this.f13490g.getMeasuredHeight() / 2);
                this.f13490g.layout(right, top, this.f13490g.getMeasuredWidth() + right, this.f13490g.getMeasuredHeight() + top);
                return;
            }
            this.f13490g.layout(0, 0, 0, 0);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.f13489f.setAlpha(1.0f);
            this.f13489f.setEnabled(z);
            setPressed(true);
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
        } else {
            this.f13489f.setAlpha(0.33f);
            this.f13489f.setEnabled(false);
            setPressed(false);
            setBackground(null);
        }
        requestLayout();
    }

    public void setIcon() {
        Drawable drawable;
        m mVar = this.j;
        int i2 = mVar.f49960f;
        if (i2 <= 0) {
            i2 = mVar.f49958d;
        }
        if (TextUtils.isEmpty(this.f13489f.getText())) {
            if (this.j.f49961g) {
                this.f13489f.setBackgroundDrawable(SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.j.f49959e, this.f13491h));
                return;
            } else {
                SkinManager.setBackgroundResource(this.f13489f, i2, this.f13491h);
                return;
            }
        }
        if (this.j.f49961g) {
            drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.j.f49959e, this.f13491h);
        } else {
            drawable = SkinManager.getDrawable(this.f13491h, i2);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.f13489f.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.f13489f.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // d.a.i0.w.h
    public void setName(String str) {
        this.f13489f.setText(str);
    }

    public void setToolId(int i2) {
        this.f13488e = i2;
    }
}
