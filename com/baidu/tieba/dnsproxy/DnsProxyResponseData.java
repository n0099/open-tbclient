package com.baidu.tieba.dnsproxy;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class DnsProxyResponseData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public List<HashMap<String, List<DnsProxyIpData>>> f15303e;

    /* renamed from: f  reason: collision with root package name */
    public int f15304f;

    /* renamed from: g  reason: collision with root package name */
    public String f15305g;

    /* loaded from: classes4.dex */
    public static class DnsProxyIpData extends OrmObject {

        /* renamed from: e  reason: collision with root package name */
        public String f15306e;

        public String getIp() {
            return this.f15306e;
        }

        public void setIp(String str) {
            this.f15306e = str;
        }
    }

    public List<HashMap<String, List<DnsProxyIpData>>> getData() {
        return this.f15303e;
    }

    public String getErrmsg() {
        return this.f15305g;
    }

    public int getErrno() {
        return this.f15304f;
    }
}
