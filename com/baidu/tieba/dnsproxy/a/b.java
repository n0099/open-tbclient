package com.baidu.tieba.dnsproxy.a;

import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    String address;
    float iDG;
    private List<Integer> data = new ArrayList();
    boolean iDH = false;
    boolean iDI = false;

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

    public void yJ(int i) {
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
            this.iDG = 0.0f;
        } else if (size == 1) {
            this.iDG = this.data.get(0).intValue();
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
            this.iDG = ((i * f2) / size) + f;
            if (this.iDG < 0.05d) {
                if (!this.iDH) {
                    com.baidu.tieba.dnsproxy.d.cwE().aD("ip_weight_lower", this.address, String.valueOf(this.iDG));
                    this.iDH = true;
                }
            } else if (this.iDH && this.iDG > 0.5d && !this.iDI) {
                com.baidu.tieba.dnsproxy.d.cwE().aD("ip_weight_lower_recover", this.address, String.valueOf(this.iDG));
                this.iDI = true;
            }
        }
    }
}
