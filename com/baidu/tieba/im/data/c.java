package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class c {
    private int hzu;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean bUy() {
        return this.hzu == 1;
    }

    public void wt(int i) {
        this.hzu = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> bUz() {
        return this.parent_menu;
    }

    public void cP(List<b> list) {
        this.parent_menu = list;
    }
}
