package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.tieba.t01;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hk0 extends s01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hk0(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((SQLiteDatabase) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.s01, com.baidu.tieba.t01
    public synchronized t01.a a(a11 a11Var, r01... r01VarArr) {
        InterceptResult invokeLL;
        t01.a a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, a11Var, r01VarArr)) == null) {
            synchronized (this) {
                a = super.a(a11Var, r01VarArr);
            }
            return a;
        }
        return (t01.a) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.s01, com.baidu.tieba.t01
    public synchronized void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                try {
                    super.beginTransaction();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.baidu.tieba.s01
    public synchronized int delete(String str, b11 b11Var) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, b11Var)) == null) {
            synchronized (this) {
                try {
                    delete = super.delete(str, b11Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.s01, com.baidu.tieba.t01
    public synchronized void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                try {
                    super.endTransaction();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.baidu.tieba.s01
    public synchronized long insert(a11 a11Var) {
        InterceptResult invokeL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, a11Var)) == null) {
            synchronized (this) {
                try {
                    insert = super.insert(a11Var);
                } catch (Exception unused) {
                    return -1L;
                }
            }
            return insert;
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.tieba.s01
    public synchronized boolean query(a11 a11Var, b11 b11Var) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, a11Var, b11Var)) == null) {
            synchronized (this) {
                try {
                    query = super.query(a11Var, b11Var);
                } catch (Exception unused) {
                    return false;
                }
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.s01, com.baidu.tieba.t01
    public synchronized void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                try {
                    super.setTransactionSuccessful();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.baidu.tieba.s01, com.baidu.tieba.t01
    public synchronized int update(a11 a11Var, r01... r01VarArr) {
        InterceptResult invokeLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, a11Var, r01VarArr)) == null) {
            synchronized (this) {
                try {
                    update = super.update(a11Var, r01VarArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.s01, com.baidu.tieba.t01
    public synchronized int delete(a11 a11Var, r01... r01VarArr) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, a11Var, r01VarArr)) == null) {
            synchronized (this) {
                try {
                    delete = super.delete(a11Var, r01VarArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.s01
    public synchronized long insert(String str, String[] strArr, Object... objArr) {
        InterceptResult invokeLLL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, strArr, objArr)) == null) {
            synchronized (this) {
                try {
                    insert = super.insert(str, strArr, objArr);
                } catch (Exception unused) {
                    return -1L;
                }
            }
            return insert;
        }
        return invokeLLL.longValue;
    }

    @Override // com.baidu.tieba.s01
    public synchronized boolean query(a11 a11Var, r01... r01VarArr) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, a11Var, r01VarArr)) == null) {
            synchronized (this) {
                try {
                    query = super.query(a11Var, r01VarArr);
                } catch (Exception unused) {
                    return false;
                }
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.s01
    public synchronized int update(Class<? extends a11> cls, b11 b11Var, r01[] r01VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, cls, b11Var, r01VarArr, objArr)) == null) {
            synchronized (this) {
                try {
                    update = super.update(cls, b11Var, r01VarArr, objArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLLLL.intValue;
    }

    @Override // com.baidu.tieba.s01
    public synchronized Cursor query(String str, r01[] r01VarArr, b11 b11Var) {
        InterceptResult invokeLLL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, r01VarArr, b11Var)) == null) {
            synchronized (this) {
                try {
                    query = super.query(str, r01VarArr, b11Var);
                } catch (Exception unused) {
                    return new g11(null);
                }
            }
            return query;
        }
        return (Cursor) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.s01
    public synchronized int update(a11 a11Var, b11 b11Var) {
        InterceptResult invokeLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, a11Var, b11Var)) == null) {
            synchronized (this) {
                try {
                    update = super.update(a11Var, b11Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.s01, com.baidu.tieba.t01
    public synchronized Cursor query(f11 f11Var) {
        InterceptResult invokeL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, f11Var)) == null) {
            synchronized (this) {
                try {
                    query = super.query(f11Var);
                } catch (Exception unused) {
                    return new g11(null);
                }
            }
            return query;
        }
        return (Cursor) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s01
    public synchronized int update(String str, ContentValues contentValues, b11 b11Var) {
        InterceptResult invokeLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, contentValues, b11Var)) == null) {
            synchronized (this) {
                try {
                    update = super.update(str, contentValues, b11Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLLL.intValue;
    }

    @Override // com.baidu.tieba.s01
    public synchronized int update(String str, Column[] columnArr, b11 b11Var) {
        InterceptResult invokeLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, str, columnArr, b11Var)) == null) {
            synchronized (this) {
                try {
                    update = super.update(str, columnArr, b11Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLLL.intValue;
    }
}
