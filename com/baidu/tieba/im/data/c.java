package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class c {
    private int jlY;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cDR() {
        return this.jlY == 1;
    }

    public void AY(int i) {
        this.jlY = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cDS() {
        return this.parent_menu;
    }

    public void dA(List<b> list) {
        this.parent_menu = list;
    }
}
