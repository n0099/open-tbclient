package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private int fVP = -1;
    private long fVQ = -1;
    private int fVM = b.alR().getInt("nani_key_download_show_position", 3);
    private Set<Integer> fVN = new HashSet();
    private Set<String> fVO = new HashSet();

    public void al(int i, String str) {
        this.fVO.add(str);
        if (this.fVP < 0 && this.fVM == this.fVO.size()) {
            this.fVP = i;
        }
    }

    public int brv() {
        return this.fVP;
    }

    public void cO(long j) {
        this.fVQ = j;
    }

    public void brw() {
        int i = b.alR().getInt("nani_key_download_show_rate", 2);
        if (this.fVQ > 0 && i != 1) {
            b.alR().putLong("key_horizontal_shown_time", this.fVQ);
        }
    }
}
