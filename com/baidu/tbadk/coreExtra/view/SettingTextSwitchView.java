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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout aQY;
    private TextView aQZ;
    protected TextView aRa;
    private BdSwitchView aRb;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Jt();
        c(attributeSet);
        fg(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Jt();
        fg(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Jt();
        c(attributeSet);
        fg(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.aQY;
    }

    public void fg(int i) {
        this.aRb.setBackgroundRes(al.dA(e.f.bg_switch_open), al.dA(e.f.bg_switch_close), al.dA(e.f.btn_handle));
        al.c(this.aQZ, e.d.cp_cont_b, 1);
        if (this.aRa != null) {
            al.c(this.aRa, e.d.cp_cont_d, 1);
        }
    }

    public void nT() {
        this.aRb.nT();
        this.aRb.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_close));
    }

    public void nS() {
        this.aRb.nS();
        this.aRb.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_open));
    }

    public void as(boolean z) {
        this.aRb.as(z);
        this.aRb.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_close));
    }

    public void ar(boolean z) {
        this.aRb.ar(z);
        this.aRb.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_open));
    }

    public void setText(String str) {
        this.aQZ.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aRb.setOnSwitchStateChangeListener(aVar);
    }

    private void Jt() {
        LayoutInflater.from(this.mContext).inflate(e.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aQY = (LinearLayout) findViewById(e.g.container);
        this.aQZ = (TextView) findViewById(e.g.text);
        this.aRb = (BdSwitchView) findViewById(e.g.button);
        this.aRb.setFocusable(true);
        this.aRa = (TextView) findViewById(e.g.tip);
        if (this.aRa != null) {
            this.aRa.setVisibility(8);
        }
        setTag(this.aRb);
        this.aQY.setClickable(false);
        this.aQY.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(e.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTipColor, -1);
        if (this.aRa != null && string2 != null) {
            this.aRa.setVisibility(0);
            this.aRa.setText(string2);
            if (color2 > -1) {
                this.aRa.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aQZ.setText(string);
        }
        if (color > -1) {
            this.aQZ.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aQZ.setTextSize(0, dimension);
        }
        this.aQY.setClickable(false);
        this.aQY.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aRa != null) {
            displayTip();
            this.aRa.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aRa != null) {
            displayTip();
            this.aRa.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aRa != null) {
            this.aRa.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aRa != null) {
            this.aRa.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aQZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aQZ.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aQZ.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aRb;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aRb = bdSwitchView;
    }
}
