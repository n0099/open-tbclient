package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> dWx = null;
    boolean fVq = false;

    public void bCi() {
        this.fVq = false;
        if (this.dWx != null && this.dWx.size() == 0) {
            this.fVq = true;
        }
    }
}
