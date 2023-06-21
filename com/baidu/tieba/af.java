package com.baidu.tieba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class af {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s9 a;

    public af(Context context, s9 s9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, s9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = s9Var;
    }

    public void a(se seVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, seVar) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("nameSpace", seVar.a);
                contentValues.put("tableName", seVar.b);
                contentValues.put("maxSize", Integer.valueOf(seVar.c));
                contentValues.put("cacheVersion", Integer.valueOf(seVar.e));
                contentValues.put("cacheType", seVar.d);
                contentValues.put("lastActiveTime", Long.valueOf(seVar.f));
                SQLiteDatabase f = this.a.f();
                if (f != null && f.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{seVar.a}) == 0) {
                    f.insert("cache_meta_info", null, contentValues);
                }
            } catch (Throwable th) {
                this.a.i(th, "addOrUpdate");
            }
        }
    }

    public se b(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                cursor = this.a.f().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    se seVar = new se();
                    seVar.a = cursor.getString(0);
                    seVar.b = cursor.getString(1);
                    seVar.c = cursor.getInt(2);
                    seVar.d = cursor.getString(3);
                    seVar.e = cursor.getInt(4);
                    seVar.f = cursor.getLong(5);
                    return seVar;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    this.a.i(th, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE);
                    return null;
                } finally {
                    tg.a(cursor);
                }
            }
            return null;
        }
        return (se) invokeL.objValue;
    }

    public int delete(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                if (b(str) == null) {
                    return 0;
                }
                return this.a.f().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
            } catch (Throwable th) {
                this.a.i(th, "delete");
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
