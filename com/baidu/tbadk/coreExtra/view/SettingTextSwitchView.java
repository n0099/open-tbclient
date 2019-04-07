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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private TextView ahN;
    private LinearLayout ceG;
    protected TextView ceH;
    private BdSwitchView ceI;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        akn();
        c(attributeSet);
        jf(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        akn();
        jf(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        akn();
        c(attributeSet);
        jf(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.ceG;
    }

    public void jf(int i) {
        this.ceI.setBackgroundRes(al.hp(d.f.bg_switch_open), al.hp(d.f.bg_switch_close), al.hp(d.f.btn_handle));
        al.d(this.ahN, d.C0277d.cp_cont_b, 1);
        if (this.ceH != null) {
            al.d(this.ceH, d.C0277d.cp_cont_d, 1);
        }
    }

    public void ob() {
        this.ceI.ob();
        this.ceI.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void oa() {
        this.ceI.oa();
        this.ceI.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void at(boolean z) {
        this.ceI.at(z);
        this.ceI.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void as(boolean z) {
        this.ceI.as(z);
        this.ceI.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.ahN.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ceI.setOnSwitchStateChangeListener(aVar);
    }

    private void akn() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.ceG = (LinearLayout) findViewById(d.g.container);
        this.ahN = (TextView) findViewById(d.g.text);
        this.ceI = (BdSwitchView) findViewById(d.g.button);
        this.ceI.setFocusable(true);
        this.ceH = (TextView) findViewById(d.g.tip);
        if (this.ceH != null) {
            this.ceH.setVisibility(8);
        }
        setTag(this.ceI);
        this.ceG.setClickable(false);
        this.ceG.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.ceH != null && string2 != null) {
            this.ceH.setVisibility(0);
            this.ceH.setText(string2);
            if (color2 > -1) {
                this.ceH.setTextColor(color2);
            }
        }
        if (string != null) {
            this.ahN.setText(string);
        }
        if (color > -1) {
            this.ahN.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.ahN.setTextSize(0, dimension);
        }
        this.ceG.setClickable(false);
        this.ceG.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.ceH != null) {
            displayTip();
            this.ceH.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.ceH != null) {
            displayTip();
            this.ceH.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.ceH != null) {
            this.ceH.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.ceH != null) {
            this.ceH.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.ahN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahN.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.ahN.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.ceI;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.ceI = bdSwitchView;
    }
}
