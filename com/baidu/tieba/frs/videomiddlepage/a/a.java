package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private int jHZ = -1;
    private long jIa = -1;
    private int jHW = b.brx().getInt("nani_key_download_show_position", 3);
    private Set<Integer> jHX = new HashSet();
    private Set<String> jHY = new HashSet();

    public void bw(int i, String str) {
        this.jHY.add(str);
        if (this.jHZ < 0 && this.jHW == this.jHY.size()) {
            this.jHZ = i;
        }
    }

    public int cLe() {
        return this.jHZ;
    }

    public void gt(long j) {
        this.jIa = j;
    }

    public void cLf() {
        int i = b.brx().getInt("nani_key_download_show_rate", 2);
        if (this.jIa > 0 && i != 1) {
            b.brx().putLong("key_horizontal_shown_time", this.jIa);
        }
    }
}
