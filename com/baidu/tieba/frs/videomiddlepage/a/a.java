package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    private int gOL = -1;
    private long gOM = -1;
    private int gOI = b.aFB().getInt("nani_key_download_show_position", 3);
    private Set<Integer> gOJ = new HashSet();
    private Set<String> gOK = new HashSet();

    public void aF(int i, String str) {
        this.gOK.add(str);
        if (this.gOL < 0 && this.gOI == this.gOK.size()) {
            this.gOL = i;
        }
    }

    public int bLz() {
        return this.gOL;
    }

    public void dy(long j) {
        this.gOM = j;
    }

    public void bLA() {
        int i = b.aFB().getInt("nani_key_download_show_rate", 2);
        if (this.gOM > 0 && i != 1) {
            b.aFB().putLong("key_horizontal_shown_time", this.gOM);
        }
    }
}
