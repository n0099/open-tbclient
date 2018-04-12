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
    protected LinearLayout ayZ;
    protected TextView aza;
    protected TextView azb;
    private boolean azd;
    private View aze;
    protected ImageView azf;
    private View mBottomLine;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azd = true;
        this.mContext = context;
        Cc();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.azd = true;
        this.mContext = context;
        Cc();
    }

    public void displayTip() {
        if (this.azb != null) {
            this.azb.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.azb != null) {
            this.azb.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
        if (this.azb != null) {
        }
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.azb != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.azb.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.azf.setVisibility(8);
    }

    public void setText(String str) {
        this.aza.setText(str);
    }

    public void setText(int i) {
        this.aza.setText(i);
    }

    public void setTip(String str) {
        this.azb.setText(str);
    }

    public CharSequence getTip() {
        return this.azb.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.azb.setBackgroundDrawable(drawable);
    }

    protected void Cc() {
        LayoutInflater.from(this.mContext).inflate(d.i.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.ayZ = (LinearLayout) findViewById(d.g.container);
        this.aza = (TextView) findViewById(d.g.text);
        this.azb = (TextView) findViewById(d.g.tip);
        this.azf = (ImageView) findViewById(d.g.arrow2);
        this.mBottomLine = findViewById(d.g.bottom_line_ll);
        this.aze = findViewById(d.g.top_line_ll);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
            String string2 = obtainStyledAttributes.getString(d.m.TbSettingView_settingTip);
            if (string != null) {
                this.aza.setText(string);
            }
            if (string2 != null) {
                this.azb.setText(string2);
            }
            this.azd = obtainStyledAttributes.getBoolean(d.m.TbSettingView_settingShowArraw, true);
            obtainStyledAttributes.recycle();
        }
        this.ayZ.setClickable(false);
        this.ayZ.setFocusable(false);
        if (!this.azd) {
            this.azf.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.aze.setVisibility(0);
        } else {
            this.aze.setVisibility(8);
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
        this.aza.setTextSize(0, f);
    }

    private void setTipTextSize(float f) {
        this.azb.setTextSize(0, f);
    }

    public void Cd() {
        int e = l.e(this.mContext, d.e.tbds42);
        int e2 = l.e(this.mContext, d.e.tbds33);
        setMainTextSize(e);
        setTipTextSize(e2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aza.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
        ((LinearLayout.LayoutParams) this.azb.getLayoutParams()).setMargins(0, 0, l.e(this.mContext, d.e.tbds18), 0);
        this.ayZ.getLayoutParams().height = -1;
        requestLayout();
    }
}
