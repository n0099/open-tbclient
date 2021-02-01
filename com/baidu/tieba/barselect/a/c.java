package com.baidu.tieba.barselect.a;

import android.graphics.BitmapFactory;
import android.util.Log;
/* loaded from: classes8.dex */
public class c {
    public static int wU(int i) {
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

    public static int aa(byte[] bArr) {
        int i;
        int i2;
        if (bArr == null) {
            return 0;
        }
        int i3 = 0;
        while (i3 + 3 < bArr.length) {
            i2 = i3 + 1;
            if ((bArr[i3] & 255) != 255) {
                i = 0;
                break;
            }
            int i4 = bArr[i2] & 255;
            if (i4 != 255) {
                i3 = i2 + 1;
                if (i4 != 216 && i4 != 1) {
                    if (i4 == 217) {
                        break;
                    } else if (i4 != 218) {
                        int b2 = b(bArr, i3, 2, false);
                        if (b2 < 2 || i3 + b2 > bArr.length) {
                            Log.e("CameraExif", "Invalid length");
                            return 0;
                        } else if (i4 == 225 && b2 >= 8 && b(bArr, i3 + 2, 4, false) == 1165519206 && b(bArr, i3 + 6, 2, false) == 0) {
                            i2 = i3 + 8;
                            i = b2 - 8;
                            break;
                        } else {
                            i3 += b2;
                        }
                    } else {
                        i = 0;
                        i2 = i3;
                        break;
                    }
                }
            } else {
                i3 = i2;
            }
        }
        i = 0;
        i2 = i3;
        if (i > 8) {
            int b3 = b(bArr, i2, 4, false);
            if (b3 != 1229531648 && b3 != 1296891946) {
                Log.e("CameraExif", "Invalid byte order");
                return 0;
            }
            boolean z = b3 == 1229531648;
            int b4 = b(bArr, i2 + 4, 4, z) + 2;
            if (b4 < 10 || b4 > i) {
                Log.e("CameraExif", "Invalid offset");
                return 0;
            }
            int i5 = i2 + b4;
            int b5 = b(bArr, i5 - 2, 2, z);
            int i6 = i - b4;
            while (true) {
                int i7 = b5 - 1;
                if (b5 <= 0 || i6 < 12) {
                    break;
                } else if (b(bArr, i5, 2, z) == 274) {
                    switch (b(bArr, i5 + 8, 2, z)) {
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
                    i5 += 12;
                    i6 -= 12;
                    b5 = i7;
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
