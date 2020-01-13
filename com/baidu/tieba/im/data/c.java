package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private int hvH;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean bSC() {
        return this.hvH == 1;
    }

    public void wf(int i) {
        this.hvH = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> bSD() {
        return this.parent_menu;
    }

    public void cT(List<b> list) {
        this.parent_menu = list;
    }
}
