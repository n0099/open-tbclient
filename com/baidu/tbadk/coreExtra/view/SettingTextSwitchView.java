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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SettingTextSwitchView extends FrameLayout {
    private LinearLayout eqD;
    protected TextView eqE;
    private BdSwitchView eqF;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bdD();
        e(attributeSet);
        nq(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        bdD();
        nq(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        bdD();
        e(attributeSet);
        nq(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.eqD;
    }

    public void nq(int i) {
        this.eqF.setBackgroundRes(an.getBitmap(R.drawable.bg_switch_open), an.getBitmap(R.drawable.bg_switch_close), an.getBitmap(R.drawable.btn_handle));
        an.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        if (this.eqE != null) {
            an.setViewTextColor(this.eqE, R.color.cp_cont_d, 1);
        }
    }

    public void turnOff() {
        this.eqF.turnOff();
        this.eqF.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn() {
        this.eqF.turnOn();
        this.eqF.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void turnOff(boolean z) {
        this.eqF.turnOff(z);
        this.eqF.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.eqF.turnOn(z);
        this.eqF.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.eqF.setOnSwitchStateChangeListener(aVar);
    }

    private void bdD() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.eqD = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.eqF = (BdSwitchView) findViewById(R.id.button);
        this.eqF.setFocusable(true);
        this.eqE = (TextView) findViewById(R.id.tip);
        if (this.eqE != null) {
            this.eqE.setVisibility(8);
        }
        setTag(this.eqF);
        this.eqD.setClickable(false);
        this.eqD.setFocusable(false);
    }

    private void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        float dimension = obtainStyledAttributes.getDimension(0, -1.0f);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.eqE != null && string2 != null) {
            this.eqE.setVisibility(0);
            this.eqE.setText(string2);
            if (color2 > -1) {
                this.eqE.setTextColor(color2);
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
        this.eqD.setClickable(false);
        this.eqD.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.eqE != null) {
            displayTip();
            this.eqE.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.eqE != null) {
            displayTip();
            this.eqE.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.eqE != null) {
            this.eqE.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.eqE != null) {
            this.eqE.setVisibility(8);
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
        return this.eqF;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.eqF = bdSwitchView;
    }
}
