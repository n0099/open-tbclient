package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes16.dex */
public class a {
    private int ijb = -1;
    private long ijc = -1;
    private int iiY = b.aZP().getInt("nani_key_download_show_position", 3);
    private Set<Integer> iiZ = new HashSet();
    private Set<String> ija = new HashSet();

    public void bf(int i, String str) {
        this.ija.add(str);
        if (this.ijb < 0 && this.iiY == this.ija.size()) {
            this.ijb = i;
        }
    }

    public int cjU() {
        return this.ijb;
    }

    public void ey(long j) {
        this.ijc = j;
    }

    public void cjV() {
        int i = b.aZP().getInt("nani_key_download_show_rate", 2);
        if (this.ijc > 0 && i != 1) {
            b.aZP().putLong("key_horizontal_shown_time", this.ijc);
        }
    }
}
