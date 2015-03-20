package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private long bcc;
    private int bcd;
    private List<d> parent_menu = new ArrayList();

    public boolean PD() {
        return this.bcd == 1;
    }

    public void fI(int i) {
        this.bcd = i;
    }

    public long PE() {
        return this.bcc;
    }

    public void X(long j) {
        this.bcc = j;
    }

    public List<d> PF() {
        return this.parent_menu;
    }

    public void ay(List<d> list) {
        this.parent_menu = list;
    }
}
