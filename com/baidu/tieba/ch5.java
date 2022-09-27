package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
/* loaded from: classes3.dex */
public class ch5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(Bitmap bitmap, int i, boolean z) {
        InterceptResult invokeCommon;
        int width;
        int height;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{bitmap, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int i2 = i;
            if (z) {
                width = bitmap.getWidth() / 2;
                height = bitmap.getHeight() / 4;
            } else {
                width = bitmap.getWidth();
                height = bitmap.getHeight();
            }
            if (width == 0 || height == 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
            if (i2 < 1) {
                return null;
            }
            int i3 = width * height;
            int[] iArr2 = new int[i3];
            createBitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
            int i4 = width - 1;
            int i5 = height - 1;
            int i6 = i2 + i2 + 1;
            int[] iArr3 = new int[i3];
            int[] iArr4 = new int[i3];
            int[] iArr5 = new int[i3];
            int[] iArr6 = new int[Math.max(width, height)];
            int i7 = (i6 + 1) >> 1;
            int i8 = i7 * i7;
            int i9 = i8 * 256;
            int[] iArr7 = new int[i9];
            for (int i10 = 0; i10 < i9; i10++) {
                iArr7[i10] = i10 / i8;
            }
            int[][] iArr8 = (int[][]) Array.newInstance(int.class, i6, 3);
            int i11 = i2 + 1;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i12 < height) {
                Bitmap bitmap2 = createBitmap;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                int i22 = 0;
                int i23 = -i2;
                int i24 = 0;
                while (i23 <= i2) {
                    int i25 = height;
                    int i26 = i5;
                    int i27 = iArr2[i13 + Math.min(i4, Math.max(i23, 0))];
                    int[] iArr9 = iArr8[i23 + i2];
                    iArr9[0] = (i27 & 16711680) >> 16;
                    iArr9[1] = (i27 & 65280) >> 8;
                    iArr9[2] = i27 & 255;
                    int abs = i11 - Math.abs(i23);
                    i24 += iArr9[0] * abs;
                    i15 += iArr9[1] * abs;
                    i16 += iArr9[2] * abs;
                    if (i23 > 0) {
                        i20 += iArr9[0];
                        i21 += iArr9[1];
                        i22 += iArr9[2];
                    } else {
                        i17 += iArr9[0];
                        i18 += iArr9[1];
                        i19 += iArr9[2];
                    }
                    i23++;
                    height = i25;
                    i5 = i26;
                }
                int i28 = height;
                int i29 = i5;
                int i30 = i2;
                int i31 = i24;
                int i32 = 0;
                while (i32 < width) {
                    iArr3[i13] = iArr7[i31];
                    iArr4[i13] = iArr7[i15];
                    iArr5[i13] = iArr7[i16];
                    int i33 = i31 - i17;
                    int i34 = i15 - i18;
                    int i35 = i16 - i19;
                    int[] iArr10 = iArr8[((i30 - i2) + i6) % i6];
                    int i36 = i17 - iArr10[0];
                    int i37 = i18 - iArr10[1];
                    int i38 = i19 - iArr10[2];
                    if (i12 == 0) {
                        iArr = iArr7;
                        iArr6[i32] = Math.min(i32 + i2 + 1, i4);
                    } else {
                        iArr = iArr7;
                    }
                    int i39 = iArr2[i14 + iArr6[i32]];
                    iArr10[0] = (i39 & 16711680) >> 16;
                    iArr10[1] = (i39 & 65280) >> 8;
                    iArr10[2] = i39 & 255;
                    int i40 = i20 + iArr10[0];
                    int i41 = i21 + iArr10[1];
                    int i42 = i22 + iArr10[2];
                    i31 = i33 + i40;
                    i15 = i34 + i41;
                    i16 = i35 + i42;
                    i30 = (i30 + 1) % i6;
                    int[] iArr11 = iArr8[i30 % i6];
                    i17 = i36 + iArr11[0];
                    i18 = i37 + iArr11[1];
                    i19 = i38 + iArr11[2];
                    i20 = i40 - iArr11[0];
                    i21 = i41 - iArr11[1];
                    i22 = i42 - iArr11[2];
                    i13++;
                    i32++;
                    iArr7 = iArr;
                }
                i14 += width;
                i12++;
                createBitmap = bitmap2;
                height = i28;
                i5 = i29;
            }
            int i43 = height;
            int i44 = i5;
            int[] iArr12 = iArr7;
            Bitmap bitmap3 = createBitmap;
            int i45 = 0;
            while (i45 < width) {
                int i46 = -i2;
                int i47 = i6;
                int[] iArr13 = iArr6;
                int i48 = 0;
                int i49 = 0;
                int i50 = 0;
                int i51 = 0;
                int i52 = 0;
                int i53 = 0;
                int i54 = 0;
                int i55 = i46;
                int i56 = i46 * width;
                int i57 = 0;
                int i58 = 0;
                while (i55 <= i2) {
                    int i59 = width;
                    int max = Math.max(0, i56) + i45;
                    int[] iArr14 = iArr8[i55 + i2];
                    iArr14[0] = iArr3[max];
                    iArr14[1] = iArr4[max];
                    iArr14[2] = iArr5[max];
                    int abs2 = i11 - Math.abs(i55);
                    i57 += iArr3[max] * abs2;
                    i58 += iArr4[max] * abs2;
                    i48 += iArr5[max] * abs2;
                    if (i55 > 0) {
                        i52 += iArr14[0];
                        i53 += iArr14[1];
                        i54 += iArr14[2];
                    } else {
                        i49 += iArr14[0];
                        i50 += iArr14[1];
                        i51 += iArr14[2];
                    }
                    int i60 = i44;
                    if (i55 < i60) {
                        i56 += i59;
                    }
                    i55++;
                    i44 = i60;
                    width = i59;
                }
                int i61 = width;
                int i62 = i44;
                int i63 = i2;
                int i64 = i45;
                int i65 = i43;
                int i66 = 0;
                while (i66 < i65) {
                    iArr2[i64] = (iArr2[i64] & (-16777216)) | (iArr12[i57] << 16) | (iArr12[i58] << 8) | iArr12[i48];
                    int i67 = i57 - i49;
                    int i68 = i58 - i50;
                    int i69 = i48 - i51;
                    int[] iArr15 = iArr8[((i63 - i2) + i47) % i47];
                    int i70 = i49 - iArr15[0];
                    int i71 = i50 - iArr15[1];
                    int i72 = i51 - iArr15[2];
                    if (i45 == 0) {
                        iArr13[i66] = Math.min(i66 + i11, i62) * i61;
                    }
                    int i73 = iArr13[i66] + i45;
                    iArr15[0] = iArr3[i73];
                    iArr15[1] = iArr4[i73];
                    iArr15[2] = iArr5[i73];
                    int i74 = i52 + iArr15[0];
                    int i75 = i53 + iArr15[1];
                    int i76 = i54 + iArr15[2];
                    i57 = i67 + i74;
                    i58 = i68 + i75;
                    i48 = i69 + i76;
                    i63 = (i63 + 1) % i47;
                    int[] iArr16 = iArr8[i63];
                    i49 = i70 + iArr16[0];
                    i50 = i71 + iArr16[1];
                    i51 = i72 + iArr16[2];
                    i52 = i74 - iArr16[0];
                    i53 = i75 - iArr16[1];
                    i54 = i76 - iArr16[2];
                    i64 += i61;
                    i66++;
                    i2 = i;
                }
                i45++;
                i2 = i;
                i44 = i62;
                i43 = i65;
                iArr6 = iArr13;
                i6 = i47;
                width = i61;
            }
            int i77 = width;
            bitmap3.setPixels(iArr2, 0, i77, 0, 0, i77, i43);
            return bitmap3;
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
