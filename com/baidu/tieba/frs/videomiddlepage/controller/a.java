package com.baidu.tieba.frs.videomiddlepage.controller;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int eiR = -1;
    private long eiS = -1;
    private int eiO = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> eiP = new HashSet();
    private Set<String> eiQ = new HashSet();

    public void Q(int i, String str) {
        this.eiQ.add(str);
        if (this.eiR < 0 && this.eiO == this.eiQ.size()) {
            this.eiR = i;
        }
    }

    public int aIZ() {
        return this.eiR;
    }

    public void cc(long j) {
        this.eiS = j;
    }

    public void aJa() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.eiS > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.eiS);
        }
    }
}
