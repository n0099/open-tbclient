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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    private View GD;
    protected LinearLayout aqM;
    protected TextView aqN;
    protected TextView aqO;
    private boolean aqQ;
    private View aqR;
    protected ImageView aqS;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqQ = true;
        this.mContext = context;
        Ba();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.aqQ = true;
        this.mContext = context;
        Ba();
    }

    public void displayTip() {
        if (this.aqO != null) {
            this.aqO.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.aqO != null) {
            this.aqO.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.aqO != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.aqO.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.aqS.setVisibility(8);
    }

    public void setText(String str) {
        this.aqN.setText(str);
    }

    public void setText(int i) {
        this.aqN.setText(i);
    }

    public void setTip(String str) {
        this.aqO.setText(str);
    }

    public CharSequence getTip() {
        return this.aqO.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.aqO.setBackgroundDrawable(drawable);
    }

    protected void Ba() {
        LayoutInflater.from(this.mContext).inflate(r.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.aqM = (LinearLayout) findViewById(r.g.container);
        this.aqN = (TextView) findViewById(r.g.text);
        this.aqO = (TextView) findViewById(r.g.tip);
        this.aqS = (ImageView) findViewById(r.g.arrow2);
        this.GD = findViewById(r.g.bottom_line_ll);
        this.aqR = findViewById(r.g.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, r.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.aqN.setText(string);
            }
            if (string2 != null) {
                this.aqO.setText(string2);
            }
            this.aqQ = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.aqM.setClickable(false);
        this.aqM.setFocusable(false);
        if (!this.aqQ) {
            this.aqS.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.aqR.setVisibility(0);
        } else {
            this.aqR.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.GD.setVisibility(0);
        } else {
            this.GD.setVisibility(8);
        }
    }
}
