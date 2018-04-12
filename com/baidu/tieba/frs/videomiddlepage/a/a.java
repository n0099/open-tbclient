package com.baidu.tieba.frs.videomiddlepage.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int dsl = -1;
    private long dsm = -1;
    private int dsi = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dsj = new HashSet();
    private Set<String> dsk = new HashSet();

    public void S(int i, String str) {
        this.dsk.add(str);
        if (this.dsl < 0 && this.dsi == this.dsk.size()) {
            this.dsl = i;
        }
    }

    public int avH() {
        return this.dsl;
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
        this.dsm = j;
    }

    public void avI() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.dsm > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.dsm);
        }
    }
}
