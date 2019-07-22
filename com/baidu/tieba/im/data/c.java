package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int gEk;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean bCt() {
        return this.gEk == 1;
    }

    public void vo(int i) {
        this.gEk = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> bCu() {
        return this.parent_menu;
    }

    public void cS(List<b> list) {
        this.parent_menu = list;
    }
}
