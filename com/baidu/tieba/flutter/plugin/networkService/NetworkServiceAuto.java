package com.baidu.tieba.flutter.plugin.networkService;

import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class NetworkServiceAuto {

    /* loaded from: classes4.dex */
    public interface HostNetworkService {
        void cancel(NetServiceCancelParam netServiceCancelParam);

        void loadData(LoadDataParam loadDataParam, Result<NetworkResult> result);

        void sendImMessage(IMParam iMParam, Result<NetworkResult> result);
    }

    /* loaded from: classes4.dex */
    public static class IMParam {
        public String identifier;
        public Long msgId;
        public HashMap params;

        public static IMParam fromMap(HashMap hashMap) {
            Long valueOf;
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

        public String getIdentifier() {
            return this.identifier;
        }

        public Long getMsgId() {
            return this.msgId;
        }

        public HashMap getParams() {
            return this.params;
        }

        public void setIdentifier(String str) {
            this.identifier = str;
        }

        public void setMsgId(Long l) {
            this.msgId = l;
        }

        public void setParams(HashMap hashMap) {
            this.params = hashMap;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("identifier", this.identifier);
            hashMap.put("msgId", this.msgId);
            hashMap.put("params", this.params);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class LoadDataParam {
        public String address;
        public Long cmd;
        public HashMap extra;
        public HashMap fileParams;
        public HashMap headers;
        public String host;
        public String identifier;
        public HashMap params;
        public Boolean useProto;

        public static LoadDataParam fromMap(HashMap hashMap) {
            Long valueOf;
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

        public String getAddress() {
            return this.address;
        }

        public Long getCmd() {
            return this.cmd;
        }

        public HashMap getExtra() {
            return this.extra;
        }

        public HashMap getFileParams() {
            return this.fileParams;
        }

        public HashMap getHeaders() {
            return this.headers;
        }

        public String getHost() {
            return this.host;
        }

        public String getIdentifier() {
            return this.identifier;
        }

        public HashMap getParams() {
            return this.params;
        }

        public Boolean getUseProto() {
            return this.useProto;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public void setCmd(Long l) {
            this.cmd = l;
        }

        public void setExtra(HashMap hashMap) {
            this.extra = hashMap;
        }

        public void setFileParams(HashMap hashMap) {
            this.fileParams = hashMap;
        }

        public void setHeaders(HashMap hashMap) {
            this.headers = hashMap;
        }

        public void setHost(String str) {
            this.host = str;
        }

        public void setIdentifier(String str) {
            this.identifier = str;
        }

        public void setParams(HashMap hashMap) {
            this.params = hashMap;
        }

        public void setUseProto(Boolean bool) {
            this.useProto = bool;
        }

        public HashMap toMap() {
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
    }

    /* loaded from: classes4.dex */
    public static class NetServiceCancelParam {
        public ArrayList list;

        public static NetServiceCancelParam fromMap(HashMap hashMap) {
            NetServiceCancelParam netServiceCancelParam = new NetServiceCancelParam();
            netServiceCancelParam.list = (ArrayList) hashMap.get("list");
            return netServiceCancelParam;
        }

        public ArrayList getList() {
            return this.list;
        }

        public void setList(ArrayList arrayList) {
            this.list = arrayList;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("list", this.list);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class NetworkResult {
        public Boolean canceled;
        public String data;
        public String errorMessage;
        public Long errorNumber;
        public String identifier;
        public HashMap performanceInfo;
        public HashMap requestInfo;

        public static NetworkResult fromMap(HashMap hashMap) {
            Long valueOf;
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

        public Boolean getCanceled() {
            return this.canceled;
        }

        public String getData() {
            return this.data;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }

        public Long getErrorNumber() {
            return this.errorNumber;
        }

        public String getIdentifier() {
            return this.identifier;
        }

        public HashMap getPerformanceInfo() {
            return this.performanceInfo;
        }

        public HashMap getRequestInfo() {
            return this.requestInfo;
        }

        public void setCanceled(Boolean bool) {
            this.canceled = bool;
        }

        public void setData(String str) {
            this.data = str;
        }

        public void setErrorMessage(String str) {
            this.errorMessage = str;
        }

        public void setErrorNumber(Long l) {
            this.errorNumber = l;
        }

        public void setIdentifier(String str) {
            this.identifier = str;
        }

        public void setPerformanceInfo(HashMap hashMap) {
            this.performanceInfo = hashMap;
        }

        public void setRequestInfo(HashMap hashMap) {
            this.requestInfo = hashMap;
        }

        public HashMap toMap() {
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
    }

    /* loaded from: classes4.dex */
    public interface Result<T> {
        void success(T t);
    }

    public static HashMap wrapError(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", exc.toString());
        hashMap.put("code", exc.getClass().getSimpleName());
        hashMap.put("details", null);
        return hashMap;
    }
}
