package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private int fON = -1;
    private long fOO = -1;
    private int fOK = b.agM().getInt("nani_key_download_show_position", 3);
    private Set<Integer> fOL = new HashSet();
    private Set<String> fOM = new HashSet();

    public void al(int i, String str) {
        this.fOM.add(str);
        if (this.fON < 0 && this.fOK == this.fOM.size()) {
            this.fON = i;
        }
    }

    public int brm() {
        return this.fON;
    }

    public void de(long j) {
        this.fOO = j;
    }

    public void brn() {
        int i = b.agM().getInt("nani_key_download_show_rate", 2);
        if (this.fOO > 0 && i != 1) {
            b.agM().putLong("key_horizontal_shown_time", this.fOO);
        }
    }
}
