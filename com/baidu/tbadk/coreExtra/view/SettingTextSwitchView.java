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
    private LinearLayout bmw;
    private TextView bmx;
    protected TextView bmy;
    private BdSwitchView bmz;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        IP();
        d(attributeSet);
        hs(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        IP();
        hs(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        IP();
        d(attributeSet);
        hs(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.bmw;
    }

    public void hs(int i) {
        this.bmz.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        aj.e(this.bmx, d.C0108d.cp_cont_b, 1);
        if (this.bmy != null) {
            aj.e(this.bmy, d.C0108d.cp_cont_d, 1);
        }
    }

    public void rM() {
        this.bmz.rM();
        this.bmz.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void rL() {
        this.bmz.rL();
        this.bmz.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void ay(boolean z) {
        this.bmz.ay(z);
        this.bmz.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void ax(boolean z) {
        this.bmz.ax(z);
        this.bmz.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.bmx.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.bmz.setOnSwitchStateChangeListener(aVar);
    }

    private void IP() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.bmw = (LinearLayout) findViewById(d.g.container);
        this.bmx = (TextView) findViewById(d.g.text);
        this.bmz = (BdSwitchView) findViewById(d.g.button);
        this.bmz.setFocusable(true);
        this.bmy = (TextView) findViewById(d.g.tip);
        if (this.bmy != null) {
            this.bmy.setVisibility(8);
        }
        setTag(this.bmz);
        this.bmw.setClickable(false);
        this.bmw.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.bmy != null && string2 != null) {
            this.bmy.setVisibility(0);
            this.bmy.setText(string2);
            if (color2 > -1) {
                this.bmy.setTextColor(color2);
            }
        }
        if (string != null) {
            this.bmx.setText(string);
        }
        if (color > -1) {
            this.bmx.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.bmx.setTextSize(0, dimension);
        }
        this.bmw.setClickable(false);
        this.bmw.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.bmy != null) {
            displayTip();
            this.bmy.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.bmy != null) {
            displayTip();
            this.bmy.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.bmy != null) {
            this.bmy.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.bmy != null) {
            this.bmy.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.bmx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmx.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.bmx.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.bmz;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.bmz = bdSwitchView;
    }
}
