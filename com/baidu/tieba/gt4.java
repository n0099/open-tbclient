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
/* loaded from: classes6.dex */
public class gt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final gt4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-764730331, "Lcom/baidu/tieba/gt4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-764730331, "Lcom/baidu/tieba/gt4$a;");
                    return;
                }
            }
            a = new gt4();
        }
    }

    public gt4() {
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

    public static final gt4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (gt4) invokeV.objValue;
    }

    public synchronized long a(it4 it4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, it4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, it4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(it4 it4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, it4Var)) == null) {
            synchronized (this) {
                if (it4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, it4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<it4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (it4 it4Var : list) {
                    h(f, it4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(it4 it4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, it4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (it4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(it4Var.d()), String.valueOf(it4Var.q())});
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

    public synchronized void k(List<it4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (it4 it4Var : list) {
                    j(f, it4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(it4 it4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, it4Var)) == null) {
            if (it4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(it4Var.d()));
            contentValues.put("missionid", Integer.valueOf(it4Var.q()));
            contentValues.put("activitysource", it4Var.e());
            contentValues.put("calltype", Integer.valueOf(it4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(it4Var.x()));
            contentValues.put("browsetimepage", it4Var.g());
            contentValues.put("browsetime", Long.valueOf(it4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(it4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(it4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(it4Var.k()));
            contentValues.put("cleartime", Long.valueOf(it4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(it4Var.t()));
            contentValues.put("tid", Long.valueOf(it4Var.C()));
            contentValues.put("fid", Long.valueOf(it4Var.o()));
            contentValues.put("threadtext", it4Var.B());
            contentValues.put("threadimg", it4Var.z());
            contentValues.put("threadforum", Long.valueOf(it4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(it4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(it4Var.w()));
            contentValues.put("token", it4Var.E());
            contentValues.put("executingMissionList", it4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final it4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                it4 it4Var = new it4();
                it4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                it4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                it4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                it4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                it4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                it4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                it4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                it4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                it4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                it4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                it4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                it4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                it4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                it4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                it4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                it4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                it4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                it4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                it4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                it4Var.Q(it4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                it4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return it4Var;
            }
            return null;
        }
        return (it4) invokeL.objValue;
    }

    public synchronized List<it4> f() {
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
                    it4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                ei.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, it4 it4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, it4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(it4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, it4 it4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, it4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(it4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(it4Var.d()), String.valueOf(it4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
