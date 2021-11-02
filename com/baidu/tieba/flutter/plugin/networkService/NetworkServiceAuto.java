package com.baidu.tieba.flutter.plugin.networkService;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class NetworkServiceAuto {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface HostNetworkService {
        void cancel(NetServiceCancelParam netServiceCancelParam);

        void loadData(LoadDataParam loadDataParam, Result<NetworkResult> result);

        void sendImMessage(IMParam iMParam, Result<NetworkResult> result);
    }

    /* loaded from: classes9.dex */
    public static class IMParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String identifier;
        public Long msgId;
        public HashMap params;

        public IMParam() {
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

        public static IMParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Long valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                IMParam iMParam = new IMParam();
                iMParam.identifier = (String) hashMap.get("identifier");
                Object obj = hashMap.get("msgId");
                if (obj == null) {
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
                }
                iMParam.msgId = valueOf;
                iMParam.params = (HashMap) hashMap.get("params");
                return iMParam;
            }
            return (IMParam) invokeL.objValue;
        }

        public String getIdentifier() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.identifier : (String) invokeV.objValue;
        }

        public Long getMsgId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msgId : (Long) invokeV.objValue;
        }

        public HashMap getParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.params : (HashMap) invokeV.objValue;
        }

        public void setIdentifier(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.identifier = str;
            }
        }

        public void setMsgId(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, l) == null) {
                this.msgId = l;
            }
        }

        public void setParams(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
                this.params = hashMap;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("identifier", this.identifier);
                hashMap.put("msgId", this.msgId);
                hashMap.put("params", this.params);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class LoadDataParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String address;
        public Long cmd;
        public HashMap extra;
        public HashMap fileParams;
        public HashMap headers;
        public String host;
        public String identifier;
        public HashMap params;
        public Boolean useProto;

        public LoadDataParam() {
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

        public static LoadDataParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Long valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                LoadDataParam loadDataParam = new LoadDataParam();
                loadDataParam.host = (String) hashMap.get("host");
                loadDataParam.address = (String) hashMap.get("address");
                loadDataParam.headers = (HashMap) hashMap.get("headers");
                loadDataParam.params = (HashMap) hashMap.get("params");
                loadDataParam.fileParams = (HashMap) hashMap.get("fileParams");
                Object obj = hashMap.get("cmd");
                if (obj == null) {
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
                }
                loadDataParam.cmd = valueOf;
                loadDataParam.identifier = (String) hashMap.get("identifier");
                loadDataParam.useProto = (Boolean) hashMap.get("useProto");
                loadDataParam.extra = (HashMap) hashMap.get("extra");
                return loadDataParam;
            }
            return (LoadDataParam) invokeL.objValue;
        }

        public String getAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.address : (String) invokeV.objValue;
        }

        public Long getCmd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cmd : (Long) invokeV.objValue;
        }

        public HashMap getExtra() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.extra : (HashMap) invokeV.objValue;
        }

        public HashMap getFileParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.fileParams : (HashMap) invokeV.objValue;
        }

        public HashMap getHeaders() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.headers : (HashMap) invokeV.objValue;
        }

        public String getHost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.host : (String) invokeV.objValue;
        }

        public String getIdentifier() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.identifier : (String) invokeV.objValue;
        }

        public HashMap getParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.params : (HashMap) invokeV.objValue;
        }

        public Boolean getUseProto() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.useProto : (Boolean) invokeV.objValue;
        }

        public void setAddress(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.address = str;
            }
        }

        public void setCmd(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, l) == null) {
                this.cmd = l;
            }
        }

        public void setExtra(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, hashMap) == null) {
                this.extra = hashMap;
            }
        }

        public void setFileParams(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, hashMap) == null) {
                this.fileParams = hashMap;
            }
        }

        public void setHeaders(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, hashMap) == null) {
                this.headers = hashMap;
            }
        }

        public void setHost(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.host = str;
            }
        }

        public void setIdentifier(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                this.identifier = str;
            }
        }

        public void setParams(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, hashMap) == null) {
                this.params = hashMap;
            }
        }

        public void setUseProto(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, bool) == null) {
                this.useProto = bool;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("host", this.host);
                hashMap.put("address", this.address);
                hashMap.put("headers", this.headers);
                hashMap.put("params", this.params);
                hashMap.put("fileParams", this.fileParams);
                hashMap.put("cmd", this.cmd);
                hashMap.put("identifier", this.identifier);
                hashMap.put("useProto", this.useProto);
                hashMap.put("extra", this.extra);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class NetServiceCancelParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList list;

        public NetServiceCancelParam() {
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

        public static NetServiceCancelParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                NetServiceCancelParam netServiceCancelParam = new NetServiceCancelParam();
                netServiceCancelParam.list = (ArrayList) hashMap.get("list");
                return netServiceCancelParam;
            }
            return (NetServiceCancelParam) invokeL.objValue;
        }

        public ArrayList getList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.list : (ArrayList) invokeV.objValue;
        }

        public void setList(ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                this.list = arrayList;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("list", this.list);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class NetworkResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean canceled;
        public String data;
        public String errorMessage;
        public Long errorNumber;
        public String identifier;
        public HashMap performanceInfo;
        public HashMap requestInfo;

        public NetworkResult() {
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

        public static NetworkResult fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Long valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                NetworkResult networkResult = new NetworkResult();
                networkResult.canceled = (Boolean) hashMap.get("canceled");
                Object obj = hashMap.get("errorNumber");
                if (obj == null) {
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
                }
                networkResult.errorNumber = valueOf;
                networkResult.errorMessage = (String) hashMap.get("errorMessage");
                networkResult.identifier = (String) hashMap.get("identifier");
                networkResult.data = (String) hashMap.get("data");
                networkResult.requestInfo = (HashMap) hashMap.get("requestInfo");
                networkResult.performanceInfo = (HashMap) hashMap.get("performanceInfo");
                return networkResult;
            }
            return (NetworkResult) invokeL.objValue;
        }

        public Boolean getCanceled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.canceled : (Boolean) invokeV.objValue;
        }

        public String getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.data : (String) invokeV.objValue;
        }

        public String getErrorMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.errorMessage : (String) invokeV.objValue;
        }

        public Long getErrorNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.errorNumber : (Long) invokeV.objValue;
        }

        public String getIdentifier() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.identifier : (String) invokeV.objValue;
        }

        public HashMap getPerformanceInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.performanceInfo : (HashMap) invokeV.objValue;
        }

        public HashMap getRequestInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.requestInfo : (HashMap) invokeV.objValue;
        }

        public void setCanceled(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, bool) == null) {
                this.canceled = bool;
            }
        }

        public void setData(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.data = str;
            }
        }

        public void setErrorMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.errorMessage = str;
            }
        }

        public void setErrorNumber(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, l) == null) {
                this.errorNumber = l;
            }
        }

        public void setIdentifier(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.identifier = str;
            }
        }

        public void setPerformanceInfo(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, hashMap) == null) {
                this.performanceInfo = hashMap;
            }
        }

        public void setRequestInfo(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, hashMap) == null) {
                this.requestInfo = hashMap;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("canceled", this.canceled);
                hashMap.put("errorNumber", this.errorNumber);
                hashMap.put("errorMessage", this.errorMessage);
                hashMap.put("identifier", this.identifier);
                hashMap.put("data", this.data);
                hashMap.put("requestInfo", this.requestInfo);
                hashMap.put("performanceInfo", this.performanceInfo);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface Result<T> {
        void success(T t);
    }

    public NetworkServiceAuto() {
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
