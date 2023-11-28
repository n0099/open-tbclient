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
/* loaded from: classes6.dex */
public class fy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, pva pvaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, pvaVar)) == null) {
            boolean z = false;
            if (context != null && pvaVar != null && pvaVar.b()) {
                TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
                TiebaPlusInfo a = pvaVar.a();
                if (a == null) {
                    return false;
                }
                tiePlusHelper.S(a.app_id);
                tiePlusHelper.T(a.title);
                z = true;
                tiePlusHelper.a0(true);
                tiePlusHelper.Y(a.download_url);
                tiePlusHelper.c0(a.app_package);
                tiePlusHelper.d0(a.app_power);
                tiePlusHelper.e0(a.app_privacy);
                tiePlusHelper.Z(a.app_effect);
                wy5 wy5Var = new wy5(context, tiePlusHelper, true);
                tiePlusHelper.W(wy5Var);
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
                tiePlusHelper.b0(itemData);
                tiePlusHelper.X(downloadData);
                wy5Var.g(a.app_company);
                wy5Var.h(a.app_icon);
                wy5Var.i(a.title);
                wy5Var.j(a.app_version);
                wy5Var.show();
            }
            return z;
        }
        return invokeLL.booleanValue;
    }
}
