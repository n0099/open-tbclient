package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private int fOO = -1;
    private long fOP = -1;
    private int fOL = b.agM().getInt("nani_key_download_show_position", 3);
    private Set<Integer> fOM = new HashSet();
    private Set<String> fON = new HashSet();

    public void al(int i, String str) {
        this.fON.add(str);
        if (this.fOO < 0 && this.fOL == this.fON.size()) {
            this.fOO = i;
        }
    }

    public int brp() {
        return this.fOO;
    }

    public void de(long j) {
        this.fOP = j;
    }

    public void brq() {
        int i = b.agM().getInt("nani_key_download_show_rate", 2);
        if (this.fOP > 0 && i != 1) {
            b.agM().putLong("key_horizontal_shown_time", this.fOP);
        }
    }
}
