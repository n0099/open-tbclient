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
    public int f13834e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13835f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13836g;

    /* renamed from: h  reason: collision with root package name */
    public int f13837h;
    public String i;
    public m j;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.f13837h = 0;
        if (mVar == null) {
            return;
        }
        this.j = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f13835f = new EMTextView(context);
        setName(mVar.f51531b);
        setIcon();
        setToolId(mVar.f51532c);
        this.f13835f.setGravity(17);
        c a2 = c.a(this.f13835f);
        a2.r(R.dimen.T_X09);
        a2.n(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.ds12);
        addView(this.f13835f, layoutParams);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i = str;
        if (this.f13836g == null) {
            TextView textView = new TextView(getContext());
            this.f13836g = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f13836g, R.color.common_color_10225, 1, this.f13837h);
        this.f13836g.setGravity(17);
        if (!str.equals(" ")) {
            this.f13836g.setTextSize(1, 10.0f);
            this.f13836g.setText(str);
            SkinManager.setBackgroundResource(this.f13836g, R.drawable.icon_news_head_prompt_one, this.f13837h);
            return;
        }
        this.f13836g.setWidth(0);
        this.f13836g.setHeight(0);
        this.f13836g.setText("");
        SkinManager.setBackgroundResource(this.f13836g, R.drawable.icon_news_down_bar_one, this.f13837h);
    }

    @Override // d.b.h0.w.h
    public void b() {
        setVisibility(0);
    }

    public void c(String str) {
        a(str);
        this.f13836g.setVisibility(0);
    }

    public void e() {
        this.i = null;
        TextView textView = this.f13836g;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // d.b.h0.w.h
    public void f() {
    }

    public String getText() {
        return this.i;
    }

    @Override // d.b.h0.w.h
    public int getToolId() {
        return this.f13834e;
    }

    @Override // d.b.h0.w.h
    public void hide() {
        setVisibility(8);
    }

    @Override // d.b.h0.w.b
    public void onAction(a aVar) {
        if (aVar == null || aVar.f51524a != 2) {
            return;
        }
        Object obj = aVar.f51526c;
        if (obj == null) {
            e();
        } else if (obj instanceof String) {
            c((String) obj);
        }
    }

    @Override // d.b.h0.w.h
    public void onChangeSkinType(int i) {
        this.f13837h = i;
        if (isEnabled()) {
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i);
        }
        c.a(this.f13835f).n(R.color.CAM_X0106);
        if (this.j == null) {
            return;
        }
        setIcon();
        TextView textView = this.f13836g;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.f13836g.getText())) {
                SkinManager.setBackgroundResource(this.f13836g, R.drawable.icon_news_head_prompt_one, i);
            } else {
                SkinManager.setBackgroundResource(this.f13836g, R.drawable.icon_news_down_bar_one, i);
            }
            this.f13836g.setPadding(0, 0, 0, 0);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f13836g != null) {
            if (getVisibility() == 0) {
                int right = this.f13835f.getRight() - (this.f13836g.getMeasuredWidth() / 2);
                int top = this.f13835f.getTop() - (this.f13836g.getMeasuredHeight() / 2);
                this.f13836g.layout(right, top, this.f13836g.getMeasuredWidth() + right, this.f13836g.getMeasuredHeight() + top);
                return;
            }
            this.f13836g.layout(0, 0, 0, 0);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.f13835f.setAlpha(1.0f);
            this.f13835f.setEnabled(z);
            setPressed(true);
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
        } else {
            this.f13835f.setAlpha(0.33f);
            this.f13835f.setEnabled(false);
            setPressed(false);
            setBackground(null);
        }
        requestLayout();
    }

    public void setIcon() {
        Drawable drawable;
        m mVar = this.j;
        int i = mVar.f51535f;
        if (i <= 0) {
            i = mVar.f51533d;
        }
        if (TextUtils.isEmpty(this.f13835f.getText())) {
            if (this.j.f51536g) {
                this.f13835f.setBackgroundDrawable(SvgManager.getInstance().getSeletableDrawableForEditorTools(i, this.j.f51534e, this.f13837h));
                return;
            } else {
                SkinManager.setBackgroundResource(this.f13835f, i, this.f13837h);
                return;
            }
        }
        if (this.j.f51536g) {
            drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i, this.j.f51534e, this.f13837h);
        } else {
            drawable = SkinManager.getDrawable(this.f13837h, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.f13835f.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.f13835f.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // d.b.h0.w.h
    public void setName(String str) {
        this.f13835f.setText(str);
    }

    public void setToolId(int i) {
        this.f13834e = i;
    }
}
