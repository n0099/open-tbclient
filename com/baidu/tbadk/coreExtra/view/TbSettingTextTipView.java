package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout agF;
    protected TextView agG;
    protected TextView agH;
    private boolean agJ;
    protected ImageView agK;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agJ = true;
        this.mContext = context;
        yd();
        c(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.agJ = true;
        this.mContext = context;
        yd();
    }

    public void displayTip() {
        if (this.agH != null) {
            this.agH.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.agH != null) {
            this.agH.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void e(int i, int i2, int i3, int i4) {
        if (this.agH != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.agH.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.agK.setVisibility(8);
    }

    public void setText(String str) {
        this.agG.setText(str);
    }

    public void setText(int i) {
        this.agG.setText(i);
    }

    public void setTip(String str) {
        this.agH.setText(str);
    }

    public CharSequence getTip() {
        return this.agH.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.agH.setBackgroundDrawable(drawable);
    }

    protected void yd() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.tb_setting_text_tip_view, this, true);
        this.agF = (LinearLayout) findViewById(com.baidu.tieba.q.container);
        this.agG = (TextView) findViewById(com.baidu.tieba.q.text);
        this.agH = (TextView) findViewById(com.baidu.tieba.q.tip);
        this.agK = (ImageView) findViewById(com.baidu.tieba.q.arrow2);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.v.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.agG.setText(string);
            }
            if (string2 != null) {
                this.agH.setText(string2);
            }
            this.agJ = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.agF.setClickable(false);
        this.agF.setFocusable(false);
        if (!this.agJ) {
            this.agK.setVisibility(4);
        }
    }
}
