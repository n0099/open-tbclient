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
import d.b.h0.r.u.c;
import d.b.h0.w.a;
import d.b.h0.w.h;
import d.b.h0.w.m;
/* loaded from: classes3.dex */
public class DLauncher extends RelativeLayout implements h {

    /* renamed from: e  reason: collision with root package name */
    public int f13495e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13496f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13497g;

    /* renamed from: h  reason: collision with root package name */
    public int f13498h;
    public String i;
    public m j;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.f13498h = 0;
        if (mVar == null) {
            return;
        }
        this.j = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f13496f = new EMTextView(context);
        setName(mVar.f51949b);
        setIcon();
        setToolId(mVar.f51950c);
        this.f13496f.setGravity(17);
        c d2 = c.d(this.f13496f);
        d2.u(R.dimen.T_X09);
        d2.q(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.ds12);
        addView(this.f13496f, layoutParams);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i = str;
        if (this.f13497g == null) {
            TextView textView = new TextView(getContext());
            this.f13497g = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f13497g, R.color.common_color_10225, 1, this.f13498h);
        this.f13497g.setGravity(17);
        if (!str.equals(" ")) {
            this.f13497g.setTextSize(1, 10.0f);
            this.f13497g.setText(str);
            SkinManager.setBackgroundResource(this.f13497g, R.drawable.icon_news_head_prompt_one, this.f13498h);
            return;
        }
        this.f13497g.setWidth(0);
        this.f13497g.setHeight(0);
        this.f13497g.setText("");
        SkinManager.setBackgroundResource(this.f13497g, R.drawable.icon_news_down_bar_one, this.f13498h);
    }

    @Override // d.b.h0.w.h
    public void b() {
        setVisibility(0);
    }

    public void c(String str) {
        a(str);
        this.f13497g.setVisibility(0);
    }

    @Override // d.b.h0.w.h
    public void e() {
    }

    public void f() {
        this.i = null;
        TextView textView = this.f13497g;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public String getText() {
        return this.i;
    }

    @Override // d.b.h0.w.h
    public int getToolId() {
        return this.f13495e;
    }

    @Override // d.b.h0.w.h
    public void hide() {
        setVisibility(8);
    }

    @Override // d.b.h0.w.b
    public void onAction(a aVar) {
        if (aVar == null || aVar.f51942a != 2) {
            return;
        }
        Object obj = aVar.f51944c;
        if (obj == null) {
            f();
        } else if (obj instanceof String) {
            c((String) obj);
        }
    }

    @Override // d.b.h0.w.h
    public void onChangeSkinType(int i) {
        this.f13498h = i;
        if (isEnabled()) {
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i);
        }
        c.d(this.f13496f).q(R.color.CAM_X0106);
        if (this.j == null) {
            return;
        }
        setIcon();
        TextView textView = this.f13497g;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.f13497g.getText())) {
                SkinManager.setBackgroundResource(this.f13497g, R.drawable.icon_news_head_prompt_one, i);
            } else {
                SkinManager.setBackgroundResource(this.f13497g, R.drawable.icon_news_down_bar_one, i);
            }
            this.f13497g.setPadding(0, 0, 0, 0);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f13497g != null) {
            if (getVisibility() == 0) {
                int right = this.f13496f.getRight() - (this.f13497g.getMeasuredWidth() / 2);
                int top = this.f13496f.getTop() - (this.f13497g.getMeasuredHeight() / 2);
                this.f13497g.layout(right, top, this.f13497g.getMeasuredWidth() + right, this.f13497g.getMeasuredHeight() + top);
                return;
            }
            this.f13497g.layout(0, 0, 0, 0);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.f13496f.setAlpha(1.0f);
            this.f13496f.setEnabled(z);
            setPressed(true);
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
        } else {
            this.f13496f.setAlpha(0.33f);
            this.f13496f.setEnabled(false);
            setPressed(false);
            setBackground(null);
        }
        requestLayout();
    }

    public void setIcon() {
        Drawable drawable;
        m mVar = this.j;
        int i = mVar.f51953f;
        if (i <= 0) {
            i = mVar.f51951d;
        }
        if (TextUtils.isEmpty(this.f13496f.getText())) {
            if (this.j.f51954g) {
                this.f13496f.setBackgroundDrawable(SvgManager.getInstance().getSeletableDrawableForEditorTools(i, this.j.f51952e, this.f13498h));
                return;
            } else {
                SkinManager.setBackgroundResource(this.f13496f, i, this.f13498h);
                return;
            }
        }
        if (this.j.f51954g) {
            drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i, this.j.f51952e, this.f13498h);
        } else {
            drawable = SkinManager.getDrawable(this.f13498h, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.f13496f.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.f13496f.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // d.b.h0.w.h
    public void setName(String str) {
        this.f13496f.setText(str);
    }

    public void setToolId(int i) {
        this.f13495e = i;
    }
}
