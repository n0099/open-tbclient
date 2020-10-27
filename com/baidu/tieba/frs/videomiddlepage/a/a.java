package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes22.dex */
public class a {
    private int jfT = -1;
    private long jfU = -1;
    private int jfQ = b.bnH().getInt("nani_key_download_show_position", 3);
    private Set<Integer> jfR = new HashSet();
    private Set<String> jfS = new HashSet();

    public void br(int i, String str) {
        this.jfS.add(str);
        if (this.jfT < 0 && this.jfQ == this.jfS.size()) {
            this.jfT = i;
        }
    }

    public int cEw() {
        return this.jfT;
    }

    public void fp(long j) {
        this.jfU = j;
    }

    public void cEx() {
        int i = b.bnH().getInt("nani_key_download_show_rate", 2);
        if (this.jfU > 0 && i != 1) {
            b.bnH().putLong("key_horizontal_shown_time", this.jfU);
        }
    }
}
