package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class TbSettingTextTipView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f13447e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13448f;

    /* renamed from: g  reason: collision with root package name */
    public View f13449g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f13450h;
    public TextView i;
    public TextView j;
    public int k;
    public ImageView l;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13448f = true;
        this.f13447e = context;
        d();
        e(attributeSet);
    }

    private void setMainTextSize(float f2) {
        this.i.setTextSize(0, f2);
    }

    private void setTipTextSize(float f2) {
        this.j.setTextSize(0, f2);
    }

    public void a() {
        int g2 = l.g(this.f13447e, R.dimen.tbds42);
        int g3 = l.g(this.f13447e, R.dimen.tbds33);
        setMainTextSize(g2);
        setTipTextSize(g3);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.j.getLayoutParams()).setMargins(0, 0, l.g(this.f13447e, R.dimen.tbds18), 0);
        this.f13450h.getLayoutParams().height = -1;
        requestLayout();
    }

    public void b() {
        TextView textView = this.j;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void c() {
        this.l.setVisibility(8);
    }

    public void d() {
        LayoutInflater.from(this.f13447e).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.f13450h = (LinearLayout) findViewById(R.id.container);
        this.i = (TextView) findViewById(R.id.text);
        this.j = (TextView) findViewById(R.id.tip);
        this.l = (ImageView) findViewById(R.id.arrow2);
        this.f13449g = findViewById(R.id.top_line_ll);
    }

    public void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f13447e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingTip);
            if (string != null) {
                this.i.setText(string);
            }
            if (string2 != null) {
                this.j.setText(string2);
            }
            this.f13448f = obtainStyledAttributes.getBoolean(R$styleable.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.f13450h.setClickable(false);
        this.f13450h.setFocusable(false);
        if (this.f13448f) {
            return;
        }
        this.l.setVisibility(4);
    }

    public void f(int i) {
        SkinManager.setBackgroundColor(this.f13449g, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105);
        TextView textView = this.j;
        int i2 = this.k;
        if (i2 == 0) {
            i2 = R.color.CAM_X0109;
        }
        SkinManager.setViewTextColor(textView, i2);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        LinearLayout linearLayout = this.f13450h;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        }
    }

    public void g() {
    }

    public CharSequence getTip() {
        return this.j.getText();
    }

    public void h(int i, int i2, int i3, int i4) {
        if (this.j == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.j.setLayoutParams(layoutParams);
    }

    public void setBottomLineVisibility(boolean z) {
    }

    public void setText(String str) {
        this.i.setText(str);
    }

    public void setTip(String str) {
        this.j.setText(str);
    }

    public void setTipBackground(Drawable drawable) {
        this.j.setBackgroundDrawable(drawable);
    }

    public void setTipColor(int i) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void setTipViewColor(int i) {
        this.k = i;
        SkinManager.setViewTextColor(this.j, i);
    }

    @Deprecated
    public void setTopLineVisibility(boolean z) {
        this.f13449g.setVisibility(8);
    }

    public void setText(int i) {
        this.i.setText(i);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.f13448f = true;
        this.f13447e = context;
        d();
    }
}
