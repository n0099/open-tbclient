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
    private LinearLayout dTF;
    protected TextView dTG;
    private BdSwitchView dTH;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aVt();
        e(attributeSet);
        ms(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        aVt();
        ms(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        aVt();
        e(attributeSet);
        ms(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.dTF;
    }

    public void ms(int i) {
        this.dTH.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        if (this.dTG != null) {
            am.setViewTextColor(this.dTG, R.color.cp_cont_d, 1);
        }
    }

    public void turnOff() {
        this.dTH.turnOff();
        this.dTH.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn() {
        this.dTH.turnOn();
        this.dTH.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void turnOff(boolean z) {
        this.dTH.turnOff(z);
        this.dTH.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.dTH.turnOn(z);
        this.dTH.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.dTH.setOnSwitchStateChangeListener(aVar);
    }

    private void aVt() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.dTF = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.dTH = (BdSwitchView) findViewById(R.id.button);
        this.dTH.setFocusable(true);
        this.dTG = (TextView) findViewById(R.id.tip);
        if (this.dTG != null) {
            this.dTG.setVisibility(8);
        }
        setTag(this.dTH);
        this.dTF.setClickable(false);
        this.dTF.setFocusable(false);
    }

    private void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        float dimension = obtainStyledAttributes.getDimension(0, -1.0f);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.dTG != null && string2 != null) {
            this.dTG.setVisibility(0);
            this.dTG.setText(string2);
            if (color2 > -1) {
                this.dTG.setTextColor(color2);
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
        this.dTF.setClickable(false);
        this.dTF.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.dTG != null) {
            displayTip();
            this.dTG.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.dTG != null) {
            displayTip();
            this.dTG.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.dTG != null) {
            this.dTG.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.dTG != null) {
            this.dTG.setVisibility(8);
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
        return this.dTH;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.dTH = bdSwitchView;
    }
}
