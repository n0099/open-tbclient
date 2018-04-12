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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout ayZ;
    private TextView aza;
    protected TextView azb;
    private BdSwitchView azc;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Cb();
        c(attributeSet);
        eq(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Cb();
        eq(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Cb();
        c(attributeSet);
        eq(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.ayZ;
    }

    public void eq(int i) {
        this.azc.setBackgroundRes(ak.cO(d.f.bg_switch_open), ak.cO(d.f.bg_switch_close), ak.cO(d.f.btn_handle));
        ak.c(this.aza, d.C0126d.cp_cont_b, 1);
        if (this.azb != null) {
            ak.c(this.azb, d.C0126d.cp_cont_d, 1);
        }
    }

    public void jP() {
        this.azc.jP();
        this.azc.setContentDescription(this.mContext.getString(d.k.talk_message_tip) + this.mContext.getString(d.k.talk_close));
    }

    public void jO() {
        this.azc.jO();
        this.azc.setContentDescription(this.mContext.getString(d.k.talk_message_tip) + this.mContext.getString(d.k.talk_open));
    }

    public void U(boolean z) {
        this.azc.U(z);
        this.azc.setContentDescription(this.mContext.getString(d.k.talk_message_tip) + this.mContext.getString(d.k.talk_close));
    }

    public void T(boolean z) {
        this.azc.T(z);
        this.azc.setContentDescription(this.mContext.getString(d.k.talk_message_tip) + this.mContext.getString(d.k.talk_open));
    }

    public void setText(String str) {
        this.aza.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.azc.setOnSwitchStateChangeListener(aVar);
    }

    private void Cb() {
        LayoutInflater.from(this.mContext).inflate(d.i.setting_text_switch_view, (ViewGroup) this, true);
        this.ayZ = (LinearLayout) findViewById(d.g.container);
        this.aza = (TextView) findViewById(d.g.text);
        this.azc = (BdSwitchView) findViewById(d.g.button);
        this.azc.setFocusable(true);
        this.azb = (TextView) findViewById(d.g.tip);
        if (this.azb != null) {
            this.azb.setVisibility(8);
        }
        setTag(this.azc);
        this.ayZ.setClickable(false);
        this.ayZ.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(d.m.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(d.m.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTipColor, -1);
        if (this.azb != null && string2 != null) {
            this.azb.setVisibility(0);
            this.azb.setText(string2);
            if (color2 > -1) {
                this.azb.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aza.setText(string);
        }
        if (color > -1) {
            this.aza.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aza.setTextSize(0, dimension);
        }
        this.ayZ.setClickable(false);
        this.ayZ.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.azb != null) {
            displayTip();
            this.azb.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.azb != null) {
            displayTip();
            this.azb.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.azb != null) {
            this.azb.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.azb != null) {
            this.azb.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aza.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aza.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aza.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.azc;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.azc = bdSwitchView;
    }
}
