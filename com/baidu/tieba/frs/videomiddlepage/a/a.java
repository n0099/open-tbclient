package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private int jMF = -1;
    private long jMG = -1;
    private int jMC = b.bvr().getInt("nani_key_download_show_position", 3);
    private Set<Integer> jMD = new HashSet();
    private Set<String> jME = new HashSet();

    public void bv(int i, String str) {
        this.jME.add(str);
        if (this.jMF < 0 && this.jMC == this.jME.size()) {
            this.jMF = i;
        }
    }

    public int cOW() {
        return this.jMF;
    }

    public void gt(long j) {
        this.jMG = j;
    }

    public void cOX() {
        int i = b.bvr().getInt("nani_key_download_show_rate", 2);
        if (this.jMG > 0 && i != 1) {
            b.bvr().putLong("key_horizontal_shown_time", this.jMG);
        }
    }
}
