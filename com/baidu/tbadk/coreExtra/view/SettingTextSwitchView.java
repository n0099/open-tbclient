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
    private LinearLayout bmf;
    private TextView bmg;
    protected TextView bmh;
    private BdSwitchView bmi;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        IY();
        d(attributeSet);
        hw(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        IY();
        hw(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        IY();
        d(attributeSet);
        hw(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.bmf;
    }

    public void hw(int i) {
        this.bmi.a(aj.fQ(d.f.bg_switch_open), aj.fQ(d.f.bg_switch_close), aj.fQ(d.f.btn_handle));
        aj.e(this.bmg, d.C0108d.cp_cont_b, 1);
        if (this.bmh != null) {
            aj.e(this.bmh, d.C0108d.cp_cont_d, 1);
        }
    }

    public void rL() {
        this.bmi.rL();
        this.bmi.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void rK() {
        this.bmi.rK();
        this.bmi.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void ax(boolean z) {
        this.bmi.ax(z);
        this.bmi.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void aw(boolean z) {
        this.bmi.aw(z);
        this.bmi.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.bmg.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.bmi.setOnSwitchStateChangeListener(aVar);
    }

    private void IY() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.bmf = (LinearLayout) findViewById(d.g.container);
        this.bmg = (TextView) findViewById(d.g.text);
        this.bmi = (BdSwitchView) findViewById(d.g.button);
        this.bmi.setFocusable(true);
        this.bmh = (TextView) findViewById(d.g.tip);
        if (this.bmh != null) {
            this.bmh.setVisibility(8);
        }
        setTag(this.bmi);
        this.bmf.setClickable(false);
        this.bmf.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.bmh != null && string2 != null) {
            this.bmh.setVisibility(0);
            this.bmh.setText(string2);
            if (color2 > -1) {
                this.bmh.setTextColor(color2);
            }
        }
        if (string != null) {
            this.bmg.setText(string);
        }
        if (color > -1) {
            this.bmg.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.bmg.setTextSize(0, dimension);
        }
        this.bmf.setClickable(false);
        this.bmf.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.bmh != null) {
            displayTip();
            this.bmh.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.bmh != null) {
            displayTip();
            this.bmh.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.bmh != null) {
            this.bmh.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.bmh != null) {
            this.bmh.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.bmg.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmg.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.bmg.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.bmi;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.bmi = bdSwitchView;
    }
}
