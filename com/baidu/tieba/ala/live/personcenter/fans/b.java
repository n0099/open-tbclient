package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> dvq = null;
    boolean fqE = false;

    public void bqg() {
        this.fqE = false;
        if (this.dvq != null && this.dvq.size() == 0) {
            this.fqE = true;
        }
    }
}
