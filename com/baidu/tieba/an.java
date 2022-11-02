package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.um;
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
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class an {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends um.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xm a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;

        public a(xm xmVar, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xmVar, str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xmVar;
            this.b = str;
            this.c = context;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.um.b
        /* renamed from: d */
        public void b(int i, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, jSONObject) == null) {
                this.a.onResult(this.b, -1, null);
                try {
                    try {
                        if (jSONObject == null) {
                            Log.d(TitanDownloadService.TAG, "response parse fail");
                            this.a.onResult(this.b, -1, null);
                            synchronized (an.class) {
                                boolean unused = an.b = false;
                            }
                            return;
                        }
                        if (an.a) {
                            Log.d(TitanDownloadService.TAG, "onResponse " + jSONObject);
                        }
                        PackageInfo k = an.k(this.c, jSONObject);
                        if (k.errNo != 0) {
                            if (an.a) {
                                Log.d(TitanDownloadService.TAG, "return fail result");
                            }
                            if (k.errNo != -2) {
                                Log.d(TitanDownloadService.TAG, "patch data errno = " + k.errNo);
                            }
                            this.a.onResult(this.b, -1, null);
                            synchronized (an.class) {
                                boolean unused2 = an.b = false;
                            }
                            return;
                        }
                        Log.d(TitanDownloadService.TAG, "start install patch");
                        bn.b(this.c, this.a, k, true);
                        synchronized (an.class) {
                            boolean unused3 = an.b = false;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.a.onResult(this.b, -1, null);
                        synchronized (an.class) {
                            boolean unused4 = an.b = false;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (an.class) {
                        boolean unused5 = an.b = false;
                        throw th;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements um.b<InputStream> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ String b;

        public InputStream d(int i, String str, InputStream inputStream) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, str, inputStream)) == null) ? inputStream : (InputStream) invokeILL.objValue;
        }

        public b(File file, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
            this.b = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.um.b
        public /* bridge */ /* synthetic */ InputStream a(int i, String str, InputStream inputStream) throws IOException {
            d(i, str, inputStream);
            return inputStream;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.um.b
        /* renamed from: c */
        public void b(int i, String str, InputStream inputStream) {
            MessageDigest messageDigest;
            FileOutputStream fileOutputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, inputStream) == null) {
                if (inputStream == null) {
                    if (an.a) {
                        Log.d(TitanDownloadService.TAG, "download patch inputstream is null");
                        return;
                    }
                    return;
                }
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        messageDigest = MessageDigest.getInstance("MD5");
                        fileOutputStream = new FileOutputStream(this.a);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 1024);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        messageDigest.update(bArr, 0, read);
                    }
                    String e2 = an.e(messageDigest.digest());
                    if (an.a) {
                        Log.d(TitanDownloadService.TAG, "download file md5 = " + e2);
                    }
                    if (!TextUtils.equals(this.b, e2)) {
                        Log.d(TitanDownloadService.TAG, "patch md5 not match");
                        fileOutputStream.close();
                        this.a.delete();
                    }
                    Closeables.closeSafely(inputStream);
                    Closeables.closeSafely(fileOutputStream);
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream2 = fileOutputStream;
                    this.a.delete();
                    e.printStackTrace();
                    Closeables.closeSafely(inputStream);
                    Closeables.closeSafely(fileOutputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    Closeables.closeSafely(inputStream);
                    Closeables.closeSafely(fileOutputStream2);
                    throw th;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448299808, "Lcom/baidu/tieba/an;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448299808, "Lcom/baidu/tieba/an;");
                return;
            }
        }
        a = rm.a;
        b = false;
    }

    public an() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return sm.a() + "?runtype=aps_132&appname=tieba";
        }
        return (String) invokeV.objValue;
    }

    public static File j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            File file = new File(new File(context.getCacheDir(), "titan_sandbox_cache"), "patch_cache");
            file.mkdirs();
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static String e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder("");
            if (bArr != null && bArr.length > 0) {
                for (byte b2 : bArr) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() < 2) {
                        sb.append(0);
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void f(Context context, String str, xm xmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, str, xmVar) == null) {
            synchronized (an.class) {
                if (b) {
                    if (a) {
                        Log.d(TitanDownloadService.TAG, "doInstall is installing");
                    }
                    return;
                }
                b = true;
                String z = vm.p().z(i());
                if (a) {
                    Log.d(TitanDownloadService.TAG, "url = " + z);
                }
                Log.d(TitanDownloadService.TAG, "start require patch data");
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                um.d(context, z, "POST", h(), hashMap, new a(xmVar, str, context));
            }
        }
    }

    public static String g(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, context, str, str2, str3)) == null) {
            File j = j(context);
            for (File file : j.listFiles()) {
                if (file.isFile()) {
                    file.delete();
                }
            }
            File file2 = new File(j, str3);
            Log.d(TitanDownloadService.TAG, "start download patch");
            um.d(context, str, "GET", null, null, new b(file2, str2));
            if (file2.exists()) {
                return file2.getAbsolutePath();
            }
            return null;
        }
        return (String) invokeLLLL.objValue;
    }

    public static byte[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            zm d = zm.d();
            d.g();
            JSONObject jSONObject5 = new JSONObject();
            try {
                jSONObject4.put("com.baidu.titan.patch", String.valueOf(d.b()));
                jSONObject3.put("132", jSONObject4);
                jSONObject2.put("aps", jSONObject3);
                jSONObject.put("versions", jSONObject2);
                jSONObject5.put("bd_version", AppConfig.AppInfo.getVersionName());
                jSONObject5.put("device_ua", "android");
                jSONObject.put("pubparam", jSONObject5);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                String jSONObject6 = jSONObject.toString();
                if (rm.a) {
                    Log.d(TitanDownloadService.TAG, "getCcsContent = " + jSONObject6);
                }
                return jSONObject6.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public static PackageInfo k(Context context, JSONObject jSONObject) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, jSONObject)) == null) {
            PackageInfo packageInfo = new PackageInfo();
            int optInt = jSONObject.optInt("errno", -1);
            packageInfo.errNo = optInt;
            if (optInt != 0) {
                if (a) {
                    Log.d(TitanDownloadService.TAG, "response errno = " + optInt);
                }
                return packageInfo;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            if (!jSONObject2.has("service")) {
                packageInfo.errNo = -2;
                return packageInfo;
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("service");
            if (!jSONObject3.has("aps")) {
                packageInfo.errNo = -2;
                return packageInfo;
            }
            JSONObject jSONObject4 = jSONObject3.getJSONObject("aps");
            if (!jSONObject4.has("132")) {
                packageInfo.errNo = -2;
                return packageInfo;
            }
            JSONObject jSONObject5 = jSONObject4.getJSONObject("132");
            if (!jSONObject5.has("com.baidu.titan.patch")) {
                packageInfo.errNo = -2;
                return packageInfo;
            }
            JSONObject jSONObject6 = jSONObject5.getJSONObject("com.baidu.titan.patch");
            String string = jSONObject6.getString("version");
            JSONObject jSONObject7 = jSONObject6.getJSONObject("data").getJSONObject("pkg_info");
            String string2 = jSONObject7.getString("version");
            String string3 = jSONObject7.getString("name");
            String string4 = jSONObject7.getString(PackageTable.MD5);
            String string5 = jSONObject7.getString("maxv");
            String string6 = jSONObject7.getString("minv");
            String string7 = jSONObject7.getString("download_url");
            if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string4) && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string7)) {
                String g = g(context, string7, string4, "com.baidu.titan.patch_" + string4 + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                if (g == null) {
                    packageInfo.errNo = -4;
                    return packageInfo;
                }
                packageInfo.filePath = g;
                packageInfo.packageName = "com.baidu.titan.patch";
                packageInfo.version = Long.valueOf(string2).longValue();
                packageInfo.maxHostVersion = string5;
                packageInfo.minHostVersion = string6;
                packageInfo.updateVersion = Long.valueOf(string).longValue();
                return packageInfo;
            }
            packageInfo.errNo = -3;
            return packageInfo;
        }
        return (PackageInfo) invokeLL.objValue;
    }
}
