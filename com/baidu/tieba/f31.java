package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.g31;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f31 implements g31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f31(SQLiteDatabase sQLiteDatabase) {
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

    public f31(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.g31
    public g31.a a(n31 n31Var, e31... e31VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, n31Var, e31VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(n31Var, e31VarArr);
                if (i == 0) {
                    j = insert(n31Var);
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
                return new g31.a(j, i);
            }
        } else {
            return (g31.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.g31
    public int delete(n31 n31Var, e31... e31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, n31Var, e31VarArr)) == null) {
            String g = n31Var.b().g();
            Column[] b = b(n31Var, e31VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, o31.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.g31
    public int update(n31 n31Var, e31... e31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, n31Var, e31VarArr)) == null) {
            String g = n31Var.b().g();
            o31 j = o31.j(b(n31Var, e31VarArr));
            return this.a.update(g, n31Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(n31 n31Var, e31... e31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n31Var, e31VarArr)) == null) {
            if (e31VarArr.length > 0) {
                return k31.d(n31Var, e31VarArr);
            }
            return k31.d(n31Var, n31Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, o31 o31Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, o31Var)) == null) {
            return this.a.delete(str, o31Var.l(), o31Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(n31 n31Var, e31... e31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, n31Var, e31VarArr)) == null) {
            return query(n31Var, o31.j(b(n31Var, e31VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(n31 n31Var, o31 o31Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, n31Var, o31Var)) == null) {
            return update(n31Var.b().g(), n31Var.a(), o31Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.g31
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.g31
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.g31
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

    @Override // com.baidu.tieba.g31
    public Cursor query(s31 s31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, s31Var)) == null) {
            return new t31(this.b.rawQuery(s31Var.f(), s31Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(n31 n31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, n31Var)) == null) {
            m31 b = n31Var.b();
            String g = b.g();
            e31[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, n31Var.a());
            }
            Column column = k31.d(n31Var, f[0])[0];
            boolean n = k31.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + n31Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, n31Var.a());
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

    public int update(String str, ContentValues contentValues, o31 o31Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, o31Var)) == null) {
            String[] strArr = null;
            if (o31Var != null) {
                str2 = o31Var.l();
            } else {
                str2 = null;
            }
            if (o31Var != null) {
                strArr = o31Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, e31[] e31VarArr, o31 o31Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, e31VarArr, o31Var)) == null) {
            return new t31(this.b.rawQuery("SELECT " + j31.d(e31VarArr) + " FROM " + str + o31Var.k(), o31Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(n31 n31Var, o31 o31Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, n31Var, o31Var)) == null) {
            t31 t31Var = new t31(this.b.rawQuery("SELECT " + j31.d(n31Var.b().d()) + " FROM " + n31Var.b().g() + o31Var.k(), o31Var.e()));
            boolean moveToFirst = t31Var.moveToFirst();
            if (moveToFirst) {
                l31.a(t31Var, n31Var);
            }
            t31Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends n31> cls, o31 o31Var, e31[] e31VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, o31Var, e31VarArr, objArr)) == null) {
            if (e31VarArr.length != 0 && objArr.length == e31VarArr.length) {
                return update(h31.b(cls).g(), k31.c(e31VarArr, objArr), o31Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, o31 o31Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, o31Var)) == null) {
            return update(str, k31.e(columnArr), o31Var);
        }
        return invokeLLL.intValue;
    }
}
