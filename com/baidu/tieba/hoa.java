package com.baidu.tieba;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hoa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@NonNull String str, @NonNull ShareItem shareItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, shareItem)) == null) {
            Boolean checkOutsideForbidShare = shareItem.checkOutsideForbidShare(str);
            if (checkOutsideForbidShare.booleanValue()) {
                b(shareItem);
            }
            return checkOutsideForbidShare.booleanValue();
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, intent)) == null) {
            try {
                if (!(context instanceof Activity) && intent != null) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void b(@NonNull ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, shareItem) == null) {
            String forbidShareTplText = shareItem.getForbidShareTplText();
            String forbidShareToast = shareItem.getForbidShareToast();
            String shareToken = shareItem.getShareToken();
            if (!TextUtils.isEmpty(shareToken) && !TextUtils.isEmpty(forbidShareTplText)) {
                if (forbidShareTplText.contains("{{token}}")) {
                    forbidShareTplText = forbidShareTplText.replace("{{token}}", shareToken);
                }
                UtilHelper.copyToClipBoard(forbidShareTplText);
                if (!TextUtils.isEmpty(forbidShareToast)) {
                    BdToast.makeText(TbadkApplication.getInst().getContext(), forbidShareToast).show();
                }
            }
        }
    }

    public static synchronized String c(Context context) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (hoa.class) {
                try {
                    string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return string;
        }
        return (String) invokeL.objValue;
    }
}
