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
    private LinearLayout bmo;
    private TextView bmp;
    protected TextView bmq;
    private BdSwitchView bmr;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        IN();
        d(attributeSet);
        hs(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        IN();
        hs(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        IN();
        d(attributeSet);
        hs(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.bmo;
    }

    public void hs(int i) {
        this.bmr.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        aj.e(this.bmp, d.C0107d.cp_cont_b, 1);
        if (this.bmq != null) {
            aj.e(this.bmq, d.C0107d.cp_cont_d, 1);
        }
    }

    public void rL() {
        this.bmr.rL();
        this.bmr.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void rK() {
        this.bmr.rK();
        this.bmr.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void ax(boolean z) {
        this.bmr.ax(z);
        this.bmr.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_close));
    }

    public void aw(boolean z) {
        this.bmr.aw(z);
        this.bmr.setContentDescription(this.mContext.getString(d.j.talk_message_tip) + this.mContext.getString(d.j.talk_open));
    }

    public void setText(String str) {
        this.bmp.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.bmr.setOnSwitchStateChangeListener(aVar);
    }

    private void IN() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_switch_view, (ViewGroup) this, true);
        this.bmo = (LinearLayout) findViewById(d.g.container);
        this.bmp = (TextView) findViewById(d.g.text);
        this.bmr = (BdSwitchView) findViewById(d.g.button);
        this.bmr.setFocusable(true);
        this.bmq = (TextView) findViewById(d.g.tip);
        if (this.bmq != null) {
            this.bmq.setVisibility(8);
        }
        setTag(this.bmr);
        this.bmo.setClickable(false);
        this.bmo.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.l.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.l.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTipColor, -1);
        if (this.bmq != null && string2 != null) {
            this.bmq.setVisibility(0);
            this.bmq.setText(string2);
            if (color2 > -1) {
                this.bmq.setTextColor(color2);
            }
        }
        if (string != null) {
            this.bmp.setText(string);
        }
        if (color > -1) {
            this.bmp.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.bmp.setTextSize(0, dimension);
        }
        this.bmo.setClickable(false);
        this.bmo.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.bmq != null) {
            displayTip();
            this.bmq.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.bmq != null) {
            displayTip();
            this.bmq.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.bmq != null) {
            this.bmq.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.bmq != null) {
            this.bmq.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.bmp.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmp.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.bmp.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.bmr;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.bmr = bdSwitchView;
    }
}
