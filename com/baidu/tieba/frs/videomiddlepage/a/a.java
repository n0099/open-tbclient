package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes22.dex */
public class a {
    private int jAe = -1;
    private long jAf = -1;
    private int jAb = b.bsO().getInt("nani_key_download_show_position", 3);
    private Set<Integer> jAc = new HashSet();
    private Set<String> jAd = new HashSet();

    public void bt(int i, String str) {
        this.jAd.add(str);
        if (this.jAe < 0 && this.jAb == this.jAd.size()) {
            this.jAe = i;
        }
    }

    public int cLR() {
        return this.jAe;
    }

    public void gt(long j) {
        this.jAf = j;
    }

    public void cLS() {
        int i = b.bsO().getInt("nani_key_download_show_rate", 2);
        if (this.jAf > 0 && i != 1) {
            b.bsO().putLong("key_horizontal_shown_time", this.jAf);
        }
    }
}
