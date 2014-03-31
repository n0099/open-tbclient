package com.baidu.tbadk.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public final class f {
    private static int a(String str) {
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
            com.baidu.adp.lib.util.f.b(e.getMessage());
            return 0;
        }
    }

    private static Bitmap a(int i) {
        Exception e;
        try {
            int a = a(w.c("camera.jpg"));
            Bitmap a2 = g.a("camera.jpg", i);
            if (a != 0 && a2 != null) {
                try {
                    return g.e(a2, a);
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.adp.lib.util.f.b("WriteUtil", "photoResult", "error = " + e.getMessage());
                    return null;
                }
            }
            return a2;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static Bitmap a(Context context, Uri uri, int i) {
        try {
            return g.a(context, uri, i);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("WriteUtil", "AlbumImageResult", "error = " + e.getMessage());
            return null;
        }
    }

    public static Bitmap a(int i, Context context, Uri uri, int i2) {
        if (i == 12001) {
            return a(i2);
        }
        return a(context, uri, i2);
    }
}
