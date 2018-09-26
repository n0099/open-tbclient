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
    private LinearLayout aLG;
    private TextView aLH;
    protected TextView aLI;
    private BdSwitchView aLJ;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Hg();
        c(attributeSet);
        eJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Hg();
        eJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Hg();
        c(attributeSet);
        eJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.aLG;
    }

    public void eJ(int i) {
        this.aLJ.setBackgroundRes(al.dc(e.f.bg_switch_open), al.dc(e.f.bg_switch_close), al.dc(e.f.btn_handle));
        al.c(this.aLH, e.d.cp_cont_b, 1);
        if (this.aLI != null) {
            al.c(this.aLI, e.d.cp_cont_d, 1);
        }
    }

    public void nL() {
        this.aLJ.nL();
        this.aLJ.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_close));
    }

    public void nK() {
        this.aLJ.nK();
        this.aLJ.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_open));
    }

    public void af(boolean z) {
        this.aLJ.af(z);
        this.aLJ.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_close));
    }

    public void ae(boolean z) {
        this.aLJ.ae(z);
        this.aLJ.setContentDescription(this.mContext.getString(e.j.talk_message_tip) + this.mContext.getString(e.j.talk_open));
    }

    public void setText(String str) {
        this.aLH.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aLJ.setOnSwitchStateChangeListener(aVar);
    }

    private void Hg() {
        LayoutInflater.from(this.mContext).inflate(e.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aLG = (LinearLayout) findViewById(e.g.container);
        this.aLH = (TextView) findViewById(e.g.text);
        this.aLJ = (BdSwitchView) findViewById(e.g.button);
        this.aLJ.setFocusable(true);
        this.aLI = (TextView) findViewById(e.g.tip);
        if (this.aLI != null) {
            this.aLI.setVisibility(8);
        }
        setTag(this.aLJ);
        this.aLG.setClickable(false);
        this.aLG.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(e.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(e.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTipColor, -1);
        if (this.aLI != null && string2 != null) {
            this.aLI.setVisibility(0);
            this.aLI.setText(string2);
            if (color2 > -1) {
                this.aLI.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aLH.setText(string);
        }
        if (color > -1) {
            this.aLH.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aLH.setTextSize(0, dimension);
        }
        this.aLG.setClickable(false);
        this.aLG.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aLI != null) {
            displayTip();
            this.aLI.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aLI != null) {
            displayTip();
            this.aLI.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aLI != null) {
            this.aLI.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aLI != null) {
            this.aLI.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aLH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aLH.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aLH.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aLJ;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aLJ = bdSwitchView;
    }
}
