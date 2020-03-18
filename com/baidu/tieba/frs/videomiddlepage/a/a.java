package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    private int gQg = -1;
    private long gQh = -1;
    private int gQd = b.aFH().getInt("nani_key_download_show_position", 3);
    private Set<Integer> gQe = new HashSet();
    private Set<String> gQf = new HashSet();

    public void aF(int i, String str) {
        this.gQf.add(str);
        if (this.gQg < 0 && this.gQd == this.gQf.size()) {
            this.gQg = i;
        }
    }

    public int bLQ() {
        return this.gQg;
    }

    public void dy(long j) {
        this.gQh = j;
    }

    public void bLR() {
        int i = b.aFH().getInt("nani_key_download_show_rate", 2);
        if (this.gQh > 0 && i != 1) {
            b.aFH().putLong("key_horizontal_shown_time", this.gQh);
        }
    }
}
