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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected ImageView agJ;
    protected TextView ahN;
    protected LinearLayout ceG;
    protected TextView ceH;
    private boolean ceJ;
    private View mBottomLine;
    protected Context mContext;
    private View mTopLine;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ceJ = true;
        this.mContext = context;
        ako();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.ceJ = true;
        this.mContext = context;
        ako();
    }

    public void displayTip() {
        if (this.ceH != null) {
            this.ceH.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.ceH != null) {
            this.ceH.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.ceH != null) {
        }
    }

    public void k(int i, int i2, int i3, int i4) {
        if (this.ceH != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.ceH.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.agJ.setVisibility(8);
    }

    public void setText(String str) {
        this.ahN.setText(str);
    }

    public void setText(int i) {
        this.ahN.setText(i);
    }

    public void setTip(String str) {
        this.ceH.setText(str);
    }

    public CharSequence getTip() {
        return this.ceH.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.ceH.setBackgroundDrawable(drawable);
    }

    protected void ako() {
        LayoutInflater.from(this.mContext).inflate(d.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.ceG = (LinearLayout) findViewById(d.g.container);
        this.ahN = (TextView) findViewById(d.g.text);
        this.ceH = (TextView) findViewById(d.g.tip);
        this.agJ = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.mTopLine = findViewById(d.g.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
            if (string != null) {
                this.ahN.setText(string);
            }
            if (string2 != null) {
                this.ceH.setText(string2);
            }
            this.ceJ = obtainStyledAttributes.getBoolean(d.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.ceG.setClickable(false);
        this.ceG.setFocusable(false);
        if (!this.ceJ) {
            this.agJ.setVisibility(4);
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
        this.ahN.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.ceH.setTextSize(0, f);
    }

    public void akp() {
        int h = l.h(this.mContext, d.e.tbds42);
        int h2 = l.h(this.mContext, d.e.tbds33);
        setMainTextSize(h);
        setTipTextSize(h2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahN.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.ceH.getLayoutParams()).setMargins(0, 0, l.h(this.mContext, d.e.tbds18), 0);
        this.ceG.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        al.l(this.mTopLine, d.C0277d.cp_bg_line_b);
        al.k(this.ceG, d.f.setting_item_selector);
        al.j(this.ahN, d.C0277d.cp_cont_b);
        al.j(this.ceH, d.C0277d.cp_cont_d);
        al.c(this.agJ, d.f.icon_arrow_gray_right_n);
        al.l(this.mBottomLine, d.C0277d.cp_bg_line_b);
    }
}
