package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.tieba.z41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cm0 extends y41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cm0(SQLiteDatabase sQLiteDatabase) {
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

    @Override // com.baidu.tieba.y41, com.baidu.tieba.z41
    public synchronized z41.a a(g51 g51Var, x41... x41VarArr) {
        InterceptResult invokeLL;
        z41.a a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, g51Var, x41VarArr)) == null) {
            synchronized (this) {
                a = super.a(g51Var, x41VarArr);
            }
            return a;
        }
        return (z41.a) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.y41, com.baidu.tieba.z41
    public synchronized int delete(g51 g51Var, x41... x41VarArr) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, g51Var, x41VarArr)) == null) {
            synchronized (this) {
                try {
                    delete = super.delete(g51Var, x41VarArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.y41
    public synchronized boolean query(g51 g51Var, h51 h51Var) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, g51Var, h51Var)) == null) {
            synchronized (this) {
                try {
                    query = super.query(g51Var, h51Var);
                } catch (Exception unused) {
                    return false;
                }
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.y41
    public synchronized int update(g51 g51Var, h51 h51Var) {
        InterceptResult invokeLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, g51Var, h51Var)) == null) {
            synchronized (this) {
                try {
                    update = super.update(g51Var, h51Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.y41, com.baidu.tieba.z41
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

    @Override // com.baidu.tieba.y41, com.baidu.tieba.z41
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

    @Override // com.baidu.tieba.y41, com.baidu.tieba.z41
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

    @Override // com.baidu.tieba.y41
    public synchronized int delete(String str, h51 h51Var) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, h51Var)) == null) {
            synchronized (this) {
                try {
                    delete = super.delete(str, h51Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.y41
    public synchronized boolean query(g51 g51Var, x41... x41VarArr) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, g51Var, x41VarArr)) == null) {
            synchronized (this) {
                try {
                    query = super.query(g51Var, x41VarArr);
                } catch (Exception unused) {
                    return false;
                }
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.y41, com.baidu.tieba.z41
    public synchronized int update(g51 g51Var, x41... x41VarArr) {
        InterceptResult invokeLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, g51Var, x41VarArr)) == null) {
            synchronized (this) {
                try {
                    update = super.update(g51Var, x41VarArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.y41
    public synchronized long insert(g51 g51Var) {
        InterceptResult invokeL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, g51Var)) == null) {
            synchronized (this) {
                try {
                    insert = super.insert(g51Var);
                } catch (Exception unused) {
                    return -1L;
                }
            }
            return insert;
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.tieba.y41, com.baidu.tieba.z41
    public synchronized Cursor query(l51 l51Var) {
        InterceptResult invokeL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, l51Var)) == null) {
            synchronized (this) {
                try {
                    query = super.query(l51Var);
                } catch (Exception unused) {
                    return new m51(null);
                }
            }
            return query;
        }
        return (Cursor) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y41
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

    @Override // com.baidu.tieba.y41
    public synchronized Cursor query(String str, x41[] x41VarArr, h51 h51Var) {
        InterceptResult invokeLLL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, x41VarArr, h51Var)) == null) {
            synchronized (this) {
                try {
                    query = super.query(str, x41VarArr, h51Var);
                } catch (Exception unused) {
                    return new m51(null);
                }
            }
            return query;
        }
        return (Cursor) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.y41
    public synchronized int update(String str, ContentValues contentValues, h51 h51Var) {
        InterceptResult invokeLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, contentValues, h51Var)) == null) {
            synchronized (this) {
                try {
                    update = super.update(str, contentValues, h51Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLLL.intValue;
    }

    @Override // com.baidu.tieba.y41
    public synchronized int update(Class<? extends g51> cls, h51 h51Var, x41[] x41VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, cls, h51Var, x41VarArr, objArr)) == null) {
            synchronized (this) {
                try {
                    update = super.update(cls, h51Var, x41VarArr, objArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLLLL.intValue;
    }

    @Override // com.baidu.tieba.y41
    public synchronized int update(String str, Column[] columnArr, h51 h51Var) {
        InterceptResult invokeLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, str, columnArr, h51Var)) == null) {
            synchronized (this) {
                try {
                    update = super.update(str, columnArr, h51Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLLL.intValue;
    }
}
