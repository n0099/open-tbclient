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
public class eh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<xg> a(ug ugVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ugVar)) == null) {
            ArrayList arrayList = new ArrayList();
            File[] b = wg.b(ugVar.C());
            if (b != null) {
                for (File file : b) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith(ugVar.h()) && name.contains("Uploading")) {
                            arrayList.add(new xg(name, file.length(), file.lastModified()));
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<xg> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                xg xgVar = (xg) it.next();
                if (xgVar != null) {
                    long j = xgVar.c;
                    if (j != 0 && j + 604800000 < currentTimeMillis) {
                        arrayList3.add(xgVar.b);
                    } else {
                        arrayList2.add(xgVar);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                wg.a(arrayList3, ugVar.C());
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static BdUploadingLogInfo b(ug ugVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ugVar)) == null) {
            ArrayList<xg> a = a(ugVar);
            BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getTrackLogWriteDir(), ugVar.C(), ugVar.A());
            if (a != null && a.size() > 0) {
                if (a.size() > 1) {
                    Collections.sort(a, new yg());
                }
                ArrayList arrayList = new ArrayList();
                int size = a.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    xg xgVar = a.get(i);
                    j += xgVar.a;
                    arrayList.add(xgVar);
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
