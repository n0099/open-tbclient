package com.baidu.tbadk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes.dex */
public class ab {
    public static int readPictureDegree(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 3:
                    return SubsamplingScaleImageView.ORIENTATION_180;
                case 4:
                case 5:
                case 7:
                default:
                    return 0;
                case 6:
                    return 90;
                case 8:
                    return SubsamplingScaleImageView.ORIENTATION_270;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0;
        }
    }

    private static Bitmap it(int i) {
        Exception e;
        try {
            int readPictureDegree = readPictureDegree(com.baidu.tbadk.core.util.k.dq("camera.jpg"));
            Bitmap subSampleBitmap = BitmapHelper.subSampleBitmap("camera.jpg", i);
            if (readPictureDegree != 0 && subSampleBitmap != null) {
                try {
                    return BitmapHelper.rotateBitmapBydegree(subSampleBitmap, readPictureDegree);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return subSampleBitmap;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static Bitmap e(Context context, String str, int i) {
        try {
            return BitmapHelper.loadResizedBitmap(str, i, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private static Bitmap a(Context context, Uri uri, int i) {
        try {
            return BitmapHelper.subSampleBitmap(context, uri, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public static Bitmap a(int i, Context context, Uri uri, String str, int i2) {
        if (i == 12001) {
            return it(i2);
        }
        if (!TextUtils.isEmpty(str)) {
            return e(context, str, i2);
        }
        return a(context, uri, i2);
    }
}
