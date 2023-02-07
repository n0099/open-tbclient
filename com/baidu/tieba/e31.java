package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class e31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, g31... g31VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, g31VarArr) == null) {
            int i = 0;
            for (g31 g31Var : g31VarArr) {
                for (Column column : g31Var.b().c()) {
                    d31.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(g31 g31Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, g31Var, cursor) == null) {
            d31.i(cursor, g31Var.b().c());
        }
    }
}
