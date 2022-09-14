package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.g01;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f01 implements g01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    public f01(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase, sQLiteDatabase2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = sQLiteDatabase;
        this.b = sQLiteDatabase2;
    }

    @Override // com.baidu.tieba.g01
    public g01.a a(n01 n01Var, e01... e01VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, n01Var, e01VarArr)) != null) {
            return (g01.a) invokeLL.objValue;
        }
        try {
            this.a.beginTransaction();
            i = update(n01Var, e01VarArr);
            r0 = i == 0 ? insert(n01Var) : 0L;
            this.a.setTransactionSuccessful();
        } catch (Exception unused) {
            i = 0;
        } catch (Throwable th) {
            try {
                this.a.endTransaction();
            } catch (Exception unused2) {
            }
            throw th;
        }
        try {
            this.a.endTransaction();
        } catch (Exception unused3) {
            return new g01.a(r0, i);
        }
    }

    public final Column[] b(n01 n01Var, e01... e01VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n01Var, e01VarArr)) == null) {
            if (e01VarArr.length > 0) {
                return k01.d(n01Var, e01VarArr);
            }
            return k01.d(n01Var, n01Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.g01
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    public final boolean c(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, columnArr)) == null) {
            for (Column column : columnArr) {
                if (column == null || !column.isAssignedValue) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int delete(String str, o01 o01Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, o01Var)) == null) ? this.a.delete(str, o01Var.l(), o01Var.e()) : invokeLL.intValue;
    }

    @Override // com.baidu.tieba.g01
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    public long insert(n01 n01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, n01Var)) == null) {
            m01 b = n01Var.b();
            String g = b.g();
            e01[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, n01Var.a());
            }
            Column column = k01.d(n01Var, f[0])[0];
            boolean n = k01.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + n01Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, n01Var.a());
            if (n) {
                int type = column.type();
                if (type == 2) {
                    ((IntegerColumn) column).setValue((int) insert);
                } else if (type == 3) {
                    ((LongColumn) column).setValue(insert);
                } else {
                    throw new IllegalStateException("Invalid key type. Must be Long or Integer.");
                }
            }
            return insert;
        }
        return invokeL.longValue;
    }

    public boolean query(n01 n01Var, o01 o01Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, n01Var, o01Var)) == null) {
            t01 t01Var = new t01(this.b.rawQuery("SELECT " + j01.d(n01Var.b().d()) + " FROM " + n01Var.b().g() + o01Var.k(), o01Var.e()));
            boolean moveToFirst = t01Var.moveToFirst();
            if (moveToFirst) {
                l01.a(t01Var, n01Var);
            }
            t01Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.g01
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    @Override // com.baidu.tieba.g01
    public int update(n01 n01Var, e01... e01VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, n01Var, e01VarArr)) == null) {
            String g = n01Var.b().g();
            o01 j = o01.j(b(n01Var, e01VarArr));
            return this.a.update(g, n01Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.g01
    public int delete(n01 n01Var, e01... e01VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, n01Var, e01VarArr)) == null) {
            String g = n01Var.b().g();
            Column[] b = b(n01Var, e01VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, o01.j(b));
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f01(SQLiteDatabase sQLiteDatabase) {
        this(sQLiteDatabase, sQLiteDatabase);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((SQLiteDatabase) objArr2[0], (SQLiteDatabase) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int update(Class<? extends n01> cls, o01 o01Var, e01[] e01VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, o01Var, e01VarArr, objArr)) == null) {
            if (e01VarArr.length != 0 && objArr.length == e01VarArr.length) {
                return update(h01.b(cls).g(), k01.c(e01VarArr, objArr), o01Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public boolean query(n01 n01Var, e01... e01VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, n01Var, e01VarArr)) == null) ? query(n01Var, o01.j(b(n01Var, e01VarArr))) : invokeLL.booleanValue;
    }

    public Cursor query(String str, e01[] e01VarArr, o01 o01Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, e01VarArr, o01Var)) == null) {
            return new t01(this.b.rawQuery("SELECT " + j01.d(e01VarArr) + " FROM " + str + o01Var.k(), o01Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public int update(n01 n01Var, o01 o01Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, n01Var, o01Var)) == null) ? update(n01Var.b().g(), n01Var.a(), o01Var) : invokeLL.intValue;
    }

    public int update(String str, ContentValues contentValues, o01 o01Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, o01Var)) == null) {
            return this.a.update(str, contentValues, o01Var != null ? o01Var.l() : null, o01Var != null ? o01Var.e() : null);
        }
        return invokeLLL.intValue;
    }

    @Override // com.baidu.tieba.g01
    public Cursor query(s01 s01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, s01Var)) == null) ? new t01(this.b.rawQuery(s01Var.f(), s01Var.b())) : (Cursor) invokeL.objValue;
    }

    public int update(String str, Column[] columnArr, o01 o01Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, o01Var)) == null) ? update(str, k01.e(columnArr), o01Var) : invokeLLL.intValue;
    }

    public long insert(String str, String[] strArr, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, strArr, objArr)) == null) {
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < strArr.length; i++) {
                contentValues.put(strArr[i], String.valueOf(objArr[i]));
            }
            return this.a.insert(str, null, contentValues);
        }
        return invokeLLL.longValue;
    }
}
