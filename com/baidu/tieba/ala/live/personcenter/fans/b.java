package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> euy = null;
    boolean gyV = false;

    public void bQe() {
        this.gyV = false;
        if (this.euy != null && this.euy.size() == 0) {
            this.gyV = true;
        }
    }
}
