package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bea implements q85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public aea a;

    public bea() {
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

    @Override // com.baidu.tieba.q85
    public Class<?> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return MainTabActivity.class;
        }
        return (Class) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q85
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return MainTabActivity.class.getName();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q85
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            aea aeaVar = this.a;
            if (aeaVar != null) {
                return aeaVar.getCurrentTabType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.q85
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                b(context, 1);
            } else {
                b(context, 0);
            }
        }
    }

    public void g(aea aeaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aeaVar) == null) {
            this.a = aeaVar;
        }
    }

    @Override // com.baidu.tieba.q85
    public void b(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i)));
        }
    }

    @Override // com.baidu.tieba.q85
    public void c(Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i, z)));
        }
    }

    @Override // com.baidu.tieba.q85
    public void e(Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
        }
    }
}
