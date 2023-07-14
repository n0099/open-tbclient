package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class aq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(qp9 qp9Var, TbPageContext<?> tbPageContext) {
        Uri parse;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, qp9Var, tbPageContext) == null) && qp9Var != null && tbPageContext != null) {
            int i = qp9Var.l;
            boolean z = false;
            if (i == 1) {
                if (!TextUtils.isEmpty(qp9Var.f)) {
                    UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{qp9Var.f});
                }
            } else if (i == 2) {
                if (!TextUtils.isEmpty(qp9Var.f) && (parse = Uri.parse(qp9Var.f)) != null) {
                    String queryParameter = parse.getQueryParameter("paramfromna");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        qp9Var.f = b(qp9Var.f, queryParameter);
                    }
                    if ("1".equalsIgnoreCase(parse.getQueryParameter("fixtitle"))) {
                        str = parse.getQueryParameter("title");
                        z = true;
                    } else {
                        str = "";
                    }
                    nx4.E(z, tbPageContext.getPageActivity(), str, qp9Var.f);
                }
            } else if (i == 3 && !TextUtils.isEmpty(qp9Var.f)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, qp9Var.f));
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
                    return ws5.g(sb.toString());
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
