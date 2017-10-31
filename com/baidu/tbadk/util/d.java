package com.baidu.tbadk.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class d {
    public static Bitmap R(View view) {
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
}
