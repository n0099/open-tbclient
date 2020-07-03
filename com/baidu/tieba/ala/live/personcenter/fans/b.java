package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> dQf = null;
    boolean fPX = false;

    public void byT() {
        this.fPX = false;
        if (this.dQf != null && this.dQf.size() == 0) {
            this.fPX = true;
        }
    }
}
