package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.android.imsdk.internal.Constants;
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
public final class hu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947836256, "Lcom/baidu/tieba/hu6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947836256, "Lcom/baidu/tieba/hu6;");
        }
    }

    public hu6() {
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
                        jSONObject.putOpt("tags", new JSONArray((Collection) itemData.mTags));
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

    public final int b(DownloadData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            lz0 lz0Var = new lz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            rna rnaVar = new rna();
            rnaVar.i(data.getUrl());
            return lz0Var.e(rnaVar, (kz0[]) Arrays.copyOf(new kz0[]{tna.o}, 1));
        }
        return invokeL.intValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            lz0 lz0Var = new lz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            rna rnaVar = new rna();
            rnaVar.k(i);
            return lz0Var.e(rnaVar, (kz0[]) Arrays.copyOf(new kz0[]{tna.l}, 1));
        }
        return invokeI.intValue;
    }

    public final int l(rna downloadMultiInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, downloadMultiInfo)) == null) {
            Intrinsics.checkNotNullParameter(downloadMultiInfo, "downloadMultiInfo");
            return new lz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f()).f(downloadMultiInfo, (kz0[]) Arrays.copyOf(new kz0[]{tna.l}, 1));
        }
        return invokeL.intValue;
    }

    public final int c(tz0 model) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, model)) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            return new lz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f()).e(model, new kz0[0]);
        }
        return invokeL.intValue;
    }

    public final uz0 e(uz0 uz0Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, uz0Var, str, str2)) == null) {
            if (!StringsKt__StringsJVMKt.isBlank(str)) {
                kz0 kz0Var = tna.q;
                uz0Var.a("m", kz0Var, " = '" + str + '\'');
            } else if (!StringsKt__StringsJVMKt.isBlank(str2)) {
                kz0 kz0Var2 = tna.p;
                uz0Var.a("m", kz0Var2, " = '" + str2 + '\'');
            }
            return uz0Var;
        }
        return (uz0) invokeLLL.objValue;
    }

    public final long f(DownloadData data) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
            lz0 lz0Var = new lz0(f);
            f.beginTransaction();
            rna rnaVar = new rna();
            rnaVar.n(System.currentTimeMillis());
            rnaVar.i(data.getUrl());
            rnaVar.o(data.getId());
            rnaVar.h(a(data.getItemData()));
            rnaVar.m(data.getSource());
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
                rnaVar.l(str2);
            } else {
                ItemData itemData3 = data.getItemData();
                if (itemData3 != null) {
                    str2 = itemData3.pkgName;
                }
                rnaVar.l(str2);
            }
            try {
                long c = lz0Var.c(rnaVar);
                f.setTransactionSuccessful();
                return c;
            } finally {
                f.endTransaction();
            }
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final rna h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            lz0 lz0Var = new lz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            yz0 f = yz0.f();
            kz0[] d = new rna().b().d();
            f.a("m", (kz0[]) Arrays.copyOf(d, d.length));
            f.d("m", rna.class);
            kz0 kz0Var = tna.l;
            f.h(kz0Var, " = " + i);
            Cursor d2 = lz0Var.d(f);
            Intrinsics.checkNotNullExpressionValue(d2, "dataSource.query(query)");
            try {
                if (d2.moveToNext()) {
                    rna rnaVar = new rna();
                    rz0.b(rnaVar, d2);
                    CloseableKt.closeFinally(d2, null);
                    return rnaVar;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(d2, null);
                return null;
            } finally {
            }
        } else {
            return (rna) invokeI.objValue;
        }
    }

    public final int m(DownloadData data) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            lz0 lz0Var = new lz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            rna rnaVar = new rna();
            rnaVar.j(System.currentTimeMillis());
            rnaVar.i(data.getUrl());
            ItemData itemData = data.getItemData();
            if (itemData != null) {
                String str = itemData.packageName;
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    rnaVar.l(itemData.packageName);
                }
            }
            return lz0Var.f(rnaVar, (kz0[]) Arrays.copyOf(new kz0[]{tna.o}, 1));
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final List<rna> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            lz0 lz0Var = new lz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            yz0 f = yz0.f();
            kz0[] d = new rna().b().d();
            f.a("m", (kz0[]) Arrays.copyOf(d, d.length));
            f.d("m", rna.class);
            Cursor d2 = lz0Var.d(f);
            Intrinsics.checkNotNullExpressionValue(d2, "dataSource.query(query)");
            ArrayList arrayList = new ArrayList();
            while (d2.moveToNext()) {
                try {
                    rna rnaVar = new rna();
                    rz0.b(rnaVar, d2);
                    arrayList.add(rnaVar);
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(d2, null);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final List<rna> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            lz0 lz0Var = new lz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            yz0 f = yz0.f();
            kz0[] d = new rna().b().d();
            f.a("m", (kz0[]) Arrays.copyOf(d, d.length));
            f.d("m", rna.class);
            f.h(tna.n, "is not null");
            Cursor d2 = lz0Var.d(f);
            Intrinsics.checkNotNullExpressionValue(d2, "dataSource.query(query)");
            ArrayList arrayList = new ArrayList();
            while (d2.moveToNext()) {
                try {
                    rna rnaVar = new rna();
                    rz0.b(rnaVar, d2);
                    arrayList.add(rnaVar);
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(d2, null);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final rna j(String title, String pkgName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, title, pkgName)) == null) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(pkgName, "pkgName");
            lz0 lz0Var = new lz0(TiebaDatabase.getInstance().getMainDBDatabaseManager().f());
            yz0 f = yz0.f();
            kz0[] d = new rna().b().d();
            f.a("m", (kz0[]) Arrays.copyOf(d, d.length));
            f.c("m", new rna());
            uz0 condition = f.h(tna.n, "is not null");
            Intrinsics.checkNotNullExpressionValue(condition, "condition");
            e(condition, title, pkgName);
            Cursor d2 = lz0Var.d(f);
            Intrinsics.checkNotNullExpressionValue(d2, "dataSource.query(query)");
            rna rnaVar = new rna();
            try {
                if (d2.moveToFirst()) {
                    rz0.b(rnaVar, d2);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(d2, null);
                return rnaVar;
            } finally {
            }
        } else {
            return (rna) invokeLL.objValue;
        }
    }

    public final long k(DownloadData data) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
            lz0 lz0Var = new lz0(f);
            f.beginTransaction();
            rna rnaVar = new rna();
            rnaVar.o(data.getId());
            try {
                if (!lz0Var.b(rnaVar, (kz0[]) Arrays.copyOf(new kz0[]{tna.q}, 1))) {
                    j = f(data);
                } else {
                    j = -1;
                }
                lz0Var.setTransactionSuccessful();
                return j;
            } finally {
                lz0Var.endTransaction();
            }
        }
        return invokeL.longValue;
    }
}
