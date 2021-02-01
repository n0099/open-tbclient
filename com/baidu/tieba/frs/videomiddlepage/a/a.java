package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private int jND = -1;
    private long jNE = -1;
    private int jNA = b.brQ().getInt("nani_key_download_show_position", 3);
    private Set<Integer> jNB = new HashSet();
    private Set<String> jNC = new HashSet();

    public void bC(int i, String str) {
        this.jNC.add(str);
        if (this.jND < 0 && this.jNA == this.jNC.size()) {
            this.jND = i;
        }
    }

    public int cMs() {
        return this.jND;
    }

    public void gy(long j) {
        this.jNE = j;
    }

    public void cMt() {
        int i = b.brQ().getInt("nani_key_download_show_rate", 2);
        if (this.jNE > 0 && i != 1) {
            b.brQ().putLong("key_horizontal_shown_time", this.jNE);
        }
    }
}
