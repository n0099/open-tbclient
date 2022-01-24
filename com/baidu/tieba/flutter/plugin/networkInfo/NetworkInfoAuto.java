package com.baidu.tieba.flutter.plugin.networkInfo;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class NetworkInfoAuto {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class DnsIpResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String dnsIp;
        public ArrayList dnsIpList;
        public String dnsResolveStatus;
        public String dnsResolveType;

        public DnsIpResult() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static DnsIpResult fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                DnsIpResult dnsIpResult = new DnsIpResult();
                dnsIpResult.dnsResolveType = (String) hashMap.get("dnsResolveType");
                dnsIpResult.dnsResolveStatus = (String) hashMap.get("dnsResolveStatus");
                dnsIpResult.dnsIpList = (ArrayList) hashMap.get("dnsIpList");
                dnsIpResult.dnsIp = (String) hashMap.get("dnsIp");
                return dnsIpResult;
            }
            return (DnsIpResult) invokeL.objValue;
        }

        public String getDnsIp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.dnsIp : (String) invokeV.objValue;
        }

        public ArrayList getDnsIpList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dnsIpList : (ArrayList) invokeV.objValue;
        }

        public String getDnsResolveStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dnsResolveStatus : (String) invokeV.objValue;
        }

        public String getDnsResolveType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.dnsResolveType : (String) invokeV.objValue;
        }

        public void setDnsIp(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.dnsIp = str;
            }
        }

        public void setDnsIpList(ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
                this.dnsIpList = arrayList;
            }
        }

        public void setDnsResolveStatus(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.dnsResolveStatus = str;
            }
        }

        public void setDnsResolveType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.dnsResolveType = str;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("dnsResolveType", this.dnsResolveType);
                hashMap.put("dnsResolveStatus", this.dnsResolveStatus);
                hashMap.put("dnsIpList", this.dnsIpList);
                hashMap.put("dnsIp", this.dnsIp);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class DnsUrl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String url;

        public DnsUrl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static DnsUrl fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                DnsUrl dnsUrl = new DnsUrl();
                dnsUrl.url = (String) hashMap.get("url");
                return dnsUrl;
            }
            return (DnsUrl) invokeL.objValue;
        }

        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.url : (String) invokeV.objValue;
        }

        public void setUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.url = str;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("url", this.url);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class FlutterNetworkInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BinaryMessenger binaryMessenger;

        /* loaded from: classes12.dex */
        public interface Reply<T> {
            void reply(T t);
        }

        public FlutterNetworkInfo(BinaryMessenger binaryMessenger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {binaryMessenger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.binaryMessenger = binaryMessenger;
        }

        public void setNetInfo(NetworkStatus networkStatus, final Reply<SetNetInfoResult> reply) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, networkStatus, reply) == null) {
                new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterNetworkInfo.setNetInfo", new StandardMessageCodec()).send(networkStatus.toMap(), new BasicMessageChannel.Reply() { // from class: c.a.t0.a1.a.e.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                    public final void reply(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            NetworkInfoAuto.FlutterNetworkInfo.Reply.this.reply(NetworkInfoAuto.SetNetInfoResult.fromMap((HashMap) obj));
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface HostNetworkInfo {
        void getDnsIp(DnsUrl dnsUrl, Result<DnsIpResult> result);

        void getNetInfo(Result<NetworkStatus> result);

        void isNetWorkAvailable(Result<NetWorkAvailable> result);

        void isNetworkAvailableForImmediately(Result<NetWorkAvailable> result);
    }

    /* loaded from: classes12.dex */
    public static class NetWorkAvailable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean isAvailable;

        public NetWorkAvailable() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static NetWorkAvailable fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                NetWorkAvailable netWorkAvailable = new NetWorkAvailable();
                netWorkAvailable.isAvailable = (Boolean) hashMap.get("isAvailable");
                return netWorkAvailable;
            }
            return (NetWorkAvailable) invokeL.objValue;
        }

        public Boolean getIsAvailable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isAvailable : (Boolean) invokeV.objValue;
        }

        public void setIsAvailable(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                this.isAvailable = bool;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("isAvailable", this.isAvailable);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class NetworkStatus {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean isNetOk;
        public Long netType;
        public String netTypeString;

        public NetworkStatus() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static NetworkStatus fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Long valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                NetworkStatus networkStatus = new NetworkStatus();
                networkStatus.isNetOk = (Boolean) hashMap.get("isNetOk");
                networkStatus.netTypeString = (String) hashMap.get("netTypeString");
                Object obj = hashMap.get("netType");
                if (obj == null) {
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
                }
                networkStatus.netType = valueOf;
                return networkStatus;
            }
            return (NetworkStatus) invokeL.objValue;
        }

        public Boolean getIsNetOk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isNetOk : (Boolean) invokeV.objValue;
        }

        public Long getNetType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.netType : (Long) invokeV.objValue;
        }

        public String getNetTypeString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.netTypeString : (String) invokeV.objValue;
        }

        public void setIsNetOk(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                this.isNetOk = bool;
            }
        }

        public void setNetType(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, l) == null) {
                this.netType = l;
            }
        }

        public void setNetTypeString(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.netTypeString = str;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("isNetOk", this.isNetOk);
                hashMap.put("netTypeString", this.netTypeString);
                hashMap.put("netType", this.netType);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public interface Result<T> {
        void success(T t);
    }

    /* loaded from: classes12.dex */
    public static class SetNetInfoResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean result;

        public SetNetInfoResult() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static SetNetInfoResult fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                SetNetInfoResult setNetInfoResult = new SetNetInfoResult();
                setNetInfoResult.result = (Boolean) hashMap.get("result");
                return setNetInfoResult;
            }
            return (SetNetInfoResult) invokeL.objValue;
        }

        public Boolean getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.result : (Boolean) invokeV.objValue;
        }

        public void setResult(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                this.result = bool;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", this.result);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    public NetworkInfoAuto() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static HashMap wrapError(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, exc)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("message", exc.toString());
            hashMap.put("code", exc.getClass().getSimpleName());
            hashMap.put("details", null);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
