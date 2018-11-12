package com.baidu.tieba.frs.videomiddlepage.controller;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int dYR = -1;
    private long dYS = -1;
    private int dYO = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dYP = new HashSet();
    private Set<String> dYQ = new HashSet();

    public void N(int i, String str) {
        this.dYQ.add(str);
        if (this.dYR < 0 && this.dYO == this.dYQ.size()) {
            this.dYR = i;
        }
    }

    public int aGa() {
        return this.dYR;
    }

    public boolean ht(boolean z) {
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
                return hu(z);
            case 3:
                return hv(z);
            default:
                return false;
        }
    }

    private boolean hu(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean hv(boolean z) {
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

    public void bQ(long j) {
        this.dYS = j;
    }

    public void aGb() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.dYS > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.dYS);
        }
    }
}
