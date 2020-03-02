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
    private LinearLayout dtk;
    protected TextView dtl;
    private BdSwitchView dtm;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aMR();
        d(attributeSet);
        me(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        aMR();
        me(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        aMR();
        d(attributeSet);
        me(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.dtk;
    }

    public void me(int i) {
        this.dtm.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        if (this.dtl != null) {
            am.setViewTextColor(this.dtl, R.color.cp_cont_d, 1);
        }
    }

    public void turnOff() {
        this.dtm.turnOff();
        this.dtm.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn() {
        this.dtm.turnOn();
        this.dtm.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void turnOff(boolean z) {
        this.dtm.turnOff(z);
        this.dtm.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.dtm.turnOn(z);
        this.dtm.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.dtm.setOnSwitchStateChangeListener(aVar);
    }

    private void aMR() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.dtk = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.dtm = (BdSwitchView) findViewById(R.id.button);
        this.dtm.setFocusable(true);
        this.dtl = (TextView) findViewById(R.id.tip);
        if (this.dtl != null) {
            this.dtl.setVisibility(8);
        }
        setTag(this.dtm);
        this.dtk.setClickable(false);
        this.dtk.setFocusable(false);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        float dimension = obtainStyledAttributes.getDimension(0, -1.0f);
        String string2 = obtainStyledAttributes.getString(1);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (this.dtl != null && string2 != null) {
            this.dtl.setVisibility(0);
            this.dtl.setText(string2);
            if (color2 > -1) {
                this.dtl.setTextColor(color2);
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
        this.dtk.setClickable(false);
        this.dtk.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.dtl != null) {
            displayTip();
            this.dtl.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.dtl != null) {
            displayTip();
            this.dtl.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.dtl != null) {
            this.dtl.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.dtl != null) {
            this.dtl.setVisibility(8);
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
        return this.dtm;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.dtm = bdSwitchView;
    }
}
