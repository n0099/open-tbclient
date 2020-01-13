package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> cRO = null;
    boolean eHI = false;

    public void bex() {
        this.eHI = false;
        if (this.cRO != null && this.cRO.size() == 0) {
            this.eHI = true;
        }
    }
}
