package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes22.dex */
public class a {
    private int jlR = -1;
    private long jlS = -1;
    private int jlO = b.bqh().getInt("nani_key_download_show_position", 3);
    private Set<Integer> jlP = new HashSet();
    private Set<String> jlQ = new HashSet();

    public void bv(int i, String str) {
        this.jlQ.add(str);
        if (this.jlR < 0 && this.jlO == this.jlQ.size()) {
            this.jlR = i;
        }
    }

    public int cGX() {
        return this.jlR;
    }

    public void fL(long j) {
        this.jlS = j;
    }

    public void cGY() {
        int i = b.bqh().getInt("nani_key_download_show_rate", 2);
        if (this.jlS > 0 && i != 1) {
            b.bqh().putLong("key_horizontal_shown_time", this.jlS);
        }
    }
}
