package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class ce9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase a;

    public ce9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zd9.a().c();
    }

    public final List<com.baidu.ubs.analytics.a.l> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Cursor rawQuery = this.a.rawQuery("SELECT * FROM  tb_ab_page_log order by _id ", null);
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
                lVar.t(rawQuery.getString(rawQuery.getColumnIndex("_pagerName")));
                lVar.setPath(rawQuery.getString(rawQuery.getColumnIndex("_path")));
                lVar.z(rawQuery.getString(rawQuery.getColumnIndex("_endTime")));
                lVar.setStartTime(rawQuery.getString(rawQuery.getColumnIndex("_startTime")));
                lVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
                lVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("_id")));
                arrayList.add(lVar);
            }
            rawQuery.close();
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.a.execSQL("delete from tb_ab_page_log where _id <= " + i);
        }
    }

    public final void c(com.baidu.ubs.analytics.a.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            this.a.execSQL("INSERT INTO tb_ab_page_log(_startTime,_endTime,_pagerName,_path,_sessionId) VALUES (?,?,?,?,?);", new String[]{lVar.N(), lVar.O(), lVar.E(), lVar.getPath(), lVar.I()});
        }
    }
}
