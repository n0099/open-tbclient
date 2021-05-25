package com.baidu.tieba.flutter.plugin.networkService;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.flutter.plugin.networkService.FlutterNetModel;
import com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto;
import com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto;
import d.a.m0.g0.b.g;
import d.a.n0.n0.a.f.f;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class NetworkServicePlugin implements FlutterPlugin, NetworkServiceAuto.HostNetworkService {
    public HashMap<String, NetModel> netModels = new HashMap<>();

    /* loaded from: classes4.dex */
    public interface NetModel {
        boolean cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetworkServiceAuto.NetworkResult wrapEventData(HashMap<String, String> hashMap, String str, int i2, String str2, String str3) {
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

    @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto.HostNetworkService
    public void cancel(NetworkServiceAuto.NetServiceCancelParam netServiceCancelParam) {
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

    @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto.HostNetworkService
    public void loadData(NetworkServiceAuto.LoadDataParam loadDataParam, final NetworkServiceAuto.Result<NetworkServiceAuto.NetworkResult> result) {
        Object obj;
        final long currentTimeMillis = System.currentTimeMillis();
        String host = loadDataParam.getHost();
        String address = loadDataParam.getAddress();
        loadDataParam.getCmd().intValue();
        HashMap headers = loadDataParam.getHeaders();
        HashMap<String, Object> params = loadDataParam.getParams();
        HashMap fileParams = loadDataParam.getFileParams();
        String identifier = loadDataParam.getIdentifier();
        final HashMap extra = loadDataParam.getExtra();
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
            netModel.setHttpCallback(new FlutterNetModelAuto.NetModelHttpCallback() { // from class: com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin.1
                @Override // com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.NetModelHttpCallback
                public void onHttpResponseMessage(String str, HashMap hashMap, MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
                    NetworkServicePlugin.this.netModels.remove(str);
                    if (hashMap != null) {
                        hashMap.put("start_time", String.valueOf(currentTimeMillis));
                    }
                    result.success(NetworkServicePlugin.this.wrapEventData(hashMap, null, mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString(), str));
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
        flutterNetModel.setHttpCallback(new FlutterNetModel.NetResponseCallback() { // from class: com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin.2
            @Override // com.baidu.tieba.flutter.plugin.networkService.FlutterNetModel.NetResponseCallback
            public void onHttpResponseMessage(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i2, String str, String str2, String str3) {
                NetworkServicePlugin.this.netModels.remove(str3);
                if (hashMap != null) {
                    hashMap.put("start_time", String.valueOf(currentTimeMillis));
                }
                NetworkServiceAuto.NetworkResult wrapEventData = NetworkServicePlugin.this.wrapEventData(hashMap, str2, i2, str, str3);
                HashMap hashMap3 = extra;
                if (hashMap3 != null && (hashMap3.get("performance") instanceof Boolean) && ((Boolean) extra.get("performance")).booleanValue()) {
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("network", hashMap2);
                    hashMap4.put("send_time", Long.valueOf(System.currentTimeMillis()));
                    wrapEventData.setPerformanceInfo(hashMap4);
                }
                result.success(wrapEventData);
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

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        f.f(flutterPluginBinding.getBinaryMessenger(), this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        f.f(flutterPluginBinding.getBinaryMessenger(), null);
    }

    @Override // com.baidu.tieba.flutter.plugin.networkService.NetworkServiceAuto.HostNetworkService
    public void sendImMessage(NetworkServiceAuto.IMParam iMParam, final NetworkServiceAuto.Result<NetworkServiceAuto.NetworkResult> result) {
        int intValue = iMParam.getMsgId().intValue();
        String identifier = iMParam.getIdentifier();
        final FlutterNetModelAuto imNetModel = ProtoHelper.getImNetModel(identifier, intValue, iMParam.getParams());
        if (imNetModel == null) {
            return;
        }
        imNetModel.setSocketCallback(new FlutterNetModelAuto.NetModelSocketCallback() { // from class: com.baidu.tieba.flutter.plugin.networkService.NetworkServicePlugin.3
            @Override // com.baidu.tieba.flutter.plugin.networkService.FlutterNetModelAuto.NetModelSocketCallback
            public void onSocketResponseMessage(String str, HashMap hashMap, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage) {
                NetworkServicePlugin.this.netModels.remove(str);
                imNetModel.setSocketCallback(null);
                result.success(NetworkServicePlugin.this.wrapEventData(hashMap, ProtoHelper.parseSocketResp(socketResponsedMessage), socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), str));
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
