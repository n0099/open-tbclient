package com.baidu.tieba;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b82 {
    public static /* synthetic */ Interceptable $ic;
    public static Uri a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS user_behavior(_id INTEGER PRIMARY KEY AUTOINCREMENT,appKey varchar(100) NOT NULL,launch_type INT NOT NULL,source varchar(100),ext TEXT,time BIGINT);");
            } catch (Exception e) {
                ay1.d("SwanLaunchBehaviorTable", "createTable", e);
            }
        }
    }

    @NonNull
    public static synchronized Uri b() {
        InterceptResult invokeV;
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (b82.class) {
                if (a == null) {
                    a = z72.c.buildUpon().appendPath("user_behavior").build();
                }
                uri = a;
            }
            return uri;
        }
        return (Uri) invokeV.objValue;
    }
}
