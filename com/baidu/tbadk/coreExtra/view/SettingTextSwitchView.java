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
    private LinearLayout boK;
    private TextView boL;
    protected TextView boM;
    private BdSwitchView boN;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Jv();
        d(attributeSet);
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Jv();
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Jv();
        d(attributeSet);
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.boK;
    }

    public void hr(int i) {
        this.boN.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        aj.e(this.boL, d.C0140d.cp_cont_b, 1);
        if (this.boM != null) {
            aj.e(this.boM, d.C0140d.cp_cont_d, 1);
        }
    }

    public void rK() {
        this.boN.rK();
        this.boN.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void rJ() {
        this.boN.rJ();
        this.boN.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void aB(boolean z) {
        this.boN.aB(z);
        this.boN.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void aA(boolean z) {
        this.boN.aA(z);
        this.boN.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.boL.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.boN.setOnSwitchStateChangeListener(aVar);
    }

    private void Jv() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.boK = (LinearLayout) findViewById(d.g.container);
        this.boL = (TextView) findViewById(d.g.text);
        this.boN = (BdSwitchView) findViewById(d.g.button);
        this.boN.setFocusable(true);
        this.boM = (TextView) findViewById(d.g.tip);
        if (this.boM != null) {
            this.boM.setVisibility(8);
        }
        setTag(this.boN);
        this.boK.setClickable(false);
        this.boK.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.boM != null && string2 != null) {
            this.boM.setVisibility(0);
            this.boM.setText(string2);
            if (color2 > -1) {
                this.boM.setTextColor(color2);
            }
        }
        if (string != null) {
            this.boL.setText(string);
        }
        if (color > -1) {
            this.boL.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.boL.setTextSize(0, dimension);
        }
        this.boK.setClickable(false);
        this.boK.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.boM != null) {
            displayTip();
            this.boM.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.boM != null) {
            displayTip();
            this.boM.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.boM != null) {
            this.boM.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.boM != null) {
            this.boM.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.boL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boL.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.boL.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.boN;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.boN = bdSwitchView;
    }
}
