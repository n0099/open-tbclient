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
    private LinearLayout aVi;
    protected TextView aVj;
    private BdSwitchView aVk;
    private TextView ajh;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        KN();
        c(attributeSet);
        fv(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        KN();
        fv(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        KN();
        c(attributeSet);
        fv(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.aVi;
    }

    public void fv(int i) {
        this.aVk.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        al.c(this.ajh, e.d.cp_cont_b, 1);
        if (this.aVj != null) {
            al.c(this.aVj, e.d.cp_cont_d, 1);
        }
    }

    public void nW() {
        this.aVk.nW();
        this.aVk.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_close));
    }

    public void nV() {
        this.aVk.nV();
        this.aVk.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_open));
    }

    public void as(boolean z) {
        this.aVk.as(z);
        this.aVk.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_close));
    }

    public void ar(boolean z) {
        this.aVk.ar(z);
        this.aVk.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_open));
    }

    public void setText(String str) {
        this.ajh.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aVk.setOnSwitchStateChangeListener(aVar);
    }

    private void KN() {
        LayoutInflater.from(this.mContext).inflate(e.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aVi = (LinearLayout) findViewById(e.g.container);
        this.ajh = (TextView) findViewById(e.g.text);
        this.aVk = (BdSwitchView) findViewById(e.g.button);
        this.aVk.setFocusable(true);
        this.aVj = (TextView) findViewById(e.g.tip);
        if (this.aVj != null) {
            this.aVj.setVisibility(8);
        }
        setTag(this.aVk);
        this.aVi.setClickable(false);
        this.aVi.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(e.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTipColor, -1);
        if (this.aVj != null && string2 != null) {
            this.aVj.setVisibility(0);
            this.aVj.setText(string2);
            if (color2 > -1) {
                this.aVj.setTextColor(color2);
            }
        }
        if (string != null) {
            this.ajh.setText(string);
        }
        if (color > -1) {
            this.ajh.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.ajh.setTextSize(0, dimension);
        }
        this.aVi.setClickable(false);
        this.aVi.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aVj != null) {
            displayTip();
            this.aVj.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aVj != null) {
            displayTip();
            this.aVj.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aVj != null) {
            this.aVj.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aVj != null) {
            this.aVj.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.ajh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajh.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.ajh.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aVk;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aVk = bdSwitchView;
    }
}
