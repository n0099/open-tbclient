package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.MyBalanceResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ProductListResult;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.SplitOrderConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetSplitOrderConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.IMiddlePayService;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes3.dex */
public final class bsa implements sra {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public qra b;
    public final IMiddleRevenue c;

    /* loaded from: classes3.dex */
    public static final class a implements IResult<BannerConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IResult a;

        public a(IResult iResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, bannerConfigResult, payCallBackBean) == null) && (iResult = this.a) != null) {
                iResult.onSuccess(bannerConfigResult, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) && (iResult = this.a) != null) {
                iResult.onFail(i, str, payCallBackBean);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements IResult<MyBalanceResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IResult a;

        public b(IResult iResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(MyBalanceResult myBalanceResult, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, myBalanceResult, payCallBackBean) == null) && (iResult = this.a) != null) {
                iResult.onSuccess(myBalanceResult, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) && (iResult = this.a) != null) {
                iResult.onFail(i, str, payCallBackBean);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements IResult<ProductListResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IResult a;

        public c(IResult iResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(ProductListResult productListResult, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, productListResult, payCallBackBean) == null) && (iResult = this.a) != null) {
                iResult.onSuccess(productListResult, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) && (iResult = this.a) != null) {
                iResult.onFail(i, str, payCallBackBean);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements IResult<SplitOrderConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IResult a;

        public d(IResult iResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iResult};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(SplitOrderConfigResult splitOrderConfigResult, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, splitOrderConfigResult, payCallBackBean) == null) && (iResult = this.a) != null) {
                iResult.onSuccess(splitOrderConfigResult, payCallBackBean);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            IResult iResult;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) && (iResult = this.a) != null) {
                iResult.onFail(i, str, payCallBackBean);
            }
        }
    }

    public bsa(MiddleRevenueConfig middleRevenueConfig, IMiddleRevenue iMiddleRevenue) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {middleRevenueConfig, iMiddleRevenue};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = iMiddleRevenue;
        this.a = "YYPayMiddleService";
        this.b = new asa(middleRevenueConfig);
        String str = this.a;
        RLog.info(str, this + " queryParamsProvider:" + this.b + WebvttCueParser.CHAR_SPACE + "revenue:" + this.c + " config:" + middleRevenueConfig.hashCode() + WebvttCueParser.CHAR_SPACE);
    }

    @Override // com.baidu.tieba.sra
    public void a(int[] iArr, IResult<BannerConfigResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, iArr, iResult) == null) {
            GetBannerConfigReqParams a2 = this.b.a();
            Intrinsics.checkExpressionValueIsNotNull(a2, "queryParamsProvider.getBannerConfigReqParams()");
            a2.setTypes(iArr);
            IAppPayService appPayService = this.c.getAppPayService();
            if (appPayService == null) {
                RLog.error(this.a, "queryBannerConfig error appPayService null", new Object[0]);
            } else {
                appPayService.queryBannerConfigRequest(a2, new a(iResult));
            }
        }
    }

    @Override // com.baidu.tieba.sra
    public void e(Map<String, String> map, IResult<ProductListResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, map, iResult) == null) {
            QueryCurrencyReqParams e = this.b.e(map);
            Intrinsics.checkExpressionValueIsNotNull(e, "queryParamsProvider.getQ…qParams(clinetInfoExpand)");
            IMiddlePayService middlePayService = this.c.getMiddlePayService();
            if (middlePayService == null) {
                RLog.error(this.a, "queryProductList error middlePayService null", new Object[0]);
            } else {
                middlePayService.queryProductList(e, new c(iResult));
            }
        }
    }

    @Override // com.baidu.tieba.sra
    public void b(Activity activity, PayFlowType payFlowType, PayType payType, ProductInfo productInfo, AppCustomExpand appCustomExpand, Map<String, String> map, IPayCallback<String> iPayCallback, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, payFlowType, payType, productInfo, appCustomExpand, map, iPayCallback, str, str2, str3}) == null) {
            tra c2 = this.b.c(payFlowType, map);
            Intrinsics.checkExpressionValueIsNotNull(c2, "queryParamsProvider.getM…owType, clinetInfoExpand)");
            c2.s(iPayCallback);
            c2.q(activity);
            c2.v(productInfo);
            c2.x(payType);
            c2.r(appCustomExpand);
            c2.C(str);
            c2.w(payFlowType.getTypeId());
            c2.z(str3);
            if (str2 != null) {
                c2.y(str2);
            }
            IMiddlePayService middlePayService = this.c.getMiddlePayService();
            if (middlePayService == null) {
                RLog.error(this.a, "queryProductList error middlePayService null", new Object[0]);
            } else {
                middlePayService.a(c2);
            }
        }
    }

    @Override // com.baidu.tieba.sra
    public void c(IResult<MyBalanceResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iResult) == null) {
            QueryCurrencyReqParams b2 = this.b.b();
            Intrinsics.checkExpressionValueIsNotNull(b2, "queryParamsProvider.getQueryMyBalanceReqParams()");
            IAppPayService appPayService = this.c.getAppPayService();
            if (appPayService == null) {
                RLog.error(this.a, "queryMyBalance error appPayService null", new Object[0]);
            } else {
                appPayService.queryMyBalance(b2, new b(iResult));
            }
        }
    }

    @Override // com.baidu.tieba.sra
    public void d(int i, String str, long j, IResult<SplitOrderConfigResult> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), iResult}) == null) {
            GetSplitOrderConfigReqParams d2 = this.b.d(i, str, j);
            Intrinsics.checkExpressionValueIsNotNull(d2, "queryParamsProvider.getS…ms(type, orderId, amount)");
            IAppPayService appPayService = this.c.getAppPayService();
            if (appPayService == null) {
                RLog.error(this.a, "querySplitOrderConfig error appPayService null", new Object[0]);
            } else {
                appPayService.querySplitOrderConfig(d2, new d(iResult));
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a + hashCode() + " :{revenue:" + this.c + '}';
        }
        return (String) invokeV.objValue;
    }
}
