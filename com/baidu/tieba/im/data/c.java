package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private int ggK;
    private List<b> parent_menu = new ArrayList();
    private long update_time;

    public boolean brY() {
        return this.ggK == 1;
    }

    public void tG(int i) {
        this.ggK = i;
    }

    public long getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public List<b> brZ() {
        return this.parent_menu;
    }

    public void cI(List<b> list) {
        this.parent_menu = list;
    }
}
