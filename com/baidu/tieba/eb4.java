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
/* loaded from: classes3.dex */
public class eb4 extends ya4<zb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public eb4() {
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

    @Override // com.baidu.tieba.ya4
    public List<zb4> e(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                return arrayList;
            }
            do {
                arrayList.add(h(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ya4
    /* renamed from: f */
    public ContentValues c(zb4 zb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, zb4Var)) == null) {
            ContentValues a = super.a(zb4Var);
            a.put("max_age", Long.valueOf(zb4Var.o));
            a.put("token", zb4Var.p);
            a.put("domains", zb4Var.q);
            a.put(GameGuideConfigInfo.KEY_APP_KEY, zb4Var.r);
            a.put("app_name", zb4Var.s);
            return a;
        }
        return (ContentValues) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ya4
    /* renamed from: g */
    public zb4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                return null;
            }
            return h(cursor);
        }
        return (zb4) invokeL.objValue;
    }

    public final zb4 h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("max_age");
                int columnIndex2 = cursor.getColumnIndex("token");
                int columnIndex3 = cursor.getColumnIndex("domains");
                int columnIndex4 = cursor.getColumnIndex(GameGuideConfigInfo.KEY_APP_KEY);
                int columnIndex5 = cursor.getColumnIndex("app_name");
                zb4 zb4Var = new zb4();
                if (b(cursor, zb4Var)) {
                    zb4Var.o = cursor.getLong(columnIndex);
                    zb4Var.p = cursor.getString(columnIndex2);
                    zb4Var.q = cursor.getString(columnIndex3);
                    zb4Var.r = cursor.getString(columnIndex4);
                    zb4Var.s = cursor.getString(columnIndex5);
                    return zb4Var;
                }
                return null;
            }
            return null;
        }
        return (zb4) invokeL.objValue;
    }
}
