package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class g29 implements ec5 {
    public static /* synthetic */ Interceptable $ic;
    public static g29 a;
    public transient /* synthetic */ FieldHolder $fh;

    public g29() {
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

    public static synchronized g29 d() {
        InterceptResult invokeV;
        g29 g29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (g29.class) {
                if (a == null) {
                    a = new g29();
                }
                g29Var = a;
            }
            return g29Var;
        }
        return (g29) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                SapiAccountManager.getInstance().logout();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ec5
    public void b(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountData) == null) {
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            if (!TextUtils.isEmpty(accountData.getID()) && loginAccounts != null && loginAccounts.size() > 0) {
                for (SapiAccount sapiAccount : loginAccounts) {
                    if (accountData.getID().equals(sapiAccount.uid)) {
                        SapiAccountManager.getInstance().validate(sapiAccount);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ec5
    public void c(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
            if (accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) {
                SapiAccountManager.getInstance().logout();
                return;
            }
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            if (loginAccounts != null && loginAccounts.size() > 0) {
                for (SapiAccount sapiAccount : loginAccounts) {
                    if (accountData.getID().equals(sapiAccount.uid)) {
                        SapiAccountManager.getInstance().removeLoginAccount(sapiAccount);
                        return;
                    }
                }
            }
        }
    }
}
