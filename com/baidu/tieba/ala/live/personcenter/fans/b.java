package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> eTF = null;
    boolean hgz = false;

    public void bXr() {
        this.hgz = false;
        if (this.eTF != null && this.eTF.size() == 0) {
            this.hgz = true;
        }
    }
}
