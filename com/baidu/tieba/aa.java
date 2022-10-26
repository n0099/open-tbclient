package com.baidu.tieba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public abstract class aa implements x9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x9.a callback;
    public SQLiteDatabase database;
    public final String dbFileFullPath;
    public int mVersion;

    public abstract void clearAllTables(SQLiteDatabase sQLiteDatabase);

    public abstract void createAllTables(SQLiteDatabase sQLiteDatabase);

    public aa(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVersion = 1;
        this.database = null;
        this.mVersion = i;
        this.dbFileFullPath = str;
    }

    private void exeCallback(SQLiteDatabase sQLiteDatabase) {
        x9.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, sQLiteDatabase) == null) && (aVar = this.callback) != null) {
            aVar.onDatabaseCreated(sQLiteDatabase);
        }
    }

    private void onCreateDatabase(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, sQLiteDatabase) == null) {
            onCreate(sQLiteDatabase);
            exeCallback(sQLiteDatabase);
        }
    }

    @Override // com.baidu.tieba.x9
    public boolean dropDatabase(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            File file = new File(this.dbFileFullPath);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
            createAllTables(sQLiteDatabase);
        }
    }

    @Override // com.baidu.tieba.x9
    public void setOnCreateCallback(x9.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.callback = aVar;
        }
    }

    private void onUpdateDatabase(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, this, sQLiteDatabase, i, i2) == null) {
            if (i2 > i) {
                onUpgrade(sQLiteDatabase, i, i2);
            } else {
                onDowngrade(sQLiteDatabase, i, i2);
            }
            exeCallback(sQLiteDatabase);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, sQLiteDatabase, i, i2) == null) {
            clearAllTables(sQLiteDatabase);
            createAllTables(sQLiteDatabase);
        }
    }

    public boolean executeDDLSqlIgnoreAnyErrors(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, sQLiteDatabase, str)) == null) {
            try {
                sQLiteDatabase.execSQL(str);
                return true;
            } catch (Throwable th) {
                BdLog.e(str + ":" + th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.x9
    public SQLiteDatabase getWritableDatabase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            File file = new File(this.dbFileFullPath);
            if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
                boolean exists = file.exists();
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(this.dbFileFullPath, (SQLiteDatabase.CursorFactory) null);
                this.database = openOrCreateDatabase;
                if (openOrCreateDatabase != null) {
                    if (!exists) {
                        onCreateDatabase(openOrCreateDatabase);
                        this.database.setVersion(this.mVersion);
                    } else {
                        int version = openOrCreateDatabase.getVersion();
                        int i = this.mVersion;
                        if (version != i) {
                            onUpdateDatabase(this.database, version, i);
                            this.database.setVersion(this.mVersion);
                        }
                    }
                }
            }
            return this.database;
        }
        return (SQLiteDatabase) invokeV.objValue;
    }
}
