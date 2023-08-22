package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.f41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e41 implements f41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e41(SQLiteDatabase sQLiteDatabase) {
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

    public e41(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.f41
    public f41.a a(m41 m41Var, d41... d41VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, m41Var, d41VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(m41Var, d41VarArr);
                if (i == 0) {
                    j = insert(m41Var);
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
                return new f41.a(j, i);
            }
        } else {
            return (f41.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.f41
    public int delete(m41 m41Var, d41... d41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, m41Var, d41VarArr)) == null) {
            String g = m41Var.b().g();
            Column[] c = c(m41Var, d41VarArr);
            int length = c.length;
            for (int i = 0; i < length; i++) {
                if (!d(c[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, n41.k(c));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.f41
    public int update(m41 m41Var, d41... d41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, m41Var, d41VarArr)) == null) {
            String g = m41Var.b().g();
            n41 k = n41.k(c(m41Var, d41VarArr));
            return this.a.update(g, m41Var.a(), k.m(), k.e());
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.f41
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.f41
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.f41
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    public final Column[] c(m41 m41Var, d41... d41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, m41Var, d41VarArr)) == null) {
            if (d41VarArr.length > 0) {
                return j41.d(m41Var, d41VarArr);
            }
            return j41.d(m41Var, m41Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, n41 n41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, n41Var)) == null) {
            return this.a.delete(str, n41Var.m(), n41Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(m41 m41Var, d41... d41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, m41Var, d41VarArr)) == null) {
            return query(m41Var, n41.k(c(m41Var, d41VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(m41 m41Var, n41 n41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, m41Var, n41Var)) == null) {
            return update(m41Var.b().g(), m41Var.a(), n41Var);
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

    @Override // com.baidu.tieba.f41
    public Cursor query(r41 r41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, r41Var)) == null) {
            return new s41(this.b.rawQuery(r41Var.g(), r41Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(m41 m41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, m41Var)) == null) {
            l41 b = m41Var.b();
            String g = b.g();
            d41[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, m41Var.a());
            }
            Column column = j41.d(m41Var, f[0])[0];
            boolean n = j41.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + m41Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, m41Var.a());
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

    public int update(String str, ContentValues contentValues, n41 n41Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, n41Var)) == null) {
            String[] strArr = null;
            if (n41Var != null) {
                str2 = n41Var.m();
            } else {
                str2 = null;
            }
            if (n41Var != null) {
                strArr = n41Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, d41[] d41VarArr, n41 n41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, d41VarArr, n41Var)) == null) {
            return new s41(this.b.rawQuery("SELECT " + i41.d(d41VarArr) + " FROM " + str + n41Var.l(), n41Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(m41 m41Var, n41 n41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, m41Var, n41Var)) == null) {
            s41 s41Var = new s41(this.b.rawQuery("SELECT " + i41.d(m41Var.b().d()) + " FROM " + m41Var.b().g() + n41Var.l(), n41Var.e()));
            boolean moveToFirst = s41Var.moveToFirst();
            if (moveToFirst) {
                k41.a(s41Var, m41Var);
            }
            s41Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends m41> cls, n41 n41Var, d41[] d41VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, n41Var, d41VarArr, objArr)) == null) {
            if (d41VarArr.length != 0 && objArr.length == d41VarArr.length) {
                return update(g41.b(cls).g(), j41.c(d41VarArr, objArr), n41Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, n41 n41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, n41Var)) == null) {
            return update(str, j41.e(columnArr), n41Var);
        }
        return invokeLLL.intValue;
    }
}
