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
    private LinearLayout aHv;
    private TextView aHw;
    protected TextView aHx;
    private BdSwitchView aHy;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        FC();
        c(attributeSet);
        eu(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        FC();
        eu(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        FC();
        c(attributeSet);
        eu(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.aHv;
    }

    public void eu(int i) {
        this.aHy.setBackgroundRes(al.cQ(d.f.bg_switch_open), al.cQ(d.f.bg_switch_close), al.cQ(d.f.btn_handle));
        al.c(this.aHw, d.C0141d.cp_cont_b, 1);
        if (this.aHx != null) {
            al.c(this.aHx, d.C0141d.cp_cont_d, 1);
        }
    }

    public void mD() {
        this.aHy.mD();
        this.aHy.setContentDescription(this.mContext.getString(d.k.talk_message_tip) + this.mContext.getString(d.k.talk_close));
    }

    public void mC() {
        this.aHy.mC();
        this.aHy.setContentDescription(this.mContext.getString(d.k.talk_message_tip) + this.mContext.getString(d.k.talk_open));
    }

    public void W(boolean z) {
        this.aHy.W(z);
        this.aHy.setContentDescription(this.mContext.getString(d.k.talk_message_tip) + this.mContext.getString(d.k.talk_close));
    }

    public void V(boolean z) {
        this.aHy.V(z);
        this.aHy.setContentDescription(this.mContext.getString(d.k.talk_message_tip) + this.mContext.getString(d.k.talk_open));
    }

    public void setText(String str) {
        this.aHw.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aHy.setOnSwitchStateChangeListener(aVar);
    }

    private void FC() {
        LayoutInflater.from(this.mContext).inflate(d.i.setting_text_switch_view, (ViewGroup) this, true);
        this.aHv = (LinearLayout) findViewById(d.g.container);
        this.aHw = (TextView) findViewById(d.g.text);
        this.aHy = (BdSwitchView) findViewById(d.g.button);
        this.aHy.setFocusable(true);
        this.aHx = (TextView) findViewById(d.g.tip);
        if (this.aHx != null) {
            this.aHx.setVisibility(8);
        }
        setTag(this.aHy);
        this.aHv.setClickable(false);
        this.aHv.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.m.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.m.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTipColor, -1);
        if (this.aHx != null && string2 != null) {
            this.aHx.setVisibility(0);
            this.aHx.setText(string2);
            if (color2 > -1) {
                this.aHx.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aHw.setText(string);
        }
        if (color > -1) {
            this.aHw.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aHw.setTextSize(0, dimension);
        }
        this.aHv.setClickable(false);
        this.aHv.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aHx != null) {
            displayTip();
            this.aHx.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aHx != null) {
            displayTip();
            this.aHx.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aHx != null) {
            this.aHx.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aHx != null) {
            this.aHx.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aHw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aHw.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aHw.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aHy;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aHy = bdSwitchView;
    }
}
