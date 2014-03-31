package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class TbSettingTextTipView extends FrameLayout {
    protected Context a;
    protected LinearLayout b;
    protected TextView c;
    protected TextView d;
    protected ImageView e;
    private boolean f;

    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = true;
        this.a = context;
        e();
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(attributeSet, com.baidu.tbadk.n.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.c.setText(string);
        }
        if (color >= 0) {
            this.c.setTextColor(color);
        }
        if (string2 != null) {
            this.d.setText(string2);
        }
        if (color2 >= 0) {
            this.d.setTextColor(color2);
        }
        this.f = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
        this.b.setClickable(false);
        this.b.setFocusable(false);
        if (!this.f) {
            this.e.setVisibility(4);
        }
        a(TbadkApplication.j().l());
    }

    public TbSettingTextTipView(Context context) {
        super(context);
        this.f = true;
        this.a = context;
        e();
        a(TbadkApplication.j().l());
    }

    public final void a() {
        if (this.d != null) {
            this.d.setVisibility(0);
        }
    }

    public final void b() {
        if (this.d != null) {
            this.d.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.d != null) {
            this.d.setTextColor(i);
        }
    }

    public void setTipStyle(int i) {
    }

    public static void c() {
    }

    public final void d() {
        this.e.setVisibility(8);
    }

    public void setText(String str) {
        this.c.setText(str);
    }

    public void setText(int i) {
        this.c.setText(i);
    }

    public void setTip(String str) {
        this.d.setText(str);
    }

    public CharSequence getTip() {
        return this.d.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.d.setBackgroundDrawable(drawable);
    }

    public final void a(int i) {
        if (i == 1) {
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tbadk.g.about_tip_color_1));
            this.d.setTextColor(this.a.getResources().getColor(com.baidu.tbadk.g.setting_subtip_color_1));
            this.e.setImageResource(com.baidu.tbadk.i.icon_arrow_right_1);
            return;
        }
        this.c.setTextColor(this.a.getResources().getColor(com.baidu.tbadk.g.about_tip_color));
        this.e.setImageResource(com.baidu.tbadk.i.icon_arrow_right);
        this.d.setTextColor(this.a.getResources().getColor(com.baidu.tbadk.g.setting_subtip_color));
    }

    private void e() {
        LayoutInflater.from(this.a).inflate(com.baidu.tbadk.k.tb_setting_text_tip_view, (ViewGroup) this, true);
        this.b = (LinearLayout) findViewById(com.baidu.tbadk.j.container);
        this.c = (TextView) findViewById(com.baidu.tbadk.j.text);
        this.d = (TextView) findViewById(com.baidu.tbadk.j.tip);
        this.e = (ImageView) findViewById(com.baidu.tbadk.j.arrow2);
    }
}
