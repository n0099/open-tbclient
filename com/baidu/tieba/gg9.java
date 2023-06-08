package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class gg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public gg9(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = z;
    }

    public PersonStatus g(UserData userData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, userData)) == null) {
            if (userData == null) {
                if (this.a) {
                    return PersonStatus.HOST_DEFAULT;
                }
                return PersonStatus.GUEST_DEFAULT;
            } else if (userData.isBaijiahaoUser()) {
                if (this.a) {
                    return PersonStatus.HOST_BJH;
                }
                return PersonStatus.GUEST_BJH;
            } else if (this.a) {
                return PersonStatus.HOST_DEFAULT;
            } else {
                return PersonStatus.GUEST_DEFAULT;
            }
        }
        return (PersonStatus) invokeL.objValue;
    }

    public PersonStatus h(ng9 ng9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ng9Var)) == null) {
            if (ng9Var != null && ng9Var.j() != null) {
                return g(ng9Var.j());
            }
            if (this.a) {
                return PersonStatus.HOST_DEFAULT;
            }
            return PersonStatus.GUEST_DEFAULT;
        }
        return (PersonStatus) invokeL.objValue;
    }
}
