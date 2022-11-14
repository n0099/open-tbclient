package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fw1 implements ew1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public String c;
    public JSONObject d;
    public boolean e;

    /* loaded from: classes4.dex */
    public static class a extends fw1 {
        public static /* synthetic */ Interceptable $ic;
        public static final fw1 g;
        public static final fw1 h;
        public static final fw1 i;
        public static final fw1 j;
        public static final fw1 k;
        public static final fw1 l;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile String f;

        @Override // com.baidu.tieba.fw1
        public void g(@NonNull String str, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-790678292, "Lcom/baidu/tieba/fw1$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-790678292, "Lcom/baidu/tieba/fw1$a;");
                    return;
                }
            }
            g = new a(0);
            h = new a(202, "json str is empty");
            i = new a(202, "json str parse fail");
            j = new a(1001, "json put data fail");
            k = new a(1001, "swan app is null");
            l = new a(1001, "swan activity is null");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, @NonNull String str) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.fw1, com.baidu.tieba.ew1
        @NonNull
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f == null) {
                    synchronized (this) {
                        if (this.f == null) {
                            this.f = super.a();
                        }
                    }
                }
                return this.f;
            }
            return (String) invokeV.objValue;
        }
    }

    public fw1() {
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
        this.e = false;
    }

    public static fw1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65543, null)) != null) {
            return (fw1) invokeV.objValue;
        }
        return a.j;
    }

    public static fw1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65544, null)) != null) {
            return (fw1) invokeV.objValue;
        }
        return a.h;
    }

    public static fw1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65545, null)) != null) {
            return (fw1) invokeV.objValue;
        }
        return a.i;
    }

    public static fw1 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65546, null)) != null) {
            return (fw1) invokeV.objValue;
        }
        return a.g;
    }

    public static fw1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65547, null)) != null) {
            return (fw1) invokeV.objValue;
        }
        return a.l;
    }

    public static fw1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65548, null)) != null) {
            return (fw1) invokeV.objValue;
        }
        return a.k;
    }

    @Override // com.baidu.tieba.ew1
    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return a();
        }
        return (String) invokeV.objValue;
    }

    public fw1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
        this.b = i;
    }

    public fw1(int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = false;
        this.b = i;
        this.c = str;
    }

    public fw1(int i, @NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, jSONObject};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.e = false;
        this.b = i;
        this.c = str;
        this.d = jSONObject;
    }

    public fw1(int i, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), jSONObject};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.e = false;
        this.b = i;
        this.d = jSONObject;
    }

    public fw1(int i, @NonNull JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), jSONObject, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.e = false;
        this.b = i;
        this.d = jSONObject;
        this.e = z;
    }

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (i != 0) {
                if (i != 101) {
                    if (i != 201) {
                        if (i != 202) {
                            if (i != 301) {
                                if (i != 302) {
                                    switch (i) {
                                        case 401:
                                            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1510);
                                        case 402:
                                            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f150d);
                                        case 403:
                                            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f150e);
                                        default:
                                            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1515);
                                    }
                                }
                                return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f150f);
                            }
                            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1511);
                        }
                        return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1514);
                    }
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1515);
                }
                return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1512);
            }
            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1513);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.ew1
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", String.valueOf(this.b));
                if (TextUtils.isEmpty(this.c)) {
                    this.c = b(this.b);
                }
                jSONObject.put("message", this.c);
                if (this.d != null) {
                    if (this.e) {
                        obj = Uri.encode(this.d.toString(), StandardCharsets.UTF_8.name());
                    } else {
                        obj = this.d;
                    }
                    jSONObject.put("data", obj);
                }
            } catch (JSONException e) {
                f12.p("SwanApiResult", "API", "#toJsonString json put data fail", e, false);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public void g(@NonNull String str, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            if (this.d == null) {
                this.d = new JSONObject();
            }
            try {
                this.d.put(str, obj);
            } catch (JSONException e) {
                f12.p("SwanApiResult", "API", "#putData json put data fail", e, false);
            }
        }
    }

    public boolean h(@NonNull String str, @Nullable Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj)) == null) {
            if (this.d == null) {
                this.d = new JSONObject();
            }
            try {
                this.d.put(str, obj);
                return true;
            } catch (JSONException e) {
                f12.p("SwanApiResult", "API", "#safePutData json put data fail", e, false);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
