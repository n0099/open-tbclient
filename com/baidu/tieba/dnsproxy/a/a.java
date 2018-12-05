package com.baidu.tieba.dnsproxy.a;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    HashMap<String, b> dlm = new HashMap<>();
    HashMap<String, b> dln = new HashMap<>();
    long dlo;
    long dlp;
    String name;

    public static final String aud() {
        String str;
        WifiInfo connectionInfo;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkCoreApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                String typeName = activeNetworkInfo.getTypeName();
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (TextUtils.isEmpty(typeName)) {
                    str = extraInfo;
                } else {
                    str = (TextUtils.isEmpty(extraInfo) && typeName.equalsIgnoreCase("WIFI") && (connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getContext().getSystemService("wifi")).getConnectionInfo()) != null) ? connectionInfo.getBSSID() : extraInfo;
                    if (!TextUtils.isEmpty(str)) {
                        return typeName + BaseRequestAction.SPLITE + str;
                    }
                }
                com.baidu.tieba.dnsproxy.d.atU().aX("get_connectpoint_null", typeName + BaseRequestAction.SPLITE + str);
            }
        } catch (Throwable th) {
            BdLog.detailException(th);
            com.baidu.tieba.dnsproxy.d.atU().aX("get_connectpoint_name", th.getMessage());
        }
        return null;
    }

    public static final a a(ConnectPointData connectPointData) {
        if (connectPointData == null) {
            return null;
        }
        a aVar = new a();
        aVar.name = connectPointData.name;
        aVar.dlo = connectPointData.last_connect_rate_update_time.longValue();
        aVar.dlp = connectPointData.last_speed_data_update_time.longValue();
        for (DnsIpData dnsIpData : connectPointData.dns_ip_connect_rate) {
            b a = b.a(dnsIpData);
            if (a != null) {
                aVar.dlm.put(a.address, a);
            }
        }
        for (DnsIpData dnsIpData2 : connectPointData.dns_ip_speed_data) {
            b a2 = b.a(dnsIpData2);
            if (a2 != null) {
                aVar.dln.put(a2.address, a2);
            }
        }
        return aVar;
    }

    public static final ConnectPointData a(a aVar) {
        if (aVar == null) {
            return null;
        }
        ConnectPointData.Builder builder = new ConnectPointData.Builder();
        builder.name = aVar.name;
        builder.last_connect_rate_update_time = Long.valueOf(aVar.dlo);
        builder.last_speed_data_update_time = Long.valueOf(aVar.dlp);
        builder.dns_ip_connect_rate = new ArrayList();
        builder.dns_ip_speed_data = new ArrayList();
        for (Map.Entry<String, b> entry : aVar.dlm.entrySet()) {
            DnsIpData a = b.a(entry.getValue());
            if (a != null) {
                builder.dns_ip_connect_rate.add(a);
            }
        }
        for (Map.Entry<String, b> entry2 : aVar.dln.entrySet()) {
            DnsIpData a2 = b.a(entry2.getValue());
            if (a2 != null) {
                builder.dns_ip_speed_data.add(a2);
            }
        }
        return builder.build(true);
    }
}
