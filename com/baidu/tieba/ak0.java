package com.baidu.tieba;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
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
public class ak0 implements il0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final mk0 a;

    public ak0(mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mk0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mk0Var;
    }

    @Override // com.baidu.tieba.il0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) a01.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        zj0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.il0
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
            mk0 mk0Var = this.a;
            mk0Var.c = AdDownloadStatus.DOWNLOADING;
            mk0Var.h = file;
            mk0Var.q.e = j;
            zj0.b().f(adDownloadAction, this.a);
            dk0.b().update(this.a);
            dk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.il0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            zj0.b().f(AdDownloadAction.PAUSE, this.a);
            vk0.f().i(this.a, "notify_type_pause");
            dk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.il0
    public void d(uk0 uk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uk0Var) == null) {
            mk0 mk0Var = this.a;
            mk0Var.c = AdDownloadStatus.FAILED;
            mk0Var.i = 0.0f;
            mk0Var.j = 0.0f;
            zj0.b().g(AdDownloadAction.FAIL, this.a, uk0Var);
            vk0.f().i(this.a, "notify_type_stop");
            dk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.il0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                mk0 mk0Var = this.a;
                mk0Var.d = ql0.a(mk0Var.h);
            }
            if (ql0.e(this.a.h)) {
                PackageInfo packageArchiveInfo = aj0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    mk0 mk0Var2 = this.a;
                    mk0Var2.o = packageArchiveInfo.versionName;
                    mk0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                mk0 mk0Var3 = this.a;
                mk0Var3.c = AdDownloadStatus.COMPLETED;
                mk0Var3.i = 1.0f;
                mk0Var3.j = 1.0f;
                zj0.b().f(AdDownloadAction.COMPLETE, this.a);
                ol0.f().k(this.a);
                vk0.f().k(this.a);
                dk0.b().e(this.a);
                mk0 mk0Var4 = this.a;
                ql0.d(mk0Var4.h, mk0Var4.a());
                return;
            }
            mk0 mk0Var5 = this.a;
            mk0Var5.c = AdDownloadStatus.FAILED;
            mk0Var5.i = 0.0f;
            mk0Var5.j = 0.0f;
            zj0.b().f(AdDownloadAction.FAIL, this.a);
            dk0.b().e(this.a);
        }
    }
}
