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
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class e07 implements tg<jn> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final pp5 a;

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

    public e07() {
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
        this.a = pp5.b;
    }

    @Override // com.baidu.tieba.tg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return a15.c().g();
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
    public jn getFromLocal(String str, String str2, int i, int i2, qg qgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        jn jnVar;
        Bitmap f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), qgVar, objArr})) == null) {
            jn jnVar2 = null;
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
            ArrayList<sj5> i3 = j07.k().i();
            if ((j07.k().q(str3) || j07.k().r(str3)) && valueOf2.booleanValue() && !new File(j07.k().g(str3, true)).exists()) {
                valueOf2 = Boolean.FALSE;
            }
            boolean booleanValue = valueOf2.booleanValue();
            if (j07.k().o(str3) && valueOf2.booleanValue()) {
                String g = j07.k().g(str3, true);
                String h = j07.k().h(str3);
                if (!new File(this.a.e(h, g)).exists()) {
                    valueOf2 = Boolean.FALSE;
                }
                valueOf = h;
            }
            if (valueOf2.booleanValue()) {
                String g2 = j07.k().g(str3, true);
                Iterator<sj5> it = i3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    sj5 next = it.next();
                    if (next.m(str3)) {
                        if (next.j()) {
                            jnVar2 = next.n(str3);
                        } else {
                            jnVar2 = e(next.f(), g2, qgVar);
                        }
                    }
                }
                if (jnVar2 == null && valueOf != null) {
                    return e(valueOf, g2, qgVar);
                }
                return jnVar2;
            }
            String g3 = j07.k().g(str3, false);
            if (booleanValue && j07.k().o(str3)) {
                g3 = g3.replaceFirst("s_", "d_");
            }
            Iterator<sj5> it2 = i3.iterator();
            jn jnVar3 = null;
            while (true) {
                if (it2.hasNext()) {
                    sj5 next2 = it2.next();
                    if (next2.m(str3)) {
                        if (next2.j()) {
                            jnVar3 = next2.o(str3);
                        } else {
                            Bitmap f2 = f(next2.f(), g3, qgVar);
                            if (f2 == null) {
                                return null;
                            }
                            jnVar = new jn(f2, false, str3);
                        }
                    }
                } else {
                    jnVar = jnVar3;
                    break;
                }
            }
            if (jnVar == null && valueOf != null && (f = f(valueOf, g3, qgVar)) != null) {
                return new jn(f, false, str3);
            }
            return jnVar;
        }
        return (jn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tg
    /* renamed from: d */
    public jn getFromRemote(String str, String str2, int i, int i2, qg qgVar, Object... objArr) {
        InterceptResult invokeCommon;
        String valueOf;
        String valueOf2;
        String valueOf3;
        jn jnVar;
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
                    ey5.g(e07.class.getSimpleName(), valueOf3);
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf3, false);
                    boolean needCache = webClient.needCache();
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String g = j07.k().g(valueOf2, valueOf4.booleanValue());
                            String str3 = ".emotions/" + valueOf;
                            if (valueOf4.booleanValue()) {
                                hc hcVar = new hc(str3, g, DiskFileOperate.Action.WRITE);
                                hcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                hcVar.setSubFolder(false);
                                hcVar.setSavedCache(false);
                                hcVar.setSdCard(false);
                                hcVar.setData(downloadImageBytes);
                                fc.f().call(hcVar);
                                if (qgVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(hcVar);
                                    qgVar.a = diskCancelWorker;
                                }
                                Iterator<sj5> it = j07.k().i().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        sj5 next = it.next();
                                        if (next.m(valueOf2)) {
                                            jnVar = e(next.f(), g, qgVar);
                                            break;
                                        }
                                    } else {
                                        jnVar = null;
                                        break;
                                    }
                                }
                                if (jnVar == null && valueOf != null) {
                                    jnVar = e(valueOf, g, qgVar);
                                }
                                if (jnVar == null) {
                                    return null;
                                }
                            } else {
                                TbImageMemoryCache.v().t(80000);
                                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                                if (checkBitmapSize == null) {
                                    return null;
                                }
                                jn jnVar2 = new jn(checkBitmapSize, valueOf4.booleanValue(), valueOf3);
                                jnVar2.y(needCache);
                                if (needCache) {
                                    jc jcVar = new jc(str3, g, DiskFileOperate.Action.WRITE);
                                    jcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                    jcVar.setSubFolder(false);
                                    jcVar.setData(downloadImageBytes);
                                    jcVar.setSavedCache(false);
                                    jcVar.setSdCard(false);
                                    jcVar.setGif(valueOf4.booleanValue());
                                    fc.f().a(jcVar);
                                    if (qgVar != null) {
                                        DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                        diskCancelWorker2.setOperate(jcVar);
                                        qgVar.a = diskCancelWorker2;
                                    }
                                }
                                jnVar = jnVar2;
                            }
                            return jnVar;
                        }
                    }
                }
            }
            return null;
        }
        return (jn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tg
    /* renamed from: c */
    public jn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return TbImageMemoryCache.v().A(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
        }
        return (jn) invokeCommon.objValue;
    }

    public jn e(String str, String str2, qg qgVar) {
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
                return new jn(f, false, str2);
            }
            byte[] bArr = new byte[0];
            hc hcVar = new hc(str3, str2, DiskFileOperate.Action.READ);
            hcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            hcVar.setSubFolder(false);
            hcVar.setIsFormatData(false);
            hcVar.setSavedCache(false);
            hcVar.setSdCard(false);
            hcVar.setLock(bArr);
            if (qgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(hcVar);
                qgVar.a = diskCancelWorker;
            }
            if (!fc.f().a(hcVar)) {
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
            if (!hcVar.isSuccess()) {
                return null;
            }
            hcVar.formatData(hcVar.getData());
            return new jn(hcVar.a());
        }
        return (jn) invokeLLL.objValue;
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
            if (!fc.f().a(diskEmotionOperate)) {
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
        j07 k;
        String g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (g = (k = j07.k()).g(str, true)) != null) {
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
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof jn)) {
            jn jnVar = (jn) obj;
            if (jnVar.u()) {
                jnVar.A(i);
                jnVar.z(i2);
                TbImageMemoryCache.v().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), jnVar);
            }
        }
    }
}
