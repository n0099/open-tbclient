package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.ApkDetail;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
public class dw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, qda qdaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, qdaVar)) == null) {
            boolean z = false;
            if (context != null && qdaVar != null && qdaVar.b()) {
                TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
                TiebaPlusInfo a = qdaVar.a();
                if (a == null) {
                    return false;
                }
                tiePlusHelper.Q(a.app_id);
                tiePlusHelper.R(a.title);
                z = true;
                tiePlusHelper.Z(true);
                tiePlusHelper.W(a.download_url);
                tiePlusHelper.b0(a.app_package);
                tiePlusHelper.c0(a.app_power);
                tiePlusHelper.d0(a.app_privacy);
                tiePlusHelper.Y(a.app_effect);
                uw5 uw5Var = new uw5(context, tiePlusHelper, true);
                tiePlusHelper.U(uw5Var);
                ItemData itemData = new ItemData();
                itemData.parseProto(a);
                itemData.fileType = "app";
                StringBuilder sb = new StringBuilder();
                sb.append(itemData.pkgName);
                sb.append(".v");
                ApkDetail apkDetail = itemData.apkDetail;
                if (apkDetail != null) {
                    sb.append(apkDetail.version);
                }
                DownloadData downloadData = new DownloadData(sb.toString());
                downloadData.setUrl(itemData.buttonLink);
                downloadData.setName(itemData.mTitle);
                downloadData.setSource(2);
                downloadData.setType(12);
                downloadData.setItemData(itemData);
                tiePlusHelper.a0(itemData);
                tiePlusHelper.V(downloadData);
                uw5Var.g(a.app_company);
                uw5Var.h(a.app_icon);
                uw5Var.i(a.title);
                uw5Var.j(a.app_version);
                uw5Var.show();
            }
            return z;
        }
        return invokeLL.booleanValue;
    }
}
