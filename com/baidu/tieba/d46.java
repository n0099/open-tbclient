package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.DataRes;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes5.dex */
public class d46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<h46> a;
    public List<h46> b;

    public d46() {
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

    public List<h46> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final boolean b(List<h46> list, bb5 bb5Var) {
        InterceptResult invokeLL;
        List<bb5> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, bb5Var)) == null) {
            if (list != null && bb5Var != null) {
                for (h46 h46Var : list) {
                    if (h46Var != null && (a = h46Var.a()) != null) {
                        for (bb5 bb5Var2 : a) {
                            if (bb5Var2 != null && bb5Var2.d() == bb5Var.d()) {
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean c(DataRes dataRes) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes)) == null) {
            if (dataRes != null && dataRes.robots_list != null) {
                this.b = new ArrayList();
                z = false;
                for (robotsList robotslist : dataRes.robots_list) {
                    if (TextUtils.isEmpty(robotslist.key)) {
                        z = true;
                    } else {
                        h46 h46Var = new h46();
                        h46Var.d(robotslist);
                        this.b.add(h46Var);
                    }
                }
            } else {
                z = false;
            }
            if (dataRes != null && dataRes.address_list != null) {
                this.a = new ArrayList();
                for (listData listdata : dataRes.address_list) {
                    if (TextUtils.isEmpty(listdata.key)) {
                        z = true;
                    } else {
                        h46 h46Var2 = new h46();
                        h46Var2.c(listdata);
                        if (h46Var2.a() != null) {
                            for (bb5 bb5Var : h46Var2.a()) {
                                if (b(this.b, bb5Var)) {
                                    bb5Var.q(1);
                                } else {
                                    bb5Var.q(0);
                                }
                            }
                        }
                        this.a.add(h46Var2);
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
