package com.baidu.tieba.im;

import android.app.Application;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class h {
    public static int a = 110000;
    private static int w = -100000000;
    public static final int b = w + SapiErrorCode.NETWORK_FAILED;
    public static final int c = w - 201;
    public static final int d = w - 210;
    public static final int e = w - 211;
    public static final int f = w - 212;
    public static final int g = w - 220;
    public static final int h = w - 221;
    public static final int i = w - 230;
    public static final int j = w - 231;
    public static final int k = w - 232;
    public static final int l = w - 233;
    public static final int m = w - 301;
    public static final int n = w - 302;
    public static final int o = w - 303;
    public static final int p = w - 304;
    public static final int q = w - 305;
    public static final int r = w - 306;
    public static final int s = w - 307;
    public static final int t = w - 308;
    public static final int u = w - 309;
    public static final int v = w - 501;

    public static String a(int i2) {
        int i3 = w - i2;
        Application b2 = TiebaApplication.g().b();
        return (i3 <= 199 || i3 >= 300) ? b2.getString(R.string.im_error_default) : b2.getString(R.string.im_error_codec);
    }
}
