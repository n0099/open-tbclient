package com.baidu.tbadk.widget.largeImage.b;

import android.content.Context;
import android.graphics.BitmapRegionDecoder;
import java.io.IOException;
/* loaded from: classes.dex */
public class a {
    private final int[] bof = new int[2];
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public BitmapRegionDecoder G(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
        this.bof[0] = newInstance.getWidth();
        this.bof[1] = newInstance.getHeight();
        return newInstance;
    }

    public int[] RD() {
        return this.bof;
    }
}
