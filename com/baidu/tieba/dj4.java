package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class dj4<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract ContentValues c(T t);

    public abstract T d(Cursor cursor) throws SQLException;

    public abstract List<T> e(Cursor cursor) throws SQLException;

    public dj4() {
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

    public ContentValues a(bk4 bk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bk4Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("bundle_id", bk4Var.g);
            contentValues.put("category", Integer.valueOf(bk4Var.h));
            contentValues.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, bk4Var.j);
            contentValues.put("version_code", Long.valueOf(bk4Var.i));
            contentValues.put("size", Long.valueOf(bk4Var.k));
            contentValues.put(PackageTable.MD5, bk4Var.l);
            contentValues.put("sign", bk4Var.m);
            contentValues.put(TTDownloadField.TT_DOWNLOAD_URL, bk4Var.n);
            contentValues.put(PackageTable.FILE_PATH, bk4Var.a);
            contentValues.put(PackageTable.CURRENT_SIZE, Long.valueOf(bk4Var.b));
            contentValues.put("create_time", Long.valueOf(bk4Var.c));
            contentValues.put("update_time", Long.valueOf(bk4Var.d));
            contentValues.put("state", Integer.valueOf(bk4Var.e));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean b(Cursor cursor, bk4 bk4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor, bk4Var)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("bundle_id");
                int columnIndex2 = cursor.getColumnIndex("category");
                int columnIndex3 = cursor.getColumnIndex(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                int columnIndex4 = cursor.getColumnIndex("version_code");
                int columnIndex5 = cursor.getColumnIndex("size");
                int columnIndex6 = cursor.getColumnIndex(PackageTable.MD5);
                int columnIndex7 = cursor.getColumnIndex("sign");
                int columnIndex8 = cursor.getColumnIndex(TTDownloadField.TT_DOWNLOAD_URL);
                int columnIndex9 = cursor.getColumnIndex("_id");
                int columnIndex10 = cursor.getColumnIndex(PackageTable.FILE_PATH);
                int columnIndex11 = cursor.getColumnIndex(PackageTable.CURRENT_SIZE);
                int columnIndex12 = cursor.getColumnIndex("create_time");
                int columnIndex13 = cursor.getColumnIndex("update_time");
                int columnIndex14 = cursor.getColumnIndex("state");
                String string = cursor.getString(columnIndex);
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
                bk4Var.g = string;
                bk4Var.h = cursor.getInt(columnIndex2);
                bk4Var.j = cursor.getString(columnIndex3);
                bk4Var.i = cursor.getLong(columnIndex4);
                bk4Var.k = cursor.getLong(columnIndex5);
                bk4Var.l = cursor.getString(columnIndex6);
                bk4Var.m = cursor.getString(columnIndex7);
                bk4Var.n = cursor.getString(columnIndex8);
                bk4Var.a = cursor.getString(columnIndex10);
                bk4Var.b = cursor.getLong(columnIndex11);
                bk4Var.c = cursor.getLong(columnIndex12);
                bk4Var.d = cursor.getLong(columnIndex13);
                bk4Var.f = cursor.getLong(columnIndex9);
                bk4Var.e = cursor.getInt(columnIndex14);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
