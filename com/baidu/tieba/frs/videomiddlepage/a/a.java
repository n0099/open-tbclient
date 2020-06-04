package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    private int hPL = -1;
    private long hPM = -1;
    private int hPI = b.aTX().getInt("nani_key_download_show_position", 3);
    private Set<Integer> hPJ = new HashSet();
    private Set<String> hPK = new HashSet();

    public void aZ(int i, String str) {
        this.hPK.add(str);
        if (this.hPL < 0 && this.hPI == this.hPK.size()) {
            this.hPL = i;
        }
    }

    public int cdb() {
        return this.hPL;
    }

    public void ei(long j) {
        this.hPM = j;
    }

    public void cdc() {
        int i = b.aTX().getInt("nani_key_download_show_rate", 2);
        if (this.hPM > 0 && i != 1) {
            b.aTX().putLong("key_horizontal_shown_time", this.hPM);
        }
    }
}
