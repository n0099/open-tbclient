package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    private int icX = -1;
    private long icY = -1;
    private int icU = b.aVP().getInt("nani_key_download_show_position", 3);
    private Set<Integer> icV = new HashSet();
    private Set<String> icW = new HashSet();

    public void bd(int i, String str) {
        this.icW.add(str);
        if (this.icX < 0 && this.icU == this.icW.size()) {
            this.icX = i;
        }
    }

    public int cgu() {
        return this.icX;
    }

    public void el(long j) {
        this.icY = j;
    }

    public void cgv() {
        int i = b.aVP().getInt("nani_key_download_show_rate", 2);
        if (this.icY > 0 && i != 1) {
            b.aVP().putLong("key_horizontal_shown_time", this.icY);
        }
    }
}
