package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.funad.adapter.FunAdNativeNewAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hx6 implements ax6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hx6() {
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

    @Override // com.baidu.tieba.ax6
    public kn<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.F) {
                FunAdNativeNewAdapter funAdNativeNewAdapter = new FunAdNativeNewAdapter(baseFragmentActivity, bdUniqueId);
                funAdNativeNewAdapter.setSid(dx6.e().d("pb_banner"));
                funAdNativeNewAdapter.setPageType("pb");
                funAdNativeNewAdapter.setSceneKey("pb_banner");
                return funAdNativeNewAdapter;
            } else if (bdUniqueId == AdvertAppInfo.I) {
                FunAdNativeNewAdapter funAdNativeNewAdapter2 = new FunAdNativeNewAdapter(baseFragmentActivity, bdUniqueId);
                funAdNativeNewAdapter2.setSid(xw6.f());
                funAdNativeNewAdapter2.setPageType("pb");
                return funAdNativeNewAdapter2;
            } else if (bdUniqueId != AdvertAppInfo.G) {
                return null;
            } else {
                return new ix6(baseFragmentActivity, bdUniqueId);
            }
        }
        return (kn) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ax6
    public kn<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.H) {
                FunAdNativeNewAdapter funAdNativeNewAdapter = new FunAdNativeNewAdapter(baseFragmentActivity, bdUniqueId);
                funAdNativeNewAdapter.setSid(xw6.g());
                funAdNativeNewAdapter.setPageType("personalize");
                return funAdNativeNewAdapter;
            } else if (bdUniqueId != AdvertAppInfo.G) {
                return null;
            } else {
                return new ix6(baseFragmentActivity, bdUniqueId);
            }
        }
        return (kn) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ax6
    public kn<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.H) {
                FunAdNativeNewAdapter funAdNativeNewAdapter = new FunAdNativeNewAdapter(baseFragmentActivity, bdUniqueId);
                funAdNativeNewAdapter.setSid(dx6.e().d("frs_feed"));
                funAdNativeNewAdapter.setPageType("frs");
                funAdNativeNewAdapter.setSceneKey("frs_feed");
                return funAdNativeNewAdapter;
            } else if (bdUniqueId != AdvertAppInfo.G) {
                return null;
            } else {
                return new ix6(baseFragmentActivity, bdUniqueId);
            }
        }
        return (kn) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ax6
    public kn<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, baseFragmentActivity, bdUniqueId, str)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.H) {
                FunAdNativeNewAdapter funAdNativeNewAdapter = new FunAdNativeNewAdapter(baseFragmentActivity, bdUniqueId);
                funAdNativeNewAdapter.setSid(dx6.e().d("frs_feed"));
                funAdNativeNewAdapter.setPageType("frs");
                funAdNativeNewAdapter.setPageTab(str);
                funAdNativeNewAdapter.setSceneKey("frs_feed");
                return funAdNativeNewAdapter;
            } else if (bdUniqueId != AdvertAppInfo.G) {
                return null;
            } else {
                return new ix6(baseFragmentActivity, bdUniqueId);
            }
        }
        return (kn) invokeLLL.objValue;
    }
}
