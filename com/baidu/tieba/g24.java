package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g24 extends r14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long h;

    /* loaded from: classes4.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ s14 b;
        public final /* synthetic */ g24 c;

        public a(g24 g24Var, String str, s14 s14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g24Var, str, s14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g24Var;
            this.a = str;
            this.b = s14Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.b.cancelTag(this.c.c);
                this.c.W(this.a, 0, iOException.getMessage());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    try {
                        JSEvent jSEvent = new JSEvent("headersReceived");
                        jSEvent.data = new e24(this.c.I(response.headers()));
                        this.c.dispatchEvent(jSEvent);
                    } catch (JSONException e) {
                        try {
                            if (r14.e) {
                                e.printStackTrace();
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            if (r14.e) {
                                Log.d("UploadFileTask", Log.getStackTraceString(e));
                            }
                            this.c.C(this.a, -1, e.getMessage());
                        }
                    }
                    f24 f24Var = new f24();
                    f24Var.statusCode = response.code();
                    f24Var.header = this.c.I(response.headers());
                    f24Var.data = this.c.X(response.body());
                    if (r14.e) {
                        Log.d("UploadFileTask", "onResponse = " + f24Var.data);
                    }
                    this.c.D(f24Var);
                } catch (IOException e3) {
                    e = e3;
                    if (r14.e) {
                    }
                    this.c.C(this.a, -1, e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements fv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ g24 c;

        public b(g24 g24Var, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g24Var, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g24Var;
            this.a = j;
            this.b = str;
        }

        @Override // com.baidu.tieba.fv2
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.c.V(this.a, j, this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g24(va2 va2Var, sv1 sv1Var) {
        super(va2Var, sv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {va2Var, sv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((va2) objArr2[0], (sv1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 0L;
        this.a = 3;
    }

    public static void Y(MultipartBody.Builder builder, sv1 sv1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, builder, sv1Var) == null) || builder == null || sv1Var == null || sv1Var.k() < 1) {
            return;
        }
        for (String str : sv1Var.j()) {
            if (!TextUtils.isEmpty(str)) {
                String H = sv1Var.H(str);
                if (!TextUtils.isEmpty(H)) {
                    builder.addFormDataPart(str, H);
                }
            }
        }
    }

    @Override // com.baidu.tieba.r14
    public void C(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
            super.C(str, i, str2);
            f44.k(str, i, str2, SwanAppNetworkUtils.i(null));
        }
    }

    public final Request T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String z = z();
            if (!TextUtils.isEmpty(z)) {
                String B = this.b.B("filePath");
                if (TextUtils.isEmpty(B)) {
                    C(z, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (pj4.x(B)) {
                    C(z, -1, "uploadFile:filePath is empty or invalid");
                    return null;
                } else if (this.b.b("header") && this.b.getType("header") != 9) {
                    C(z, -1, "uploadFile:header is invalid");
                    return null;
                } else {
                    File U = U(z, B);
                    if (U != null) {
                        sv1 w = this.b.w("formData");
                        Request.Builder builder = new Request.Builder();
                        pu2 pu2Var = new pu2(U, IMAudioTransRequest.CONTENT_TYPE, new b(this, U.length(), z));
                        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                        Y(type, w);
                        type.addFormDataPart(this.b.B("name"), U.getName(), pu2Var);
                        MultipartBody build = type.build();
                        G(builder, this.b.w("header"), new HashMap(), false);
                        return builder.url(z).tag(this.c).post(build).build();
                    }
                }
            }
            return null;
        }
        return (Request) invokeV.objValue;
    }

    public final File U(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            String a2 = yo2.U().G().a(str2);
            if (!TextUtils.isEmpty(a2) && !TextUtils.equals(str2, a2)) {
                File file = new File(a2);
                if (file.exists() && file.isFile()) {
                    if (file.length() > 26214400) {
                        C(str, -1, "request:file size > 25 MB");
                        return null;
                    } else if (TextUtils.isEmpty(this.b.B("name"))) {
                        C(str, -1, "uploadFile:name is invalid");
                        return null;
                    } else if (!this.b.b("formData") || this.b.getType("formData") == 9) {
                        return file;
                    } else {
                        C(str, -1, "uploadFile:formData is invalid");
                        return null;
                    }
                }
                C(str, -1, "request:file not exists or not file");
                return null;
            }
            C(str, -1, "uploadFile:filePath is empty or invalid");
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public final void V(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) || j <= 0 || j2 > j || j2 == 0) {
            return;
        }
        int floor = (int) Math.floor((100 * j2) / j);
        if (System.currentTimeMillis() - this.h > 500 || floor == 100) {
            if (floor <= 100) {
                dispatchEvent(new JSEvent("progressUpdate", new h24(floor, j, j2)));
            }
            this.h = System.currentTimeMillis();
        }
    }

    public final void W(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i, str2) == null) {
            if (r14.e) {
                Log.d("UploadFileTask", "onFailure: " + str2);
            }
            C(str, i, ("Socket is closed".equalsIgnoreCase(str2) || "Canceled".equalsIgnoreCase(str2)) ? "uploadFile:fail abort" : "uploadFile:fail abort");
        }
    }

    public final Object X(ResponseBody responseBody) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, responseBody)) == null) {
            if (responseBody == null) {
                return null;
            }
            String string = responseBody.string();
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
                return string;
            }
        }
        return invokeL.objValue;
    }

    public void start() {
        Request T;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.b == null || (T = T()) == null) {
            return;
        }
        if (l33.M() == null) {
            C("", -1, "request:swanApp is null");
            return;
        }
        String httpUrl = T.url().toString();
        s14 s14Var = (s14) l33.M().i0();
        s14Var.call(T, new a(this, httpUrl, s14Var));
    }
}
