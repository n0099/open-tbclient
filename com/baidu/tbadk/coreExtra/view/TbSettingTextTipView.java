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
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected ImageView agT;
    protected TextView aif;
    protected LinearLayout cmO;
    protected TextView cmP;
    private boolean cmR;
    private View mBottomLine;
    protected Context mContext;
    private View mTopLine;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmR = true;
        this.mContext = context;
        apr();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.cmR = true;
        this.mContext = context;
        apr();
    }

    public void displayTip() {
        if (this.cmP != null) {
            this.cmP.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.cmP != null) {
            this.cmP.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.cmP != null) {
        }
    }

    public void k(int i, int i2, int i3, int i4) {
        if (this.cmP != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.cmP.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.agT.setVisibility(8);
    }

    public void setText(String str) {
        this.aif.setText(str);
    }

    public void setText(int i) {
        this.aif.setText(i);
    }

    public void setTip(String str) {
        this.cmP.setText(str);
    }

    public CharSequence getTip() {
        return this.cmP.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.cmP.setBackgroundDrawable(drawable);
    }

    protected void apr() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.cmO = (LinearLayout) findViewById(R.id.container);
        this.aif = (TextView) findViewById(R.id.text);
        this.cmP = (TextView) findViewById(R.id.tip);
        this.agT = (ImageView) findViewById(R.id.arrow2);
        this.mBottomLine = findViewById(R.id.bottom_line_ll);
        this.mTopLine = findViewById(R.id.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, c.a.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(5);
            String string2 = obtainStyledAttributes.getString(1);
            if (string != null) {
                this.aif.setText(string);
            }
            if (string2 != null) {
                this.cmP.setText(string2);
            }
            this.cmR = obtainStyledAttributes.getBoolean(2, true);
            obtainStyledAttributes.recycle();
        }
        this.cmO.setClickable(false);
        this.cmO.setFocusable(false);
        if (!this.cmR) {
            this.agT.setVisibility(4);
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
        this.aif.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.cmP.setTextSize(0, f);
    }

    public void aps() {
        int g = l.g(this.mContext, R.dimen.tbds42);
        int g2 = l.g(this.mContext, R.dimen.tbds33);
        setMainTextSize(g);
        setTipTextSize(g2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aif.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.cmP.getLayoutParams()).setMargins(0, 0, l.g(this.mContext, R.dimen.tbds18), 0);
        this.cmO.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        al.l(this.mTopLine, R.color.cp_bg_line_b);
        al.k(this.cmO, R.drawable.setting_item_selector);
        al.j(this.aif, R.color.cp_cont_b);
        al.j(this.cmP, R.color.cp_cont_d);
        al.c(this.agT, (int) R.drawable.icon_arrow_gray_right_n);
        al.l(this.mBottomLine, R.color.cp_bg_line_b);
    }
}
