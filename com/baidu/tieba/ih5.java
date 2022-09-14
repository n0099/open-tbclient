package com.baidu.tieba;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ih5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str == null) {
                return Boolean.FALSE;
            }
            String c = fi5.c(str, "topic_id=");
            String c2 = fi5.c(str, "topic_name=");
            String c3 = fi5.c(str, "customfullscreen=");
            String c4 = fi5.c(str, "nonavigationbar=");
            if ((c != null || c2 != null) && StringHelper.equals(c3, "1") && StringHelper.equals(c4, "1")) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }

    public static Boolean b(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) {
            if (uri != null && uri.toString() != null) {
                if (fi5.c(uri.toString(), "source=").contains("hottopic_detail_hybrid")) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? fi5.c(str, "topic_id=") : (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? fi5.c(str, "hottopic_detail_hybrid-") : (String) invokeL.objValue;
    }

    public static void e(TbPageContext tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, str, str2) == null) || tbPageContext == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("https://tieba.baidu.com/mo/q/newtopic/topicTemplate?");
        sb.append("customfullscreen=");
        sb.append("1");
        sb.append("&nonavigationbar=");
        sb.append("1");
        sb.append("&from=");
        sb.append("1");
        if (str != null) {
            sb.append("&topic_id=");
            sb.append(str);
        }
        if (str2 != null) {
            sb.append("&topic_name=");
            sb.append(str2);
        }
        sb.append("&skin=");
        sb.append(SkinManager.getCurrentSkinTypeString());
        UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{sb.toString()});
    }
}
