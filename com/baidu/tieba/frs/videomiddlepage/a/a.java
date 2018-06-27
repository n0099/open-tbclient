package com.baidu.tieba.frs.videomiddlepage.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int dFQ = -1;
    private long dFR = -1;
    private int dFN = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dFO = new HashSet();
    private Set<String> dFP = new HashSet();

    public void P(int i, String str) {
        this.dFP.add(str);
        if (this.dFQ < 0 && this.dFN == this.dFP.size()) {
            this.dFQ = i;
        }
    }

    public int aAw() {
        return this.dFQ;
    }

    public boolean gr(boolean z) {
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
                return gs(z);
            case 3:
                return gt(z);
            default:
                return false;
        }
    }

    private boolean gs(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean gt(boolean z) {
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

    public void bF(long j) {
        this.dFR = j;
    }

    public void aAx() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.dFR > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.dFR);
        }
    }
}
