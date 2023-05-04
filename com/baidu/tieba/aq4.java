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
/* loaded from: classes3.dex */
public class aq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final aq4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-939275800, "Lcom/baidu/tieba/aq4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-939275800, "Lcom/baidu/tieba/aq4$a;");
                    return;
                }
            }
            a = new aq4();
        }
    }

    public aq4() {
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

    public static final aq4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (aq4) invokeV.objValue;
    }

    public synchronized long a(cq4 cq4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cq4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, cq4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(cq4 cq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cq4Var)) == null) {
            synchronized (this) {
                if (cq4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, cq4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<cq4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (cq4 cq4Var : list) {
                    h(f, cq4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(cq4 cq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cq4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (cq4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(cq4Var.d()), String.valueOf(cq4Var.q())});
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

    public synchronized void k(List<cq4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (cq4 cq4Var : list) {
                    j(f, cq4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(cq4 cq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cq4Var)) == null) {
            if (cq4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(cq4Var.d()));
            contentValues.put("missionid", Integer.valueOf(cq4Var.q()));
            contentValues.put("activitysource", cq4Var.e());
            contentValues.put("calltype", Integer.valueOf(cq4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(cq4Var.x()));
            contentValues.put("browsetimepage", cq4Var.g());
            contentValues.put("browsetime", Long.valueOf(cq4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(cq4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(cq4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(cq4Var.k()));
            contentValues.put("cleartime", Long.valueOf(cq4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(cq4Var.t()));
            contentValues.put("tid", Long.valueOf(cq4Var.C()));
            contentValues.put("fid", Long.valueOf(cq4Var.o()));
            contentValues.put("threadtext", cq4Var.B());
            contentValues.put("threadimg", cq4Var.z());
            contentValues.put("threadforum", Long.valueOf(cq4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(cq4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(cq4Var.w()));
            contentValues.put("token", cq4Var.E());
            contentValues.put("executingMissionList", cq4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final cq4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                cq4 cq4Var = new cq4();
                cq4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                cq4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                cq4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                cq4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                cq4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                cq4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                cq4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                cq4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                cq4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                cq4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                cq4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                cq4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                cq4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                cq4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                cq4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                cq4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                cq4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                cq4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                cq4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                cq4Var.Q(cq4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                cq4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return cq4Var;
            }
            return null;
        }
        return (cq4) invokeL.objValue;
    }

    public synchronized List<cq4> f() {
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
                    cq4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                ji.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, cq4 cq4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, cq4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(cq4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, cq4 cq4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, cq4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(cq4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(cq4Var.d()), String.valueOf(cq4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
