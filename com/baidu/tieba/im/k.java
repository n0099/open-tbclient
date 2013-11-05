package com.baidu.tieba.im;

import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static int f1636a = 110000;
    private static int u = 100000000;
    public static final int b = u + 200;
    public static final int c = u + 201;
    public static final int d = u + 210;
    public static final int e = u + 211;
    public static final int f = u + 212;
    public static final int g = u + 220;
    public static final int h = u + 221;
    public static final int i = u + 230;
    public static final int j = u + 231;
    public static final int k = u + 232;
    public static final int l = u + 233;
    public static final int m = (u + BVideoView.MEDIA_ERROR_NO_INPUTFILE) * (-1);
    public static final int n = (u + BVideoView.MEDIA_ERROR_INVALID_INPUTFILE) * (-1);
    public static final int o = (u + BVideoView.MEDIA_ERROR_NO_SUPPORTED_CODEC) * (-1);
    public static final int p = (u + BVideoView.MEDIA_ERROR_DISPLAY) * (-1);
    public static final int q = (u + BVideoView.MEDIA_ERROR_EIO) * (-1);
    public static final int r = (u + 306) * (-1);
    public static final int s = (u + 307) * (-1);
    public static final int t = u + BdWebErrorView.ERROR_CODE_501;

    public static String a(int i2) {
        int i3 = i2 - u;
        TiebaApplication g2 = TiebaApplication.g();
        return (i3 <= 199 || i3 >= 300) ? g2.getString(R.string.im_error_default) : g2.getString(R.string.im_error_codec);
    }
}
