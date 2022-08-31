package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.codec.binary4util.BaseNCodec;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cd9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String d = "UnionIDHelper";
    public static boolean e;
    public static final String f;
    public static final String g;
    public static final Object h;
    public static cd9 i;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile fd9 a;
    public AtomicBoolean b;
    public AtomicBoolean c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ c b;
        public final /* synthetic */ cd9 c;

        public a(cd9 cd9Var, Context context, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd9Var, context, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cd9Var;
            this.a = context;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (cd9.e) {
                    Log.d(cd9.d, "asyncRequest, Thread runn！");
                }
                dd9 n = this.c.n(this.a);
                if (cd9.e) {
                    String str = cd9.d;
                    StringBuilder sb = new StringBuilder();
                    sb.append("asyncRequest, cachedBean == null ？");
                    sb.append(n == null);
                    Log.d(str, sb.toString());
                }
                if (n == null || this.c.r(n)) {
                    if (cd9.e) {
                        Log.d(cd9.d, "asyncRequest, requestFromManufacturer");
                    }
                    this.c.s();
                    if (cd9.e) {
                        Log.d(cd9.d, "asyncRequest, trySaveFiles！");
                    }
                    this.c.c.set(this.c.w(this.a));
                    if (cd9.e) {
                        Log.d(cd9.d, "asyncRequest, trySaveFiles done");
                    }
                }
                if (cd9.e) {
                    Log.d(cd9.d, "asyncRequest, send  innerHandler message");
                }
                this.b.obtainMessage(100, this.c.a).sendToTarget();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ cd9 c;

        public b(cd9 cd9Var, Context context, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd9Var, context, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cd9Var;
            this.a = context;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (cd9.e) {
                    Log.d(cd9.d, "syncReadFromCache, thread runn:");
                }
                this.c.b.set(this.c.n(this.a) != null);
                if (cd9.e) {
                    Log.d(cd9.d, "syncReadFromCache, cachJsonObject done:");
                }
                synchronized (this.b) {
                    if (cd9.e) {
                        Log.d(cd9.d, "syncReadFromCache, cachJsonObject notifyAll:");
                    }
                    this.b.notifyAll();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ed9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper, ed9 ed9Var) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, ed9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed9Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                fd9 fd9Var = (fd9) message.obj;
                if (cd9.e) {
                    String str = cd9.d;
                    StringBuilder sb = new StringBuilder();
                    sb.append("handleMessage ，what：");
                    sb.append(fd9Var == null ? "" : fd9Var.getOAID());
                    Log.d(str, sb.toString());
                }
                ed9 ed9Var = this.a;
                if (ed9Var != null) {
                    ed9Var.a(fd9Var);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947671057, "Lcom/baidu/tieba/cd9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947671057, "Lcom/baidu/tieba/cd9;");
                return;
            }
        }
        e = yc9.e();
        f = k(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, BaseNCodec.PAD_DEFAULT}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, BaseNCodec.PAD_DEFAULT});
        g = k(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, BaseNCodec.PAD_DEFAULT}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, BaseNCodec.PAD_DEFAULT});
        h = new Object();
    }

    public cd9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
    }

    public static String k(byte[]... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr2 : bArr) {
                sb.append(new String(md9.a(bArr2)));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new String(kd9.a(f, g, md9.a(str.getBytes())));
            } catch (Exception e2) {
                if (e) {
                    String str2 = d;
                    Log.d(str2, "getCacheObject ，decryptUnionID：" + e2.getMessage());
                    return "";
                }
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return md9.c(kd9.b(f, g, str.getBytes()), IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException | Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static cd9 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (i == null) {
                synchronized (cd9.class) {
                    if (i == null) {
                        i = new cd9();
                    }
                }
            }
            return i;
        }
        return (cd9) invokeV.objValue;
    }

    public synchronized void j(Context context, @NonNull Looper looper, @Nullable ed9 ed9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, looper, ed9Var) == null) {
            synchronized (this) {
                if (looper != null) {
                    c cVar = new c(looper, ed9Var);
                    if (q()) {
                        cVar.obtainMessage(100, null).sendToTarget();
                        return;
                    }
                    if (this.a != null && this.c.get()) {
                        if (e) {
                            String str = d;
                            Log.d(str, "asyncRequest, mIUnionId.getOAID：" + this.a.getOAID());
                            String str2 = d;
                            Log.d(str2, "asyncRequest, mIUnionId.isTrackLimited：" + this.a.c());
                            String str3 = d;
                            Log.d(str3, "asyncRequest, mIUnionId.getStatusCode：" + this.a.getStatusCode());
                        }
                        cVar.obtainMessage(100, this.a).sendToTarget();
                    } else {
                        if (!this.c.get()) {
                            this.a = new ad9(context).a;
                        }
                        new Thread(new a(this, context, cVar)).start();
                    }
                    return;
                }
                throw new NullPointerException("param looper not null");
            }
        }
    }

    public final dd9 n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
            if (!file.exists()) {
                if (e) {
                    Log.d(d, "getCacheObject dir 不存在 , 首次需要创建");
                }
                return null;
            }
            File file2 = new File(file, ".bd_un_info.so");
            if (!file2.exists()) {
                if (e) {
                    Log.d(d, "getCacheObject  file 不存在, 首次需要创建");
                }
                return null;
            }
            String a2 = od9.a(file2, h);
            if (e) {
                String str = d;
                Log.d(str, "getCacheObject ，content：" + a2);
            }
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            String l = l(a2);
            if (e) {
                String str2 = d;
                Log.d(str2, "getCacheObject ，json：" + l);
            }
            try {
                JSONObject jSONObject = new JSONObject(l);
                dd9 dd9Var = new dd9();
                v(dd9Var, jSONObject);
                return dd9Var;
            } catch (Exception e2) {
                if (e) {
                    String str3 = d;
                    Log.d(str3, "getCacheObject , " + e2.getMessage());
                }
                return null;
            }
        }
        return (dd9) invokeL.objValue;
    }

    public final long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? yc9.a(zc9.a()) * 60 * 1000 : invokeV.longValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? yc9.d(zc9.a()) : invokeV.booleanValue;
    }

    public final boolean r(@NonNull dd9 dd9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dd9Var)) == null) {
            if (Math.abs(System.currentTimeMillis() - dd9Var.a) > o()) {
                if (e) {
                    Log.d(d, "isExpireTime ：超过缓存有效期");
                    return true;
                }
                return true;
            } else if (e) {
                Log.d(d, "isExpireTime ：没有超过缓存有效期");
                return false;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = this.a.d();
            if (e) {
                String str = d;
                Log.d(str, "asyncRequest, requestFromManufacturer done :" + this.a.getOAID());
            }
        }
    }

    public final void t(Context context, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, obj) == null) {
            new Thread(new b(this, context, obj)).start();
            synchronized (obj) {
                if (!this.b.get()) {
                    try {
                        if (e) {
                            Log.d(d, "syncReadFromCache, waiter:");
                        }
                        obj.wait(300L);
                        if (e) {
                            Log.d(d, "syncReadFromCache, waiter over:");
                        }
                    } catch (InterruptedException unused) {
                        if (e) {
                            Log.d(d, "syncReadFromCache, InterruptedException");
                        }
                    }
                }
            }
        }
    }

    public synchronized fd9 u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            synchronized (this) {
                if (e) {
                    String str = d;
                    Log.d(str, "syncRequest, isClosedByCC():" + q());
                }
                if (q()) {
                    return null;
                }
                if (e) {
                    String str2 = d;
                    StringBuilder sb = new StringBuilder();
                    sb.append("syncRequest,  (mIUnionId == null):");
                    sb.append(this.a == null);
                    Log.d(str2, sb.toString());
                }
                if (this.a == null) {
                    this.a = new ad9(context).a;
                }
                if (!(this.a instanceof id9) && !this.b.get()) {
                    t(context, new Object());
                }
                if (e) {
                    String str3 = d;
                    Log.d(str3, "syncRequest, (mIUnionId instanceof UnSupportedUnionID):" + (this.a instanceof id9));
                }
                if (e) {
                    String str4 = d;
                    Log.d(str4, "syncRequest, mIUnionId.getOAID：" + this.a.getOAID());
                    String str5 = d;
                    Log.d(str5, "syncRequest, mIUnionId.isTrackLimited：" + this.a.c());
                    String str6 = d;
                    Log.d(str6, "syncRequest, mIUnionId.getStatusCode：" + this.a.getStatusCode());
                }
                if (this.a.getStatusCode() == -200) {
                    return null;
                }
                return this.a;
            }
        }
        return (fd9) invokeL.objValue;
    }

    public final boolean v(dd9 dd9Var, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dd9Var, jSONObject)) == null) {
            try {
                long optLong = jSONObject.optLong(new String(md9.a("dGltZQ==".getBytes())));
                dd9Var.a = optLong;
                if (e) {
                    String str = d;
                    Log.d(str, "tryParseCacheJsonObject ，time：" + optLong);
                    String str2 = d;
                    Log.d(str2, "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong));
                }
                String str3 = new String(md9.a("dW5pb25JRG9iag==".getBytes()));
                if (e) {
                    String str4 = d;
                    Log.d(str4, "tryParseCacheJsonObject objKey：" + str3);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                if (e) {
                    String str5 = d;
                    Log.d(str5, "tryParseCacheJsonObject ，jsonObject：" + optJSONObject);
                }
                if (optJSONObject != null) {
                    String str6 = new String(md9.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str7 = new String(md9.a("aXNTdXBwb3J0".getBytes()));
                    String str8 = new String(md9.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str9 = new String(md9.a("b2FpZA==".getBytes()));
                    String str10 = new String(md9.a("YWFpZA==".getBytes()));
                    String str11 = new String(md9.a("dmFpZA==".getBytes()));
                    boolean optBoolean = optJSONObject.optBoolean(str6);
                    boolean optBoolean2 = optJSONObject.optBoolean(str7);
                    int optInt = optJSONObject.optInt(str8);
                    String optString = optJSONObject.optString(str9);
                    String optString2 = optJSONObject.optString(str10);
                    String optString3 = optJSONObject.optString(str11);
                    this.a.h(optBoolean);
                    this.a.e(optBoolean2);
                    this.a.a(optInt);
                    this.a.g(optString);
                    this.a.f(optString2);
                    this.a.b(optString3);
                    dd9Var.b = this.a;
                    return true;
                }
                dd9Var.b = null;
                if (e) {
                    Log.d(d, "tryParseCacheJsonObject return cause null：");
                }
                return false;
            } catch (Exception e2) {
                if (e) {
                    String str12 = d;
                    Log.d(str12, "tryParseCacheJsonObject ：" + e2.getMessage());
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            try {
                if (this.a != null && !TextUtils.isEmpty(this.a.getOAID())) {
                    File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, ".bd_un_info.so");
                    String str = new String(md9.a("dGltZQ==".getBytes()));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, System.currentTimeMillis());
                    String str2 = new String(md9.a("dW5pb25JRG9iag==".getBytes()));
                    JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    String str3 = new String(md9.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str4 = new String(md9.a("aXNTdXBwb3J0".getBytes()));
                    String str5 = new String(md9.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str6 = new String(md9.a("b2FpZA==".getBytes()));
                    String str7 = new String(md9.a("YWFpZA==".getBytes()));
                    String str8 = new String(md9.a("dmFpZA==".getBytes()));
                    optJSONObject.put(str3, this.a.c());
                    optJSONObject.put(str4, this.a.isSupport());
                    optJSONObject.put(str5, this.a.getStatusCode());
                    optJSONObject.put(str6, this.a.getOAID());
                    optJSONObject.put(str7, this.a.getAAID());
                    optJSONObject.put(str8, this.a.getVAID());
                    jSONObject.put(str2, optJSONObject);
                    od9.b(m(jSONObject.toString()), file2, false, h);
                    if (e) {
                        String str9 = d;
                        Log.d(str9, "trySaveFiles, app: " + jSONObject.toString());
                        return true;
                    }
                    return true;
                }
                return false;
            } catch (Exception e2) {
                if (e) {
                    String str10 = d;
                    Log.d(str10, "trySaveFiles, error " + e2.getMessage());
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
