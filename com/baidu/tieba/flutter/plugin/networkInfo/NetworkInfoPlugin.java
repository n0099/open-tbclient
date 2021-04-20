package com.baidu.tieba.flutter.plugin.networkInfo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.tbadk.core.util.httpNet.NetWorkUtil;
import com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto;
import d.b.c.e.j.a.a;
import d.b.c.e.p.j;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class NetworkInfoPlugin implements FlutterPlugin, NetworkInfoAuto.HostNetworkInfo {
    public NetworkInfoAuto.FlutterNetworkInfo mFlutterNetworkInfo;
    public CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoPlugin.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
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
                if (NetworkInfoPlugin.this.mFlutterNetworkInfo != null) {
                    NetworkInfoPlugin.this.mFlutterNetworkInfo.setNetInfo(networkStatus, new NetworkInfoAuto.FlutterNetworkInfo.Reply<NetworkInfoAuto.SetNetInfoResult>() { // from class: com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoPlugin.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.FlutterNetworkInfo.Reply
                        public void reply(NetworkInfoAuto.SetNetInfoResult setNetInfoResult) {
                            BdLog.i("setNetInfo result:" + setNetInfoResult.getResult());
                        }
                    });
                }
            }
        }
    };

    private String resolveStatusString(BDHttpDnsResult.ResolveStatus resolveStatus) {
        return resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK ? "BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK" : resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsInputError ? "BDHttpDnsResult.ResolveStatus.BDHttpDnsInputError" : resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss ? "BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss" : resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve ? "BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve" : "";
    }

    private String resolveTypeString(BDHttpDnsResult.ResolveType resolveType) {
        return resolveType == BDHttpDnsResult.ResolveType.RESOLVE_NONE ? "BDHttpDnsResult.ResolveType.RESOLVE_NONE" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_NONEED ? "BDHttpDnsResult.ResolveType.RESOLVE_NONEED" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE ? "BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE ? "BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE ? "BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE" : resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS ? "BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS" : "";
    }

    @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.HostNetworkInfo
    public void getDnsIp(NetworkInfoAuto.DnsUrl dnsUrl, NetworkInfoAuto.Result<NetworkInfoAuto.DnsIpResult> result) {
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

    @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.HostNetworkInfo
    public void getNetInfo(NetworkInfoAuto.Result<NetworkInfoAuto.NetworkStatus> result) {
        NetworkInfoAuto.NetworkStatus networkStatus = new NetworkInfoAuto.NetworkStatus();
        networkStatus.setIsNetOk(Boolean.valueOf(j.z()));
        networkStatus.setNetType(Long.valueOf(j.I()));
        networkStatus.setNetTypeString(NetWorkUtil.getNetType());
        result.success(networkStatus);
    }

    @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.HostNetworkInfo
    public void isNetWorkAvailable(NetworkInfoAuto.Result<NetworkInfoAuto.NetWorkAvailable> result) {
        NetworkInfoAuto.NetWorkAvailable netWorkAvailable = new NetworkInfoAuto.NetWorkAvailable();
        netWorkAvailable.setIsAvailable(Boolean.valueOf(j.z()));
        result.success(netWorkAvailable);
    }

    @Override // com.baidu.tieba.flutter.plugin.networkInfo.NetworkInfoAuto.HostNetworkInfo
    public void isNetworkAvailableForImmediately(NetworkInfoAuto.Result<NetworkInfoAuto.NetWorkAvailable> result) {
        NetworkInfoAuto.NetWorkAvailable netWorkAvailable = new NetworkInfoAuto.NetWorkAvailable();
        netWorkAvailable.setIsAvailable(Boolean.valueOf(j.A()));
        result.success(netWorkAvailable);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.mFlutterNetworkInfo = new NetworkInfoAuto.FlutterNetworkInfo(flutterPluginBinding.getBinaryMessenger());
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        d.b.i0.m0.a.e.j.i(flutterPluginBinding.getBinaryMessenger(), this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedListener);
        this.mFlutterNetworkInfo = null;
        d.b.i0.m0.a.e.j.i(flutterPluginBinding.getBinaryMessenger(), null);
    }
}
