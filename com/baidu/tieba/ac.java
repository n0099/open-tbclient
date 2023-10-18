package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import com.baidu.searchbox.retrieve.core.task.UploadTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class ac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<tb> a(qb qbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qbVar)) == null) {
            ArrayList arrayList = new ArrayList();
            File[] b = sb.b(qbVar.C());
            if (b != null) {
                for (File file : b) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith(qbVar.h()) && name.contains("Uploading")) {
                            arrayList.add(new tb(name, file.length(), file.lastModified()));
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<tb> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                tb tbVar = (tb) it.next();
                if (tbVar != null) {
                    long j = tbVar.c;
                    if (j != 0 && j + 604800000 < currentTimeMillis) {
                        arrayList3.add(tbVar.b);
                    } else {
                        arrayList2.add(tbVar);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                sb.a(arrayList3, qbVar.C());
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static BdUploadingLogInfo b(qb qbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qbVar)) == null) {
            ArrayList<tb> a = a(qbVar);
            BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getTrackLogWriteDir(), qbVar.C(), qbVar.A());
            if (a != null && a.size() > 0) {
                if (a.size() > 1) {
                    Collections.sort(a, new ub());
                }
                ArrayList arrayList = new ArrayList();
                int size = a.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    tb tbVar = a.get(i);
                    j += tbVar.a;
                    arrayList.add(tbVar);
                    if (j >= UploadTask.SIZE_LIMIT_DEFAULT) {
                        bdUploadingLogInfo.add(arrayList);
                        arrayList = new ArrayList();
                        j = 0;
                    }
                }
                if (arrayList.size() > 0) {
                    bdUploadingLogInfo.add(arrayList);
                }
            }
            return bdUploadingLogInfo;
        }
        return (BdUploadingLogInfo) invokeL.objValue;
    }
}
