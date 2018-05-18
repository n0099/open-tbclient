package com.baidu.tieba.frs.videomiddlepage.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int dtq = -1;
    private long dtr = -1;
    private int dtn = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dto = new HashSet();
    private Set<String> dtp = new HashSet();

    public void S(int i, String str) {
        this.dtp.add(str);
        if (this.dtq < 0 && this.dtn == this.dtp.size()) {
            this.dtq = i;
        }
    }

    public int avG() {
        return this.dtq;
    }

    public boolean gc(boolean z) {
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
                return gd(z);
            case 3:
                return ge(z);
            default:
                return false;
        }
    }

    private boolean gd(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean ge(boolean z) {
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
        this.dtr = j;
    }

    public void avH() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.dtr > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.dtr);
        }
    }
}
