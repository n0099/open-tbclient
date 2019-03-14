package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int ggW;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean bsb() {
        return this.ggW == 1;
    }

    public void tK(int i) {
        this.ggW = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> bsc() {
        return this.parent_menu;
    }

    public void cL(List<b> list) {
        this.parent_menu = list;
    }
}
