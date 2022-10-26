package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class es1 extends ds1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.pr1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ImageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ m33 d;
        public final /* synthetic */ es1 e;

        public a(es1 es1Var, File file, int i, String str, m33 m33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es1Var, file, Integer.valueOf(i), str, m33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = es1Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = m33Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = kg3.k(this.a.getName());
                if (!kg3.b(this.a, k, this.b)) {
                    m02.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new mv1(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", ua3.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    m02.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new mv1(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public es1(nr1 nr1Var) {
        super(nr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public mv1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#compressImage", false);
            Pair s = s(str);
            mv1 mv1Var = (mv1) s.first;
            if (!mv1Var.isSuccess()) {
                return mv1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                m02.c("ImageApi", "cb is empty");
                return new mv1(202, "cb is empty");
            }
            return y(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
        }
        return (mv1) invokeL.objValue;
    }

    public final mv1 y(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            m33 b0 = m33.b0();
            if (b0 == null) {
                return new mv1(1001, "swan app is null");
            }
            if (i >= 0 && i <= 100) {
                i2 = i;
            } else {
                i2 = 80;
            }
            if (TextUtils.isEmpty(str2)) {
                m02.c("ImageApi", "src is null");
                return new mv1(202, "src is null");
            }
            PathType s = ua3.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = ua3.M(str2, b0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = ua3.L(str2, b0, b0.k0());
            }
            if (TextUtils.isEmpty(str3)) {
                m02.c("ImageApi", "file path error");
                return new mv1(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                m02.c("ImageApi", "file does not exist");
                return new mv1(2001, "file does not exist");
            }
            gg3.k(new a(this, file, i2, str, b0), "compressImage");
            return mv1.f();
        }
        return (mv1) invokeLLI.objValue;
    }
}
