package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes16.dex */
public class a {
    private int iiZ = -1;
    private long ija = -1;
    private int iiW = b.aZP().getInt("nani_key_download_show_position", 3);
    private Set<Integer> iiX = new HashSet();
    private Set<String> iiY = new HashSet();

    public void bf(int i, String str) {
        this.iiY.add(str);
        if (this.iiZ < 0 && this.iiW == this.iiY.size()) {
            this.iiZ = i;
        }
    }

    public int cjU() {
        return this.iiZ;
    }

    public void ey(long j) {
        this.ija = j;
    }

    public void cjV() {
        int i = b.aZP().getInt("nani_key_download_show_rate", 2);
        if (this.ija > 0 && i != 1) {
            b.aZP().putLong("key_horizontal_shown_time", this.ija);
        }
    }
}
