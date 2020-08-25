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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout eHv;
    protected TextView eHw;
    private BdSwitchView eHx;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bpY();
        e(attributeSet);
        pT(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        bpY();
        pT(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        bpY();
        e(attributeSet);
        pT(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.eHv;
    }

    public void pT(int i) {
        this.eHx.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        if (this.eHw != null) {
            ap.setViewTextColor(this.eHw, R.color.cp_cont_d, 1);
        }
    }

    public void turnOff() {
        this.eHx.turnOff();
        this.eHx.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn() {
        this.eHx.turnOn();
        this.eHx.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void turnOff(boolean z) {
        this.eHx.turnOff(z);
        this.eHx.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.eHx.turnOn(z);
        this.eHx.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.eHx.setOnSwitchStateChangeListener(aVar);
    }

    private void bpY() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.eHv = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.eHx = (BdSwitchView) findViewById(R.id.button);
        this.eHx.setFocusable(true);
        this.eHw = (TextView) findViewById(R.id.tip);
        if (this.eHw != null) {
            this.eHw.setVisibility(8);
        }
        setTag(this.eHx);
        this.eHv.setClickable(false);
        this.eHv.setFocusable(false);
    }

    private void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTipColor, -1);
        if (this.eHw != null && string2 != null) {
            this.eHw.setVisibility(0);
            this.eHw.setText(string2);
            if (color2 > -1) {
                this.eHw.setTextColor(color2);
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
        this.eHv.setClickable(false);
        this.eHv.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.eHw != null) {
            displayTip();
            this.eHw.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.eHw != null) {
            displayTip();
            this.eHw.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.eHw != null) {
            this.eHw.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.eHw != null) {
            this.eHw.setVisibility(8);
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
        return this.eHx;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.eHx = bdSwitchView;
    }
}
