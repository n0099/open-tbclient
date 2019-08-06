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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected ImageView ahs;
    protected LinearLayout coi;
    protected TextView coj;
    private boolean col;
    private View mBottomLine;
    protected Context mContext;
    private View mTopLine;
    protected TextView textView;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.col = true;
        this.mContext = context;
        aqy();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.col = true;
        this.mContext = context;
        aqy();
    }

    public void displayTip() {
        if (this.coj != null) {
            this.coj.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.coj != null) {
            this.coj.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.coj != null) {
        }
    }

    public void l(int i, int i2, int i3, int i4) {
        if (this.coj != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.coj.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.ahs.setVisibility(8);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public void setTip(String str) {
        this.coj.setText(str);
    }

    public CharSequence getTip() {
        return this.coj.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.coj.setBackgroundDrawable(drawable);
    }

    protected void aqy() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.coi = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.coj = (TextView) findViewById(R.id.tip);
        this.ahs = (ImageView) findViewById(R.id.arrow2);
        this.mBottomLine = findViewById(R.id.bottom_line_ll);
        this.mTopLine = findViewById(R.id.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, c.a.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(5);
            String string2 = obtainStyledAttributes.getString(1);
            if (string != null) {
                this.textView.setText(string);
            }
            if (string2 != null) {
                this.coj.setText(string2);
            }
            this.col = obtainStyledAttributes.getBoolean(2, true);
            obtainStyledAttributes.recycle();
        }
        this.coi.setClickable(false);
        this.coi.setFocusable(false);
        if (!this.col) {
            this.ahs.setVisibility(4);
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
        this.textView.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.coj.setTextSize(0, f);
    }

    public void aqz() {
        int g = l.g(this.mContext, R.dimen.tbds42);
        int g2 = l.g(this.mContext, R.dimen.tbds33);
        setMainTextSize(g);
        setTipTextSize(g2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.coj.getLayoutParams()).setMargins(0, 0, l.g(this.mContext, R.dimen.tbds18), 0);
        this.coi.getLayoutParams().height = -1;
        requestLayout();
    }

    public void onChangeSkinType(int i) {
        am.l(this.mTopLine, R.color.cp_bg_line_b);
        am.k(this.coi, R.drawable.setting_item_selector);
        am.j(this.textView, R.color.cp_cont_b);
        am.j(this.coj, R.color.cp_cont_d);
        am.c(this.ahs, (int) R.drawable.icon_arrow_gray_right_n);
        am.l(this.mBottomLine, R.color.cp_bg_line_b);
    }
}
