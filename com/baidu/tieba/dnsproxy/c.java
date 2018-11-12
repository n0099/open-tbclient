package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tieba.dnsproxy.DnsProxyResponseData;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes3.dex */
public class c extends BdAsyncTask<Collection<String>, HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>, HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>> {
    boolean dek;

    public c(boolean z) {
        this.dek = z;
        setPriority(4);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> doInBackground(Collection<String>... collectionArr) {
        Collection<String> collection;
        String sb;
        String str;
        StringBuilder sb2;
        l<String> a = BdCacheService.iy().a("dnsproxy", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
        if (this.dek) {
            String str2 = a.get("dnsproxycachedata");
            if (str2 != null) {
                DnsProxyResponseData dnsProxyResponseData = (DnsProxyResponseData) DnsProxyResponseData.objectWithJsonStr(str2, DnsProxyResponseData.class);
                if (dnsProxyResponseData == null || dnsProxyResponseData.getErrno() != 0) {
                    publishProgress(null);
                } else {
                    List<HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>> data = dnsProxyResponseData.getData();
                    HashMap hashMap = new HashMap(data.size());
                    for (HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap2 : data) {
                        for (Map.Entry<String, List<DnsProxyResponseData.DnsProxyIpData>> entry : hashMap2.entrySet()) {
                            hashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    publishProgress(hashMap);
                }
            } else {
                publishProgress(null);
            }
            return null;
        }
        try {
            Thread.sleep(SystemScreenshotManager.DELAY_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (collectionArr != null && collectionArr.length == 1 && (collection = collectionArr[0]) != null) {
            String asf = new a().asf();
            StringBuilder sb3 = new StringBuilder();
            for (String str3 : collection) {
                if (sb3.length() > 0) {
                    sb3.append(",");
                }
                sb3.append(str3);
            }
            String str4 = "http://" + asf + "/domains/resolve?domains=" + ((Object) sb3) + "&t=" + System.currentTimeMillis();
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            com.baidu.adp.lib.network.http.c cVar = new com.baidu.adp.lib.network.http.c(eVar);
            eVar.jp().setUrl(str4);
            cVar.e(-1, -1, -1);
            byte[] bArr = eVar.jq().Dg;
            StringBuilder sb4 = null;
            if (bArr != null) {
                try {
                    String str5 = new String(bArr, "UTF-8");
                    sb = null;
                    str = str5;
                } catch (Throwable th) {
                    str = null;
                    sb = th.getMessage();
                }
                DnsProxyResponseData dnsProxyResponseData2 = (DnsProxyResponseData) DnsProxyResponseData.objectWithJsonStr(str, DnsProxyResponseData.class);
                if (dnsProxyResponseData2 != null && dnsProxyResponseData2.getErrno() == 0) {
                    StringBuilder sb5 = new StringBuilder();
                    List<HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>> data2 = dnsProxyResponseData2.getData();
                    HashSet hashSet = new HashSet();
                    HashMap hashMap3 = new HashMap(data2.size());
                    for (HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap4 : data2) {
                        for (Map.Entry<String, List<DnsProxyResponseData.DnsProxyIpData>> entry2 : hashMap4.entrySet()) {
                            hashMap3.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    for (Map.Entry entry3 : hashMap3.entrySet()) {
                        List<DnsProxyResponseData.DnsProxyIpData> list = (List) entry3.getValue();
                        if (list != null && list.size() > 0) {
                            StringBuilder sb6 = new StringBuilder();
                            for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                                if (dnsProxyIpData != null) {
                                    hashSet.add(dnsProxyIpData.getIp());
                                    if (sb6.length() > 0) {
                                        sb6.append(",");
                                    }
                                    sb6.append(dnsProxyIpData.getIp());
                                }
                            }
                            if (sb6.length() > 0) {
                                sb6.insert(0, ":");
                                sb6.insert(0, (String) entry3.getKey());
                                if (sb5.length() > 0) {
                                    sb5.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                                }
                                sb5.append((CharSequence) sb6);
                            }
                        }
                    }
                    b.ash().e(hashSet);
                    publishProgress(hashMap3);
                    a.e("dnsproxycachedata", str);
                    sb2 = sb5;
                } else if (dnsProxyResponseData2 == null) {
                    sb = "parser response error return null";
                    sb2 = null;
                } else {
                    sb = dnsProxyResponseData2.getErrno() + " " + dnsProxyResponseData2.getErrmsg();
                    sb2 = null;
                }
                sb4 = sb2;
            } else if (eVar.js() != null) {
                sb = eVar.js().CL;
            } else {
                StringBuilder sb7 = new StringBuilder();
                List<com.baidu.adp.lib.network.http.d> jr = eVar.jr();
                if (jr != null) {
                    for (com.baidu.adp.lib.network.http.d dVar : jr) {
                        if (dVar != null && !TextUtils.isEmpty(dVar.CL)) {
                            if (sb7.length() > 0) {
                                sb7.append(",");
                            }
                            sb7.append(dVar.CL);
                        }
                    }
                }
                if (sb7.length() <= 0) {
                    sb = "http get data is null";
                } else {
                    sb = sb7.toString();
                }
            }
            if (TextUtils.isEmpty(sb)) {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_get");
                statsItem.f("issuc", true);
                statsItem.append(ClientCookie.COMMENT_ATTR, sb4 == null ? "" : sb4.toString());
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
            } else {
                com.baidu.adp.lib.stats.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem2.append("workflow", "dnsproxy_get");
                statsItem2.f("issuc", false);
                statsItem2.append(ClientCookie.COMMENT_ATTR, sb);
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem2);
            }
        }
        return null;
    }
}
