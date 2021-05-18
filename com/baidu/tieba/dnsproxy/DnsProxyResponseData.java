package com.baidu.tieba.dnsproxy;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class DnsProxyResponseData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public List<HashMap<String, List<DnsProxyIpData>>> f14406e;

    /* renamed from: f  reason: collision with root package name */
    public int f14407f;

    /* renamed from: g  reason: collision with root package name */
    public String f14408g;

    /* loaded from: classes4.dex */
    public static class DnsProxyIpData extends OrmObject {

        /* renamed from: e  reason: collision with root package name */
        public String f14409e;

        public String getIp() {
            return this.f14409e;
        }

        public void setIp(String str) {
            this.f14409e = str;
        }
    }

    public List<HashMap<String, List<DnsProxyIpData>>> getData() {
        return this.f14406e;
    }

    public String getErrmsg() {
        return this.f14408g;
    }

    public int getErrno() {
        return this.f14407f;
    }
}
