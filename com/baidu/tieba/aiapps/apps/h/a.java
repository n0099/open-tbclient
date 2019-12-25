package com.baidu.tieba.aiapps.apps.h;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes9.dex */
public class a {
    public final String bey;
    public final Map<String, String> bez = new HashMap();
    public final long delta;
    public final long serverTime;

    public static a aXX() {
        return new a(0L);
    }

    private a(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.bey = Long.toHexString(ge(this.serverTime + "#" + this.delta));
        this.bez.put("timestamp", Long.toString(this.serverTime));
        this.bez.put("delta", Long.toString(this.delta));
        this.bez.put("rasign", this.bey);
    }

    private long ge(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.bey;
    }
}
