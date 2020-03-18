package com.baidu.tieba.aiapps.apps.h;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes12.dex */
public class a {
    public final String bjQ;
    public final Map<String, String> bjR = new HashMap();
    public final long delta;
    public final long serverTime;

    public static a baN() {
        return new a(0L);
    }

    private a(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.bjQ = Long.toHexString(gw(this.serverTime + "#" + this.delta));
        this.bjR.put("timestamp", Long.toString(this.serverTime));
        this.bjR.put("delta", Long.toString(this.delta));
        this.bjR.put("rasign", this.bjQ);
    }

    private long gw(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.bjQ;
    }
}
