package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.RevenueConfig;
import com.yy.mobile.framework.revenuesdk.RevenueConfigCenter;
import com.yy.mobile.framework.revenuesdk.RevenueSdk;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.data.DataSenderConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayNetStateStatisticsApi;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.XorUtil;
import com.yy.mobile.framework.revenuesdk.payapi.utils.HiidoUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.http.HttpDataSenderAdapter;
/* loaded from: classes5.dex */
public class alc implements yfc {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, MiddleRevenueConfig> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements IPayNetStateStatisticsApi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ alc c;

        public a(alc alcVar, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alcVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = alcVar;
            this.a = i;
            this.b = i2;
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayNetStateStatisticsApi
        public void reportPayNetEvent(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                this.c.d(this.a, this.b, str, str2, str3);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947620465, "Lcom/baidu/tieba/alc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947620465, "Lcom/baidu/tieba/alc;");
                return;
            }
        }
        a = new HashMap();
    }

    public alc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.yfc
    public List<IRevenue> getAllRevenue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return RevenueSdk.getAllRevenue();
        }
        return (List) invokeV.objValue;
    }

    public static String c(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
            return i + "-" + i2;
        }
        return (String) invokeII.objValue;
    }

    public final IPayNetStateStatisticsApi b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            return new a(this, i, i2);
        }
        return (IPayNetStateStatisticsApi) invokeII.objValue;
    }

    @Override // com.baidu.tieba.yfc
    public IRevenue getRevenue(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) {
            return RevenueSdk.getRevenue(i, i2);
        }
        return (IRevenue) invokeII.objValue;
    }

    @Override // com.baidu.tieba.yfc
    public synchronized void addLogDelegate(IRLogDelegate iRLogDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iRLogDelegate) == null) {
            synchronized (this) {
                RLog.debug("RevenueService", "addLogDelegate");
                RevenueSdk.addLogDelegate(iRLogDelegate);
            }
        }
    }

    @Override // com.baidu.tieba.yfc
    public synchronized void addRevenueConfig(MiddleRevenueConfig middleRevenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, middleRevenueConfig) == null) {
            synchronized (this) {
                if (middleRevenueConfig == null) {
                    RLog.debug("RevenueService", "addRevenueConfig fail! config == null");
                    return;
                }
                RLog.info("RevenueService", "addRevenueConfig versionName:4.3.45-bdpay config:" + middleRevenueConfig.toString());
                String c = c(middleRevenueConfig.getAppId(), middleRevenueConfig.getUseChannel());
                if (a.get(c) != null) {
                    RLog.error("RevenueService", "addRevenueConfig fail! duplicate init revenue  appId:" + middleRevenueConfig.getAppId() + " usechanel:" + middleRevenueConfig.getUseChannel(), new Object[0]);
                    return;
                }
                a.put(c, middleRevenueConfig);
                RLog.debug("RevenueService", "addRevenueConfig mapKey=" + c + " mapSize=" + a.size());
                Env.instance().init(middleRevenueConfig.isTestEnv(), middleRevenueConfig.getHttpUrl());
                f(middleRevenueConfig.getAppId(), middleRevenueConfig.getAppContext(), middleRevenueConfig.getUid(), middleRevenueConfig.getUseChannel(), middleRevenueConfig.getCurrencyType(), middleRevenueConfig.getPackageName(), middleRevenueConfig.getVersion(), middleRevenueConfig.getAuthType(), middleRevenueConfig.getProtoType(), e(middleRevenueConfig), middleRevenueConfig.getAppName(), middleRevenueConfig.getDeviceId());
            }
        }
    }

    public final void d(int i, int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3}) == null) {
            IRevenue revenue = getRevenue(i, i2);
            if (revenue != null && revenue.getPayEventStatisticApi() != null) {
                RLog.info("RevenueService", "handlePayNetEventStatistic event:" + str + " code:" + str2 + " msg:" + str3);
                revenue.getPayEventStatisticApi().reportPayFlowEvent(str, str2, str3, "", "", "", "", "");
                return;
            }
            RLog.error("RevenueService", "handlePayNetEventStatistic object null", new Object[0]);
        }
    }

    public final IDataSenderAdapter e(MiddleRevenueConfig middleRevenueConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, middleRevenueConfig)) == null) {
            HttpDataSenderAdapter httpDataSenderAdapter = new HttpDataSenderAdapter();
            DataSenderConfig dataSenderConfig = new DataSenderConfig();
            dataSenderConfig.hostId = middleRevenueConfig.getHostId();
            dataSenderConfig.pakageName = middleRevenueConfig.getPackageName();
            dataSenderConfig.version = middleRevenueConfig.getVersion();
            dataSenderConfig.httpUrl = Env.instance().REVENUE_HTTP_URL;
            dataSenderConfig.protoType = middleRevenueConfig.getProtoType();
            dataSenderConfig.authType = middleRevenueConfig.getAuthType();
            dataSenderConfig.appContext = middleRevenueConfig.getAppContext();
            dataSenderConfig.gslbAppId = middleRevenueConfig.getGslbAppId();
            dataSenderConfig.hdid = HiidoUtils.getHdid(middleRevenueConfig.getAppContext());
            dataSenderConfig.payNetStateStaticsApi = b(middleRevenueConfig.getAppId(), middleRevenueConfig.getUseChannel());
            httpDataSenderAdapter.init(dataSenderConfig);
            return httpDataSenderAdapter;
        }
        return (IDataSenderAdapter) invokeL.objValue;
    }

    public final IRevenue f(int i, Context context, long j, int i2, int i3, String str, String str2, int i4, ProtocolType protocolType, IRevenueDataSender iRevenueDataSender, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), context, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), str, str2, Integer.valueOf(i4), protocolType, iRevenueDataSender, str3, str4})) == null) {
            RLog.info("RevenueService", "initRevenue: appId = %d, uid = %s, usedChannel = %d, currencyType = %d, authType = %s", Integer.valueOf(i), XorUtil.encode(String.valueOf(j)), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            return RevenueSdk.addRevenueConfig(i, i2, RevenueConfig.RevenueConfigBuilder.aRevenueConfig().setUid(j).setAppId(i).setUsedChannel(i2).setCurrencyType(i3).setDataSender(iRevenueDataSender).setContext(context).setProtoType(protocolType).setPakageName(str).setClientVersion(str2).setAppName(str3).setAuthType(i4).setDeviceId(str4).build());
        }
        return (IRevenue) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.yfc
    public synchronized IMiddleRevenue getMiddleRevenue(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i, i2)) == null) {
            synchronized (this) {
                MiddleRevenueConfig middleRevenueConfig = a.get(c(i, i2));
                if (middleRevenueConfig == null) {
                    RLog.info("RevenueService", "getMiddleRevenue fail,not yet config appId:" + i + " usechanel:" + i2);
                    return null;
                }
                IRevenue revenue = getRevenue(middleRevenueConfig.getAppId(), middleRevenueConfig.getUseChannel());
                if (revenue == null) {
                    RLog.error("RevenueService", "getMiddleRevenue revenue null appId:" + i + " usechanel:" + i2, new Object[0]);
                    return null;
                }
                return new ggc(middleRevenueConfig, revenue);
            }
        }
        return (IMiddleRevenue) invokeII.objValue;
    }

    @Override // com.baidu.tieba.yfc
    public zfc getYYPayMiddleService(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) {
            MiddleRevenueConfig middleRevenueConfig = a.get(c(i, i2));
            if (middleRevenueConfig == null) {
                RLog.info("RevenueService", "getMiddleRevenue fail,not yet config appId:" + i + " usechanel:" + i2);
                return null;
            }
            IMiddleRevenue middleRevenue = getMiddleRevenue(i, i2);
            if (middleRevenue == null) {
                RLog.info("RevenueService", "getMiddleRevenue middleRevenue null appId:" + i + " usechanel:" + i2);
                return null;
            }
            return new igc(middleRevenueConfig, middleRevenue);
        }
        return (zfc) invokeII.objValue;
    }

    @Override // com.baidu.tieba.yfc
    public synchronized void removeRevenueConfig(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            synchronized (this) {
                String c = c(i, i2);
                a.remove(c);
                RLog.info("RevenueService", "removeRevenueConfig mapKey=" + c + " mapSize:" + a.size());
                RevenueSdk.removeRevenueConfig(i, i2);
            }
        }
    }

    @Override // com.baidu.tieba.yfc
    public void updateMiddleRevenueConfig(int i, int i2, Long l, String str) {
        RevenueConfig config;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), l, str}) == null) && (config = RevenueConfigCenter.getConfig(i, i2)) != null) {
            config.setUid(l.longValue());
            getRevenue(i, i2).updateConfig(config);
        }
    }
}
