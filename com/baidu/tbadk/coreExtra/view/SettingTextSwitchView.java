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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout aqH;
    private TextView aqI;
    protected TextView aqJ;
    private BdSwitchView aqK;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Bc();
        d(attributeSet);
        eh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        Bc();
        eh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        Bc();
        d(attributeSet);
        eh(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public View getView() {
        return this.aqH;
    }

    public void eh(int i) {
        this.aqK.a(av.cN(t.f.bg_switch_open), av.cN(t.f.bg_switch_close), av.cN(t.f.btn_handle));
        av.c(this.aqI, t.d.cp_cont_b, 1);
        if (this.aqJ != null) {
            av.c(this.aqJ, t.d.cp_cont_d, 1);
        }
    }

    public void jw() {
        this.aqK.jw();
        this.aqK.setContentDescription(String.valueOf(this.mContext.getString(t.j.talk_message_tip)) + this.mContext.getString(t.j.talk_close));
    }

    public void jv() {
        this.aqK.jv();
        this.aqK.setContentDescription(String.valueOf(this.mContext.getString(t.j.talk_message_tip)) + this.mContext.getString(t.j.talk_open));
    }

    public void P(boolean z) {
        this.aqK.P(z);
        this.aqK.setContentDescription(String.valueOf(this.mContext.getString(t.j.talk_message_tip)) + this.mContext.getString(t.j.talk_close));
    }

    public void O(boolean z) {
        this.aqK.O(z);
        this.aqK.setContentDescription(String.valueOf(this.mContext.getString(t.j.talk_message_tip)) + this.mContext.getString(t.j.talk_open));
    }

    public void setText(String str) {
        this.aqI.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.aqK.setOnSwitchStateChangeListener(aVar);
    }

    private void Bc() {
        LayoutInflater.from(this.mContext).inflate(t.h.setting_text_switch_view, (ViewGroup) this, true);
        this.aqH = (LinearLayout) findViewById(t.g.container);
        this.aqI = (TextView) findViewById(t.g.text);
        this.aqK = (BdSwitchView) findViewById(t.g.button);
        this.aqK.setFocusable(true);
        this.aqJ = (TextView) findViewById(t.g.tip);
        if (this.aqJ != null) {
            this.aqJ.setVisibility(8);
        }
        setTag(this.aqK);
        this.aqH.setClickable(false);
        this.aqH.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, t.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.aqJ != null && string2 != null) {
            this.aqJ.setVisibility(0);
            this.aqJ.setText(string2);
            if (color2 > -1) {
                this.aqJ.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aqI.setText(string);
        }
        if (color > -1) {
            this.aqI.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aqI.setTextSize(0, dimension);
        }
        this.aqH.setClickable(false);
        this.aqH.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.aqJ != null) {
            displayTip();
            this.aqJ.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.aqJ != null) {
            displayTip();
            this.aqJ.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.aqJ != null) {
            this.aqJ.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.aqJ != null) {
            this.aqJ.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aqI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqI.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aqI.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.aqK;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.aqK = bdSwitchView;
    }
}
