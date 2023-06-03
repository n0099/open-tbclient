package com.baidu.tieba;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "CREATE TABLE IF NOT EXISTS ai_apps_history (_id INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT NOT NULL UNIQUE,app_from TEXT,visit_time INTEGER DEFAULT 0,app_name TEXT,app_icon TEXT,frame_type INTEGER,sync_state INTEGER,pay_protected INTEGER,app_type TEXT,app_key TEXT,version_code TEXT);" : (String) invokeV.objValue;
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL(c());
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS delete_old_swan_history");
                sQLiteDatabase.execSQL("CREATE TRIGGER delete_old_swan_history AFTER INSERT ON ai_apps_history WHEN (select count(*) from ai_apps_history)>200 BEGIN  DELETE FROM ai_apps_history WHERE _id IN (SELECT _id FROM  ai_apps_history ORDER BY visit_time LIMIT (SELECT count(*) -200 FROM ai_apps_history)); END;");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
