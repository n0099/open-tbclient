package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ak4 extends vj4<vk4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ak4() {
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
    /* renamed from: f */
    public ContentValues c(vk4 vk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vk4Var)) == null) {
            ContentValues a = super.a(vk4Var);
            a.put("independent", Integer.valueOf(vk4Var.r ? 1 : 0));
            a.put("sub_pkg_name", vk4Var.p);
            a.put("app_id", vk4Var.o);
            return a;
        }
        return (ContentValues) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vj4
    /* renamed from: g */
    public vk4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                return h(cursor);
            }
            return null;
        }
        return (vk4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vj4
    public List<vk4> e(Cursor cursor) {
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

    public final vk4 h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("independent");
                int columnIndex2 = cursor.getColumnIndex("sub_pkg_name");
                int columnIndex3 = cursor.getColumnIndex("app_id");
                vk4 vk4Var = new vk4();
                if (b(cursor, vk4Var)) {
                    boolean z = true;
                    if (cursor.getInt(columnIndex) != 1) {
                        z = false;
                    }
                    vk4Var.r = z;
                    vk4Var.p = cursor.getString(columnIndex2);
                    vk4Var.o = cursor.getString(columnIndex3);
                    return vk4Var;
                }
                return null;
            }
            return null;
        }
        return (vk4) invokeL.objValue;
    }
}
