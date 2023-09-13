package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.j41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i41 implements j41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i41(SQLiteDatabase sQLiteDatabase) {
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

    public i41(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.j41
    public j41.a a(q41 q41Var, h41... h41VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, q41Var, h41VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(q41Var, h41VarArr);
                if (i == 0) {
                    j = insert(q41Var);
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
                return new j41.a(j, i);
            }
        } else {
            return (j41.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.j41
    public int delete(q41 q41Var, h41... h41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, q41Var, h41VarArr)) == null) {
            String g = q41Var.b().g();
            Column[] c = c(q41Var, h41VarArr);
            int length = c.length;
            for (int i = 0; i < length; i++) {
                if (!d(c[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, r41.k(c));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.j41
    public int update(q41 q41Var, h41... h41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, q41Var, h41VarArr)) == null) {
            String g = q41Var.b().g();
            r41 k = r41.k(c(q41Var, h41VarArr));
            return this.a.update(g, q41Var.a(), k.m(), k.e());
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.j41
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.j41
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.j41
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    public final Column[] c(q41 q41Var, h41... h41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, q41Var, h41VarArr)) == null) {
            if (h41VarArr.length > 0) {
                return n41.d(q41Var, h41VarArr);
            }
            return n41.d(q41Var, q41Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, r41 r41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, r41Var)) == null) {
            return this.a.delete(str, r41Var.m(), r41Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(q41 q41Var, h41... h41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, q41Var, h41VarArr)) == null) {
            return query(q41Var, r41.k(c(q41Var, h41VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(q41 q41Var, r41 r41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, q41Var, r41Var)) == null) {
            return update(q41Var.b().g(), q41Var.a(), r41Var);
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

    @Override // com.baidu.tieba.j41
    public Cursor query(v41 v41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, v41Var)) == null) {
            return new w41(this.b.rawQuery(v41Var.g(), v41Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(q41 q41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, q41Var)) == null) {
            p41 b = q41Var.b();
            String g = b.g();
            h41[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, q41Var.a());
            }
            Column column = n41.d(q41Var, f[0])[0];
            boolean n = n41.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + q41Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, q41Var.a());
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

    public int update(String str, ContentValues contentValues, r41 r41Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, r41Var)) == null) {
            String[] strArr = null;
            if (r41Var != null) {
                str2 = r41Var.m();
            } else {
                str2 = null;
            }
            if (r41Var != null) {
                strArr = r41Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, h41[] h41VarArr, r41 r41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, h41VarArr, r41Var)) == null) {
            return new w41(this.b.rawQuery("SELECT " + m41.d(h41VarArr) + " FROM " + str + r41Var.l(), r41Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(q41 q41Var, r41 r41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, q41Var, r41Var)) == null) {
            w41 w41Var = new w41(this.b.rawQuery("SELECT " + m41.d(q41Var.b().d()) + " FROM " + q41Var.b().g() + r41Var.l(), r41Var.e()));
            boolean moveToFirst = w41Var.moveToFirst();
            if (moveToFirst) {
                o41.a(w41Var, q41Var);
            }
            w41Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends q41> cls, r41 r41Var, h41[] h41VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, r41Var, h41VarArr, objArr)) == null) {
            if (h41VarArr.length != 0 && objArr.length == h41VarArr.length) {
                return update(k41.b(cls).g(), n41.c(h41VarArr, objArr), r41Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, r41 r41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, r41Var)) == null) {
            return update(str, n41.e(columnArr), r41Var);
        }
        return invokeLLL.intValue;
    }
}
