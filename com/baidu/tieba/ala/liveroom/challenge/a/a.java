package com.baidu.tieba.ala.liveroom.challenge.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
/* loaded from: classes6.dex */
public class a implements b<String> {
    private int dZN;
    private int dZO;

    public a(int i, int i2) {
        this.dZN = i;
        this.dZO = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.liveroom.challenge.a.b
    /* renamed from: decodeBitmap */
    public Bitmap ai(String str) {
        return tA(str);
    }

    private Bitmap tA(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = a(this.dZN, this.dZO, options);
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
