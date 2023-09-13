package com.baidu.tieba;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class cya {
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

    public static fya b(hya hyaVar, xxa xxaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, hyaVar, xxaVar)) == null) {
            if (hyaVar == null || xxaVar == null || hyaVar.e == null) {
                return null;
            }
            long[] a = a(hyaVar.b, hyaVar.a);
            MultiMediaData multiMediaData = hyaVar.e;
            fya fyaVar = new fya();
            fyaVar.e = new ArrayList();
            fyaVar.a = multiMediaData.path;
            fyaVar.c = hyaVar.c;
            fyaVar.d = hyaVar.d;
            fyaVar.b = multiMediaData.rotation;
            for (int i = 0; i < hyaVar.b; i++) {
                long j = multiMediaData.start + a[i];
                zxa zxaVar = new zxa();
                zxaVar.a = sxa.b(multiMediaData.path, j, multiMediaData.type);
                zxaVar.b = multiMediaData.path;
                zxaVar.f = i;
                zxaVar.g = multiMediaData.type;
                zxaVar.h = hyaVar.c;
                zxaVar.i = hyaVar.d;
                zxaVar.j = xxaVar;
                zxaVar.d = j;
                zxaVar.c = multiMediaData.rotation;
                fyaVar.e.add(zxaVar);
            }
            return fyaVar;
        }
        return (fya) invokeLL.objValue;
    }

    public static List<fya> c(gya gyaVar, xxa xxaVar) {
        InterceptResult invokeLL;
        List<zxa> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, gyaVar, xxaVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (gyaVar == null || xxaVar == null || gyaVar.b <= 0 || nib.e(gyaVar.e) || nib.e(gyaVar.f)) {
                return null;
            }
            long[] a = a(gyaVar.b, gyaVar.a);
            ArrayList arrayList = new ArrayList();
            fya fyaVar = null;
            for (int i = 0; i < gyaVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(gyaVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) nib.c(gyaVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        fyaVar = new fya();
                        fyaVar.e = new ArrayList();
                        fyaVar.a = multiMediaData2.path;
                        fyaVar.c = gyaVar.c;
                        fyaVar.d = gyaVar.d;
                        fyaVar.b = multiMediaData2.rotation;
                        arrayList.add(fyaVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) nib.c(gyaVar.e, findInputIndexInSegments), j) * 1000;
                    zxa zxaVar = new zxa();
                    zxaVar.a = sxa.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    zxaVar.b = multiMediaData2.path;
                    zxaVar.f = i;
                    zxaVar.g = multiMediaData2.type;
                    zxaVar.h = gyaVar.c;
                    zxaVar.i = gyaVar.d;
                    zxaVar.d = multiMediaDataSeekTime;
                    zxaVar.j = xxaVar;
                    zxaVar.c = multiMediaData2.rotation;
                    if (fyaVar != null && (list = fyaVar.e) != null) {
                        list.add(zxaVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
