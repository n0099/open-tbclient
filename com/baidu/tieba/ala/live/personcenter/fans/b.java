package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> eVV = null;
    boolean hkP = false;

    public void bYr() {
        this.hkP = false;
        if (this.eVV != null && this.eVV.size() == 0) {
            this.hkP = true;
        }
    }
}
