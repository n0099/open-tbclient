package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gg9 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final se9 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gg9(MainTabActivity mainTabActivity, se9 se9Var) {
        super(2921728);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, se9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = se9Var;
        setPriority(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        se9 se9Var;
        MainTabActivity mainTabActivity;
        ch9 B1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921728 && (se9Var = this.b) != null && se9Var.y() != null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            BdUniqueId bdUniqueId = null;
            if (currentActivity instanceof BdBaseFragmentActivity) {
                bdUniqueId = ((BdBaseFragmentActivity) currentActivity).getUniqueId();
            }
            if (getTag() == bdUniqueId && (mainTabActivity = this.a) != null && (B1 = mainTabActivity.B1()) != null) {
                B1.a();
            }
        }
    }
}
