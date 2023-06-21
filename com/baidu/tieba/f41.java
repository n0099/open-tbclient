package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, h41... h41VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, h41VarArr) == null) {
            int i = 0;
            for (h41 h41Var : h41VarArr) {
                for (Column column : h41Var.b().c()) {
                    e41.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(h41 h41Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, h41Var, cursor) == null) {
            e41.i(cursor, h41Var.b().c());
        }
    }
}
