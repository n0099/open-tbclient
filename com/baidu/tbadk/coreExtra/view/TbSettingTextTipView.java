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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout aVi;
    protected TextView aVj;
    private boolean aVl;
    protected ImageView ahZ;
    protected TextView ajh;
    private View mBottomLine;
    protected Context mContext;
    private View mTopLine;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aVl = true;
        this.mContext = context;
        KO();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.aVl = true;
        this.mContext = context;
        KO();
    }

    public void displayTip() {
        if (this.aVj != null) {
            this.aVj.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.aVj != null) {
            this.aVj.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.aVj != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.aVj != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.aVj.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.ahZ.setVisibility(8);
    }

    public void setText(String str) {
        this.ajh.setText(str);
    }

    public void setText(int i) {
        this.ajh.setText(i);
    }

    public void setTip(String str) {
        this.aVj.setText(str);
    }

    public CharSequence getTip() {
        return this.aVj.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aVj.setBackgroundDrawable(drawable);
    }

    protected void KO() {
        LayoutInflater.from(this.mContext).inflate(e.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.aVi = (LinearLayout) findViewById(e.g.container);
        this.ajh = (TextView) findViewById(e.g.text);
        this.aVj = (TextView) findViewById(e.g.tip);
        this.ahZ = (ImageView) findViewById(e.g.arrow2);
        this.mBottomLine = findViewById(e.g.bottom_line_ll);
        this.mTopLine = findViewById(e.g.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
            if (string != null) {
                this.ajh.setText(string);
            }
            if (string2 != null) {
                this.aVj.setText(string2);
            }
            this.aVl = obtainStyledAttributes.getBoolean(e.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.aVi.setClickable(false);
        this.aVi.setFocusable(false);
        if (!this.aVl) {
            this.ahZ.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.mTopLine.setVisibility(0);
        } else {
            this.mTopLine.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.mBottomLine.setVisibility(0);
        } else {
            this.mBottomLine.setVisibility(8);
        }
    }

    private void setMainTextSize(float f) {
        this.ajh.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.aVj.setTextSize(0, f);
    }

    public void KP() {
        int h = l.h(this.mContext, e.C0210e.tbds42);
        int h2 = l.h(this.mContext, e.C0210e.tbds33);
        setMainTextSize(h);
        setTipTextSize(h2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajh.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.aVj.getLayoutParams()).setMargins(0, 0, l.h(this.mContext, e.C0210e.tbds18), 0);
        this.aVi.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mTopLine, e.d.cp_bg_line_b);
        al.i(this.aVi, e.f.setting_item_selector);
        al.h(this.ajh, e.d.cp_cont_b);
        al.h(this.aVj, e.d.cp_cont_d);
        al.c(this.ahZ, e.f.icon_arrow_gray_right_n);
        al.j(this.mBottomLine, e.d.cp_bg_line_b);
    }
}
