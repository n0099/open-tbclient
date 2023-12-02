package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.bh0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hh0 extends gh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final wg0 e;
    public HashMap<String, b> f;
    public String g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-747302596, "Lcom/baidu/tieba/hh0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-747302596, "Lcom/baidu/tieba/hh0$a;");
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
                a[AdDownloadStatus.FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public b() {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hh0(@NonNull wg0 wg0Var) {
        super(wg0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wg0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wg0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new HashMap<>();
        this.g = "";
        this.e = wg0Var;
        this.c = new mh0(this);
    }

    @NonNull
    public wg0 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (wg0) invokeV.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n(this.c);
        }
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = a.a[this.e.c.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return "0";
                            }
                            return "4";
                        }
                        wg0 wg0Var = this.e;
                        wg0Var.i = 1.0f;
                        wg0Var.j = 1.0f;
                        return "3";
                    }
                    return "2";
                }
                return "1";
            }
            wg0 wg0Var2 = this.e;
            wg0Var2.i = 0.0f;
            wg0Var2.j = 0.0f;
            return "0";
        }
        return (String) invokeV.objValue;
    }

    public void x(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, str4) == null) {
            bh0 bh0Var = new bh0();
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            String a2 = hi0.a(str, str2, str3, str4);
            oy0.f(jSONObject, "status", "0");
            oy0.f(jSONObject, "message", "");
            oy0.f(jSONObject, "data", a2);
            for (String str5 : this.f.keySet()) {
                b bVar = (b) py0.b(this.f, str5);
                if (bVar != null && !TextUtils.isEmpty(bVar.a)) {
                    bh0.a aVar = new bh0.a();
                    aVar.b = bVar.b;
                    aVar.a = bVar.a;
                    aVar.c = jSONObject.toString();
                    aVar.d = this.g;
                    ny0.b(arrayList, aVar);
                }
            }
            if (!arrayList.isEmpty()) {
                bh0Var.a = arrayList;
                ti0.a().b(bh0Var);
            }
        }
    }

    public void y(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, str3, str4) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str5 = str + "_" + str4 + "_" + str3 + "_" + str2;
            this.f.remove(str5);
            b bVar = new b();
            bVar.b = str;
            bVar.a = str2;
            this.f.put(str5, bVar);
        }
    }

    public void z(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            this.f.remove(str + "_" + str4 + "_" + str3 + "_" + str2);
            this.g = "";
        }
    }
}
