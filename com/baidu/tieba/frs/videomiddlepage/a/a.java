package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class a {
    private int gML = -1;
    private long gMM = -1;
    private int gMI = b.aDr().getInt("nani_key_download_show_position", 3);
    private Set<Integer> gMJ = new HashSet();
    private Set<String> gMK = new HashSet();

    public void aF(int i, String str) {
        this.gMK.add(str);
        if (this.gML < 0 && this.gMI == this.gMK.size()) {
            this.gML = i;
        }
    }

    public int bJX() {
        return this.gML;
    }

    public void dy(long j) {
        this.gMM = j;
    }

    public void bJY() {
        int i = b.aDr().getInt("nani_key_download_show_rate", 2);
        if (this.gMM > 0 && i != 1) {
            b.aDr().putLong("key_horizontal_shown_time", this.gMM);
        }
    }
}
