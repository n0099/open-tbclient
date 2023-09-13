package com.baidu.tieba;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes5.dex */
public class fj4 extends ej4 {
    public static /* synthetic */ Interceptable $ic;
    public static final jo4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ij4 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947766041, "Lcom/baidu/tieba/fj4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947766041, "Lcom/baidu/tieba/fj4;");
                return;
            }
        }
        c = jo4.c();
    }

    public fj4() {
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
        this.b = new ij4();
    }

    public final <T extends fk4> boolean A(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            try {
                jo4 jo4Var = c;
                jo4Var.i("PMSDBImpl", "#addPackage bundleId=" + t);
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.b.b(t.getClass()), this.b.a(t.getClass()).c(t));
                if (insert != null) {
                    if (ContentUris.parseId(insert) > 0) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                c.g("PMSDBImpl", "#addPackage error", e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final PMSAppInfo B(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                hj4 a = this.b.a(PMSAppInfo.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
                if (cursor != null) {
                    try {
                        try {
                            PMSAppInfo pMSAppInfo = (PMSAppInfo) a.d(cursor);
                            mo4.a(cursor);
                            return pMSAppInfo;
                        } catch (Exception e) {
                            e = e;
                            c.g("PMSDBImpl", "#queryAppInfo error", e);
                            mo4.a(cursor);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        mo4.a(cursor);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                mo4.a(cursor);
                throw th;
            }
            mo4.a(cursor);
            return null;
        }
        return (PMSAppInfo) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            jo4 jo4Var = c;
            jo4Var.i("PMSDBImpl", "#clearSubPackage appId=" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                AppRuntime.getAppContext().getContentResolver().delete(this.b.b(hk4.class), "app_id=?", new String[]{str});
            } catch (Exception e) {
                c.g("PMSDBImpl", "#clearSubPackage error", e);
            }
        }
    }

    @Override // com.baidu.tieba.ej4
    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            jo4 jo4Var = c;
            jo4Var.i("PMSDBImpl", "#deleteSwanApp appId=" + str);
            try {
            } catch (Exception e) {
                c.g("PMSDBImpl", "#deleteSwanApp error", e);
            }
            if (AppRuntime.getAppContext().getContentResolver().delete(this.b.b(PMSAppInfo.class), "app_id =? ", new String[]{str}) <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ej4
    @WorkerThread
    public int j(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            Cursor cursor = null;
            int i = -1;
            try {
                try {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(hk4.class), new String[]{"version_code"}, "app_id=?", new String[]{str}, "version_code DESC limit 1");
                    if (cursor != null && cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                    }
                } catch (Exception e) {
                    c.g("PMSDBImpl", "#getNewestSubPkgVersion fail", e);
                }
                return i;
            } finally {
                mo4.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.ej4
    public boolean l(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pMSAppInfo)) == null) {
            try {
                jo4 jo4Var = c;
                jo4Var.i("PMSDBImpl", "#insertOrUpdateSwanApp appId=" + pMSAppInfo.appId);
                Class<?> cls = pMSAppInfo.getClass();
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.b.b(cls), this.b.a(cls).c(pMSAppInfo));
                if (insert != null) {
                    if (ContentUris.parseId(insert) > 0) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                c.g("PMSDBImpl", "#insertOrUpdateSwanApp error", e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // com.baidu.tieba.ej4
    @Nullable
    public jk4 t(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            ?? r1 = 0;
            try {
                try {
                    hj4 a = this.b.a(jk4.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(jk4.class), null, "lib_name =? ", new String[]{str}, "version_code DESC");
                    if (cursor != null) {
                        try {
                            jk4 jk4Var = (jk4) a.d(cursor);
                            mo4.a(cursor);
                            return jk4Var;
                        } catch (Exception e) {
                            e = e;
                            c.g("PMSDBImpl", "#querySoLib error", e);
                            mo4.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                    mo4.a(r1);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                mo4.a(r1);
                throw th;
            }
            mo4.a(cursor);
            return null;
        }
        return (jk4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public List<ik4> w(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            Cursor cursor2 = null;
            try {
                hj4 a = this.b.a(ik4.class);
                Uri.Builder buildUpon = this.b.b(ik4.class).buildUpon();
                buildUpon.appendQueryParameter("rawQuery", "");
                cursor = AppRuntime.getAppContext().getContentResolver().query(buildUpon.build(), null, str, null, null);
                if (cursor != null) {
                    try {
                        try {
                            List<ik4> e = a.e(cursor);
                            mo4.a(cursor);
                            return e;
                        } catch (Exception e2) {
                            e = e2;
                            c.g("PMSDBImpl", "#rawQueryPlugins error", e);
                            mo4.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        mo4.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                mo4.a(cursor2);
                throw th;
            }
            mo4.a(cursor);
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final <T> List<T> C(Class<T> cls, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cls, str, strArr, str2)) == null) {
            Cursor cursor2 = null;
            try {
                hj4<T> a = this.b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        try {
                            List<T> e = a.e(cursor);
                            mo4.a(cursor);
                            return e;
                        } catch (Exception e2) {
                            e = e2;
                            c.g("PMSDBImpl", "#queryAppInfoList error", e);
                            mo4.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        mo4.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                mo4.a(cursor2);
                throw th;
            }
            mo4.a(cursor);
            return null;
        }
        return (List) invokeLLLL.objValue;
    }

    public final <T> List<T> E(Class<T> cls, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, cls, str, strArr, str2)) == null) {
            Cursor cursor2 = null;
            try {
                hj4<T> a = this.b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        try {
                            List<T> e = a.e(cursor);
                            mo4.a(cursor);
                            return e;
                        } catch (Exception e2) {
                            e = e2;
                            c.g("PMSDBImpl", "#queryPackageList error", e);
                            mo4.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        mo4.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                mo4.a(cursor2);
                throw th;
            }
            mo4.a(cursor);
            return null;
        }
        return (List) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final <T> T D(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, str)) == null) {
            ?? r0 = 0;
            try {
                try {
                    hj4<T> a = this.b.a(cls);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(cls), null, "bundle_id =? ", new String[]{str}, "version_code DESC");
                    if (cursor != null) {
                        try {
                            T d = a.d(cursor);
                            mo4.a(cursor);
                            return d;
                        } catch (Exception e) {
                            e = e;
                            c.g("PMSDBImpl", "#queryPackage error", e);
                            mo4.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r0 = cls;
                    mo4.a(r0);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                mo4.a(r0);
                throw th;
            }
            mo4.a(cursor);
            return null;
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            jo4 jo4Var = c;
            jo4Var.i("PMSDBImpl", "#clearSubPackage appId=" + str + " versionCode=" + str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    AppRuntime.getAppContext().getContentResolver().delete(this.b.b(hk4.class), "app_id=? AND version_code=?", new String[]{str, str2});
                } catch (Exception e) {
                    c.g("PMSDBImpl", "#clearSubPackage error", e);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ej4
    public <T extends fk4> boolean e(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cls, str)) == null) {
            try {
                jo4 jo4Var = c;
                jo4Var.i("PMSDBImpl", "#deletePkg bundleId=" + str);
            } catch (Exception e) {
                c.g("PMSDBImpl", "#deletePkg error", e);
            }
            if (AppRuntime.getAppContext().getContentResolver().delete(this.b.b(cls), "bundle_id =? ", new String[]{str}) <= 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0030 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // com.baidu.tieba.ej4
    public List<ik4> r(String str, String[] strArr) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, strArr)) == null) {
            ?? r1 = 0;
            try {
                try {
                    hj4 a = this.b.a(ik4.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(ik4.class), null, str, strArr, "update_time DESC");
                    if (cursor != null) {
                        try {
                            List<ik4> e = a.e(cursor);
                            mo4.a(cursor);
                            return e;
                        } catch (Exception e2) {
                            e = e2;
                            c.g("PMSDBImpl", "#queryPlugin error", e);
                            mo4.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                    mo4.a(r1);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                mo4.a(r1);
                throw th;
            }
            mo4.a(cursor);
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public List<ik4> F(String str, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Cursor cursor;
        List<ik4> e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            Cursor cursor2 = null;
            try {
                hj4 a = this.b.a(ik4.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.b.b(ik4.class), null, "bundle_id = ? AND version_code >= ? AND version_code <= ? ", new String[]{str, String.valueOf(j), String.valueOf(j2)}, "version_code DESC");
                if (cursor != null) {
                    try {
                        if (z) {
                            e = Collections.singletonList(a.d(cursor));
                        } else {
                            e = a.e(cursor);
                        }
                        mo4.a(cursor);
                        return e;
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        mo4.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            mo4.a(cursor);
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public boolean a(gk4 gk4Var, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, gk4Var, pMSAppInfo)) == null) {
            return b(gk4Var, null, null, null, pMSAppInfo);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.ej4
    public <T extends fk4> T o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, cls, str)) == null) {
            return (T) D(cls, str);
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public boolean b(gk4 gk4Var, List<hk4> list, ek4 ek4Var, ck4 ck4Var, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLLLL;
        ContentProviderResult[] applyBatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048583, this, gk4Var, list, ek4Var, ck4Var, pMSAppInfo)) == null) {
            c.i("PMSDBImpl", "#bulkInsert");
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (gk4Var != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.b.b(gk4.class)).withValues(this.b.a(gk4.class).c(gk4Var)).build());
            }
            if (list != null && !list.isEmpty()) {
                hj4 a = this.b.a(hk4.class);
                for (hk4 hk4Var : list) {
                    arrayList.add(ContentProviderOperation.newInsert(this.b.b(hk4.class)).withValues(a.c(hk4Var)).build());
                }
            }
            if (ek4Var != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.b.b(ek4.class)).withValues(this.b.a(ek4.class).c(ek4Var)).build());
            }
            if (ck4Var != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.b.b(ck4.class)).withValues(this.b.a(ck4.class).c(ck4Var)).build());
            }
            if (pMSAppInfo != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.b.b(PMSAppInfo.class)).withValues(this.b.a(PMSAppInfo.class).c(pMSAppInfo)).build());
            }
            try {
                for (ContentProviderResult contentProviderResult : AppRuntime.getAppContext().getContentResolver().applyBatch(yj4.c, arrayList)) {
                    if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                c.g("PMSDBImpl", "#bulkInsert error", e);
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ej4
    public boolean f(@NonNull ik4 ik4Var) {
        InterceptResult invokeL;
        Uri b;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ik4Var)) == null) {
            try {
                jo4 jo4Var = c;
                jo4Var.i("PMSDBImpl", "#deletePlugin bundleId=" + ik4Var.g + " versionCode=" + ik4Var.i);
                b = this.b.b(ik4Var.getClass());
                if (ik4Var.i >= 0) {
                    str = "bundle_id = ?  and version_code < ? ";
                    strArr = new String[]{ik4Var.g, String.valueOf(ik4Var.i)};
                } else {
                    str = "bundle_id = ? ";
                    strArr = new String[]{ik4Var.g};
                }
            } catch (Exception e) {
                c.g("PMSDBImpl", "#deletePlugin error", e);
            }
            if (AppRuntime.getAppContext().getContentResolver().delete(b, str, strArr) <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ej4
    public boolean g(List<ik4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                try {
                    Uri b = this.b.b(ik4.class);
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    boolean z = true;
                    for (ik4 ik4Var : list) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(" or ");
                        }
                        sb.append("( ");
                        sb.append("bundle_id");
                        sb.append(" = ? and ");
                        sb.append("version_code");
                        sb.append(" = ?");
                        sb.append(" )");
                        arrayList.add(ik4Var.g);
                        arrayList.add(String.valueOf(ik4Var.i));
                    }
                    if (AppRuntime.getAppContext().getContentResolver().delete(b, sb.toString(), (String[]) arrayList.toArray(new String[0])) > 0) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ej4
    public boolean x(@NonNull ik4 ik4Var) {
        InterceptResult invokeL;
        Uri b;
        ContentValues c2;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, ik4Var)) == null) {
            try {
                jo4 jo4Var = c;
                jo4Var.i("PMSDBImpl", "#deletePlugin bundleId=" + ik4Var.g + " versionCode=" + ik4Var.i);
                hj4 a = this.b.a(ik4Var.getClass());
                b = this.b.b(ik4Var.getClass());
                c2 = a.c(ik4Var);
                if (ik4Var.i >= 0) {
                    str = "bundle_id = ?  and version_code = ? ";
                    strArr = new String[]{ik4Var.g, String.valueOf(ik4Var.i)};
                } else {
                    str = "bundle_id = ?  and version_name = ? ";
                    strArr = new String[]{ik4Var.g, ik4Var.j};
                }
            } catch (Exception e) {
                c.g("PMSDBImpl", "#updatePlugin error", e);
            }
            if (AppRuntime.getAppContext().getContentResolver().update(b, c2, str, strArr) <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ej4
    public boolean y(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, pMSAppInfo)) == null) {
            try {
                jo4 jo4Var = c;
                jo4Var.i("PMSDBImpl", "#updateSwanApp appId=" + pMSAppInfo.appId);
            } catch (Exception e) {
                c.g("PMSDBImpl", "#updateSwanApp error", e);
            }
            if (AppRuntime.getAppContext().getContentResolver().update(this.b.b(pMSAppInfo.getClass()), this.b.a(pMSAppInfo.getClass()).c(pMSAppInfo), "app_id =? ", new String[]{pMSAppInfo.appId}) <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.ej4
    @NonNull
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<hk4> k(@NonNull String str, int i) {
        InterceptResult invokeLI;
        Cursor cursor;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, str, i)) == null) {
            Cursor cursor2 = null;
            r1 = null;
            r1 = null;
            List<hk4> list = null;
            try {
                if (i >= 0) {
                    str2 = "app_id=? and version_code" + RFC1522Codec.PREFIX;
                } else {
                    str2 = "app_id=? and version_code>?";
                }
                Uri b = this.b.b(hk4.class);
                hj4 a = this.b.a(hk4.class);
                Cursor query = AppRuntime.getAppContext().getContentResolver().query(b, null, str2, new String[]{str, String.valueOf(i)}, null);
                if (query != null && a != null) {
                    try {
                        list = a.e(query);
                    } catch (Exception e) {
                        cursor = query;
                        e = e;
                        try {
                            c.g("PMSDBImpl", "#getSubPackageByAppId fail", e);
                            mo4.a(cursor);
                            if (list != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            mo4.a(cursor2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        cursor2 = query;
                        th = th2;
                        mo4.a(cursor2);
                        throw th;
                    }
                }
                mo4.a(query);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
            if (list != null) {
                return Collections.emptyList();
            }
            return list;
        }
        return (List) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public <T extends fk4> boolean m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, t)) == null) {
            c.i("PMSDBImpl", "#insertPkg");
            return A(t);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ej4
    public PMSAppInfo u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            return B(str);
        }
        return (PMSAppInfo) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public boolean n(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, str2, str3)) == null) {
            boolean z = false;
            Cursor cursor = null;
            try {
                try {
                    Uri b = this.b.b(hk4.class);
                    hj4 a = this.b.a(hk4.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(b, null, "app_id=? AND version_code=? AND sub_pkg_name=?", new String[]{str, str2, str3}, null);
                    if (cursor != null) {
                        if (a.d(cursor) != null) {
                            z = true;
                        }
                        return z;
                    }
                } catch (Exception e) {
                    c.g("PMSDBImpl", "#isSubPackageExist error", e);
                }
                return false;
            } finally {
                mo4.a(cursor);
            }
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ej4
    public Map<String, gk4> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            HashMap hashMap = new HashMap();
            List<gk4> E = E(gk4.class, "state =? ", new String[]{"10"}, "version_code ASC");
            if (E != null && E.size() > 0) {
                for (gk4 gk4Var : E) {
                    if (gk4Var != null) {
                        hashMap.put(gk4Var.g, gk4Var);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public Map<String, PMSAppInfo> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            HashMap hashMap = new HashMap();
            List<PMSAppInfo> C = C(PMSAppInfo.class, null, null, null);
            if (C != null && C.size() > 0) {
                for (PMSAppInfo pMSAppInfo : C) {
                    if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                        hashMap.put(pMSAppInfo.appId, pMSAppInfo);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public ik4 q(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            List<ik4> F = F(str, j, j2, true);
            if (F != null && !F.isEmpty()) {
                return F.get(0);
            }
            return null;
        }
        return (ik4) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public List<ik4> s(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return F(str, j, j2, false);
        }
        return (List) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ej4
    public boolean z(String str, int i) {
        InterceptResult invokeLI;
        Uri b;
        ContentValues contentValues;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048606, this, str, i)) == null) {
            jo4 jo4Var = c;
            jo4Var.i("PMSDBImpl", "#updateSwanAppPendingErrCode appId=" + str + " errCode=" + i);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                b = this.b.b(PMSAppInfo.class);
                contentValues = new ContentValues();
                contentValues.put("pending_err_code", Integer.valueOf(i));
            } catch (Exception e) {
                c.g("PMSDBImpl", "#updateSwanAppPendingErrCode error", e);
            }
            if (AppRuntime.getAppContext().getContentResolver().update(b, contentValues, "app_id =? ", new String[]{str}) <= 0) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
