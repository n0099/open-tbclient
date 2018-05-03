package com.baidu.tieba.frs.videomiddlepage.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int dsi = -1;
    private long dsj = -1;
    private int dsf = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dsg = new HashSet();
    private Set<String> dsh = new HashSet();

    public void S(int i, String str) {
        this.dsh.add(str);
        if (this.dsi < 0 && this.dsf == this.dsh.size()) {
            this.dsi = i;
        }
    }

    public int avH() {
        return this.dsi;
    }

    public boolean gb(boolean z) {
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
                return gc(z);
            case 3:
                return gd(z);
            default:
                return false;
        }
    }

    private boolean gc(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean gd(boolean z) {
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
        this.dsj = j;
    }

    public void avI() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.dsj > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.dsj);
        }
    }
}
