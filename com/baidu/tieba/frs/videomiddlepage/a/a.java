package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private int fTN = -1;
    private long fTO = -1;
    private int fTK = b.ahO().getInt("nani_key_download_show_position", 3);
    private Set<Integer> fTL = new HashSet();
    private Set<String> fTM = new HashSet();

    public void al(int i, String str) {
        this.fTM.add(str);
        if (this.fTN < 0 && this.fTK == this.fTM.size()) {
            this.fTN = i;
        }
    }

    public int bts() {
        return this.fTN;
    }

    public void dl(long j) {
        this.fTO = j;
    }

    public void btt() {
        int i = b.ahO().getInt("nani_key_download_show_rate", 2);
        if (this.fTO > 0 && i != 1) {
            b.ahO().putLong("key_horizontal_shown_time", this.fTO);
        }
    }
}
