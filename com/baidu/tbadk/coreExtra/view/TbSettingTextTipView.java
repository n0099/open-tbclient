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
    protected LinearLayout aQi;
    protected TextView aQj;
    protected TextView aQk;
    private boolean aQm;
    protected ImageView aQn;
    private View mBottomLine;
    protected Context mContext;
    private View mTopLine;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQm = true;
        this.mContext = context;
        Ji();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.aQm = true;
        this.mContext = context;
        Ji();
    }

    public void displayTip() {
        if (this.aQk != null) {
            this.aQk.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.aQk != null) {
            this.aQk.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.aQk != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.aQk != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.aQk.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.aQn.setVisibility(8);
    }

    public void setText(String str) {
        this.aQj.setText(str);
    }

    public void setText(int i) {
        this.aQj.setText(i);
    }

    public void setTip(String str) {
        this.aQk.setText(str);
    }

    public CharSequence getTip() {
        return this.aQk.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aQk.setBackgroundDrawable(drawable);
    }

    protected void Ji() {
        LayoutInflater.from(this.mContext).inflate(e.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.aQi = (LinearLayout) findViewById(e.g.container);
        this.aQj = (TextView) findViewById(e.g.text);
        this.aQk = (TextView) findViewById(e.g.tip);
        this.aQn = (ImageView) findViewById(e.g.arrow2);
        this.mBottomLine = findViewById(e.g.bottom_line_ll);
        this.mTopLine = findViewById(e.g.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
            if (string != null) {
                this.aQj.setText(string);
            }
            if (string2 != null) {
                this.aQk.setText(string2);
            }
            this.aQm = obtainStyledAttributes.getBoolean(e.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.aQi.setClickable(false);
        this.aQi.setFocusable(false);
        if (!this.aQm) {
            this.aQn.setVisibility(4);
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
        this.aQj.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.aQk.setTextSize(0, f);
    }

    public void Jj() {
        int h = l.h(this.mContext, e.C0175e.tbds42);
        int h2 = l.h(this.mContext, e.C0175e.tbds33);
        setMainTextSize(h);
        setTipTextSize(h2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aQj.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.aQk.getLayoutParams()).setMargins(0, 0, l.h(this.mContext, e.C0175e.tbds18), 0);
        this.aQi.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mTopLine, e.d.cp_bg_line_b);
        al.i(this.aQi, e.f.setting_item_selector);
        al.h(this.aQj, e.d.cp_cont_b);
        al.h(this.aQk, e.d.cp_cont_d);
        al.c(this.aQn, e.f.icon_arrow_gray_right_n);
        al.j(this.mBottomLine, e.d.cp_bg_line_b);
    }
}
