package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private int fWu = -1;
    private long fWv = -1;
    private int fWr = b.ahU().getInt("nani_key_download_show_position", 3);
    private Set<Integer> fWs = new HashSet();
    private Set<String> fWt = new HashSet();

    public void al(int i, String str) {
        this.fWt.add(str);
        if (this.fWu < 0 && this.fWr == this.fWt.size()) {
            this.fWu = i;
        }
    }

    public int but() {
        return this.fWu;
    }

    /* renamed from: do  reason: not valid java name */
    public void m21do(long j) {
        this.fWv = j;
    }

    public void buu() {
        int i = b.ahU().getInt("nani_key_download_show_rate", 2);
        if (this.fWv > 0 && i != 1) {
            b.ahU().putLong("key_horizontal_shown_time", this.fWv);
        }
    }
}
