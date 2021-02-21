package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private int jNR = -1;
    private long jNS = -1;
    private int jNO = b.brQ().getInt("nani_key_download_show_position", 3);
    private Set<Integer> jNP = new HashSet();
    private Set<String> jNQ = new HashSet();

    public void bC(int i, String str) {
        this.jNQ.add(str);
        if (this.jNR < 0 && this.jNO == this.jNQ.size()) {
            this.jNR = i;
        }
    }

    public int cMz() {
        return this.jNR;
    }

    public void gy(long j) {
        this.jNS = j;
    }

    public void cMA() {
        int i = b.brQ().getInt("nani_key_download_show_rate", 2);
        if (this.jNS > 0 && i != 1) {
            b.brQ().putLong("key_horizontal_shown_time", this.jNS);
        }
    }
}
