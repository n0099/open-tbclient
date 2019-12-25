package com.baidu.tieba.frs.videomiddlepage.a;

import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class a {
    private int gJy = -1;
    private long gJz = -1;
    private int gJv = b.aCY().getInt("nani_key_download_show_position", 3);
    private Set<Integer> gJw = new HashSet();
    private Set<String> gJx = new HashSet();

    public void az(int i, String str) {
        this.gJx.add(str);
        if (this.gJy < 0 && this.gJv == this.gJx.size()) {
            this.gJy = i;
        }
    }

    public int bIV() {
        return this.gJy;
    }

    public void dt(long j) {
        this.gJz = j;
    }

    public void bIW() {
        int i = b.aCY().getInt("nani_key_download_show_rate", 2);
        if (this.gJz > 0 && i != 1) {
            b.aCY().putLong("key_horizontal_shown_time", this.gJz);
        }
    }
}
