package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.friendList;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes6.dex */
public class h76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<ef5> b;

    public h76() {
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

    public List<ef5> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public void c(listData listdata) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, listdata) == null) && listdata != null) {
            this.a = listdata.key;
            if (listdata.friend_list != null) {
                this.b = new ArrayList();
                for (friendList friendlist : listdata.friend_list) {
                    ef5 ef5Var = new ef5();
                    ef5Var.i(friendlist);
                    ef5Var.j(this.a);
                    this.b.add(ef5Var);
                }
            }
        }
    }

    public void d(robotsList robotslist) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, robotslist) == null) && robotslist != null) {
            this.a = robotslist.key;
            if (robotslist.friend_list != null) {
                this.b = new ArrayList();
                for (friendList friendlist : robotslist.friend_list) {
                    ef5 ef5Var = new ef5();
                    ef5Var.i(friendlist);
                    ef5Var.j(this.a);
                    this.b.add(ef5Var);
                }
            }
        }
    }
}
