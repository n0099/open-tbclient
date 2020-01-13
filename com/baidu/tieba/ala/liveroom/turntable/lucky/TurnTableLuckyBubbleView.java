package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.mobstat.Config;
/* loaded from: classes2.dex */
public class TurnTableLuckyBubbleView extends LinearLayout {
    private TextView aqn;
    private String fhU;
    private String mName;

    public TurnTableLuckyBubbleView(Context context) {
        super(context);
        init();
    }

    public void setContent(String str) {
        this.aqn.setText(str);
    }

    public void setContent(String str, String str2) {
        if (TextUtils.isEmpty(this.mName) || TextUtils.isEmpty(this.fhU) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !this.mName.equals(str) || !this.fhU.equals(str2)) {
            this.mName = str;
            this.fhU = str2;
            this.aqn.setText(!TextUtils.isEmpty(this.fhU) ? this.mName + Config.EVENT_HEAT_X + this.fhU : this.mName);
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.turn_table_widget_lucky_bubble, (ViewGroup) this, true);
        this.aqn = (TextView) findViewById(a.g.tv_content);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setColors(new int[]{-22755, -2199, -22755});
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        } else {
            gradientDrawable.setColor(-2199);
        }
        this.aqn.setBackgroundDrawable(gradientDrawable);
    }
}
