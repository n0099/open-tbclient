package com.baidu.tieba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public final class ih9 {
    public static /* synthetic */ Interceptable $ic;
    public static ih9 c;
    public static SQLiteOpenHelper d;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger a;
    public SQLiteDatabase b;

    public ih9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new AtomicInteger();
    }

    public static synchronized ih9 a() {
        InterceptResult invokeV;
        ih9 ih9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (ih9.class) {
                if (c == null) {
                    b(dh9.h().getContext());
                }
                ih9Var = c;
            }
            return ih9Var;
        }
        return (ih9) invokeV.objValue;
    }

    public final synchronized SQLiteDatabase c() {
        InterceptResult invokeV;
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.a.incrementAndGet() == 1) {
                    ei9.a("***************新建立了 一个数据库的实例****************");
                    this.b = d.getWritableDatabase();
                }
                sQLiteDatabase = this.b;
            }
            return sQLiteDatabase;
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    public static synchronized void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            synchronized (ih9.class) {
                if (c == null) {
                    c = new ih9();
                    d = new gh9(context);
                }
            }
        }
    }
}
