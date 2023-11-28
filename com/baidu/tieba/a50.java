package com.baidu.tieba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes5.dex */
public class a50 extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a50 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ReentrantReadWriteLock a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a50(Context context) {
        super(context, "blcp_track.db", (SQLiteDatabase.CursorFactory) null, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ReentrantReadWriteLock(true);
    }

    public static void d(Cursor cursor) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, cursor) == null) && cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static a50 j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (a50.class) {
                    if (b == null) {
                        b = new a50(context);
                    }
                }
            }
            return b;
        }
        return (a50) invokeL.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle TEXT,begintime LONG,endtime LONG,detail TEXT,state INTEGER,ext TEXT );");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final boolean a(int i, int i2, SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, sQLiteDatabase)) == null) {
            this.a.writeLock().lock();
            Cursor cursor = null;
            boolean z = false;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("SELECT flowid FROM flow WHERE flowid = " + i + " AND flowhandle = " + i2, null);
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            z = true;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                d(cursor);
                this.a.writeLock().unlock();
                if (n50.a) {
                    o50.a("TrackDBHelper", "flow checkFlowExist:" + z);
                }
                return z;
            } catch (Throwable th) {
                d(cursor);
                this.a.writeLock().unlock();
                throw th;
            }
        }
        return invokeIIL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0072, code lost:
        if (r0 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
        if (r0 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007d, code lost:
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0080, code lost:
        r7.a.writeLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.writeLock().lock();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = getWritableDatabase();
                    sQLiteDatabase.beginTransactionNonExclusive();
                    int delete = sQLiteDatabase.delete("flow", "begintime < ? AND ? != ?", new String[]{String.valueOf(System.currentTimeMillis() - 604800000), "state", String.valueOf(1)});
                    if (n50.a) {
                        o50.a("TrackDBHelper", "clear expired flow cout:" + delete);
                    }
                    if (delete > 0 && n50.a) {
                        o50.a("TrackDBHelper", "删除过期数据count:" + delete);
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.a.writeLock().unlock();
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a1, code lost:
        if (r0 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00aa, code lost:
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ac, code lost:
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00af, code lost:
        r5.a.writeLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b8, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, list) == null) && !TextUtils.isEmpty(str) && list != null && list.size() > 0) {
            this.a.writeLock().lock();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = getWritableDatabase();
                    sQLiteDatabase.beginTransactionNonExclusive();
                    int size = list.size();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < size; i++) {
                        arrayList.add("?");
                    }
                    int delete = sQLiteDatabase.delete("flow", "flowid = " + str + " AND flowhandle IN (" + TextUtils.join(",", arrayList) + SmallTailInfo.EMOTION_SUFFIX, (String[]) list.toArray(new String[list.size()]));
                    sQLiteDatabase.setTransactionSuccessful();
                    if (delete > 0 && n50.a) {
                        o50.a("TrackDBHelper", "flow 删除：" + list.toString() + " success");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.a.writeLock().unlock();
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0098 A[Catch: all -> 0x00c5, Exception -> 0x00c7, TRY_LEAVE, TryCatch #1 {Exception -> 0x00c7, blocks: (B:8:0x0058, B:10:0x0062, B:12:0x0068, B:13:0x0077, B:15:0x0094, B:17:0x0098), top: B:31:0x0058, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<j40> g(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList2;
            }
            String str2 = "SELECT * FROM flow WHERE flowid=\"" + str + "\" AND state = 1  limit " + i;
            o50.a("TrackDBHelper", "flow getAllData querySql:" + str2);
            this.a.readLock().lock();
            Cursor cursor = null;
            try {
                try {
                    cursor = getReadableDatabase().rawQuery(str2, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex("flowhandle");
                    int columnIndex2 = cursor.getColumnIndex("detail");
                    do {
                        arrayList2.add(new j40(str, cursor.getString(columnIndex), cursor.getString(columnIndex2)));
                        arrayList.add(cursor.getString(columnIndex2));
                    } while (cursor.moveToNext());
                    if (n50.a) {
                    }
                    d(cursor);
                    this.a.readLock().unlock();
                    o50.a("TrackDBHelper", "flow uploadData SIZE:" + arrayList2.size());
                    return arrayList2;
                }
                if (n50.a) {
                    o50.a("TrackDBHelper", "flow flowID:" + str + ", get data from db count:" + arrayList.size() + ",flow detail:" + arrayList.toString());
                }
                d(cursor);
                this.a.readLock().unlock();
                o50.a("TrackDBHelper", "flow uploadData SIZE:" + arrayList2.size());
                return arrayList2;
            } catch (Throwable th) {
                d(cursor);
                this.a.readLock().unlock();
                throw th;
            }
        }
        return (List) invokeLI.objValue;
    }

    public void f(f40 f40Var) {
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f40Var) == null) {
            if (f40Var == null) {
                if (n50.a) {
                    o50.a("TrackDBHelper", "flowData is null");
                    return;
                }
                return;
            }
            this.a.writeLock().lock();
            if (n50.a) {
                o50.a("TrackDBHelper", "flow insert to db:" + f40Var.g());
            }
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                } catch (SQLException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                writableDatabase.beginTransactionNonExclusive();
                if (a(f40Var.a, f40Var.b, writableDatabase)) {
                    ContentValues h = h(f40Var);
                    int update = writableDatabase.update("flow", h, "flowid = " + f40Var.a + " AND flowhandle = " + f40Var.b, null);
                    if (n50.a) {
                        o50.a("TrackDBHelper", "endFlow update count:" + update);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                e = e2;
                sQLiteDatabase = writableDatabase;
                e.printStackTrace();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.a.writeLock().unlock();
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.a.writeLock().unlock();
                throw th;
            }
            this.a.writeLock().unlock();
        }
    }

    public final ContentValues h(f40 f40Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f40Var)) == null) {
            ContentValues contentValues = new ContentValues();
            if (f40Var != null) {
                contentValues.put("flowid", Integer.valueOf(f40Var.a));
                contentValues.put("flowhandle", Integer.valueOf(f40Var.b));
                contentValues.put("begintime", Long.valueOf(f40Var.c));
                contentValues.put("endtime", Long.valueOf(f40Var.d));
                contentValues.put("detail", f40Var.f());
                if (f40Var.d == 0) {
                    contentValues.put("state", (Integer) 0);
                } else {
                    contentValues.put("state", (Integer) 1);
                }
                contentValues.put("ext", "");
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            String str2 = "SELECT COUNT(*) FROM flow WHERE flowid=\"" + str + "\" AND state = 1 ";
            this.a.readLock().lock();
            Cursor cursor = null;
            int i = 0;
            try {
                try {
                    cursor = getReadableDatabase().rawQuery(str2, null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        i = cursor.getInt(0);
                    }
                    if (n50.a) {
                        o50.a("TrackDBHelper", "flow getEndedFlowCount:" + i);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return i;
            } finally {
                d(cursor);
                this.a.readLock().unlock();
            }
        }
        return invokeL.intValue;
    }

    public void k(f40 f40Var) {
        ContentValues h;
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, f40Var) == null) {
            if (f40Var == null) {
                if (n50.a) {
                    o50.a("TrackDBHelper", "flow must not be null");
                    return;
                }
                return;
            }
            this.a.writeLock().lock();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    h = h(f40Var);
                    writableDatabase = getWritableDatabase();
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                writableDatabase.beginTransactionNonExclusive();
                if (!a(f40Var.a, f40Var.b, writableDatabase)) {
                    long insert = writableDatabase.insert("flow", null, h);
                    if (n50.a) {
                        o50.a("TrackDBHelper", "flow saveFlow,rowId:" + insert);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                }
            } catch (Exception e2) {
                e = e2;
                sQLiteDatabase = writableDatabase;
                e.printStackTrace();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.a.writeLock().unlock();
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.a.writeLock().unlock();
                throw th;
            }
            this.a.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, sQLiteDatabase, i, i2) == null) {
            try {
                sQLiteDatabase.beginTransaction();
                while (i < i2) {
                    i++;
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase == null) {
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                }
            }
        }
    }
}
