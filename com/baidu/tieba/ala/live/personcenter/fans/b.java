package com.baidu.tieba.ala.live.personcenter.fans;

import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<a> cVR = null;
    boolean eLD = false;

    public void bgJ() {
        this.eLD = false;
        if (this.cVR != null && this.cVR.size() == 0) {
            this.eLD = true;
        }
    }
}
