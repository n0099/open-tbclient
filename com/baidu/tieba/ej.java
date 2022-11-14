package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.df;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ej {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b implements Comparator<df.b<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public /* synthetic */ b(a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(df.b<?> bVar, df.b<?> bVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, bVar2)) == null) {
                long j = bVar.c;
                long j2 = bVar2.c;
                if (j == j2) {
                    return 0;
                }
                if (j > j2) {
                    return -1;
                }
                return 1;
            }
            return invokeLL.intValue;
        }
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [T, byte[]] */
    @SuppressLint({"Range"})
    public static List<df.b<byte[]>> a(df<byte[]> dfVar) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dfVar)) == null) {
            LinkedList linkedList = new LinkedList();
            try {
                cursor = c(dfVar);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            if (cursor == null) {
                return null;
            }
            while (cursor.moveToNext()) {
                try {
                    df.b bVar = new df.b();
                    bVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                    bVar.c = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    bVar.b = cursor.getBlob(cursor.getColumnIndex("m_value"));
                    linkedList.add(bVar);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        BdLog.e(th);
                        wg.a(cursor);
                        Collections.sort(linkedList, new b(null));
                        return linkedList;
                    } finally {
                        wg.a(cursor);
                    }
                }
            }
            wg.a(cursor);
            Collections.sort(linkedList, new b(null));
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [T, java.lang.String] */
    @SuppressLint({"Range"})
    public static List<df.b<String>> b(df<String> dfVar) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dfVar)) == null) {
            LinkedList linkedList = new LinkedList();
            try {
                cursor = c(dfVar);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            if (cursor == null) {
                return null;
            }
            while (cursor.moveToNext()) {
                try {
                    df.b bVar = new df.b();
                    bVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                    bVar.c = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    bVar.b = cursor.getString(cursor.getColumnIndex("m_value"));
                    linkedList.add(bVar);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        BdLog.e(th);
                        wg.a(cursor);
                        Collections.sort(linkedList, new b(null));
                        return linkedList;
                    } finally {
                        wg.a(cursor);
                    }
                }
            }
            wg.a(cursor);
            Collections.sort(linkedList, new b(null));
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static Cursor c(df<?> dfVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dfVar)) == null) {
            if (dfVar == null || !(dfVar instanceof df.c)) {
                return null;
            }
            df.c cVar = (df.c) dfVar;
            if (!(cVar.c() instanceof bf)) {
                return null;
            }
            ue n = ((bf) cVar.c()).n();
            return n.q(n.h().f(), cVar.j());
        }
        return (Cursor) invokeL.objValue;
    }
}
