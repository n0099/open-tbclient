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
    private LinearLayout fzw;
    protected TextView fzx;
    private BdSwitchView fzy;
    private final Context mContext;
    private TextView textView;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bzH();
        h(attributeSet);
        qK(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.mContext = context;
        bzH();
        qK(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        bzH();
        h(attributeSet);
        qK(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.fzw;
    }

    public void qK(int i) {
        this.fzy.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setViewTextColor(this.textView, R.color.CAM_X0105, 1);
        if (this.fzx != null) {
            ap.setViewTextColor(this.fzx, R.color.CAM_X0109, 1);
        }
    }

    public void turnOff(boolean z) {
        this.fzy.turnOff(z);
        this.fzy.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_close));
    }

    public void turnOn(boolean z) {
        this.fzy.turnOn(z);
        this.fzy.setContentDescription(this.mContext.getString(R.string.talk_message_tip) + this.mContext.getString(R.string.talk_open));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setSwitchStateChangeListener(BdSwitchView.a aVar) {
        this.fzy.setOnSwitchStateChangeListener(aVar);
    }

    private void bzH() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.fzw = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.fzy = (BdSwitchView) findViewById(R.id.button);
        this.fzy.setFocusable(true);
        this.fzx = (TextView) findViewById(R.id.tip);
        if (this.fzx != null) {
            this.fzx.setVisibility(8);
        }
        setTag(this.fzy);
        this.fzw.setClickable(false);
        this.fzw.setFocusable(false);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTipColor, -1);
        if (this.fzx != null && string2 != null) {
            this.fzx.setVisibility(0);
            this.fzx.setText(string2);
            if (color2 > -1) {
                this.fzx.setTextColor(color2);
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
        this.fzw.setClickable(false);
        this.fzw.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public void setTip(String str) {
        if (str != null && this.fzx != null) {
            displayTip();
            this.fzx.setText(str);
        }
    }

    public void setTip(int i) {
        if (i != -1 && this.fzx != null) {
            displayTip();
            this.fzx.setText(i);
        }
    }

    public void setTipColor(int i) {
        if (this.fzx != null) {
            this.fzx.setTextColor(i);
        }
    }

    public void displayTip() {
        if (this.fzx != null) {
            this.fzx.setVisibility(8);
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
        return this.fzy;
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.fzy = bdSwitchView;
    }
}
