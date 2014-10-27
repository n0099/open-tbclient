package com.baidu.tbadk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes.dex */
public class k {
    public static int bl(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 3:
                    return 180;
                case 4:
                case 5:
                case 7:
                default:
                    return 0;
                case 6:
                    return 90;
                case 8:
                    return 270;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0;
        }
    }

    private static Bitmap dr(int i) {
        Exception e;
        try {
            int bl = bl(s.bq("camera.jpg"));
            Bitmap m = com.baidu.tbadk.core.util.d.m("camera.jpg", i);
            if (bl != 0 && m != null) {
                try {
                    return com.baidu.tbadk.core.util.d.e(m, bl);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return m;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static Bitmap b(Context context, String str, int i) {
        try {
            return com.baidu.tbadk.core.util.d.a(str, i, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private static Bitmap b(Context context, Uri uri, int i) {
        try {
            return com.baidu.tbadk.core.util.d.a(context, uri, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public static Bitmap a(int i, Context context, Uri uri, String str, int i2) {
        if (i == 12001) {
            return dr(i2);
        }
        if (!TextUtils.isEmpty(str)) {
            return b(context, str, i2);
        }
        return b(context, uri, i2);
    }
}
