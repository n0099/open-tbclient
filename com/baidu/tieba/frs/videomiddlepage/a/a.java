package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    private int gOZ = -1;
    private long gPa = -1;
    private int gOW = b.aFD().getInt("nani_key_download_show_position", 3);
    private Set<Integer> gOX = new HashSet();
    private Set<String> gOY = new HashSet();

    public void aF(int i, String str) {
        this.gOY.add(str);
        if (this.gOZ < 0 && this.gOW == this.gOY.size()) {
            this.gOZ = i;
        }
    }

    public int bLC() {
        return this.gOZ;
    }

    public void dy(long j) {
        this.gPa = j;
    }

    public void bLD() {
        int i = b.aFD().getInt("nani_key_download_show_rate", 2);
        if (this.gPa > 0 && i != 1) {
            b.aFD().putLong("key_horizontal_shown_time", this.gPa);
        }
    }
}
