package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.c41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b41 implements c41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b41(SQLiteDatabase sQLiteDatabase) {
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

    public b41(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.c41
    public c41.a a(j41 j41Var, a41... a41VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, j41Var, a41VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(j41Var, a41VarArr);
                if (i == 0) {
                    j = insert(j41Var);
                }
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
                return new c41.a(j, i);
            }
        } else {
            return (c41.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.c41
    public int delete(j41 j41Var, a41... a41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, j41Var, a41VarArr)) == null) {
            String g = j41Var.b().g();
            Column[] c = c(j41Var, a41VarArr);
            int length = c.length;
            for (int i = 0; i < length; i++) {
                if (!d(c[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, k41.j(c));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.c41
    public int update(j41 j41Var, a41... a41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, j41Var, a41VarArr)) == null) {
            String g = j41Var.b().g();
            k41 j = k41.j(c(j41Var, a41VarArr));
            return this.a.update(g, j41Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.c41
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.c41
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.c41
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    public final Column[] c(j41 j41Var, a41... a41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, j41Var, a41VarArr)) == null) {
            if (a41VarArr.length > 0) {
                return g41.d(j41Var, a41VarArr);
            }
            return g41.d(j41Var, j41Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, k41 k41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, k41Var)) == null) {
            return this.a.delete(str, k41Var.l(), k41Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(j41 j41Var, a41... a41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, j41Var, a41VarArr)) == null) {
            return query(j41Var, k41.j(c(j41Var, a41VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(j41 j41Var, k41 k41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, j41Var, k41Var)) == null) {
            return update(j41Var.b().g(), j41Var.a(), k41Var);
        }
        return invokeLL.intValue;
    }

    public final boolean d(Column... columnArr) {
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

    @Override // com.baidu.tieba.c41
    public Cursor query(o41 o41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, o41Var)) == null) {
            return new p41(this.b.rawQuery(o41Var.f(), o41Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(j41 j41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, j41Var)) == null) {
            i41 b = j41Var.b();
            String g = b.g();
            a41[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, j41Var.a());
            }
            Column column = g41.d(j41Var, f[0])[0];
            boolean n = g41.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + j41Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, j41Var.a());
            if (n) {
                int type = column.type();
                if (type != 2) {
                    if (type == 3) {
                        ((LongColumn) column).setValue(insert);
                    } else {
                        throw new IllegalStateException("Invalid key type. Must be Long or Integer.");
                    }
                } else {
                    ((IntegerColumn) column).setValue((int) insert);
                }
            }
            return insert;
        }
        return invokeL.longValue;
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

    public int update(String str, ContentValues contentValues, k41 k41Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, k41Var)) == null) {
            String[] strArr = null;
            if (k41Var != null) {
                str2 = k41Var.l();
            } else {
                str2 = null;
            }
            if (k41Var != null) {
                strArr = k41Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, a41[] a41VarArr, k41 k41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, a41VarArr, k41Var)) == null) {
            return new p41(this.b.rawQuery("SELECT " + f41.d(a41VarArr) + " FROM " + str + k41Var.k(), k41Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(j41 j41Var, k41 k41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, j41Var, k41Var)) == null) {
            p41 p41Var = new p41(this.b.rawQuery("SELECT " + f41.d(j41Var.b().d()) + " FROM " + j41Var.b().g() + k41Var.k(), k41Var.e()));
            boolean moveToFirst = p41Var.moveToFirst();
            if (moveToFirst) {
                h41.a(p41Var, j41Var);
            }
            p41Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends j41> cls, k41 k41Var, a41[] a41VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, k41Var, a41VarArr, objArr)) == null) {
            if (a41VarArr.length != 0 && objArr.length == a41VarArr.length) {
                return update(d41.b(cls).g(), g41.c(a41VarArr, objArr), k41Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, k41 k41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, k41Var)) == null) {
            return update(str, g41.e(columnArr), k41Var);
        }
        return invokeLLL.intValue;
    }
}
