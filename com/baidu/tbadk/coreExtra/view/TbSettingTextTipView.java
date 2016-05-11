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
    protected LinearLayout amf;
    protected TextView amg;
    protected TextView amh;
    private boolean amj;
    protected ImageView amk;
    protected Context mContext;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amj = true;
        this.mContext = context;
        zI();
        d(attributeSet);
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.amj = true;
        this.mContext = context;
        zI();
    }

    public void displayTip() {
        if (this.amh != null) {
            this.amh.setVisibility(0);
        }
    }

    public void setTipColor(int i) {
        if (this.amh != null) {
            this.amh.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public void e(int i, int i2, int i3, int i4) {
        if (this.amh != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(i, i2, i3, i4);
            this.amh.setLayoutParams(layoutParams);
        }
    }

    public void recycle() {
    }

    public void hideArrow() {
        this.amk.setVisibility(8);
    }

    public void setText(String str) {
        this.amg.setText(str);
    }

    public void setText(int i) {
        this.amg.setText(i);
    }

    public void setTip(String str) {
        this.amh.setText(str);
    }

    public CharSequence getTip() {
        return this.amh.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.amh.setBackgroundDrawable(drawable);
    }

    protected void zI() {
        LayoutInflater.from(this.mContext).inflate(t.h.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.amf = (LinearLayout) findViewById(t.g.container);
        this.amg = (TextView) findViewById(t.g.text);
        this.amh = (TextView) findViewById(t.g.tip);
        this.amk = (ImageView) findViewById(t.g.arrow2);
    }

    protected void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            String string2 = obtainStyledAttributes.getString(3);
            if (string != null) {
                this.amg.setText(string);
            }
            if (string2 != null) {
                this.amh.setText(string2);
            }
            this.amj = obtainStyledAttributes.getBoolean(5, true);
            obtainStyledAttributes.recycle();
        }
        this.amf.setClickable(false);
        this.amf.setFocusable(false);
        if (!this.amj) {
            this.amk.setVisibility(4);
        }
    }
}
