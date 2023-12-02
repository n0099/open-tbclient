package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AdMixFloor;
import tbclient.BannerList;
import tbclient.Error;
import tbclient.GeneralTabList.DataRes;
import tbclient.GeneralTabList.GeneralTabListResIdl;
import tbclient.GeneralTabList.PageData;
import tbclient.LayoutFactory;
/* loaded from: classes6.dex */
public final class hj7 extends ej7<ti7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hj7() {
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

    @Override // com.baidu.tieba.xi7
    public boolean a(Object originData) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            if (!(originData instanceof DataRes) || (num = ((DataRes) originData).has_more) == null || num.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ej7
    public List<LayoutFactory> g(Object originData) {
        InterceptResult invokeL;
        List<LayoutFactory> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            if (originData instanceof DataRes) {
                PageData pageData = ((DataRes) originData).page_data;
                if (pageData != null) {
                    list = pageData.feed_list;
                } else {
                    list = null;
                }
                if (list == null) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                return list;
            }
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ej7
    public dj7 f(Object originData) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            dj7 dj7Var = new dj7();
            if (originData instanceof DataRes) {
                BannerList.Builder builder = new BannerList.Builder();
                DataRes dataRes = (DataRes) originData;
                builder.app = dataRes.app_list;
                BannerList build = builder.build(true);
                Intrinsics.checkNotNullExpressionValue(build, "bannerListBuilder.build(true)");
                dj7Var.f(build);
                Integer num = dataRes.ad_show_select;
                if (num == null) {
                    intValue = 0;
                } else {
                    intValue = num.intValue();
                }
                dj7Var.e(intValue);
                List<AdMixFloor> list = dataRes.ad_mix_list;
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                dj7Var.d(list);
            }
            return dj7Var;
        }
        return (dj7) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xi7
    /* renamed from: l */
    public ti7 b(byte[] bArr) {
        InterceptResult invokeL;
        Integer num;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            ti7 ti7Var = new ti7();
            GeneralTabListResIdl generalTabListResIdl = (GeneralTabListResIdl) new Wire(new Class[0]).parseFrom(bArr, GeneralTabListResIdl.class);
            if (generalTabListResIdl == null) {
                generalTabListResIdl = new GeneralTabListResIdl.Builder().build(false);
            }
            Error error = generalTabListResIdl.error;
            String str = null;
            if (error != null) {
                num = error.errorno;
            } else {
                num = null;
            }
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            ti7Var.c(intValue);
            Error error2 = generalTabListResIdl.error;
            if (error2 != null) {
                str = error2.usermsg;
            }
            if (str == null) {
                str = "";
            }
            ti7Var.d(str);
            DataRes dataRes = generalTabListResIdl.data;
            if (dataRes == null) {
                dataRes = new DataRes.Builder().build(false);
                Intrinsics.checkNotNullExpressionValue(dataRes, "Builder().build(false)");
            }
            ti7Var.e(dataRes);
            ti7Var.f(this);
            return ti7Var;
        }
        return (ti7) invokeL.objValue;
    }
}
