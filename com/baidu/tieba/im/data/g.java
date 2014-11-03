package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private long aVj;
    private int aVk;
    private List<f> parent_menu = new ArrayList();

    public boolean Mu() {
        return this.aVk == 1;
    }

    public void fz(int i) {
        this.aVk = i;
    }

    public long Mv() {
        return this.aVj;
    }

    public void M(long j) {
        this.aVj = j;
    }

    public List<f> Mw() {
        return this.parent_menu;
    }

    public void R(List<f> list) {
        this.parent_menu = list;
    }
}
