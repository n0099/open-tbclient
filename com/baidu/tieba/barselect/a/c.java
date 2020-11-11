package com.baidu.tieba.barselect.a;

import android.graphics.BitmapFactory;
import android.util.Log;
/* loaded from: classes21.dex */
public class c {
    public static int wZ(int i) {
        if (i == 6) {
            return 90;
        }
        if (i == 3) {
            return 180;
        }
        if (i == 8) {
            return 270;
        }
        return 0;
    }

    public static int ad(byte[] bArr) {
        int i;
        int i2;
        if (bArr == null) {
            return 0;
        }
        int i3 = 0;
        while (i3 + 3 < bArr.length) {
            int i4 = i3 + 1;
            if ((bArr[i3] & 255) != 255) {
                i2 = i4;
                i = 0;
                break;
            }
            int i5 = bArr[i4] & 255;
            if (i5 != 255) {
                i3 = i4 + 1;
                if (i5 != 216 && i5 != 1) {
                    if (i5 == 217) {
                        break;
                    } else if (i5 != 218) {
                        int a2 = a(bArr, i3, 2, false);
                        if (a2 < 2 || i3 + a2 > bArr.length) {
                            Log.e("CameraExif", "Invalid length");
                            return 0;
                        } else if (i5 == 225 && a2 >= 8 && a(bArr, i3 + 2, 4, false) == 1165519206 && a(bArr, i3 + 6, 2, false) == 0) {
                            i2 = i3 + 8;
                            i = a2 - 8;
                            break;
                        } else {
                            i3 += a2;
                        }
                    } else {
                        i = 0;
                        i2 = i3;
                        break;
                    }
                }
            } else {
                i3 = i4;
            }
        }
        i = 0;
        i2 = i3;
        if (i > 8) {
            int a3 = a(bArr, i2, 4, false);
            if (a3 != 1229531648 && a3 != 1296891946) {
                Log.e("CameraExif", "Invalid byte order");
                return 0;
            }
            boolean z = a3 == 1229531648;
            int a4 = a(bArr, i2 + 4, 4, z) + 2;
            if (a4 < 10 || a4 > i) {
                Log.e("CameraExif", "Invalid offset");
                return 0;
            }
            int i6 = i2 + a4;
            int i7 = i - a4;
            int a5 = a(bArr, i6 - 2, 2, z);
            int i8 = i6;
            int i9 = i7;
            while (true) {
                int i10 = a5 - 1;
                if (a5 <= 0 || i9 < 12) {
                    break;
                } else if (a(bArr, i8, 2, z) == 274) {
                    switch (a(bArr, i8 + 8, 2, z)) {
                        case 1:
                        case 2:
                        case 4:
                        case 5:
                        case 7:
                        default:
                            return 0;
                        case 3:
                            return 180;
                        case 6:
                            return 90;
                        case 8:
                            return 270;
                    }
                } else {
                    i8 += 12;
                    i9 -= 12;
                    a5 = i10;
                }
            }
        }
        Log.i("CameraExif", "Orientation not found");
        return 0;
    }

    private static int a(byte[] bArr, int i, int i2, boolean z) {
        int i3 = 1;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 > 0) {
                i4 = (i4 << 8) | (bArr[i] & 255);
                i += i3;
                i2 = i5;
            } else {
                return i4;
            }
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }
}
