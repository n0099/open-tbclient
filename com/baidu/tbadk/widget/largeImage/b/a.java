package com.baidu.tbadk.widget.largeImage.b;

import android.content.Context;
import android.graphics.BitmapRegionDecoder;
import java.io.IOException;
/* loaded from: classes.dex */
public class a {
    private final int[] boc = new int[2];
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public BitmapRegionDecoder G(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
        this.boc[0] = newInstance.getWidth();
        this.boc[1] = newInstance.getHeight();
        return newInstance;
    }

    public int[] RB() {
        return this.boc;
    }
}
