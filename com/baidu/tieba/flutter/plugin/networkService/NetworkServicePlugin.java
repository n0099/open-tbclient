package com.baidu.tieba.flutter.plugin.networkService;

import androidx.annotation.NonNull;
import c.a.q0.k0.b.g;
import c.a.r0.s0.a.f.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.flutter.plugin.networkService.FlutterNetModel;
import com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto;
import com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class NetworkServicePlugin implements FlutterPlugin, NetworkServiceAuto.HostNetworkService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, NetModel> netModels;

    /* loaded from: classes7.dex */
    public interface NetModel {
        boolean cancelLoadData();
    }

    public NetworkServicePlugin() {
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
        this.netModels = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetworkServiceAuto.NetworkResult wrapEventData(HashMap<String, String> hashMap, String str, int i2, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{hashMap, str, Integer.valueOf(i2), str2, str3})) == null) {
            NetworkServiceAuto.NetworkResult networkResult = new NetworkServiceAuto.NetworkResult();
            networkResult.setErrorNumber(Long.valueOf(i2));
            networkResult.setErrorMessage(str2);
            if (i2 == -1 && "cancle".equals(str2)) {
                networkResult.setCanceled(Boolean.TRUE);
            } else {
                networkResult.setCanceled(Boolean.FALSE);
            }
            networkResult.setRequestInfo(hashMap);
            networkResult.setIdentifier(str3);
            if (i2 == 0) {
                networkResult.setData(str);
            }
            return networkResult;
        }
        return (NetworkServiceAuto.NetworkResult) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto.HostNetworkService
    public void cancel(NetworkServiceAuto.NetServiceCancelParam netServiceCancelParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, netServiceCancelParam) == null) {
            ArrayList list = netServiceCancelParam.getList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Map map = (Map) list.get(i2);
                String str = (String) map.get(RetrieveTaskManager.KEY);
                ((Integer) map.get("cmd")).intValue();
                NetModel netModel = this.netModels.get((String) map.get("identifier"));
                if (netModel != null) {
                    netModel.cancelLoadData();
                }
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto.HostNetworkService
    public void loadData(NetworkServiceAuto.LoadDataParam loadDataParam, NetworkServiceAuto.Result<NetworkServiceAuto.NetworkResult> result) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loadDataParam, result) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String host = loadDataParam.getHost();
            String address = loadDataParam.getAddress();
            loadDataParam.getCmd().intValue();
            HashMap headers = loadDataParam.getHeaders();
            HashMap<String, Object> params = loadDataParam.getParams();
            HashMap fileParams = loadDataParam.getFileParams();
            String identifier = loadDataParam.getIdentifier();
            HashMap extra = loadDataParam.getExtra();
            boolean booleanValue = loadDataParam.getUseProto() != null ? loadDataParam.getUseProto().booleanValue() : false;
            if (address.startsWith("/")) {
                address = address.substring(1);
            }
            if (!address.startsWith("http")) {
                address = host + "/" + address;
            }
            params.put(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
            params.put("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
            params.put("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
            params.put("swan_game_ver", TbadkCoreApplication.getInst().getSwan_game_ver());
            if (booleanValue) {
                BdUniqueId gen = BdUniqueId.gen();
                int httpCmdFromUrl = ProtoHelper.getHttpCmdFromUrl(address);
                g requestData = ProtoHelper.getRequestData(httpCmdFromUrl, headers, params);
                if (httpCmdFromUrl == 0 || requestData == null) {
                    return;
                }
                FlutterNetModelAuto netModel = ProtoHelper.getNetModel(identifier, httpCmdFromUrl);
                netModel.setUniqueId(gen);
                netModel.setHttpUrl(address);
                netModel.setHttpCallback(new FlutterNetModelAuto.NetModelHttpCallback(this, currentTimeMillis, result) { // from class: com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NetworkServicePlugin this$0;
                    public final /* synthetic */ long val$netStartTime;
                    public final /* synthetic */ NetworkServiceAuto.Result val$result;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(currentTimeMillis), result};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$netStartTime = currentTimeMillis;
                        this.val$result = result;
                    }

                    @Override // com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.NetModelHttpCallback
                    public void onHttpResponseMessage(String str, HashMap hashMap, MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLLLL(1048576, this, str, hashMap, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
                            this.this$0.netModels.remove(str);
                            if (hashMap != null) {
                                hashMap.put(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY, String.valueOf(this.val$netStartTime));
                            }
                            this.val$result.success(this.this$0.wrapEventData(hashMap, null, mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString(), str));
                        }
                    }
                });
                this.netModels.put(identifier, netModel);
                try {
                    netModel.loadData();
                    return;
                } catch (Exception e2) {
                    BdLog.e("netModel loadData exception" + e2.toString());
                    return;
                }
            }
            FlutterNetModel flutterNetModel = new FlutterNetModel(identifier);
            flutterNetModel.setHttpUrl(address);
            flutterNetModel.setStartRequestTime(currentTimeMillis);
            flutterNetModel.setHttpCallback(new FlutterNetModel.NetResponseCallback(this, currentTimeMillis, extra, result) { // from class: com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NetworkServicePlugin this$0;
                public final /* synthetic */ HashMap val$extra;
                public final /* synthetic */ long val$netStartTime;
                public final /* synthetic */ NetworkServiceAuto.Result val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(currentTimeMillis), extra, result};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$netStartTime = currentTimeMillis;
                    this.val$extra = extra;
                    this.val$result = result;
                }

                @Override // com.baidu.tieba.flutter.plugin.networkService.FlutterNetModel.NetResponseCallback
                public void onHttpResponseMessage(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i2, String str, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{hashMap, hashMap2, Integer.valueOf(i2), str, str2, str3}) == null) {
                        this.this$0.netModels.remove(str3);
                        if (hashMap != null) {
                            hashMap.put(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY, String.valueOf(this.val$netStartTime));
                        }
                        NetworkServiceAuto.NetworkResult wrapEventData = this.this$0.wrapEventData(hashMap, str2, i2, str, str3);
                        HashMap hashMap3 = this.val$extra;
                        if (hashMap3 != null && (hashMap3.get("performance") instanceof Boolean) && ((Boolean) this.val$extra.get("performance")).booleanValue()) {
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put("network", hashMap2);
                            hashMap4.put("send_time", Long.valueOf(System.currentTimeMillis()));
                            wrapEventData.setPerformanceInfo(hashMap4);
                        }
                        this.val$result.success(wrapEventData);
                    }
                }
            });
            if (fileParams != null && (fileParams instanceof Map) && (obj = fileParams.get("debugfile")) != null && (obj instanceof byte[])) {
                byte[] bArr = (byte[]) obj;
                if (bArr.length > 3145728) {
                    return;
                }
                params.put("debugfile", bArr);
                params.put("type", "android");
                flutterNetModel.setIsChunk(true);
            }
            flutterNetModel.setParams(params);
            this.netModels.put(identifier, flutterNetModel);
            try {
                flutterNetModel.loadData();
            } catch (Exception e3) {
                BdLog.e("netModel loadData exception" + e3.toString());
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flutterPluginBinding) == null) {
            f.f(flutterPluginBinding.getBinaryMessenger(), this);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, flutterPluginBinding) == null) {
            f.f(flutterPluginBinding.getBinaryMessenger(), null);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto.HostNetworkService
    public void sendImMessage(NetworkServiceAuto.IMParam iMParam, NetworkServiceAuto.Result<NetworkServiceAuto.NetworkResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, iMParam, result) == null) {
            int intValue = iMParam.getMsgId().intValue();
            String identifier = iMParam.getIdentifier();
            FlutterNetModelAuto imNetModel = ProtoHelper.getImNetModel(identifier, intValue, iMParam.getParams());
            if (imNetModel == null) {
                return;
            }
            imNetModel.setSocketCallback(new FlutterNetModelAuto.NetModelSocketCallback(this, imNetModel, result) { // from class: com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NetworkServicePlugin this$0;
                public final /* synthetic */ FlutterNetModelAuto val$netModel;
                public final /* synthetic */ NetworkServiceAuto.Result val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, imNetModel, result};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$netModel = imNetModel;
                    this.val$result = result;
                }

                @Override // com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.NetModelSocketCallback
                public void onSocketResponseMessage(String str, HashMap hashMap, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLLL(1048576, this, str, hashMap, socketResponsedMessage, socketMessage, netMessage) == null) {
                        this.this$0.netModels.remove(str);
                        this.val$netModel.setSocketCallback(null);
                        this.val$result.success(this.this$0.wrapEventData(hashMap, ProtoHelper.parseSocketResp(socketResponsedMessage), socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), str));
                    }
                }
            });
            imNetModel.setUniqueId(BdUniqueId.gen());
            this.netModels.put(identifier, imNetModel);
            if (imNetModel != null) {
                try {
                    imNetModel.loadData();
                } catch (Exception e2) {
                    BdLog.e("netModel loadData exception" + e2.toString());
                }
            }
        }
    }
}
