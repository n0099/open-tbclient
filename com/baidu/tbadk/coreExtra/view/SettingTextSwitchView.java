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
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout eVN;
    protected TextView eVO;
    private BdSwitchView eVP;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        btD();
        e(attributeSet);
        qE(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        btD();
        qE(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        btD();
        e(attributeSet);
        qE(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.eVN;
    }

    public void qE(int i) {
        this.eVP.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        if (this.eVO != null) {
            ap.setViewTextColor(this.eVO, R.color.cp_cont_d, 1);
        }
    }

    public void turnOff() {
        this.eVP.turnOff();
        this.eVP.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn() {
        this.eVP.turnOn();
        this.eVP.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void turnOff(boolean z) {
        this.eVP.turnOff(z);
        this.eVP.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.eVP.turnOn(z);
        this.eVP.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.eVP.setOnSwitchStateChangeListener(aVar);
    }

    private void btD() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.eVN = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.eVP = (BdSwitchView) findViewById(R.id.button);
        this.eVP.setFocusable(true);
        this.eVO = (TextView) findViewById(R.id.tip);
        if (this.eVO != null) {
            this.eVO.setVisibility(8);
        }
        setTag(this.eVP);
        this.eVN.setClickable(false);
        this.eVN.setFocusable(false);
    }

    private void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTipColor, -1);
        if (this.eVO != null && string2 != null) {
            this.eVO.setVisibility(0);
            this.eVO.setText(string2);
            if (color2 > -1) {
                this.eVO.setTextColor(color2);
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
        this.eVN.setClickable(false);
        this.eVN.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.eVO != null) {
            displayTip();
            this.eVO.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.eVO != null) {
            displayTip();
            this.eVO.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.eVO != null) {
            this.eVO.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.eVO != null) {
            this.eVO.setVisibility(8);
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
        return this.eVP;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.eVP = bdSwitchView;
    }
}
