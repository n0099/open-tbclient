package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, h21... h21VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, h21VarArr) == null) {
            int i = 0;
            for (h21 h21Var : h21VarArr) {
                for (Column column : h21Var.b().c()) {
                    e21.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(h21 h21Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, h21Var, cursor) == null) {
            e21.i(cursor, h21Var.b().c());
        }
    }
}
