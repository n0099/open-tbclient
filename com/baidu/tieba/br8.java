package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class br8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65536, null, activity) != null) || activity == null) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (!(findViewById instanceof ViewGroup)) {
            return;
        }
        new BdTopToast(activity, 3000).setIcon(true).setContent(TbadkCoreApplication.getInst().getString(R.string.chat_msg_gone_top_excellent_tips)).show((ViewGroup) findViewById);
    }

    public static void b(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, activity) != null) || activity == null) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (!(findViewById instanceof ViewGroup)) {
            return;
        }
        new BdTopToast(activity, 3000).setIcon(true).setContent(TbadkCoreApplication.getInst().getString(R.string.add_group_success_toast)).show((ViewGroup) findViewById);
    }

    public static void c(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, activity) != null) || activity == null) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (!(findViewById instanceof ViewGroup)) {
            return;
        }
        new BdTopToast(activity, 3000).setIcon(true).setContent(TbadkCoreApplication.getInst().getString(R.string.delete_group_success_toast)).show((ViewGroup) findViewById);
    }
}
