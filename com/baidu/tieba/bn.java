package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.vm;
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
/* loaded from: classes5.dex */
public class bn {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448300769, "Lcom/baidu/tieba/bn;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448300769, "Lcom/baidu/tieba/bn;");
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends vm.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ym a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;

        public a(ym ymVar, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ymVar, str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ymVar;
            this.b = str;
            this.c = context;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vm.b
        /* renamed from: d */
        public void b(int i, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, jSONObject) == null) {
                this.a.onResult(this.b, -1, null);
                try {
                    try {
                        if (jSONObject == null) {
                            ew8 defaultLog = DefaultLog.getInstance();
                            defaultLog.b(TitanDownloadService.TAG, "response parse fail:" + this.b);
                            this.a.onResult(this.b, -1, null);
                            synchronized (bn.class) {
                                boolean unused = bn.a = false;
                            }
                            return;
                        }
                        ew8 defaultLog2 = DefaultLog.getInstance();
                        defaultLog2.c(TitanDownloadService.TAG, "onResponse " + jSONObject);
                        PackageInfo j = bn.j(this.c, jSONObject);
                        if (j.errNo != 0) {
                            ew8 defaultLog3 = DefaultLog.getInstance();
                            defaultLog3.b(TitanDownloadService.TAG, "return fail, result errno = " + j.errNo);
                            this.a.onResult(this.b, -1, null);
                            synchronized (bn.class) {
                                boolean unused2 = bn.a = false;
                            }
                            return;
                        }
                        DefaultLog.getInstance().c(TitanDownloadService.TAG, "start install patch");
                        cn.b(this.c, this.a, j, true);
                        synchronized (bn.class) {
                            boolean unused3 = bn.a = false;
                        }
                    } catch (Exception e) {
                        ew8 defaultLog4 = DefaultLog.getInstance();
                        defaultLog4.b(TitanDownloadService.TAG, "TitanRequester onResponse Exception:" + e);
                        this.a.onResult(this.b, -1, null);
                        synchronized (bn.class) {
                            boolean unused4 = bn.a = false;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (bn.class) {
                        boolean unused5 = bn.a = false;
                        throw th;
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements vm.b<InputStream> {
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
        @Override // com.baidu.tieba.vm.b
        public /* bridge */ /* synthetic */ InputStream a(int i, String str, InputStream inputStream) throws IOException {
            d(i, str, inputStream);
            return inputStream;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vm.b
        /* renamed from: c */
        public void b(int i, String str, InputStream inputStream) {
            MessageDigest messageDigest;
            FileOutputStream fileOutputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, inputStream) == null) {
                if (inputStream == null) {
                    DefaultLog.getInstance().b(TitanDownloadService.TAG, "download patch inputstream is null");
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
                    String d = bn.d(messageDigest.digest());
                    ew8 defaultLog = DefaultLog.getInstance();
                    defaultLog.c(TitanDownloadService.TAG, "download file md5 = " + d);
                    if (!TextUtils.equals(this.b, d)) {
                        DefaultLog.getInstance().b(TitanDownloadService.TAG, "patch md5 not match");
                        fileOutputStream.close();
                        this.a.delete();
                    }
                    Closeables.closeSafely(inputStream);
                    Closeables.closeSafely(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
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

    public bn() {
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

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return tm.a() + "?runtype=aps_132&appname=tieba";
        }
        return (String) invokeV.objValue;
    }

    public static File i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            File file = new File(new File(context.getCacheDir(), "titan_sandbox_cache"), "patch_cache");
            file.mkdirs();
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static String d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
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

    public static void e(Context context, String str, ym ymVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, context, str, ymVar) == null) {
            synchronized (bn.class) {
                if (a) {
                    DefaultLog.getInstance().b(TitanDownloadService.TAG, "doInstall is installing");
                    return;
                }
                a = true;
                String z = wm.p().z(h());
                ew8 defaultLog = DefaultLog.getInstance();
                defaultLog.c(TitanDownloadService.TAG, "start require patch data, url = " + z);
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                vm.c(context, z, "POST", g(), hashMap, new a(ymVar, str, context));
            }
        }
    }

    public static String f(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, context, str, str2, str3)) == null) {
            File i = i(context);
            if (i != null && (listFiles = i.listFiles()) != null) {
                for (File file : listFiles) {
                    if (file != null && file.isFile()) {
                        file.delete();
                    }
                }
            }
            File file2 = new File(i, str3);
            DefaultLog.getInstance().c(TitanDownloadService.TAG, "start download patch");
            vm.c(context, str, "GET", null, null, new b(file2, str2));
            if (file2.exists()) {
                return file2.getAbsolutePath();
            }
            return null;
        }
        return (String) invokeLLLL.objValue;
    }

    public static byte[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            an d = an.d();
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
                ew8 defaultLog = DefaultLog.getInstance();
                defaultLog.b(TitanDownloadService.TAG, "getCcsPostContent JSONException:" + e);
            }
            try {
                String jSONObject6 = jSONObject.toString();
                ew8 defaultLog2 = DefaultLog.getInstance();
                defaultLog2.c(TitanDownloadService.TAG, "getCcsContent = " + jSONObject6);
                return jSONObject6.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e2) {
                ew8 defaultLog3 = DefaultLog.getInstance();
                defaultLog3.b(TitanDownloadService.TAG, "getCcsPostContent UnsupportedEncodingException:" + e2);
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public static PackageInfo j(Context context, JSONObject jSONObject) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, jSONObject)) == null) {
            PackageInfo packageInfo = new PackageInfo();
            int optInt = jSONObject.optInt("errno", -1);
            packageInfo.errNo = optInt;
            if (optInt != 0) {
                ew8 defaultLog = DefaultLog.getInstance();
                defaultLog.b(TitanDownloadService.TAG, "response errno = " + optInt);
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
                String f = f(context, string7, string4, "com.baidu.titan.patch_" + string4 + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                if (f == null) {
                    packageInfo.errNo = -4;
                    return packageInfo;
                }
                packageInfo.filePath = f;
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
