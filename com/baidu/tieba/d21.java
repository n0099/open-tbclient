package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, f21... f21VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, f21VarArr) == null) {
            int i = 0;
            for (f21 f21Var : f21VarArr) {
                for (Column column : f21Var.b().c()) {
                    c21.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(f21 f21Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, f21Var, cursor) == null) {
            c21.i(cursor, f21Var.b().c());
        }
    }
}
