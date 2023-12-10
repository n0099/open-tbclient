package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(y8a y8aVar, TbPageContext<?> tbPageContext) {
        Uri parse;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, y8aVar, tbPageContext) == null) && y8aVar != null && tbPageContext != null) {
            int i = y8aVar.l;
            boolean z = false;
            if (i == 1) {
                if (!TextUtils.isEmpty(y8aVar.f)) {
                    UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{y8aVar.f});
                }
            } else if (i == 2) {
                if (!TextUtils.isEmpty(y8aVar.f) && (parse = Uri.parse(y8aVar.f)) != null) {
                    String queryParameter = parse.getQueryParameter("paramfromna");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        y8aVar.f = b(y8aVar.f, queryParameter);
                    }
                    if ("1".equalsIgnoreCase(parse.getQueryParameter("fixtitle"))) {
                        str = parse.getQueryParameter("title");
                        z = true;
                    } else {
                        str = "";
                    }
                    BrowserHelper.startWebActivity(z, tbPageContext.getPageActivity(), str, y8aVar.f);
                }
            } else if (i == 3 && !TextUtils.isEmpty(y8aVar.f)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, y8aVar.f));
            }
        }
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str2) && (split = str2.split("#")) != null) {
                StringBuilder sb = new StringBuilder(str);
                boolean z = false;
                for (String str3 : split) {
                    if ("skin".equalsIgnoreCase(str3)) {
                        sb.append("&skin=");
                        sb.append(SkinManager.getCurrentSkinTypeString());
                    } else if ("user_id".equalsIgnoreCase(str3)) {
                        sb.append("&user_id=");
                        sb.append(TbadkCoreApplication.getCurrentAccountId());
                    } else if ("comparams".equalsIgnoreCase(str3)) {
                        z = true;
                    }
                }
                if (z) {
                    return to5.e(sb.toString());
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
