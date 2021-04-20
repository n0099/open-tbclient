package com.baidu.tieba.dnsproxy;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class DnsProxyResponseData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public List<HashMap<String, List<DnsProxyIpData>>> f14967e;

    /* renamed from: f  reason: collision with root package name */
    public int f14968f;

    /* renamed from: g  reason: collision with root package name */
    public String f14969g;

    /* loaded from: classes4.dex */
    public static class DnsProxyIpData extends OrmObject {

        /* renamed from: e  reason: collision with root package name */
        public String f14970e;

        public String getIp() {
            return this.f14970e;
        }

        public void setIp(String str) {
            this.f14970e = str;
        }
    }

    public List<HashMap<String, List<DnsProxyIpData>>> getData() {
        return this.f14967e;
    }

    public String getErrmsg() {
        return this.f14969g;
    }

    public int getErrno() {
        return this.f14968f;
    }
}
