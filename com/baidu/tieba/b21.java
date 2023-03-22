package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, d21... d21VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, d21VarArr) == null) {
            int i = 0;
            for (d21 d21Var : d21VarArr) {
                for (Column column : d21Var.b().c()) {
                    a21.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(d21 d21Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, d21Var, cursor) == null) {
            a21.i(cursor, d21Var.b().c());
        }
    }
}
