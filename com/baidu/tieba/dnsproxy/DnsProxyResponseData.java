package com.baidu.tieba.dnsproxy;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class DnsProxyResponseData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public List<HashMap<String, List<DnsProxyIpData>>> f15091e;

    /* renamed from: f  reason: collision with root package name */
    public int f15092f;

    /* renamed from: g  reason: collision with root package name */
    public String f15093g;

    /* loaded from: classes4.dex */
    public static class DnsProxyIpData extends OrmObject {

        /* renamed from: e  reason: collision with root package name */
        public String f15094e;

        public String getIp() {
            return this.f15094e;
        }

        public void setIp(String str) {
            this.f15094e = str;
        }
    }

    public List<HashMap<String, List<DnsProxyIpData>>> getData() {
        return this.f15091e;
    }

    public String getErrmsg() {
        return this.f15093g;
    }

    public int getErrno() {
        return this.f15092f;
    }
}
