package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tieba.rw6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gk6 implements rw6.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gk6() {
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

    @Override // com.baidu.tieba.rw6.l
    public void a(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof SingleLinkCardView)) {
            ((SingleLinkCardView) viewGroup).d();
        }
    }

    @Override // com.baidu.tieba.rw6.i
    @NonNull
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new SingleLinkCardView(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rw6.i
    public void update(@NonNull ViewGroup viewGroup, @NonNull ux6 ux6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, ux6Var) == null) && (viewGroup instanceof SingleLinkCardView)) {
            az6 d = ux6Var.d();
            if (d.i() == 6) {
                PbGoodsData pbGoodsData = new PbGoodsData();
                pbGoodsData.title = d.h();
                pbGoodsData.picUrl = d.f();
                pbGoodsData.price = d.c();
                pbGoodsData.linkUrl = d.e();
                pbGoodsData.sort = d.g();
                pbGoodsData.linkFrom = d.d();
                pbGoodsData.goodsUrlH5 = d.a();
                ((SingleLinkCardView) viewGroup).a(pbGoodsData);
                return;
            }
            PbLinkData pbLinkData = new PbLinkData();
            pbLinkData.title = d.h();
            pbLinkData.linkUrl = d.e();
            pbLinkData.picUrl = d.f();
            pbLinkData.linkFrom = d.d();
            pbLinkData.extTxt = d.c();
            pbLinkData.sort = d.g();
            pbLinkData.urlType = d.i();
            pbLinkData.content1 = d.a();
            pbLinkData.content2 = d.b();
            ((SingleLinkCardView) viewGroup).a(pbLinkData);
        }
    }
}
