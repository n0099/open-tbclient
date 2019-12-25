package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> cRE = null;
    boolean eGy = false;

    public void bec() {
        this.eGy = false;
        if (this.cRE != null && this.cRE.size() == 0) {
            this.eGy = true;
        }
    }
}
