package com.baidu.tieba;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class ik0 implements qk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yj0 a;
    public long b;
    public pk0 c;
    public nk0 d;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-715902882, "Lcom/baidu/tieba/ik0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-715902882, "Lcom/baidu/tieba/ik0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            b = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[AdDownloadStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[AdDownloadStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[AdDownloadStatus.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[AdDownloadStatus.COMPLETED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[AdDownloadStatus.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[AdDownloadAction.values().length];
            a = iArr2;
            try {
                iArr2[AdDownloadAction.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[AdDownloadAction.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[AdDownloadAction.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[AdDownloadAction.PROGRESS_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[AdDownloadAction.COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[AdDownloadAction.INSTALL_FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[AdDownloadAction.FAIL.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public ik0(@NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yj0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0L;
        this.c = null;
        this.a = yj0Var;
        e();
    }

    @Override // com.baidu.tieba.qk0
    public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, yj0Var) == null) {
            switch (a.a[adDownloadAction.ordinal()]) {
                case 1:
                    if (this.a.q.r) {
                        n11.a().a(mi0.b(), R.string.obfuscated_res_0x7f0f0b7e);
                    }
                    ak0 ak0Var = this.a.p.k;
                    if (ak0Var != null && !TextUtils.isEmpty(ak0Var.a)) {
                        ak0 ak0Var2 = this.a.p.k;
                        d(ak0Var2.a, ak0Var2.b);
                    }
                    q();
                    break;
                case 2:
                    r();
                    break;
                case 3:
                    q();
                    break;
                case 4:
                    this.a.i = Math.max(yj0Var.i, yj0Var.j);
                    hk0.f().l(this.a);
                    break;
                case 5:
                    r();
                    break;
                case 6:
                    r();
                    break;
                case 7:
                    r();
                    b(AdDownloadCode.ERROR_OTHERS);
                    return;
            }
            b(AdDownloadCode.SUCCESS);
        }
    }

    public final void b(AdDownloadCode adDownloadCode) {
        pk0 pk0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) || (pk0Var = this.c) == null) {
            return;
        }
        if (adDownloadCode == AdDownloadCode.SUCCESS) {
            pk0Var.a(this.a.c);
        } else {
            pk0Var.b(adDownloadCode);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            lj0.b().a(this.a);
        }
    }

    public final void d(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            Context b = mi0.b();
            Object systemService = b.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (systemService instanceof ClipboardManager) {
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(b.getResources().getString(R.string.obfuscated_res_0x7f0f0bd3), str));
                n11.a().showToast(b, str2);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            s();
            j();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!cl0.e(this.a.h)) {
                lj0.b().a(this.a);
                this.a.g();
                return false;
            }
            AdAppStateManager.instance().register(this.a);
            yj0 yj0Var = this.a;
            return cl0.d(yj0Var.h, yj0Var.a());
        }
        return invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.b;
            this.b = currentTimeMillis;
            return j > 0 && j < 1000;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qk0
    public yj0 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (yj0) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            switch (a.b[this.a.c.ordinal()]) {
                case 1:
                    p();
                    break;
                case 2:
                    lj0.d(AdDownloadAction.FAIL_RETRY, this.a);
                    p();
                    break;
                case 3:
                    i();
                    break;
                case 4:
                    l();
                    break;
                case 5:
                    if (f()) {
                        lj0.d(AdDownloadAction.INSTALL_START, this.a);
                        break;
                    }
                    break;
                case 6:
                    if (cl0.b(this.a.d)) {
                        lj0.c(this.a);
                        break;
                    } else {
                        this.a.c = AdDownloadStatus.NONE;
                        p();
                        break;
                    }
            }
            if (TextUtils.isEmpty(this.a.f)) {
                return;
            }
            vh0.b(this.a.f);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (xk0.c().e(this)) {
                xk0.c().d();
                return;
            }
            lj0.b().h(this.a);
            r();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            lj0.b().i(this.a.e(), this);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            lj0.b().l(this.a.e(), this);
            mk0.b(this.a);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            lj0.b().j(this.a);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            n(this.c);
        }
    }

    public void n(@Nullable pk0 pk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pk0Var) == null) {
            this.c = pk0Var;
            if (g()) {
                b(AdDownloadCode.ERROR_FAST_CLICK);
            } else if (this.a.f()) {
                b(AdDownloadCode.ERROR_INVALID_DATA);
            } else {
                h();
                b(AdDownloadCode.SUCCESS);
            }
        }
    }

    public void o(pk0 pk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pk0Var) == null) {
            this.c = pk0Var;
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            lj0.b().k(this.a);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.d == null && this.a.b()) {
                this.d = mk0.a(this.a);
            }
            nk0 nk0Var = this.d;
            if (nk0Var != null) {
                nk0Var.a();
            }
        }
    }

    public final void r() {
        nk0 nk0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (nk0Var = this.d) == null) {
            return;
        }
        nk0Var.d();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.a.i(pj0.b().query(this.a.e()));
        }
    }
}
