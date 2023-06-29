package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class e64 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static volatile e64 f;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ArrayList<b>> a;
    public final ExecutorService b;
    public String c;
    public Object d;

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str);

        void b();
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JsArrayBuffer a;
        public final /* synthetic */ b b;
        public final /* synthetic */ e64 c;

        public a(e64 e64Var, JsArrayBuffer jsArrayBuffer, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e64Var, jsArrayBuffer, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e64Var;
            this.a = jsArrayBuffer;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            String g = this.c.g(this.a.buffer());
            File file = new File(g);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    this.b.a(g);
                } else {
                    this.b.b();
                }
            } else if (this.c.e(g, this.b)) {
            } else {
                this.c.i(g, this.a.buffer());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947686278, "Lcom/baidu/tieba/e64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947686278, "Lcom/baidu/tieba/e64;");
                return;
            }
        }
        e = ms1.a;
    }

    public static e64 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f == null) {
                synchronized (e64.class) {
                    if (f == null) {
                        f = new e64();
                    }
                }
            }
            return f;
        }
        return (e64) invokeV.objValue;
    }

    public e64() {
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
        this.a = new HashMap<>();
        this.b = Executors.newCachedThreadPool();
        this.d = new Object();
        this.c = y54.g() + y54.f();
    }

    public final boolean e(String str, b bVar) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar)) == null) {
            synchronized (this.d) {
                ArrayList<b> arrayList = this.a.get(str);
                z = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(str, arrayList);
                    z = false;
                }
                arrayList.add(bVar);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public void h(JsArrayBuffer jsArrayBuffer, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jsArrayBuffer, bVar) == null) {
            this.b.execute(new a(this, jsArrayBuffer, bVar));
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this.d) {
                ArrayList<b> arrayList = this.a.get(str);
                if (arrayList == null) {
                    return;
                }
                boolean isEmpty = TextUtils.isEmpty(str);
                Iterator<b> it = arrayList.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (!isEmpty) {
                        if (e) {
                            Log.e("AudioBufferManager", "save success path: " + str);
                        }
                        next.a(str);
                    } else {
                        next.b();
                    }
                }
                this.a.remove(str);
            }
        }
    }

    public final String g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            String h = y54.h(bArr);
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            sb.append(bArr.length);
            if (TextUtils.isEmpty(h)) {
                h = "";
            }
            sb.append(h);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final void i(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, bArr) == null) {
            File file = new File(this.c);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str + ".bdsave");
            Closeable closeable = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        File file3 = new File(str);
                        if (file3.exists() && !file3.isDirectory()) {
                            file3.delete();
                        }
                        if (file2.renameTo(file3)) {
                            if (e) {
                                Log.e("AudioBufferManager", "buffer load rename success path = " + str);
                            }
                            d(str);
                        } else {
                            if (e) {
                                Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                            }
                            file2.delete();
                            d(null);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (e) {
                            e.printStackTrace();
                        }
                        if (file2.exists()) {
                            file2.delete();
                        }
                        d(null);
                        gs4.d(fileOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable = ".bdsave";
                    gs4.d(closeable);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                gs4.d(closeable);
                throw th;
            }
            gs4.d(fileOutputStream);
        }
    }
}
