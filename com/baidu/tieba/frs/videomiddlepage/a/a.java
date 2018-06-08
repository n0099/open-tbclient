package com.baidu.tieba.frs.videomiddlepage.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int dCD = -1;
    private long dCE = -1;
    private int dCA = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dCB = new HashSet();
    private Set<String> dCC = new HashSet();

    public void S(int i, String str) {
        this.dCC.add(str);
        if (this.dCD < 0 && this.dCA == this.dCC.size()) {
            this.dCD = i;
        }
    }

    public int azP() {
        return this.dCD;
    }

    public boolean gh(boolean z) {
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
                return gi(z);
            case 3:
                return gj(z);
            default:
                return false;
        }
    }

    private boolean gi(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean gj(boolean z) {
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

    public void bJ(long j) {
        this.dCE = j;
    }

    public void azQ() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.dCE > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.dCE);
        }
    }
}
