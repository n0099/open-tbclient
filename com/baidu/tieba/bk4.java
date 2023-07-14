package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class bk4 extends vj4<wk4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bk4() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vj4
    /* renamed from: g */
    public wk4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                return h(cursor);
            }
            return null;
        }
        return (wk4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vj4
    public List<wk4> e(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    arrayList.add(h(cursor));
                } while (cursor.moveToNext());
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vj4
    /* renamed from: f */
    public ContentValues c(wk4 wk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, wk4Var)) == null) {
            ContentValues a = super.a(wk4Var);
            a.put("max_age", Long.valueOf(wk4Var.o));
            a.put("token", wk4Var.p);
            a.put("domains", wk4Var.q);
            a.put(GameGuideConfigInfo.KEY_APP_KEY, wk4Var.r);
            a.put("app_name", wk4Var.s);
            return a;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final wk4 h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("max_age");
                int columnIndex2 = cursor.getColumnIndex("token");
                int columnIndex3 = cursor.getColumnIndex("domains");
                int columnIndex4 = cursor.getColumnIndex(GameGuideConfigInfo.KEY_APP_KEY);
                int columnIndex5 = cursor.getColumnIndex("app_name");
                wk4 wk4Var = new wk4();
                if (b(cursor, wk4Var)) {
                    wk4Var.o = cursor.getLong(columnIndex);
                    wk4Var.p = cursor.getString(columnIndex2);
                    wk4Var.q = cursor.getString(columnIndex3);
                    wk4Var.r = cursor.getString(columnIndex4);
                    wk4Var.s = cursor.getString(columnIndex5);
                    return wk4Var;
                }
                return null;
            }
            return null;
        }
        return (wk4) invokeL.objValue;
    }
}
