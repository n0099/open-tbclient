package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> cWf = null;
    boolean eMm = false;

    public void bgP() {
        this.eMm = false;
        if (this.cWf != null && this.cWf.size() == 0) {
            this.eMm = true;
        }
    }
}
