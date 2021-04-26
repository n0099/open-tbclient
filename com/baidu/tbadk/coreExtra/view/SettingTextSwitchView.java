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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
/* loaded from: classes3.dex */
public class SettingTextSwitchView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public final Context f13422e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13423f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13424g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13425h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f13426i;

    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13422e = context;
        c();
        b(attributeSet);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a() {
        TextView textView = this.f13425h;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f13422e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
        float dimension = obtainStyledAttributes.getDimension(R$styleable.TbSettingView_settingTextSize, -1.0f);
        String string2 = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTipColor, -1);
        TextView textView = this.f13425h;
        if (textView != null && string2 != null) {
            textView.setVisibility(0);
            this.f13425h.setText(string2);
            if (color2 > -1) {
                this.f13425h.setTextColor(color2);
            }
        }
        if (string != null) {
            this.f13424g.setText(string);
        }
        if (color > -1) {
            this.f13424g.setTextColor(color);
        }
        if (dimension > -1.0f) {
            this.f13424g.setTextSize(0, dimension);
        }
        this.f13423f.setClickable(false);
        this.f13423f.setFocusable(false);
        obtainStyledAttributes.recycle();
    }

    public final void c() {
        LayoutInflater.from(this.f13422e).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
        this.f13423f = (LinearLayout) findViewById(R.id.container);
        this.f13424g = (TextView) findViewById(R.id.text);
        BdSwitchView bdSwitchView = (BdSwitchView) findViewById(R.id.button);
        this.f13426i = bdSwitchView;
        bdSwitchView.setFocusable(true);
        TextView textView = (TextView) findViewById(R.id.tip);
        this.f13425h = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        setTag(this.f13426i);
        this.f13423f.setClickable(false);
        this.f13423f.setFocusable(false);
    }

    public void d(int i2) {
        this.f13426i.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        SkinManager.setViewTextColor(this.f13424g, R.color.CAM_X0105, 1);
        TextView textView = this.f13425h;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
        }
    }

    public void e(boolean z) {
        this.f13426i.g(z);
        BdSwitchView bdSwitchView = this.f13426i;
        bdSwitchView.setContentDescription(this.f13422e.getString(R.string.talk_message_tip) + this.f13422e.getString(R.string.talk_close));
    }

    public void f(boolean z) {
        this.f13426i.j(z);
        BdSwitchView bdSwitchView = this.f13426i;
        bdSwitchView.setContentDescription(this.f13422e.getString(R.string.talk_message_tip) + this.f13422e.getString(R.string.talk_open));
    }

    public BdSwitchView getSwitchView() {
        return this.f13426i;
    }

    public View getView() {
        return this.f13423f;
    }

    public void setSwitchStateChangeListener(BdSwitchView.b bVar) {
        this.f13426i.setOnSwitchStateChangeListener(bVar);
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        this.f13426i = bdSwitchView;
    }

    public void setText(String str) {
        this.f13424g.setText(str);
    }

    public void setTextLeftMargin(int i2) {
        if (this.f13424g.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13424g.getLayoutParams();
            layoutParams.leftMargin = this.f13422e.getResources().getDimensionPixelSize(i2);
            this.f13424g.setLayoutParams(layoutParams);
        }
    }

    public void setTip(String str) {
        if (str == null || this.f13425h == null) {
            return;
        }
        a();
        this.f13425h.setText(str);
    }

    public void setTipColor(int i2) {
        TextView textView = this.f13425h;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public void setTip(int i2) {
        if (i2 == -1 || this.f13425h == null) {
            return;
        }
        a();
        this.f13425h.setText(i2);
    }

    public SettingTextSwitchView(Context context) {
        super(context);
        this.f13422e = context;
        c();
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13422e = context;
        c();
        b(attributeSet);
        d(TbadkCoreApplication.getInst().getSkinType());
    }
}
