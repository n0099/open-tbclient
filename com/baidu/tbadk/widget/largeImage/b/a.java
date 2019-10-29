package com.baidu.tbadk.widget.largeImage.b;

import android.content.Context;
import android.graphics.BitmapRegionDecoder;
import java.io.IOException;
/* loaded from: classes.dex */
public class a {
    private Context mContext;
    private final int[] mWidthAndheight = new int[2];

    public a(Context context) {
        this.mContext = context;
    }

    public BitmapRegionDecoder createDecoder(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
        this.mWidthAndheight[0] = newInstance.getWidth();
        this.mWidthAndheight[1] = newInstance.getHeight();
        return newInstance;
    }

    public int[] getImageWidthAndHeight() {
        return this.mWidthAndheight;
    }
}
