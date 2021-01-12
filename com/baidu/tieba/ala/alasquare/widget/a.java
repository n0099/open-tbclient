package com.baidu.tieba.ala.alasquare.widget;

import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    public static int gGU;

    public static int bRX() {
        int[] iArr = {R.color.common_color_10313, R.color.common_color_10314, R.color.common_color_10315, R.color.common_color_10316, R.color.common_color_10317};
        int length = gGU % iArr.length;
        int i = iArr[length];
        gGU = length + 1;
        return i;
    }
}
