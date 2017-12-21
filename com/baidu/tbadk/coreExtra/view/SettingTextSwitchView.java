package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout aya;
    private TextView ayb;
    protected TextView ayc;
    private BdSwitchView ayd;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bw();
        b(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Bw();
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Bw();
        b(attributeSet);
        ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.aya;
    }

    public void ey(int i) {
        this.ayd.a(aj.cR(d.f.bg_switch_open), aj.cR(d.f.bg_switch_close), aj.cR(d.f.btn_handle));
        aj.c(this.ayb, d.C0095d.cp_cont_b, 1);
        if (this.ayc != null) {
            aj.c(this.ayc, d.C0095d.cp_cont_d, 1);
        }
    }

    public void km() {
        this.ayd.km();
        this.ayd.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void kl() {
        this.ayd.kl();
        this.ayd.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void R(boolean z) {
        this.ayd.R(z);
        this.ayd.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void Q(boolean z) {
        this.ayd.Q(z);
        this.ayd.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.ayb.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ayd.setOnSwitchStateChangeListener(aVar);
    }

    private void Bw() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aya = (LinearLayout) findViewById(d.g.container);
        this.ayb = (TextView) findViewById(d.g.text);
        this.ayd = (BdSwitchView) findViewById(d.g.button);
        this.ayd.setFocusable(true);
        this.ayc = (TextView) findViewById(d.g.tip);
        if (this.ayc != null) {
            this.ayc.setVisibility(8);
        }
        setTag(this.ayd);
        this.aya.setClickable(false);
        this.aya.setFocusable(false);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.ayc != null && string2 != null) {
            this.ayc.setVisibility(0);
            this.ayc.setText(string2);
            if (color2 > -1) {
                this.ayc.setTextColor(color2);
            }
        }
        if (string != null) {
            this.ayb.setText(string);
        }
        if (color > -1) {
            this.ayb.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.ayb.setTextSize(0, dimension);
        }
        this.aya.setClickable(false);
        this.aya.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.ayc != null) {
            displayTip();
            this.ayc.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.ayc != null) {
            displayTip();
            this.ayc.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.ayc != null) {
            this.ayc.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.ayc != null) {
            this.ayc.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.ayb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayb.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.ayb.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.ayd;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.ayd = bdSwitchView;
    }
}
