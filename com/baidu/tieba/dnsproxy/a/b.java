package com.baidu.tieba.dnsproxy.a;

import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    String address;
    float iGG;
    private List<Integer> data = new ArrayList();
    boolean iGH = false;
    boolean iGI = false;

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

    public void xo(int i) {
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
            this.iGG = 0.0f;
        } else if (size == 1) {
            this.iGG = this.data.get(0).intValue();
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
            this.iGG = ((i * f2) / size) + f;
            if (this.iGG < 0.05d) {
                if (!this.iGH) {
                    com.baidu.tieba.dnsproxy.d.cum().aD("ip_weight_lower", this.address, String.valueOf(this.iGG));
                    this.iGH = true;
                }
            } else if (this.iGH && this.iGG > 0.5d && !this.iGI) {
                com.baidu.tieba.dnsproxy.d.cum().aD("ip_weight_lower_recover", this.address, String.valueOf(this.iGG));
                this.iGI = true;
            }
        }
    }
}
