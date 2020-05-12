package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    private int hAl = -1;
    private long hAm = -1;
    private int hAi = b.aNT().getInt("nani_key_download_show_position", 3);
    private Set<Integer> hAj = new HashSet();
    private Set<String> hAk = new HashSet();

    public void aU(int i, String str) {
        this.hAk.add(str);
        if (this.hAl < 0 && this.hAi == this.hAk.size()) {
            this.hAl = i;
        }
    }

    public int bWv() {
        return this.hAl;
    }

    public void eh(long j) {
        this.hAm = j;
    }

    public void bWw() {
        int i = b.aNT().getInt("nani_key_download_show_rate", 2);
        if (this.hAm > 0 && i != 1) {
            b.aNT().putLong("key_horizontal_shown_time", this.hAm);
        }
    }
}
