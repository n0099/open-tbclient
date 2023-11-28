package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes6.dex */
public class hp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes a;
    public boolean b;
    public String c;
    public final ArrayList<lo4> d;
    public final ArrayList<FloatStrategy> e;
    public NewUserRedPackageData f;
    public ActiveCenterData g;

    public hp4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = "";
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
    }

    public ArrayList<FloatStrategy> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<lo4> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) {
            this.a = dataRes;
            this.d.clear();
            this.e.clear();
            if (dataRes == null) {
                return;
            }
            boolean z = true;
            if (dataRes.is_new_user.intValue() != 1) {
                z = false;
            }
            this.b = z;
            this.c = dataRes.active_url;
            this.e.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.a.mission_list) {
                if (missionInfo != null) {
                    lo4 lo4Var = new lo4(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        t45.e().g(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        zo4.c().f(lo4Var);
                    } else if (lo4Var.L()) {
                        this.d.add(lo4Var);
                    }
                }
            }
            if (ListUtils.isNotEmpty(this.a.task_list)) {
                po4.d().h(this.a.task_list);
            } else {
                po4.d().h(null);
            }
            NewUserRedPackageData newUserRedPackageData = new NewUserRedPackageData();
            this.f = newUserRedPackageData;
            newUserRedPackageData.parseProto(dataRes);
            if (dataRes.active_center != null) {
                ActiveCenterData activeCenterData = new ActiveCenterData();
                this.g = activeCenterData;
                activeCenterData.parseProto(dataRes);
            }
        }
    }
}
