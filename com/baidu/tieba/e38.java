package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e38 implements as4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.as4
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbConfig.FOLLOW_ADDRESS : (String) invokeV.objValue;
    }

    public e38() {
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

    @Override // com.baidu.tieba.as4
    public void b(HashMap<String, String> hashMap, bs4 bs4Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap, bs4Var) == null) && bs4Var != null && hashMap != null && !hashMap.isEmpty()) {
            UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
            aVar.a = bs4Var.a;
            aVar.b = bs4Var.c;
            aVar.d = true;
            if (hashMap.get("touid") == null) {
                str = "";
            } else {
                str = hashMap.get("touid");
            }
            aVar.c = str;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new UpdateAttentionMessage(aVar));
        }
    }
}
