package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> eiq = null;
    boolean gkC = false;

    public void bMN() {
        this.gkC = false;
        if (this.eiq != null && this.eiq.size() == 0) {
            this.gkC = true;
        }
    }
}
