package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.HeadImgs;
import tbclient.FrsPage.Size;
/* loaded from: classes4.dex */
public class gp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<jp4> a;
    public String b;
    public ko4 c;

    public gp4() {
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
        this.a = new ArrayList<>();
    }

    public ko4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (ko4) invokeV.objValue;
    }

    public ArrayList<jp4> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void d(ActivityHead activityHead, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, activityHead, j) == null) || activityHead == null) {
            return;
        }
        activityHead.activity_type.intValue();
        String str = activityHead.activity_title;
        Size size = activityHead.top_size;
        if (size != null) {
            size.width.intValue();
        }
        Size size2 = activityHead.top_size;
        if (size2 != null) {
            size2.height.intValue();
        }
        this.b = activityHead.obj_id;
        f(activityHead.head_imgs);
        ko4 ko4Var = new ko4();
        ko4Var.a = activityHead.pull_down_pic_android;
        ko4Var.b = activityHead.pull_down_url;
        ko4Var.c = activityHead.pull_down_interval.intValue();
        ko4Var.d = activityHead.pull_down_exposure_url;
        ko4Var.e = activityHead.pull_down_click_url;
        ko4Var.f = activityHead.pull_down_schema;
        ko4Var.g = activityHead.pull_down_package_name;
        ko4Var.h = activityHead.is_ad.booleanValue();
        ko4Var.i = activityHead.obj_id;
        ko4Var.j = j;
        this.c = ko4Var;
    }

    public void e(HeadImgs headImgs) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, headImgs) == null) || headImgs == null) {
            return;
        }
        jp4 jp4Var = new jp4();
        jp4Var.q(headImgs);
        this.a.add(jp4Var);
    }

    public void f(List<HeadImgs> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (HeadImgs headImgs : list) {
            e(headImgs);
        }
    }

    public void g(ArrayList<jp4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.a = arrayList;
        }
    }
}
