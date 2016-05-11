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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout amf;
    private TextView amg;
    protected TextView amh;
    private BdSwitchView ami;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zH();
        d(attributeSet);
        dS(TbadkCoreApplication.m11getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        zH();
        dS(TbadkCoreApplication.m11getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        zH();
        d(attributeSet);
        dS(TbadkCoreApplication.m11getInst().getSkinType());
    }

    public View getView() {
        return this.amf;
    }

    public void dS(int i) {
        this.ami.a(at.cA(t.f.bg_switch_open), at.cA(t.f.bg_switch_close), at.cA(t.f.btn_handle));
        at.c(this.amg, t.d.cp_cont_b, 1);
        if (this.amh != null) {
            at.c(this.amh, t.d.cp_cont_d, 1);
        }
    }

    public void iz() {
        this.ami.iz();
        this.ami.setContentDescription(String.valueOf(this.mContext.getString(t.j.talk_message_tip)) + this.mContext.getString(t.j.talk_close));
    }

    public void iy() {
        this.ami.iy();
        this.ami.setContentDescription(String.valueOf(this.mContext.getString(t.j.talk_message_tip)) + this.mContext.getString(t.j.talk_open));
    }

    public void L(boolean z) {
        this.ami.L(z);
        this.ami.setContentDescription(String.valueOf(this.mContext.getString(t.j.talk_message_tip)) + this.mContext.getString(t.j.talk_close));
    }

    public void K(boolean z) {
        this.ami.K(z);
        this.ami.setContentDescription(String.valueOf(this.mContext.getString(t.j.talk_message_tip)) + this.mContext.getString(t.j.talk_open));
    }

    public void setText(String str) {
        this.amg.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ami.setOnSwitchStateChangeListener(aVar);
    }

    private void zH() {
        LayoutInflater.from(this.mContext).inflate(t.h.setting_text_switch_view, (ViewGroup) this, true);
        this.amf = (LinearLayout) findViewById(t.g.container);
        this.amg = (TextView) findViewById(t.g.text);
        this.ami = (BdSwitchView) findViewById(t.g.button);
        this.ami.setFocusable(true);
        this.amh = (TextView) findViewById(t.g.tip);
        if (this.amh != null) {
            this.amh.setVisibility(8);
        }
        setTag(this.ami);
        this.amf.setClickable(false);
        this.amf.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.amh != null && string2 != null) {
            this.amh.setVisibility(0);
            this.amh.setText(string2);
            if (color2 > -1) {
                this.amh.setTextColor(color2);
            }
        }
        if (string != null) {
            this.amg.setText(string);
        }
        if (color > -1) {
            this.amg.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.amg.setTextSize(0, dimension);
        }
        this.amf.setClickable(false);
        this.amf.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.amh != null) {
            displayTip();
            this.amh.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.amh != null) {
            displayTip();
            this.amh.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.amh != null) {
            this.amh.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.amh != null) {
            this.amh.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.amg.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amg.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.amg.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.ami;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.ami = bdSwitchView;
    }
}
