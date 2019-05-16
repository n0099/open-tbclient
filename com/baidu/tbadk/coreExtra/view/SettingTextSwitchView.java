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
    private LinearLayout cmN;
    protected TextView cmO;
    private BdSwitchView cmP;
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
        return this.cmN;
    }

    public void jT(int i) {
        this.cmP.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        al.f(this.aif, R.color.cp_cont_b, 1);
        if (this.cmO != null) {
            al.f(this.cmO, R.color.cp_cont_d, 1);
        }
    }

    public void mW() {
        this.cmP.mW();
        this.cmP.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void mV() {
        this.cmP.mV();
        this.cmP.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void al(boolean z) {
        this.cmP.al(z);
        this.cmP.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void ak(boolean z) {
        this.cmP.ak(z);
        this.cmP.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.aif.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.cmP.setOnSwitchStateChangeListener(aVar);
    }

    private void apq() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.cmN = (LinearLayout) findViewById(R.id.container);
        this.aif = (TextView) findViewById(R.id.text);
        this.cmP = (BdSwitchView) findViewById(R.id.button);
        this.cmP.setFocusable(true);
        this.cmO = (TextView) findViewById(R.id.tip);
        if (this.cmO != null) {
            this.cmO.setVisibility(8);
        }
        setTag(this.cmP);
        this.cmN.setClickable(false);
        this.cmN.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, c.a.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        float dimension = obtainStyledAttributes.getDimension(0, -1.0f);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.cmO != null && string2 != null) {
            this.cmO.setVisibility(0);
            this.cmO.setText(string2);
            if (color2 > -1) {
                this.cmO.setTextColor(color2);
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
        this.cmN.setClickable(false);
        this.cmN.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.cmO != null) {
            displayTip();
            this.cmO.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.cmO != null) {
            displayTip();
            this.cmO.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.cmO != null) {
            this.cmO.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.cmO != null) {
            this.cmO.setVisibility(8);
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
        return this.cmP;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.cmP = bdSwitchView;
    }
}
