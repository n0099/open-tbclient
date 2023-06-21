package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class cu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final cu4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-878323414, "Lcom/baidu/tieba/cu4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-878323414, "Lcom/baidu/tieba/cu4$a;");
                    return;
                }
            }
            a = new cu4();
        }
    }

    public cu4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final cu4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (cu4) invokeV.objValue;
    }

    public synchronized long a(eu4 eu4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eu4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, eu4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(eu4 eu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eu4Var)) == null) {
            synchronized (this) {
                if (eu4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, eu4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<eu4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (eu4 eu4Var : list) {
                    h(f, eu4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(eu4 eu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eu4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (eu4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(eu4Var.d()), String.valueOf(eu4Var.q())});
                f.setTransactionSuccessful();
                f.endTransaction();
                if (delete >= 0) {
                    z = true;
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void k(List<eu4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (eu4 eu4Var : list) {
                    j(f, eu4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(eu4 eu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eu4Var)) == null) {
            if (eu4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(eu4Var.d()));
            contentValues.put("missionid", Integer.valueOf(eu4Var.q()));
            contentValues.put("activitysource", eu4Var.e());
            contentValues.put("calltype", Integer.valueOf(eu4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(eu4Var.x()));
            contentValues.put("browsetimepage", eu4Var.g());
            contentValues.put("browsetime", Long.valueOf(eu4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(eu4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(eu4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(eu4Var.k()));
            contentValues.put("cleartime", Long.valueOf(eu4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(eu4Var.t()));
            contentValues.put("tid", Long.valueOf(eu4Var.C()));
            contentValues.put("fid", Long.valueOf(eu4Var.o()));
            contentValues.put("threadtext", eu4Var.B());
            contentValues.put("threadimg", eu4Var.z());
            contentValues.put("threadforum", Long.valueOf(eu4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(eu4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(eu4Var.w()));
            contentValues.put("token", eu4Var.E());
            contentValues.put("executingMissionList", eu4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final eu4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                eu4 eu4Var = new eu4();
                eu4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                eu4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                eu4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                eu4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                eu4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                eu4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                eu4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                eu4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                eu4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                eu4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                eu4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                eu4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                eu4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                eu4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                eu4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                eu4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                eu4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                eu4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                eu4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                eu4Var.Q(eu4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                eu4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return eu4Var;
            }
            return null;
        }
        return (eu4) invokeL.objValue;
    }

    public synchronized List<eu4> f() {
        InterceptResult invokeV;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                linkedList = new LinkedList();
                Cursor rawQuery = f.rawQuery("SELECT * FROM activity_mission_info", null);
                while (rawQuery.moveToNext()) {
                    eu4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                xi.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, eu4 eu4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, eu4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(eu4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, eu4 eu4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, eu4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(eu4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(eu4Var.d()), String.valueOf(eu4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
