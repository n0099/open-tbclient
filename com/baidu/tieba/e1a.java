package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class e1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    public e1a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        MessageManager.getInstance().registerStickyMode(2921453);
    }

    public void a(Intent intent, a1a a1aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, intent, a1aVar) != null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.PUSH_DES_PAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            String string = this.a.getString(R.string.des_page_home_recommend);
            u35 u35Var = new u35();
            Matcher matcher = Pattern.compile(UrlSchemaHelper.PB_URL).matcher(intent.getStringExtra("target_scheme"));
            int i = 1;
            if (matcher.find()) {
                u35Var.c = matcher.group(1);
            }
            if (stringExtra.equals(string)) {
                u35Var.a = 1;
            } else {
                u35Var.a = 2;
                u35Var.b = stringExtra;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921453, u35Var));
            if (stringExtra.equals(string)) {
                intent.putExtra("sub_locate_type", 1);
                i = 2;
            } else {
                intent.putExtra("sub_locate_type", stringExtra);
            }
            if (a1aVar != null && a1aVar.y() != null) {
                a1aVar.y().setCurrentTabByType(i);
                FragmentTabHost.c h = a1aVar.y().h(i);
                if (h != null) {
                    Fragment fragment = h.c;
                    if (fragment instanceof h05) {
                        ((h05) fragment).t1(intent);
                    }
                }
            }
        }
        intent.removeExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION);
        intent.removeExtra(MainTabActivityConfig.PUSH_DES_PAGE);
    }

    public boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            if (intent.getIntExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION, 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
