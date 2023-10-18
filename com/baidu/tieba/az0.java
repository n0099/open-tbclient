package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class az0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, cz0... cz0VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, cz0VarArr) == null) {
            int i = 0;
            for (cz0 cz0Var : cz0VarArr) {
                for (Column column : cz0Var.b().c()) {
                    zy0.e(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(cz0 cz0Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, cz0Var, cursor) == null) {
            zy0.f(cursor, cz0Var.b().c());
        }
    }
}
