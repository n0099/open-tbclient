package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    private int hAf = -1;
    private long hAg = -1;
    private int hAc = b.aNV().getInt("nani_key_download_show_position", 3);
    private Set<Integer> hAd = new HashSet();
    private Set<String> hAe = new HashSet();

    public void aU(int i, String str) {
        this.hAe.add(str);
        if (this.hAf < 0 && this.hAc == this.hAe.size()) {
            this.hAf = i;
        }
    }

    public int bWw() {
        return this.hAf;
    }

    public void eh(long j) {
        this.hAg = j;
    }

    public void bWx() {
        int i = b.aNV().getInt("nani_key_download_show_rate", 2);
        if (this.hAg > 0 && i != 1) {
            b.aNV().putLong("key_horizontal_shown_time", this.hAg);
        }
    }
}
