package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> bbZ = null;
    boolean dRI = false;

    public void aMz() {
        this.dRI = false;
        if (this.bbZ != null && this.bbZ.size() == 0) {
            this.dRI = true;
        }
    }
}
