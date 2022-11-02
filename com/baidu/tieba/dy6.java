package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.ActivityPageResIdl;
import tbclient.ActivityPage.DataRes;
import tbclient.ActivityPage.HotTopic;
import tbclient.ActivityPage.RecommendForumList;
import tbclient.ActivityPage.RecommendUserList;
import tbclient.ActivityPage.SpecialColumnList;
import tbclient.BannerImage;
import tbclient.Error;
/* loaded from: classes3.dex */
public class dy6 extends pg5<ActivityPageResIdl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mg5 c;
    public List<ThreadData> d;
    public List<rr4> e;
    public fs4 f;
    public dt4 g;

    public dy6() {
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
        this.c = new mg5();
    }

    @Override // com.baidu.tieba.pg5
    public List<rr4> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pg5
    public List<ThreadData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pg5, com.baidu.tieba.sg5
    public mg5 getPageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (mg5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sg5
    public final void a(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, bArr) == null) {
            ActivityPageResIdl activityPageResIdl = (ActivityPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ActivityPageResIdl.class);
            Error error = activityPageResIdl.error;
            if (error != null && (num = error.errorno) != null) {
                b(num.intValue());
                c(activityPageResIdl.error.errmsg);
            }
            Error error2 = activityPageResIdl.error;
            if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
                b(activityPageResIdl.error.errorno.intValue());
                c(activityPageResIdl.error.errmsg);
            }
            if (getErrorCode() != 0 || (dataRes = activityPageResIdl.data) == null) {
                return;
            }
            j(dataRes);
        }
    }

    @Override // com.baidu.tieba.pg5
    public List<wn> i(List<? extends wn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            return ih5.a(list);
        }
        return (List) invokeL.objValue;
    }

    public final void j(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) {
            m(dataRes);
            n(dataRes);
            l(dataRes);
            k(dataRes);
        }
    }

    public final void m(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dataRes) == null) {
            this.c.a(dataRes.page_info);
        }
    }

    public final void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dataRes) == null) {
            this.d = ih5.c(dataRes.thread_list);
        }
    }

    public final void k(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dataRes) == null) {
            ArrayList arrayList = new ArrayList();
            RecommendForumList recommendForumList = dataRes.recommend_forum;
            if (recommendForumList != null && ListUtils.getCount(recommendForumList.forum_list) >= 5) {
                gu4 gu4Var = new gu4();
                gu4Var.j(recommendForumList.forum_list);
                gu4Var.f = recommendForumList.class_name;
                gu4Var.floorPosition = recommendForumList.floor_position.intValue();
                gu4Var.d = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fe9);
                gu4Var.e = R.color.CAM_X0108;
                arrayList.add(gu4Var);
            }
            RecommendUserList recommendUserList = dataRes.recommend_user;
            if (recommendUserList != null && ListUtils.getCount(recommendUserList.user_list) >= 4) {
                ku4 ku4Var = new ku4();
                ku4Var.f(recommendUserList.user_list);
                ku4Var.floorPosition = recommendUserList.floor_position.intValue();
                ku4Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1000);
                ku4Var.b = R.color.CAM_X0108;
                arrayList.add(ku4Var);
            }
            HotTopic hotTopic = dataRes.hot_topic;
            if (hotTopic != null && ListUtils.getCount(hotTopic.topic_list) >= 4) {
                g67 g67Var = new g67();
                g67Var.h(hotTopic);
                arrayList.add(g67Var);
            }
            SpecialColumnList specialColumnList = dataRes.special_column;
            if (specialColumnList != null && ListUtils.getCount(specialColumnList.item_list) >= 3) {
                SpecialColumnListData specialColumnListData = new SpecialColumnListData();
                specialColumnListData.parserProtobuf(specialColumnList);
                arrayList.add(specialColumnListData);
            }
            this.e = arrayList;
        }
    }

    public final void l(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            List<BannerImage> list = dataRes.banner_image;
            if (!ListUtils.isEmpty(list)) {
                fs4 fs4Var = new fs4();
                this.f = fs4Var;
                fs4Var.parserProtobuf(list);
            }
            List<BannerImage> list2 = dataRes.grid;
            if (ListUtils.getCount(list2) >= 4) {
                dt4 dt4Var = new dt4();
                this.g = dt4Var;
                dt4Var.parserProtobuf(list2);
            }
        }
    }
}
