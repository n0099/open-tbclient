package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> cVS = null;
    boolean eLQ = false;

    public void bgK() {
        this.eLQ = false;
        if (this.cVS != null && this.cVS.size() == 0) {
            this.eLQ = true;
        }
    }
}
