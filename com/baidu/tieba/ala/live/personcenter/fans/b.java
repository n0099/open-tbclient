package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> bbH = null;
    boolean dQR = false;

    public void aMx() {
        this.dQR = false;
        if (this.bbH != null && this.bbH.size() == 0) {
            this.dQR = true;
        }
    }
}
