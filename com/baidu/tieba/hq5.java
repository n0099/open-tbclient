package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hq5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public static String b = null;
    public static String c = null;
    public static String d = "floor";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947832381, "Lcom/baidu/tieba/hq5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947832381, "Lcom/baidu/tieba/hq5;");
        }
    }

    public static void a(String str, String str2, String str3, int i, x9 x9Var, BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, str2, str3, Integer.valueOf(i), x9Var, baijiahaoData}) == null) {
            b = str;
            c = str2;
            a = str3;
            if (!StringUtils.isNull(str3) && x9Var != null && x9Var.getPageActivity() != null) {
                if (d.equals(a)) {
                    SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(x9Var.getPageActivity()).createSubPbActivityConfig(b, c, "search_post", true);
                    createSubPbActivityConfig.setKeyPageStartFrom(8);
                    createSubPbActivityConfig.setBjhData(baijiahaoData);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                    return;
                }
                PbActivityConfig createNormalCfg = new PbActivityConfig(x9Var.getPageActivity()).createNormalCfg(b, c, "search_post");
                createNormalCfg.setStartFrom(8);
                createNormalCfg.setBjhData(baijiahaoData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            }
        }
    }
}
