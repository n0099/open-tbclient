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
/* loaded from: classes4.dex */
public class hm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final hm4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-742565827, "Lcom/baidu/tieba/hm4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-742565827, "Lcom/baidu/tieba/hm4$a;");
                    return;
                }
            }
            a = new hm4();
        }
    }

    public hm4() {
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

    public static final hm4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (hm4) invokeV.objValue;
    }

    public synchronized long a(jm4 jm4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jm4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, jm4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(jm4 jm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jm4Var)) == null) {
            synchronized (this) {
                if (jm4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, jm4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<jm4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (jm4 jm4Var : list) {
                    h(f, jm4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(jm4 jm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jm4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (jm4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(jm4Var.d()), String.valueOf(jm4Var.q())});
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

    public synchronized void k(List<jm4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (jm4 jm4Var : list) {
                    j(f, jm4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(jm4 jm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jm4Var)) == null) {
            if (jm4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(jm4Var.d()));
            contentValues.put("missionid", Integer.valueOf(jm4Var.q()));
            contentValues.put("activitysource", jm4Var.e());
            contentValues.put("calltype", Integer.valueOf(jm4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(jm4Var.x()));
            contentValues.put("browsetimepage", jm4Var.g());
            contentValues.put("browsetime", Long.valueOf(jm4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(jm4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(jm4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(jm4Var.k()));
            contentValues.put("cleartime", Long.valueOf(jm4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(jm4Var.t()));
            contentValues.put("tid", Long.valueOf(jm4Var.C()));
            contentValues.put("fid", Long.valueOf(jm4Var.o()));
            contentValues.put("threadtext", jm4Var.B());
            contentValues.put("threadimg", jm4Var.z());
            contentValues.put("threadforum", Long.valueOf(jm4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(jm4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(jm4Var.w()));
            contentValues.put("token", jm4Var.E());
            contentValues.put("executingMissionList", jm4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final jm4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                jm4 jm4Var = new jm4();
                jm4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                jm4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                jm4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                jm4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                jm4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                jm4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                jm4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                jm4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                jm4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                jm4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                jm4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                jm4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                jm4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                jm4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                jm4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                jm4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                jm4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                jm4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                jm4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                jm4Var.Q(jm4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                jm4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return jm4Var;
            }
            return null;
        }
        return (jm4) invokeL.objValue;
    }

    public synchronized List<jm4> f() {
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
                    jm4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                zi.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, jm4 jm4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, jm4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(jm4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, jm4 jm4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, jm4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(jm4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(jm4Var.d()), String.valueOf(jm4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
