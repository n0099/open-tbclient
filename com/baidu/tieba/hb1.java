package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class hb1 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947817842, "Lcom/baidu/tieba/hb1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947817842, "Lcom/baidu/tieba/hb1;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes6.dex */
    public static final class a {
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Intent intent) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            Object m849constructorimpl;
            String jSONObject;
            Charset charset;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    Intrinsics.checkNotNullExpressionValue(extras, "intent.extras ?: return");
                    Serializable serializable = extras.getSerializable("map");
                    if (!(serializable instanceof HashMap)) {
                        serializable = null;
                    }
                    HashMap hashMap = (HashMap) serializable;
                    if (hashMap != null) {
                        if (hashMap != null) {
                            if (hashMap == null || hashMap.isEmpty() || !TextUtils.equals((CharSequence) f31.b(hashMap, "append_da"), "1")) {
                                return;
                            }
                            String str = (String) f31.b(hashMap, "url");
                            boolean z6 = false;
                            if (str != null && str.length() != 0) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                return;
                            }
                            String ver = sj0.d().w();
                            Intrinsics.checkNotNullExpressionValue(ver, "ver");
                            if (ver.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                str = h71.a(str, "ver", ver);
                            }
                            String uid = sj0.d().t();
                            Intrinsics.checkNotNullExpressionValue(uid, "uid");
                            if (uid.length() > 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                byte[] bytes = uid.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                                byte[] B64Encode = Base64Encoder.B64Encode(bytes);
                                Intrinsics.checkNotNullExpressionValue(B64Encode, "Base64Encoder.B64Encode(uid.toByteArray())");
                                str = h71.a(str, "uid", new String(B64Encode, Charsets.UTF_8));
                            }
                            String apna = sj0.d().packageName();
                            Intrinsics.checkNotNullExpressionValue(apna, "apna");
                            if (apna.length() > 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                str = h71.a(str, "apna", apna);
                            }
                            String sid = sj0.d().i();
                            Intrinsics.checkNotNullExpressionValue(sid, "sid");
                            if (sid.length() > 0) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                str = h71.a(str, "sid", sid);
                            }
                            String a = h71.a(str, "network", String.valueOf(new ft0().c()));
                            String ua = sj0.d().h();
                            Intrinsics.checkNotNullExpressionValue(ua, "ua");
                            if (ua.length() > 0) {
                                z6 = true;
                            }
                            if (z6) {
                                byte[] bytes2 = ua.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                                byte[] B64Encode2 = Base64Encoder.B64Encode(bytes2);
                                Intrinsics.checkNotNullExpressionValue(B64Encode2, "Base64Encoder.B64Encode(ua.toByteArray())");
                                a = h71.a(a, "ua", new String(B64Encode2, Charsets.UTF_8));
                            }
                            try {
                                Result.Companion companion = Result.Companion;
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(AdExtParam.KEY_IADEX, sj0.d().m());
                                jSONObject = jSONObject2.toString();
                                Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().apply {\n   …             }.toString()");
                                charset = Charsets.UTF_8;
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                m849constructorimpl = Result.m849constructorimpl(ResultKt.createFailure(th));
                            }
                            if (jSONObject != null) {
                                byte[] bytes3 = jSONObject.getBytes(charset);
                                Intrinsics.checkNotNullExpressionValue(bytes3, "(this as java.lang.String).getBytes(charset)");
                                m849constructorimpl = Result.m849constructorimpl(bytes3);
                                if (Result.m856isSuccessimpl(m849constructorimpl)) {
                                    byte[] bArr = (byte[]) m849constructorimpl;
                                    if (Uri.parse(a).getQueryParameter("da") == null) {
                                        byte[] encode = Base64.encode(bArr, 2);
                                        Intrinsics.checkNotNullExpressionValue(encode, "Base64.encode(it, Base64.NO_WRAP)");
                                        a = h71.a(a, "da", new String(encode, Charsets.UTF_8));
                                    }
                                }
                                f31.e(hashMap, "url", a);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
                    }
                }
            }
        }
    }
}
