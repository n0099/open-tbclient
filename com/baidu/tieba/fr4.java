package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public fr4(Context context) {
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

    public final boolean a(yr4 yr4Var) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yr4Var)) == null) {
            File file = new File(this.a.getFilesDir() + File.separator + "ubcdir", "proc");
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    BufferedReader bufferedReader = null;
                    try {
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                            long j = Long.MAX_VALUE;
                            long j2 = 0;
                            int i = 0;
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                                    if (jSONObject.has("abtest")) {
                                        yr4Var.f = "1";
                                    }
                                    long j3 = jSONObject.getLong("timestamp");
                                    if (j3 > 0) {
                                        if (j3 < j) {
                                            j = j3;
                                        }
                                        if (j3 > j2) {
                                            j2 = j3;
                                        }
                                    }
                                    yr4Var.a(jSONObject);
                                    i++;
                                    if (i >= 10) {
                                        break;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    bufferedReader = bufferedReader2;
                                    e.printStackTrace();
                                    gs4.d(bufferedReader);
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader = bufferedReader2;
                                    gs4.d(bufferedReader);
                                    throw th;
                                }
                            }
                            yr4Var.g(j, j2);
                            gs4.d(bufferedReader2);
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void b(boolean z) {
        String str;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            File file = new File(this.a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                return;
            }
            if (z) {
                str = "filereal";
            } else {
                str = "filedata";
            }
            File file2 = new File(file, str);
            if (file2.exists()) {
                file2.delete();
            }
            File file3 = new File(file, "proc");
            if (file3.exists() && file3.isDirectory() && (listFiles = file3.listFiles()) != null && listFiles.length != 0) {
                for (File file4 : listFiles) {
                    if (file4.isFile()) {
                        file4.delete();
                    }
                }
            }
        }
    }

    public boolean c(yr4 yr4Var, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, yr4Var, z)) == null) {
            File file = new File(this.a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                file.mkdir();
            }
            if (!z) {
                z2 = a(yr4Var);
            } else {
                z2 = false;
            }
            if (z) {
                str = "filereal";
            } else {
                str = "filedata";
            }
            File file2 = new File(file, str);
            if (file2.exists()) {
                BufferedReader bufferedReader = null;
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                    long j = Long.MAX_VALUE;
                    long j2 = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                            if (jSONObject.has("abtest")) {
                                yr4Var.f = "1";
                            }
                            long j3 = jSONObject.getLong("timestamp");
                            if (j3 > 0) {
                                if (j3 < j) {
                                    j = j3;
                                }
                                if (j3 > j2) {
                                    j2 = j3;
                                }
                            }
                            yr4Var.a(jSONObject);
                            z2 = true;
                        } catch (Exception unused) {
                            bufferedReader = bufferedReader2;
                            gs4.d(bufferedReader);
                            return z2;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            gs4.d(bufferedReader);
                            throw th;
                        }
                    }
                    yr4Var.g(j, j2);
                    gs4.d(bufferedReader2);
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return z2;
        }
        return invokeLZ.booleanValue;
    }

    public void d(mr4 mr4Var, boolean z) {
        String str;
        File file;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, mr4Var, z) == null) {
            File file2 = new File(this.a.getFilesDir(), "ubcdir");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!TextUtils.isEmpty(mr4Var.k)) {
                File file3 = new File(file2, "proc");
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                file = new File(file3, mr4Var.k);
            } else {
                if (z) {
                    str = "filereal";
                } else {
                    str = "filedata";
                }
                file = new File(file2, str);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (mr4Var.e != null) {
                    JSONObject jSONObject2 = mr4Var.e;
                    if (jSONObject2.has("bizId")) {
                        try {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("content");
                            JSONObject jSONObject4 = jSONObject2.getJSONObject(DI.APP_INFO_NAME);
                            if (jSONObject3 != null && jSONObject4 != null) {
                                jSONObject3.put(DI.APP_INFO_NAME, jSONObject4);
                                jSONObject2.remove(DI.APP_INFO_NAME);
                            }
                            jSONObject = jSONObject2;
                        } catch (JSONException unused) {
                            jSONObject = jSONObject2;
                        }
                    } else {
                        jSONObject.put("content", jSONObject2);
                    }
                } else if (!TextUtils.isEmpty(mr4Var.d)) {
                    jSONObject.put("content", mr4Var.d);
                }
                jSONObject.put("bizId", mr4Var.a);
                jSONObject.put("timestamp", mr4Var.f);
                jSONObject.put("eventType", "0");
                if (!TextUtils.isEmpty(mr4Var.h)) {
                    jSONObject.put("abtest", mr4Var.h);
                }
                if (!TextUtils.isEmpty(mr4Var.i)) {
                    jSONObject.put("c", mr4Var.i);
                }
                if (mr4Var.j) {
                    jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                }
                jSONObject.put(Constant.ID_TYPE, hr4.g().j(mr4Var.a));
            } catch (JSONException unused2) {
            }
            byte[] encode = Base64.encode(jSONObject.toString().getBytes(), 2);
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, true);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(encode);
                fileOutputStream.write("\n".getBytes());
                fileOutputStream.flush();
                gs4.d(fileOutputStream);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                gs4.d(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                gs4.d(fileOutputStream2);
                throw th;
            }
        }
    }
}
