package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class c {
    public static void a(Context context, View view, boolean z, String str, String str2, boolean z2) {
        float dimension;
        try {
            if (z) {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor(str), Color.parseColor(str2)});
                if (z2) {
                    dimension = context.getResources().getDimension(a.d.sdk_ds36);
                } else {
                    dimension = context.getResources().getDimension(a.d.sdk_ds44);
                }
                gradientDrawable.setCornerRadii(new float[]{dimension, dimension, dimension, dimension, dimension, dimension, dimension, dimension});
                if (Build.VERSION.SDK_INT < 16) {
                    view.setBackgroundDrawable(gradientDrawable);
                } else {
                    view.setBackground(gradientDrawable);
                }
            } else if (z2) {
                view.setBackgroundDrawable(context.getResources().getDrawable(a.e.sdk_scene_item_bg_n));
            } else {
                view.setBackgroundDrawable(context.getResources().getDrawable(a.e.sdk_land_scene_item_bg_n));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
