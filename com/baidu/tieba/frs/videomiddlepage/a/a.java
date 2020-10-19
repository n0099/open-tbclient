package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes22.dex */
public class a {
    private int iTx = -1;
    private long iTy = -1;
    private int iTu = b.blO().getInt("nani_key_download_show_position", 3);
    private Set<Integer> iTv = new HashSet();
    private Set<String> iTw = new HashSet();

    public void bq(int i, String str) {
        this.iTw.add(str);
        if (this.iTx < 0 && this.iTu == this.iTw.size()) {
            this.iTx = i;
        }
    }

    public int cBp() {
        return this.iTx;
    }

    public void fo(long j) {
        this.iTy = j;
    }

    public void cBq() {
        int i = b.blO().getInt("nani_key_download_show_rate", 2);
        if (this.iTy > 0 && i != 1) {
            b.blO().putLong("key_horizontal_shown_time", this.iTy);
        }
    }
}
