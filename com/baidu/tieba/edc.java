package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetSplitOrderConfigReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryCurrencyReqParams;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes5.dex */
public class edc implements ucc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MiddleRevenueConfig a;

    public edc(MiddleRevenueConfig middleRevenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {middleRevenueConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = middleRevenueConfig;
    }

    @Override // com.baidu.tieba.ucc
    public GetBannerConfigReqParams a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetBannerConfigReqParams getBannerConfigReqParams = new GetBannerConfigReqParams();
            getBannerConfigReqParams.setAppId(this.a.getAppId());
            getBannerConfigReqParams.setUsedChannel(this.a.getUseChannel());
            getBannerConfigReqParams.setUid(this.a.getUid());
            getBannerConfigReqParams.setToken(this.a.getToken());
            getBannerConfigReqParams.setTokenCallback(this.a.getTokenCallback());
            return getBannerConfigReqParams;
        }
        return (GetBannerConfigReqParams) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "QueryParamsProviderImpl" + hashCode() + " revenueConfig:" + this.a.hashCode();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ucc
    public QueryCurrencyReqParams b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
            queryCurrencyReqParams.setCurrencyType(this.a.getCurrencyType());
            queryCurrencyReqParams.setAppId(this.a.getAppId());
            queryCurrencyReqParams.setUsedChannel(this.a.getUseChannel());
            queryCurrencyReqParams.setUid(this.a.getUid());
            queryCurrencyReqParams.setToken(this.a.getToken());
            queryCurrencyReqParams.setTokenCallback(this.a.getTokenCallback());
            queryCurrencyReqParams.setReturnYb(true);
            return queryCurrencyReqParams;
        }
        return (QueryCurrencyReqParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ucc
    public xcc c(PayFlowType payFlowType, Map<String, String> map) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, payFlowType, map)) == null) {
            xcc xccVar = new xcc();
            xccVar.D(this.a.getUid());
            xccVar.A(this.a.getToken());
            xccVar.E(this.a.getUseChannel());
            xccVar.t(this.a.getCurrencyType());
            xccVar.B(this.a.getTokenCallback());
            String deviceId = this.a.getDeviceId();
            RLog.info("QueryParamsProviderImpl", "getMiddlePayWithProductInfoParams deviceId:" + deviceId);
            HashMap hashMap = new HashMap();
            if (deviceId != null) {
                hashMap.put("deviceId", deviceId);
            } else {
                RLog.error("QueryParamsProviderImpl", "getMiddlePayWithProductInfoParams deviceId null", new Object[0]);
            }
            if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("chargeScene", str);
            JSONObject f = f(map);
            if (f != null) {
                hashMap.put("clientInfo", f);
            }
            xccVar.u(hashMap);
            return xccVar;
        }
        return (xcc) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ucc
    public QueryCurrencyReqParams d(PayFlowType payFlowType, Map<String, String> map) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, payFlowType, map)) == null) {
            QueryCurrencyReqParams queryCurrencyReqParams = new QueryCurrencyReqParams();
            queryCurrencyReqParams.setCurrencyType(this.a.getCurrencyType());
            queryCurrencyReqParams.setAppId(this.a.getAppId());
            queryCurrencyReqParams.setUsedChannel(this.a.getUseChannel());
            queryCurrencyReqParams.setUid(this.a.getUid());
            queryCurrencyReqParams.setToken(this.a.getToken());
            queryCurrencyReqParams.setTokenCallback(this.a.getTokenCallback());
            HashMap hashMap = new HashMap();
            JSONObject f = f(map);
            if (f != null) {
                hashMap.put("clientInfo", f);
            }
            if (payFlowType == PayFlowType.WALLET_PAY_FLOW) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("chargeScene", str);
            queryCurrencyReqParams.setExpandMap(hashMap);
            return queryCurrencyReqParams;
        }
        return (QueryCurrencyReqParams) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ucc
    public GetSplitOrderConfigReqParams e(int i, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)})) == null) {
            GetSplitOrderConfigReqParams getSplitOrderConfigReqParams = new GetSplitOrderConfigReqParams();
            getSplitOrderConfigReqParams.setAppId(this.a.getAppId());
            getSplitOrderConfigReqParams.setUsedChannel(this.a.getUseChannel());
            getSplitOrderConfigReqParams.setUid(this.a.getUid());
            getSplitOrderConfigReqParams.setToken(this.a.getToken());
            getSplitOrderConfigReqParams.setTokenCallback(this.a.getTokenCallback());
            getSplitOrderConfigReqParams.setCurrencyType(this.a.getCurrencyType());
            getSplitOrderConfigReqParams.setOrderId(str);
            getSplitOrderConfigReqParams.setType(i);
            getSplitOrderConfigReqParams.setAmount(j);
            return getSplitOrderConfigReqParams;
        }
        return (GetSplitOrderConfigReqParams) invokeCommon.objValue;
    }

    public final JSONObject f(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, map)) == null) {
            JSONObject jSONObject = null;
            if (map == null) {
                return null;
            }
            try {
                if (map.size() <= 0) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (entry.getKey() != null && entry.getValue() != null) {
                            jSONObject2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    return jSONObject2;
                } catch (JSONException e) {
                    e = e;
                    jSONObject = jSONObject2;
                    RLog.error("QueryParamsProviderImpl", "getClientInfoJsonObject JSONException" + e.getLocalizedMessage(), new Object[0]);
                    return jSONObject;
                }
            } catch (JSONException e2) {
                e = e2;
            }
        } else {
            return (JSONObject) invokeL.objValue;
        }
    }
}
