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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout boK;
    protected TextView boL;
    protected TextView boM;
    private boolean boO;
    private View boP;
    protected ImageView boQ;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boO = true;
        this.mContext = context;
        Jw();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.boO = true;
        this.mContext = context;
        Jw();
    }

    public void displayTip() {
        if (this.boM != null) {
            this.boM.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.boM != null) {
            this.boM.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.boM != null) {
        }
    }

    public void o(int i, int i2, int i3, int i4) {
        if (this.boM != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.boM.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.boQ.setVisibility(8);
    }

    public void setText(String str) {
        this.boL.setText(str);
    }

    public void setText(int i) {
        this.boL.setText(i);
    }

    public void setTip(String str) {
        this.boM.setText(str);
    }

    public CharSequence getTip() {
        return this.boM.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.boM.setBackgroundDrawable(drawable);
    }

    protected void Jw() {
        LayoutInflater.from(this.mContext).inflate(d.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.boK = (LinearLayout) findViewById(d.g.container);
        this.boL = (TextView) findViewById(d.g.text);
        this.boM = (TextView) findViewById(d.g.tip);
        this.boQ = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.boP = findViewById(d.g.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
            if (string != null) {
                this.boL.setText(string);
            }
            if (string2 != null) {
                this.boM.setText(string2);
            }
            this.boO = obtainStyledAttributes.getBoolean(d.l.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.boK.setClickable(false);
        this.boK.setFocusable(false);
        if (!this.boO) {
            this.boQ.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.boP.setVisibility(0);
        } else {
            this.boP.setVisibility(8);
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
        this.boL.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.boM.setTextSize(0, f);
    }

    public void Jx() {
        int t = l.t(this.mContext, d.e.tbds42);
        int t2 = l.t(this.mContext, d.e.tbds33);
        setMainTextSize(t);
        setTipTextSize(t2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boL.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.boM.getLayoutParams()).setMargins(0, 0, l.t(this.mContext, d.e.tbds18), 0);
        this.boK.getLayoutParams().height = -1;
        requestLayout();
    }
}
