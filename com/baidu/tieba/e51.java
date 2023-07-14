package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, g51... g51VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, g51VarArr) == null) {
            int i = 0;
            for (g51 g51Var : g51VarArr) {
                for (Column column : g51Var.b().c()) {
                    d51.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(g51 g51Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, g51Var, cursor) == null) {
            d51.i(cursor, g51Var.b().c());
        }
    }
}
