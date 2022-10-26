package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class aa7 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static volatile SQLiteDatabase b;
    public static HashMap c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947608530, "Lcom/baidu/tieba/aa7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947608530, "Lcom/baidu/tieba/aa7;");
                return;
            }
        }
        c = new HashMap();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            try {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        ba7.d().f();
                        Iterator it = b().iterator();
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            if (str2 != null) {
                                if (str2.equals("tb_message_center")) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("is_hidden", (Integer) 1);
                                    ba7.d().update("tb_message_center", contentValues, null, null);
                                } else if (!str2.equals("tb_new_friends")) {
                                    ba7.d().delete(str2, null, null);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
                    e.printStackTrace();
                }
            } finally {
                ba7.d().b();
            }
        }
    }

    public static LinkedList b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            SQLiteDatabase c2 = c();
            LinkedList linkedList = new LinkedList();
            Cursor cursor = null;
            try {
                if (c2 != null) {
                    try {
                        cursor = c2.rawQuery("select * from sqlite_master where type='table'", null);
                        if (cursor != null) {
                            cursor.moveToFirst();
                            while (cursor.moveToNext()) {
                                linkedList.add(cursor.getString(cursor.getColumnIndex("name")));
                            }
                        }
                    } catch (Exception e) {
                        TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.getAllTables", new Object[0]);
                        e.printStackTrace();
                    }
                }
                return linkedList;
            } finally {
                gj.a(cursor);
            }
        }
        return (LinkedList) invokeV.objValue;
    }

    public static synchronized SQLiteDatabase c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (aa7.class) {
                try {
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
                }
                if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return null;
                }
                String str = TbadkCoreApplication.getCurrentAccount() + ".db";
                if (c.containsKey(str)) {
                    return (SQLiteDatabase) c.get(str);
                }
                if (b != null && str.equals(a) && b.isOpen()) {
                    return b;
                }
                if (b != null) {
                    gj.b(b);
                }
                z97 z97Var = new z97(TbadkCoreApplication.getInst().getApp(), str);
                a = str;
                b = z97Var.getWritableDatabase();
                return b;
            }
        }
        return (SQLiteDatabase) invokeV.objValue;
    }
}
