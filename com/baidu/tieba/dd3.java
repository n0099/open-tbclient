package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes3.dex */
public class dd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public cd3 a;
    public boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947700662, "Lcom/baidu/tieba/dd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947700662, "Lcom/baidu/tieba/dd3;");
                return;
            }
        }
        c = ok1.a;
    }

    public dd3() {
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
        this.a = null;
    }

    public synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                f();
            }
        }
    }

    public synchronized void a(zc3 zc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zc3Var) == null) {
            synchronized (this) {
                if (zc3Var != null) {
                    if (!TextUtils.isEmpty(zc3Var.a) && !TextUtils.isEmpty(zc3Var.c) && !TextUtils.isEmpty(zc3Var.b)) {
                        if (zc3Var.e == -1) {
                            return;
                        }
                        SQLiteDatabase f = f();
                        if (f == null) {
                            return;
                        }
                        if (c) {
                            Log.d("SwanCookieDatabase", "addCookie cookie=" + zc3Var.toString());
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("domain", zc3Var.a);
                        contentValues.put("path", zc3Var.b);
                        contentValues.put("name", zc3Var.c);
                        contentValues.put("value", zc3Var.d);
                        contentValues.put("expires", Long.valueOf(zc3Var.e));
                        contentValues.put(ClientCookie.SECURE_ATTR, Boolean.valueOf(zc3Var.f));
                        f.insert("cookies", null, contentValues);
                    }
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                SQLiteDatabase f = f();
                if (f == null) {
                    return;
                }
                if (c) {
                    Log.d("SwanCookieDatabase", "clearExpiredCookies");
                }
                f.delete("cookies", "expires <= ?", new String[]{Long.toString(System.currentTimeMillis())});
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return;
                }
                try {
                    if (c) {
                        Log.d("SwanCookieDatabase", "close");
                    }
                    this.a.close();
                    this.a = null;
                    this.b = true;
                } catch (Exception e) {
                    e12.k("SwanCookieDatabase", "close fail:" + Log.getStackTraceString(e));
                }
            }
        }
    }

    public synchronized void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                SQLiteDatabase f = f();
                if (f == null) {
                    return;
                }
                if (c) {
                    Log.d("SwanCookieDatabase", "deleteCookies domain=" + str + ";path=" + str2 + ";name=" + str3);
                }
                f.delete("cookies", "(domain == ?) AND (path == ?) AND (name == ?)", new String[]{str, str2, str3});
            }
        }
    }

    public synchronized ArrayList<zc3> e(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (c) {
                    Log.d("SwanCookieDatabase", "getCookiesForDomain baseDomain=" + str);
                }
                ArrayList<zc3> arrayList = new ArrayList<>();
                if (TextUtils.isEmpty(str)) {
                    return arrayList;
                }
                SQLiteDatabase f = f();
                if (f == null) {
                    return arrayList;
                }
                Cursor query = f.query("cookies", new String[]{"_id", "domain", "path", "name", "value", "expires", ClientCookie.SECURE_ATTR}, "(domain GLOB '*' || ?)", new String[]{str}, null, null, null);
                if (query == null) {
                    return arrayList;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (query.moveToFirst()) {
                    int columnIndex = query.getColumnIndex("domain");
                    int columnIndex2 = query.getColumnIndex("path");
                    int columnIndex3 = query.getColumnIndex("name");
                    int columnIndex4 = query.getColumnIndex("value");
                    int columnIndex5 = query.getColumnIndex("expires");
                    int columnIndex6 = query.getColumnIndex(ClientCookie.SECURE_ATTR);
                    do {
                        zc3 zc3Var = new zc3();
                        zc3Var.a = query.getString(columnIndex);
                        zc3Var.b = query.getString(columnIndex2);
                        zc3Var.c = query.getString(columnIndex3);
                        zc3Var.d = query.getString(columnIndex4);
                        if (query.isNull(columnIndex5)) {
                            zc3Var.e = -1L;
                        } else {
                            zc3Var.e = query.getLong(columnIndex5);
                        }
                        if (query.getShort(columnIndex6) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zc3Var.f = z;
                        zc3Var.i = 1;
                        if (zc3Var.e > currentTimeMillis) {
                            arrayList.add(zc3Var);
                            if (c) {
                                Log.d("SwanCookieDatabase", "getCookiesForDomain cookie=" + zc3Var.toString());
                            }
                        }
                    } while (query.moveToNext());
                    gs2.a(query);
                    return arrayList;
                }
                gs2.a(query);
                return arrayList;
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    public final SQLiteDatabase f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b) {
                return null;
            }
            cd3 cd3Var = this.a;
            if (cd3Var != null) {
                return cd3Var.getWritableDatabase();
            }
            String appId = d43.K().getAppId();
            if (!d43.K().E()) {
                e12.k("SwanCookieDatabase", "getSQLiteDatabase currentAppId =" + appId);
                return null;
            }
            String t = mb3.t(d43.K().q());
            e12.k("SwanCookieDatabase", "initDbHelper name =" + t);
            cd3 cd3Var2 = new cd3(ln2.c(), t);
            this.a = cd3Var2;
            return cd3Var2.getWritableDatabase();
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    public synchronized void g(Runnable runnable) {
        String str;
        String stackTraceString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, runnable) == null) {
            synchronized (this) {
                SQLiteDatabase f = f();
                if (f == null) {
                    return;
                }
                try {
                    f.beginTransaction();
                    runnable.run();
                    f.setTransactionSuccessful();
                    try {
                        f.endTransaction();
                    } catch (Exception e) {
                        str = "SwanCookieDatabase";
                        stackTraceString = Log.getStackTraceString(e);
                        e12.k(str, stackTraceString);
                    }
                } catch (Exception e2) {
                    e12.k("SwanCookieDatabase", Log.getStackTraceString(e2));
                    try {
                        f.endTransaction();
                    } catch (Exception e3) {
                        str = "SwanCookieDatabase";
                        stackTraceString = Log.getStackTraceString(e3);
                        e12.k(str, stackTraceString);
                    }
                }
            }
        }
    }
}
