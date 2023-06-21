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
public class cfa {
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

    public static ffa b(hfa hfaVar, xea xeaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, hfaVar, xeaVar)) == null) {
            if (hfaVar == null || xeaVar == null || hfaVar.e == null) {
                return null;
            }
            long[] a = a(hfaVar.b, hfaVar.a);
            MultiMediaData multiMediaData = hfaVar.e;
            ffa ffaVar = new ffa();
            ffaVar.e = new ArrayList();
            ffaVar.a = multiMediaData.path;
            ffaVar.c = hfaVar.c;
            ffaVar.d = hfaVar.d;
            ffaVar.b = multiMediaData.rotation;
            for (int i = 0; i < hfaVar.b; i++) {
                long j = multiMediaData.start + a[i];
                zea zeaVar = new zea();
                zeaVar.a = sea.b(multiMediaData.path, j, multiMediaData.type);
                zeaVar.b = multiMediaData.path;
                zeaVar.f = i;
                zeaVar.g = multiMediaData.type;
                zeaVar.h = hfaVar.c;
                zeaVar.i = hfaVar.d;
                zeaVar.j = xeaVar;
                zeaVar.d = j;
                zeaVar.c = multiMediaData.rotation;
                ffaVar.e.add(zeaVar);
            }
            return ffaVar;
        }
        return (ffa) invokeLL.objValue;
    }

    public static List<ffa> c(gfa gfaVar, xea xeaVar) {
        InterceptResult invokeLL;
        List<zea> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, gfaVar, xeaVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (gfaVar == null || xeaVar == null || gfaVar.b <= 0 || wwa.e(gfaVar.e) || wwa.e(gfaVar.f)) {
                return null;
            }
            long[] a = a(gfaVar.b, gfaVar.a);
            ArrayList arrayList = new ArrayList();
            ffa ffaVar = null;
            for (int i = 0; i < gfaVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(gfaVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) wwa.c(gfaVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        ffaVar = new ffa();
                        ffaVar.e = new ArrayList();
                        ffaVar.a = multiMediaData2.path;
                        ffaVar.c = gfaVar.c;
                        ffaVar.d = gfaVar.d;
                        ffaVar.b = multiMediaData2.rotation;
                        arrayList.add(ffaVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) wwa.c(gfaVar.e, findInputIndexInSegments), j) * 1000;
                    zea zeaVar = new zea();
                    zeaVar.a = sea.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    zeaVar.b = multiMediaData2.path;
                    zeaVar.f = i;
                    zeaVar.g = multiMediaData2.type;
                    zeaVar.h = gfaVar.c;
                    zeaVar.i = gfaVar.d;
                    zeaVar.d = multiMediaDataSeekTime;
                    zeaVar.j = xeaVar;
                    zeaVar.c = multiMediaData2.rotation;
                    if (ffaVar != null && (list = ffaVar.e) != null) {
                        list.add(zeaVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
