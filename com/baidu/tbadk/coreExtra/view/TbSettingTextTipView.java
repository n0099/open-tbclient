package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout aqa;
    protected TextView aqb;
    protected TextView aqc;
    private boolean aqe;
    protected ImageView aqf;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqe = true;
        this.mContext = context;
        Bl();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.aqe = true;
        this.mContext = context;
        Bl();
    }

    public void displayTip() {
        if (this.aqc != null) {
            this.aqc.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.aqc != null) {
            this.aqc.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void g(int i, int i2, int i3, int i4) {
        if (this.aqc != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.aqc.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.aqf.setVisibility(8);
    }

    public void setText(String str) {
        this.aqb.setText(str);
    }

    public void setText(int i) {
        this.aqb.setText(i);
    }

    public void setTip(String str) {
        this.aqc.setText(str);
    }

    public CharSequence getTip() {
        return this.aqc.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aqc.setBackgroundDrawable(drawable);
    }

    protected void Bl() {
        LayoutInflater.from(this.mContext).inflate(t.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.aqa = (LinearLayout) findViewById(t.g.container);
        this.aqb = (TextView) findViewById(t.g.text);
        this.aqc = (TextView) findViewById(t.g.tip);
        this.aqf = (ImageView) findViewById(t.g.arrow2);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.aqb.setText(string);
            }
            if (string2 != null) {
                this.aqc.setText(string2);
            }
            this.aqe = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.aqa.setClickable(false);
        this.aqa.setFocusable(false);
        if (!this.aqe) {
            this.aqf.setVisibility(4);
        }
    }
}
