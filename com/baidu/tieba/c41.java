package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.d41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c41 implements d41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c41(SQLiteDatabase sQLiteDatabase) {
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

    public c41(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.d41
    public d41.a a(k41 k41Var, b41... b41VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k41Var, b41VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(k41Var, b41VarArr);
                if (i == 0) {
                    j = insert(k41Var);
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
                return new d41.a(j, i);
            }
        } else {
            return (d41.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.d41
    public int delete(k41 k41Var, b41... b41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k41Var, b41VarArr)) == null) {
            String g = k41Var.b().g();
            Column[] b = b(k41Var, b41VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, l41.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.d41
    public int update(k41 k41Var, b41... b41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, k41Var, b41VarArr)) == null) {
            String g = k41Var.b().g();
            l41 j = l41.j(b(k41Var, b41VarArr));
            return this.a.update(g, k41Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(k41 k41Var, b41... b41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k41Var, b41VarArr)) == null) {
            if (b41VarArr.length > 0) {
                return h41.d(k41Var, b41VarArr);
            }
            return h41.d(k41Var, k41Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, l41 l41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, l41Var)) == null) {
            return this.a.delete(str, l41Var.l(), l41Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(k41 k41Var, b41... b41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, k41Var, b41VarArr)) == null) {
            return query(k41Var, l41.j(b(k41Var, b41VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(k41 k41Var, l41 l41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, k41Var, l41Var)) == null) {
            return update(k41Var.b().g(), k41Var.a(), l41Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.d41
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.d41
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.d41
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
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

    @Override // com.baidu.tieba.d41
    public Cursor query(p41 p41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, p41Var)) == null) {
            return new q41(this.b.rawQuery(p41Var.f(), p41Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(k41 k41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, k41Var)) == null) {
            j41 b = k41Var.b();
            String g = b.g();
            b41[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, k41Var.a());
            }
            Column column = h41.d(k41Var, f[0])[0];
            boolean n = h41.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + k41Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, k41Var.a());
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

    public int update(String str, ContentValues contentValues, l41 l41Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, l41Var)) == null) {
            String[] strArr = null;
            if (l41Var != null) {
                str2 = l41Var.l();
            } else {
                str2 = null;
            }
            if (l41Var != null) {
                strArr = l41Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, b41[] b41VarArr, l41 l41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, b41VarArr, l41Var)) == null) {
            return new q41(this.b.rawQuery("SELECT " + g41.d(b41VarArr) + " FROM " + str + l41Var.k(), l41Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(k41 k41Var, l41 l41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, k41Var, l41Var)) == null) {
            q41 q41Var = new q41(this.b.rawQuery("SELECT " + g41.d(k41Var.b().d()) + " FROM " + k41Var.b().g() + l41Var.k(), l41Var.e()));
            boolean moveToFirst = q41Var.moveToFirst();
            if (moveToFirst) {
                i41.a(q41Var, k41Var);
            }
            q41Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends k41> cls, l41 l41Var, b41[] b41VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, l41Var, b41VarArr, objArr)) == null) {
            if (b41VarArr.length != 0 && objArr.length == b41VarArr.length) {
                return update(e41.b(cls).g(), h41.c(b41VarArr, objArr), l41Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, l41 l41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, l41Var)) == null) {
            return update(str, h41.e(columnArr), l41Var);
        }
        return invokeLLL.intValue;
    }
}
