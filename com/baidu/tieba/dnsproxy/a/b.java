package com.baidu.tieba.dnsproxy.a;

import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes13.dex */
public class b {
    String address;
    float ifI;
    private List<Integer> data = new ArrayList();
    boolean ifJ = false;
    boolean ifK = false;

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

    public void xt(int i) {
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
            this.ifI = 0.0f;
        } else if (size == 1) {
            this.ifI = this.data.get(0).intValue();
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
            this.ifI = ((i * f3) / size) + f;
            if (this.ifI < 0.05d) {
                if (!this.ifJ) {
                    com.baidu.tieba.dnsproxy.d.cpV().ay("ip_weight_lower", this.address, String.valueOf(this.ifI));
                    this.ifJ = true;
                }
            } else if (this.ifJ && this.ifI > 0.5d && !this.ifK) {
                com.baidu.tieba.dnsproxy.d.cpV().ay("ip_weight_lower_recover", this.address, String.valueOf(this.ifI));
                this.ifK = true;
            }
        }
    }
}
