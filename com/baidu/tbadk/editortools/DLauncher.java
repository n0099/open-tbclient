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
import d.a.m0.r.u.c;
import d.a.m0.w.a;
import d.a.m0.w.h;
import d.a.m0.w.m;
/* loaded from: classes3.dex */
public class DLauncher extends RelativeLayout implements h {

    /* renamed from: e  reason: collision with root package name */
    public int f12732e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12733f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12734g;

    /* renamed from: h  reason: collision with root package name */
    public int f12735h;

    /* renamed from: i  reason: collision with root package name */
    public String f12736i;
    public m j;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.f12735h = 0;
        if (mVar == null) {
            return;
        }
        this.j = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f12733f = new EMTextView(context);
        setName(mVar.f50848b);
        setIcon();
        setToolId(mVar.f50849c);
        this.f12733f.setGravity(17);
        c d2 = c.d(this.f12733f);
        d2.w(R.dimen.T_X09);
        d2.s(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.ds12);
        addView(this.f12733f, layoutParams);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f12736i = str;
        if (this.f12734g == null) {
            TextView textView = new TextView(getContext());
            this.f12734g = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f12734g, R.color.common_color_10225, 1, this.f12735h);
        this.f12734g.setGravity(17);
        if (!str.equals(" ")) {
            this.f12734g.setTextSize(1, 10.0f);
            this.f12734g.setText(str);
            SkinManager.setBackgroundResource(this.f12734g, R.drawable.icon_news_head_prompt_one, this.f12735h);
            return;
        }
        this.f12734g.setWidth(0);
        this.f12734g.setHeight(0);
        this.f12734g.setText("");
        SkinManager.setBackgroundResource(this.f12734g, R.drawable.icon_news_down_bar_one, this.f12735h);
    }

    @Override // d.a.m0.w.h
    public void b() {
        setVisibility(0);
    }

    public void c(String str) {
        a(str);
        this.f12734g.setVisibility(0);
    }

    @Override // d.a.m0.w.h
    public void e() {
    }

    public void f() {
        this.f12736i = null;
        TextView textView = this.f12734g;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public String getText() {
        return this.f12736i;
    }

    @Override // d.a.m0.w.h
    public int getToolId() {
        return this.f12732e;
    }

    @Override // d.a.m0.w.h
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.m0.w.b
    public void onAction(a aVar) {
        if (aVar == null || aVar.f50841a != 2) {
            return;
        }
        Object obj = aVar.f50843c;
        if (obj == null) {
            f();
        } else if (obj instanceof String) {
            c((String) obj);
        }
    }

    @Override // d.a.m0.w.h
    public void onChangeSkinType(int i2) {
        this.f12735h = i2;
        if (isEnabled()) {
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i2);
        }
        c.d(this.f12733f).s(R.color.CAM_X0106);
        if (this.j == null) {
            return;
        }
        setIcon();
        TextView textView = this.f12734g;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i2);
            if (!TextUtils.isEmpty(this.f12734g.getText())) {
                SkinManager.setBackgroundResource(this.f12734g, R.drawable.icon_news_head_prompt_one, i2);
            } else {
                SkinManager.setBackgroundResource(this.f12734g, R.drawable.icon_news_down_bar_one, i2);
            }
            this.f12734g.setPadding(0, 0, 0, 0);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f12734g != null) {
            if (getVisibility() == 0) {
                int right = this.f12733f.getRight() - (this.f12734g.getMeasuredWidth() / 2);
                int top = this.f12733f.getTop() - (this.f12734g.getMeasuredHeight() / 2);
                this.f12734g.layout(right, top, this.f12734g.getMeasuredWidth() + right, this.f12734g.getMeasuredHeight() + top);
                return;
            }
            this.f12734g.layout(0, 0, 0, 0);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.f12733f.setAlpha(1.0f);
            this.f12733f.setEnabled(z);
            setPressed(true);
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
        } else {
            this.f12733f.setAlpha(0.33f);
            this.f12733f.setEnabled(false);
            setPressed(false);
            setBackground(null);
        }
        requestLayout();
    }

    public void setIcon() {
        Drawable drawable;
        m mVar = this.j;
        int i2 = mVar.f50852f;
        if (i2 <= 0) {
            i2 = mVar.f50850d;
        }
        if (TextUtils.isEmpty(this.f12733f.getText())) {
            if (this.j.f50853g) {
                this.f12733f.setBackgroundDrawable(SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.j.f50851e, this.f12735h));
                return;
            } else {
                SkinManager.setBackgroundResource(this.f12733f, i2, this.f12735h);
                return;
            }
        }
        if (this.j.f50853g) {
            drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.j.f50851e, this.f12735h);
        } else {
            drawable = SkinManager.getDrawable(this.f12735h, i2);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.f12733f.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.f12733f.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // d.a.m0.w.h
    public void setName(String str) {
        this.f12733f.setText(str);
    }

    public void setToolId(int i2) {
        this.f12732e = i2;
    }
}
