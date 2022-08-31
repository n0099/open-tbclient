package com.baidu.tieba;

import android.app.Activity;
import android.view.ViewGroup;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DownloadData downloadData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, downloadData) == null) || (currentActivity = TbadkApplication.getInst().getCurrentActivity()) == null || currentActivity.isDestroyed()) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
        bdTopToast.h(false);
        bdTopToast.g(currentActivity.getString(R.string.obfuscated_res_0x7f0f0989));
        bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
    }

    public static void b(DownloadData downloadData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, downloadData) == null) || (currentActivity = TbadkApplication.getInst().getCurrentActivity()) == null || currentActivity.isDestroyed()) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
        bdTopToast.h(false);
        bdTopToast.g(currentActivity.getString(R.string.obfuscated_res_0x7f0f098b));
        bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
    }

    public static void c(DownloadData downloadData) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, downloadData) == null) || (currentActivity = TbadkApplication.getInst().getCurrentActivity()) == null || currentActivity.isDestroyed()) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
        bdTopToast.h(true);
        bdTopToast.g(currentActivity.getString(R.string.obfuscated_res_0x7f0f0990));
        bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
    }
}
