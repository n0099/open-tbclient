package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
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
/* loaded from: classes5.dex */
public class dv1 extends cv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ImageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ k63 d;
        public final /* synthetic */ dv1 e;

        public a(dv1 dv1Var, File file, int i, String str, k63 k63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv1Var, file, Integer.valueOf(i), str, k63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dv1Var;
            this.a = file;
            this.b = i;
            this.c = str;
            this.d = k63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File k = ij3.k(this.a.getName());
                if (!ij3.b(this.a, k, this.b)) {
                    k32.c("ImageApi", "compress image failed");
                    this.e.d(this.c, new ly1(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", sd3.J(k.getAbsolutePath(), this.d.b));
                } catch (JSONException e) {
                    k32.c("ImageApi", e.toString());
                }
                this.e.d(this.c, new ly1(0, jSONObject));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dv1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ly1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#compressImage", false);
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                k32.c("ImageApi", "cb is empty");
                return new ly1(202, "cb is empty");
            }
            return z(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
        }
        return (ly1) invokeL.objValue;
    }

    public final ly1 z(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                return new ly1(1001, "swan app is null");
            }
            if (i >= 0 && i <= 100) {
                i2 = i;
            } else {
                i2 = 80;
            }
            if (TextUtils.isEmpty(str2)) {
                k32.c("ImageApi", "src is null");
                return new ly1(202, "src is null");
            }
            PathType s = sd3.s(str2);
            String str3 = null;
            if (s == PathType.BD_FILE) {
                str3 = sd3.M(str2, c0.b);
            } else if (s == PathType.RELATIVE) {
                str3 = sd3.L(str2, c0, c0.l0());
            }
            if (TextUtils.isEmpty(str3)) {
                k32.c("ImageApi", "file path error");
                return new ly1(2001, "file path error");
            }
            File file = new File(str3);
            if (!file.exists()) {
                k32.c("ImageApi", "file does not exist");
                return new ly1(2001, "file does not exist");
            }
            ej3.k(new a(this, file, i2, str, c0), "compressImage");
            return ly1.f();
        }
        return (ly1) invokeLLI.objValue;
    }
}
