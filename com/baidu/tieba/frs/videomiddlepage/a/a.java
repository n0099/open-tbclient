package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private int fUY = -1;
    private long fUZ = -1;
    private int fUV = b.alP().getInt("nani_key_download_show_position", 3);
    private Set<Integer> fUW = new HashSet();
    private Set<String> fUX = new HashSet();

    public void ak(int i, String str) {
        this.fUX.add(str);
        if (this.fUY < 0 && this.fUV == this.fUX.size()) {
            this.fUY = i;
        }
    }

    public int brt() {
        return this.fUY;
    }

    public void cN(long j) {
        this.fUZ = j;
    }

    public void bru() {
        int i = b.alP().getInt("nani_key_download_show_rate", 2);
        if (this.fUZ > 0 && i != 1) {
            b.alP().putLong("key_horizontal_shown_time", this.fUZ);
        }
    }
}
