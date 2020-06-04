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
    private LinearLayout ehT;
    protected TextView ehU;
    private BdSwitchView ehV;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bbB();
        e(attributeSet);
        mW(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        bbB();
        mW(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        bbB();
        e(attributeSet);
        mW(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.ehT;
    }

    public void mW(int i) {
        this.ehV.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        if (this.ehU != null) {
            am.setViewTextColor(this.ehU, R.color.cp_cont_d, 1);
        }
    }

    public void turnOff() {
        this.ehV.turnOff();
        this.ehV.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn() {
        this.ehV.turnOn();
        this.ehV.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void turnOff(boolean z) {
        this.ehV.turnOff(z);
        this.ehV.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.ehV.turnOn(z);
        this.ehV.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.ehV.setOnSwitchStateChangeListener(aVar);
    }

    private void bbB() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.ehT = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.ehV = (BdSwitchView) findViewById(R.id.button);
        this.ehV.setFocusable(true);
        this.ehU = (TextView) findViewById(R.id.tip);
        if (this.ehU != null) {
            this.ehU.setVisibility(8);
        }
        setTag(this.ehV);
        this.ehT.setClickable(false);
        this.ehT.setFocusable(false);
    }

    private void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        float dimension = obtainStyledAttributes.getDimension(0, -1.0f);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.ehU != null && string2 != null) {
            this.ehU.setVisibility(0);
            this.ehU.setText(string2);
            if (color2 > -1) {
                this.ehU.setTextColor(color2);
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
        this.ehT.setClickable(false);
        this.ehT.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.ehU != null) {
            displayTip();
            this.ehU.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.ehU != null) {
            displayTip();
            this.ehU.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.ehU != null) {
            this.ehU.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.ehU != null) {
            this.ehU.setVisibility(8);
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
        return this.ehV;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.ehV = bdSwitchView;
    }
}
