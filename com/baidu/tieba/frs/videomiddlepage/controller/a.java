package com.baidu.tieba.frs.videomiddlepage.controller;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int dPH = -1;
    private long dPI = -1;
    private int dPE = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dPF = new HashSet();
    private Set<String> dPG = new HashSet();

    public void R(int i, String str) {
        this.dPG.add(str);
        if (this.dPH < 0 && this.dPE == this.dPG.size()) {
            this.dPH = i;
        }
    }

    public int aDk() {
        return this.dPH;
    }

    public boolean gR(boolean z) {
        boolean z2 = b.getInstance().getBoolean("nani_key_is_show_download_nani_panel", true);
        boolean z3 = b.getInstance().getBoolean("nani_key_is_activate_app", false);
        String string = b.getInstance().getString("nani_key_download_link_url", null);
        if (!z2 || z3 || TextUtils.isEmpty(string)) {
            return false;
        }
        switch (b.getInstance().getInt("nani_key_download_show_rate", 2)) {
            case 1:
                return true;
            case 2:
                return gS(z);
            case 3:
                return gT(z);
            default:
                return false;
        }
    }

    private boolean gS(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean gT(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        if (j <= 0) {
            return true;
        }
        return false;
    }

    public void bO(long j) {
        this.dPI = j;
    }

    public void aDl() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.dPI > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.dPI);
        }
    }
}
