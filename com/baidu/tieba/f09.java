package com.baidu.tieba;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long[] a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (i < 0) {
                i = 0;
            }
            float[] fArr = new float[i];
            if (i > 1) {
                float f = 1.0f / i;
                int i2 = 0;
                while (i2 < i) {
                    int i3 = i2 + 1;
                    if (i3 == i) {
                        int i4 = i2 - 1;
                        fArr[i2] = fArr[i4] + ((1.0f - fArr[i4]) / 2.0f);
                    } else {
                        fArr[i2] = i3 * f;
                    }
                    i2 = i3;
                }
            } else if (i == 1) {
                fArr[0] = 0.5f;
            }
            long[] jArr = new long[i];
            for (int i5 = 0; i5 < i; i5++) {
                jArr[i5] = fArr[i5] * ((float) j) * 1000.0f;
            }
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static i09 b(k09 k09Var, a09 a09Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, k09Var, a09Var)) == null) {
            if (k09Var == null || a09Var == null || k09Var.e == null) {
                return null;
            }
            long[] a = a(k09Var.b, k09Var.a);
            MultiMediaData multiMediaData = k09Var.e;
            i09 i09Var = new i09();
            i09Var.e = new ArrayList();
            i09Var.a = multiMediaData.path;
            i09Var.c = k09Var.c;
            i09Var.d = k09Var.d;
            i09Var.b = multiMediaData.rotation;
            for (int i = 0; i < k09Var.b; i++) {
                long j = multiMediaData.start + a[i];
                c09 c09Var = new c09();
                c09Var.a = vz8.b(multiMediaData.path, j, multiMediaData.type);
                c09Var.b = multiMediaData.path;
                c09Var.f = i;
                c09Var.g = multiMediaData.type;
                c09Var.h = k09Var.c;
                c09Var.i = k09Var.d;
                c09Var.j = a09Var;
                c09Var.d = j;
                c09Var.c = multiMediaData.rotation;
                i09Var.e.add(c09Var);
            }
            return i09Var;
        }
        return (i09) invokeLL.objValue;
    }

    public static List<i09> c(j09 j09Var, a09 a09Var) {
        InterceptResult invokeLL;
        List<c09> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, j09Var, a09Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (j09Var == null || a09Var == null || j09Var.b <= 0 || gg9.e(j09Var.e) || gg9.e(j09Var.f)) {
                return null;
            }
            long[] a = a(j09Var.b, j09Var.a);
            ArrayList arrayList = new ArrayList();
            i09 i09Var = null;
            for (int i = 0; i < j09Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(j09Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) gg9.c(j09Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        i09Var = new i09();
                        i09Var.e = new ArrayList();
                        i09Var.a = multiMediaData2.path;
                        i09Var.c = j09Var.c;
                        i09Var.d = j09Var.d;
                        i09Var.b = multiMediaData2.rotation;
                        arrayList.add(i09Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) gg9.c(j09Var.e, findInputIndexInSegments), j) * 1000;
                    c09 c09Var = new c09();
                    c09Var.a = vz8.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    c09Var.b = multiMediaData2.path;
                    c09Var.f = i;
                    c09Var.g = multiMediaData2.type;
                    c09Var.h = j09Var.c;
                    c09Var.i = j09Var.d;
                    c09Var.d = multiMediaDataSeekTime;
                    c09Var.j = a09Var;
                    c09Var.c = multiMediaData2.rotation;
                    if (i09Var != null && (list = i09Var.e) != null) {
                        list.add(c09Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
