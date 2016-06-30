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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout amL;
    protected TextView amM;
    protected TextView amN;
    private boolean amP;
    protected ImageView amQ;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amP = true;
        this.mContext = context;
        zO();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.amP = true;
        this.mContext = context;
        zO();
    }

    public void displayTip() {
        if (this.amN != null) {
            this.amN.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.amN != null) {
            this.amN.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void e(int i, int i2, int i3, int i4) {
        if (this.amN != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.amN.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.amQ.setVisibility(8);
    }

    public void setText(String str) {
        this.amM.setText(str);
    }

    public void setText(int i) {
        this.amM.setText(i);
    }

    public void setTip(String str) {
        this.amN.setText(str);
    }

    public CharSequence getTip() {
        return this.amN.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.amN.setBackgroundDrawable(drawable);
    }

    protected void zO() {
        LayoutInflater.from(this.mContext).inflate(u.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.amL = (LinearLayout) findViewById(u.g.container);
        this.amM = (TextView) findViewById(u.g.text);
        this.amN = (TextView) findViewById(u.g.tip);
        this.amQ = (ImageView) findViewById(u.g.arrow2);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, u.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.amM.setText(string);
            }
            if (string2 != null) {
                this.amN.setText(string2);
            }
            this.amP = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.amL.setClickable(false);
        this.amL.setFocusable(false);
        if (!this.amP) {
            this.amQ.setVisibility(4);
        }
    }
}
