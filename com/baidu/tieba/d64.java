package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes5.dex */
public class d64 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public ja4 a;
    public String b;
    public String c;
    public b64 d;

    /* loaded from: classes5.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d64 a;

        public a(d64 d64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d64Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (d64.e) {
                    Log.e("AudioDownloader", this.a.b + " load failed");
                    iOException.printStackTrace();
                }
                if (this.a.d != null) {
                    this.a.d.fail(-1, this.a.b);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            FileOutputStream fileOutputStream;
            File file;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                byte[] bArr = new byte[2048];
                InputStream inputStream = null;
                try {
                    InputStream byteStream = response.body().byteStream();
                    try {
                        try {
                            String d = y54.d(this.a.b);
                            String str = this.a.c + d.substring(0, d.lastIndexOf("/"));
                            File file2 = new File(str);
                            if (!file2.exists() || !file2.isDirectory()) {
                                file2.mkdirs();
                            }
                            String substring = d.substring(d.lastIndexOf("/") + 1);
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
                                    } catch (Exception e) {
                                        e = e;
                                        inputStream = byteStream;
                                        try {
                                            if (d64.e) {
                                                Log.e("AudioDownloader", this.a.b + " load failed", e);
                                            }
                                            if (file != null) {
                                                file.delete();
                                            }
                                            if (this.a.d != null) {
                                                this.a.d.fail(-1, this.a.b);
                                            }
                                            gs4.d(inputStream);
                                            gs4.d(fileOutputStream);
                                            gs4.d(response);
                                        } catch (Throwable th) {
                                            th = th;
                                            gs4.d(inputStream);
                                            gs4.d(fileOutputStream);
                                            gs4.d(response);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream = byteStream;
                                        gs4.d(inputStream);
                                        gs4.d(fileOutputStream);
                                        gs4.d(response);
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
                                    if (d64.e) {
                                        Log.e("AudioDownloader", this.a.b + " load rename success path = " + absolutePath);
                                    }
                                    if (this.a.d != null) {
                                        this.a.d.a(this.a.b, absolutePath);
                                    }
                                } else {
                                    if (d64.e) {
                                        Log.e("AudioDownloader", this.a.b + " load rename error path = " + absolutePath);
                                    }
                                    file.delete();
                                    if (this.a.d != null) {
                                        this.a.d.fail(-1, absolutePath);
                                    }
                                }
                                gs4.d(byteStream);
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = null;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            file = null;
                            fileOutputStream = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    file = null;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
                gs4.d(fileOutputStream);
                gs4.d(response);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947656487, "Lcom/baidu/tieba/d64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947656487, "Lcom/baidu/tieba/d64;");
                return;
            }
        }
        e = ms1.a;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.call(new Request.Builder().url(this.b).build(), new a(this));
        }
    }

    public d64(ja4 ja4Var, String str, String str2, b64 b64Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ja4Var, str, str2, b64Var};
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
        this.a = ja4Var;
        this.c = str;
        this.b = str2;
        this.d = b64Var;
    }
}
