package com.baidu.tieba.ala.liveroom.challenge.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
/* loaded from: classes2.dex */
public class a implements b<String> {
    private int eOT;
    private int eOU;

    public a(int i, int i2) {
        this.eOT = i;
        this.eOU = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.liveroom.challenge.a.b
    /* renamed from: decodeBitmap */
    public Bitmap ao(String str) {
        return yr(str);
    }

    private Bitmap yr(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = a(this.eOT, this.eOU, options);
        options2.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeFile(str, options2);
    }

    private int a(int i, int i2, BitmapFactory.Options options) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            i5 = 2;
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }
}
