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
import d.a.j0.r.u.c;
import d.a.j0.w.a;
import d.a.j0.w.h;
import d.a.j0.w.m;
/* loaded from: classes3.dex */
public class DLauncher extends RelativeLayout implements h {

    /* renamed from: e  reason: collision with root package name */
    public int f12824e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12825f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12826g;

    /* renamed from: h  reason: collision with root package name */
    public int f12827h;

    /* renamed from: i  reason: collision with root package name */
    public String f12828i;
    public m j;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.f12827h = 0;
        if (mVar == null) {
            return;
        }
        this.j = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f12825f = new EMTextView(context);
        setName(mVar.f50775b);
        setIcon();
        setToolId(mVar.f50776c);
        this.f12825f.setGravity(17);
        c d2 = c.d(this.f12825f);
        d2.u(R.dimen.T_X09);
        d2.q(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.ds12);
        addView(this.f12825f, layoutParams);
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f12828i = str;
        if (this.f12826g == null) {
            TextView textView = new TextView(getContext());
            this.f12826g = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f12826g, R.color.common_color_10225, 1, this.f12827h);
        this.f12826g.setGravity(17);
        if (!str.equals(" ")) {
            this.f12826g.setTextSize(1, 10.0f);
            this.f12826g.setText(str);
            SkinManager.setBackgroundResource(this.f12826g, R.drawable.icon_news_head_prompt_one, this.f12827h);
            return;
        }
        this.f12826g.setWidth(0);
        this.f12826g.setHeight(0);
        this.f12826g.setText("");
        SkinManager.setBackgroundResource(this.f12826g, R.drawable.icon_news_down_bar_one, this.f12827h);
    }

    @Override // d.a.j0.w.h
    public void b() {
        setVisibility(0);
    }

    public void c(String str) {
        a(str);
        this.f12826g.setVisibility(0);
    }

    @Override // d.a.j0.w.h
    public void e() {
    }

    public void f() {
        this.f12828i = null;
        TextView textView = this.f12826g;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public String getText() {
        return this.f12828i;
    }

    @Override // d.a.j0.w.h
    public int getToolId() {
        return this.f12824e;
    }

    @Override // d.a.j0.w.h
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.j0.w.b
    public void onAction(a aVar) {
        if (aVar == null || aVar.f50768a != 2) {
            return;
        }
        Object obj = aVar.f50770c;
        if (obj == null) {
            f();
        } else if (obj instanceof String) {
            c((String) obj);
        }
    }

    @Override // d.a.j0.w.h
    public void onChangeSkinType(int i2) {
        this.f12827h = i2;
        if (isEnabled()) {
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i2);
        }
        c.d(this.f12825f).q(R.color.CAM_X0106);
        if (this.j == null) {
            return;
        }
        setIcon();
        TextView textView = this.f12826g;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i2);
            if (!TextUtils.isEmpty(this.f12826g.getText())) {
                SkinManager.setBackgroundResource(this.f12826g, R.drawable.icon_news_head_prompt_one, i2);
            } else {
                SkinManager.setBackgroundResource(this.f12826g, R.drawable.icon_news_down_bar_one, i2);
            }
            this.f12826g.setPadding(0, 0, 0, 0);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f12826g != null) {
            if (getVisibility() == 0) {
                int right = this.f12825f.getRight() - (this.f12826g.getMeasuredWidth() / 2);
                int top = this.f12825f.getTop() - (this.f12826g.getMeasuredHeight() / 2);
                this.f12826g.layout(right, top, this.f12826g.getMeasuredWidth() + right, this.f12826g.getMeasuredHeight() + top);
                return;
            }
            this.f12826g.layout(0, 0, 0, 0);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.f12825f.setAlpha(1.0f);
            this.f12825f.setEnabled(z);
            setPressed(true);
            SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
        } else {
            this.f12825f.setAlpha(0.33f);
            this.f12825f.setEnabled(false);
            setPressed(false);
            setBackground(null);
        }
        requestLayout();
    }

    public void setIcon() {
        Drawable drawable;
        m mVar = this.j;
        int i2 = mVar.f50779f;
        if (i2 <= 0) {
            i2 = mVar.f50777d;
        }
        if (TextUtils.isEmpty(this.f12825f.getText())) {
            if (this.j.f50780g) {
                this.f12825f.setBackgroundDrawable(SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.j.f50778e, this.f12827h));
                return;
            } else {
                SkinManager.setBackgroundResource(this.f12825f, i2, this.f12827h);
                return;
            }
        }
        if (this.j.f50780g) {
            drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.j.f50778e, this.f12827h);
        } else {
            drawable = SkinManager.getDrawable(this.f12827h, i2);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.f12825f.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.f12825f.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // d.a.j0.w.h
    public void setName(String str) {
        this.f12825f.setText(str);
    }

    public void setToolId(int i2) {
        this.f12824e = i2;
    }
}
