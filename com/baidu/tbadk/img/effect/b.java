package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public abstract class b {
    public abstract Bitmap b(Bitmap bitmap, boolean z);

    public abstract void fJ(String str);

    public abstract String getActionName();

    public Bitmap fK(String str) {
        return b(BitmapHelper.loadBitmap(str), true);
    }
}
