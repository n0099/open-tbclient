package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, e21... e21VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, e21VarArr) == null) {
            int i = 0;
            for (e21 e21Var : e21VarArr) {
                for (Column column : e21Var.b().c()) {
                    b21.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(e21 e21Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, e21Var, cursor) == null) {
            b21.i(cursor, e21Var.b().c());
        }
    }
}
