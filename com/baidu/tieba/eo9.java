package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.tieba.recapp.view.AdVideoFlowView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class eo9 implements xm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u56 a;
    public TbPageContext<BaseFragmentActivity> b;
    public Map<AdvertAppInfo, AdVideoFlowView> c;

    public eo9(IAdBaseAsyncController.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        u56 u56Var = new u56(PlaceId.VIDEO_FLOW, "VIDEO_FLOW", aVar);
        this.a = u56Var;
        u56Var.e(false);
        this.c = new HashMap();
    }

    @Override // com.baidu.tieba.xm9
    @Nullable
    public xl9 i(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo)) == null) {
            if (this.b == null) {
                return null;
            }
            AdVideoFlowView adVideoFlowView = this.c.get(advertAppInfo);
            if (adVideoFlowView == null) {
                adVideoFlowView = new AdVideoFlowView(this.b.getPageActivity());
                this.c.put(advertAppInfo, adVideoFlowView);
            }
            adVideoFlowView.setPageContext(this.b);
            adVideoFlowView.setData(advertAppInfo);
            return adVideoFlowView;
        }
        return (xl9) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xm9
    public void a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.b = tbPageContext;
        }
    }

    @Override // com.baidu.tieba.xm9
    public void m(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, advertAppInfo) == null) {
            this.c.remove(advertAppInfo);
        }
    }

    @Override // com.baidu.tieba.xm9
    public void c(AdvertAppInfo advertAppInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z) == null) {
            AdVideoFlowView adVideoFlowView = this.c.get(advertAppInfo);
            if (adVideoFlowView != null) {
                adVideoFlowView.onPageSelected(z);
            }
            for (AdVideoFlowView adVideoFlowView2 : this.c.values()) {
                if (adVideoFlowView2 != adVideoFlowView) {
                    adVideoFlowView2.onPageSelected(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.xm9
    public void loadAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.d(1, null);
        }
    }
}
