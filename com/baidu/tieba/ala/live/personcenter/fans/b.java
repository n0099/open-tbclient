package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> dvu = null;
    boolean fqJ = false;

    public void bqe() {
        this.fqJ = false;
        if (this.dvu != null && this.dvu.size() == 0) {
            this.fqJ = true;
        }
    }
}
