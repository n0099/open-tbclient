package com.baidu.tieba.im;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static int f1723a = 110000;
    private static int u = -100000000;
    public static final int b = u - 200;
    public static final int c = u - 201;
    public static final int d = u - 210;
    public static final int e = u - 211;
    public static final int f = u - 212;
    public static final int g = u - 220;
    public static final int h = u - 221;
    public static final int i = u - 230;
    public static final int j = u - 231;
    public static final int k = u - 232;
    public static final int l = u - 233;
    public static final int m = u - 301;
    public static final int n = u - 302;
    public static final int o = u - 303;
    public static final int p = u - 304;
    public static final int q = u - 305;
    public static final int r = u - 306;
    public static final int s = u - 307;
    public static final int t = u - 501;

    public static String a(int i2) {
        int i3 = u - i2;
        TiebaApplication g2 = TiebaApplication.g();
        return (i3 <= 199 || i3 >= 300) ? g2.getString(R.string.im_error_default) : g2.getString(R.string.im_error_codec);
    }
}
