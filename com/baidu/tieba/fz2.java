package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fz2 extends gz2 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final y33<fz2> k;
    public static final z33<fz2> l;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean g;
    public long h;
    public long i;
    public int j;

    /* loaded from: classes4.dex */
    public static class a extends y33<fz2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y33
        /* renamed from: b */
        public fz2 a(@NonNull qm2 qm2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qm2Var)) == null) {
                fz2 fz2Var = new fz2();
                fz2Var.a = qm2Var.g();
                fz2Var.b = qm2Var.g();
                fz2Var.c = qm2Var.readLong();
                fz2Var.d = qm2Var.readInt();
                fz2Var.e = qm2Var.g();
                fz2Var.f = qm2Var.g();
                fz2Var.g = qm2Var.readBoolean();
                fz2Var.h = qm2Var.readLong();
                fz2Var.i = qm2Var.readLong();
                fz2Var.j = qm2Var.readInt();
                return fz2Var;
            }
            return (fz2) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends z33<fz2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z33
        /* renamed from: b */
        public void a(@NonNull fz2 fz2Var, @NonNull rm2 rm2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fz2Var, rm2Var) == null) {
                rm2Var.f(fz2Var.a);
                rm2Var.f(fz2Var.b);
                rm2Var.writeLong(fz2Var.c);
                rm2Var.writeInt(fz2Var.d);
                rm2Var.f(fz2Var.e);
                rm2Var.f(fz2Var.f);
                rm2Var.writeBoolean(fz2Var.g);
                rm2Var.writeLong(fz2Var.h);
                rm2Var.writeLong(fz2Var.i);
                rm2Var.writeInt(fz2Var.j);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947781355, "Lcom/baidu/tieba/fz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947781355, "Lcom/baidu/tieba/fz2;");
                return;
            }
        }
        k = new a();
        l = new b();
    }

    public fz2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = false;
        this.j = 1;
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.clone() : invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanDependentModel{inline=" + this.g + ", minVersionCode=" + this.h + ", maxVersionCode=" + this.i + ", requireType=" + this.j + ", libName='" + this.a + "', versionName='" + this.b + "', versionCode=" + this.c + ", category=" + this.d + ", libPath='" + this.e + "', libConfig='" + this.f + "'}";
        }
        return (String) invokeV.objValue;
    }

    public fz2(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.g = false;
        this.j = 1;
        if (jSONObject == null) {
            return;
        }
        this.a = str;
        this.d = 6;
        this.b = jSONObject.optString("version");
        this.c = jSONObject.optLong("version_code", -1L);
        this.e = jSONObject.optString("path");
        this.g = jSONObject.optBoolean("inline", false);
        this.h = jSONObject.optLong("min_version_code");
        this.i = jSONObject.optLong("max_version_code");
        this.f = jSONObject.optString("config");
        this.j = jSONObject.optInt("require_type");
    }
}
