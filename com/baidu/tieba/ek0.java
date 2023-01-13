package com.baidu.tieba;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.connect.NetWorkUtils;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public class ek0 implements ml0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qk0 a;
    public int b;

    public ek0(@NonNull qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qk0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.a = qk0Var;
    }

    @Override // com.baidu.tieba.ml0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) w01.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        dk0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.ml0
    public void b(long j, File file) {
        AdDownloadAction adDownloadAction;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, file) == null) {
            if (this.a.c == AdDownloadStatus.PAUSE) {
                adDownloadAction = AdDownloadAction.RESUME;
            } else {
                adDownloadAction = AdDownloadAction.START;
            }
            this.a.l = System.currentTimeMillis();
            qk0 qk0Var = this.a;
            qk0Var.c = AdDownloadStatus.DOWNLOADING;
            qk0Var.h = file;
            qk0Var.q.e = j;
            dk0.b().f(adDownloadAction, this.a);
            hk0.b().update(this.a);
            hk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.ml0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            dk0.b().f(AdDownloadAction.PAUSE, this.a);
            zk0.f().i(this.a, "notify_type_pause");
            hk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.ml0
    public void d(@Nullable yk0 yk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yk0Var) == null) {
            if (e(yk0Var)) {
                qk0 qk0Var = this.a;
                if (qk0Var.c == AdDownloadStatus.PAUSE) {
                    dk0.b().j(this.a);
                } else {
                    qk0Var.i = 0.0f;
                    qk0Var.j = 0.0f;
                    dk0.b().k(this.a);
                }
                this.b++;
            } else {
                qk0 qk0Var2 = this.a;
                qk0Var2.c = AdDownloadStatus.FAILED;
                qk0Var2.i = 0.0f;
                qk0Var2.j = 0.0f;
                dk0.b().g(AdDownloadAction.FAIL, this.a, yk0Var);
                zk0.f().i(this.a, "notify_type_stop");
            }
            hk0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable yk0 yk0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yk0Var)) == null) {
            if (yk0Var == null || !yk0Var.c) {
                return false;
            }
            if (vm0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= vm0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (vm0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(ej0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ml0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                qk0 qk0Var = this.a;
                qk0Var.d = ul0.b(qk0Var.h);
            }
            if (ul0.f(this.a.h)) {
                PackageInfo packageArchiveInfo = ej0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    qk0 qk0Var2 = this.a;
                    qk0Var2.o = packageArchiveInfo.versionName;
                    qk0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                qk0 qk0Var3 = this.a;
                qk0Var3.c = AdDownloadStatus.COMPLETED;
                qk0Var3.i = 1.0f;
                qk0Var3.j = 1.0f;
                dk0.b().f(AdDownloadAction.COMPLETE, this.a);
                sl0.f().k(this.a);
                zk0.f().k(this.a);
                hk0.b().e(this.a);
                qk0 qk0Var4 = this.a;
                ul0.e(qk0Var4.h, qk0Var4.a());
                return;
            }
            qk0 qk0Var5 = this.a;
            qk0Var5.c = AdDownloadStatus.FAILED;
            qk0Var5.i = 0.0f;
            qk0Var5.j = 0.0f;
            dk0.b().f(AdDownloadAction.FAIL, this.a);
            hk0.b().e(this.a);
        }
    }
}
