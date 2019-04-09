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
    private TextView ahO;
    private LinearLayout ceH;
    protected TextView ceI;
    private BdSwitchView ceJ;
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
        return this.ceH;
    }

    public void jf(int i) {
        this.ceJ.setBackgroundRes(al.hp(d.f.bg_switch_open), al.hp(d.f.bg_switch_close), al.hp(d.f.btn_handle));
        al.d(this.ahO, d.C0277d.cp_cont_b, 1);
        if (this.ceI != null) {
            al.d(this.ceI, d.C0277d.cp_cont_d, 1);
        }
    }

    public void ob() {
        this.ceJ.ob();
        this.ceJ.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void oa() {
        this.ceJ.oa();
        this.ceJ.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void at(boolean z) {
        this.ceJ.at(z);
        this.ceJ.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void as(boolean z) {
        this.ceJ.as(z);
        this.ceJ.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.ahO.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ceJ.setOnSwitchStateChangeListener(aVar);
    }

    private void akn() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.ceH = (LinearLayout) findViewById(d.g.container);
        this.ahO = (TextView) findViewById(d.g.text);
        this.ceJ = (BdSwitchView) findViewById(d.g.button);
        this.ceJ.setFocusable(true);
        this.ceI = (TextView) findViewById(d.g.tip);
        if (this.ceI != null) {
            this.ceI.setVisibility(8);
        }
        setTag(this.ceJ);
        this.ceH.setClickable(false);
        this.ceH.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.ceI != null && string2 != null) {
            this.ceI.setVisibility(0);
            this.ceI.setText(string2);
            if (color2 > -1) {
                this.ceI.setTextColor(color2);
            }
        }
        if (string != null) {
            this.ahO.setText(string);
        }
        if (color > -1) {
            this.ahO.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.ahO.setTextSize(0, dimension);
        }
        this.ceH.setClickable(false);
        this.ceH.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.ceI != null) {
            displayTip();
            this.ceI.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.ceI != null) {
            displayTip();
            this.ceI.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.ceI != null) {
            this.ceI.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.ceI != null) {
            this.ceI.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.ahO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahO.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.ahO.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.ceJ;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.ceJ = bdSwitchView;
    }
}
