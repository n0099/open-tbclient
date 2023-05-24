package com.baidu.tbadk.dispatcher;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tieba.hi9;
import com.baidu.tieba.mr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OneKeySignDispatcher implements hi9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PREFIX = "com.baidu.tieba://unidispatch/onekeysign";
    public transient /* synthetic */ FieldHolder $fh;

    public OneKeySignDispatcher() {
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

    @Override // com.baidu.tieba.hi9
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) {
            if (TbadkCoreApplication.isLogin()) {
                SignAllForumActivityConfig signAllForumActivityConfig = new SignAllForumActivityConfig(context);
                signAllForumActivityConfig.setUri(Uri.parse(PREFIX));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, signAllForumActivityConfig));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(1)));
            }
            mr4.w().M(true);
        }
    }
}
