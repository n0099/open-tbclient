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
public class fu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final fu4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-792435961, "Lcom/baidu/tieba/fu4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-792435961, "Lcom/baidu/tieba/fu4$a;");
                    return;
                }
            }
            a = new fu4();
        }
    }

    public fu4() {
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

    public static final fu4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (fu4) invokeV.objValue;
    }

    public synchronized long a(hu4 hu4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hu4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, hu4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(hu4 hu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hu4Var)) == null) {
            synchronized (this) {
                if (hu4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, hu4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<hu4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (hu4 hu4Var : list) {
                    h(f, hu4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(hu4 hu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hu4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (hu4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(hu4Var.d()), String.valueOf(hu4Var.q())});
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

    public synchronized void k(List<hu4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (hu4 hu4Var : list) {
                    j(f, hu4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(hu4 hu4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hu4Var)) == null) {
            if (hu4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(hu4Var.d()));
            contentValues.put("missionid", Integer.valueOf(hu4Var.q()));
            contentValues.put("activitysource", hu4Var.e());
            contentValues.put("calltype", Integer.valueOf(hu4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(hu4Var.x()));
            contentValues.put("browsetimepage", hu4Var.g());
            contentValues.put("browsetime", Long.valueOf(hu4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(hu4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(hu4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(hu4Var.k()));
            contentValues.put("cleartime", Long.valueOf(hu4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(hu4Var.t()));
            contentValues.put("tid", Long.valueOf(hu4Var.C()));
            contentValues.put("fid", Long.valueOf(hu4Var.o()));
            contentValues.put("threadtext", hu4Var.B());
            contentValues.put("threadimg", hu4Var.z());
            contentValues.put("threadforum", Long.valueOf(hu4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(hu4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(hu4Var.w()));
            contentValues.put("token", hu4Var.E());
            contentValues.put("executingMissionList", hu4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final hu4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                hu4 hu4Var = new hu4();
                hu4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                hu4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                hu4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                hu4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                hu4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                hu4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                hu4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                hu4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                hu4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                hu4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                hu4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                hu4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                hu4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                hu4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                hu4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                hu4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                hu4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                hu4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                hu4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                hu4Var.Q(hu4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                hu4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return hu4Var;
            }
            return null;
        }
        return (hu4) invokeL.objValue;
    }

    public synchronized List<hu4> f() {
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
                    hu4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                yi.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, hu4 hu4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, hu4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(hu4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, hu4 hu4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, hu4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(hu4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(hu4Var.d()), String.valueOf(hu4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
