package com.baidu.tieba.aiapps.apps.j;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes4.dex */
public class a {
    public final long delta;
    public final String diQ;
    public final Map<String, String> diR = new HashMap();
    public final long serverTime;

    public static a aHB() {
        return new a(0L);
    }

    private a(long j) {
        this.delta = TimeUnit.MILLISECONDS.toSeconds(j);
        this.serverTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.diQ = Long.toHexString(tJ(this.serverTime + "#" + this.delta));
        this.diR.put(DpStatConstants.KEY_TIMESTAMP, Long.toString(this.serverTime));
        this.diR.put("delta", Long.toString(this.delta));
        this.diR.put("rasign", this.diQ);
    }

    private long tJ(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.serverTime + " delta:" + this.delta + " rasign:" + this.diQ;
    }
}
