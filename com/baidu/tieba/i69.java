package com.baidu.tieba;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i69 {
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

    public static l69 b(n69 n69Var, d69 d69Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, n69Var, d69Var)) == null) {
            if (n69Var == null || d69Var == null || n69Var.e == null) {
                return null;
            }
            long[] a = a(n69Var.b, n69Var.a);
            MultiMediaData multiMediaData = n69Var.e;
            l69 l69Var = new l69();
            l69Var.e = new ArrayList();
            l69Var.a = multiMediaData.path;
            l69Var.c = n69Var.c;
            l69Var.d = n69Var.d;
            l69Var.b = multiMediaData.rotation;
            for (int i = 0; i < n69Var.b; i++) {
                long j = multiMediaData.start + a[i];
                f69 f69Var = new f69();
                f69Var.a = y59.b(multiMediaData.path, j, multiMediaData.type);
                f69Var.b = multiMediaData.path;
                f69Var.f = i;
                f69Var.g = multiMediaData.type;
                f69Var.h = n69Var.c;
                f69Var.i = n69Var.d;
                f69Var.j = d69Var;
                f69Var.d = j;
                f69Var.c = multiMediaData.rotation;
                l69Var.e.add(f69Var);
            }
            return l69Var;
        }
        return (l69) invokeLL.objValue;
    }

    public static List<l69> c(m69 m69Var, d69 d69Var) {
        InterceptResult invokeLL;
        List<f69> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, m69Var, d69Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (m69Var == null || d69Var == null || m69Var.b <= 0 || rm9.e(m69Var.e) || rm9.e(m69Var.f)) {
                return null;
            }
            long[] a = a(m69Var.b, m69Var.a);
            ArrayList arrayList = new ArrayList();
            l69 l69Var = null;
            for (int i = 0; i < m69Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(m69Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) rm9.c(m69Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        l69Var = new l69();
                        l69Var.e = new ArrayList();
                        l69Var.a = multiMediaData2.path;
                        l69Var.c = m69Var.c;
                        l69Var.d = m69Var.d;
                        l69Var.b = multiMediaData2.rotation;
                        arrayList.add(l69Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) rm9.c(m69Var.e, findInputIndexInSegments), j) * 1000;
                    f69 f69Var = new f69();
                    f69Var.a = y59.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    f69Var.b = multiMediaData2.path;
                    f69Var.f = i;
                    f69Var.g = multiMediaData2.type;
                    f69Var.h = m69Var.c;
                    f69Var.i = m69Var.d;
                    f69Var.d = multiMediaDataSeekTime;
                    f69Var.j = d69Var;
                    f69Var.c = multiMediaData2.rotation;
                    if (l69Var != null && (list = l69Var.e) != null) {
                        list.add(f69Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
