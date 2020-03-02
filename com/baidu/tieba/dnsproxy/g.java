package com.baidu.tieba.dnsproxy;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.dnsproxy.DnsProxyResponseData;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class g extends BdAsyncTask<Collection<String>, Void, HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> doInBackground(Collection<String>... collectionArr) {
        Collection<String> collection;
        if (collectionArr == null || collectionArr.length != 1 || (collection = collectionArr[0]) == null) {
            return null;
        }
        HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap = new HashMap<>(collection.size());
        for (String str : collection) {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null) {
                    ArrayList arrayList = new ArrayList(allByName.length);
                    for (InetAddress inetAddress : allByName) {
                        if (inetAddress != null) {
                            DnsProxyResponseData.DnsProxyIpData dnsProxyIpData = new DnsProxyResponseData.DnsProxyIpData();
                            dnsProxyIpData.setIp(inetAddress.getHostAddress());
                            arrayList.add(dnsProxyIpData);
                        }
                    }
                    hashMap.put(str, arrayList);
                }
            } catch (UnknownHostException e) {
                BdLog.detailException(e);
                d.bwM().bx("sysdns_get", e.getMessage());
            } catch (Throwable th) {
                BdLog.detailException(th);
                d.bwM().bx("sysdns_get", th.getMessage());
            }
        }
        return hashMap;
    }
}
