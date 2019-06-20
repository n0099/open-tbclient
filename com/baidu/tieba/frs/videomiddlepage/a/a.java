package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private int fOQ = -1;
    private long fOR = -1;
    private int fON = b.agM().getInt("nani_key_download_show_position", 3);
    private Set<Integer> fOO = new HashSet();
    private Set<String> fOP = new HashSet();

    public void al(int i, String str) {
        this.fOP.add(str);
        if (this.fOQ < 0 && this.fON == this.fOP.size()) {
            this.fOQ = i;
        }
    }

    public int brr() {
        return this.fOQ;
    }

    public void de(long j) {
        this.fOR = j;
    }

    public void brs() {
        int i = b.agM().getInt("nani_key_download_show_rate", 2);
        if (this.fOR > 0 && i != 1) {
            b.agM().putLong("key_horizontal_shown_time", this.fOR);
        }
    }
}
