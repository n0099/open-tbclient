package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes21.dex */
public class a {
    private int iEH = -1;
    private long iEI = -1;
    private int iEE = b.bjf().getInt("nani_key_download_show_position", 3);
    private Set<Integer> iEF = new HashSet();
    private Set<String> iEG = new HashSet();

    public void bg(int i, String str) {
        this.iEG.add(str);
        if (this.iEH < 0 && this.iEE == this.iEG.size()) {
            this.iEH = i;
        }
    }

    public int cxS() {
        return this.iEH;
    }

    public void eX(long j) {
        this.iEI = j;
    }

    public void cxT() {
        int i = b.bjf().getInt("nani_key_download_show_rate", 2);
        if (this.iEI > 0 && i != 1) {
            b.bjf().putLong("key_horizontal_shown_time", this.iEI);
        }
    }
}
