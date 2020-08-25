package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> efX = null;
    boolean ghp = false;

    public void bLC() {
        this.ghp = false;
        if (this.efX != null && this.efX.size() == 0) {
            this.ghp = true;
        }
    }
}
