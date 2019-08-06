package com.baidu.tieba.dnsproxy.a;

import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    String address;
    float eTk;
    private List<Integer> data = new ArrayList();
    boolean eTl = false;
    boolean eTm = false;

    public static final b a(DnsIpData dnsIpData) {
        if (dnsIpData == null) {
            return null;
        }
        b bVar = new b();
        bVar.address = dnsIpData.address;
        for (int i = 0; i < dnsIpData.data.size(); i++) {
            bVar.data.add(dnsIpData.data.get(i));
        }
        bVar.nu();
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

    public void qk(int i) {
        this.data.add(0, Integer.valueOf(i));
        while (this.data.size() > 49) {
            this.data.remove(this.data.size() - 1);
        }
        nu();
    }

    private void nu() {
        float f;
        int i;
        int i2 = 0;
        float f2 = 0.0f;
        int size = this.data.size();
        if (size <= 0) {
            this.eTk = 0.0f;
        } else if (size == 1) {
            this.eTk = this.data.get(0).intValue();
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
            this.eTk = ((i * f3) / size) + f;
            if (this.eTk < 0.05d) {
                if (!this.eTl) {
                    com.baidu.tieba.dnsproxy.d.bek().R("ip_weight_lower", this.address, String.valueOf(this.eTk));
                    this.eTl = true;
                }
            } else if (this.eTl && this.eTk > 0.5d && !this.eTm) {
                com.baidu.tieba.dnsproxy.d.bek().R("ip_weight_lower_recover", this.address, String.valueOf(this.eTk));
                this.eTm = true;
            }
        }
    }
}
