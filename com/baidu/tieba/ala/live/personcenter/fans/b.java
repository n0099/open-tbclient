package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> eHj = null;
    boolean gQc = false;

    public void bUT() {
        this.gQc = false;
        if (this.eHj != null && this.eHj.size() == 0) {
            this.gQc = true;
        }
    }
}
