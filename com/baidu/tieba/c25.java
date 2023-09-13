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
/* loaded from: classes5.dex */
public class c25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<f25> a;
    public String b;
    public e15 c;

    public c25() {
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

    public e15 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (e15) invokeV.objValue;
    }

    public ArrayList<f25> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void d(ActivityHead activityHead, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(1048579, this, activityHead, j) != null) || activityHead == null) {
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
        e15 e15Var = new e15();
        e15Var.a = activityHead.pull_down_pic_android;
        e15Var.b = activityHead.pull_down_url;
        e15Var.c = activityHead.pull_down_interval.intValue();
        e15Var.d = activityHead.pull_down_exposure_url;
        e15Var.e = activityHead.pull_down_click_url;
        e15Var.f = activityHead.pull_down_schema;
        e15Var.g = activityHead.pull_down_package_name;
        e15Var.h = activityHead.is_ad.booleanValue();
        e15Var.i = activityHead.obj_id;
        e15Var.j = j;
        this.c = e15Var;
    }

    public void e(HeadImgs headImgs) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, headImgs) != null) || headImgs == null) {
            return;
        }
        f25 f25Var = new f25();
        f25Var.o(headImgs);
        this.a.add(f25Var);
    }

    public void f(List<HeadImgs> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (HeadImgs headImgs : list) {
            e(headImgs);
        }
    }

    public void g(ArrayList<f25> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.a = arrayList;
        }
    }
}
