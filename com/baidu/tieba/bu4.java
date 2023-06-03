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
public class bu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final bu4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-906952565, "Lcom/baidu/tieba/bu4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-906952565, "Lcom/baidu/tieba/bu4$a;");
                    return;
                }
            }
            a = new bu4();
        }
    }

    public bu4() {
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

    public static final bu4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (bu4) invokeV.objValue;
    }

    public synchronized long a(du4 du4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, du4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, du4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(du4 du4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, du4Var)) == null) {
            synchronized (this) {
                if (du4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, du4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<du4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (du4 du4Var : list) {
                    h(f, du4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(du4 du4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, du4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (du4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(du4Var.d()), String.valueOf(du4Var.q())});
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

    public synchronized void k(List<du4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (du4 du4Var : list) {
                    j(f, du4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(du4 du4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, du4Var)) == null) {
            if (du4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(du4Var.d()));
            contentValues.put("missionid", Integer.valueOf(du4Var.q()));
            contentValues.put("activitysource", du4Var.e());
            contentValues.put("calltype", Integer.valueOf(du4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(du4Var.x()));
            contentValues.put("browsetimepage", du4Var.g());
            contentValues.put("browsetime", Long.valueOf(du4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(du4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(du4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(du4Var.k()));
            contentValues.put("cleartime", Long.valueOf(du4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(du4Var.t()));
            contentValues.put("tid", Long.valueOf(du4Var.C()));
            contentValues.put("fid", Long.valueOf(du4Var.o()));
            contentValues.put("threadtext", du4Var.B());
            contentValues.put("threadimg", du4Var.z());
            contentValues.put("threadforum", Long.valueOf(du4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(du4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(du4Var.w()));
            contentValues.put("token", du4Var.E());
            contentValues.put("executingMissionList", du4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final du4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                du4 du4Var = new du4();
                du4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                du4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                du4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                du4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                du4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                du4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                du4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                du4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                du4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                du4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                du4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                du4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                du4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                du4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                du4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                du4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                du4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                du4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                du4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                du4Var.Q(du4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                du4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return du4Var;
            }
            return null;
        }
        return (du4) invokeL.objValue;
    }

    public synchronized List<du4> f() {
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
                    du4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                wi.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, du4 du4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, du4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(du4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, du4 du4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, du4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(du4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(du4Var.d()), String.valueOf(du4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
