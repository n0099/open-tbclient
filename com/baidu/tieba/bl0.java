package com.baidu.tieba;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class bl0 implements cl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<wk0> a;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-915383418, "Lcom/baidu/tieba/bl0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-915383418, "Lcom/baidu/tieba/bl0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AdDownloadStatus.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public bl0(@NonNull wk0 wk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wk0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new WeakReference<>(wk0Var);
    }

    @Override // com.baidu.tieba.cl0
    public void a(AdDownloadStatus adDownloadStatus) {
        wk0 wk0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, adDownloadStatus) == null) || (wk0Var = this.a.get()) == null) {
            return;
        }
        lk0 t = wk0Var.t();
        switch (a.a[adDownloadStatus.ordinal()]) {
            case 1:
                wk0Var.w("0", String.valueOf(t.i), "", t.e());
                return;
            case 2:
                String valueOf = String.valueOf(t.i);
                Uri uri = t.k;
                wk0Var.w("2", valueOf, uri != null ? uri.toString() : "", t.e());
                return;
            case 3:
                String valueOf2 = String.valueOf(t.i);
                Uri uri2 = t.k;
                wk0Var.w("1", valueOf2, uri2 != null ? uri2.toString() : "", t.e());
                return;
            case 4:
                Uri uri3 = t.k;
                wk0Var.w("3", "1", uri3 != null ? uri3.toString() : "", t.e());
                return;
            case 5:
                Uri uri4 = t.k;
                wk0Var.w("6", "1", uri4 != null ? uri4.toString() : "", t.e());
                return;
            case 6:
                wk0Var.w("4", "0", "", t.e());
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.cl0
    public void b(AdDownloadCode adDownloadCode) {
        wk0 wk0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) || (wk0Var = this.a.get()) == null || adDownloadCode == AdDownloadCode.ERROR_FAST_CLICK) {
            return;
        }
        wk0Var.w("4", "0", "", wk0Var.t().e());
    }
}
