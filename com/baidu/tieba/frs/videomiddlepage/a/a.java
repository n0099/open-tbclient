package com.baidu.tieba.frs.videomiddlepage.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int dIF = -1;
    private long dIG = -1;
    private int dIC = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dID = new HashSet();
    private Set<String> dIE = new HashSet();

    public void R(int i, String str) {
        this.dIE.add(str);
        if (this.dIF < 0 && this.dIC == this.dIE.size()) {
            this.dIF = i;
        }
    }

    public int aBf() {
        return this.dIF;
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
        this.dIG = j;
    }

    public void aBg() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.dIG > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.dIG);
        }
    }
}
