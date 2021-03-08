package com.baidu.tieba.ala.alasquare.widget;

import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    public static int gLB;

    public static int bSN() {
        int[] iArr = {R.color.common_color_10313, R.color.common_color_10314, R.color.common_color_10315, R.color.common_color_10316, R.color.common_color_10317};
        int length = gLB % iArr.length;
        int i = iArr[length];
        gLB = length + 1;
        return i;
    }
}
