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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout ewV;
    protected TextView ewW;
    private BdSwitchView ewX;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bhm();
        e(attributeSet);
        nI(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        bhm();
        nI(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        bhm();
        e(attributeSet);
        nI(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.ewV;
    }

    public void nI(int i) {
        this.ewX.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        ao.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        if (this.ewW != null) {
            ao.setViewTextColor(this.ewW, R.color.cp_cont_d, 1);
        }
    }

    public void turnOff() {
        this.ewX.turnOff();
        this.ewX.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn() {
        this.ewX.turnOn();
        this.ewX.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void turnOff(boolean z) {
        this.ewX.turnOff(z);
        this.ewX.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.ewX.turnOn(z);
        this.ewX.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ewX.setOnSwitchStateChangeListener(aVar);
    }

    private void bhm() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.ewV = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.ewX = (BdSwitchView) findViewById(R.id.button);
        this.ewX.setFocusable(true);
        this.ewW = (TextView) findViewById(R.id.tip);
        if (this.ewW != null) {
            this.ewW.setVisibility(8);
        }
        setTag(this.ewX);
        this.ewV.setClickable(false);
        this.ewV.setFocusable(false);
    }

    private void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTipColor, -1);
        if (this.ewW != null && string2 != null) {
            this.ewW.setVisibility(0);
            this.ewW.setText(string2);
            if (color2 > -1) {
                this.ewW.setTextColor(color2);
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
        this.ewV.setClickable(false);
        this.ewV.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.ewW != null) {
            displayTip();
            this.ewW.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.ewW != null) {
            displayTip();
            this.ewW.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.ewW != null) {
            this.ewW.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.ewW != null) {
            this.ewW.setVisibility(8);
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
        return this.ewX;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.ewX = bdSwitchView;
    }
}
