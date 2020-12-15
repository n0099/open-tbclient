package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes22.dex */
public class a {
    private int jAg = -1;
    private long jAh = -1;
    private int jAd = b.bsO().getInt("nani_key_download_show_position", 3);
    private Set<Integer> jAe = new HashSet();
    private Set<String> jAf = new HashSet();

    public void bt(int i, String str) {
        this.jAf.add(str);
        if (this.jAg < 0 && this.jAd == this.jAf.size()) {
            this.jAg = i;
        }
    }

    public int cLS() {
        return this.jAg;
    }

    public void gt(long j) {
        this.jAh = j;
    }

    public void cLT() {
        int i = b.bsO().getInt("nani_key_download_show_rate", 2);
        if (this.jAh > 0 && i != 1) {
            b.bsO().putLong("key_horizontal_shown_time", this.jAh);
        }
    }
}
