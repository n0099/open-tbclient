package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.HotUserRankEntry;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class fx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<yh> a;
    public ArrayList<gy4> b;
    public ay4 c;
    public hx6 d;
    public boolean e;

    public fx6() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public fx6 clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fx6 fx6Var = new fx6();
            fx6Var.a = this.a;
            fx6Var.b = this.b;
            fx6Var.c = this.c;
            fx6Var.d = this.d;
            fx6Var.e = this.e;
            return fx6Var;
        }
        return (fx6) invokeV.objValue;
    }

    public hx6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (hx6) invokeV.objValue;
    }

    public ay4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (ay4) invokeV.objValue;
    }

    public ArrayList<gy4> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<yh> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public void g(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, dataRes) != null) || dataRes == null) {
            return;
        }
        this.a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            ThreadData threadData = new ThreadData();
            threadData.parserProtobuf(threadInfo);
            threadData.insertItemToTitleOrAbstractText();
            this.a.add(threadData);
        }
        this.b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                gy4 gy4Var = new gy4();
                gy4Var.c(generalResource);
                this.b.add(gy4Var);
            }
        }
        ay4 ay4Var = new ay4();
        this.c = ay4Var;
        ay4Var.f(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            hx6 hx6Var = new hx6();
            this.d = hx6Var;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            hx6Var.a = hotUserRankEntry.hot_user;
            hx6Var.b = hotUserRankEntry.module_name;
            hx6Var.c = hotUserRankEntry.module_icon;
        }
        boolean z = true;
        if (dataRes.is_new_url.intValue() != 1) {
            z = false;
        }
        this.e = z;
    }
}
