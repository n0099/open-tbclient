package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    private int hOY = -1;
    private long hOZ = -1;
    private int hOV = b.aTX().getInt("nani_key_download_show_position", 3);
    private Set<Integer> hOW = new HashSet();
    private Set<String> hOX = new HashSet();

    public void aZ(int i, String str) {
        this.hOX.add(str);
        if (this.hOY < 0 && this.hOV == this.hOX.size()) {
            this.hOY = i;
        }
    }

    public int ccT() {
        return this.hOY;
    }

    public void ei(long j) {
        this.hOZ = j;
    }

    public void ccU() {
        int i = b.aTX().getInt("nani_key_download_show_rate", 2);
        if (this.hOZ > 0 && i != 1) {
            b.aTX().putLong("key_horizontal_shown_time", this.hOZ);
        }
    }
}
