package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public abstract class b {
    public abstract Bitmap b(Bitmap bitmap, boolean z);

    public abstract void fH(String str);

    public abstract String getActionName();

    public Bitmap fI(String str) {
        return b(com.baidu.tbadk.core.util.c.cJ(str), true);
    }
}
