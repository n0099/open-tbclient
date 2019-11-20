package com.baidu.tieba.aiapps.apps.j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes4.dex */
public class a {
    public final long delta;
    public final String dru;
    public final Map<String, String> drv = new HashMap();
    public final long serverTime;

    public static a aHM() {
        return new a(0L);
    }

    private a(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.dru = Long.toHexString(st(this.serverTime + "#" + this.delta));
        this.drv.put("timestamp", Long.toString(this.serverTime));
        this.drv.put("delta", Long.toString(this.delta));
        this.drv.put("rasign", this.dru);
    }

    private long st(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.dru;
    }
}
