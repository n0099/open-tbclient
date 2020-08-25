package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes16.dex */
public class a {
    private int ixf = -1;
    private long ixg = -1;
    private int ixc = b.bik().getInt("nani_key_download_show_position", 3);
    private Set<Integer> ixd = new HashSet();
    private Set<String> ixe = new HashSet();

    public void bd(int i, String str) {
        this.ixe.add(str);
        if (this.ixf < 0 && this.ixc == this.ixe.size()) {
            this.ixf = i;
        }
    }

    public int cuy() {
        return this.ixf;
    }

    public void eK(long j) {
        this.ixg = j;
    }

    public void cuz() {
        int i = b.bik().getInt("nani_key_download_show_rate", 2);
        if (this.ixg > 0 && i != 1) {
            b.bik().putLong("key_horizontal_shown_time", this.ixg);
        }
    }
}
