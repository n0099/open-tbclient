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
/* loaded from: classes5.dex */
public final class bdb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase a;

    public bdb() {
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
        this.a = edb.a().c();
    }

    public final List<com.baidu.ubs.analytics.a.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Cursor rawQuery = this.a.rawQuery("SELECT * FROM tb_ab_click_log order by _id ", null);
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.ubs.analytics.a.a aVar = new com.baidu.ubs.analytics.a.a();
                aVar.v(rawQuery.getString(rawQuery.getColumnIndex("_eventId")));
                aVar.w(rawQuery.getString(rawQuery.getColumnIndex("_parameter")));
                aVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
                aVar.u(rawQuery.getString(rawQuery.getColumnIndex("_timeStamp")));
                aVar.t(rawQuery.getString(rawQuery.getColumnIndex("_pagerName")));
                aVar.s(rawQuery.getString(rawQuery.getColumnIndex("_productLine")));
                aVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("_id")));
                arrayList.add(aVar);
            }
            rawQuery.close();
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.a.execSQL("delete from tb_ab_click_log where _id <= " + i);
        }
    }

    public final void c(com.baidu.ubs.analytics.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.a.execSQL("INSERT INTO tb_ab_click_log(_eventId,_parameter,_sessionId,_timeStamp,_pagerName,_productLine) VALUES (?,?,?,?,?,?);", new String[]{aVar.G(), aVar.H(), aVar.I(), aVar.F(), aVar.E(), aVar.D()});
        }
    }
}
