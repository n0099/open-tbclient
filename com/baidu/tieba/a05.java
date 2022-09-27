package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.core.util.resourceLoaderProc.DiskCancelWorker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a05 implements ah<yz4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a05() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah
    /* renamed from: a */
    public yz4 getFromLocal(String str, String str2, int i, int i2, xg xgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), xgVar, objArr})) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            diskFileOperate.setSubFolder(false);
            diskFileOperate.setIsFormatData(false);
            if (xgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskFileOperate);
                xgVar.a = diskCancelWorker;
            }
            diskFileOperate.call();
            if (diskFileOperate.isSuccess()) {
                String desPath = diskFileOperate.getDesPath();
                yz4 yz4Var = new yz4();
                yz4Var.a = str;
                yz4Var.b = desPath;
                return yz4Var;
            }
            return null;
        }
        return (yz4) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah
    /* renamed from: b */
    public yz4 getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (yz4) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah
    /* renamed from: c */
    public yz4 getFromRemote(String str, String str2, int i, int i2, xg xgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), xgVar, objArr})) == null) {
            int i3 = 1;
            String str3 = null;
            String valueOf = objArr.length == 1 ? String.valueOf(objArr[0]) : null;
            yz4 yz4Var = new yz4();
            WebClient webClient = new WebClient();
            if (xgVar != null) {
                xgVar.a = webClient;
            }
            String str4 = TbConfig.SERVER_ADDRESS + TbConfig.VOICE_DATA + "?voice_md5=" + str;
            if (!TextUtils.isEmpty(valueOf)) {
                str4 = str4 + "&play_from=" + valueOf;
            }
            byte[] downloadCommonBytes = webClient.downloadCommonBytes(str4);
            if (!webClient.IsRequestSuccess()) {
                yz4Var.c = 3;
                yz4Var.d = wj.a(R.string.obfuscated_res_0x7f0f0c59);
                return yz4Var;
            } else if (downloadCommonBytes == null || downloadCommonBytes.length == 0) {
                yz4Var.c = 4;
                yz4Var.d = wj.a(R.string.obfuscated_res_0x7f0f1580);
                return yz4Var;
            } else {
                if (str == null) {
                    i3 = 5;
                } else if (downloadCommonBytes == null || downloadCommonBytes.length == 0) {
                    i3 = 6;
                } else {
                    DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                    diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                    diskFileOperate.setSubFolder(false);
                    diskFileOperate.setData(downloadCommonBytes);
                    if (xgVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(diskFileOperate);
                        xgVar.a = diskCancelWorker;
                    }
                    diskFileOperate.call();
                    if (diskFileOperate.isSuccess() && diskFileOperate.getFileInfo() != null) {
                        str3 = diskFileOperate.getFileInfo().getAbsolutePath();
                        i3 = 0;
                    } else if (FileHelper.getAvailableSize() < downloadCommonBytes.length) {
                        i3 = 2;
                    }
                }
                if (i3 == 0) {
                    yz4Var.b = str3;
                    yz4Var.a = str;
                } else {
                    yz4Var.c = i3;
                    yz4Var.d = yz4.a(i3);
                }
                return yz4Var;
            }
        }
        return (yz4) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ah
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ah
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ah
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ah
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) {
        }
    }
}
