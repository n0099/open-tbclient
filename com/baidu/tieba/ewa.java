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
public class ewa {
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

    public static hwa b(jwa jwaVar, zva zvaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jwaVar, zvaVar)) == null) {
            if (jwaVar == null || zvaVar == null || jwaVar.e == null) {
                return null;
            }
            long[] a = a(jwaVar.b, jwaVar.a);
            MultiMediaData multiMediaData = jwaVar.e;
            hwa hwaVar = new hwa();
            hwaVar.e = new ArrayList();
            hwaVar.a = multiMediaData.path;
            hwaVar.c = jwaVar.c;
            hwaVar.d = jwaVar.d;
            hwaVar.b = multiMediaData.rotation;
            for (int i = 0; i < jwaVar.b; i++) {
                long j = multiMediaData.start + a[i];
                bwa bwaVar = new bwa();
                bwaVar.a = uva.b(multiMediaData.path, j, multiMediaData.type);
                bwaVar.b = multiMediaData.path;
                bwaVar.f = i;
                bwaVar.g = multiMediaData.type;
                bwaVar.h = jwaVar.c;
                bwaVar.i = jwaVar.d;
                bwaVar.j = zvaVar;
                bwaVar.d = j;
                bwaVar.c = multiMediaData.rotation;
                hwaVar.e.add(bwaVar);
            }
            return hwaVar;
        }
        return (hwa) invokeLL.objValue;
    }

    public static List<hwa> c(iwa iwaVar, zva zvaVar) {
        InterceptResult invokeLL;
        List<bwa> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, iwaVar, zvaVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (iwaVar == null || zvaVar == null || iwaVar.b <= 0 || fgb.e(iwaVar.e) || fgb.e(iwaVar.f)) {
                return null;
            }
            long[] a = a(iwaVar.b, iwaVar.a);
            ArrayList arrayList = new ArrayList();
            hwa hwaVar = null;
            for (int i = 0; i < iwaVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(iwaVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) fgb.c(iwaVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        hwaVar = new hwa();
                        hwaVar.e = new ArrayList();
                        hwaVar.a = multiMediaData2.path;
                        hwaVar.c = iwaVar.c;
                        hwaVar.d = iwaVar.d;
                        hwaVar.b = multiMediaData2.rotation;
                        arrayList.add(hwaVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) fgb.c(iwaVar.e, findInputIndexInSegments), j) * 1000;
                    bwa bwaVar = new bwa();
                    bwaVar.a = uva.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    bwaVar.b = multiMediaData2.path;
                    bwaVar.f = i;
                    bwaVar.g = multiMediaData2.type;
                    bwaVar.h = iwaVar.c;
                    bwaVar.i = iwaVar.d;
                    bwaVar.d = multiMediaDataSeekTime;
                    bwaVar.j = zvaVar;
                    bwaVar.c = multiMediaData2.rotation;
                    if (hwaVar != null && (list = hwaVar.e) != null) {
                        list.add(bwaVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
