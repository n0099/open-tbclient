package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private long bcs;
    private int bct;
    private List<d> parent_menu = new ArrayList();

    public boolean PQ() {
        return this.bct == 1;
    }

    public void fK(int i) {
        this.bct = i;
    }

    public long PR() {
        return this.bcs;
    }

    public void X(long j) {
        this.bcs = j;
    }

    public List<d> PS() {
        return this.parent_menu;
    }

    public void aA(List<d> list) {
        this.parent_menu = list;
    }
}
