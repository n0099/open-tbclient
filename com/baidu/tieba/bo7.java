package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.RouterService;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bo7 implements RouterService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public boolean invokeSchemeWithCallBack(Context context, Uri uri, String str, RouterService.LiveShowSchemeCallBack liveShowSchemeCallBack) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, uri, str, liveShowSchemeCallBack)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public bo7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (!StringUtils.isNull(str)) {
                if (str.contains("com.baidu.tieba.unidispatch://pwStatisticalLog?")) {
                    c(Uri.parse(str));
                    return true;
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_MESSAGE_CENTER_PAGE)) {
                    UrlSchemaJumpHelper.jumpMessageCenterPage(context, str);
                    return true;
                } else if (str.startsWith("com.baidu.tieba://unidispatch/GameGodsDetailPage")) {
                    UrlSchemaJumpHelper.jumpGameGodsPage(context, str);
                    return true;
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_DISPATCH_PAGE)) {
                    UrlSchemaJumpHelper.jumpDispatchOrderPage(context, str);
                    return true;
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_UNPAID_PAGE)) {
                    UrlSchemaJumpHelper.jumpUnPaidOrderPage(context, str);
                    return true;
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_UNPAID_LIST_PAGE)) {
                    UrlSchemaJumpHelper.jumpUnPaidListPage(context, str);
                    return true;
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_GAME_PLAY_PERSON_CHAT)) {
                    UrlSchemaJumpHelper.jumpPersonChat(context, str, true);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) != null) || StringUtils.isNull(str) || a(context, str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append(WebViewBroadcastReceiver.INTENT_LOCALE_RECEV_CLOSE);
        sb.append("=1");
        sb.append("&page_from=live");
        String sb2 = sb.toString();
        Activity b = n9.g().b();
        if (b != null && (x9.a(b) instanceof TbPageContext)) {
            UrlManager.getInstance().dealOneLink((TbPageContext) x9.a(b), new String[]{sb2}, true);
        } else if (sb2.startsWith(BdUniDispatchSchemeController.SCHEME)) {
            UtilHelper.dealOneScheme(context, sb2);
        }
    }

    public final void c(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri) != null) || uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("key");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(queryParameter);
        for (String str : uri.getQueryParameterNames()) {
            if (!TextUtils.equals(str, "key")) {
                statisticItem.addParam(str, uri.getQueryParameter(str));
            }
        }
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public void openScheme(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && !StringUtils.isNull(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append(WebViewBroadcastReceiver.INTENT_LOCALE_RECEV_CLOSE);
            sb.append("=1");
            sb.append("&page_from=live");
            Activity b = n9.g().b();
            if (b != null) {
                UrlManager.getInstance().dealOneLink((TbPageContext) x9.a(b), new String[]{sb.toString()}, true);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public void invoke(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            b(context, str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public void invokeScheme(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
            b(context, str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public boolean invokeScheme(Uri uri, String str, RouterService.LiveShowSchemeCallBack liveShowSchemeCallBack) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, uri, str, liveShowSchemeCallBack)) == null) {
            openScheme(uri.toString());
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
