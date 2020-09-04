package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> egb = null;
    boolean ght = false;

    public void bLD() {
        this.ght = false;
        if (this.egb != null && this.egb.size() == 0) {
            this.ght = true;
        }
    }
}
