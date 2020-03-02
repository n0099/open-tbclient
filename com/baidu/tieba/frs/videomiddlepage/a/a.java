package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    private int gON = -1;
    private long gOO = -1;
    private int gOK = b.aFD().getInt("nani_key_download_show_position", 3);
    private Set<Integer> gOL = new HashSet();
    private Set<String> gOM = new HashSet();

    public void aF(int i, String str) {
        this.gOM.add(str);
        if (this.gON < 0 && this.gOK == this.gOM.size()) {
            this.gON = i;
        }
    }

    public int bLB() {
        return this.gON;
    }

    public void dy(long j) {
        this.gOO = j;
    }

    public void bLC() {
        int i = b.aFD().getInt("nani_key_download_show_rate", 2);
        if (this.gOO > 0 && i != 1) {
            b.aFD().putLong("key_horizontal_shown_time", this.gOO);
        }
    }
}
