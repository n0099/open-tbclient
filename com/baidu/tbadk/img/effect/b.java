package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public abstract class b {
    public abstract Bitmap b(Bitmap bitmap, boolean z);

    public abstract void eq(String str);

    public abstract String getActionName();

    public Bitmap er(String str) {
        return b(com.baidu.tbadk.core.util.d.ca(str), true);
    }
}
