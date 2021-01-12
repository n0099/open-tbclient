package com.baidu.tieba.dnsproxy.a;

import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    String address;
    float iyZ;
    private List<Integer> data = new ArrayList();
    boolean iza = false;
    boolean izb = false;

    public static final b a(DnsIpData dnsIpData) {
        if (dnsIpData == null) {
            return null;
        }
        b bVar = new b();
        bVar.address = dnsIpData.address;
        for (int i = 0; i < dnsIpData.data.size(); i++) {
            bVar.data.add(dnsIpData.data.get(i));
        }
        bVar.compute();
        return bVar;
    }

    public static final DnsIpData a(b bVar) {
        if (bVar == null) {
            return null;
        }
        DnsIpData.Builder builder = new DnsIpData.Builder();
        builder.address = bVar.address;
        builder.data = new ArrayList();
        for (Integer num : bVar.data) {
            builder.data.add(Integer.valueOf(num.intValue()));
        }
        return builder.build(true);
    }

    public void xd(int i) {
        this.data.add(0, Integer.valueOf(i));
        while (this.data.size() > 49) {
            this.data.remove(this.data.size() - 1);
        }
        compute();
    }

    private void compute() {
        int i;
        int i2 = 0;
        float f = 0.0f;
        int size = this.data.size();
        if (size <= 0) {
            this.iyZ = 0.0f;
        } else if (size == 1) {
            this.iyZ = this.data.get(0).intValue();
        } else {
            float f2 = 1.0f;
            Iterator<Integer> it = this.data.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                int intValue = it.next().intValue();
                i2 = i + intValue;
                f2 *= 0.5f;
                f += intValue * f2;
            }
            this.iyZ = ((i * f2) / size) + f;
            if (this.iyZ < 0.05d) {
                if (!this.iza) {
                    com.baidu.tieba.dnsproxy.d.csN().aC("ip_weight_lower", this.address, String.valueOf(this.iyZ));
                    this.iza = true;
                }
            } else if (this.iza && this.iyZ > 0.5d && !this.izb) {
                com.baidu.tieba.dnsproxy.d.csN().aC("ip_weight_lower_recover", this.address, String.valueOf(this.iyZ));
                this.izb = true;
            }
        }
    }
}
