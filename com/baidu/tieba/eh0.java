package com.baidu.tieba;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class eh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public eh0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public boolean a(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, file)) == null) {
            boolean b = b(str, file);
            if (file.isDirectory()) {
                File file2 = new File(file, ".nomedia");
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return b;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x00de A[Catch: IOException -> 0x00da, TRY_LEAVE, TryCatch #0 {IOException -> 0x00da, blocks: (B:76:0x00d6, B:80:0x00de), top: B:88:0x00d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(String str, File file) {
        InterceptResult invokeLL;
        InputStream inputStream;
        InputStream open;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, file)) == null) {
            AssetManager assets = this.a.getAssets();
            FileOutputStream fileOutputStream = null;
            try {
                String[] list = assets.list(str);
                if (list.length > 0) {
                    if (!file.isDirectory() && file.exists()) {
                        file.delete();
                    }
                    if (file.isDirectory() && !file.exists()) {
                        file.mkdirs();
                    }
                    for (String str2 : list) {
                        if (!TextUtils.isEmpty(str2)) {
                            b(str + File.separator + str2, new File(file, str2));
                        }
                    }
                    open = null;
                } else {
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    open = assets.open(str);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = open.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            }
                            fileOutputStream2.flush();
                            fileOutputStream = fileOutputStream2;
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            Exception exc = e;
                            inputStream = open;
                            e = exc;
                            try {
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        return false;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            Throwable th3 = th;
                            inputStream = open;
                            th = th3;
                            if (fileOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return true;
                    }
                }
                if (open != null) {
                    open.close();
                    return true;
                }
                return true;
            } catch (Exception e6) {
                e = e6;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }
}
