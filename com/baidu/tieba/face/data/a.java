package com.baidu.tieba.face.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int cpG;
    private int cuA;
    private List<EmotionImageData> dbj;

    public int getPage() {
        return this.cuA;
    }

    public void setPage(int i) {
        this.cuA = i;
    }

    public int aro() {
        return this.cpG;
    }

    public void setHasMore(int i) {
        this.cpG = i;
    }

    public List<EmotionImageData> arp() {
        return this.dbj;
    }

    public void aY(List<EmotionImageData> list) {
        this.dbj = list;
    }
}
