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
    private LinearLayout dpb;
    protected TextView dpc;
    private BdSwitchView dpd;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aKt();
        d(attributeSet);
        lM(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        aKt();
        lM(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        aKt();
        d(attributeSet);
        lM(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.dpb;
    }

    public void lM(int i) {
        this.dpd.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        if (this.dpc != null) {
            am.setViewTextColor(this.dpc, R.color.cp_cont_d, 1);
        }
    }

    public void turnOff() {
        this.dpd.turnOff();
        this.dpd.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn() {
        this.dpd.turnOn();
        this.dpd.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void turnOff(boolean z) {
        this.dpd.turnOff(z);
        this.dpd.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.dpd.turnOn(z);
        this.dpd.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.dpd.setOnSwitchStateChangeListener(aVar);
    }

    private void aKt() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.dpb = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.dpd = (BdSwitchView) findViewById(R.id.button);
        this.dpd.setFocusable(true);
        this.dpc = (TextView) findViewById(R.id.tip);
        if (this.dpc != null) {
            this.dpc.setVisibility(8);
        }
        setTag(this.dpd);
        this.dpb.setClickable(false);
        this.dpb.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        float dimension = obtainStyledAttributes.getDimension(0, -1.0f);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.dpc != null && string2 != null) {
            this.dpc.setVisibility(0);
            this.dpc.setText(string2);
            if (color2 > -1) {
                this.dpc.setTextColor(color2);
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
        this.dpb.setClickable(false);
        this.dpb.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.dpc != null) {
            displayTip();
            this.dpc.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.dpc != null) {
            displayTip();
            this.dpc.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.dpc != null) {
            this.dpc.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.dpc != null) {
            this.dpc.setVisibility(8);
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
        return this.dpd;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.dpd = bdSwitchView;
    }
}
