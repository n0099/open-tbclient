package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private int fxT = -1;
    private long fxU = -1;
    private int fxQ = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> fxR = new HashSet();
    private Set<String> fxS = new HashSet();

    public void ai(int i, String str) {
        this.fxS.add(str);
        if (this.fxT < 0 && this.fxQ == this.fxS.size()) {
            this.fxT = i;
        }
    }

    public int bjU() {
        return this.fxT;
    }

    public void cH(long j) {
        this.fxU = j;
    }

    public void bjV() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.fxU > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.fxU);
        }
    }
}
