package com.baidu.tieba;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class ci0 implements lj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final pi0 a;

    public ci0(@NonNull pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pi0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pi0Var;
    }

    @Override // com.baidu.tieba.lj0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) ay0.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        bi0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.lj0
    public void b(long j, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, file) == null) {
            AdDownloadAction adDownloadAction = this.a.c == AdDownloadStatus.PAUSE ? AdDownloadAction.RESUME : AdDownloadAction.START;
            this.a.l = System.currentTimeMillis();
            pi0 pi0Var = this.a;
            pi0Var.c = AdDownloadStatus.DOWNLOADING;
            pi0Var.h = file;
            pi0Var.q.e = j;
            bi0.b().f(adDownloadAction, this.a);
            fi0.a().update(this.a);
            fi0.a().c(this.a);
        }
    }

    @Override // com.baidu.tieba.lj0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            bi0.b().f(AdDownloadAction.PAUSE, this.a);
            yi0.f().h(this.a, "notify_type_pause");
            fi0.a().c(this.a);
        }
    }

    @Override // com.baidu.tieba.lj0
    public void d(@Nullable xi0 xi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xi0Var) == null) {
            pi0 pi0Var = this.a;
            pi0Var.c = AdDownloadStatus.FAILED;
            pi0Var.i = 0.0f;
            pi0Var.j = 0.0f;
            bi0.b().g(AdDownloadAction.FAIL, this.a, xi0Var);
            yi0.f().h(this.a, "notify_type_stop");
            fi0.a().c(this.a);
        }
    }

    @Override // com.baidu.tieba.lj0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                pi0 pi0Var = this.a;
                pi0Var.d = rj0.a(pi0Var.h);
            }
            if (rj0.e(this.a.h)) {
                PackageInfo packageArchiveInfo = eh0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    pi0 pi0Var2 = this.a;
                    pi0Var2.o = packageArchiveInfo.versionName;
                    pi0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                pi0 pi0Var3 = this.a;
                pi0Var3.c = AdDownloadStatus.COMPLETED;
                pi0Var3.i = 1.0f;
                pi0Var3.j = 1.0f;
                bi0.b().f(AdDownloadAction.COMPLETE, this.a);
                qj0.a().b(this.a);
                yi0.f().i(this.a);
                fi0.a().c(this.a);
                pi0 pi0Var4 = this.a;
                rj0.d(pi0Var4.h, pi0Var4.a());
                return;
            }
            pi0 pi0Var5 = this.a;
            pi0Var5.c = AdDownloadStatus.FAILED;
            pi0Var5.i = 0.0f;
            pi0Var5.j = 0.0f;
            bi0.b().f(AdDownloadAction.FAIL, this.a);
            fi0.a().c(this.a);
        }
    }
}
