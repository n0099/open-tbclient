package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.g;
/* loaded from: classes.dex */
public abstract class b {
    public abstract Bitmap a(Bitmap bitmap, boolean z);

    public abstract String a();

    public abstract void b(String str);

    public Bitmap c(String str) {
        return a(g.a(str), true);
    }
}
