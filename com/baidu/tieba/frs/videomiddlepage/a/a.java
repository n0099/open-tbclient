package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes16.dex */
public class a {
    private int ixl = -1;
    private long ixm = -1;
    private int ixi = b.bik().getInt("nani_key_download_show_position", 3);
    private Set<Integer> ixj = new HashSet();
    private Set<String> ixk = new HashSet();

    public void bc(int i, String str) {
        this.ixk.add(str);
        if (this.ixl < 0 && this.ixi == this.ixk.size()) {
            this.ixl = i;
        }
    }

    public int cuz() {
        return this.ixl;
    }

    public void eK(long j) {
        this.ixm = j;
    }

    public void cuA() {
        int i = b.bik().getInt("nani_key_download_show_rate", 2);
        if (this.ixm > 0 && i != 1) {
            b.bik().putLong("key_horizontal_shown_time", this.ixm);
        }
    }
}
