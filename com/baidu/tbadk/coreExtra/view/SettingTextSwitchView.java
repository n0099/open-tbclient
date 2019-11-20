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
    private LinearLayout cBh;
    protected TextView cBi;
    private BdSwitchView cBj;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        asB();
        c(attributeSet);
        jz(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        asB();
        jz(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        asB();
        c(attributeSet);
        jz(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.cBh;
    }

    public void jz(int i) {
        this.cBj.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        if (this.cBi != null) {
            am.setViewTextColor(this.cBi, R.color.cp_cont_d, 1);
        }
    }

    public void turnOff() {
        this.cBj.turnOff();
        this.cBj.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn() {
        this.cBj.turnOn();
        this.cBj.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void turnOff(boolean z) {
        this.cBj.turnOff(z);
        this.cBj.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.cBj.turnOn(z);
        this.cBj.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.cBj.setOnSwitchStateChangeListener(aVar);
    }

    private void asB() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.cBh = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.cBj = (BdSwitchView) findViewById(R.id.button);
        this.cBj.setFocusable(true);
        this.cBi = (TextView) findViewById(R.id.tip);
        if (this.cBi != null) {
            this.cBi.setVisibility(8);
        }
        setTag(this.cBj);
        this.cBh.setClickable(false);
        this.cBh.setFocusable(false);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        float dimension = obtainStyledAttributes.getDimension(0, -1.0f);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.cBi != null && string2 != null) {
            this.cBi.setVisibility(0);
            this.cBi.setText(string2);
            if (color2 > -1) {
                this.cBi.setTextColor(color2);
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
        this.cBh.setClickable(false);
        this.cBh.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.cBi != null) {
            displayTip();
            this.cBi.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.cBi != null) {
            displayTip();
            this.cBi.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.cBi != null) {
            this.cBi.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.cBi != null) {
            this.cBi.setVisibility(8);
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
        return this.cBj;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.cBj = bdSwitchView;
    }
}
