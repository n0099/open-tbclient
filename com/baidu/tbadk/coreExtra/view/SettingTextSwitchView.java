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
    private LinearLayout fqI;
    protected TextView fqJ;
    private BdSwitchView fqK;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bAL();
        e(attributeSet);
        rY(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        bAL();
        rY(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        bAL();
        e(attributeSet);
        rY(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.fqI;
    }

    public void rY(int i) {
        this.fqK.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.textView, R.color.CAM_X0105, 1);
        if (this.fqJ != null) {
            ap.setViewTextColor(this.fqJ, R.color.CAM_X0109, 1);
        }
    }

    public void turnOff() {
        this.fqK.turnOff();
        this.fqK.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn() {
        this.fqK.turnOn();
        this.fqK.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void turnOff(boolean z) {
        this.fqK.turnOff(z);
        this.fqK.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.fqK.turnOn(z);
        this.fqK.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.fqK.setOnSwitchStateChangeListener(aVar);
    }

    private void bAL() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.fqI = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fqK = (BdSwitchView) findViewById(R.id.button);
        this.fqK.setFocusable(true);
        this.fqJ = (TextView) findViewById(R.id.tip);
        if (this.fqJ != null) {
            this.fqJ.setVisibility(8);
        }
        setTag(this.fqK);
        this.fqI.setClickable(false);
        this.fqI.setFocusable(false);
    }

    private void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTipColor, -1);
        if (this.fqJ != null && string2 != null) {
            this.fqJ.setVisibility(0);
            this.fqJ.setText(string2);
            if (color2 > -1) {
                this.fqJ.setTextColor(color2);
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
        this.fqI.setClickable(false);
        this.fqI.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.fqJ != null) {
            displayTip();
            this.fqJ.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.fqJ != null) {
            displayTip();
            this.fqJ.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.fqJ != null) {
            this.fqJ.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.fqJ != null) {
            this.fqJ.setVisibility(8);
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
        return this.fqK;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.fqK = bdSwitchView;
    }
}
