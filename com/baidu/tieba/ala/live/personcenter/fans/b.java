package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> eYq = null;
    boolean hlg = false;

    public void cbj() {
        this.hlg = false;
        if (this.eYq != null && this.eYq.size() == 0) {
            this.hlg = true;
        }
    }
}
