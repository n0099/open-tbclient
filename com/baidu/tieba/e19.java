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
public class e19 {
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

    public static h19 b(j19 j19Var, z09 z09Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, j19Var, z09Var)) == null) {
            if (j19Var == null || z09Var == null || j19Var.e == null) {
                return null;
            }
            long[] a = a(j19Var.b, j19Var.a);
            MultiMediaData multiMediaData = j19Var.e;
            h19 h19Var = new h19();
            h19Var.e = new ArrayList();
            h19Var.a = multiMediaData.path;
            h19Var.c = j19Var.c;
            h19Var.d = j19Var.d;
            h19Var.b = multiMediaData.rotation;
            for (int i = 0; i < j19Var.b; i++) {
                long j = multiMediaData.start + a[i];
                b19 b19Var = new b19();
                b19Var.a = u09.b(multiMediaData.path, j, multiMediaData.type);
                b19Var.b = multiMediaData.path;
                b19Var.f = i;
                b19Var.g = multiMediaData.type;
                b19Var.h = j19Var.c;
                b19Var.i = j19Var.d;
                b19Var.j = z09Var;
                b19Var.d = j;
                b19Var.c = multiMediaData.rotation;
                h19Var.e.add(b19Var);
            }
            return h19Var;
        }
        return (h19) invokeLL.objValue;
    }

    public static List c(i19 i19Var, z09 z09Var) {
        InterceptResult invokeLL;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, i19Var, z09Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (i19Var == null || z09Var == null || i19Var.b <= 0 || nh9.e(i19Var.e) || nh9.e(i19Var.f)) {
                return null;
            }
            long[] a = a(i19Var.b, i19Var.a);
            ArrayList arrayList = new ArrayList();
            h19 h19Var = null;
            for (int i = 0; i < i19Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(i19Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) nh9.c(i19Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        h19Var = new h19();
                        h19Var.e = new ArrayList();
                        h19Var.a = multiMediaData2.path;
                        h19Var.c = i19Var.c;
                        h19Var.d = i19Var.d;
                        h19Var.b = multiMediaData2.rotation;
                        arrayList.add(h19Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) nh9.c(i19Var.e, findInputIndexInSegments), j) * 1000;
                    b19 b19Var = new b19();
                    b19Var.a = u09.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    b19Var.b = multiMediaData2.path;
                    b19Var.f = i;
                    b19Var.g = multiMediaData2.type;
                    b19Var.h = i19Var.c;
                    b19Var.i = i19Var.d;
                    b19Var.d = multiMediaDataSeekTime;
                    b19Var.j = z09Var;
                    b19Var.c = multiMediaData2.rotation;
                    if (h19Var != null && (list = h19Var.e) != null) {
                        list.add(b19Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
