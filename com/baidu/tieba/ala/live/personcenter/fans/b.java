package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> eIM = null;
    boolean gQv = false;

    public void bVA() {
        this.gQv = false;
        if (this.eIM != null && this.eIM.size() == 0) {
            this.gQv = true;
        }
    }
}
