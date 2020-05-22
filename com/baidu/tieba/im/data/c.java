package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class c {
    private int ixW;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean clv() {
        return this.ixW == 1;
    }

    public void xx(int i) {
        this.ixW = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> clw() {
        return this.parent_menu;
    }

    public void cY(List<b> list) {
        this.parent_menu = list;
    }
}
