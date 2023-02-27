package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class du3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public cu3 i;
    public cu3 j;
    public cu3 k;
    public cu3 l;

    public du3() {
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
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.h) {
                return b(this.l);
            }
            cu3 cu3Var = this.k;
            if (cu3Var != null) {
                return cu3Var.c;
            }
            cu3 cu3Var2 = this.i;
            if (cu3Var2 != null) {
                return cu3Var2.c;
            }
            cu3 cu3Var3 = this.j;
            if (cu3Var3 != null) {
                return cu3Var3.c;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.g != -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int b(cu3 cu3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cu3Var)) == null) {
            if (cu3Var != null) {
                return cu3Var.c;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final int c(cu3 cu3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cu3Var)) == null) {
            if (cu3Var != null) {
                return cu3Var.b;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cores", this.a);
                jSONObject.put("is_biglittle", this.h);
                if (this.h) {
                    jSONObject.put("little_freq_min", c(this.j));
                    jSONObject.put("little_freq_max", b(this.j));
                    jSONObject.put("big_freq_min", c(this.i));
                    jSONObject.put("big_freq_max", b(this.i));
                    jSONObject.put("little_cores", this.b);
                    jSONObject.put("big_cores", this.d);
                    jSONObject.put("little_index", this.c);
                    jSONObject.put("big_index", this.e);
                    if (this.g != -1) {
                        jSONObject.put("super_freq_min", c(this.k));
                        jSONObject.put("super_freq_max", b(this.k));
                        jSONObject.put("super_cores", this.f);
                        jSONObject.put("super_index", this.g);
                    }
                } else {
                    jSONObject.put("freq_min", c(this.l));
                    jSONObject.put("freq_max", b(this.l));
                }
                return jSONObject.toString();
            } catch (JSONException unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
