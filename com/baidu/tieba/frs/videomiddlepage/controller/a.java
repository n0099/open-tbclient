package com.baidu.tieba.frs.videomiddlepage.controller;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private int eil = -1;
    private long eim = -1;
    private int eii = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> eij = new HashSet();
    private Set<String> eik = new HashSet();

    public void O(int i, String str) {
        this.eik.add(str);
        if (this.eil < 0 && this.eii == this.eik.size()) {
            this.eil = i;
        }
    }

    public int aIB() {
        return this.eil;
    }

    public boolean hy(boolean z) {
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
                return hz(z);
            case 3:
                return hA(z);
            default:
                return false;
        }
    }

    private boolean hz(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean hA(boolean z) {
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

    public void cc(long j) {
        this.eim = j;
    }

    public void aIC() {
        int i = b.getInstance().getInt("nani_key_download_show_rate", 2);
        if (this.eim > 0 && i != 1) {
            b.getInstance().putLong("key_horizontal_shown_time", this.eim);
        }
    }
}
