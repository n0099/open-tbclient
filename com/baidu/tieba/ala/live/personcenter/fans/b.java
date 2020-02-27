package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> cVQ = null;
    boolean eLC = false;

    public void bgH() {
        this.eLC = false;
        if (this.cVQ != null && this.cVQ.size() == 0) {
            this.eLC = true;
        }
    }
}
