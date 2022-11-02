package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DiskEmotionOperate;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.core.util.resourceLoaderProc.DiskCancelWorker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class da6 implements tg<hn> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ua5 a;

    @Override // com.baidu.tieba.tg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public da6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ua5.b;
    }

    @Override // com.baidu.tieba.tg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return ar4.c().g();
        }
        return invokeV.booleanValue;
    }

    public final String a(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (z) {
                str2 = "_gif";
            } else {
                str2 = "";
            }
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tg
    /* renamed from: b */
    public hn getFromLocal(String str, String str2, int i, int i2, qg qgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        hn hnVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), qgVar, objArr})) == null) {
            hn hnVar2 = null;
            if (objArr == null || objArr.length != 4) {
                return null;
            }
            String str3 = "";
            if (objArr[0] == null) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(objArr[0]);
            }
            if (objArr[1] != null) {
                str3 = String.valueOf(objArr[1]);
            }
            Boolean valueOf2 = Boolean.valueOf(String.valueOf(objArr[2]));
            if (valueOf == null || str3 == null || valueOf2 == null) {
                return null;
            }
            g(str3);
            ArrayList<w65> i3 = ia6.k().i();
            if ((ia6.k().q(str3) || ia6.k().r(str3)) && valueOf2.booleanValue() && !new File(ia6.k().g(str3, true)).exists()) {
                valueOf2 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf2.booleanValue();
            if (ia6.k().o(str3) && valueOf2.booleanValue()) {
                String g = ia6.k().g(str3, true);
                String h = ia6.k().h(str3);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf2 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf2.booleanValue()) {
                String g2 = ia6.k().g(str3, true);
                Iterator<w65> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    w65 next = it.next();
                    if (next.m(str3)) {
                        if (next.j()) {
                            hnVar2 = next.n(str3);
                        } else {
                            hnVar2 = e(next.f(), g2, qgVar);
                        }
                    }
                }
                if (hnVar2 == null && valueOf != null) {
                    return e(valueOf, g2, qgVar);
                }
                return hnVar2;
            }
            String g3 = ia6.k().g(str3, false);
            if (booleanValue && ia6.k().o(str3)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<w65> it2 = i3.iterator();
            hn hnVar3 = null;
            while (true) {
                if (it2.hasNext()) {
                    w65 next2 = it2.next();
                    if (next2.m(str3)) {
                        if (next2.j()) {
                            hnVar3 = next2.o(str3);
                        } else {
                            Bitmap f2 = f(next2.f(), g3, qgVar);
                            if (f2 == null) {
                                return null;
                            }
                            hnVar = new hn(f2, false, str3);
                        }
                    }
                } else {
                    hnVar = hnVar3;
                    break;
                }
            }
            if (hnVar == null && valueOf != null && (f = f(valueOf, g3, qgVar)) != null) {
                return new hn(f, false, str3);
            }
            return hnVar;
        }
        return (hn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tg
    /* renamed from: d */
    public hn getFromRemote(String str, String str2, int i, int i2, qg qgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        String valueOf2;
        String valueOf3;
        hn hnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), qgVar, objArr})) == null) {
            if (objArr != null && objArr.length == 4) {
                if (objArr[0] == null) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(objArr[0]);
                }
                if (objArr[1] == null) {
                    valueOf2 = "";
                } else {
                    valueOf2 = String.valueOf(objArr[1]);
                }
                Boolean valueOf4 = Boolean.valueOf(String.valueOf(objArr[2]));
                if (objArr[3] == null) {
                    valueOf3 = "";
                } else {
                    valueOf3 = String.valueOf(objArr[3]);
                }
                if (valueOf != null && valueOf2 != null && valueOf4 != null && valueOf3 != null) {
                    pi5.g(da6.class.getSimpleName(), valueOf3);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf3, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = ia6.k().g(valueOf2, valueOf4.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf4.booleanValue()) {
                                mc mcVar = new mc(str3, g, DiskFileOperate.Action.WRITE);
                                mcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                mcVar.setSubFolder(false);
                                mcVar.setSavedCache(false);
                                mcVar.setSdCard(false);
                                mcVar.setData(downloadImageBytes);
                                kc.f().call(mcVar);
                                if (qgVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(mcVar);
                                    qgVar.a = diskCancelWorker;
                                }
                                Iterator<w65> it = ia6.k().i().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        w65 next = it.next();
                                        if (next.m(valueOf2)) {
                                            hnVar = e(next.f(), g, qgVar);
                                            break;
                                        }
                                    } else {
                                        hnVar = null;
                                        break;
                                    }
                                }
                                if (hnVar == null && valueOf != null) {
                                    hnVar = e(valueOf, g, qgVar);
                                }
                                if (hnVar == null) {
                                    return null;
                                }
                            } else {
                                e95.k().i(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                hn hnVar2 = new hn(checkBitmapSize, valueOf4.booleanValue(), valueOf3);
                                hnVar2.y(needCache);
                                if (needCache) {
                                    oc ocVar = new oc(str3, g, DiskFileOperate.Action.WRITE);
                                    ocVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    ocVar.setSubFolder(false);
                                    ocVar.setData(downloadImageBytes);
                                    ocVar.setSavedCache(false);
                                    ocVar.setSdCard(false);
                                    ocVar.setGif(valueOf4.booleanValue());
                                    kc.f().a(ocVar);
                                    if (qgVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(ocVar);
                                        qgVar.a = diskCancelWorker2;
                                    }
                                }
                                hnVar = hnVar2;
                            }
                            return hnVar;
                        }
                    }
                }
            }
            return null;
        }
        return (hn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tg
    /* renamed from: c */
    public hn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return e95.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
        }
        return (hn) invokeCommon.objValue;
    }

    public hn e(String str, String str2, qg qgVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, qgVar)) == null) {
            String str3 = ".emotions/";
            if (str != null) {
                str3 = ".emotions/" + str + "/";
            }
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap f = f(str, str2, qgVar);
                if (f == null) {
                    return null;
                }
                return new hn(f, false, str2);
            }
            byte[] bArr = new byte[0];
            mc mcVar = new mc(str3, str2, DiskFileOperate.Action.READ);
            mcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            mcVar.setSubFolder(false);
            mcVar.setIsFormatData(false);
            mcVar.setSavedCache(false);
            mcVar.setSdCard(false);
            mcVar.setLock(bArr);
            if (qgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(mcVar);
                qgVar.a = diskCancelWorker;
            }
            if (!kc.f().a(mcVar)) {
                return null;
            }
            int i = 2000;
            if (BdNetTypeUtil.isWifiNet()) {
                i = 500;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (!mcVar.isSuccess()) {
                return null;
            }
            mcVar.formatData(mcVar.getData());
            return new hn(mcVar.a());
        }
        return (hn) invokeLLL.objValue;
    }

    public Bitmap f(String str, String str2, qg qgVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, qgVar)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(".emotions/");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            byte[] bArr = new byte[0];
            DiskEmotionOperate diskEmotionOperate = new DiskEmotionOperate(sb.toString(), str2, DiskFileOperate.Action.READ);
            diskEmotionOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            diskEmotionOperate.setSubFolder(false);
            diskEmotionOperate.setIsFormatData(false);
            diskEmotionOperate.setSavedCache(false);
            diskEmotionOperate.setSdCard(false);
            diskEmotionOperate.setLock(bArr);
            if (qgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskEmotionOperate);
                qgVar.a = diskCancelWorker;
            }
            if (!kc.f().a(diskEmotionOperate)) {
                return null;
            }
            int i = 2000;
            if (BdNetTypeUtil.isWifiNet()) {
                i = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (!diskEmotionOperate.isSuccess()) {
                return null;
            }
            diskEmotionOperate.formatData(diskEmotionOperate.getData());
            return diskEmotionOperate.getBitmap();
        }
        return (Bitmap) invokeLLL.objValue;
    }

    public final void g(@NonNull String str) {
        ia6 k;
        String g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (g = (k = ia6.k()).g(str, true)) != null) {
            boolean q = k.q(str);
            boolean r = k.r(str);
            String replace = g.replace(".gif", ".jpg");
            if (!q && !r) {
                g = this.a.e(k.h(str), g);
                replace = g.replace(".gif", ".jpg");
            }
            if (FileHelper.isGifImage(replace)) {
                FileHelper.renameTo(replace, g);
            }
        }
    }

    @Override // com.baidu.tieba.tg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof hn)) {
            hn hnVar = (hn) obj;
            if (hnVar.u()) {
                hnVar.A(i);
                hnVar.z(i2);
                e95.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), hnVar);
            }
        }
    }
}
