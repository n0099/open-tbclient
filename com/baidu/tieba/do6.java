package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class do6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final do6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-855175807, "Lcom/baidu/tieba/do6$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-855175807, "Lcom/baidu/tieba/do6$a;");
                    return;
                }
            }
            a = new do6();
        }
    }

    public do6() {
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

    public static final do6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (do6) invokeV.objValue;
    }

    private long insert(SQLiteDatabase sQLiteDatabase, co6 co6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, sQLiteDatabase, co6Var)) == null) {
            try {
                return sQLiteDatabase.insert(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO, null, a(co6Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    private long update(SQLiteDatabase sQLiteDatabase, co6 co6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, sQLiteDatabase, co6Var)) == null) {
            try {
                return sQLiteDatabase.update(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO, a(co6Var), "pkg_name = ?", new String[]{String.valueOf(co6Var.a.pkgName)});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final ContentValues a(co6 co6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, co6Var)) == null) {
            if (co6Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, co6Var.a.pkgName);
            contentValues.put("download_time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put(WriteActivityConfig.ITEM_INFO, f(co6Var.a));
            contentValues.put("item_source", Integer.valueOf(co6Var.b));
            contentValues.put("storage_location", Integer.valueOf(co6Var.c));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    @SuppressLint({"Range"})
    public final mb5 b(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                mb5 mb5Var = new mb5();
                mb5Var.a = cursor.getString(cursor.getColumnIndex(EmotionResourceInfo.JSON_KEY_PKG_NAME));
                cursor.getLong(cursor.getColumnIndex("download_time"));
                mb5Var.c = cursor.getString(cursor.getColumnIndex(WriteActivityConfig.ITEM_INFO));
                mb5Var.d = cursor.getInt(cursor.getColumnIndex("item_source"));
                mb5Var.e = cursor.getInt(cursor.getColumnIndex("storage_location"));
                return mb5Var;
            }
            return null;
        }
        return (mb5) invokeL.objValue;
    }

    public synchronized boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (hi.isEmpty(str)) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO, "pkg_name = ?", new String[]{str});
                f.setTransactionSuccessful();
                f.endTransaction();
                if (delete >= 0) {
                    z = true;
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<mb5> d() {
        InterceptResult invokeV;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                linkedList = new LinkedList();
                Cursor rawQuery = f.rawQuery(String.format("SELECT * FROM %s ORDER BY %s DESC", TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO, "download_time"), null);
                while (rawQuery.moveToNext()) {
                    mb5 b = b(rawQuery);
                    if (b != null) {
                        linkedList.add(b);
                    }
                }
                f.setTransactionSuccessful();
                ji.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final String f(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, itemData)) == null) {
            if (itemData == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("item_id", itemData.itemId);
                jSONObject.put("item_name", itemData.mTitle);
                jSONObject.put("icon_size", itemData.mIconSize);
                jSONObject.put("icon_url", itemData.mIconUrl);
                if (!ListUtils.isEmpty(itemData.mTags)) {
                    jSONObject.put(TaskProcess.keyTags, new JSONArray((Collection) itemData.mTags));
                }
                jSONObject.put("score", itemData.mScore);
                jSONObject.put(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, itemData.mStar);
                jSONObject.put("button_name", itemData.buttonName);
                jSONObject.put("button_link", itemData.buttonLink);
                jSONObject.put("button_link_type", itemData.buttonLinkType);
                jSONObject.put("apk_name", itemData.pkgName);
                jSONObject.put("forum_name", itemData.forumName);
                jSONObject.put("item_appid", itemData.appId);
                if (itemData.apkDetail != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("developer", itemData.apkDetail.developer);
                    jSONObject2.put("publisher", itemData.apkDetail.publisher);
                    jSONObject2.put("version", itemData.apkDetail.version);
                    jSONObject2.put("version_code", itemData.apkDetail.version_code);
                    jSONObject2.put("update_time", itemData.apkDetail.update_time);
                    jSONObject2.put("size", itemData.apkDetail.size);
                    jSONObject2.put("need_network", itemData.apkDetail.need_network);
                    jSONObject2.put("need_inner_buy", itemData.apkDetail.need_inner_buy);
                    jSONObject2.put("authority_url", itemData.apkDetail.authority_url);
                    jSONObject2.put("privacy_url", itemData.apkDetail.privacy_url);
                    jSONObject2.put("pkg_source", itemData.apkDetail.pkg_source);
                    jSONObject.put("apk_detail", jSONObject2);
                }
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public synchronized long g(co6 co6Var) {
        InterceptResult invokeL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, co6Var)) == null) {
            synchronized (this) {
                if (co6Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                Cursor rawQuery = f.rawQuery("SELECT * FROM download_info where pkg_name = ?", new String[]{co6Var.a.pkgName});
                if (rawQuery.getCount() > 0) {
                    insert = update(f, co6Var);
                } else {
                    insert = insert(f, co6Var);
                }
                f.setTransactionSuccessful();
                ji.a(rawQuery);
                f.endTransaction();
                return insert;
            }
        }
        return invokeL.longValue;
    }
}
