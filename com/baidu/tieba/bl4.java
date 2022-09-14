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
public class bl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final bl4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-915264254, "Lcom/baidu/tieba/bl4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-915264254, "Lcom/baidu/tieba/bl4$a;");
                    return;
                }
            }
            a = new bl4();
        }
    }

    public bl4() {
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

    public static final bl4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (bl4) invokeV.objValue;
    }

    public synchronized long a(dl4 dl4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dl4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, dl4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<dl4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (dl4 dl4Var : list) {
                    h(f, dl4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(dl4 dl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dl4Var)) == null) {
            if (dl4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(dl4Var.d()));
            contentValues.put("missionid", Integer.valueOf(dl4Var.q()));
            contentValues.put("activitysource", dl4Var.e());
            contentValues.put("calltype", Integer.valueOf(dl4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(dl4Var.x()));
            contentValues.put("browsetimepage", dl4Var.g());
            contentValues.put("browsetime", Long.valueOf(dl4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(dl4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(dl4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(dl4Var.k()));
            contentValues.put("cleartime", Long.valueOf(dl4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(dl4Var.t()));
            contentValues.put("tid", Long.valueOf(dl4Var.C()));
            contentValues.put("fid", Long.valueOf(dl4Var.o()));
            contentValues.put("threadtext", dl4Var.B());
            contentValues.put("threadimg", dl4Var.z());
            contentValues.put("threadforum", Long.valueOf(dl4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(dl4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(dl4Var.w()));
            contentValues.put("token", dl4Var.E());
            contentValues.put("executingMissionList", dl4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final dl4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            dl4 dl4Var = new dl4();
            dl4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
            dl4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
            dl4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
            dl4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
            dl4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
            dl4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
            dl4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
            dl4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
            dl4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
            dl4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
            dl4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
            dl4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
            dl4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
            dl4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
            dl4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
            dl4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
            dl4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
            dl4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
            dl4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
            dl4Var.Q(dl4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
            dl4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
            return dl4Var;
        }
        return (dl4) invokeL.objValue;
    }

    public synchronized boolean e(dl4 dl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dl4Var)) == null) {
            synchronized (this) {
                if (dl4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(dl4Var.d()), String.valueOf(dl4Var.q())});
                f.setTransactionSuccessful();
                f.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<dl4> f() {
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
                    dl4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                fj.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, dl4 dl4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, dl4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(dl4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(dl4 dl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, dl4Var)) == null) {
            synchronized (this) {
                if (dl4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, dl4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, dl4 dl4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, dl4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(dl4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(dl4Var.d()), String.valueOf(dl4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized void k(List<dl4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (dl4 dl4Var : list) {
                    j(f, dl4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }
}
