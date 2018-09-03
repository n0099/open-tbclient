package com.baidu.tieba.frs.videomiddlepage.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int dIB = -1;
    private long dIC = -1;
    private int dIy = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dIz = new HashSet();
    private Set<String> dIA = new HashSet();

    public void R(int i, String str) {
        this.dIA.add(str);
        if (this.dIB < 0 && this.dIy == this.dIA.size()) {
            this.dIB = i;
        }
    }

    public int aBc() {
        return this.dIB;
    }

    public boolean gt(boolean z) {
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
                return gu(z);
            case 3:
                return gv(z);
            default:
                return false;
        }
    }

    private boolean gu(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean gv(boolean z) {
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

    public void bK(long j) {
        this.dIC = j;
    }

    public void aBd() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.dIC > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.dIC);
        }
    }
}
