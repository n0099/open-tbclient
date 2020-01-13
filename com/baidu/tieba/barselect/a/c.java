package com.baidu.tieba.barselect.a;

import android.graphics.BitmapFactory;
import android.util.Log;
/* loaded from: classes6.dex */
public class c {
    public static int rd(int i) {
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

    public static int M(byte[] bArr) {
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
                        int b = b(bArr, i3, 2, false);
                        if (b < 2 || i3 + b > bArr.length) {
                            Log.e("CameraExif", "Invalid length");
                            return 0;
                        } else if (i5 == 225 && b >= 8 && b(bArr, i3 + 2, 4, false) == 1165519206 && b(bArr, i3 + 6, 2, false) == 0) {
                            i2 = i3 + 8;
                            i = b - 8;
                            break;
                        } else {
                            i3 += b;
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
            int b2 = b(bArr, i2, 4, false);
            if (b2 != 1229531648 && b2 != 1296891946) {
                Log.e("CameraExif", "Invalid byte order");
                return 0;
            }
            boolean z = b2 == 1229531648;
            int b3 = b(bArr, i2 + 4, 4, z) + 2;
            if (b3 < 10 || b3 > i) {
                Log.e("CameraExif", "Invalid offset");
                return 0;
            }
            int i6 = i2 + b3;
            int i7 = i - b3;
            int b4 = b(bArr, i6 - 2, 2, z);
            int i8 = i6;
            int i9 = i7;
            while (true) {
                int i10 = b4 - 1;
                if (b4 <= 0 || i9 < 12) {
                    break;
                } else if (b(bArr, i8, 2, z) == 274) {
                    switch (b(bArr, i8 + 8, 2, z)) {
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
                    b4 = i10;
                }
            }
        }
        Log.i("CameraExif", "Orientation not found");
        return 0;
    }

    private static int b(byte[] bArr, int i, int i2, boolean z) {
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
