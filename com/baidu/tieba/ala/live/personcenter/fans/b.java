package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> eOt = null;
    boolean gZp = false;

    public void bYC() {
        this.gZp = false;
        if (this.eOt != null && this.eOt.size() == 0) {
            this.gZp = true;
        }
    }
}
