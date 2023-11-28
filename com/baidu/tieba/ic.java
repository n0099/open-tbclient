package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ArrayList<String> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65536, null, arrayList, z) == null) {
            r7 r7Var = new r7(BdStatisticsManager.getInstance().getWriteDir(), null, DiskFileOperate.Action.DELETE_FILES, arrayList);
            r7Var.setSdCard(z);
            r7Var.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            k7.g().a(r7Var);
        }
    }

    public static File[] b(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        File[] fileArr;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), null, DiskFileOperate.Action.INFO);
            diskFileOperate.setSdCard(z);
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            k7.g().d(diskFileOperate);
            File fileInfo = diskFileOperate.getFileInfo();
            if (fileInfo != null) {
                fileArr = fileInfo.listFiles();
            } else {
                fileArr = null;
            }
            if (z2) {
                DiskFileOperate diskFileOperate2 = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), null, DiskFileOperate.Action.INFO);
                diskFileOperate2.setSdCard(z);
                diskFileOperate2.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                k7.g().d(diskFileOperate2);
                if (diskFileOperate2.getFileInfo() != null && (listFiles = diskFileOperate2.getFileInfo().listFiles()) != null && listFiles.length != 0) {
                    if (fileArr != null && fileArr.length != 0) {
                        File[] fileArr2 = new File[listFiles.length + fileArr.length];
                        System.arraycopy(fileArr, 0, fileArr2, 0, fileArr.length);
                        System.arraycopy(listFiles, 0, fileArr2, fileArr.length, listFiles.length);
                        return fileArr2;
                    }
                    return listFiles;
                }
            }
            return fileArr;
        }
        return (File[]) invokeCommon.objValue;
    }

    public static ArrayList<kc> c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            ArrayList<kc> arrayList = new ArrayList<>();
            File[] b = b(z, true);
            if (b != null) {
                for (File file : b) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (!TextUtils.isEmpty(name)) {
                            arrayList.add(new kc(name, file.length(), file.lastModified()));
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeZ.objValue;
    }
}
