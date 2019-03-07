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
    private TextView ahH;
    private LinearLayout ceE;
    protected TextView ceF;
    private BdSwitchView ceG;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        akr();
        c(attributeSet);
        jg(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        akr();
        jg(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        akr();
        c(attributeSet);
        jg(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.ceE;
    }

    public void jg(int i) {
        this.ceG.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        al.d(this.ahH, d.C0236d.cp_cont_b, 1);
        if (this.ceF != null) {
            al.d(this.ceF, d.C0236d.cp_cont_d, 1);
        }
    }

    public void ob() {
        this.ceG.ob();
        this.ceG.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void oa() {
        this.ceG.oa();
        this.ceG.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void at(boolean z) {
        this.ceG.at(z);
        this.ceG.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void as(boolean z) {
        this.ceG.as(z);
        this.ceG.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.ahH.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ceG.setOnSwitchStateChangeListener(aVar);
    }

    private void akr() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.ceE = (LinearLayout) findViewById(d.g.container);
        this.ahH = (TextView) findViewById(d.g.text);
        this.ceG = (BdSwitchView) findViewById(d.g.button);
        this.ceG.setFocusable(true);
        this.ceF = (TextView) findViewById(d.g.tip);
        if (this.ceF != null) {
            this.ceF.setVisibility(8);
        }
        setTag(this.ceG);
        this.ceE.setClickable(false);
        this.ceE.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.ceF != null && string2 != null) {
            this.ceF.setVisibility(0);
            this.ceF.setText(string2);
            if (color2 > -1) {
                this.ceF.setTextColor(color2);
            }
        }
        if (string != null) {
            this.ahH.setText(string);
        }
        if (color > -1) {
            this.ahH.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.ahH.setTextSize(0, dimension);
        }
        this.ceE.setClickable(false);
        this.ceE.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.ceF != null) {
            displayTip();
            this.ceF.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.ceF != null) {
            displayTip();
            this.ceF.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.ceF != null) {
            this.ceF.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.ceF != null) {
            this.ceF.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.ahH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahH.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.ahH.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.ceG;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.ceG = bdSwitchView;
    }
}
