package com.baidu.tieba.frs.videomiddlepage.controller;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int eiS = -1;
    private long eiT = -1;
    private int eiP = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> eiQ = new HashSet();
    private Set<String> eiR = new HashSet();

    public void Q(int i, String str) {
        this.eiR.add(str);
        if (this.eiS < 0 && this.eiP == this.eiR.size()) {
            this.eiS = i;
        }
    }

    public int aIZ() {
        return this.eiS;
    }

    public void cc(long j) {
        this.eiT = j;
    }

    public void aJa() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.eiT > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.eiT);
        }
    }
}
