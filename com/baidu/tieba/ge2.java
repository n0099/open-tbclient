package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes6.dex */
public class ge2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpManager a;
    public String b;
    public String c;
    public ee2 d;

    /* loaded from: classes6.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge2 a;

        public a(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge2Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (ge2.e) {
                    Log.e("ImageDownloader", this.a.b + " load failed");
                    iOException.printStackTrace();
                }
                if (this.a.d != null) {
                    this.a.d.b(-1, this.a.b);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FileOutputStream fileOutputStream;
            File file;
            InputStream byteStream;
            String c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (TextUtils.isEmpty(this.a.c)) {
                    if (rm1.a) {
                        Log.e("SwanGameRuntime", "非手百环境依赖注入接口未实现，直接返回");
                        return;
                    }
                    return;
                }
                byte[] bArr = new byte[2048];
                InputStream inputStream = null;
                try {
                    byteStream = response.body().byteStream();
                    try {
                        try {
                            c = op2.f().c(this.a.b);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = null;
                        }
                    } catch (Exception e) {
                        e = e;
                        file = null;
                        fileOutputStream = null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    file = null;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
                if (TextUtils.isEmpty(c)) {
                    if (rm1.a) {
                        Log.e("SwanGameRuntime", "非手百环境依赖注入接口convertSrc()未实现，直接返回");
                    }
                    jm4.d(byteStream);
                    jm4.d(null);
                    jm4.d(response);
                    return;
                }
                String str = this.a.c + c.substring(0, c.lastIndexOf("/"));
                File file2 = new File(str);
                if (!file2.exists() || !file2.isDirectory()) {
                    file2.mkdirs();
                }
                String substring = c.substring(c.lastIndexOf("/") + 1);
                file = new File(str, substring + ".bddownload");
                try {
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = byteStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        } catch (Exception e3) {
                            e = e3;
                            inputStream = byteStream;
                            try {
                                if (ge2.e) {
                                    Log.e("ImageDownloader", this.a.b + " load failed", e);
                                }
                                if (file != null) {
                                    file.delete();
                                }
                                if (this.a.d != null) {
                                    this.a.d.b(-1, this.a.b);
                                }
                                jm4.d(inputStream);
                                jm4.d(fileOutputStream);
                                jm4.d(response);
                            } catch (Throwable th3) {
                                th = th3;
                                jm4.d(inputStream);
                                jm4.d(fileOutputStream);
                                jm4.d(response);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = byteStream;
                            jm4.d(inputStream);
                            jm4.d(fileOutputStream);
                            jm4.d(response);
                            throw th;
                        }
                    }
                    fileOutputStream.flush();
                    File file3 = new File(str, substring);
                    if (file3.exists() && !file3.isDirectory()) {
                        file3.delete();
                    }
                    String absolutePath = file3.getAbsolutePath();
                    if (file.renameTo(file3)) {
                        if (ge2.e) {
                            Log.e("ImageDownloader", this.a.b + " load rename success path = " + absolutePath);
                        }
                        if (this.a.d != null) {
                            this.a.d.a(this.a.b, absolutePath);
                        }
                    } else {
                        if (ge2.e) {
                            Log.e("ImageDownloader", this.a.b + " load rename error path = " + absolutePath);
                        }
                        file.delete();
                        if (this.a.d != null) {
                            this.a.d.b(-1, absolutePath);
                        }
                    }
                    jm4.d(byteStream);
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                }
                jm4.d(fileOutputStream);
                jm4.d(response);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947790965, "Lcom/baidu/tieba/ge2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947790965, "Lcom/baidu/tieba/ge2;");
                return;
            }
        }
        e = rm1.a;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            op2.l().a(this.a, new Request.Builder().url(this.b).build(), new a(this));
        }
    }

    public ge2(HttpManager httpManager, String str, String str2, ee2 ee2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpManager, str, str2, ee2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = "";
        this.c = "";
        this.a = httpManager;
        this.c = str;
        this.b = str2;
        this.d = ee2Var;
    }
}
