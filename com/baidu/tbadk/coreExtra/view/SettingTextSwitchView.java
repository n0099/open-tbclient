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
    private LinearLayout fAp;
    protected TextView fAq;
    private BdSwitchView fAr;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bDg();
        i(attributeSet);
        sk(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        bDg();
        sk(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        bDg();
        i(attributeSet);
        sk(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.fAp;
    }

    public void sk(int i) {
        this.fAr.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        ao.setViewTextColor(this.textView, R.color.CAM_X0105, 1);
        if (this.fAq != null) {
            ao.setViewTextColor(this.fAq, R.color.CAM_X0109, 1);
        }
    }

    public void turnOff(boolean z) {
        this.fAr.turnOff(z);
        this.fAr.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.fAr.turnOn(z);
        this.fAr.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.fAr.setOnSwitchStateChangeListener(aVar);
    }

    private void bDg() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.fAp = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fAr = (BdSwitchView) findViewById(R.id.button);
        this.fAr.setFocusable(true);
        this.fAq = (TextView) findViewById(R.id.tip);
        if (this.fAq != null) {
            this.fAq.setVisibility(8);
        }
        setTag(this.fAr);
        this.fAp.setClickable(false);
        this.fAp.setFocusable(false);
    }

    private void i(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTipColor, -1);
        if (this.fAq != null && string2 != null) {
            this.fAq.setVisibility(0);
            this.fAq.setText(string2);
            if (color2 > -1) {
                this.fAq.setTextColor(color2);
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
        this.fAp.setClickable(false);
        this.fAp.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.fAq != null) {
            displayTip();
            this.fAq.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.fAq != null) {
            displayTip();
            this.fAq.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.fAq != null) {
            this.fAq.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.fAq != null) {
            this.fAq.setVisibility(8);
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
        return this.fAr;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.fAr = bdSwitchView;
    }
}
