package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private int hse;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean bRt() {
        return this.hse == 1;
    }

    public void wa(int i) {
        this.hse = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> bRu() {
        return this.parent_menu;
    }

    public void cT(List<b> list) {
        this.parent_menu = list;
    }
}
