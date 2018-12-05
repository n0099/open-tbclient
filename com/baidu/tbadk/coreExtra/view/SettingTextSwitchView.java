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
    private LinearLayout aUx;
    protected TextView aUy;
    private BdSwitchView aUz;
    private TextView aiY;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Kx();
        c(attributeSet);
        fu(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Kx();
        fu(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Kx();
        c(attributeSet);
        fu(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.aUx;
    }

    public void fu(int i) {
        this.aUz.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        al.c(this.aiY, e.d.cp_cont_b, 1);
        if (this.aUy != null) {
            al.c(this.aUy, e.d.cp_cont_d, 1);
        }
    }

    public void nS() {
        this.aUz.nS();
        this.aUz.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_close));
    }

    public void nR() {
        this.aUz.nR();
        this.aUz.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_open));
    }

    public void as(boolean z) {
        this.aUz.as(z);
        this.aUz.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_close));
    }

    public void ar(boolean z) {
        this.aUz.ar(z);
        this.aUz.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_open));
    }

    public void setText(String str) {
        this.aiY.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aUz.setOnSwitchStateChangeListener(aVar);
    }

    private void Kx() {
        LayoutInflater.from(this.mContext).inflate(e.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aUx = (LinearLayout) findViewById(e.g.container);
        this.aiY = (TextView) findViewById(e.g.text);
        this.aUz = (BdSwitchView) findViewById(e.g.button);
        this.aUz.setFocusable(true);
        this.aUy = (TextView) findViewById(e.g.tip);
        if (this.aUy != null) {
            this.aUy.setVisibility(8);
        }
        setTag(this.aUz);
        this.aUx.setClickable(false);
        this.aUx.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(e.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTipColor, -1);
        if (this.aUy != null && string2 != null) {
            this.aUy.setVisibility(0);
            this.aUy.setText(string2);
            if (color2 > -1) {
                this.aUy.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aiY.setText(string);
        }
        if (color > -1) {
            this.aiY.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aiY.setTextSize(0, dimension);
        }
        this.aUx.setClickable(false);
        this.aUx.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aUy != null) {
            displayTip();
            this.aUy.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aUy != null) {
            displayTip();
            this.aUy.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aUy != null) {
            this.aUy.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aUy != null) {
            this.aUy.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aiY.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiY.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aiY.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aUz;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aUz = bdSwitchView;
    }
}
