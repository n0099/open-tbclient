package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int eQT;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean aRw() {
        return this.eQT == 1;
    }

    public void qa(int i) {
        this.eQT = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> aRx() {
        return this.parent_menu;
    }

    public void cz(List<b> list) {
        this.parent_menu = list;
    }
}
