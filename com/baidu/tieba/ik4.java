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
/* loaded from: classes6.dex */
public class ik4 extends ck4<dl4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ik4() {
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
    @Override // com.baidu.tieba.ck4
    /* renamed from: g */
    public dl4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                return h(cursor);
            }
            return null;
        }
        return (dl4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ck4
    public List<dl4> e(Cursor cursor) {
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
    @Override // com.baidu.tieba.ck4
    /* renamed from: f */
    public ContentValues c(dl4 dl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dl4Var)) == null) {
            ContentValues a = super.a(dl4Var);
            a.put("max_age", Long.valueOf(dl4Var.o));
            a.put("token", dl4Var.p);
            a.put("domains", dl4Var.q);
            a.put(GameGuideConfigInfo.KEY_APP_KEY, dl4Var.r);
            a.put("app_name", dl4Var.s);
            return a;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final dl4 h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("max_age");
                int columnIndex2 = cursor.getColumnIndex("token");
                int columnIndex3 = cursor.getColumnIndex("domains");
                int columnIndex4 = cursor.getColumnIndex(GameGuideConfigInfo.KEY_APP_KEY);
                int columnIndex5 = cursor.getColumnIndex("app_name");
                dl4 dl4Var = new dl4();
                if (b(cursor, dl4Var)) {
                    dl4Var.o = cursor.getLong(columnIndex);
                    dl4Var.p = cursor.getString(columnIndex2);
                    dl4Var.q = cursor.getString(columnIndex3);
                    dl4Var.r = cursor.getString(columnIndex4);
                    dl4Var.s = cursor.getString(columnIndex5);
                    return dl4Var;
                }
                return null;
            }
            return null;
        }
        return (dl4) invokeL.objValue;
    }
}
