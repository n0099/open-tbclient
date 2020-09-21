package com.baidu.tbadk.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    public static float[] a(Bitmap bitmap, Matrix matrix) {
        float[] fArr = new float[8];
        matrix.mapPoints(fArr, new float[]{0.0f, 0.0f, bitmap.getWidth(), 0.0f, 0.0f, bitmap.getHeight(), bitmap.getWidth(), bitmap.getHeight()});
        return fArr;
    }

    public static Bitmap bx(View view) {
        Bitmap bitmap = null;
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0) {
            return null;
        }
        try {
            bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(bitmap));
            return bitmap;
        } catch (OutOfMemoryError e) {
            try {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                view.draw(new Canvas(bitmap));
                return bitmap;
            } catch (OutOfMemoryError e2) {
                BdLog.e(e2);
                return bitmap;
            }
        }
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        Bitmap bitmap3 = null;
        if (bitmap == null || bitmap2 == null || i <= 0 || i2 <= 0) {
            return null;
        }
        try {
            bitmap3 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap3);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            return bitmap3;
        } catch (OutOfMemoryError e) {
            try {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                bitmap3 = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
                Canvas canvas2 = new Canvas(bitmap3);
                canvas2.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                canvas2.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return bitmap3;
            } catch (OutOfMemoryError e2) {
                BdLog.e(e2);
                return bitmap3;
            }
        }
    }
}
