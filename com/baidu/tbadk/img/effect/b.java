package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public abstract class b {
    public abstract Bitmap b(Bitmap bitmap, boolean z) throws Exception;

    public abstract String getActionName();

    public abstract void setParams(String str);

    public Bitmap qM(String str) throws Exception {
        return b(BitmapHelper.loadBitmap(str), true);
    }
}
