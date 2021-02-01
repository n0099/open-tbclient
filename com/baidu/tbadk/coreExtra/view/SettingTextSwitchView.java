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
    private LinearLayout fxX;
    protected TextView fxY;
    private BdSwitchView fxZ;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bzE();
        h(attributeSet);
        qJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        bzE();
        qJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        bzE();
        h(attributeSet);
        qJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.fxX;
    }

    public void qJ(int i) {
        this.fxZ.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.textView, R.color.CAM_X0105, 1);
        if (this.fxY != null) {
            ap.setViewTextColor(this.fxY, R.color.CAM_X0109, 1);
        }
    }

    public void turnOff(boolean z) {
        this.fxZ.turnOff(z);
        this.fxZ.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.fxZ.turnOn(z);
        this.fxZ.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.fxZ.setOnSwitchStateChangeListener(aVar);
    }

    private void bzE() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.fxX = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fxZ = (BdSwitchView) findViewById(R.id.button);
        this.fxZ.setFocusable(true);
        this.fxY = (TextView) findViewById(R.id.tip);
        if (this.fxY != null) {
            this.fxY.setVisibility(8);
        }
        setTag(this.fxZ);
        this.fxX.setClickable(false);
        this.fxX.setFocusable(false);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTipColor, -1);
        if (this.fxY != null && string2 != null) {
            this.fxY.setVisibility(0);
            this.fxY.setText(string2);
            if (color2 > -1) {
                this.fxY.setTextColor(color2);
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
        this.fxX.setClickable(false);
        this.fxX.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.fxY != null) {
            displayTip();
            this.fxY.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.fxY != null) {
            displayTip();
            this.fxY.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.fxY != null) {
            this.fxY.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.fxY != null) {
            this.fxY.setVisibility(8);
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
        return this.fxZ;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.fxZ = bdSwitchView;
    }
}
