package com.baidu.tieba.dnsproxy;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class DnsProxyResponseData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public List<HashMap<String, List<DnsProxyIpData>>> f14448e;

    /* renamed from: f  reason: collision with root package name */
    public int f14449f;

    /* renamed from: g  reason: collision with root package name */
    public String f14450g;

    /* loaded from: classes4.dex */
    public static class DnsProxyIpData extends OrmObject {

        /* renamed from: e  reason: collision with root package name */
        public String f14451e;

        public String getIp() {
            return this.f14451e;
        }

        public void setIp(String str) {
            this.f14451e = str;
        }
    }

    public List<HashMap<String, List<DnsProxyIpData>>> getData() {
        return this.f14448e;
    }

    public String getErrmsg() {
        return this.f14450g;
    }

    public int getErrno() {
        return this.f14449f;
    }
}
