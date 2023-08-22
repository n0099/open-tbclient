package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public fq4 b;
    public gq4 c;
    public List<nq4> d;
    public long e;
    public long f;
    public long g;
    public int h;
    public SparseArray<ArrayList> i;
    public HashMap<String, Long> j;
    public rq4 k;
    public iq4 l;

    public hq4(Context context) {
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
        this.b = new fq4(context);
        this.c = new gq4(context);
        this.k = jq4.g().l();
        this.d = new ArrayList(20);
        yq4 e = yq4.e();
        this.e = e.getLong("ubc_last_upload_all_time", 0L);
        this.f = e.getLong("ubc_last_upload_non_real", 0L);
        this.g = e.getLong("ubc_reset_real_time_count_time", 0L);
        this.h = e.getInt("ubc_real_time_count", 0);
        iq4 g = iq4.g();
        this.l = g;
        g.k(this, context);
    }

    public void k(nq4 nq4Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, nq4Var) == null) {
            if (TextUtils.equals(nq4Var.a, nq4Var.b) && this.l.b(nq4Var.a) && (nq4Var.g & 64) == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && !A(nq4Var)) {
                this.b.y(nq4Var);
            } else if (Math.abs(System.currentTimeMillis() - this.f) >= iq4.g().h()) {
                if (!z) {
                    this.d.add(nq4Var);
                }
                z();
            } else if ((1 & nq4Var.g) == 0) {
                if (!z) {
                    this.d.add(nq4Var);
                }
                if (this.d.size() >= 20) {
                    j();
                }
            } else if (!z) {
                this.b.y(nq4Var);
            }
        }
    }

    public final void q(zq4 zq4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, zq4Var) != null) || zq4Var.d()) {
            return;
        }
        JSONArray jSONArray = zq4Var.a;
        String d = jr4.d(jSONArray.toString().getBytes(), true);
        m(jSONArray.toString(), d);
        this.b.A(d, zq4Var.g);
        if (!this.b.g(zq4Var.b, zq4Var.c, zq4Var.g, d)) {
            zq4Var.c();
            File file = new File(this.a.getFilesDir() + File.separator + "statistics_data", d);
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
            }
            this.b.i(d);
            return;
        }
        sq4.f().r(jSONArray, d);
        zq4Var.c();
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            File file = new File(this.a.getFilesDir() + File.separator + "statistics_data", str);
            InputStream inputStream = null;
            try {
                InputStream fileInputStream = new FileInputStream(file);
                try {
                    if (fileInputStream.available() > 0) {
                        inputStream = new Base64InputStream(fileInputStream, 0);
                        sq4.f().r(new JSONArray(lr4.c(inputStream)), str);
                        fileInputStream = inputStream;
                    }
                    hr4.d(fileInputStream);
                } catch (Exception unused) {
                    inputStream = fileInputStream;
                    hr4.d(inputStream);
                } catch (Throwable th) {
                    th = th;
                    inputStream = fileInputStream;
                    hr4.d(inputStream);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final boolean A(nq4 nq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nq4Var)) == null) {
            if (!g(this.a) || !c()) {
                return false;
            }
            j();
            zq4 zq4Var = new zq4();
            zq4Var.g = true;
            JSONObject jSONObject = nq4Var.e;
            try {
                if (jSONObject != null && jSONObject.has("bizId")) {
                    wq4.a(jSONObject);
                    zq4Var.a(jSONObject);
                    long j = nq4Var.f;
                    zq4Var.g(j, j);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                    JSONObject jSONObject3 = jSONObject.getJSONObject(DI.APP_INFO_NAME);
                    if (jSONObject2 != null && jSONObject3 != null) {
                        jSONObject2.put(DI.APP_INFO_NAME, jSONObject3);
                        jSONObject.remove(DI.APP_INFO_NAME);
                    }
                } else {
                    JSONObject e = new wq4(nq4Var.a()).e();
                    e.put("bizId", nq4Var.a);
                    e.put("timestamp", Long.toString(nq4Var.f));
                    if (nq4Var.e != null) {
                        e.put("content", nq4Var.e);
                    } else {
                        e.put("content", nq4Var.d);
                    }
                    e.put("eventType", "0");
                    if (!TextUtils.isEmpty(nq4Var.h)) {
                        e.put("abtest", nq4Var.h);
                        zq4Var.f = "1";
                    }
                    if (!TextUtils.isEmpty(nq4Var.i)) {
                        e.put("c", nq4Var.i);
                    }
                    if (nq4Var.j) {
                        e.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                    }
                    e.put(Constant.ID_TYPE, this.l.j(nq4Var.a));
                    zq4Var.a(e);
                    zq4Var.g(nq4Var.f, nq4Var.f);
                }
            } catch (JSONException unused) {
            }
            if (this.i == null) {
                f();
            }
            if (this.i.size() > 0) {
                this.b.m(this.i.valueAt(0), zq4Var);
            }
            q(zq4Var);
            i();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !g(this.a) || !c()) {
            return;
        }
        zq4 zq4Var = new zq4();
        zq4Var.g = true;
        if (this.i == null) {
            f();
        }
        if (this.i.size() > 0) {
            if (jq4.g().r()) {
                this.b.l(zq4Var);
            } else {
                this.b.m(this.i.valueAt(0), zq4Var);
            }
        }
        q(zq4Var);
        i();
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (jq4.g().r()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.g) > 86400000) {
                this.h = 0;
                this.g = currentTimeMillis;
                yq4.e().putLong("ubc_reset_real_time_count_time", this.g);
                yq4.e().putInt("ubc_real_time_count", this.h);
            }
            int i = this.h;
            if (i < 1000) {
                return true;
            }
            if (i == 1000) {
                this.h = i + 1;
                jq4.h("23", "realLimit");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.i != null) {
            return;
        }
        SparseArray<ArrayList> sparseArray = new SparseArray<>();
        this.i = sparseArray;
        this.b.v(sparseArray);
        this.j = new HashMap<>();
        int i = 0;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            int keyAt = this.i.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            HashMap<String, Long> hashMap = this.j;
            hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.l.p(i);
    }

    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            j();
            this.b.d(str, i);
            if (Math.abs(System.currentTimeMillis() - this.f) >= iq4.g().h()) {
                z();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n(true);
            n(false);
        }
    }

    public fq4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (fq4) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.h++;
            yq4.e().putInt("ubc_real_time_count", this.h);
        }
    }

    public final void j() {
        List<nq4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (list = this.d) != null && list.size() != 0) {
            this.b.z(this.d);
            this.d.clear();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b.C();
        }
    }

    public void d(String str, int i, long j, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), jSONArray}) == null) {
            j();
            this.b.j(str, i, j, jSONArray);
            if (this.l.b(str)) {
                B();
            }
            if (Math.abs(System.currentTimeMillis() - this.f) >= iq4.g().h()) {
                z();
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public final boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo networkInfo = null;
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception unused) {
            }
            if (networkInfo == null || !networkInfo.isAvailable()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void l(nq4 nq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, nq4Var) == null) {
            this.c.d(nq4Var, this.l.b(nq4Var.a));
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            zq4 zq4Var = new zq4();
            zq4Var.g = z;
            if (this.c.c(zq4Var, z)) {
                JSONArray jSONArray = zq4Var.a;
                this.c.b(z);
                sq4.f().s(jSONArray);
            }
        }
    }

    public void p(pq4 pq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pq4Var) == null) {
            this.b.B(pq4Var);
        }
    }

    public void w(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, jSONArray) == null) && !this.k.a(jSONArray)) {
            jq4.h("23", "sendFail");
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            xq4.a("upload file fail");
            this.b.F(str);
        }
    }

    public void h() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || !g(this.a)) {
            return;
        }
        File file = new File(this.a.getFilesDir() + File.separator + "statistics_data");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            if (listFiles.length > 50) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "del_file");
                    jSONObject.put("del_file_size", listFiles.length);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jq4.h("23", jSONObject.toString());
                for (File file2 : listFiles) {
                    file2.delete();
                }
                this.b.h();
            }
            for (int i = 0; i < listFiles.length; i++) {
                oq4 u = this.b.u(listFiles[i].getName());
                if (u != null && TextUtils.equals("0", u.a())) {
                    xq4.a("processFailedData file, no need to send");
                } else if (u != null && TextUtils.equals("1", u.a())) {
                    xq4.a("processFailedData file, send");
                    this.b.G(listFiles[i].getName(), "0");
                    v(listFiles[i].getName());
                } else {
                    xq4.a("processFailedData file, data in db, delete file");
                    listFiles[i].delete();
                }
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || !g(this.a) || Math.abs(System.currentTimeMillis() - this.e) < 3600000) {
            return;
        }
        this.b.f();
        zq4 zq4Var = new zq4();
        if (this.b.l(zq4Var) == 0) {
            return;
        }
        zq4 zq4Var2 = new zq4();
        zq4Var2.g(zq4Var.d, zq4Var.e);
        zq4Var2.f = zq4Var.f;
        zq4Var2.g = true;
        zq4 zq4Var3 = new zq4();
        zq4Var3.g(zq4Var.d, zq4Var.e);
        zq4Var3.f = zq4Var.f;
        zq4Var3.g = false;
        SparseIntArray sparseIntArray = zq4Var.b;
        int size = sparseIntArray.size();
        for (int i = 0; i < size; i++) {
            if (this.l.b(String.valueOf(sparseIntArray.valueAt(i)))) {
                zq4Var2.f(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
            } else {
                zq4Var3.f(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
            }
        }
        ArrayList<String> arrayList = zq4Var.c;
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String str = arrayList.get(i2);
            if (this.l.b(str)) {
                zq4Var2.e(str);
            } else {
                zq4Var3.e(str);
            }
        }
        JSONArray jSONArray = zq4Var.a;
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject.has("bizId")) {
                String str2 = null;
                try {
                    str2 = optJSONObject.getString("bizId");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (this.l.b(str2)) {
                        zq4Var2.a(optJSONObject);
                    } else {
                        zq4Var3.a(optJSONObject);
                    }
                }
            }
        }
        if (zq4Var2.a.length() > 0) {
            q(zq4Var2);
        }
        if (zq4Var3.a.length() > 0) {
            q(zq4Var3);
        }
        this.e = System.currentTimeMillis();
        yq4.e().putLong("ubc_last_upload_all_time", this.e);
        this.f = this.e;
        yq4.e().putLong("ubc_last_upload_non_real", this.f);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048603, this) != null) || !g(this.a)) {
            return;
        }
        this.f = System.currentTimeMillis();
        yq4.e().putLong("ubc_last_upload_non_real", this.f);
        b();
        j();
        this.b.f();
        HashSet hashSet = new HashSet();
        if (this.i == null) {
            f();
        }
        zq4 zq4Var = new zq4();
        zq4Var.g = false;
        int i = 0;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            int keyAt = this.i.keyAt(i2);
            if (keyAt != 0) {
                HashMap<String, Long> hashMap = this.j;
                long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.l.h()) {
                    i |= this.b.m(this.i.valueAt(i2), zq4Var);
                    HashMap<String, Long> hashMap2 = this.j;
                    hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                    hashSet.add(Integer.valueOf(keyAt));
                }
            }
        }
        if (i == 0) {
            return;
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            int keyAt2 = this.i.keyAt(i3);
            if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                if (zq4Var.b(51200)) {
                    break;
                }
                this.b.m(this.i.valueAt(i3), zq4Var);
            }
        }
        q(zq4Var);
    }

    public final void m(String str, String str2) {
        OutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            String str3 = this.a.getFilesDir() + File.separator + "statistics_data";
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(str3, str2);
            if (!file2.exists()) {
                OutputStream outputStream = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    outputStream = new Base64OutputStream(fileOutputStream, 0);
                    outputStream.write(str.getBytes());
                    outputStream.flush();
                    xq4.a("save to file suc");
                } catch (Exception e2) {
                    e = e2;
                    outputStream = fileOutputStream;
                    e.printStackTrace();
                    hr4.d(outputStream);
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = fileOutputStream;
                    hr4.d(outputStream);
                    throw th;
                }
                hr4.d(outputStream);
            }
        }
    }

    public void r(vq4 vq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, vq4Var) == null) {
            this.l.q(vq4Var.a());
            this.l.n(vq4Var.d() * 86400000);
            this.l.o(vq4Var.c());
            yq4.e().putString("ubc_version_md5", vq4Var.b());
            this.b.D(vq4Var.a());
            vq4Var.a().clear();
            if (this.i == null) {
                this.i = new SparseArray<>();
            }
            this.i.clear();
            if (this.j == null) {
                this.j = new HashMap<>();
            }
            this.j.clear();
            this.b.v(this.i);
            int i = 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                int keyAt = this.i.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                HashMap<String, Long> hashMap = this.j;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.l.p(i);
        }
    }

    public void s(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048596, this, str, i, str2) == null) {
            this.b.E(str, i, str2);
        }
    }

    public final void u(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, jSONArray, str) == null) {
            sq4.f().t(str, this.k.a(jSONArray));
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            File file = new File(this.a.getFilesDir() + File.separator + "statistics_data", str);
            xq4.a("delete file");
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
                xq4.a("delete file suc");
            }
            this.b.i(str);
        }
    }
}
