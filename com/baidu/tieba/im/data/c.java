package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class c {
    private int kcF;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean cQu() {
        return this.kcF == 1;
    }

    public void Dj(int i) {
        this.kcF = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> cQv() {
        return this.parent_menu;
    }

    public void ec(List<b> list) {
        this.parent_menu = list;
    }
}
