package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSResponseEntity;
import com.baidu.searchbox.aperf.bosuploader.BOSUploader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.tj9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ej9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile ej9 e;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public File b;
    public ExecutorService c;

    /* loaded from: classes3.dex */
    public class a implements fj9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;
        public final /* synthetic */ hj9 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ String f;

        public a(ej9 ej9Var, File file, hj9 hj9Var, String str, String str2, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej9Var, file, hj9Var, str, str2, jSONObject, str3};
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
            this.b = hj9Var;
            this.c = str;
            this.d = str2;
            this.e = jSONObject;
            this.f = str3;
        }

        @Override // com.baidu.tieba.fj9
        public void a(ij9 ij9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ij9Var) == null) {
                if (ij9Var != null && ij9Var.c()) {
                    if (ej9.d) {
                        Log.d("VoyagerFileManager", "bos upload success");
                    }
                    if (this.a.exists()) {
                        this.a.delete();
                    }
                    hj9 hj9Var = this.b;
                    if (hj9Var != null) {
                        hj9Var.d(this.c, this.d, this.e);
                    }
                } else if (ij9Var != null) {
                    int a = ij9Var.a();
                    String b = ij9Var.b();
                    if (ej9.d) {
                        Log.d("VoyagerFileManager", "bos upload fail: error code = " + a + ", error message: " + b);
                    }
                    hj9 hj9Var2 = this.b;
                    if (hj9Var2 != null) {
                        hj9Var2.c(this.f, a, b, this.e);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ fj9 d;
        public final /* synthetic */ ej9 e;

        public b(ej9 ej9Var, String str, String str2, File file, fj9 fj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej9Var, str, str2, file, fj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ej9Var;
            this.a = str;
            this.b = str2;
            this.c = file;
            this.d = fj9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.e.m(this.a, this.b, this.c, this.d);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947736405, "Lcom/baidu/tieba/ej9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947736405, "Lcom/baidu/tieba/ej9;");
                return;
            }
        }
        d = AppConfig.isDebug();
    }

    public static ej9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (ej9.class) {
                    if (e == null) {
                        e = new ej9();
                    }
                }
            }
            return e;
        }
        return (ej9) invokeV.objValue;
    }

    public ArrayList f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            File[] listFiles = this.a.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                return new ArrayList(Arrays.asList(listFiles));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (File) invokeV.objValue;
    }

    public ej9() {
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
        j();
        this.c = new ThreadPoolExecutor(1, 1, 600000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public void c(mj9 mj9Var, hj9 hj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, mj9Var, hj9Var) == null) {
            String j = mj9Var.j();
            String a2 = mj9Var.a();
            if (!TextUtils.isEmpty(j) && !TextUtils.isEmpty(a2)) {
                File file = new File(this.a, j);
                JSONObject c = mj9Var.c();
                if (file.exists()) {
                    if (d) {
                        Log.d("VoyagerFileManager", "retry: " + j + " exists and upload");
                    }
                    k(j, a2, file, c, hj9Var);
                    return;
                }
                d(mj9Var, hj9Var);
            }
        }
    }

    public void d(mj9 mj9Var, hj9 hj9Var) {
        File i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mj9Var, hj9Var) == null) {
            String j = mj9Var.j();
            String a2 = mj9Var.a();
            if (!TextUtils.isEmpty(j) && !TextUtils.isEmpty(a2)) {
                ArrayList g = mj9Var.g();
                JSONObject c = mj9Var.c();
                if (c == null) {
                    c = new JSONObject();
                    mj9Var.n(c);
                }
                JSONObject jSONObject = c;
                if (g != null && g.size() != 0) {
                    if (!mj9Var.l() && g.size() == 1) {
                        String str = (String) g.get(0);
                        if (TextUtils.isEmpty(str)) {
                            hj9Var.a(j, jSONObject);
                            return;
                        }
                        File file = new File(str);
                        if (!file.exists()) {
                            hj9Var.a(j, jSONObject);
                            return;
                        } else {
                            i = new File(this.a, j);
                            vj9.a(file, i);
                        }
                    } else {
                        long e2 = mj9Var.e();
                        if (e2 == 0) {
                            e2 = cj9.f().d(a2);
                        }
                        i = i(j, g, e2, jSONObject);
                    }
                    File file2 = i;
                    if (file2 != null && file2.exists()) {
                        k(j, a2, file2, jSONObject, hj9Var);
                        return;
                    } else {
                        hj9Var.b(j, jSONObject);
                        return;
                    }
                }
                hj9Var.a(j, jSONObject);
            }
        }
    }

    public void e(String str, String str2, String str3, File file, String str4, boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, file, str4, Boolean.valueOf(z), jSONObject}) == null) {
            try {
                JSONObject b2 = uj9.b(file, str4, str2, str3, z);
                jSONObject.put(str, b2);
                if (d) {
                    Log.d("VoyagerFileManager", "generateMetaInfo path " + str + " fileMeta ：" + b2);
                }
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public File i(String str, ArrayList arrayList, long j, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        JSONObject jSONObject2;
        String str2;
        File file;
        String str3;
        Iterator it;
        File file2;
        String str4;
        boolean z;
        String str5;
        File file3;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, arrayList, Long.valueOf(j), jSONObject})) == null) {
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            if (jSONObject == null) {
                jSONObject2 = new JSONObject();
            } else {
                jSONObject2 = jSONObject;
            }
            Iterator it2 = arrayList.iterator();
            long j2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    str2 = "VoyagerFileManager";
                    file = null;
                    str3 = " not exist";
                    break;
                }
                String str8 = (String) it2.next();
                if (!TextUtils.isEmpty(str8)) {
                    if (str8.startsWith("external:")) {
                        str8 = str8.replace("external:", AppRuntime.getAppContext().getExternalFilesDir(null).getParent() + File.separatorChar);
                    } else if (str8.startsWith("internal:")) {
                        str8 = str8.replace("internal:", AppRuntime.getAppContext().getApplicationInfo().dataDir + File.separator);
                    }
                    String str9 = str8;
                    if (str9.contains("../")) {
                        e(str9, "4", str9 + " error", null, null, true, jSONObject2);
                    } else {
                        File file4 = new File(str9);
                        if (!file4.exists()) {
                            e(str9, "1", str9 + " not exist", null, null, true, jSONObject2);
                        } else {
                            if (d) {
                                Log.d("VoyagerFileManager", "path: " + str9);
                            }
                            if (file4.isFile()) {
                                long length = file4.length() + j2;
                                if (d) {
                                    Log.d("VoyagerFileManager", "total file size: " + length);
                                    Log.d("VoyagerFileManager", "max file size: " + j);
                                }
                                if (length > j) {
                                    file = null;
                                    e(str9, "3", str9 + " size exceed maxFileSize ", null, null, true, jSONObject2);
                                    str3 = " not exist";
                                    str2 = "VoyagerFileManager";
                                    break;
                                }
                                file = null;
                                StringBuilder sb = new StringBuilder(wj9.c(file4.getAbsolutePath().getBytes(), true));
                                sb.append("_");
                                sb.append(file4.getName());
                                arrayList2.add(new tj9.a(file4, sb.toString()));
                                file2 = file4;
                                str4 = str9;
                                it = it2;
                                z = true;
                                str3 = " not exist";
                                e(str9, "0", str9 + " success", file2, sb.toString(), true, jSONObject2);
                                if (d) {
                                    Log.d("VoyagerFileManager", "zip name: " + ((Object) sb));
                                }
                                str5 = "VoyagerFileManager";
                                j2 = length;
                            } else {
                                it = it2;
                                file2 = file4;
                                str4 = str9;
                                file = null;
                                str3 = " not exist";
                                z = true;
                                str5 = "VoyagerFileManager";
                            }
                            if (file2.isDirectory()) {
                                ArrayList arrayList3 = new ArrayList();
                                File file5 = file2;
                                vj9.e(file5, arrayList3);
                                if (arrayList3.size() != 0) {
                                    boolean z2 = false;
                                    Iterator it3 = arrayList3.iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            String str10 = (String) it3.next();
                                            if (!TextUtils.isEmpty(str10)) {
                                                File file6 = new File(str10);
                                                if (file6.exists()) {
                                                    j2 += file6.length();
                                                    if (j2 > j) {
                                                        file3 = file5;
                                                        str6 = str5;
                                                        e(str4, "3", file5.getPath() + "size exceed maxFileSize ", null, null, true, jSONObject2);
                                                        z2 = true;
                                                        break;
                                                    }
                                                }
                                                file5 = file5;
                                                str5 = str5;
                                            }
                                        } else {
                                            file3 = file5;
                                            str6 = str5;
                                            break;
                                        }
                                    }
                                    if (z2) {
                                        str2 = str6;
                                        break;
                                    }
                                    File file7 = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "/store/");
                                    String c = wj9.c(file3.getAbsolutePath().getBytes(), z);
                                    File file8 = new File(file7, c + ".zip");
                                    if (d) {
                                        str7 = str6;
                                        Log.d(str7, "inner path: " + file7.getAbsolutePath());
                                        Log.d(str7, "inner path md5: " + c);
                                        Log.d(str7, "inner zip out file: " + file8.getAbsolutePath());
                                    } else {
                                        str7 = str6;
                                    }
                                    if (!file7.exists()) {
                                        file7.mkdir();
                                    }
                                    if (file8.exists()) {
                                        file8.delete();
                                    }
                                    if (vj9.h(file3, file8.getAbsolutePath())) {
                                        if (d) {
                                            Log.d(str7, "inner zip out file: " + file8.getName());
                                        }
                                        arrayList2.add(new tj9.a(file8, file8.getName(), z));
                                        e(str4, "0", "success", file8, file8.getPath(), false, jSONObject2);
                                    } else {
                                        StringBuilder sb2 = new StringBuilder();
                                        String str11 = str4;
                                        sb2.append(str11);
                                        sb2.append("copy error");
                                        e(str11, "2", sb2.toString(), null, null, false, jSONObject2);
                                    }
                                }
                            }
                            it2 = it;
                        }
                    }
                }
            }
            File file9 = new File(this.b, "filemeta_" + str + ".log");
            try {
                file9.createNewFile();
                vj9.g(jSONObject2.toString(), file9);
            } catch (IOException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            if (file9.exists()) {
                arrayList2.add(new tj9.a(file9, file9.getName(), true));
            }
            if (d) {
                Log.d(str2, "start generate out zip file");
            }
            File file10 = new File(this.a, str);
            try {
                if (file10.exists()) {
                    file10.delete();
                }
                file10.createNewFile();
            } catch (IOException e3) {
                if (d) {
                    e3.printStackTrace();
                }
            }
            if (arrayList2.size() > 0) {
                tj9.a(file10, arrayList2);
                File file11 = new File(file10.getAbsolutePath());
                if (d) {
                    Log.d(str2, "out put File: " + file11.getAbsolutePath());
                }
                return file11;
            }
            e(file10.getAbsolutePath(), "1", file10.getPath() + str3, null, null, true, jSONObject2);
            return file;
        }
        return (File) invokeCommon.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String str = AppRuntime.getAppContext().getApplicationInfo().dataDir + "/.voyager";
            File file = new File(str, "/upload/");
            this.a = file;
            if (!file.exists()) {
                this.a.mkdirs();
            }
            File file2 = new File(str, "/store/");
            this.b = file2;
            if (!file2.exists()) {
                this.b.mkdirs();
            }
        }
    }

    public final void k(String str, String str2, File file, JSONObject jSONObject, hj9 hj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, file, jSONObject, hj9Var) == null) {
            String str3 = str + ".zip";
            String createObjectKey = BOSUploader.getInstance().createObjectKey(str2, str3);
            if (d) {
                Log.d("VoyagerFileManager", "bos object key is : " + createObjectKey);
            }
            l(str2, str3, file, new a(this, file, hj9Var, str3, createObjectKey, jSONObject, str));
        }
    }

    public final void l(String str, String str2, File file, fj9 fj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, file, fj9Var) == null) {
            this.c.execute(new b(this, str, str2, file, fj9Var));
        }
    }

    public final void m(String str, String str2, File file, fj9 fj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, str, str2, file, fj9Var) == null) {
            BOSResponseEntity uploadFileSync = BOSUploader.getInstance().uploadFileSync(str, str2, file);
            ij9 ij9Var = new ij9(uploadFileSync.isSuccess(), uploadFileSync.getErrorCode(), uploadFileSync.getMessage());
            if (fj9Var != null) {
                fj9Var.a(ij9Var);
            }
        }
    }
}
