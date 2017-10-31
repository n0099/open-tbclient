package com.baidu.tbadk.widget.a.c;

import android.content.Context;
import android.graphics.BitmapRegionDecoder;
import java.io.IOException;
/* loaded from: classes.dex */
public class a {
    private final int[] aPi = new int[2];
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public BitmapRegionDecoder y(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
        this.aPi[0] = newInstance.getWidth();
        this.aPi[1] = newInstance.getHeight();
        return newInstance;
    }

    public int[] Ii() {
        return this.aPi;
    }
}
