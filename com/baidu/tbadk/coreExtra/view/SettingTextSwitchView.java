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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout dTK;
    protected TextView dTL;
    private BdSwitchView dTM;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aVr();
        e(attributeSet);
        ms(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        aVr();
        ms(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        aVr();
        e(attributeSet);
        ms(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.dTK;
    }

    public void ms(int i) {
        this.dTM.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        if (this.dTL != null) {
            am.setViewTextColor(this.dTL, R.color.cp_cont_d, 1);
        }
    }

    public void turnOff() {
        this.dTM.turnOff();
        this.dTM.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn() {
        this.dTM.turnOn();
        this.dTM.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void turnOff(boolean z) {
        this.dTM.turnOff(z);
        this.dTM.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.dTM.turnOn(z);
        this.dTM.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.dTM.setOnSwitchStateChangeListener(aVar);
    }

    private void aVr() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.dTK = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.dTM = (BdSwitchView) findViewById(R.id.button);
        this.dTM.setFocusable(true);
        this.dTL = (TextView) findViewById(R.id.tip);
        if (this.dTL != null) {
            this.dTL.setVisibility(8);
        }
        setTag(this.dTM);
        this.dTK.setClickable(false);
        this.dTK.setFocusable(false);
    }

    private void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        float dimension = obtainStyledAttributes.getDimension(0, -1.0f);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.dTL != null && string2 != null) {
            this.dTL.setVisibility(0);
            this.dTL.setText(string2);
            if (color2 > -1) {
                this.dTL.setTextColor(color2);
            }
        }
        if (string != null) {
            this.textView.setText(string);
        }
        if (color > -1) {
            this.textView.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.textView.setTextSize(0, dimension);
        }
        this.dTK.setClickable(false);
        this.dTK.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.dTL != null) {
            displayTip();
            this.dTL.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.dTL != null) {
            displayTip();
            this.dTL.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.dTL != null) {
            this.dTL.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.dTL != null) {
            this.dTL.setVisibility(8);
        }
    }

    public void setTextLeftMargin(int i) {
        if (this.textView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(i);
            this.textView.setLayoutParams(layoutParams);
        }
    }

    public BdSwitchView getSwitchView() {
        return this.dTM;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.dTM = bdSwitchView;
    }
}
