package com.baidu.tieba.aiapps.apps.i;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes4.dex */
public class a {
    public final String cVU;
    public final Map<String, String> cVV = new HashMap();
    public final long delta;
    public final long serverTime;

    public static a azG() {
        return new a(0L);
    }

    private a(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.cVU = Long.toHexString(rG(this.serverTime + "#" + this.delta));
        this.cVV.put("timestamp", Long.toString(this.serverTime));
        this.cVV.put("delta", Long.toString(this.delta));
        this.cVV.put("rasign", this.cVU);
    }

    private long rG(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.cVU;
    }
}
