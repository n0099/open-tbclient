package com.baidu.tieba;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public class cj0 extends zi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<ij0<?>> e;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-888601309, "Lcom/baidu/tieba/cj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-888601309, "Lcom/baidu/tieba/cj0$a;");
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
                a[AdDownloadStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 3;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cj0(@NonNull pi0 pi0Var) {
        super(pi0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pi0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((pi0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
    }

    @Override // com.baidu.tieba.zi0, com.baidu.tieba.hj0
    public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, pi0Var) == null) {
            super.a(adDownloadAction, pi0Var);
            u();
        }
    }

    public void t(ij0<?> ij0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ij0Var) == null) {
            this.e = new WeakReference<>(ij0Var);
            u();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.e == null) {
            return;
        }
        Resources resources = eh0.b().getResources();
        String string = resources.getString(R.string.obfuscated_res_0x7f0f0ba7);
        switch (a.a[this.a.c.ordinal()]) {
            case 1:
                string = TextUtils.isEmpty(this.a.p.d) ? resources.getString(R.string.obfuscated_res_0x7f0f0ba7) : this.a.p.d;
                break;
            case 2:
                string = new DecimalFormat("#.#%").format(this.a.i);
                break;
            case 3:
                string = resources.getString(R.string.obfuscated_res_0x7f0f0b99);
                break;
            case 4:
                string = resources.getString(R.string.obfuscated_res_0x7f0f0b9c);
                break;
            case 5:
                string = resources.getString(R.string.obfuscated_res_0x7f0f0ba0);
                break;
            case 6:
                string = resources.getString(R.string.obfuscated_res_0x7f0f0b9b);
                break;
        }
        ij0<?> ij0Var = this.e.get();
        if (ij0Var == null) {
            return;
        }
        ij0Var.update(string, this.a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cj0(@NonNull pi0 pi0Var, @NonNull ij0<?> ij0Var) {
        super(pi0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pi0Var, ij0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((pi0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = null;
        t(ij0Var);
    }
}
