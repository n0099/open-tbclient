package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ib5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return "reply_7_times.mp4";
                    }
                    return "post_7_times.mp4";
                }
                return "reply_1_times.mp4";
            }
            return "post_1_times.mp4";
        }
        return (String) invokeI.objValue;
    }

    public static boolean a(IconStampData iconStampData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iconStampData)) == null) {
            if (iconStampData == null) {
                return false;
            }
            String c = c(iconStampData.stampType);
            if (TextUtils.isEmpty(c)) {
                return false;
            }
            File file = new File(am.b(c));
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get(c)) || !file.exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(boolean z) {
        String c;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            if (z) {
                c = c(1);
                c2 = c(3);
            } else {
                c = c(2);
                c2 = c(4);
            }
            if (!TextUtils.isEmpty(c) && !TextUtils.isEmpty(c2)) {
                String str = BdBaseApplication.getInst().getResHashMap().get(c2);
                if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get(c)) || StringUtils.isNull(str)) {
                    RequestParams requestParams = new RequestParams();
                    requestParams.setRunType(wl.a);
                    requestParams.setRunNode("aps");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("com.baidu.tieba.resloader." + c);
                    arrayList.add("com.baidu.tieba.resloader." + c2);
                    requestParams.addChannel(new vl(arrayList, (DefaultDownloadCallback) null));
                    PmsManager.getInstance().execute(requestParams);
                }
            }
        }
    }
}
