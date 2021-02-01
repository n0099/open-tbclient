package com.baidu.tbadk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class an {
    public static int readPictureDegree(String str) {
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

    private static Bitmap photoResult(int i) {
        try {
            int readPictureDegree = readPictureDegree(com.baidu.tbadk.core.util.o.getFileDireciory(SelectImageHelper.TMP_IMAGE_NAME));
            Bitmap subSampleBitmap = BitmapHelper.subSampleBitmap(SelectImageHelper.TMP_IMAGE_NAME, i);
            if (readPictureDegree != 0 && subSampleBitmap != null) {
                return BitmapHelper.rotateBitmapBydegree(subSampleBitmap, readPictureDegree);
            }
            return subSampleBitmap;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private static Bitmap AlbumImageResult(Context context, String str, int i) {
        try {
            return BitmapHelper.loadResizedBitmap(str, i, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private static Bitmap AlbumImageResult(Context context, Uri uri, int i) {
        try {
            return BitmapHelper.subSampleBitmap(context, uri, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public static Bitmap ImageResult(int i, Context context, Uri uri, String str, int i2) {
        if (i == 12001) {
            return photoResult(i2);
        }
        if (!TextUtils.isEmpty(str)) {
            return AlbumImageResult(context, str, i2);
        }
        return AlbumImageResult(context, uri, i2);
    }
}
