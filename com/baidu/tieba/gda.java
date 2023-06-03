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
public class gda {
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

    public static jda b(lda ldaVar, bda bdaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ldaVar, bdaVar)) == null) {
            if (ldaVar == null || bdaVar == null || ldaVar.e == null) {
                return null;
            }
            long[] a = a(ldaVar.b, ldaVar.a);
            MultiMediaData multiMediaData = ldaVar.e;
            jda jdaVar = new jda();
            jdaVar.e = new ArrayList();
            jdaVar.a = multiMediaData.path;
            jdaVar.c = ldaVar.c;
            jdaVar.d = ldaVar.d;
            jdaVar.b = multiMediaData.rotation;
            for (int i = 0; i < ldaVar.b; i++) {
                long j = multiMediaData.start + a[i];
                dda ddaVar = new dda();
                ddaVar.a = wca.b(multiMediaData.path, j, multiMediaData.type);
                ddaVar.b = multiMediaData.path;
                ddaVar.f = i;
                ddaVar.g = multiMediaData.type;
                ddaVar.h = ldaVar.c;
                ddaVar.i = ldaVar.d;
                ddaVar.j = bdaVar;
                ddaVar.d = j;
                ddaVar.c = multiMediaData.rotation;
                jdaVar.e.add(ddaVar);
            }
            return jdaVar;
        }
        return (jda) invokeLL.objValue;
    }

    public static List<jda> c(kda kdaVar, bda bdaVar) {
        InterceptResult invokeLL;
        List<dda> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, kdaVar, bdaVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (kdaVar == null || bdaVar == null || kdaVar.b <= 0 || yua.e(kdaVar.e) || yua.e(kdaVar.f)) {
                return null;
            }
            long[] a = a(kdaVar.b, kdaVar.a);
            ArrayList arrayList = new ArrayList();
            jda jdaVar = null;
            for (int i = 0; i < kdaVar.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(kdaVar.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) yua.c(kdaVar.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        jdaVar = new jda();
                        jdaVar.e = new ArrayList();
                        jdaVar.a = multiMediaData2.path;
                        jdaVar.c = kdaVar.c;
                        jdaVar.d = kdaVar.d;
                        jdaVar.b = multiMediaData2.rotation;
                        arrayList.add(jdaVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) yua.c(kdaVar.e, findInputIndexInSegments), j) * 1000;
                    dda ddaVar = new dda();
                    ddaVar.a = wca.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    ddaVar.b = multiMediaData2.path;
                    ddaVar.f = i;
                    ddaVar.g = multiMediaData2.type;
                    ddaVar.h = kdaVar.c;
                    ddaVar.i = kdaVar.d;
                    ddaVar.d = multiMediaDataSeekTime;
                    ddaVar.j = bdaVar;
                    ddaVar.c = multiMediaData2.rotation;
                    if (jdaVar != null && (list = jdaVar.e) != null) {
                        list.add(ddaVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
