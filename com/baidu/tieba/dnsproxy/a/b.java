package com.baidu.tieba.dnsproxy.a;

import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    String address;
    float cGe;
    private List<Integer> data = new ArrayList();
    boolean cGf = false;
    boolean cGg = false;

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

    public void jl(int i) {
        this.data.add(0, Integer.valueOf(i));
        while (this.data.size() > 49) {
            this.data.remove(this.data.size() - 1);
        }
        compute();
    }

    private void compute() {
        float f;
        int i;
        int i2 = 0;
        float f2 = 0.0f;
        int size = this.data.size();
        if (size <= 0) {
            this.cGe = 0.0f;
        } else if (size == 1) {
            this.cGe = this.data.get(0).intValue();
        } else {
            Iterator<Integer> it = this.data.iterator();
            float f3 = 1.0f;
            while (true) {
                f = f2;
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                int intValue = it.next().intValue();
                i2 = i + intValue;
                f3 *= 0.5f;
                f2 = (intValue * f3) + f;
            }
            this.cGe = ((i * f3) / size) + f;
            if (this.cGe < 0.05d) {
                if (!this.cGf) {
                    com.baidu.tieba.dnsproxy.d.ajG().z("ip_weight_lower", this.address, String.valueOf(this.cGe));
                    this.cGf = true;
                }
            } else if (this.cGf && this.cGe > 0.5d && !this.cGg) {
                com.baidu.tieba.dnsproxy.d.ajG().z("ip_weight_lower_recover", this.address, String.valueOf(this.cGe));
                this.cGg = true;
            }
        }
    }
}
