package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.i41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h41 implements i41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h41(SQLiteDatabase sQLiteDatabase) {
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

    public h41(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.i41
    public i41.a a(p41 p41Var, g41... g41VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, p41Var, g41VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(p41Var, g41VarArr);
                if (i == 0) {
                    j = insert(p41Var);
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
                return new i41.a(j, i);
            }
        } else {
            return (i41.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.i41
    public int delete(p41 p41Var, g41... g41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, p41Var, g41VarArr)) == null) {
            String g = p41Var.b().g();
            Column[] c = c(p41Var, g41VarArr);
            int length = c.length;
            for (int i = 0; i < length; i++) {
                if (!d(c[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, q41.k(c));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.i41
    public int update(p41 p41Var, g41... g41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, p41Var, g41VarArr)) == null) {
            String g = p41Var.b().g();
            q41 k = q41.k(c(p41Var, g41VarArr));
            return this.a.update(g, p41Var.a(), k.m(), k.e());
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.i41
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.i41
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.i41
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    public final Column[] c(p41 p41Var, g41... g41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, p41Var, g41VarArr)) == null) {
            if (g41VarArr.length > 0) {
                return m41.d(p41Var, g41VarArr);
            }
            return m41.d(p41Var, p41Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, q41 q41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, q41Var)) == null) {
            return this.a.delete(str, q41Var.m(), q41Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(p41 p41Var, g41... g41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, p41Var, g41VarArr)) == null) {
            return query(p41Var, q41.k(c(p41Var, g41VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(p41 p41Var, q41 q41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, p41Var, q41Var)) == null) {
            return update(p41Var.b().g(), p41Var.a(), q41Var);
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

    @Override // com.baidu.tieba.i41
    public Cursor query(u41 u41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, u41Var)) == null) {
            return new v41(this.b.rawQuery(u41Var.g(), u41Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(p41 p41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, p41Var)) == null) {
            o41 b = p41Var.b();
            String g = b.g();
            g41[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, p41Var.a());
            }
            Column column = m41.d(p41Var, f[0])[0];
            boolean n = m41.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + p41Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, p41Var.a());
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

    public int update(String str, ContentValues contentValues, q41 q41Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, q41Var)) == null) {
            String[] strArr = null;
            if (q41Var != null) {
                str2 = q41Var.m();
            } else {
                str2 = null;
            }
            if (q41Var != null) {
                strArr = q41Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, g41[] g41VarArr, q41 q41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, g41VarArr, q41Var)) == null) {
            return new v41(this.b.rawQuery("SELECT " + l41.d(g41VarArr) + " FROM " + str + q41Var.l(), q41Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(p41 p41Var, q41 q41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, p41Var, q41Var)) == null) {
            v41 v41Var = new v41(this.b.rawQuery("SELECT " + l41.d(p41Var.b().d()) + " FROM " + p41Var.b().g() + q41Var.l(), q41Var.e()));
            boolean moveToFirst = v41Var.moveToFirst();
            if (moveToFirst) {
                n41.a(v41Var, p41Var);
            }
            v41Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends p41> cls, q41 q41Var, g41[] g41VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, q41Var, g41VarArr, objArr)) == null) {
            if (g41VarArr.length != 0 && objArr.length == g41VarArr.length) {
                return update(j41.b(cls).g(), m41.c(g41VarArr, objArr), q41Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, q41 q41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, q41Var)) == null) {
            return update(str, m41.e(columnArr), q41Var);
        }
        return invokeLLL.intValue;
    }
}
