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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected LinearLayout avI;
    protected TextView avJ;
    protected TextView avK;
    private boolean avM;
    private View avN;
    private View avO;
    protected ImageView avP;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avM = true;
        this.mContext = context;
        AX();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.avM = true;
        this.mContext = context;
        AX();
    }

    public void displayTip() {
        if (this.avK != null) {
            this.avK.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.avK != null) {
            this.avK.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void f(int i, int i2, int i3, int i4) {
        if (this.avK != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.avK.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.avP.setVisibility(8);
    }

    public void setText(String str) {
        this.avJ.setText(str);
    }

    public void setText(int i) {
        this.avJ.setText(i);
    }

    public void setTip(String str) {
        this.avK.setText(str);
    }

    public CharSequence getTip() {
        return this.avK.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.avK.setBackgroundDrawable(drawable);
    }

    protected void AX() {
        LayoutInflater.from(this.mContext).inflate(w.j.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.avI = (LinearLayout) findViewById(w.h.container);
        this.avJ = (TextView) findViewById(w.h.text);
        this.avK = (TextView) findViewById(w.h.tip);
        this.avP = (ImageView) findViewById(w.h.arrow2);
        this.avO = findViewById(w.h.bottom_line_ll);
        this.avN = findViewById(w.h.top_line_ll);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, w.n.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.avJ.setText(string);
            }
            if (string2 != null) {
                this.avK.setText(string2);
            }
            this.avM = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.avI.setClickable(false);
        this.avI.setFocusable(false);
        if (!this.avM) {
            this.avP.setVisibility(4);
        }
    }

    public void setTopLineVisibility(boolean z) {
        if (z) {
            this.avN.setVisibility(0);
        } else {
            this.avN.setVisibility(8);
        }
    }

    public void setBottomLineVisibility(boolean z) {
        if (z) {
            this.avO.setVisibility(0);
        } else {
            this.avO.setVisibility(8);
        }
    }
}
