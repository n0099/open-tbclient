package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, g41... g41VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, g41VarArr) == null) {
            int i = 0;
            for (g41 g41Var : g41VarArr) {
                for (Column column : g41Var.b().c()) {
                    d41.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(g41 g41Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, g41Var, cursor) == null) {
            d41.i(cursor, g41Var.b().c());
        }
    }
}
