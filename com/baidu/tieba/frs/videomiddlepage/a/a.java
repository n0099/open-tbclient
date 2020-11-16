package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes21.dex */
public class a {
    private int jmC = -1;
    private long jmD = -1;
    private int jmz = b.bpu().getInt("nani_key_download_show_position", 3);
    private Set<Integer> jmA = new HashSet();
    private Set<String> jmB = new HashSet();

    public void bt(int i, String str) {
        this.jmB.add(str);
        if (this.jmC < 0 && this.jmz == this.jmB.size()) {
            this.jmC = i;
        }
    }

    public int cGC() {
        return this.jmC;
    }

    public void fO(long j) {
        this.jmD = j;
    }

    public void cGD() {
        int i = b.bpu().getInt("nani_key_download_show_rate", 2);
        if (this.jmD > 0 && i != 1) {
            b.bpu().putLong("key_horizontal_shown_time", this.jmD);
        }
    }
}
