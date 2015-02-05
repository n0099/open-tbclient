package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private long aXU;
    private int aXV;
    private List<d> parent_menu = new ArrayList();

    public boolean ME() {
        return this.aXV == 1;
    }

    public void fH(int i) {
        this.aXV = i;
    }

    public long MF() {
        return this.aXU;
    }

    public void T(long j) {
        this.aXU = j;
    }

    public List<d> MG() {
        return this.parent_menu;
    }

    public void ao(List<d> list) {
        this.parent_menu = list;
    }
}
