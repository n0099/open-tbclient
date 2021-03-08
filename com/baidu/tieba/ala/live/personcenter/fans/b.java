package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> eXu = null;
    boolean hmM = false;

    public void bYE() {
        this.hmM = false;
        if (this.eXu != null && this.eXu.size() == 0) {
            this.hmM = true;
        }
    }
}
