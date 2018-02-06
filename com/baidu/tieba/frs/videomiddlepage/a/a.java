package com.baidu.tieba.frs.videomiddlepage.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int dXn = -1;
    private long dXo = -1;
    private int dXk = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dXl = new HashSet();
    private Set<String> dXm = new HashSet();

    public void J(int i, String str) {
        this.dXm.add(str);
        if (this.dXn < 0 && this.dXk == this.dXm.size()) {
            this.dXn = i;
        }
    }

    public int aAK() {
        return this.dXn;
    }

    public boolean gw(boolean z) {
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
                return gx(z);
            case 3:
                return gy(z);
            default:
                return false;
        }
    }

    private boolean gx(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean gy(boolean z) {
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

    public void bH(long j) {
        this.dXo = j;
    }

    public void aAL() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.dXo > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.dXo);
        }
    }
}
