package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> dJp = null;
    boolean fED = false;

    public void bvW() {
        this.fED = false;
        if (this.dJp != null && this.dJp.size() == 0) {
            this.fED = true;
        }
    }
}
