package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, k41... k41VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, k41VarArr) == null) {
            int i = 0;
            for (k41 k41Var : k41VarArr) {
                for (Column column : k41Var.b().c()) {
                    h41.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(k41 k41Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, k41Var, cursor) == null) {
            h41.i(cursor, k41Var.b().c());
        }
    }
}
