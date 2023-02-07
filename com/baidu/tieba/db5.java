package com.baidu.tieba;

import android.app.Activity;
import android.view.ViewGroup;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class db5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DownloadData downloadData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, downloadData) == null) && (currentActivity = TbadkApplication.getInst().getCurrentActivity()) != null && !currentActivity.isDestroyed()) {
            BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
            bdTopToast.h(false);
            bdTopToast.g(currentActivity.getString(R.string.item_download_fail));
            bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
        }
    }

    public static void b(DownloadData downloadData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, downloadData) == null) && (currentActivity = TbadkApplication.getInst().getCurrentActivity()) != null && !currentActivity.isDestroyed()) {
            BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
            bdTopToast.h(false);
            bdTopToast.g(currentActivity.getString(R.string.item_download_no_net));
            bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
        }
    }

    public static void c(DownloadData downloadData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, downloadData) == null) && (currentActivity = TbadkApplication.getInst().getCurrentActivity()) != null && !currentActivity.isDestroyed()) {
            BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
            bdTopToast.h(true);
            bdTopToast.g(currentActivity.getString(R.string.item_download_success));
            bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
        }
    }
}
