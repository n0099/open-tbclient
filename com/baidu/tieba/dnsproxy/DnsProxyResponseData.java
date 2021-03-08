package com.baidu.tieba.dnsproxy;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class DnsProxyResponseData extends OrmObject {
    private List<HashMap<String, List<DnsProxyIpData>>> data;
    private String errmsg;
    private int errno;

    public List<HashMap<String, List<DnsProxyIpData>>> getData() {
        return this.data;
    }

    public int getErrno() {
        return this.errno;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    /* loaded from: classes7.dex */
    public static class DnsProxyIpData extends OrmObject {
        private String ip;

        public String getIp() {
            return this.ip;
        }

        public void setIp(String str) {
            this.ip = str;
        }
    }
}
