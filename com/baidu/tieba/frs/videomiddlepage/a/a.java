package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private int fyf = -1;
    private long fyg = -1;
    private int fyc = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> fyd = new HashSet();
    private Set<String> fye = new HashSet();

    public void ag(int i, String str) {
        this.fye.add(str);
        if (this.fyf < 0 && this.fyc == this.fye.size()) {
            this.fyf = i;
        }
    }

    public int bjW() {
        return this.fyf;
    }

    public void cH(long j) {
        this.fyg = j;
    }

    public void bjX() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.fyg > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.fyg);
        }
    }
}
