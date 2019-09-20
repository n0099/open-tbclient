package com.baidu.tieba.dnsproxy.a;

import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    String address;
    float eUQ;
    private List<Integer> data = new ArrayList();
    boolean eUR = false;
    boolean eUS = false;

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

    public void qn(int i) {
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
            this.eUQ = 0.0f;
        } else if (size == 1) {
            this.eUQ = this.data.get(0).intValue();
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
            this.eUQ = ((i * f3) / size) + f;
            if (this.eUQ < 0.05d) {
                if (!this.eUR) {
                    com.baidu.tieba.dnsproxy.d.beO().T("ip_weight_lower", this.address, String.valueOf(this.eUQ));
                    this.eUR = true;
                }
            } else if (this.eUR && this.eUQ > 0.5d && !this.eUS) {
                com.baidu.tieba.dnsproxy.d.beO().T("ip_weight_lower_recover", this.address, String.valueOf(this.eUQ));
                this.eUS = true;
            }
        }
    }
}
