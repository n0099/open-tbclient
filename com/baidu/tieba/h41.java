package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, j41... j41VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, j41VarArr) == null) {
            int i = 0;
            for (j41 j41Var : j41VarArr) {
                for (Column column : j41Var.b().c()) {
                    g41.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(j41 j41Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, j41Var, cursor) == null) {
            g41.i(cursor, j41Var.b().c());
        }
    }
}
