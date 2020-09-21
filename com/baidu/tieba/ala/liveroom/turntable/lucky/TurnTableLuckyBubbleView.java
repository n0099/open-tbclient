package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class TurnTableLuckyBubbleView extends LinearLayout {
    private TextView aBe;
    private String gMZ;
    private String mName;

    public TurnTableLuckyBubbleView(Context context) {
        super(context);
        init();
    }

    public void setContent(String str) {
        this.aBe.setText(str);
    }

    public void setContent(String str, String str2) {
        if (TextUtils.isEmpty(this.mName) || TextUtils.isEmpty(this.gMZ) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !this.mName.equals(str) || !this.gMZ.equals(str2)) {
            this.mName = str;
            this.gMZ = str2;
            this.aBe.setText(!TextUtils.isEmpty(this.gMZ) ? this.mName + "x" + this.gMZ : this.mName);
        }
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.turn_table_widget_lucky_bubble, (ViewGroup) this, true);
        this.aBe = (TextView) findViewById(a.g.tv_content);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setColors(new int[]{-22755, -2199, -22755});
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        } else {
            gradientDrawable.setColor(-2199);
        }
        this.aBe.setBackgroundDrawable(gradientDrawable);
    }
}
