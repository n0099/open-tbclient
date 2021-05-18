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
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class TbSettingTextTipView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f12763e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12764f;

    /* renamed from: g  reason: collision with root package name */
    public View f12765g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f12766h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12767i;
    public TextView j;
    public int k;
    public ImageView l;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12764f = true;
        this.f12763e = context;
        d();
        e(attributeSet);
    }

    private void setMainTextSize(float f2) {
        this.f12767i.setTextSize(0, f2);
    }

    private void setTipTextSize(float f2) {
        this.j.setTextSize(0, f2);
    }

    public void a() {
        int g2 = l.g(this.f12763e, R.dimen.tbds42);
        int g3 = l.g(this.f12763e, R.dimen.tbds33);
        setMainTextSize(g2);
        setTipTextSize(g3);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12767i.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.j.getLayoutParams()).setMargins(0, 0, l.g(this.f12763e, R.dimen.tbds18), 0);
        this.f12766h.getLayoutParams().height = -1;
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
        LayoutInflater.from(this.f12763e).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.f12766h = (LinearLayout) findViewById(R.id.container);
        this.f12767i = (TextView) findViewById(R.id.text);
        this.j = (TextView) findViewById(R.id.tip);
        this.l = (ImageView) findViewById(R.id.arrow2);
        this.f12765g = findViewById(R.id.top_line_ll);
    }

    public void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f12763e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingTip);
            if (string != null) {
                this.f12767i.setText(string);
            }
            if (string2 != null) {
                this.j.setText(string2);
            }
            this.f12764f = obtainStyledAttributes.getBoolean(R$styleable.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.f12766h.setClickable(false);
        this.f12766h.setFocusable(false);
        if (this.f12764f) {
            return;
        }
        this.l.setVisibility(4);
    }

    public void f(int i2) {
        SkinManager.setBackgroundColor(this.f12765g, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f12767i, R.color.CAM_X0105);
        TextView textView = this.j;
        int i3 = this.k;
        if (i3 == 0) {
            i3 = R.color.CAM_X0109;
        }
        SkinManager.setViewTextColor(textView, i3);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        LinearLayout linearLayout = this.f12766h;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        }
    }

    public void g() {
    }

    public CharSequence getTip() {
        return this.j.getText();
    }

    public void h(int i2, int i3, int i4, int i5) {
        if (this.j == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i2, i3, i4, i5);
        this.j.setLayoutParams(layoutParams);
    }

    public void setBottomLineVisibility(boolean z) {
    }

    public void setText(String str) {
        this.f12767i.setText(str);
    }

    public void setTip(String str) {
        this.j.setText(str);
    }

    public void setTipBackground(Drawable drawable) {
        this.j.setBackgroundDrawable(drawable);
    }

    public void setTipColor(int i2) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public void setTipStyle(int i2) {
    }

    public void setTipViewColor(int i2) {
        this.k = i2;
        SkinManager.setViewTextColor(this.j, i2);
    }

    @Deprecated
    public void setTopLineVisibility(boolean z) {
        this.f12765g.setVisibility(8);
    }

    public void setText(int i2) {
        this.f12767i.setText(i2);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.f12764f = true;
        this.f12763e = context;
        d();
    }
}
