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
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private TextView aif;
    private LinearLayout cmO;
    protected TextView cmP;
    private BdSwitchView cmQ;
    private final Context mContext;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        apq();
        c(attributeSet);
        jT(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        apq();
        jT(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        apq();
        c(attributeSet);
        jT(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.cmO;
    }

    public void jT(int i) {
        this.cmQ.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        al.f(this.aif, R.color.cp_cont_b, 1);
        if (this.cmP != null) {
            al.f(this.cmP, R.color.cp_cont_d, 1);
        }
    }

    public void mW() {
        this.cmQ.mW();
        this.cmQ.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void mV() {
        this.cmQ.mV();
        this.cmQ.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void al(boolean z) {
        this.cmQ.al(z);
        this.cmQ.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void ak(boolean z) {
        this.cmQ.ak(z);
        this.cmQ.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.aif.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.cmQ.setOnSwitchStateChangeListener(aVar);
    }

    private void apq() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.cmO = (LinearLayout) findViewById(R.id.container);
        this.aif = (TextView) findViewById(R.id.text);
        this.cmQ = (BdSwitchView) findViewById(R.id.button);
        this.cmQ.setFocusable(true);
        this.cmP = (TextView) findViewById(R.id.tip);
        if (this.cmP != null) {
            this.cmP.setVisibility(8);
        }
        setTag(this.cmQ);
        this.cmO.setClickable(false);
        this.cmO.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, c.a.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        float dimension = obtainStyledAttributes.getDimension(0, -1.0f);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.cmP != null && string2 != null) {
            this.cmP.setVisibility(0);
            this.cmP.setText(string2);
            if (color2 > -1) {
                this.cmP.setTextColor(color2);
            }
        }
        if (string != null) {
            this.aif.setText(string);
        }
        if (color > -1) {
            this.aif.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.aif.setTextSize(0, dimension);
        }
        this.cmO.setClickable(false);
        this.cmO.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.cmP != null) {
            displayTip();
            this.cmP.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.cmP != null) {
            displayTip();
            this.cmP.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.cmP != null) {
            this.cmP.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.cmP != null) {
            this.cmP.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.aif.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aif.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.aif.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.cmQ;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.cmQ = bdSwitchView;
    }
}
