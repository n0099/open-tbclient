package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tieba.dnsproxy.DnsProxyResponseData;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class c extends BdAsyncTask<Collection<String>, HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>, HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>> {
    boolean useCache;

    public c(boolean z) {
        this.useCache = z;
        setPriority(4);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> doInBackground(Collection<String>... collectionArr) {
        Collection<String> collection;
        String str;
        StringBuilder sb;
        l<String> a2 = BdCacheService.lw().a("dnsproxy", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
        if (this.useCache) {
            String str2 = a2.get("dnsproxycachedata");
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
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (collectionArr != null && collectionArr.length == 1 && (collection = collectionArr[0]) != null) {
            String cuj = new a().cuj();
            StringBuilder sb2 = new StringBuilder();
            for (String str3 : collection) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(str3);
            }
            String str4 = "http://" + cuj + "/domains/resolve?domains=" + ((Object) sb2) + "&t=" + System.currentTimeMillis();
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            com.baidu.adp.lib.network.http.c cVar = new com.baidu.adp.lib.network.http.c(eVar);
            eVar.lU().setUrl(str4);
            cVar.d(-1, -1, -1);
            String str5 = null;
            byte[] bArr = eVar.lV().retBytes;
            StringBuilder sb3 = null;
            if (bArr != null) {
                try {
                    str = new String(bArr, "UTF-8");
                } catch (Throwable th) {
                    str = null;
                    str5 = th.getMessage();
                }
                DnsProxyResponseData dnsProxyResponseData2 = (DnsProxyResponseData) DnsProxyResponseData.objectWithJsonStr(str, DnsProxyResponseData.class);
                if (dnsProxyResponseData2 != null && dnsProxyResponseData2.getErrno() == 0) {
                    StringBuilder sb4 = new StringBuilder();
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
                            StringBuilder sb5 = new StringBuilder();
                            for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                                if (dnsProxyIpData != null) {
                                    hashSet.add(dnsProxyIpData.getIp());
                                    if (sb5.length() > 0) {
                                        sb5.append(",");
                                    }
                                    sb5.append(dnsProxyIpData.getIp());
                                }
                            }
                            if (sb5.length() > 0) {
                                sb5.insert(0, ":");
                                sb5.insert(0, (String) entry3.getKey());
                                if (sb4.length() > 0) {
                                    sb4.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                                }
                                sb4.append((CharSequence) sb5);
                            }
                        }
                    }
                    b.cul().g(hashSet);
                    publishProgress(hashMap3);
                    a2.setForever("dnsproxycachedata", str);
                    sb = sb4;
                } else if (dnsProxyResponseData2 == null) {
                    str5 = "parser response error return null";
                    sb = null;
                } else {
                    str5 = dnsProxyResponseData2.getErrno() + " " + dnsProxyResponseData2.getErrmsg();
                    sb = null;
                }
                sb3 = sb;
            } else if (eVar.lX() != null) {
                str5 = eVar.lX().exception;
            } else {
                StringBuilder sb6 = new StringBuilder();
                List<com.baidu.adp.lib.network.http.d> lW = eVar.lW();
                if (lW != null) {
                    for (com.baidu.adp.lib.network.http.d dVar : lW) {
                        if (dVar != null && !TextUtils.isEmpty(dVar.exception)) {
                            if (sb6.length() > 0) {
                                sb6.append(",");
                            }
                            sb6.append(dVar.exception);
                        }
                    }
                }
                if (sb6.length() <= 0) {
                    str5 = "http get data is null";
                } else {
                    str5 = sb6.toString();
                }
            }
            if (TextUtils.isEmpty(str5)) {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_get");
                statsItem.append("issuc", true);
                statsItem.append("comment", sb3 == null ? "" : sb3.toString());
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
            } else {
                com.baidu.adp.lib.stats.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem2.append("workflow", "dnsproxy_get");
                statsItem2.append("issuc", false);
                statsItem2.append("comment", str5);
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem2);
            }
        }
        return null;
    }
}
