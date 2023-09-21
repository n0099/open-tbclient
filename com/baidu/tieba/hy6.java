package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ApkDetail;
/* loaded from: classes6.dex */
public final class hy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947840100, "Lcom/baidu/tieba/hy6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947840100, "Lcom/baidu/tieba/hy6;");
        }
    }

    public hy6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String a(ItemData itemData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, itemData)) == null) {
            if (itemData != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("item_id", Long.valueOf(itemData.itemId));
                    jSONObject.putOpt("item_name", itemData.mTitle);
                    jSONObject.putOpt("icon_size", Double.valueOf(itemData.mIconSize));
                    jSONObject.putOpt("icon_url", itemData.mIconUrl);
                    if (!ListUtils.isEmpty(itemData.mTags)) {
                        jSONObject.putOpt(TaskProcess.keyTags, new JSONArray((Collection) itemData.mTags));
                    }
                    jSONObject.putOpt("score", Double.valueOf(itemData.mScore));
                    jSONObject.putOpt("star", Integer.valueOf(itemData.mStar));
                    jSONObject.putOpt("button_name", itemData.buttonName);
                    jSONObject.putOpt("button_link", itemData.buttonLink);
                    jSONObject.putOpt("button_link_type", itemData.buttonLinkType);
                    jSONObject.putOpt("apk_name", itemData.pkgName);
                    jSONObject.putOpt("forum_name", itemData.forumName);
                    jSONObject.putOpt("item_appid", itemData.appId);
                    jSONObject.putOpt("file_download_type", Integer.valueOf(itemData.mTbFileDownloaderType));
                    jSONObject.putOpt("notification_show_count", Integer.valueOf(itemData.notificationShowCount));
                    jSONObject.putOpt(NetDiskFileMsg.NetDiskFile.JSON_KEY_FILE_TYPE, itemData.fileType);
                    ApkDetail apkDetail = itemData.apkDetail;
                    if (apkDetail != null) {
                        Intrinsics.checkNotNullExpressionValue(apkDetail, "apkDetail");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("developer", apkDetail.developer);
                        jSONObject2.putOpt("publisher", apkDetail.publisher);
                        jSONObject2.putOpt("version", apkDetail.version);
                        jSONObject2.putOpt("version_code", apkDetail.version_code);
                        jSONObject2.putOpt("update_time", apkDetail.update_time);
                        jSONObject2.putOpt("size", apkDetail.size);
                        jSONObject2.putOpt("need_network", apkDetail.need_network);
                        jSONObject2.putOpt("need_inner_buy", apkDetail.need_inner_buy);
                        jSONObject2.putOpt("authority_url", apkDetail.authority_url);
                        jSONObject2.putOpt("privacy_url", apkDetail.privacy_url);
                        jSONObject2.putOpt("pkg_source", apkDetail.pkg_source);
                        jSONObject2.putOpt("app_effect", apkDetail.app_effect);
                        jSONObject.putOpt("apk_detail", jSONObject2);
                    }
                } catch (JSONException unused) {
                    DefaultLog.getInstance().i("DownloadMultiInfoDbMana", "convertToDbDetailInfoData 解析json异常");
                    if (BdLog.isDebugMode()) {
                        Log.e("DownloadMultiInfoDbMana", "convertToDbDetailInfoData 解析json异常");
                    }
                }
                str = jSONObject.toString();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final int b(p41 model) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, model)) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            return new h41(TiebaDatabase.getInstance().getMainDBDatabaseManager().f()).delete(model, new g41[0]);
        }
        return invokeL.intValue;
    }

    public final int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            h41 h41Var = new h41(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            vfa vfaVar = new vfa();
            vfaVar.k(i);
            return h41Var.delete(vfaVar, (g41[]) Arrays.copyOf(new g41[]{xfa.l}, 1));
        }
        return invokeI.intValue;
    }

    public final int delete(DownloadData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            h41 h41Var = new h41(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            vfa vfaVar = new vfa();
            vfaVar.i(data.getUrl());
            return h41Var.delete(vfaVar, (g41[]) Arrays.copyOf(new g41[]{xfa.o}, 1));
        }
        return invokeL.intValue;
    }

    public final int j(vfa downloadMultiInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, downloadMultiInfo)) == null) {
            Intrinsics.checkNotNullParameter(downloadMultiInfo, "downloadMultiInfo");
            return new h41(TiebaDatabase.getInstance().getMainDBDatabaseManager().f()).update(downloadMultiInfo, (g41[]) Arrays.copyOf(new g41[]{xfa.l}, 1));
        }
        return invokeL.intValue;
    }

    public final q41 d(q41 q41Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, q41Var, str, str2)) == null) {
            if (!StringsKt__StringsJVMKt.isBlank(str)) {
                g41 g41Var = xfa.q;
                q41Var.a("m", g41Var, " = '" + str + '\'');
            } else if (!StringsKt__StringsJVMKt.isBlank(str2)) {
                g41 g41Var2 = xfa.p;
                q41Var.a("m", g41Var2, " = '" + str2 + '\'');
            }
            return q41Var;
        }
        return (q41) invokeLLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final List<vfa> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            h41 h41Var = new h41(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            u41 f = u41.f();
            g41[] d = new vfa().b().d();
            f.a("m", (g41[]) Arrays.copyOf(d, d.length));
            f.d("m", vfa.class);
            Cursor query = h41Var.query(f);
            Intrinsics.checkNotNullExpressionValue(query, "dataSource.query(query)");
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                try {
                    vfa vfaVar = new vfa();
                    n41.b(vfaVar, query);
                    arrayList.add(vfaVar);
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final List<vfa> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            h41 h41Var = new h41(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            u41 f = u41.f();
            g41[] d = new vfa().b().d();
            f.a("m", (g41[]) Arrays.copyOf(d, d.length));
            f.d("m", vfa.class);
            f.h(xfa.n, "is not null");
            Cursor query = h41Var.query(f);
            Intrinsics.checkNotNullExpressionValue(query, "dataSource.query(query)");
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                try {
                    vfa vfaVar = new vfa();
                    n41.b(vfaVar, query);
                    arrayList.add(vfaVar);
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final vfa f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            h41 h41Var = new h41(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            u41 f = u41.f();
            g41[] d = new vfa().b().d();
            f.a("m", (g41[]) Arrays.copyOf(d, d.length));
            f.d("m", vfa.class);
            g41 g41Var = xfa.l;
            f.h(g41Var, " = " + i);
            Cursor query = h41Var.query(f);
            Intrinsics.checkNotNullExpressionValue(query, "dataSource.query(query)");
            try {
                if (query.moveToNext()) {
                    vfa vfaVar = new vfa();
                    n41.b(vfaVar, query);
                    CloseableKt.closeFinally(query, null);
                    return vfaVar;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(query, null);
                return null;
            } finally {
            }
        } else {
            return (vfa) invokeI.objValue;
        }
    }

    public final long insert(DownloadData data) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
            h41 h41Var = new h41(f);
            f.beginTransaction();
            vfa vfaVar = new vfa();
            vfaVar.n(System.currentTimeMillis());
            vfaVar.i(data.getUrl());
            vfaVar.o(data.getId());
            vfaVar.h(a(data.getItemData()));
            vfaVar.m(data.getSource());
            ItemData itemData = data.getItemData();
            String str2 = null;
            if (itemData != null) {
                str = itemData.packageName;
            } else {
                str = null;
            }
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                ItemData itemData2 = data.getItemData();
                if (itemData2 != null) {
                    str2 = itemData2.packageName;
                }
                vfaVar.l(str2);
            } else {
                ItemData itemData3 = data.getItemData();
                if (itemData3 != null) {
                    str2 = itemData3.pkgName;
                }
                vfaVar.l(str2);
            }
            try {
                long insert = h41Var.insert(vfaVar);
                f.setTransactionSuccessful();
                return insert;
            } finally {
                f.endTransaction();
            }
        }
        return invokeL.longValue;
    }

    public final int k(DownloadData data) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            h41 h41Var = new h41(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            vfa vfaVar = new vfa();
            vfaVar.j(System.currentTimeMillis());
            vfaVar.i(data.getUrl());
            ItemData itemData = data.getItemData();
            if (itemData != null) {
                String str = itemData.packageName;
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    vfaVar.l(itemData.packageName);
                }
            }
            return h41Var.update(vfaVar, (g41[]) Arrays.copyOf(new g41[]{xfa.o}, 1));
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final vfa h(String title, String pkgName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, title, pkgName)) == null) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(pkgName, "pkgName");
            h41 h41Var = new h41(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            u41 f = u41.f();
            g41[] d = new vfa().b().d();
            f.a("m", (g41[]) Arrays.copyOf(d, d.length));
            f.c("m", new vfa());
            q41 condition = f.h(xfa.n, "is not null");
            Intrinsics.checkNotNullExpressionValue(condition, "condition");
            d(condition, title, pkgName);
            Cursor query = h41Var.query(f);
            Intrinsics.checkNotNullExpressionValue(query, "dataSource.query(query)");
            vfa vfaVar = new vfa();
            try {
                if (query.moveToFirst()) {
                    n41.b(vfaVar, query);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(query, null);
                return vfaVar;
            } finally {
            }
        } else {
            return (vfa) invokeLL.objValue;
        }
    }

    public final long i(DownloadData data) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
            h41 h41Var = new h41(f);
            f.beginTransaction();
            vfa vfaVar = new vfa();
            vfaVar.o(data.getId());
            try {
                if (!h41Var.query(vfaVar, (g41[]) Arrays.copyOf(new g41[]{xfa.q}, 1))) {
                    j = insert(data);
                } else {
                    j = -1;
                }
                h41Var.setTransactionSuccessful();
                return j;
            } finally {
                h41Var.endTransaction();
            }
        }
        return invokeL.longValue;
    }
}
