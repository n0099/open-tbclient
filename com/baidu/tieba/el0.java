package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.tieba.j41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class el0 extends i41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public el0(SQLiteDatabase sQLiteDatabase) {
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

    @Override // com.baidu.tieba.i41, com.baidu.tieba.j41
    public synchronized j41.a a(q41 q41Var, h41... h41VarArr) {
        InterceptResult invokeLL;
        j41.a a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, q41Var, h41VarArr)) == null) {
            synchronized (this) {
                a = super.a(q41Var, h41VarArr);
            }
            return a;
        }
        return (j41.a) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.i41, com.baidu.tieba.j41
    public synchronized int delete(q41 q41Var, h41... h41VarArr) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, q41Var, h41VarArr)) == null) {
            synchronized (this) {
                try {
                    delete = super.delete(q41Var, h41VarArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.i41
    public synchronized boolean query(q41 q41Var, r41 r41Var) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, q41Var, r41Var)) == null) {
            synchronized (this) {
                try {
                    query = super.query(q41Var, r41Var);
                } catch (Exception unused) {
                    return false;
                }
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.i41
    public synchronized int update(q41 q41Var, r41 r41Var) {
        InterceptResult invokeLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, q41Var, r41Var)) == null) {
            synchronized (this) {
                try {
                    update = super.update(q41Var, r41Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.i41, com.baidu.tieba.j41
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

    @Override // com.baidu.tieba.i41, com.baidu.tieba.j41
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

    @Override // com.baidu.tieba.i41, com.baidu.tieba.j41
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

    @Override // com.baidu.tieba.i41
    public synchronized int delete(String str, r41 r41Var) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, r41Var)) == null) {
            synchronized (this) {
                try {
                    delete = super.delete(str, r41Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.i41
    public synchronized boolean query(q41 q41Var, h41... h41VarArr) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, q41Var, h41VarArr)) == null) {
            synchronized (this) {
                try {
                    query = super.query(q41Var, h41VarArr);
                } catch (Exception unused) {
                    return false;
                }
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.i41, com.baidu.tieba.j41
    public synchronized int update(q41 q41Var, h41... h41VarArr) {
        InterceptResult invokeLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, q41Var, h41VarArr)) == null) {
            synchronized (this) {
                try {
                    update = super.update(q41Var, h41VarArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.i41
    public synchronized long insert(q41 q41Var) {
        InterceptResult invokeL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, q41Var)) == null) {
            synchronized (this) {
                try {
                    insert = super.insert(q41Var);
                } catch (Exception unused) {
                    return -1L;
                }
            }
            return insert;
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.tieba.i41, com.baidu.tieba.j41
    public synchronized Cursor query(v41 v41Var) {
        InterceptResult invokeL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, v41Var)) == null) {
            synchronized (this) {
                try {
                    query = super.query(v41Var);
                } catch (Exception unused) {
                    return new w41(null);
                }
            }
            return query;
        }
        return (Cursor) invokeL.objValue;
    }

    @Override // com.baidu.tieba.i41
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

    @Override // com.baidu.tieba.i41
    public synchronized Cursor query(String str, h41[] h41VarArr, r41 r41Var) {
        InterceptResult invokeLLL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, h41VarArr, r41Var)) == null) {
            synchronized (this) {
                try {
                    query = super.query(str, h41VarArr, r41Var);
                } catch (Exception unused) {
                    return new w41(null);
                }
            }
            return query;
        }
        return (Cursor) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.i41
    public synchronized int update(String str, ContentValues contentValues, r41 r41Var) {
        InterceptResult invokeLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, contentValues, r41Var)) == null) {
            synchronized (this) {
                try {
                    update = super.update(str, contentValues, r41Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLLL.intValue;
    }

    @Override // com.baidu.tieba.i41
    public synchronized int update(Class<? extends q41> cls, r41 r41Var, h41[] h41VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, cls, r41Var, h41VarArr, objArr)) == null) {
            synchronized (this) {
                try {
                    update = super.update(cls, r41Var, h41VarArr, objArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLLLL.intValue;
    }

    @Override // com.baidu.tieba.i41
    public synchronized int update(String str, Column[] columnArr, r41 r41Var) {
        InterceptResult invokeLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, str, columnArr, r41Var)) == null) {
            synchronized (this) {
                try {
                    update = super.update(str, columnArr, r41Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLLL.intValue;
    }
}
