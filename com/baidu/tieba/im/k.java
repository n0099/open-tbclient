package com.baidu.tieba.im;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static int f1788a = 110000;
    private static int v = -100000000;
    public static final int b = v - 200;
    public static final int c = v - 201;
    public static final int d = v - 210;
    public static final int e = v - 211;
    public static final int f = v - 212;
    public static final int g = v - 220;
    public static final int h = v - 221;
    public static final int i = v - 230;
    public static final int j = v - 231;
    public static final int k = v - 232;
    public static final int l = v - 233;
    public static final int m = v - 301;
    public static final int n = v - 302;
    public static final int o = v - 303;
    public static final int p = v - 304;
    public static final int q = v - 305;
    public static final int r = v - 306;
    public static final int s = v - 307;
    public static final int t = v - 308;
    public static final int u = v - 501;

    public static String a(int i2) {
        int i3 = v - i2;
        TiebaApplication h2 = TiebaApplication.h();
        return (i3 <= 199 || i3 >= 300) ? h2.getString(R.string.im_error_default) : h2.getString(R.string.im_error_codec);
    }
}
