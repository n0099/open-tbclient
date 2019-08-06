package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private int fUD = -1;
    private long fUE = -1;
    private int fUA = b.ahQ().getInt("nani_key_download_show_position", 3);
    private Set<Integer> fUB = new HashSet();
    private Set<String> fUC = new HashSet();

    public void al(int i, String str) {
        this.fUC.add(str);
        if (this.fUD < 0 && this.fUA == this.fUC.size()) {
            this.fUD = i;
        }
    }

    public int btF() {
        return this.fUD;
    }

    public void dl(long j) {
        this.fUE = j;
    }

    public void btG() {
        int i = b.ahQ().getInt("nani_key_download_show_rate", 2);
        if (this.fUE > 0 && i != 1) {
            b.ahQ().putLong("key_horizontal_shown_time", this.fUE);
        }
    }
}
