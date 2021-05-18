package com.baidu.tieba.flutter.plugin.networkInfo;

import com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class NetworkInfoAuto {

    /* loaded from: classes4.dex */
    public static class DnsIpResult {
        public String dnsIp;
        public ArrayList dnsIpList;
        public String dnsResolveStatus;
        public String dnsResolveType;

        public static DnsIpResult fromMap(HashMap hashMap) {
            DnsIpResult dnsIpResult = new DnsIpResult();
            dnsIpResult.dnsResolveType = (String) hashMap.get("dnsResolveType");
            dnsIpResult.dnsResolveStatus = (String) hashMap.get("dnsResolveStatus");
            dnsIpResult.dnsIpList = (ArrayList) hashMap.get("dnsIpList");
            dnsIpResult.dnsIp = (String) hashMap.get("dnsIp");
            return dnsIpResult;
        }

        public String getDnsIp() {
            return this.dnsIp;
        }

        public ArrayList getDnsIpList() {
            return this.dnsIpList;
        }

        public String getDnsResolveStatus() {
            return this.dnsResolveStatus;
        }

        public String getDnsResolveType() {
            return this.dnsResolveType;
        }

        public void setDnsIp(String str) {
            this.dnsIp = str;
        }

        public void setDnsIpList(ArrayList arrayList) {
            this.dnsIpList = arrayList;
        }

        public void setDnsResolveStatus(String str) {
            this.dnsResolveStatus = str;
        }

        public void setDnsResolveType(String str) {
            this.dnsResolveType = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("dnsResolveType", this.dnsResolveType);
            hashMap.put("dnsResolveStatus", this.dnsResolveStatus);
            hashMap.put("dnsIpList", this.dnsIpList);
            hashMap.put("dnsIp", this.dnsIp);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class DnsUrl {
        public String url;

        public static DnsUrl fromMap(HashMap hashMap) {
            DnsUrl dnsUrl = new DnsUrl();
            dnsUrl.url = (String) hashMap.get("url");
            return dnsUrl;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("url", this.url);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class FlutterNetworkInfo {
        public final BinaryMessenger binaryMessenger;

        /* loaded from: classes4.dex */
        public interface Reply<T> {
            void reply(T t);
        }

        public FlutterNetworkInfo(BinaryMessenger binaryMessenger) {
            this.binaryMessenger = binaryMessenger;
        }

        public void setNetInfo(NetworkStatus networkStatus, final Reply<SetNetInfoResult> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterNetworkInfo.setNetInfo", new StandardMessageCodec()).send(networkStatus.toMap(), new BasicMessageChannel.Reply() { // from class: d.a.k0.m0.a.e.a
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    NetworkInfoAuto.FlutterNetworkInfo.Reply.this.reply(NetworkInfoAuto.SetNetInfoResult.fromMap((HashMap) obj));
                }
            });
        }
    }

    /* loaded from: classes4.dex */
    public interface HostNetworkInfo {
        void getDnsIp(DnsUrl dnsUrl, Result<DnsIpResult> result);

        void getNetInfo(Result<NetworkStatus> result);

        void isNetWorkAvailable(Result<NetWorkAvailable> result);

        void isNetworkAvailableForImmediately(Result<NetWorkAvailable> result);
    }

    /* loaded from: classes4.dex */
    public static class NetWorkAvailable {
        public Boolean isAvailable;

        public static NetWorkAvailable fromMap(HashMap hashMap) {
            NetWorkAvailable netWorkAvailable = new NetWorkAvailable();
            netWorkAvailable.isAvailable = (Boolean) hashMap.get("isAvailable");
            return netWorkAvailable;
        }

        public Boolean getIsAvailable() {
            return this.isAvailable;
        }

        public void setIsAvailable(Boolean bool) {
            this.isAvailable = bool;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("isAvailable", this.isAvailable);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public static class NetworkStatus {
        public Boolean isNetOk;
        public Long netType;
        public String netTypeString;

        public static NetworkStatus fromMap(HashMap hashMap) {
            Long valueOf;
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

        public Boolean getIsNetOk() {
            return this.isNetOk;
        }

        public Long getNetType() {
            return this.netType;
        }

        public String getNetTypeString() {
            return this.netTypeString;
        }

        public void setIsNetOk(Boolean bool) {
            this.isNetOk = bool;
        }

        public void setNetType(Long l) {
            this.netType = l;
        }

        public void setNetTypeString(String str) {
            this.netTypeString = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("isNetOk", this.isNetOk);
            hashMap.put("netTypeString", this.netTypeString);
            hashMap.put("netType", this.netType);
            return hashMap;
        }
    }

    /* loaded from: classes4.dex */
    public interface Result<T> {
        void success(T t);
    }

    /* loaded from: classes4.dex */
    public static class SetNetInfoResult {
        public Boolean result;

        public static SetNetInfoResult fromMap(HashMap hashMap) {
            SetNetInfoResult setNetInfoResult = new SetNetInfoResult();
            setNetInfoResult.result = (Boolean) hashMap.get("result");
            return setNetInfoResult;
        }

        public Boolean getResult() {
            return this.result;
        }

        public void setResult(Boolean bool) {
            this.result = bool;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.result);
            return hashMap;
        }
    }

    public static HashMap wrapError(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", exc.toString());
        hashMap.put("code", exc.getClass().getSimpleName());
        hashMap.put("details", null);
        return hashMap;
    }
}
