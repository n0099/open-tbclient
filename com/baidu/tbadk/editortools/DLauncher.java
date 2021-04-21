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
import d.b.i0.r.u.c;
import d.b.i0.w.a;
import d.b.i0.w.h;
import d.b.i0.w.m;
/* loaded from: classes3.dex */
public class DLauncher extends RelativeLayout implements h {

    /* renamed from: e  reason: collision with root package name */
    public int f13503e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13504f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13505g;

    /* renamed from: h  reason: collision with root package name */
    public int f13506h;
    public String i;
    public m j;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.f13506h = 0;
        if (mVar == null) {
            return;
        }
        this.j = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f13504f = new EMTextView(context);
        setName(mVar.f52285b);
        setIcon();
        setToolId(mVar.f52286c);
        this.f13504f.setGravity(17);
        c d2 = c.d(this.f13504f);
        d2.u(R.dimen.T_X09);
        d2.q(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.ds12);
        addView(this.f13504f, layoutParams);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i = str;
        if (this.f13505g == null) {
            TextView textView = new TextView(getContext());
            this.f13505g = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f13505g, R.color.common_color_10225, 1, this.f13506h);
        this.f13505g.setGravity(17);
        if (!str.equals(" ")) {
            this.f13505g.setTextSize(1, 10.0f);
            this.f13505g.setText(str);
            SkinManager.setBackgroundResource(this.f13505g, R.drawable.icon_news_head_prompt_one, this.f13506h);
            return;
        }
        this.f13505g.setWidth(0);
        this.f13505g.setHeight(0);
        this.f13505g.setText("");
        SkinManager.setBackgroundResource(this.f13505g, R.drawable.icon_news_down_bar_one, this.f13506h);
    }

    @Override // d.b.i0.w.h
    public void b() {
        setVisibility(0);
    }

    public void c(String str) {
        a(str);
        this.f13505g.setVisibility(0);
    }

    @Override // d.b.i0.w.h
    public void e() {
    }

    public void f() {
        this.i = null;
        TextView textView = this.f13505g;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public String getText() {
        return this.i;
    }

    @Override // d.b.i0.w.h
    public int getToolId() {
        return this.f13503e;
    }

    @Override // d.b.i0.w.h
    public void hide() {
        setVisibility(8);
    }

    @Override // d.b.i0.w.b
    public void onAction(a aVar) {
        if (aVar == null || aVar.f52278a != 2) {
            return;
        }
        Object obj = aVar.f52280c;
        if (obj == null) {
            f();
        } else if (obj instanceof String) {
            c((String) obj);
        }
    }

    @Override // d.b.i0.w.h
    public void onChangeSkinType(int i) {
        this.f13506h = i;
        if (isEnabled()) {
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i);
        }
        c.d(this.f13504f).q(R.color.CAM_X0106);
        if (this.j == null) {
            return;
        }
        setIcon();
        TextView textView = this.f13505g;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.f13505g.getText())) {
                SkinManager.setBackgroundResource(this.f13505g, R.drawable.icon_news_head_prompt_one, i);
            } else {
                SkinManager.setBackgroundResource(this.f13505g, R.drawable.icon_news_down_bar_one, i);
            }
            this.f13505g.setPadding(0, 0, 0, 0);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f13505g != null) {
            if (getVisibility() == 0) {
                int right = this.f13504f.getRight() - (this.f13505g.getMeasuredWidth() / 2);
                int top = this.f13504f.getTop() - (this.f13505g.getMeasuredHeight() / 2);
                this.f13505g.layout(right, top, this.f13505g.getMeasuredWidth() + right, this.f13505g.getMeasuredHeight() + top);
                return;
            }
            this.f13505g.layout(0, 0, 0, 0);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.f13504f.setAlpha(1.0f);
            this.f13504f.setEnabled(z);
            setPressed(true);
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
        } else {
            this.f13504f.setAlpha(0.33f);
            this.f13504f.setEnabled(false);
            setPressed(false);
            setBackground(null);
        }
        requestLayout();
    }

    public void setIcon() {
        Drawable drawable;
        m mVar = this.j;
        int i = mVar.f52289f;
        if (i <= 0) {
            i = mVar.f52287d;
        }
        if (TextUtils.isEmpty(this.f13504f.getText())) {
            if (this.j.f52290g) {
                this.f13504f.setBackgroundDrawable(SvgManager.getInstance().getSeletableDrawableForEditorTools(i, this.j.f52288e, this.f13506h));
                return;
            } else {
                SkinManager.setBackgroundResource(this.f13504f, i, this.f13506h);
                return;
            }
        }
        if (this.j.f52290g) {
            drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i, this.j.f52288e, this.f13506h);
        } else {
            drawable = SkinManager.getDrawable(this.f13506h, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.f13504f.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.f13504f.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // d.b.i0.w.h
    public void setName(String str) {
        this.f13504f.setText(str);
    }

    public void setToolId(int i) {
        this.f13503e = i;
    }
}
