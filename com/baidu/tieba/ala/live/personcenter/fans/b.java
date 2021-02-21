package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> eVV = null;
    boolean hld = false;

    public void bYy() {
        this.hld = false;
        if (this.eVV != null && this.eVV.size() == 0) {
            this.hld = true;
        }
    }
}
