package com.baidu.tieba.flutter.plugin.networkInfo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.e.e.j.a.a;
import c.a.e.e.p.j;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
import com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class NetworkInfoPlugin implements FlutterPlugin, NetworkInfoAuto.HostNetworkInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetworkInfoAuto.FlutterNetworkInfo mFlutterNetworkInfo;
    public CustomMessageListener mNetworkChangedListener;

    public NetworkInfoPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNetworkChangedListener = new CustomMessageListener(this, 2000994) { // from class: com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoPlugin.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NetworkInfoPlugin this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    boolean z = true;
                    try {
                        z = j.z();
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                    NetworkInfoAuto.NetworkStatus networkStatus = new NetworkInfoAuto.NetworkStatus();
                    networkStatus.setIsNetOk(Boolean.valueOf(z));
                    networkStatus.setNetType(Long.valueOf(j.I()));
                    networkStatus.setNetTypeString(NetWorkUtil.getNetType());
                    if (this.this$0.mFlutterNetworkInfo != null) {
                        this.this$0.mFlutterNetworkInfo.setNetInfo(networkStatus, new NetworkInfoAuto.FlutterNetworkInfo.Reply<NetworkInfoAuto.SetNetInfoResult>(this) { // from class: com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoPlugin.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i4 = newInitContext2.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.FlutterNetworkInfo.Reply
                            public void reply(NetworkInfoAuto.SetNetInfoResult setNetInfoResult) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, setNetInfoResult) == null) {
                                    BdLog.i("setNetInfo result:" + setNetInfoResult.getResult());
                                }
                            }
                        });
                    }
                }
            }
        };
    }

    private String resolveStatusString(BDHttpDnsResult.ResolveStatus resolveStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, resolveStatus)) == null) ? resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK ? "BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK" : resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsInputError ? "BDHttpDnsResult.ResolveStatus.BDHttpDnsInputError" : resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss ? "BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss" : resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve ? "BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve" : "" : (String) invokeL.objValue;
    }

    private String resolveTypeString(BDHttpDnsResult.ResolveType resolveType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, resolveType)) == null) ? resolveType == BDHttpDnsResult.ResolveType.RESOLVE_NONE ? "BDHttpDnsResult.ResolveType.RESOLVE_NONE" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_NONEED ? "BDHttpDnsResult.ResolveType.RESOLVE_NONEED" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE ? "BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE ? "BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE ? "BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS ? "BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS" : "" : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.HostNetworkInfo
    public void getDnsIp(NetworkInfoAuto.DnsUrl dnsUrl, NetworkInfoAuto.Result<NetworkInfoAuto.DnsIpResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dnsUrl, result) == null) {
            String str = "hiphotos.baidu.com";
            NetworkInfoAuto.DnsIpResult dnsIpResult = new NetworkInfoAuto.DnsIpResult();
            String url = dnsUrl.getUrl();
            try {
                URL url2 = new URL(url);
                if (!TextUtils.isEmpty(url)) {
                    String host = url2.getHost();
                    if (!TextUtils.isEmpty(host)) {
                        if (!host.contains("hiphotos.baidu.com")) {
                            str = host;
                        }
                        BDHttpDnsResult r = BDHttpDns.j(BdBaseApplication.getInst().getApplicationContext()).r(str, true);
                        if (r != null) {
                            dnsIpResult.setDnsResolveType(resolveTypeString(r.d()));
                            dnsIpResult.setDnsResolveStatus(resolveStatusString(r.c()));
                            ArrayList<String> a2 = r.a();
                            if (a2 != null && a2.size() > 0) {
                                dnsIpResult.setDnsIpList(a2);
                                result.success(dnsIpResult);
                                return;
                            }
                        }
                    }
                }
                a b2 = a.b();
                if (b2 != null) {
                    String a3 = b2.a(url);
                    if (!TextUtils.isEmpty(a3)) {
                        dnsIpResult.setDnsIp(a3);
                    }
                }
                result.success(dnsIpResult);
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.HostNetworkInfo
    public void getNetInfo(NetworkInfoAuto.Result<NetworkInfoAuto.NetworkStatus> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result) == null) {
            NetworkInfoAuto.NetworkStatus networkStatus = new NetworkInfoAuto.NetworkStatus();
            networkStatus.setIsNetOk(Boolean.valueOf(j.z()));
            networkStatus.setNetType(Long.valueOf(j.I()));
            networkStatus.setNetTypeString(NetWorkUtil.getNetType());
            result.success(networkStatus);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.HostNetworkInfo
    public void isNetWorkAvailable(NetworkInfoAuto.Result<NetworkInfoAuto.NetWorkAvailable> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, result) == null) {
            NetworkInfoAuto.NetWorkAvailable netWorkAvailable = new NetworkInfoAuto.NetWorkAvailable();
            netWorkAvailable.setIsAvailable(Boolean.valueOf(j.z()));
            result.success(netWorkAvailable);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.HostNetworkInfo
    public void isNetworkAvailableForImmediately(NetworkInfoAuto.Result<NetworkInfoAuto.NetWorkAvailable> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
            NetworkInfoAuto.NetWorkAvailable netWorkAvailable = new NetworkInfoAuto.NetWorkAvailable();
            netWorkAvailable.setIsAvailable(Boolean.valueOf(j.A()));
            result.success(netWorkAvailable);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, flutterPluginBinding) == null) {
            this.mFlutterNetworkInfo = new NetworkInfoAuto.FlutterNetworkInfo(flutterPluginBinding.getBinaryMessenger());
            MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            c.a.r0.s0.a.e.j.i(flutterPluginBinding.getBinaryMessenger(), this);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, flutterPluginBinding) == null) {
            MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
            this.mFlutterNetworkInfo = null;
            c.a.r0.s0.a.e.j.i(flutterPluginBinding.getBinaryMessenger(), null);
        }
    }
}
