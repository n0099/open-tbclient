package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> eCX = null;
    boolean gKJ = false;

    public void bTb() {
        this.gKJ = false;
        if (this.eCX != null && this.eCX.size() == 0) {
            this.gKJ = true;
        }
    }
}
