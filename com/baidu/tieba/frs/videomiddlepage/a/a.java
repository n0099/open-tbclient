package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private int jPA = -1;
    private long jPB = -1;
    private int jPx = b.brR().getInt("nani_key_download_show_position", 3);
    private Set<Integer> jPy = new HashSet();
    private Set<String> jPz = new HashSet();

    public void bC(int i, String str) {
        this.jPz.add(str);
        if (this.jPA < 0 && this.jPx == this.jPz.size()) {
            this.jPA = i;
        }
    }

    public int cMF() {
        return this.jPA;
    }

    public void gy(long j) {
        this.jPB = j;
    }

    public void cMG() {
        int i = b.brR().getInt("nani_key_download_show_rate", 2);
        if (this.jPB > 0 && i != 1) {
            b.brR().putLong("key_horizontal_shown_time", this.jPB);
        }
    }
}
