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
public class ed3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public dd3 a;
    public boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947730453, "Lcom/baidu/tieba/ed3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947730453, "Lcom/baidu/tieba/ed3;");
                return;
            }
        }
        c = pk1.a;
    }

    public ed3() {
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

    public synchronized void a(ad3 ad3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ad3Var) == null) {
            synchronized (this) {
                if (ad3Var != null) {
                    if (!TextUtils.isEmpty(ad3Var.a) && !TextUtils.isEmpty(ad3Var.c) && !TextUtils.isEmpty(ad3Var.b)) {
                        if (ad3Var.e == -1) {
                            return;
                        }
                        SQLiteDatabase f = f();
                        if (f == null) {
                            return;
                        }
                        if (c) {
                            Log.d("SwanCookieDatabase", "addCookie cookie=" + ad3Var.toString());
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("domain", ad3Var.a);
                        contentValues.put("path", ad3Var.b);
                        contentValues.put("name", ad3Var.c);
                        contentValues.put("value", ad3Var.d);
                        contentValues.put("expires", Long.valueOf(ad3Var.e));
                        contentValues.put(ClientCookie.SECURE_ATTR, Boolean.valueOf(ad3Var.f));
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
                    f12.k("SwanCookieDatabase", "close fail:" + Log.getStackTraceString(e));
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

    public synchronized ArrayList<ad3> e(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (c) {
                    Log.d("SwanCookieDatabase", "getCookiesForDomain baseDomain=" + str);
                }
                ArrayList<ad3> arrayList = new ArrayList<>();
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
                        ad3 ad3Var = new ad3();
                        ad3Var.a = query.getString(columnIndex);
                        ad3Var.b = query.getString(columnIndex2);
                        ad3Var.c = query.getString(columnIndex3);
                        ad3Var.d = query.getString(columnIndex4);
                        if (query.isNull(columnIndex5)) {
                            ad3Var.e = -1L;
                        } else {
                            ad3Var.e = query.getLong(columnIndex5);
                        }
                        if (query.getShort(columnIndex6) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ad3Var.f = z;
                        ad3Var.i = 1;
                        if (ad3Var.e > currentTimeMillis) {
                            arrayList.add(ad3Var);
                            if (c) {
                                Log.d("SwanCookieDatabase", "getCookiesForDomain cookie=" + ad3Var.toString());
                            }
                        }
                    } while (query.moveToNext());
                    hs2.a(query);
                    return arrayList;
                }
                hs2.a(query);
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
            dd3 dd3Var = this.a;
            if (dd3Var != null) {
                return dd3Var.getWritableDatabase();
            }
            String appId = e43.K().getAppId();
            if (!e43.K().E()) {
                f12.k("SwanCookieDatabase", "getSQLiteDatabase currentAppId =" + appId);
                return null;
            }
            String t = nb3.t(e43.K().q());
            f12.k("SwanCookieDatabase", "initDbHelper name =" + t);
            dd3 dd3Var2 = new dd3(mn2.c(), t);
            this.a = dd3Var2;
            return dd3Var2.getWritableDatabase();
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
                        f12.k(str, stackTraceString);
                    }
                } catch (Exception e2) {
                    f12.k("SwanCookieDatabase", Log.getStackTraceString(e2));
                    try {
                        f.endTransaction();
                    } catch (Exception e3) {
                        str = "SwanCookieDatabase";
                        stackTraceString = Log.getStackTraceString(e3);
                        f12.k(str, stackTraceString);
                    }
                }
            }
        }
    }
}
